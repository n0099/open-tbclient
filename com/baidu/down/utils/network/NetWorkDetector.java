package com.baidu.down.utils.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class NetWorkDetector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final long DETECT_INTERVAL = 5000;
    public static final int RETURN_VALUE_FAILED = -1;
    public static final int RETURN_VALUE_SUCCESS = 0;
    public static final int RETURN_VALUE_TIMEOUT = 1;
    public static final int RETURN_VALUE_UNREACHABLE = 2;
    public static final String TAG = "NetWorkDetector";
    public static NetWorkDetector sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, HostStatusCache> mDetectCacheMap;
    public boolean sNeedDetect;

    /* renamed from: com.baidu.down.utils.network.NetWorkDetector$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1293107525, "Lcom/baidu/down/utils/network/NetWorkDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1293107525, "Lcom/baidu/down/utils/network/NetWorkDetector;");
        }
    }

    public NetWorkDetector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sNeedDetect = true;
        this.mDetectCacheMap = null;
        this.mDetectCacheMap = new HashMap<>();
    }

    public static int getHostReachable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                Process exec = runtime.exec("ping -c 1 " + str);
                exec.waitFor();
                return exec.exitValue();
            } catch (IOException | InterruptedException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static NetWorkDetector getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                sInstance = new NetWorkDetector();
            }
            return sInstance;
        }
        return (NetWorkDetector) invokeV.objValue;
    }

    public synchronized boolean isHostReachableCached(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j2)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.mDetectCacheMap.containsKey(str)) {
                    HostStatusCache hostStatusCache = this.mDetectCacheMap.get(str);
                    if (SystemClock.elapsedRealtime() - hostStatusCache.cacheTime < j2) {
                        return hostStatusCache.lastStatus == 0;
                    }
                }
                int hostReachable = getHostReachable(str);
                HostStatusCache hostStatusCache2 = new HostStatusCache(null);
                hostStatusCache2.cacheTime = SystemClock.elapsedRealtime();
                hostStatusCache2.lastStatus = hostReachable;
                this.mDetectCacheMap.put(str, hostStatusCache2);
                return hostReachable == 0;
            }
        }
        return invokeLJ.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static final class HostStatusCache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long cacheTime;
        public int lastStatus;

        public HostStatusCache() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cacheTime = 0L;
            this.lastStatus = -1;
        }

        public /* synthetic */ HostStatusCache(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
