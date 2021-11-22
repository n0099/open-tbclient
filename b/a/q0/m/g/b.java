package b.a.q0.m.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
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
    public final Context f13496a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13497b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13498c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f13499d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.e1.n.a f13500e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13501f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13502g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13503h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13504i;
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
        this.f13496a = context;
        this.f13497b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f13498c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13497b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13498c.getContent() == null || this.f13498c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f13498c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f13498c.getThread_title())) {
            this.f13502g.setText(this.f13498c.getThread_title());
            this.f13502g.setVisibility(0);
            this.f13499d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f13499d.getLayoutParams()).topMargin = l.g(this.f13496a, R.dimen.tbds20);
            this.f13499d.setMaxLines(8);
        }
        this.f13499d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f13499d.setMinimumHeight(l.g(this.f13496a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f13498c.getThread_type().contains("pic")) {
            this.f13501f.setVisibility(0);
            this.f13501f.setDefaultBgResource(R.color.transparent);
            this.f13501f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13501f.setPlaceHolder(2);
            this.f13501f.startLoad(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f13498c.getThread_title())) {
                this.f13499d.setVisibility(8);
            } else {
                this.f13499d.setMaxLines(2);
                this.f13499d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f13499d.setLayoutStrategy(this.f13500e);
                this.f13499d.setMinimumHeight(l.g(this.f13496a, R.dimen.tbds0));
            }
        }
        this.f13499d.setText(TbRichTextView.parse(this.f13496a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f13498c.getAgree_num()));
        this.f13503h.setText(StringHelper.numFormatOverWanWithNegative(this.f13498c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13503h = (TextView) this.f13497b.findViewById(R.id.comment_num);
            this.f13504i = (TextView) this.f13497b.findViewById(R.id.comment_desc);
            this.j = (TextView) this.f13497b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f13497b.findViewById(R.id.praise_num);
            this.f13502g = (TextView) this.f13497b.findViewById(R.id.thread_title);
            this.f13501f = (TbImageView) this.f13497b.findViewById(R.id.main_img);
            this.f13499d = (TbRichTextView) this.f13497b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13503h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13504i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13502g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            b.a.q0.e1.n.a aVar = new b.a.q0.e1.n.a();
            this.f13500e = aVar;
            aVar.s(l.g(this.f13496a, R.dimen.tbds38));
            this.f13500e.v(l.g(this.f13496a, R.dimen.tbds42));
            this.f13500e.j(l.g(this.f13496a, R.dimen.tbds23));
            this.f13500e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f13500e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f13499d.setLayoutStrategy(this.f13500e);
            this.f13499d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
