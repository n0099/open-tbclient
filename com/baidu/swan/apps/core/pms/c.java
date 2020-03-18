package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<b>> bpX;

    /* loaded from: classes11.dex */
    public interface b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar);
    }

    private c() {
        this.bpX = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<b> set = this.bpX.get(eVar);
        if (set != null) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a(pMSDownloadType);
                }
            }
            this.bpX.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<b> set = this.bpX.get(eVar);
        if (set != null) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a(pMSDownloadType, aVar);
                }
            }
            this.bpX.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, b bVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && bVar != null) {
            Set<b> set = this.bpX.get(eVar);
            if (set != null) {
                set.add(bVar);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(bVar);
                this.bpX.put(eVar, hashSet);
            }
        }
    }

    public static c Pn() {
        return a.bpY;
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static c bpY = new c();
    }
}
