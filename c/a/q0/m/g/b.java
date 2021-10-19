package c.a.q0.m.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f13610a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13611b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13612c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f13613d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.m.a f13614e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13615f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13616g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13617h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13618i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13619j;
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
        this.f13610a = context;
        this.f13611b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f13612c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13611b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13612c.getContent() == null || this.f13612c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f13612c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f13612c.getThread_title())) {
            this.f13616g.setText(this.f13612c.getThread_title());
            this.f13616g.setVisibility(0);
            this.f13613d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f13613d.getLayoutParams()).topMargin = l.g(this.f13610a, R.dimen.tbds20);
            this.f13613d.setMaxLines(8);
        }
        this.f13613d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f13613d.setMinimumHeight(l.g(this.f13610a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f13612c.getThread_type().contains("pic")) {
            this.f13615f.setVisibility(0);
            this.f13615f.setDefaultBgResource(R.color.transparent);
            this.f13615f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13615f.setPlaceHolder(2);
            this.f13615f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f13612c.getThread_title())) {
                this.f13613d.setVisibility(8);
            } else {
                this.f13613d.setMaxLines(2);
                this.f13613d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f13613d.setLayoutStrategy(this.f13614e);
                this.f13613d.setMinimumHeight(l.g(this.f13610a, R.dimen.tbds0));
            }
        }
        this.f13613d.setText(TbRichTextView.parse(this.f13610a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f13612c.getAgree_num()));
        this.f13617h.setText(StringHelper.numFormatOverWanWithNegative(this.f13612c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13617h = (TextView) this.f13611b.findViewById(R.id.comment_num);
            this.f13618i = (TextView) this.f13611b.findViewById(R.id.comment_desc);
            this.f13619j = (TextView) this.f13611b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f13611b.findViewById(R.id.praise_num);
            this.f13616g = (TextView) this.f13611b.findViewById(R.id.thread_title);
            this.f13615f = (TbImageView) this.f13611b.findViewById(R.id.main_img);
            this.f13613d = (TbRichTextView) this.f13611b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13617h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13619j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13618i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13616g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c.a.q0.f1.m.a aVar = new c.a.q0.f1.m.a();
            this.f13614e = aVar;
            aVar.s(l.g(this.f13610a, R.dimen.tbds38));
            this.f13614e.v(l.g(this.f13610a, R.dimen.tbds42));
            this.f13614e.j(l.g(this.f13610a, R.dimen.tbds23));
            this.f13614e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f13614e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f13613d.setLayoutStrategy(this.f13614e);
            this.f13613d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
