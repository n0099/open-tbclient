package com.baidu.swan.apps.performance;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, Bundle> aFI = new HashMap();
    private final c aFJ = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.performance.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0155b {
        private static b aFV = new b();
    }

    public static b HP() {
        return C0155b.aFV;
    }

    public Bundle fS(String str) {
        Bundle fU = HQ().fU(str);
        if (fU == null) {
            fU = new Bundle();
        }
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> startTargetSwanApp: intent.bundle.ext.size=" + fU.size());
        }
        return fU;
    }

    public void a(final String str, final SwanAppProcessInfo swanAppProcessInfo) {
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> sendToProcess: mActionCache.size=" + this.aFJ.size());
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1
            @Override // java.lang.Runnable
            public void run() {
                final Bundle fS = b.this.fS(str);
                if (b.DEBUG) {
                    Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: ext.size=" + fS.size());
                }
                if (!TextUtils.isEmpty(str) && swanAppProcessInfo.isSwanAppProcess()) {
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.DEBUG) {
                                Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: action");
                            }
                            com.baidu.swan.apps.process.messaging.service.b.IY().a(swanAppProcessInfo, 109, fS);
                        }
                    }, 2500L);
                }
            }
        }, getClass().getSimpleName());
    }

    public b as(String str, String str2) {
        return c(str, str2, System.currentTimeMillis());
    }

    public b c(String str, String str2, long j) {
        return d(str, str2, j);
    }

    public b q(String str, final String str2, final String str3) {
        b(str, str2, str3);
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putString(str2, str3);
            }
        });
    }

    public b f(String str, final String str2, final boolean z) {
        b(str, str2, Boolean.valueOf(z));
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putBoolean(str2, z);
            }
        });
    }

    public b d(String str, final String str2, final int i) {
        b(str, str2, Integer.valueOf(i));
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putInt(str2, i);
            }
        });
    }

    public b d(String str, final String str2, final long j) {
        b(str, str2, Long.valueOf(j));
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putLong(str2, j);
            }
        });
    }

    private void b(String str, String str2, Object obj) {
        com.baidu.swan.apps.v.c.a.eR(str).eS(String.format("%s: %s", str2, obj)).eV("[CheckPoint]");
    }

    private b a(a aVar) {
        this.aFJ.f(aVar);
        return this;
    }

    public synchronized Bundle fT(String str) {
        Bundle bundle;
        synchronized (this.aFI) {
            bundle = getBundle(str);
            if (bundle == null) {
                bundle = new Bundle();
                this.aFI.put(str, bundle);
            }
        }
        return bundle;
    }

    public b HQ() {
        this.aFJ.HV();
        return this;
    }

    public Bundle fU(String str) {
        Bundle remove;
        synchronized (this.aFI) {
            remove = this.aFI.remove(str);
        }
        return remove;
    }

    public Bundle getBundle(String str) {
        Bundle bundle;
        synchronized (this.aFI) {
            bundle = this.aFI.get(str);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.swan.apps.an.d.a<Bundle>, Runnable {
        final String aFT;
        final List<Object<Bundle, Boolean>> aFU = new ArrayList();

        public a(String str) {
            this.aFT = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.aFT)) {
                synchronized (b.this.aFI) {
                    D(b.this.fT(this.aFT));
                }
            }
        }
    }
}
