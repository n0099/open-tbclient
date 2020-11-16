package com.baidu.down.utils.network;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: classes15.dex */
public final class NetWorkDetector {
    private static final boolean DEBUG = false;
    public static final long DETECT_INTERVAL = 5000;
    public static final int RETURN_VALUE_FAILED = -1;
    public static final int RETURN_VALUE_SUCCESS = 0;
    public static final int RETURN_VALUE_TIMEOUT = 1;
    public static final int RETURN_VALUE_UNREACHABLE = 2;
    private static final String TAG = NetWorkDetector.class.getSimpleName();
    private static NetWorkDetector sInstance = null;
    private HashMap<String, HostStatusCache> mDetectCacheMap;
    public boolean sNeedDetect = true;

    /* loaded from: classes15.dex */
    private static final class HostStatusCache {
        long cacheTime;
        int lastStatus;

        private HostStatusCache() {
            this.cacheTime = 0L;
            this.lastStatus = -1;
        }
    }

    public static NetWorkDetector getInstance() {
        if (sInstance == null) {
            sInstance = new NetWorkDetector();
        }
        return sInstance;
    }

    private NetWorkDetector() {
        this.mDetectCacheMap = null;
        this.mDetectCacheMap = new HashMap<>();
    }

    public synchronized boolean isHostReachableCached(String str, long j) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                if (this.mDetectCacheMap.containsKey(str)) {
                    HostStatusCache hostStatusCache = this.mDetectCacheMap.get(str);
                    if (SystemClock.elapsedRealtime() - hostStatusCache.cacheTime < j) {
                        z = hostStatusCache.lastStatus == 0;
                    }
                }
                int hostReachable = getHostReachable(str);
                HostStatusCache hostStatusCache2 = new HostStatusCache();
                hostStatusCache2.cacheTime = SystemClock.elapsedRealtime();
                hostStatusCache2.lastStatus = hostReachable;
                this.mDetectCacheMap.put(str, hostStatusCache2);
                z = hostReachable == 0;
            }
        }
        return z;
    }

    public static int getHostReachable(String str) {
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 1 " + str);
            exec.waitFor();
            return exec.exitValue();
        } catch (IOException e) {
            return -1;
        } catch (InterruptedException e2) {
            return -1;
        }
    }
}
