package com.baidu.platform.comjni.engine;

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
/* loaded from: classes3.dex */
public class MessageProxy {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<List<Handler>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780577180, "Lcom/baidu/platform/comjni/engine/MessageProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1780577180, "Lcom/baidu/platform/comjni/engine/MessageProxy;");
                return;
            }
        }
        a = new SparseArray<>();
    }

    public MessageProxy() {
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

    public static void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                SparseArray<List<Handler>> sparseArray = a;
                List<Handler> list = sparseArray.get(sparseArray.keyAt(i));
                if (list != null) {
                    list.clear();
                }
            }
            a.clear();
        }
    }

    public static void dispatchMessage(int i, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            if (i != 2000) {
            }
            synchronized (a) {
                List<Handler> list = a.get(i);
                if (list != null && !list.isEmpty()) {
                    for (Handler handler : list) {
                        Message obtain = Message.obtain(handler, i, i2, i3, Long.valueOf(j));
                        if (i != 41 && (i != 39 || (i2 != 0 && i2 != 1))) {
                            obtain.sendToTarget();
                        }
                        handler.handleMessage(obtain);
                    }
                }
            }
        }
    }

    public static void registerMessageHandler(int i, Handler handler) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, handler) != null) || handler == null) {
            return;
        }
        synchronized (a) {
            List<Handler> list = a.get(i);
            if (list != null) {
                if (!list.contains(handler)) {
                    list.add(handler);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                a.put(i, arrayList);
            }
        }
    }

    public static void unRegisterMessageHandler(int i, Handler handler) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65541, null, i, handler) == null) && handler != null) {
            handler.removeCallbacksAndMessages(null);
            synchronized (a) {
                List<Handler> list = a.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
