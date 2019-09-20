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
    private final Map<String, Bundle> aGO = new HashMap();
    private final c aGP = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.performance.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0166b {
        private static b aHb = new b();
    }

    public static b IG() {
        return C0166b.aHb;
    }

    public Bundle fZ(String str) {
        Bundle gb = IH().gb(str);
        if (gb == null) {
            gb = new Bundle();
        }
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> startTargetSwanApp: intent.bundle.ext.size=" + gb.size());
        }
        return gb;
    }

    public void a(final String str, final SwanAppProcessInfo swanAppProcessInfo) {
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> sendToProcess: mActionCache.size=" + this.aGP.size());
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1
            @Override // java.lang.Runnable
            public void run() {
                final Bundle fZ = b.this.fZ(str);
                if (b.DEBUG) {
                    Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: ext.size=" + fZ.size());
                }
                if (!TextUtils.isEmpty(str) && swanAppProcessInfo.isSwanAppProcess()) {
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.DEBUG) {
                                Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: action");
                            }
                            com.baidu.swan.apps.process.messaging.service.b.JP().a(swanAppProcessInfo, 109, fZ);
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
        com.baidu.swan.apps.v.c.a.eY(str).eZ(String.format("%s: %s", str2, obj)).fc("[CheckPoint]");
    }

    private b a(a aVar) {
        this.aGP.f(aVar);
        return this;
    }

    public synchronized Bundle ga(String str) {
        Bundle gc;
        synchronized (this.aGO) {
            gc = gc(str);
            if (gc == null) {
                gc = new Bundle();
                this.aGO.put(str, gc);
            }
        }
        return gc;
    }

    public b IH() {
        this.aGP.IM();
        return this;
    }

    public Bundle gb(String str) {
        Bundle remove;
        synchronized (this.aGO) {
            remove = this.aGO.remove(str);
        }
        return remove;
    }

    public Bundle gc(String str) {
        Bundle bundle;
        synchronized (this.aGO) {
            bundle = this.aGO.get(str);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.swan.apps.an.d.a<Bundle>, Runnable {
        final String aGZ;
        final List<Object<Bundle, Boolean>> aHa = new ArrayList();

        public a(String str) {
            this.aGZ = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.aGZ)) {
                synchronized (b.this.aGO) {
                    D(b.this.ga(this.aGZ));
                }
            }
        }
    }
}
