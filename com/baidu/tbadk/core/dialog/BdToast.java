package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.oj;
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
    public static SoftReference<Toast> j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public Toast b;
    public final ViewGroup c;
    public final ImageView d;
    public final TextView e;
    public CharSequence f;
    public int g;
    public boolean h;
    public int i;

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
            SUCCESS = new ToastIcon("SUCCESS", 0, R.drawable.obfuscated_res_0x7f080a02, true);
            FAILURE = new ToastIcon("FAILURE", 1, R.drawable.obfuscated_res_0x7f080a00, true);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ToastIcon) Enum.valueOf(ToastIcon.class, str) : (ToastIcon) invokeL.objValue;
        }

        public static ToastIcon[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ToastIcon[]) $VALUES.clone() : (ToastIcon[]) invokeV.objValue;
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
        this.h = false;
        this.i = 0;
        this.a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0226, (ViewGroup) null);
        this.c = viewGroup;
        this.d = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092277);
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09227a);
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, charSequence)) == null) {
            BdToast bdToast = new BdToast(context);
            bdToast.h(charSequence);
            return bdToast;
        }
        return (BdToast) invokeLL.objValue;
    }

    public final BdToast a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Toast toast = new Toast(this.a);
            this.b = toast;
            oj.a(toast);
            j();
            int i = this.g;
            if (i != -1) {
                if (this.h) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, this.g, R.color.CAM_X0101, null);
                } else {
                    WebPManager.setMaskDrawable(this.d, i, null);
                }
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            this.c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.f(this.a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
            this.e.setText(this.f);
            this.b.setView(this.c);
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public BdToast c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.e.setLineSpacing(0.0f, f);
        }
    }

    public BdToast e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i != 0) {
                this.h = false;
                this.g = i;
            }
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast f(ToastIcon toastIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, toastIcon)) == null) {
            if (toastIcon != null) {
                this.h = toastIcon.isSvg;
                this.g = toastIcon.iconId;
            }
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048581, this, i, i2, i3)) == null) {
            if (i != 0) {
                this.h = false;
                this.g = i;
            }
            ImageView imageView = this.d;
            if (imageView != null && i2 > 0 && i3 > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(i2, i3);
                    layoutParams.topMargin = R.dimen.obfuscated_res_0x7f0702c3;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = i2;
                    layoutParams.height = i3;
                }
                this.d.setLayoutParams(layoutParams);
            }
            return this;
        }
        return (BdToast) invokeIII.objValue;
    }

    public BdToast h(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, charSequence)) == null) {
            this.f = charSequence;
            this.e.setText(charSequence);
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b == null) {
                a();
            }
            this.e.setText(this.f);
            this.b.setGravity(16, 0, 0);
            this.b.setDuration(this.i);
            this.b.show();
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SoftReference<Toast> softReference = j;
            if (softReference != null && softReference.get() != null) {
                j.get().cancel();
            }
            j = new SoftReference<>(this.b);
        }
    }
}
