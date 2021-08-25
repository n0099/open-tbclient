package com.baidu.platform.comapi.pano;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PanoStateError {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final PanoStateError f44194a;

    /* renamed from: b  reason: collision with root package name */
    public static final PanoStateError f44195b;

    /* renamed from: c  reason: collision with root package name */
    public static final PanoStateError f44196c;

    /* renamed from: d  reason: collision with root package name */
    public static final PanoStateError f44197d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ PanoStateError[] f44198e;
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
        f44194a = new PanoStateError("PANO_NO_ERROR", 0);
        f44195b = new PanoStateError("PANO_UID_ERROR", 1);
        f44196c = new PanoStateError("PANO_NOT_FOUND", 2);
        PanoStateError panoStateError = new PanoStateError("PANO_NO_TOKEN", 3);
        f44197d = panoStateError;
        f44198e = new PanoStateError[]{f44194a, f44195b, f44196c, panoStateError};
    }

    public PanoStateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PanoStateError) Enum.valueOf(PanoStateError.class, str) : (PanoStateError) invokeL.objValue;
    }

    public static PanoStateError[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PanoStateError[]) f44198e.clone() : (PanoStateError[]) invokeV.objValue;
    }
}
