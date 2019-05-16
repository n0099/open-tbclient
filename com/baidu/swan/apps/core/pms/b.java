package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<InterfaceC0139b>> asj;

    /* renamed from: com.baidu.swan.apps.core.pms.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0139b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar);
    }

    private b() {
        this.asj = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0139b> set = this.asj.get(eVar);
        if (set != null) {
            for (InterfaceC0139b interfaceC0139b : set) {
                if (interfaceC0139b != null) {
                    interfaceC0139b.a(pMSDownloadType);
                }
            }
            this.asj.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0139b> set = this.asj.get(eVar);
        if (set != null) {
            for (InterfaceC0139b interfaceC0139b : set) {
                if (interfaceC0139b != null) {
                    interfaceC0139b.a(pMSDownloadType, aVar);
                }
            }
            this.asj.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, InterfaceC0139b interfaceC0139b) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0139b != null) {
            Set<InterfaceC0139b> set = this.asj.get(eVar);
            if (set != null) {
                set.add(interfaceC0139b);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0139b);
                this.asj.put(eVar, hashSet);
            }
        }
    }

    public static b Az() {
        return a.ask;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b ask = new b();
    }
}
