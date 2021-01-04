package com.baidu.searchbox.http;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class NetworkQuality {
    public static final int BAD_NETWORK_QUALITY = 2;
    public static final int DEFAULT_NETWORK_QUALITY = 1;
    public static final int GOOD_NETWORK_QUALITY = 1;
    public static final int NET_QUALITY_UPDATE_FROM_NQE = 2;
    public static final int NET_QUALITY_UPDATE_FROM_SDT = 1;
    public static final int OFFLINE_NETWORK_QUALITY = 3;
    public static final String TAG = "NetworkQualityLog";
    public static final int UNKNOWN_NETWORK_QUALITY = -1;
    private static Map<String, List<Integer>> sLastSdtProbeErrorCodeMap;
    private static int sNetworkQuality = 1;
    private static int sLastNetworkQualityQuality = 1;
    private static final List<NetworkQualityListener> sNetworkQualityListeners = new ArrayList(2);
    private static volatile int sNetworkQualityUpdateFrom = -1;
    private static WeakNetCheckConfig sWeakNetCheckConfig = new WeakNetCheckConfig();

    /* loaded from: classes15.dex */
    public static abstract class NetworkQualityListener {
        private final Executor mExecutor;

        public abstract void onNetworkQualityChanged(int i);

        public NetworkQualityListener(Executor executor) {
            if (executor == null) {
                throw new IllegalStateException("Executor must not be null");
            }
            this.mExecutor = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Executor getExecutor() {
            return this.mExecutor;
        }
    }

    public static boolean isEnable() {
        return getWeakNetCheckConfig().enableNqe || getWeakNetCheckConfig().enableSdt;
    }

    public static void addNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        synchronized (sNetworkQualityListeners) {
            if (!sNetworkQualityListeners.contains(networkQualityListener)) {
                sNetworkQualityListeners.add(networkQualityListener);
            }
        }
    }

    public static void removeNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        synchronized (sNetworkQualityListeners) {
            sNetworkQualityListeners.remove(networkQualityListener);
        }
    }

    public static int getNetworkQuality() {
        return sNetworkQuality;
    }

    public static boolean isWeakNet() {
        return sNetworkQuality == 2 || sNetworkQuality == 3;
    }

    public static int getNetworkQualityUpdateFrom() {
        return sNetworkQualityUpdateFrom;
    }

    public static void updateNetworkQuality(int i, int i2) {
        if (i != sLastNetworkQualityQuality) {
            synchronized (sNetworkQualityListeners) {
                sNetworkQuality = i;
                sNetworkQualityUpdateFrom = i2;
                for (final NetworkQualityListener networkQualityListener : sNetworkQualityListeners) {
                    try {
                        networkQualityListener.getExecutor().execute(new Runnable() { // from class: com.baidu.searchbox.http.NetworkQuality.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NetworkQualityListener.this != null) {
                                    NetworkQualityListener.this.onNetworkQualityChanged(NetworkQuality.sNetworkQuality);
                                }
                            }
                        });
                    } catch (Exception e) {
                    }
                }
                sLastNetworkQualityQuality = i;
            }
        }
    }

    public static String getNameOfQuality(int i) {
        switch (i) {
            case -1:
                return "Unknown";
            case 0:
            default:
                return String.valueOf(i);
            case 1:
                return "Good";
            case 2:
                return "Bad";
            case 3:
                return "Offline";
        }
    }

    public static void setWeakNetCheckConfig(WeakNetCheckConfig weakNetCheckConfig) {
        sWeakNetCheckConfig = weakNetCheckConfig;
    }

    public static WeakNetCheckConfig getWeakNetCheckConfig() {
        return sWeakNetCheckConfig;
    }

    public static JSONObject getLastSdtProbeErrorCode() {
        synchronized (NetworkQuality.class) {
            if (sLastSdtProbeErrorCodeMap != null) {
                return new JSONObject(sLastSdtProbeErrorCodeMap);
            }
            return null;
        }
    }

    protected static void updateLastSdtProbeErrCode(Map<String, List<Integer>> map) {
        synchronized (NetworkQuality.class) {
            if (sLastSdtProbeErrorCodeMap == null) {
                sLastSdtProbeErrorCodeMap = new HashMap();
            }
            sLastSdtProbeErrorCodeMap = map;
        }
    }

    /* loaded from: classes15.dex */
    public static class WeakNetCheckConfig {
        static final long DEFAULT_TTFB_EXPIRE_TIME = 1000;
        static final long DEFAULT_TTFB_GOOD_THRESHOLD = 590;
        public boolean enableNqe;
        public boolean enableSdt;
        public long goodTtfbThresholdMillis;
        public long nqeWeakTtfbThresholdMillis;
        public List<String> sdtProbeDomains;
        public long weakTtfbThresholdMillis;

        WeakNetCheckConfig() {
            this.goodTtfbThresholdMillis = DEFAULT_TTFB_GOOD_THRESHOLD;
            this.weakTtfbThresholdMillis = 1000L;
            this.nqeWeakTtfbThresholdMillis = 1000L;
            this.sdtProbeDomains = new ArrayList();
        }

        public WeakNetCheckConfig(long j, long j2, long j3, List<String> list, boolean z, boolean z2) {
            this.goodTtfbThresholdMillis = DEFAULT_TTFB_GOOD_THRESHOLD;
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
            if (this.sdtProbeDomains == null || this.sdtProbeDomains.isEmpty()) {
                this.sdtProbeDomains = Arrays.asList("www.baidu.com");
            }
            this.enableSdt = z;
            this.enableNqe = z2;
        }
    }
}
