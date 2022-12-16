package com.baidu.card;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class Align {
    public static final /* synthetic */ Align[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Align ALIGN_LEFT_BOTTOM;
    public static final Align ALIGN_LEFT_CENTER;
    public static final Align ALIGN_LEFT_TOP;
    public static final Align ALIGN_NONE;
    public static final Align ALIGN_RIGHT_BOTTOM;
    public static final Align ALIGN_RIGHT_CENTER;
    public static final Align ALIGN_RIGHT_TOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1429327353, "Lcom/baidu/card/Align;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1429327353, "Lcom/baidu/card/Align;");
                return;
            }
        }
        ALIGN_NONE = new Align("ALIGN_NONE", 0);
        ALIGN_RIGHT_TOP = new Align("ALIGN_RIGHT_TOP", 1);
        ALIGN_RIGHT_CENTER = new Align("ALIGN_RIGHT_CENTER", 2);
        ALIGN_RIGHT_BOTTOM = new Align("ALIGN_RIGHT_BOTTOM", 3);
        ALIGN_LEFT_TOP = new Align("ALIGN_LEFT_TOP", 4);
        ALIGN_LEFT_CENTER = new Align("ALIGN_LEFT_CENTER", 5);
        Align align = new Align("ALIGN_LEFT_BOTTOM", 6);
        ALIGN_LEFT_BOTTOM = align;
        $VALUES = new Align[]{ALIGN_NONE, ALIGN_RIGHT_TOP, ALIGN_RIGHT_CENTER, ALIGN_RIGHT_BOTTOM, ALIGN_LEFT_TOP, ALIGN_LEFT_CENTER, align};
    }

    public Align(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Align valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (Align) Enum.valueOf(Align.class, str);
        }
        return (Align) invokeL.objValue;
    }

    public static Align[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (Align[]) $VALUES.clone();
        }
        return (Align[]) invokeV.objValue;
    }
}
