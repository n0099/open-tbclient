package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class PolylineDottedLineType {
    public static /* synthetic */ Interceptable $ic;
    public static final PolylineDottedLineType DOTTED_LINE_CIRCLE;
    public static final PolylineDottedLineType DOTTED_LINE_SQUARE;
    public static final /* synthetic */ PolylineDottedLineType[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1823502291, "Lcom/baidu/mapapi/map/PolylineDottedLineType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1823502291, "Lcom/baidu/mapapi/map/PolylineDottedLineType;");
                return;
            }
        }
        DOTTED_LINE_SQUARE = new PolylineDottedLineType("DOTTED_LINE_SQUARE", 0);
        PolylineDottedLineType polylineDottedLineType = new PolylineDottedLineType("DOTTED_LINE_CIRCLE", 1);
        DOTTED_LINE_CIRCLE = polylineDottedLineType;
        a = new PolylineDottedLineType[]{DOTTED_LINE_SQUARE, polylineDottedLineType};
    }

    public PolylineDottedLineType(String str, int i) {
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

    public static PolylineDottedLineType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PolylineDottedLineType) Enum.valueOf(PolylineDottedLineType.class, str);
        }
        return (PolylineDottedLineType) invokeL.objValue;
    }

    public static PolylineDottedLineType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PolylineDottedLineType[]) a.clone();
        }
        return (PolylineDottedLineType[]) invokeV.objValue;
    }
}
