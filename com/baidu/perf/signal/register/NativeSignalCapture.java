package com.baidu.perf.signal.register;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.d81;
import com.baidu.tieba.e81;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class NativeSignalCapture {
    public static /* synthetic */ Interceptable $ic;
    public static final LinkedList<d81> sANRListeners;
    public static final Object sANRMutex;
    public static final LinkedList<e81> sExceptionListeners;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addANRListener(d81 d81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, d81Var) == null) || d81Var == null) {
            return;
        }
        synchronized (sANRMutex) {
            sANRListeners.add(d81Var);
        }
    }

    public static void addExceptionListener(e81 e81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, e81Var) == null) || e81Var == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            sExceptionListeners.add(e81Var);
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

    public static final void onNativeANR(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, null, i) == null) || sANRListeners == null) {
            return;
        }
        synchronized (sANRMutex) {
            Iterator<d81> it = sANRListeners.iterator();
            while (it.hasNext()) {
                it.next().onNativeANR(i);
            }
        }
    }

    public static final void onNativeException(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(65544, null, i, i2, i3) == null) || sExceptionListeners == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            Iterator<e81> it = sExceptionListeners.iterator();
            while (it.hasNext()) {
                it.next().a(i, i2, i3);
            }
        }
    }

    public static native int registerANR(int i);

    public static native int registerException(int i);

    public static void removeANRListener(d81 d81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, d81Var) == null) || d81Var == null) {
            return;
        }
        synchronized (sANRMutex) {
            sANRListeners.remove(d81Var);
        }
    }

    public static void removeExceptionListener(e81 e81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, e81Var) == null) || e81Var == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            sExceptionListeners.remove(e81Var);
        }
    }

    public static native int unRegisterANR();

    public static native int unRegisterException();
}
