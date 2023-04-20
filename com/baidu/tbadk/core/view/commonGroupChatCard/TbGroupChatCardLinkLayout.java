package com.baidu.tbadk.core.view.commonGroupChatCard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ix4;
import com.baidu.tieba.r25;
import com.baidu.tieba.tbadkcore.databinding.TbGroupChatLinkCardLayoutBinding;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0003\u001b\u001c\u001dB'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/TbGroupChatLinkCardLayoutBinding;", "cardClickListener", "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout$ITbCardClickListener;", "commodityData", "Lcom/baidu/tbadk/core/data/CommodityData;", "bindData", "", "data", "fillData", "initView", "onClick", "v", "Landroid/view/View;", "onSkinChanged", "setCardClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ClickType", "Companion", "ITbCardClickListener", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TbGroupChatCardLinkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static final int d;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public TbGroupChatLinkCardLayoutBinding b;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ClickType clickType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbGroupChatCardLinkLayout(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbGroupChatCardLinkLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @JvmStatic
    @SuppressLint({"SetTextI18n"})
    public static final void e(TextView textView, View view2, TextView textView2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, textView, view2, textView2, str, str2) == null) {
            c.a(textView, view2, textView2, str, str2);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout$ClickType;", "", "(Ljava/lang/String;I)V", "CLICK_MAIN", "CLICK_CLOSE", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ClickType {
        public static final /* synthetic */ ClickType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ClickType CLICK_CLOSE;
        public static final ClickType CLICK_MAIN;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ ClickType[] $values() {
            return new ClickType[]{CLICK_MAIN, CLICK_CLOSE};
        }

        public static ClickType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ClickType) Enum.valueOf(ClickType.class, str) : (ClickType) invokeL.objValue;
        }

        public static ClickType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ClickType[]) $VALUES.clone() : (ClickType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(899539344, "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout$ClickType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(899539344, "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout$ClickType;");
                    return;
                }
            }
            CLICK_MAIN = new ClickType("CLICK_MAIN", 0);
            CLICK_CLOSE = new ClickType("CLICK_CLOSE", 1);
            $VALUES = $values();
        }

        public ClickType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        @SuppressLint({"SetTextI18n"})
        public final void a(TextView content1, View icon1, TextView content2, String str, String str2) {
            boolean z;
            boolean z2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, content1, icon1, content2, str, str2) == null) {
                Intrinsics.checkNotNullParameter(content1, "content1");
                Intrinsics.checkNotNullParameter(icon1, "icon1");
                Intrinsics.checkNotNullParameter(content2, "content2");
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    String string = content1.getResources().getString(R.string.ellipsis_suffix_bar);
                    Intrinsics.checkNotNullExpressionValue(string, "content1.resources.getSt…ring.ellipsis_suffix_bar)");
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        i = (int) content2.getPaint().measureText(str2);
                    } else {
                        i = 0;
                    }
                    int i2 = (TbGroupChatCardLinkLayout.d - TbGroupChatCardLinkLayout.e) - i;
                    if (i2 < 0) {
                        content1.setVisibility(8);
                        icon1.setVisibility(8);
                        return;
                    }
                    float f = i2;
                    if (content1.getPaint().measureText(str) > f) {
                        int length = str.length() - 1;
                        while (length > 0) {
                            TextPaint paint = content1.getPaint();
                            StringBuilder sb = new StringBuilder();
                            String substring = str.substring(0, length);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            sb.append(substring);
                            sb.append(string);
                            if (paint.measureText(sb.toString()) <= f) {
                                break;
                            }
                            length--;
                        }
                        if (length > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            String substring2 = str.substring(0, length);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            sb2.append(substring2);
                            sb2.append(string);
                            content1.setText(sb2.toString());
                            return;
                        }
                        content1.setVisibility(8);
                        icon1.setVisibility(8);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1354547538, "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1354547538, "Lcom/baidu/tbadk/core/view/commonGroupChatCard/TbGroupChatCardLinkLayout;");
                return;
            }
        }
        c = new a(null);
        d = UtilHelper.getDimenPixelSize(R.dimen.tbds735);
        e = UtilHelper.getDimenPixelSize(R.dimen.tbds52) * 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbGroupChatCardLinkLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        f();
    }

    public /* synthetic */ TbGroupChatCardLinkLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void c(ix4 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            d(data);
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (v.getId() == R.id.close_button) {
                b bVar = this.a;
                if (bVar != null) {
                    bVar.a(ClickType.CLICK_CLOSE);
                    return;
                }
                return;
            }
            b bVar2 = this.a;
            if (bVar2 != null) {
                bVar2.a(ClickType.CLICK_MAIN);
            }
        }
    }

    public final void setCardClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public final void d(ix4 ix4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ix4Var) == null) {
            TbGroupChatLinkCardLayoutBinding tbGroupChatLinkCardLayoutBinding = this.b;
            if (tbGroupChatLinkCardLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tbGroupChatLinkCardLayoutBinding = null;
            }
            tbGroupChatLinkCardLayoutBinding.h.N(ix4Var.e, 10, false);
            tbGroupChatLinkCardLayoutBinding.i.setText(ix4Var.c);
            tbGroupChatLinkCardLayoutBinding.g.setVisibility(8);
            CardLinkInfoData mCardLinkInfoData = ix4Var.p;
            if (mCardLinkInfoData != null) {
                Intrinsics.checkNotNullExpressionValue(mCardLinkInfoData, "mCardLinkInfoData");
                String str = mCardLinkInfoData.content1;
                boolean z2 = true;
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    tbGroupChatLinkCardLayoutBinding.d.setVisibility(8);
                    tbGroupChatLinkCardLayoutBinding.c.setVisibility(8);
                } else {
                    tbGroupChatLinkCardLayoutBinding.d.setVisibility(0);
                    tbGroupChatLinkCardLayoutBinding.c.setVisibility(0);
                    tbGroupChatLinkCardLayoutBinding.g.setVisibility(0);
                    tbGroupChatLinkCardLayoutBinding.d.setText(mCardLinkInfoData.content1);
                }
                String str2 = mCardLinkInfoData.content2;
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                }
                if (z2) {
                    tbGroupChatLinkCardLayoutBinding.f.setVisibility(8);
                    tbGroupChatLinkCardLayoutBinding.e.setVisibility(8);
                } else {
                    tbGroupChatLinkCardLayoutBinding.f.setVisibility(0);
                    tbGroupChatLinkCardLayoutBinding.e.setVisibility(0);
                    tbGroupChatLinkCardLayoutBinding.g.setVisibility(0);
                    tbGroupChatLinkCardLayoutBinding.f.setText(mCardLinkInfoData.content2);
                }
                a aVar = c;
                TextView content1Text = tbGroupChatLinkCardLayoutBinding.d;
                Intrinsics.checkNotNullExpressionValue(content1Text, "content1Text");
                ImageView content1Icon = tbGroupChatLinkCardLayoutBinding.c;
                Intrinsics.checkNotNullExpressionValue(content1Icon, "content1Icon");
                TextView content2Text = tbGroupChatLinkCardLayoutBinding.f;
                Intrinsics.checkNotNullExpressionValue(content2Text, "content2Text");
                aVar.a(content1Text, content1Icon, content2Text, mCardLinkInfoData.content1, mCardLinkInfoData.content2);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbGroupChatLinkCardLayoutBinding c2 = TbGroupChatLinkCardLayoutBinding.c(LayoutInflater.from(getContext()), this, true);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(LayoutInflater.f…              this, true)");
            this.b = c2;
            TbGroupChatLinkCardLayoutBinding tbGroupChatLinkCardLayoutBinding = null;
            if (c2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                c2 = null;
            }
            TbImageView tbImageView = c2.h;
            tbImageView.setDrawCorner(true);
            tbImageView.setDefaultBgResource(R.drawable.icon_pure_group_chat_card_link_default);
            tbImageView.setRadiusById(R.string.J_X04);
            tbImageView.setConrers(15);
            tbImageView.setUseNightOrDarkMask(true);
            setOnClickListener(this);
            TbGroupChatLinkCardLayoutBinding tbGroupChatLinkCardLayoutBinding2 = this.b;
            if (tbGroupChatLinkCardLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tbGroupChatLinkCardLayoutBinding2 = null;
            }
            tbGroupChatLinkCardLayoutBinding2.j.setOnClickListener(this);
            TbGroupChatLinkCardLayoutBinding tbGroupChatLinkCardLayoutBinding3 = this.b;
            if (tbGroupChatLinkCardLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                tbGroupChatLinkCardLayoutBinding = tbGroupChatLinkCardLayoutBinding3;
            }
            tbGroupChatLinkCardLayoutBinding.b.setOnClickListener(this);
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbGroupChatLinkCardLayoutBinding tbGroupChatLinkCardLayoutBinding = this.b;
            if (tbGroupChatLinkCardLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tbGroupChatLinkCardLayoutBinding = null;
            }
            r25 d2 = r25.d(tbGroupChatLinkCardLayoutBinding.j);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            r25 d3 = r25.d(tbGroupChatLinkCardLayoutBinding.i);
            d3.C(R.string.F_X01);
            d3.B(R.dimen.T_X07);
            d3.w(R.color.CAM_X0107);
            r25 d4 = r25.d(tbGroupChatLinkCardLayoutBinding.d);
            d4.C(R.string.F_X01);
            d4.B(R.dimen.T_X09);
            d4.w(R.color.CAM_X0109);
            r25 d5 = r25.d(tbGroupChatLinkCardLayoutBinding.f);
            d5.C(R.string.F_X01);
            d5.B(R.dimen.T_X09);
            d5.w(R.color.CAM_X0109);
            WebPManager.setPureDrawable(tbGroupChatLinkCardLayoutBinding.c, R.drawable.icon_group_chat_bar_icon, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(tbGroupChatLinkCardLayoutBinding.e, R.drawable.icon_group_chat_icon, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(tbGroupChatLinkCardLayoutBinding.b, R.drawable.icon_pure_mount_card_link_right_del, R.color.CAM_X0108, null);
        }
    }
}
