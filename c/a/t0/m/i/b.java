package c.a.t0.m.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13318b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13319c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f13320d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.f1.n.a f13321e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13322f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13323g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13324h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13325i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13326j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f13318b = LayoutInflater.from(context).inflate(h.normal_interaction_achievement, (ViewGroup) null);
        this.f13319c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13318b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13319c.getContent() == null || this.f13319c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f13319c.getContent()) {
            if (contentBean2.getType() == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", contentBean2.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } else if (contentBean2.getType() == 3) {
                contentBean = contentBean2;
            }
        }
        if (!TextUtils.isEmpty(this.f13319c.getThread_title())) {
            this.f13323g.setText(this.f13319c.getThread_title());
            this.f13323g.setVisibility(0);
            this.f13320d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f13320d.getLayoutParams()).topMargin = n.f(this.a, e.tbds20);
            this.f13320d.setMaxLines(8);
        }
        this.f13320d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f13320d.setMinimumHeight(n.f(this.a, e.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f13319c.getThread_type().contains("pic")) {
            this.f13322f.setVisibility(0);
            this.f13322f.setDefaultBgResource(d.transparent);
            this.f13322f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13322f.setPlaceHolder(2);
            this.f13322f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f13319c.getThread_title())) {
                this.f13320d.setVisibility(8);
            } else {
                this.f13320d.setMaxLines(2);
                this.f13320d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f13320d.setLayoutStrategy(this.f13321e);
                this.f13320d.setMinimumHeight(n.f(this.a, e.tbds0));
            }
        }
        this.f13320d.setText(TbRichTextView.parse(jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f13319c.getAgree_num()));
        this.f13324h.setText(StringHelper.numFormatOverWanWithNegative(this.f13319c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13324h = (TextView) this.f13318b.findViewById(g.comment_num);
            this.f13325i = (TextView) this.f13318b.findViewById(g.comment_desc);
            this.f13326j = (TextView) this.f13318b.findViewById(g.praise_desc);
            this.k = (TextView) this.f13318b.findViewById(g.praise_num);
            this.f13323g = (TextView) this.f13318b.findViewById(g.thread_title);
            this.f13322f = (TbImageView) this.f13318b.findViewById(g.main_img);
            this.f13320d = (TbRichTextView) this.f13318b.findViewById(g.rich_text);
            this.k.setTextColor(SkinManager.getColor(d.CAM_X0310));
            this.f13324h.setTextColor(SkinManager.getColor(d.CAM_X0310));
            this.f13326j.setTextColor(SkinManager.getColor(d.CAM_X0105));
            this.f13325i.setTextColor(SkinManager.getColor(d.CAM_X0105));
            this.f13323g.setTextColor(SkinManager.getColor(d.CAM_X0105));
            c.a.t0.f1.n.a aVar = new c.a.t0.f1.n.a();
            this.f13321e = aVar;
            aVar.s(n.f(this.a, e.tbds38));
            this.f13321e.v(n.f(this.a, e.tbds42));
            this.f13321e.j(n.f(this.a, e.tbds23));
            this.f13321e.o(n.f(TbadkCoreApplication.getInst().getContext(), e.tbds12), 1.0f);
            this.f13321e.i(n.f(TbadkCoreApplication.getInst().getContext(), e.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), e.tbds48));
            this.f13320d.setLayoutStrategy(this.f13321e);
            this.f13320d.setTextColor(SkinManager.getColor(d.CAM_X0105));
        }
    }
}
