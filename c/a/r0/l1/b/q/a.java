package c.a.r0.l1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.r0.k1.f.h;
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
    public static final String f22051i = "c.a.r0.l1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f22052a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f22053b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22054c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22055d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f22056e;

    /* renamed from: f  reason: collision with root package name */
    public View f22057f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f22058g;

    /* renamed from: h  reason: collision with root package name */
    public int f22059h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(217210756, "Lc/a/r0/l1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(217210756, "Lc/a/r0/l1/b/q/a;");
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
        this.f22059h = 3;
        this.f22058g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f22052a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f22053b = headImageView;
        headImageView.setIsRound(true);
        this.f22053b.setOnClickListener(onClickListener);
        this.f22053b.setPlaceHolder(1);
        TextView textView = (TextView) this.f22052a.findViewById(R.id.tv_user_name);
        this.f22054c = textView;
        textView.setOnClickListener(onClickListener);
        this.f22055d = (TextView) this.f22052a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f22052a.findViewById(R.id.tv_content);
        this.f22056e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        c.a.q0.f1.m.a layoutStrategy = this.f22056e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f22056e.setLayoutStrategy(layoutStrategy);
        this.f22056e.setClickable(true);
        this.f22056e.setFocusable(true);
        this.f22057f = this.f22052a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22052a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f22059h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.f22052a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f22054c, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f22055d, R.color.CAM_X0109);
        this.f22056e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f22056e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f22057f, R.color.CAM_X0204);
        this.f22059h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f22053b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f22053b.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f22055d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        TbPageContext tbPageContext = this.f22058g;
        if (tbPageContext == null || this.f22056e == null) {
            return;
        }
        h.e(tbPageContext.getContext(), this.f22056e, chatMessage, f22051i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f22056e.setContentDescription(stringBuffer.toString());
        this.f22056e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
