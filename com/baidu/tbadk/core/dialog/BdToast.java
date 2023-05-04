package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.si;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class BdToast {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<Toast> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public Toast b;
    public final ViewGroup c;
    public final TbImage d;
    public final TextView e;
    public CharSequence f;
    public int g;
    public String h;
    public String i;
    public boolean j;
    public int k;
    public int l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ToastIcon {
        public static final /* synthetic */ ToastIcon[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ToastIcon FAILURE;
        public static final ToastIcon NOT;
        public static final ToastIcon SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;
        public int iconId;
        public boolean isSvg;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1621383372, "Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1621383372, "Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;");
                    return;
                }
            }
            SUCCESS = new ToastIcon("SUCCESS", 0, R.drawable.icon_pure_toast_succeed40_svg, true);
            FAILURE = new ToastIcon("FAILURE", 1, R.drawable.icon_pure_toast_mistake40_svg, true);
            ToastIcon toastIcon = new ToastIcon("NOT", 2, 0, false);
            NOT = toastIcon;
            $VALUES = new ToastIcon[]{SUCCESS, FAILURE, toastIcon};
        }

        public ToastIcon(String str, int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.iconId = i2;
            this.isSvg = z;
        }

        public static ToastIcon valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (ToastIcon) Enum.valueOf(ToastIcon.class, str);
            }
            return (ToastIcon) invokeL.objValue;
        }

        public static ToastIcon[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (ToastIcon[]) $VALUES.clone();
            }
            return (ToastIcon[]) invokeV.objValue;
        }
    }

    public BdToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = -1;
        this.j = false;
        this.k = 0;
        this.a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.c = viewGroup;
        this.d = (TbImage) viewGroup.findViewById(R.id.toast_icon);
        this.e = (TextView) this.c.findViewById(R.id.toast_message);
        GreyUtil.grey(this.c);
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, charSequence)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.l(charSequence);
            return bdToast;
        }
        return (BdToast) invokeLL.objValue;
    }

    public BdToast h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            i(i, i2, UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0702c4));
            return this;
        }
        return (BdToast) invokeII.objValue;
    }

    public final BdToast a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Toast toast = new Toast(this.a);
            this.b = toast;
            si.a(toast);
            p();
            n();
            if (this.l != 0) {
                this.c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ii.g(this.a, R.dimen.tbds32), this.l));
            } else {
                this.c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ii.g(this.a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            }
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
            this.e.setText(this.f);
            this.b.setView(this.c);
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4 && StringUtils.isNotNull(this.i)) {
                this.d.k(this.i);
                this.d.setVisibility(0);
            } else if (StringUtils.isNotNull(this.h)) {
                this.d.k(this.h);
                this.d.setVisibility(0);
            } else {
                int i = this.g;
                if (i != -1) {
                    if (this.j) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, this.g, R.color.CAM_X0101, null);
                    } else {
                        WebPManager.setMaskDrawable(this.d, i, null);
                    }
                    this.d.setVisibility(0);
                    return;
                }
                this.d.setVisibility(8);
            }
        }
    }

    public void c(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.l = i;
        }
    }

    public BdToast d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public void e(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.e.setLineSpacing(0.0f, f);
        }
    }

    public BdToast f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i != 0) {
                this.j = false;
                this.g = i;
            }
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast g(ToastIcon toastIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, toastIcon)) == null) {
            if (toastIcon != null) {
                this.j = toastIcon.isSvg;
                this.g = toastIcon.iconId;
            }
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.h = str;
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.i = str;
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast l(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, charSequence)) == null) {
            this.f = charSequence;
            this.e.setText(charSequence);
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public void m(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (textView = this.e) != null && i > 80) {
            textView.setMinWidth(i);
        }
    }

    public BdToast i(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            TbImage tbImage = this.d;
            if (tbImage != null && i > 0 && i2 > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImage.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(i, i2);
                    layoutParams.topMargin = i3;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.topMargin = i3;
                    layoutParams.width = i;
                    layoutParams.height = i2;
                }
                this.d.setLayoutParams(layoutParams);
            }
            return this;
        }
        return (BdToast) invokeIII.objValue;
    }

    public BdToast o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.b == null) {
                a();
            }
            GreyUtil.grey(this.b);
            this.e.setText(this.f);
            this.b.setGravity(16, 0, 0);
            this.b.setDuration(this.k);
            this.b.show();
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SoftReference<Toast> softReference = m;
            if (softReference != null && softReference.get() != null) {
                m.get().cancel();
            }
            m = new SoftReference<>(this.b);
        }
    }
}
