package com.baidu.searchbox.http;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NetworkQuality {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BAD_NETWORK_QUALITY = 2;
    public static final int DEFAULT_NETWORK_QUALITY = 1;
    public static final int GOOD_NETWORK_QUALITY = 1;
    public static final int NET_QUALITY_UPDATE_FROM_NQE = 2;
    public static final int NET_QUALITY_UPDATE_FROM_SDT = 1;
    public static final int OFFLINE_NETWORK_QUALITY = 3;
    public static final String TAG = "NetworkQualityLog";
    public static final int UNKNOWN_NETWORK_QUALITY = -1;
    public static int sLastNetworkQualityQuality = 1;
    public static Map<String, List<Integer>> sLastSdtProbeErrorCodeMap = null;
    public static int sNetworkQuality = 1;
    public static final List<NetworkQualityListener> sNetworkQualityListeners;
    public static volatile int sNetworkQualityUpdateFrom;
    public static WeakNetCheckConfig sWeakNetCheckConfig;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class NetworkQualityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor mExecutor;

        public abstract void onNetworkQualityChanged(int i);

        public NetworkQualityListener(Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (executor != null) {
                this.mExecutor = executor;
                return;
            }
            throw new IllegalStateException("Executor must not be null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Executor getExecutor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                return this.mExecutor;
            }
            return (Executor) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class WeakNetCheckConfig {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long DEFAULT_TTFB_EXPIRE_TIME = 1000;
        public static final long DEFAULT_TTFB_GOOD_THRESHOLD = 590;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean enableNqe;
        public boolean enableSdt;
        public long goodTtfbThresholdMillis;
        public long nqeWeakTtfbThresholdMillis;
        public List<String> sdtProbeDomains;
        public long weakTtfbThresholdMillis;

        public WeakNetCheckConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.goodTtfbThresholdMillis = 590L;
            this.weakTtfbThresholdMillis = 1000L;
            this.nqeWeakTtfbThresholdMillis = 1000L;
            this.sdtProbeDomains = new ArrayList();
        }

        public WeakNetCheckConfig(long j, long j2, long j3, List<String> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), list, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.goodTtfbThresholdMillis = 590L;
            this.weakTtfbThresholdMillis = 1000L;
            this.nqeWeakTtfbThresholdMillis = 1000L;
            this.sdtProbeDomains = new ArrayList();
            if (j > 0) {
                this.goodTtfbThresholdMillis = j;
            }
            if (j2 > 0) {
                this.weakTtfbThresholdMillis = j2;
            }
            if (j3 > 0) {
                this.nqeWeakTtfbThresholdMillis = j3;
            }
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.sdtProbeDomains = Collections.unmodifiableList(arrayList);
                }
            }
            List<String> list2 = this.sdtProbeDomains;
            if (list2 == null || list2.isEmpty()) {
                this.sdtProbeDomains = Arrays.asList("www.baidu.com");
            }
            this.enableSdt = z;
            this.enableNqe = z2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1961808317, "Lcom/baidu/searchbox/http/NetworkQuality;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1961808317, "Lcom/baidu/searchbox/http/NetworkQuality;");
                return;
            }
        }
        sNetworkQualityListeners = new ArrayList(2);
        sNetworkQualityUpdateFrom = -1;
        sWeakNetCheckConfig = new WeakNetCheckConfig();
    }

    public NetworkQuality() {
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

    public static JSONObject getLastSdtProbeErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (NetworkQuality.class) {
                if (sLastSdtProbeErrorCodeMap != null) {
                    return new JSONObject(sLastSdtProbeErrorCodeMap);
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static int getNetworkQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return sNetworkQuality;
        }
        return invokeV.intValue;
    }

    public static int getNetworkQualityUpdateFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return sNetworkQualityUpdateFrom;
        }
        return invokeV.intValue;
    }

    public static WeakNetCheckConfig getWeakNetCheckConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return sWeakNetCheckConfig;
        }
        return (WeakNetCheckConfig) invokeV.objValue;
    }

    public static boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (!getWeakNetCheckConfig().enableNqe && !getWeakNetCheckConfig().enableSdt) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isWeakNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int i = sNetworkQuality;
            if (i != 2 && i != 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void addNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, networkQualityListener) == null) {
            synchronized (sNetworkQualityListeners) {
                if (!sNetworkQualityListeners.contains(networkQualityListener)) {
                    sNetworkQualityListeners.add(networkQualityListener);
                }
            }
        }
    }

    public static String getNameOfQuality(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i != -1) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return String.valueOf(i);
                        }
                        return "Offline";
                    }
                    return "Bad";
                }
                return "Good";
            }
            return "Unknown";
        }
        return (String) invokeI.objValue;
    }

    public static void removeNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, networkQualityListener) == null) {
            synchronized (sNetworkQualityListeners) {
                sNetworkQualityListeners.remove(networkQualityListener);
            }
        }
    }

    public static void setWeakNetCheckConfig(WeakNetCheckConfig weakNetCheckConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, weakNetCheckConfig) == null) {
            sWeakNetCheckConfig = weakNetCheckConfig;
        }
    }

    public static void updateLastSdtProbeErrCode(Map<String, List<Integer>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, map) == null) {
            synchronized (NetworkQuality.class) {
                if (sLastSdtProbeErrorCodeMap == null) {
                    sLastSdtProbeErrorCodeMap = new HashMap();
                }
                sLastSdtProbeErrorCodeMap = map;
            }
        }
    }

    public static void updateNetworkQuality(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65550, null, i, i2) == null) && i != sLastNetworkQualityQuality) {
            synchronized (sNetworkQualityListeners) {
                sNetworkQuality = i;
                sNetworkQualityUpdateFrom = i2;
                for (NetworkQualityListener networkQualityListener : sNetworkQualityListeners) {
                    try {
                        networkQualityListener.getExecutor().execute(new Runnable(networkQualityListener) { // from class: com.baidu.searchbox.http.NetworkQuality.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NetworkQualityListener val$listener;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {networkQualityListener};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$listener = networkQualityListener;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                NetworkQualityListener networkQualityListener2;
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (networkQualityListener2 = this.val$listener) != null) {
                                    networkQualityListener2.onNetworkQualityChanged(NetworkQuality.sNetworkQuality);
                                }
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
                sLastNetworkQualityQuality = i;
            }
        }
    }
}
