package com.baidu.searchbox.bddownload.core.file;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes2.dex */
public class FileLock {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FileLock";
    public static final long WAIT_RELEASE_LOCK_NANO;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map fileLockCountMap;
    public final Map waitThreadForFileLockMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(370221702, "Lcom/baidu/searchbox/bddownload/core/file/FileLock;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(370221702, "Lcom/baidu/searchbox/bddownload/core/file/FileLock;");
                return;
            }
        }
        WAIT_RELEASE_LOCK_NANO = TimeUnit.MILLISECONDS.toNanos(100L);
    }

    public void park() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LockSupport.park(Long.valueOf(WAIT_RELEASE_LOCK_NANO));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileLock() {
        this(new HashMap(), new HashMap());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Map) objArr[0], (Map) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public FileLock(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, map2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.fileLockCountMap = map;
        this.waitThreadForFileLockMap = map2;
    }

    public void decreaseLock(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.fileLockCountMap) {
                atomicInteger = (AtomicInteger) this.fileLockCountMap.get(str);
            }
            if (atomicInteger != null && atomicInteger.decrementAndGet() == 0) {
                Util.d(TAG, "decreaseLock decrease lock-count to 0 " + str);
                synchronized (this.waitThreadForFileLockMap) {
                    thread = (Thread) this.waitThreadForFileLockMap.get(str);
                    if (thread != null) {
                        this.waitThreadForFileLockMap.remove(str);
                    }
                }
                if (thread != null) {
                    Util.d(TAG, "decreaseLock " + str + " unpark locked thread " + atomicInteger);
                    unpark(thread);
                }
                synchronized (this.fileLockCountMap) {
                    this.fileLockCountMap.remove(str);
                }
            }
        }
    }

    public void waitForRelease(String str) {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this.fileLockCountMap) {
                atomicInteger = (AtomicInteger) this.fileLockCountMap.get(str);
            }
            if (atomicInteger != null && atomicInteger.get() > 0) {
                synchronized (this.waitThreadForFileLockMap) {
                    this.waitThreadForFileLockMap.put(str, Thread.currentThread());
                }
                Util.d(TAG, "waitForRelease start " + str);
                while (!isNotLocked(atomicInteger)) {
                    park();
                }
                Util.d(TAG, "waitForRelease finish " + str);
            }
        }
    }

    public void increaseLock(String str) {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this.fileLockCountMap) {
                atomicInteger = (AtomicInteger) this.fileLockCountMap.get(str);
            }
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
                synchronized (this.fileLockCountMap) {
                    this.fileLockCountMap.put(str, atomicInteger);
                }
            }
            Util.d(TAG, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + str);
        }
    }

    public boolean isNotLocked(AtomicInteger atomicInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, atomicInteger)) == null) {
            if (atomicInteger.get() <= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void unpark(Thread thread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, thread) == null) {
            LockSupport.unpark(thread);
        }
    }
}
