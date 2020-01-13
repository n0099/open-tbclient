package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<b>> blz;

    /* loaded from: classes10.dex */
    public interface b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar);
    }

    private c() {
        this.blz = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<b> set = this.blz.get(eVar);
        if (set != null) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a(pMSDownloadType);
                }
            }
            this.blz.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<b> set = this.blz.get(eVar);
        if (set != null) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a(pMSDownloadType, aVar);
                }
            }
            this.blz.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, b bVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && bVar != null) {
            Set<b> set = this.blz.get(eVar);
            if (set != null) {
                set.add(bVar);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(bVar);
                this.blz.put(eVar, hashSet);
            }
        }
    }

    public static c MU() {
        return a.blA;
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static c blA = new c();
    }
}
