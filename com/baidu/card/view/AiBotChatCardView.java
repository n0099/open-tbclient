package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.jw4;
import com.baidu.tieba.uua;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ChatContent;
import tbclient.User;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/card/view/AiBotChatCardView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBg", "Landroid/view/View;", "mCardScheme", "", "mChatBtn", "mChatBtnText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "mContent", "mContentBg", "mImageBg", "Lcom/baidu/tbadk/widget/TbImageView;", "mName", "mPortrait", "Lcom/baidu/tbadk/core/view/HeadImageView;", "mPortraitScheme", "uk", CommonTbJsBridge.CHANGE_SKIN_TYPE, "", "gotoScheme", "scheme", "onClick", "v", "setData", "data", "Lcom/baidu/tbadk/core/data/AiBotChatData;", "stat", "objType", "", "Companion", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AiBotChatCardView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbImageView b;
    public HeadImageView c;
    public EMTextView d;
    public RelativeLayout e;
    public EMTextView f;
    public RelativeLayout g;
    public EMTextView h;
    public String i;
    public String j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(346381864, "Lcom/baidu/card/view/AiBotChatCardView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(346381864, "Lcom/baidu/card/view/AiBotChatCardView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AiBotChatCardView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AiBotChatCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = "";
        this.j = "";
        this.k = "";
        LayoutInflater.from(context).inflate(R.layout.ai_bot_chat_card_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ai_bot_chat_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ai_bot_chat_bg)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.ai_bot_chat_bg_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ai_bot_chat_bg_img)");
        this.b = (TbImageView) findViewById2;
        View findViewById3 = findViewById(R.id.ai_bot_chat_portrait);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ai_bot_chat_portrait)");
        this.c = (HeadImageView) findViewById3;
        View findViewById4 = findViewById(R.id.ai_bot_chat_name);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ai_bot_chat_name)");
        this.d = (EMTextView) findViewById4;
        View findViewById5 = findViewById(R.id.ai_bot_chat_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ai_bot_chat_btn)");
        this.e = (RelativeLayout) findViewById5;
        View findViewById6 = findViewById(R.id.ai_bot_chat_btn_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ai_bot_chat_btn_text)");
        this.f = (EMTextView) findViewById6;
        View findViewById7 = findViewById(R.id.ai_bot_chat_content_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.ai_bot_chat_content_bg)");
        this.g = (RelativeLayout) findViewById7;
        View findViewById8 = findViewById(R.id.ai_bot_chat_content);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.ai_bot_chat_content)");
        this.h = (EMTextView) findViewById8;
        this.a.setOnClickListener(this);
        this.c.setOnClickListener(this);
        a();
        this.b.setDefaultBgResource(R.drawable.ai_bot_chat_bg);
    }

    public /* synthetic */ AiBotChatCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int color = SkinManager.getColor(R.color.CAM_X0216);
            int color2 = SkinManager.getColor(R.color.CAM_X0302);
            EMManager.from(this.a).setCorner(R.string.J_X05).setGradientColorValue(new int[]{uua.a(color, 0.17f), uua.a(color2, 0.15f)}, Direction.LEFT_TOP);
            this.b.setDrawCorner(true);
            this.b.setRadiusById(R.string.J_X05);
            this.b.setConrers(15);
            EMManager.from(this.g).setCorner(R.string.obfuscated_res_0x7f0f0035).setAlpha(R.string.A_X13).setBackGroundColor(R.color.CAM_X0101);
            EMManager.from(this.e).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0619);
            EMManager.from(this.d).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.f).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X1302);
            EMManager.from(this.h).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X1107);
            this.c.setDefaultResource(R.color.transparent);
            this.c.setPlaceHolder(1);
            this.c.setIsRound(true);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c(2, this.k);
            UrlManager.getInstance().dealOneLink(str);
        }
    }

    public final void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            new StatisticItem("c15566").param("obj_type", i).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", str).eventStat();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            boolean z2 = true;
            if (view2 != null && view2.getId() == R.id.ai_bot_chat_bg) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                b(this.j);
                return;
            }
            if ((view2 == null || view2.getId() != R.id.ai_bot_chat_portrait) ? false : false) {
                b(this.i);
            }
        }
    }

    public final void setData(jw4 data) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            User c = data.c();
            if (c != null) {
                String str = c.uk;
                if (str == null) {
                    str = "";
                }
                this.k = str;
                String str2 = c.target_scheme;
                Intrinsics.checkNotNullExpressionValue(str2, "botInfo.target_scheme");
                this.i = str2;
                String str3 = c.portrait;
                Intrinsics.checkNotNullExpressionValue(str3, "botInfo.portrait");
                if (str3.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.c.startLoad(c.portrait, 12, false);
                }
                this.d.setText(c.name);
                ChatContent d = data.d();
                if (d != null) {
                    this.f.setText(StringHelper.cutChineseAndEnglishWithEmoji(d.btn_text, 8, ""));
                }
                this.h.setText(data.e());
                this.j = data.getTargetScheme();
                c(1, this.k);
            }
        }
    }
}
