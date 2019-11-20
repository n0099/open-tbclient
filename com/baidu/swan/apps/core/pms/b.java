package com.baidu.swan.apps.core.pms;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<com.baidu.swan.pms.model.e, Set<InterfaceC0182b>> aMj;

    /* renamed from: com.baidu.swan.apps.core.pms.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0182b {
        void a(PMSDownloadType pMSDownloadType);

        void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar);
    }

    private b() {
        this.aMj = new HashMap<>();
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0182b> set = this.aMj.get(eVar);
        if (set != null) {
            for (InterfaceC0182b interfaceC0182b : set) {
                if (interfaceC0182b != null) {
                    interfaceC0182b.a(pMSDownloadType);
                }
            }
            this.aMj.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + " : " + pMSDownloadType);
        }
        Set<InterfaceC0182b> set = this.aMj.get(eVar);
        if (set != null) {
            for (InterfaceC0182b interfaceC0182b : set) {
                if (interfaceC0182b != null) {
                    interfaceC0182b.a(pMSDownloadType, aVar);
                }
            }
            this.aMj.remove(eVar);
        }
    }

    public synchronized void a(com.baidu.swan.pms.model.e eVar, InterfaceC0182b interfaceC0182b) {
        if (DEBUG) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0182b != null) {
            Set<InterfaceC0182b> set = this.aMj.get(eVar);
            if (set != null) {
                set.add(interfaceC0182b);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0182b);
                this.aMj.put(eVar, hashSet);
            }
        }
    }

    public static b Gh() {
        return a.aMk;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b aMk = new b();
    }
}
