package com.baidu.nadcore.net.request;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class BodyStyle {
    public static final /* synthetic */ BodyStyle[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BodyStyle BYTE;
    public static final BodyStyle FILE;
    public static final BodyStyle FORM;
    public static final BodyStyle STRING;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1282127243, "Lcom/baidu/nadcore/net/request/BodyStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1282127243, "Lcom/baidu/nadcore/net/request/BodyStyle;");
                return;
            }
        }
        BYTE = new BodyStyle("BYTE", 0, "BYTE");
        STRING = new BodyStyle("STRING", 1, "STRING");
        FILE = new BodyStyle("FILE", 2, "FILE");
        BodyStyle bodyStyle = new BodyStyle("FORM", 3, "FORM");
        FORM = bodyStyle;
        $VALUES = new BodyStyle[]{BYTE, STRING, FILE, bodyStyle};
    }

    public BodyStyle(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public static BodyStyle valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BodyStyle) Enum.valueOf(BodyStyle.class, str) : (BodyStyle) invokeL.objValue;
    }

    public static BodyStyle[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BodyStyle[]) $VALUES.clone() : (BodyStyle[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
    }
}
