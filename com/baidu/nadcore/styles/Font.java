package com.baidu.nadcore.styles;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class Font {
    public static final /* synthetic */ Font[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"InlinedApi"})
    public static final Font F_F_X01;
    @SuppressLint({"InlinedApi"})
    public static final Font F_F_X02;
    @SuppressLint({"InlinedApi"})
    public static final Font F_F_X03;
    @SuppressLint({"InlinedApi"})
    public static final Font F_NORMAL;
    public transient /* synthetic */ FieldHolder $fh;
    public int mFontWeight;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1963933236, "Lcom/baidu/nadcore/styles/Font;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1963933236, "Lcom/baidu/nadcore/styles/Font;");
                return;
            }
        }
        F_NORMAL = new Font("F_NORMAL", 0, 400);
        F_F_X01 = new Font("F_F_X01", 1, 700);
        F_F_X02 = new Font("F_F_X02", 2, 700);
        Font font = new Font("F_F_X03", 3, 700);
        F_F_X03 = font;
        $VALUES = new Font[]{F_NORMAL, F_F_X01, F_F_X02, font};
    }

    public Font(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
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
        this.mFontWeight = i3;
    }

    public static Font valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Font) Enum.valueOf(Font.class, str) : (Font) invokeL.objValue;
    }

    public static Font[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Font[]) $VALUES.clone() : (Font[]) invokeV.objValue;
    }

    public int getFontWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFontWeight : invokeV.intValue;
    }
}
