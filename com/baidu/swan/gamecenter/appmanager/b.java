package com.baidu.swan.gamecenter.appmanager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class b {
    private volatile HashMap<String, List<com.baidu.swan.gamecenter.appmanager.b.b>> ecM = new HashMap<>();

    public synchronized void a(String str, com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        for (com.baidu.swan.gamecenter.appmanager.b.b bVar2 : new ArrayList(getEventListeners(str))) {
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
        }
    }

    public synchronized void f(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (!h(str, bVar)) {
            List<com.baidu.swan.gamecenter.appmanager.b.b> eventListeners = getEventListeners(str);
            if (!eventListeners.contains(bVar)) {
                eventListeners.add(bVar);
            }
            if (!this.ecM.containsKey(str)) {
                this.ecM.put(str, eventListeners);
            }
        }
    }

    public synchronized void removeEventListener(String str) {
        g(str, null);
    }

    public synchronized void g(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (bVar == null) {
                this.ecM.remove(str);
            } else {
                List<com.baidu.swan.gamecenter.appmanager.b.b> eventListeners = getEventListeners(str);
                if (eventListeners.contains(bVar)) {
                    eventListeners.remove(bVar);
                    if (eventListeners.isEmpty()) {
                        this.ecM.remove(str);
                    }
                }
            }
        }
    }

    public synchronized boolean hasEventListener(String str) {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                List<com.baidu.swan.gamecenter.appmanager.b.b> list = this.ecM.get(str);
                if (list != null) {
                    if (!list.isEmpty()) {
                        z = true;
                        z2 = z;
                    }
                }
                z = false;
                z2 = z;
            }
        }
        return z2;
    }

    private boolean h(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        return TextUtils.isEmpty(str) || bVar == null;
    }

    private List<com.baidu.swan.gamecenter.appmanager.b.b> getEventListeners(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        List<com.baidu.swan.gamecenter.appmanager.b.b> list = this.ecM.get(str);
        return list == null ? new ArrayList() : list;
    }
}
