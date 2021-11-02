package b.a.q0.m.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f12746a;

    /* renamed from: b  reason: collision with root package name */
    public final View f12747b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f12748c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f12749d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.f1.n.a f12750e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f12751f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12752g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12753h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12754i;
    public TextView j;
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
        this.f12746a = context;
        this.f12747b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f12748c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12747b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12748c.getContent() == null || this.f12748c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f12748c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f12748c.getThread_title())) {
            this.f12752g.setText(this.f12748c.getThread_title());
            this.f12752g.setVisibility(0);
            this.f12749d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f12749d.getLayoutParams()).topMargin = l.g(this.f12746a, R.dimen.tbds20);
            this.f12749d.setMaxLines(8);
        }
        this.f12749d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f12749d.setMinimumHeight(l.g(this.f12746a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f12748c.getThread_type().contains("pic")) {
            this.f12751f.setVisibility(0);
            this.f12751f.setDefaultBgResource(R.color.transparent);
            this.f12751f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f12751f.setPlaceHolder(2);
            this.f12751f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f12748c.getThread_title())) {
                this.f12749d.setVisibility(8);
            } else {
                this.f12749d.setMaxLines(2);
                this.f12749d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f12749d.setLayoutStrategy(this.f12750e);
                this.f12749d.setMinimumHeight(l.g(this.f12746a, R.dimen.tbds0));
            }
        }
        this.f12749d.setText(TbRichTextView.parse(this.f12746a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f12748c.getAgree_num()));
        this.f12753h.setText(StringHelper.numFormatOverWanWithNegative(this.f12748c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12753h = (TextView) this.f12747b.findViewById(R.id.comment_num);
            this.f12754i = (TextView) this.f12747b.findViewById(R.id.comment_desc);
            this.j = (TextView) this.f12747b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f12747b.findViewById(R.id.praise_num);
            this.f12752g = (TextView) this.f12747b.findViewById(R.id.thread_title);
            this.f12751f = (TbImageView) this.f12747b.findViewById(R.id.main_img);
            this.f12749d = (TbRichTextView) this.f12747b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12753h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f12754i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f12752g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            b.a.q0.f1.n.a aVar = new b.a.q0.f1.n.a();
            this.f12750e = aVar;
            aVar.s(l.g(this.f12746a, R.dimen.tbds38));
            this.f12750e.v(l.g(this.f12746a, R.dimen.tbds42));
            this.f12750e.j(l.g(this.f12746a, R.dimen.tbds23));
            this.f12750e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f12750e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f12749d.setLayoutStrategy(this.f12750e);
            this.f12749d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
