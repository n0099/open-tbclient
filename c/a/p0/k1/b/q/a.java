package c.a.p0.k1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.p0.j1.f.h;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f21127i = "c.a.p0.k1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f21128a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f21129b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21130c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21131d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f21132e;

    /* renamed from: f  reason: collision with root package name */
    public View f21133f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f21134g;

    /* renamed from: h  reason: collision with root package name */
    public int f21135h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1766499781, "Lc/a/p0/k1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1766499781, "Lc/a/p0/k1/b/q/a;");
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
        this.f21135h = 3;
        this.f21134g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f21128a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f21129b = headImageView;
        headImageView.setIsRound(true);
        this.f21129b.setOnClickListener(onClickListener);
        this.f21129b.setPlaceHolder(1);
        TextView textView = (TextView) this.f21128a.findViewById(R.id.tv_user_name);
        this.f21130c = textView;
        textView.setOnClickListener(onClickListener);
        this.f21131d = (TextView) this.f21128a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f21128a.findViewById(R.id.tv_content);
        this.f21132e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        c.a.o0.d1.m.a layoutStrategy = this.f21132e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f21132e.setLayoutStrategy(layoutStrategy);
        this.f21132e.setClickable(true);
        this.f21132e.setFocusable(true);
        this.f21133f = this.f21128a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21128a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21135h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.f21128a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f21130c, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f21131d, R.color.CAM_X0109);
        this.f21132e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f21132e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f21133f, R.color.CAM_X0204);
        this.f21135h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f21129b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f21129b.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f21131d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        TbPageContext tbPageContext = this.f21134g;
        if (tbPageContext == null || this.f21132e == null) {
            return;
        }
        h.e(tbPageContext.getContext(), this.f21132e, chatMessage, f21127i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f21132e.setContentDescription(stringBuffer.toString());
        this.f21132e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
