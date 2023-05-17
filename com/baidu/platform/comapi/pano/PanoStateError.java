package com.baidu.platform.comapi.pano;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class PanoStateError {
    public static /* synthetic */ Interceptable $ic;
    public static final PanoStateError a;
    public static final PanoStateError b;
    public static final PanoStateError c;
    public static final PanoStateError d;
    public static final /* synthetic */ PanoStateError[] e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-417856675, "Lcom/baidu/platform/comapi/pano/PanoStateError;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-417856675, "Lcom/baidu/platform/comapi/pano/PanoStateError;");
                return;
            }
        }
        a = new PanoStateError("PANO_NO_ERROR", 0);
        b = new PanoStateError("PANO_UID_ERROR", 1);
        c = new PanoStateError("PANO_NOT_FOUND", 2);
        PanoStateError panoStateError = new PanoStateError("PANO_NO_TOKEN", 3);
        d = panoStateError;
        e = new PanoStateError[]{a, b, c, panoStateError};
    }

    public PanoStateError(String str, int i) {
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

    public static PanoStateError valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PanoStateError) Enum.valueOf(PanoStateError.class, str);
        }
        return (PanoStateError) invokeL.objValue;
    }

    public static PanoStateError[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PanoStateError[]) e.clone();
        }
        return (PanoStateError[]) invokeV.objValue;
    }
}
