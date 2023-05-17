package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class BaseMapCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<Long, a> a;
    public static final ConcurrentHashMap<Long, com.baidu.mapsdkplatform.comjni.a.a.a> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1736640575, "Lcom/baidu/platform/comjni/map/basemap/BaseMapCallback;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1736640575, "Lcom/baidu/platform/comjni/map/basemap/BaseMapCallback;");
                return;
            }
        }
        a = new ConcurrentHashMap<>(2);
        b = new ConcurrentHashMap<>(2);
    }

    public BaseMapCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void release(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            a.remove(Long.valueOf(j));
            b.remove(Long.valueOf(j));
        }
    }

    public static int reqLayerData(Bundle bundle, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bundle, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (a.isEmpty()) {
                return 0;
            }
            for (Map.Entry<Long, a> entry : a.entrySet()) {
                a value = entry.getValue();
                if (value != null && value.a(j)) {
                    return value.a(bundle, j, i);
                }
            }
            for (Map.Entry<Long, com.baidu.mapsdkplatform.comjni.a.a.a> entry2 : b.entrySet()) {
                com.baidu.mapsdkplatform.comjni.a.a.a value2 = entry2.getValue();
                if (value2 != null && value2.a(j)) {
                    return value2.a(bundle, j, i);
                }
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public static boolean setMapCallback(long j, a aVar) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j, aVar)) == null) {
            if (aVar != null && j != 0) {
                a.put(Long.valueOf(j), aVar);
                return true;
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    public static boolean setMapSDKCallback(long j, com.baidu.mapsdkplatform.comjni.a.a.a aVar) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65541, null, j, aVar)) == null) {
            if (aVar != null && j != 0) {
                b.put(Long.valueOf(j), aVar);
                return true;
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
