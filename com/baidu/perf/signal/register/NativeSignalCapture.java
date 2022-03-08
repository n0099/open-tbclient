package com.baidu.perf.signal.register;

import androidx.core.view.InputDeviceCompat;
import c.a.e0.a.a.a;
import c.a.e0.a.a.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class NativeSignalCapture {
    public static /* synthetic */ Interceptable $ic;
    public static final LinkedList<a> sANRListeners;
    public static final Object sANRMutex;
    public static final LinkedList<b> sExceptionListeners;
    public static final Object sExceptionMutex;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-450924687, "Lcom/baidu/perf/signal/register/NativeSignalCapture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-450924687, "Lcom/baidu/perf/signal/register/NativeSignalCapture;");
                return;
            }
        }
        sExceptionListeners = new LinkedList<>();
        sExceptionMutex = new Object();
        sANRListeners = new LinkedList<>();
        sANRMutex = new Object();
    }

    public NativeSignalCapture() {
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

    public static void addANRListener(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        synchronized (sANRMutex) {
            sANRListeners.add(aVar);
        }
    }

    public static void addExceptionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            sExceptionListeners.add(bVar);
        }
    }

    public static void clearANRListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (sANRMutex) {
                sANRListeners.clear();
            }
        }
    }

    public static void clearExceptionListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (sExceptionMutex) {
                sExceptionListeners.clear();
            }
        }
    }

    public static native int makeNativeCrash();

    public static final void onNativeANR(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, null, i2) == null) || sANRListeners == null) {
            return;
        }
        synchronized (sANRMutex) {
            Iterator<a> it = sANRListeners.iterator();
            while (it.hasNext()) {
                it.next().onNativeANR(i2);
            }
        }
    }

    public static final void onNativeException(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(65544, null, i2, i3, i4) == null) || sExceptionListeners == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            Iterator<b> it = sExceptionListeners.iterator();
            while (it.hasNext()) {
                it.next().a(i2, i3, i4);
            }
        }
    }

    public static native int registerANR(int i2);

    public static native int registerException(int i2);

    public static void removeANRListener(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, aVar) == null) || aVar == null) {
            return;
        }
        synchronized (sANRMutex) {
            sANRListeners.remove(aVar);
        }
    }

    public static void removeExceptionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            sExceptionListeners.remove(bVar);
        }
    }

    public static native int unRegisterANR();

    public static native int unRegisterException();
}
