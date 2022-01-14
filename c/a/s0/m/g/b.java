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
    public final View f12907b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f12908c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f12909d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.g1.n.a f12910e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f12911f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12912g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12913h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12914i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f12915j;
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
        this.f12907b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f12908c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12907b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12908c.getContent() == null || this.f12908c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f12908c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f12908c.getThread_title())) {
            this.f12912g.setText(this.f12908c.getThread_title());
            this.f12912g.setVisibility(0);
            this.f12909d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f12909d.getLayoutParams()).topMargin = n.f(this.a, R.dimen.tbds20);
            this.f12909d.setMaxLines(8);
        }
        this.f12909d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f12909d.setMinimumHeight(n.f(this.a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f12908c.getThread_type().contains("pic")) {
            this.f12911f.setVisibility(0);
            this.f12911f.setDefaultBgResource(R.color.transparent);
            this.f12911f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f12911f.setPlaceHolder(2);
            this.f12911f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f12908c.getThread_title())) {
                this.f12909d.setVisibility(8);
            } else {
                this.f12909d.setMaxLines(2);
                this.f12909d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f12909d.setLayoutStrategy(this.f12910e);
                this.f12909d.setMinimumHeight(n.f(this.a, R.dimen.tbds0));
            }
        }
        this.f12909d.setText(TbRichTextView.parse(jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f12908c.getAgree_num()));
        this.f12913h.setText(StringHelper.numFormatOverWanWithNegative(this.f12908c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12913h = (TextView) this.f12907b.findViewById(R.id.comment_num);
            this.f12914i = (TextView) this.f12907b.findViewById(R.id.comment_desc);
            this.f12915j = (TextView) this.f12907b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f12907b.findViewById(R.id.praise_num);
            this.f12912g = (TextView) this.f12907b.findViewById(R.id.thread_title);
            this.f12911f = (TbImageView) this.f12907b.findViewById(R.id.main_img);
            this.f12909d = (TbRichTextView) this.f12907b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12913h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12915j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f12914i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f12912g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c.a.s0.g1.n.a aVar = new c.a.s0.g1.n.a();
            this.f12910e = aVar;
            aVar.s(n.f(this.a, R.dimen.tbds38));
            this.f12910e.v(n.f(this.a, R.dimen.tbds42));
            this.f12910e.j(n.f(this.a, R.dimen.tbds23));
            this.f12910e.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f12910e.i(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f12909d.setLayoutStrategy(this.f12910e);
            this.f12909d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
