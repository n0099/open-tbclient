package com.baidu.ar.plugin.helper;

import android.app.Instrumentation;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.plugin.reflect.MethodUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ActivityThreadCompat {
    public static /* synthetic */ Interceptable $ic;
    public static Object sActivityThread;
    public static Class sClass;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1684439029, "Lcom/baidu/ar/plugin/helper/ActivityThreadCompat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1684439029, "Lcom/baidu/ar/plugin/helper/ActivityThreadCompat;");
        }
    }

    public ActivityThreadCompat() {
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

    public static final Class activityThreadClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sClass == null) {
                sClass = Class.forName("android.app.ActivityThread");
            }
            return sClass;
        }
        return (Class) invokeV.objValue;
    }

    public static final synchronized Object currentActivityThread() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (ActivityThreadCompat.class) {
                if (sActivityThread == null) {
                    Object invokeStaticMethod = MethodUtils.invokeStaticMethod(activityThreadClass(), "currentActivityThread", new Object[0]);
                    sActivityThread = invokeStaticMethod;
                    if (invokeStaticMethod == null) {
                        sActivityThread = currentActivityThread2();
                    }
                }
                obj = sActivityThread;
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public static Object currentActivityThread2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            Object obj = new Object();
            handler.post(new Runnable(obj) { // from class: com.baidu.ar.plugin.helper.ActivityThreadCompat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object val$sLock;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {obj};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$sLock = obj;
                }

                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            try {
                                Object unused = ActivityThreadCompat.sActivityThread = MethodUtils.invokeStaticMethod(ActivityThreadCompat.activityThreadClass(), "currentActivityThread", new Object[0]);
                                synchronized (this.val$sLock) {
                                    this.val$sLock.notifyAll();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                synchronized (this.val$sLock) {
                                    this.val$sLock.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            synchronized (this.val$sLock) {
                                this.val$sLock.notifyAll();
                                throw th;
                            }
                        }
                    }
                }
            });
            if (sActivityThread != null || Looper.getMainLooper() == Looper.myLooper()) {
                return null;
            }
            synchronized (obj) {
                try {
                    obj.wait(300L);
                } catch (InterruptedException unused) {
                }
            }
            return null;
        }
        return invokeV.objValue;
    }

    public static Instrumentation getInstrumentation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? (Instrumentation) MethodUtils.invokeMethod(currentActivityThread(), "getInstrumentation", new Object[0]) : (Instrumentation) invokeV.objValue;
    }
}
