package com.baidu.android.util.concurrent;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
@Deprecated
/* loaded from: classes.dex */
public final class LockUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "LockUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
        if (com.baidu.android.util.concurrent.LockUtils.DEBUG == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
        android.util.Log.d(com.baidu.android.util.concurrent.LockUtils.TAG, "Utility.doWorkInLock [lock.unlock()] Exception.", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:
        if (com.baidu.android.util.concurrent.LockUtils.DEBUG == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                            try {
                                lock.unlock();
                            } catch (Exception e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            try {
                                lock.unlock();
                            } catch (Exception e2) {
                                if (DEBUG) {
                                    Log.d(TAG, "Utility.doWorkInLock [lock.unlock()] Exception.", e2);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        if (DEBUG) {
                            Log.d(TAG, "Utility.doWorkInLock [work.work()] Exception.", e3);
                        }
                        try {
                            lock.unlock();
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                    return obj;
                } catch (Exception e5) {
                    if (DEBUG) {
                        Log.d(TAG, "Utility.doWorkInLock [lock.lock()] Exception.", e5);
                    }
                    return null;
                }
            }
            if (DEBUG) {
                Log.d(TAG, "Utility.doWorkInLock [parameters is null] :lock = " + lock + ", work = " + workInLock);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
