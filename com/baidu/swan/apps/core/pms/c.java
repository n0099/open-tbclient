package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<b>> cVQ;

    /* loaded from: classes8.dex */
    public interface b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar);
    }

    private c() {
        this.cVQ = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<b> set = this.cVQ.get(eVar);
        if (set != null) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a(pMSDownloadType);
                }
            }
            this.cVQ.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<b> set = this.cVQ.get(eVar);
        if (set != null) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a(pMSDownloadType, aVar);
                }
            }
            this.cVQ.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, b bVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && bVar != null) {
            Set<b> set = this.cVQ.get(eVar);
            if (set != null) {
                set.add(bVar);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(bVar);
                this.cVQ.put(eVar, hashSet);
            }
        }
    }

    public static c aqH() {
        return a.cVR;
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static c cVR = new c();
    }
}
