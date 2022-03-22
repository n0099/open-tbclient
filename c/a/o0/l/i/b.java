package c.a.o0.l.i;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10421b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f10422c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f10423d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.e1.n.a f10424e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f10425f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10426g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10427h;
    public TextView i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f10421b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0623, (ViewGroup) null);
        this.f10422c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10421b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10422c.getContent() == null || this.f10422c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f10422c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f10422c.getThread_title())) {
            this.f10426g.setText(this.f10422c.getThread_title());
            this.f10426g.setVisibility(0);
            this.f10423d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f10423d.getLayoutParams()).topMargin = n.f(this.a, R.dimen.tbds20);
            this.f10423d.setMaxLines(8);
        }
        this.f10423d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f10423d.setMinimumHeight(n.f(this.a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f10422c.getThread_type().contains("pic")) {
            this.f10425f.setVisibility(0);
            this.f10425f.setDefaultBgResource(R.color.transparent);
            this.f10425f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f10425f.setPlaceHolder(2);
            this.f10425f.J(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f10422c.getThread_title())) {
                this.f10423d.setVisibility(8);
            } else {
                this.f10423d.setMaxLines(2);
                this.f10423d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f10423d.setLayoutStrategy(this.f10424e);
                this.f10423d.setMinimumHeight(n.f(this.a, R.dimen.tbds0));
            }
        }
        this.f10423d.setText(TbRichTextView.U(jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f10422c.getAgree_num()));
        this.f10427h.setText(StringHelper.numFormatOverWanWithNegative(this.f10422c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10427h = (TextView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f09068e);
            this.i = (TextView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f090684);
            this.j = (TextView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f0918d4);
            this.k = (TextView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f0918d5);
            this.f10426g = (TextView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f091fcd);
            this.f10425f = (TbImageView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f091374);
            this.f10423d = (TbRichTextView) this.f10421b.findViewById(R.id.obfuscated_res_0x7f091a97);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f10427h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f10426g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c.a.o0.e1.n.a aVar = new c.a.o0.e1.n.a();
            this.f10424e = aVar;
            aVar.s(n.f(this.a, R.dimen.tbds38));
            this.f10424e.v(n.f(this.a, R.dimen.tbds42));
            this.f10424e.j(n.f(this.a, R.dimen.tbds23));
            this.f10424e.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f10424e.i(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f10423d.setLayoutStrategy(this.f10424e);
            this.f10423d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
