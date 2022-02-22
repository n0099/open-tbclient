package c.a.u0.u1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.u0.t1.f.h;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f23055i = "c.a.u0.u1.b.q.a";
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f23056b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23057c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23058d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f23059e;

    /* renamed from: f  reason: collision with root package name */
    public View f23060f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f23061g;

    /* renamed from: h  reason: collision with root package name */
    public int f23062h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1517237930, "Lc/a/u0/u1/b/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1517237930, "Lc/a/u0/u1/b/q/a;");
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
        this.f23062h = 3;
        this.f23061g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f23056b = headImageView;
        headImageView.setIsRound(true);
        this.f23056b.setOnClickListener(onClickListener);
        this.f23056b.setPlaceHolder(1);
        TextView textView = (TextView) this.a.findViewById(R.id.tv_user_name);
        this.f23057c = textView;
        textView.setOnClickListener(onClickListener);
        this.f23058d = (TextView) this.a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.a.findViewById(R.id.tv_content);
        this.f23059e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        c.a.t0.f1.n.a layoutStrategy = this.f23059e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f23059e.setLayoutStrategy(layoutStrategy);
        this.f23059e.setClickable(true);
        this.f23059e.setFocusable(true);
        this.f23060f = this.a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f23062h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f23057c, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f23058d, R.color.CAM_X0109);
        this.f23059e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f23059e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f23060f, R.color.CAM_X0204);
        this.f23062h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        TbRichTextView tbRichTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.f23056b.setUserId(chatMessage.getUserInfo().getUserId());
        this.f23056b.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.f23058d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        if (this.f23061g == null || (tbRichTextView = this.f23059e) == null) {
            return;
        }
        h.e(tbRichTextView, chatMessage, f23055i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.f23059e.setContentDescription(stringBuffer.toString());
        this.f23059e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
