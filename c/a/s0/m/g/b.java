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
    public final View f13231b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13232c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f13233d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.g1.n.a f13234e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13235f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13236g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13237h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13238i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13239j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f13240k;

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
        this.f13231b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f13232c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13231b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13232c.getContent() == null || this.f13232c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f13232c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f13232c.getThread_title())) {
            this.f13236g.setText(this.f13232c.getThread_title());
            this.f13236g.setVisibility(0);
            this.f13233d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f13233d.getLayoutParams()).topMargin = n.f(this.a, R.dimen.tbds20);
            this.f13233d.setMaxLines(8);
        }
        this.f13233d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f13233d.setMinimumHeight(n.f(this.a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f13232c.getThread_type().contains("pic")) {
            this.f13235f.setVisibility(0);
            this.f13235f.setDefaultBgResource(R.color.transparent);
            this.f13235f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13235f.setPlaceHolder(2);
            this.f13235f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f13232c.getThread_title())) {
                this.f13233d.setVisibility(8);
            } else {
                this.f13233d.setMaxLines(2);
                this.f13233d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f13233d.setLayoutStrategy(this.f13234e);
                this.f13233d.setMinimumHeight(n.f(this.a, R.dimen.tbds0));
            }
        }
        this.f13233d.setText(TbRichTextView.parse(jSONArray, false));
        this.f13240k.setText(StringHelper.numFormatOverWanWithNegative(this.f13232c.getAgree_num()));
        this.f13237h.setText(StringHelper.numFormatOverWanWithNegative(this.f13232c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13237h = (TextView) this.f13231b.findViewById(R.id.comment_num);
            this.f13238i = (TextView) this.f13231b.findViewById(R.id.comment_desc);
            this.f13239j = (TextView) this.f13231b.findViewById(R.id.praise_desc);
            this.f13240k = (TextView) this.f13231b.findViewById(R.id.praise_num);
            this.f13236g = (TextView) this.f13231b.findViewById(R.id.thread_title);
            this.f13235f = (TbImageView) this.f13231b.findViewById(R.id.main_img);
            this.f13233d = (TbRichTextView) this.f13231b.findViewById(R.id.rich_text);
            this.f13240k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13237h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13239j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13238i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13236g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c.a.s0.g1.n.a aVar = new c.a.s0.g1.n.a();
            this.f13234e = aVar;
            aVar.s(n.f(this.a, R.dimen.tbds38));
            this.f13234e.v(n.f(this.a, R.dimen.tbds42));
            this.f13234e.j(n.f(this.a, R.dimen.tbds23));
            this.f13234e.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f13234e.i(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f13233d.setLayoutStrategy(this.f13234e);
            this.f13233d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
