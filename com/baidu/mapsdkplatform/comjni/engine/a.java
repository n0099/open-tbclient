package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static SparseArray<List<Handler>> f37338b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-981076276, "Lcom/baidu/mapsdkplatform/comjni/engine/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-981076276, "Lcom/baidu/mapsdkplatform/comjni/engine/a;");
                return;
            }
        }
        f37338b = new SparseArray<>();
    }

    public a() {
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

    public static void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            synchronized (f37338b) {
                List<Handler> list = f37338b.get(i2);
                if (list != null && !list.isEmpty()) {
                    for (Handler handler : list) {
                        Message.obtain(handler, i2, i3, i4, Long.valueOf(j2)).sendToTarget();
                    }
                }
            }
        }
    }

    public static void a(int i2, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, handler) == null) {
            synchronized (f37338b) {
                if (handler == null) {
                    return;
                }
                List<Handler> list = f37338b.get(i2);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(handler);
                    f37338b.put(i2, arrayList);
                } else if (!list.contains(handler)) {
                    list.add(handler);
                }
            }
        }
    }

    public static void b(int i2, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, handler) == null) {
            synchronized (f37338b) {
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    List<Handler> list = f37338b.get(i2);
                    if (list != null) {
                        list.remove(handler);
                    }
                }
            }
        }
    }
}
