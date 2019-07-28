package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<InterfaceC0141b>> asM;

    /* renamed from: com.baidu.swan.apps.core.pms.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0141b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar);
    }

    private b() {
        this.asM = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0141b> set = this.asM.get(eVar);
        if (set != null) {
            for (InterfaceC0141b interfaceC0141b : set) {
                if (interfaceC0141b != null) {
                    interfaceC0141b.a(pMSDownloadType);
                }
            }
            this.asM.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0141b> set = this.asM.get(eVar);
        if (set != null) {
            for (InterfaceC0141b interfaceC0141b : set) {
                if (interfaceC0141b != null) {
                    interfaceC0141b.a(pMSDownloadType, aVar);
                }
            }
            this.asM.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, InterfaceC0141b interfaceC0141b) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0141b != null) {
            Set<InterfaceC0141b> set = this.asM.get(eVar);
            if (set != null) {
                set.add(interfaceC0141b);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0141b);
                this.asM.put(eVar, hashSet);
            }
        }
    }

    public static b Bh() {
        return a.asN;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b asN = new b();
    }
}
