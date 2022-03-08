package com.baidu.android.util.concurrent;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
@Deprecated
/* loaded from: classes3.dex */
public final class LockUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "LockUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface WorkInLock {
        Object work();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1817624818, "Lcom/baidu/android/util/concurrent/LockUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1817624818, "Lcom/baidu/android/util/concurrent/LockUtils;");
        }
    }

    public LockUtils() {
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

    public static Object doWorkInLock(Lock lock, WorkInLock workInLock) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, lock, workInLock)) == null) {
            Object obj = null;
            if (lock != null && workInLock != null) {
                try {
                    lock.lock();
                    try {
                        try {
                            obj = workInLock.work();
                        } catch (Exception unused) {
                            boolean z = DEBUG;
                        }
                        try {
                            lock.unlock();
                        } catch (Exception unused2) {
                            boolean z2 = DEBUG;
                        }
                        return obj;
                    } catch (Throwable th) {
                        try {
                            lock.unlock();
                        } catch (Exception unused3) {
                            boolean z3 = DEBUG;
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                    boolean z4 = DEBUG;
                    return null;
                }
            }
            if (DEBUG) {
                String str = "Utility.doWorkInLock [parameters is null] :lock = " + lock + ", work = " + workInLock;
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
