package c.a.s0.m.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
    public final View f13051b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13052c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f13053d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.f1.n.a f13054e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13055f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13056g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13057h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13058i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13059j;
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
        this.f13051b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f13052c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13051b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13052c.getContent() == null || this.f13052c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f13052c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f13052c.getThread_title())) {
            this.f13056g.setText(this.f13052c.getThread_title());
            this.f13056g.setVisibility(0);
            this.f13053d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f13053d.getLayoutParams()).topMargin = n.f(this.a, R.dimen.tbds20);
            this.f13053d.setMaxLines(8);
        }
        this.f13053d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f13053d.setMinimumHeight(n.f(this.a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f13052c.getThread_type().contains("pic")) {
            this.f13055f.setVisibility(0);
            this.f13055f.setDefaultBgResource(R.color.transparent);
            this.f13055f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13055f.setPlaceHolder(2);
            this.f13055f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f13052c.getThread_title())) {
                this.f13053d.setVisibility(8);
            } else {
                this.f13053d.setMaxLines(2);
                this.f13053d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f13053d.setLayoutStrategy(this.f13054e);
                this.f13053d.setMinimumHeight(n.f(this.a, R.dimen.tbds0));
            }
        }
        this.f13053d.setText(TbRichTextView.parse(jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f13052c.getAgree_num()));
        this.f13057h.setText(StringHelper.numFormatOverWanWithNegative(this.f13052c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13057h = (TextView) this.f13051b.findViewById(R.id.comment_num);
            this.f13058i = (TextView) this.f13051b.findViewById(R.id.comment_desc);
            this.f13059j = (TextView) this.f13051b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f13051b.findViewById(R.id.praise_num);
            this.f13056g = (TextView) this.f13051b.findViewById(R.id.thread_title);
            this.f13055f = (TbImageView) this.f13051b.findViewById(R.id.main_img);
            this.f13053d = (TbRichTextView) this.f13051b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13057h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13059j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13058i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13056g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c.a.s0.f1.n.a aVar = new c.a.s0.f1.n.a();
            this.f13054e = aVar;
            aVar.s(n.f(this.a, R.dimen.tbds38));
            this.f13054e.v(n.f(this.a, R.dimen.tbds42));
            this.f13054e.j(n.f(this.a, R.dimen.tbds23));
            this.f13054e.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f13054e.i(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f13053d.setLayoutStrategy(this.f13054e);
            this.f13053d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
