package com.baidu.android.imsdk.internal;

import com.baidu.android.imsdk.IMListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class ListenerManager {
    private static ListenerManager sInstance;
    private Map<String, IMListener> mMap = new HashMap();
    private AtomicInteger mOpenCounter = new AtomicInteger();

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

    public synchronized void clearListener() {
        this.mMap.clear();
    }

    public synchronized boolean addListener(String str, IMListener iMListener) {
        boolean z;
        if (str == null || iMListener == null) {
            z = false;
        } else {
            this.mMap.put(str, iMListener);
            z = true;
        }
        return z;
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

    public synchronized IMListener getListener(String str) {
        IMListener iMListener = null;
        synchronized (this) {
            if (str != null) {
                if (this.mMap.containsKey(str)) {
                    iMListener = this.mMap.get(str);
                }
            }
        }
        return iMListener;
    }

    public synchronized IMListener removeListener(String str) {
        IMListener iMListener = null;
        synchronized (this) {
            if (str != null) {
                if (this.mMap.containsKey(str)) {
                    iMListener = this.mMap.remove(str);
                }
            }
        }
        return iMListener;
    }

    private synchronized String getKey() {
        return "k" + System.currentTimeMillis() + this.mOpenCounter.incrementAndGet();
    }
}
