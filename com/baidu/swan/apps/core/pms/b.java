package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.f, Set<InterfaceC0136b>> asa;

    /* renamed from: com.baidu.swan.apps.core.pms.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0136b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar);
    }

    private b() {
        this.asa = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.f fVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + fVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0136b> set = this.asa.get(fVar);
        if (set != null) {
            for (InterfaceC0136b interfaceC0136b : set) {
                if (interfaceC0136b != null) {
                    interfaceC0136b.a(pMSDownloadType);
                }
            }
            this.asa.remove(fVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.f fVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + fVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0136b> set = this.asa.get(fVar);
        if (set != null) {
            for (InterfaceC0136b interfaceC0136b : set) {
                if (interfaceC0136b != null) {
                    interfaceC0136b.a(pMSDownloadType, aVar);
                }
            }
            this.asa.remove(fVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.f fVar, InterfaceC0136b interfaceC0136b) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + fVar);
        }
        if (fVar != null && interfaceC0136b != null) {
            Set<InterfaceC0136b> set = this.asa.get(fVar);
            if (set != null) {
                set.add(interfaceC0136b);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0136b);
                this.asa.put(fVar, hashSet);
            }
        }
    }

    public static b zw() {
        return a.asb;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b asb = new b();
    }
}
