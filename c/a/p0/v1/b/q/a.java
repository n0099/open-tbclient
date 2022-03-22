package c.a.p0.v1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.p0.u1.f.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String i = "c.a.p0.v1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f19187b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19188c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19189d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f19190e;

    /* renamed from: f  reason: collision with root package name */
    public View f19191f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19192g;

    /* renamed from: h  reason: collision with root package name */
    public int f19193h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-935630128, "Lc/a/p0/v1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-935630128, "Lc/a/p0/v1/b/q/a;");
        }
    }

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19193h = 3;
        this.f19192g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0644, viewGroup, false);
        this.a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090fd6);
        this.f19187b = headImageView;
        headImageView.setIsRound(true);
        this.f19187b.setOnClickListener(onClickListener);
        this.f19187b.setPlaceHolder(1);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092229);
        this.f19188c = textView;
        textView.setOnClickListener(onClickListener);
        this.f19189d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09219c);
        TbRichTextView tbRichTextView = (TbRichTextView) this.a.findViewById(R.id.obfuscated_res_0x7f092198);
        this.f19190e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        c.a.o0.e1.n.a layoutStrategy = this.f19190e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f19190e.setLayoutStrategy(layoutStrategy);
        this.f19190e.setClickable(true);
        this.f19190e.setFocusable(true);
        this.f19191f = this.a.findViewById(R.id.obfuscated_res_0x7f0903ca);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19193h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f19188c, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f19189d, (int) R.color.CAM_X0109);
        this.f19190e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f19190e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f19191f, R.color.CAM_X0204);
        this.f19193h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        TbRichTextView tbRichTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f19187b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f19187b.J(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f19189d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        if (this.f19192g == null || (tbRichTextView = this.f19190e) == null) {
            return;
        }
        h.e(tbRichTextView, chatMessage, i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f19190e.setContentDescription(stringBuffer.toString());
        this.f19190e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
