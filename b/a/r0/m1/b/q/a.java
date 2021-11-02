package b.a.r0.m1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.r0.l1.f.h;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f21139i = "b.a.r0.m1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f21140a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f21141b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21142c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21143d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f21144e;

    /* renamed from: f  reason: collision with root package name */
    public View f21145f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f21146g;

    /* renamed from: h  reason: collision with root package name */
    public int f21147h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1079709530, "Lb/a/r0/m1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1079709530, "Lb/a/r0/m1/b/q/a;");
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
        this.f21147h = 3;
        this.f21146g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f21140a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f21141b = headImageView;
        headImageView.setIsRound(true);
        this.f21141b.setOnClickListener(onClickListener);
        this.f21141b.setPlaceHolder(1);
        TextView textView = (TextView) this.f21140a.findViewById(R.id.tv_user_name);
        this.f21142c = textView;
        textView.setOnClickListener(onClickListener);
        this.f21143d = (TextView) this.f21140a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f21140a.findViewById(R.id.tv_content);
        this.f21144e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        b.a.q0.f1.n.a layoutStrategy = this.f21144e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f21144e.setLayoutStrategy(layoutStrategy);
        this.f21144e.setClickable(true);
        this.f21144e.setFocusable(true);
        this.f21145f = this.f21140a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21140a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21147h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.f21140a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f21142c, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f21143d, R.color.CAM_X0109);
        this.f21144e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f21144e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f21145f, R.color.CAM_X0204);
        this.f21147h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f21141b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f21141b.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f21143d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        TbPageContext tbPageContext = this.f21146g;
        if (tbPageContext == null || this.f21144e == null) {
            return;
        }
        h.e(tbPageContext.getContext(), this.f21144e, chatMessage, f21139i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f21144e.setContentDescription(stringBuffer.toString());
        this.f21144e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
