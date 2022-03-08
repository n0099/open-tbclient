package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BaseMapCallback {
    public static /* synthetic */ Interceptable $ic;
    public static LongSparseArray<b> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-701531619, "Lcom/baidu/mapsdkplatform/comjni/map/basemap/BaseMapCallback;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-701531619, "Lcom/baidu/mapsdkplatform/comjni/map/basemap/BaseMapCallback;");
                return;
            }
        }
        a = new LongSparseArray<>();
    }

    public BaseMapCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int ReqLayerData(Bundle bundle, long j2, int i2, Bundle bundle2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bundle, Long.valueOf(j2), Integer.valueOf(i2), bundle2})) == null) {
            int size = a.size();
            for (int i3 = 0; i3 < size; i3++) {
                b valueAt = a.valueAt(i3);
                if (valueAt != null && valueAt.a(j2)) {
                    return valueAt.a(bundle, j2, i2, bundle2);
                }
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public static void addLayerDataInterface(long j2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65539, null, j2, bVar) == null) {
            a.put(j2, bVar);
        }
    }

    public static void removeLayerDataInterface(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2) == null) {
            a.remove(j2);
        }
    }
}
