package com.baidu.searchbox.network;

import android.content.Context;
import com.baidu.searchbox.network.core.RequestClient;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class HttpManager extends AbstractHttpManager {
    public static final int BAD_NETWORK_QUALITY = 2;
    public static final int GOOD_NETWORK_QUALITY = 1;
    public static final int OFFLINE_NETWORK_QUALITY = 3;
    public static final int UNKNOWN_NETWORK_QUALITY = -1;
    public static volatile HttpManager httpManager;
    private static ExtraInfoDispatcher sExtraInfoDispatcher = new ExtraInfoDispatcher();

    /* loaded from: classes5.dex */
    public static abstract class NetworkQualityListener {
        private final Executor mExecutor;

        public abstract void onNetworkQualityChanged(int i);

        public NetworkQualityListener(Executor executor) {
            if (executor == null) {
                throw new IllegalStateException("Executor must not be null");
            }
            this.mExecutor = executor;
        }

        public Executor getExecutor() {
            return this.mExecutor;
        }
    }

    public static void addNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        if (!RequestClient.sNetworkQualityListeners.contains(networkQualityListener)) {
            RequestClient.sNetworkQualityListeners.add(networkQualityListener);
        }
    }

    public static void removeNetworkQualityListener(NetworkQualityListener networkQualityListener) {
        RequestClient.sNetworkQualityListeners.remove(networkQualityListener);
    }

    public static int getNetworkQuality() {
        return RequestClient.sNetworkQuality;
    }

    protected HttpManager(Context context) {
        super(context);
    }

    public static HttpManager newHttpManager(Context context) {
        HttpManager httpManager2 = new HttpManager(context);
        httpManager2.setHttpDnsEnable(getDefault(context).getHttpDnsEnable());
        return httpManager2;
    }

    public static HttpManager getDefault(Context context) {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager(context);
                    if (HttpRuntime.getHttpContext() != null) {
                        httpManager.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
        }
        return httpManager;
    }

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        return sExtraInfoDispatcher;
    }
}
