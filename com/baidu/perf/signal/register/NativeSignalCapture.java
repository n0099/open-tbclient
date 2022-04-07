package com.baidu.perf.signal.register;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o71;
import com.repackage.p71;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class NativeSignalCapture {
    public static /* synthetic */ Interceptable $ic;
    public static final LinkedList<o71> sANRListeners;
    public static final Object sANRMutex;
    public static final LinkedList<p71> sExceptionListeners;
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

    public static void addANRListener(o71 o71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, o71Var) == null) || o71Var == null) {
            return;
        }
        synchronized (sANRMutex) {
            sANRListeners.add(o71Var);
        }
    }

    public static void addExceptionListener(p71 p71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, p71Var) == null) || p71Var == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            sExceptionListeners.add(p71Var);
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
            Iterator<o71> it = sANRListeners.iterator();
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
            Iterator<p71> it = sExceptionListeners.iterator();
            while (it.hasNext()) {
                it.next().a(i, i2, i3);
            }
        }
    }

    public static native int registerANR(int i);

    public static native int registerException(int i);

    public static void removeANRListener(o71 o71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, o71Var) == null) || o71Var == null) {
            return;
        }
        synchronized (sANRMutex) {
            sANRListeners.remove(o71Var);
        }
    }

    public static void removeExceptionListener(p71 p71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, p71Var) == null) || p71Var == null) {
            return;
        }
        synchronized (sExceptionMutex) {
            sExceptionListeners.remove(p71Var);
        }
    }

    public static native int unRegisterANR();

    public static native int unRegisterException();
}
