package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private HashMap<com.baidu.swan.pms.model.f, Set<InterfaceC0107b>> arU;

    /* renamed from: com.baidu.swan.apps.core.pms.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0107b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar);
    }

    private b() {
        this.arU = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.f fVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + fVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0107b> set = this.arU.get(fVar);
        if (set != null) {
            for (InterfaceC0107b interfaceC0107b : set) {
                if (interfaceC0107b != null) {
                    interfaceC0107b.a(pMSDownloadType);
                }
            }
            this.arU.remove(fVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.f fVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + fVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0107b> set = this.arU.get(fVar);
        if (set != null) {
            for (InterfaceC0107b interfaceC0107b : set) {
                if (interfaceC0107b != null) {
                    interfaceC0107b.a(pMSDownloadType, aVar);
                }
            }
            this.arU.remove(fVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.f fVar, InterfaceC0107b interfaceC0107b) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + fVar);
        }
        if (fVar != null && interfaceC0107b != null) {
            Set<InterfaceC0107b> set = this.arU.get(fVar);
            if (set != null) {
                set.add(interfaceC0107b);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0107b);
                this.arU.put(fVar, hashSet);
            }
        }
    }

    public static b zx() {
        return a.arV;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b arV = new b();
    }
}
