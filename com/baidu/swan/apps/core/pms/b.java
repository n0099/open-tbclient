package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<InterfaceC0150b>> atk;

    /* renamed from: com.baidu.swan.apps.core.pms.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0150b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar);
    }

    private b() {
        this.atk = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0150b> set = this.atk.get(eVar);
        if (set != null) {
            for (InterfaceC0150b interfaceC0150b : set) {
                if (interfaceC0150b != null) {
                    interfaceC0150b.a(pMSDownloadType);
                }
            }
            this.atk.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0150b> set = this.atk.get(eVar);
        if (set != null) {
            for (InterfaceC0150b interfaceC0150b : set) {
                if (interfaceC0150b != null) {
                    interfaceC0150b.a(pMSDownloadType, aVar);
                }
            }
            this.atk.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, InterfaceC0150b interfaceC0150b) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0150b != null) {
            Set<InterfaceC0150b> set = this.atk.get(eVar);
            if (set != null) {
                set.add(interfaceC0150b);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0150b);
                this.atk.put(eVar, hashSet);
            }
        }
    }

    public static b Bl() {
        return a.atl;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b atl = new b();
    }
}
