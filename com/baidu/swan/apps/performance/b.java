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
    private final Map<String, Bundle> aGq = new HashMap();
    private final c aGr = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.performance.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0157b {
        private static b aGD = new b();
    }

    public static b IC() {
        return C0157b.aGD;
    }

    public Bundle fX(String str) {
        Bundle fZ = ID().fZ(str);
        if (fZ == null) {
            fZ = new Bundle();
        }
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> startTargetSwanApp: intent.bundle.ext.size=" + fZ.size());
        }
        return fZ;
    }

    public void a(final String str, final SwanAppProcessInfo swanAppProcessInfo) {
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> sendToProcess: mActionCache.size=" + this.aGr.size());
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1
            @Override // java.lang.Runnable
            public void run() {
                final Bundle fX = b.this.fX(str);
                if (b.DEBUG) {
                    Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: ext.size=" + fX.size());
                }
                if (!TextUtils.isEmpty(str) && swanAppProcessInfo.isSwanAppProcess()) {
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.DEBUG) {
                                Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: action");
                            }
                            com.baidu.swan.apps.process.messaging.service.b.JL().a(swanAppProcessInfo, 109, fX);
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
        com.baidu.swan.apps.v.c.a.eW(str).eX(String.format("%s: %s", str2, obj)).fa("[CheckPoint]");
    }

    private b a(a aVar) {
        this.aGr.f(aVar);
        return this;
    }

    public synchronized Bundle fY(String str) {
        Bundle ga;
        synchronized (this.aGq) {
            ga = ga(str);
            if (ga == null) {
                ga = new Bundle();
                this.aGq.put(str, ga);
            }
        }
        return ga;
    }

    public b ID() {
        this.aGr.II();
        return this;
    }

    public Bundle fZ(String str) {
        Bundle remove;
        synchronized (this.aGq) {
            remove = this.aGq.remove(str);
        }
        return remove;
    }

    public Bundle ga(String str) {
        Bundle bundle;
        synchronized (this.aGq) {
            bundle = this.aGq.get(str);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.swan.apps.an.d.a<Bundle>, Runnable {
        final String aGB;
        final List<Object<Bundle, Boolean>> aGC = new ArrayList();

        public a(String str) {
            this.aGB = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.aGB)) {
                synchronized (b.this.aGq) {
                    D(b.this.fY(this.aGB));
                }
            }
        }
    }
}
