package com.baidu.perf.signal.register;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.na1;
import com.baidu.tieba.oa1;
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
    public static final LinkedList sANRListeners;
    public static final Object sANRMutex;
    public static final LinkedList sExceptionListeners;
    public static final Object sExceptionMutex;
    public transient /* synthetic */ FieldHolder $fh;

    public static native int makeNativeCrash();

    public static native int registerANR(int i);

    public static native int registerException(int i);

    public static native int unRegisterANR();

    public static native int unRegisterException();

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
        sExceptionListeners = new LinkedList();
        sExceptionMutex = new Object();
        sANRListeners = new LinkedList();
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

    public static void addANRListener(na1 na1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, na1Var) == null) && na1Var != null) {
            synchronized (sANRMutex) {
                sANRListeners.add(na1Var);
            }
        }
    }

    public static void addExceptionListener(oa1 oa1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, oa1Var) == null) && oa1Var != null) {
            synchronized (sExceptionMutex) {
                sExceptionListeners.add(oa1Var);
            }
        }
    }

    public static void removeANRListener(na1 na1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, na1Var) == null) && na1Var != null) {
            synchronized (sANRMutex) {
                sANRListeners.remove(na1Var);
            }
        }
    }

    public static void removeExceptionListener(oa1 oa1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, oa1Var) == null) && oa1Var != null) {
            synchronized (sExceptionMutex) {
                sExceptionListeners.remove(oa1Var);
            }
        }
    }

    public static final void onNativeANR(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65543, null, i) == null) && sANRListeners != null) {
            synchronized (sANRMutex) {
                Iterator it = sANRListeners.iterator();
                while (it.hasNext()) {
                    ((na1) it.next()).onNativeANR(i);
                }
            }
        }
    }

    public static final void onNativeException(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(65544, null, i, i2, i3) == null) && sExceptionListeners != null) {
            synchronized (sExceptionMutex) {
                Iterator it = sExceptionListeners.iterator();
                while (it.hasNext()) {
                    ((oa1) it.next()).a(i, i2, i3);
                }
            }
        }
    }
}
