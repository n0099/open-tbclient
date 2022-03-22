package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class y {
    public static /* synthetic */ Interceptable $ic;
    public static final y a;

    /* renamed from: b  reason: collision with root package name */
    public static final y f26754b;

    /* renamed from: c  reason: collision with root package name */
    public static final y f26755c;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ y[] f26756e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final int f26757d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782747, "Lcom/baidu/mapsdkplatform/comapi/map/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782747, "Lcom/baidu/mapsdkplatform/comapi/map/y;");
                return;
            }
        }
        a = new y(EngineName.DEFAULT_ENGINE, 0, 1);
        f26754b = new y("INDOOR", 1, 2);
        y yVar = new y("STREET", 2, 3);
        f26755c = yVar;
        f26756e = new y[]{a, f26754b, yVar};
    }

    public y(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
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
        this.f26757d = i2;
    }

    public static y valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (y) Enum.valueOf(y.class, str) : (y) invokeL.objValue;
    }

    public static y[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (y[]) f26756e.clone() : (y[]) invokeV.objValue;
    }
}
