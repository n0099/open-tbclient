package com.baidu.android.ext.widget.toast;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class ToastRightAreaStyle {
    public static final /* synthetic */ ToastRightAreaStyle[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ToastRightAreaStyle BUTTON;
    public static final ToastRightAreaStyle JUMP;
    public transient /* synthetic */ FieldHolder $fh;
    public int btnBgDrawableResId;
    public int btnTextColorResId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-704042237, "Lcom/baidu/android/ext/widget/toast/ToastRightAreaStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-704042237, "Lcom/baidu/android/ext/widget/toast/ToastRightAreaStyle;");
                return;
            }
        }
        BUTTON = new ToastRightAreaStyle("BUTTON", 0, R.drawable.obfuscated_res_0x7f081444, R.color.obfuscated_res_0x7f0601d7);
        ToastRightAreaStyle toastRightAreaStyle = new ToastRightAreaStyle("JUMP", 1, -1, -1);
        JUMP = toastRightAreaStyle;
        $VALUES = new ToastRightAreaStyle[]{BUTTON, toastRightAreaStyle};
    }

    public ToastRightAreaStyle(@DrawableRes String str, @ColorRes int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.btnBgDrawableResId = -1;
        this.btnTextColorResId = -1;
        this.btnBgDrawableResId = i2;
        this.btnTextColorResId = i3;
    }

    public static ToastRightAreaStyle valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ToastRightAreaStyle) Enum.valueOf(ToastRightAreaStyle.class, str);
        }
        return (ToastRightAreaStyle) invokeL.objValue;
    }

    public static ToastRightAreaStyle[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ToastRightAreaStyle[]) $VALUES.clone();
        }
        return (ToastRightAreaStyle[]) invokeV.objValue;
    }

    public void resetButtonStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.btnBgDrawableResId = R.drawable.obfuscated_res_0x7f081444;
            this.btnTextColorResId = R.color.obfuscated_res_0x7f0601d7;
        }
    }
}
