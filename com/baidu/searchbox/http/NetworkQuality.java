package com.baidu.searchbox.http;

import android.text.TextUtils;
import com.baidu.searchbox.dns.policy.LocalDnsPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NetworkQuality {
    public static final int BAD_NETWORK_QUALITY = 2;
    public static final boolean DEBUG = false;
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
    public static NetworkQualityListenerEventObserver sNetworkQualityListenerEventObserver;
    public static final List<NetworkQualityListener> sNetworkQualityListeners = new ArrayList(2);
    public static volatile int sNetworkQualityUpdateFrom = -1;
    public static WeakNetCheckConfig sWeakNetCheckConfig = new WeakNetCheckConfig();

    /* loaded from: classes3.dex */
    public interface NetworkQualityListenerEventObserver {
        void onNetworkQualityListenerAdded(NetworkQualityListener networkQualityListener);

        void onNetworkQualityListenerRemoved(NetworkQualityListener networkQualityListener);
    }

    /* loaded from: classes3.dex */
    public static abstract class NetworkQualityListener {
        public final Executor mExecutor;

        public abstract void onNetworkQualityChanged(int i);

        public NetworkQualityListener(Executor executor) {
            if (executor != null) {
                this.mExecutor = executor;
                return;
            }
            throw new IllegalStateException("Executor must not be null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Executor getExecutor() {
            return this.mExecutor;
        }
    }

    /* loaded from: classes3.dex */
    public static class WeakNetCheckConfig {
        public static final long DEFAULT_TTFB_EXPIRE_TIME = 1000;
        public static final long DEFAULT_TTFB_GOOD_THRESHOLD = 590;
        public boolean enableNqe;
        public boolean enableSdt;
        public long goodTtfbThresholdMillis;
        public long nqeWeakTtfbThresholdMillis;
        public List<String> sdtProbeDomains;
        public long weakTtfbThresholdMillis;

        public WeakNetCheckConfig() {
            this.goodTtfbThresholdMillis = 590L;
            this.weakTtfbThresholdMillis = 1000L;
            this.nqeWeakTtfbThresholdMillis = 1000L;
            this.sdtProbeDomains = new ArrayList();
        }

        public WeakNetCheckConfig(long j, long j2, long j3, List<String> list, boolean z, boolean z2) {
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
                this.sdtProbeDomains = Arrays.asList(LocalDnsPolicy.MBD_DOMAIN);
            }
            this.enableSdt = z;
            this.enableNqe = z2;
        }
    }

    public static JSONObject getLastSdtProbeErrorCode() {
        synchronized (NetworkQuality.class) {
            if (sLastSdtProbeErrorCodeMap != null) {
                return new JSONObject(sLastSdtProbeErrorCodeMap);
            }
            return null;
        }
    }

    public static int getNetworkQuality() {
        return sNetworkQuality;
    }

    public static int getNetworkQualityUpdateFrom() {
        return sNetworkQualityUpdateFrom;
    }

    public static WeakNetCheckConfig getWeakNetCheckConfig() {
        return sWeakNetCheckConfig;
    }

    public static boolean isEnable() {
        if (!getWeakNetCheckConfig().enableNqe && !getWeakNetCheckConfig().enableSdt) {
            return false;
        }
        return true;
    }

    public static boolean isSdtEnable() {
        return getWeakNetCheckConfig().enableSdt;
    }

    public static boolean isWeakNet() {
        int i = sNetworkQuality;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    public static void addNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        synchronized (sNetworkQualityListeners) {
            if (!sNetworkQualityListeners.contains(networkQualityListener)) {
                sNetworkQualityListeners.add(networkQualityListener);
                if (sNetworkQualityListenerEventObserver != null) {
                    sNetworkQualityListenerEventObserver.onNetworkQualityListenerAdded(networkQualityListener);
                }
            }
        }
    }

    public static String getNameOfQuality(int i) {
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

    public static void removeNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        synchronized (sNetworkQualityListeners) {
            sNetworkQualityListeners.remove(networkQualityListener);
            if (sNetworkQualityListenerEventObserver != null) {
                sNetworkQualityListenerEventObserver.onNetworkQualityListenerRemoved(networkQualityListener);
            }
        }
    }

    public static void setNetworkQualityListenerEventObserver(NetworkQualityListenerEventObserver networkQualityListenerEventObserver) {
        sNetworkQualityListenerEventObserver = networkQualityListenerEventObserver;
    }

    public static void setWeakNetCheckConfig(WeakNetCheckConfig weakNetCheckConfig) {
        sWeakNetCheckConfig = weakNetCheckConfig;
    }

    public static void updateLastSdtProbeErrCode(Map<String, List<Integer>> map) {
        synchronized (NetworkQuality.class) {
            if (sLastSdtProbeErrorCodeMap == null) {
                sLastSdtProbeErrorCodeMap = new HashMap();
            }
            sLastSdtProbeErrorCodeMap = map;
        }
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
                                NetworkQualityListener networkQualityListener2 = NetworkQualityListener.this;
                                if (networkQualityListener2 != null) {
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
