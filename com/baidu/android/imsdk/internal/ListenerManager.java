package com.baidu.android.imsdk.internal;

import com.baidu.android.imsdk.IMListener;
import com.baidu.mobstat.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ListenerManager {
    public static ListenerManager sInstance;
    public Map<String, IMListener> mMap = new HashMap();
    public AtomicInteger mOpenCounter = new AtomicInteger();

    public static synchronized ListenerManager getInstance() {
        ListenerManager listenerManager;
        synchronized (ListenerManager.class) {
            if (sInstance == null) {
                sInstance = new ListenerManager();
            }
            listenerManager = sInstance;
        }
        return listenerManager;
    }

    private synchronized String getKey() {
        return Config.APP_KEY + System.currentTimeMillis() + this.mOpenCounter.incrementAndGet();
    }

    public synchronized boolean addListener(String str, IMListener iMListener) {
        if (str == null || iMListener == null) {
            return false;
        }
        this.mMap.put(str, iMListener);
        return true;
    }

    public synchronized void clearListener() {
        this.mMap.clear();
    }

    public synchronized IMListener getListener(String str) {
        if (str == null) {
            return null;
        }
        if (this.mMap.containsKey(str)) {
            return this.mMap.get(str);
        }
        return null;
    }

    public synchronized IMListener removeListener(String str) {
        if (str == null) {
            return null;
        }
        if (this.mMap.containsKey(str)) {
            return this.mMap.remove(str);
        }
        return null;
    }

    public synchronized String addListener(IMListener iMListener) {
        String str;
        str = "";
        if (iMListener != null) {
            str = getKey();
            this.mMap.put(str, iMListener);
        }
        return str;
    }
}
