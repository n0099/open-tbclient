package com.baidu.swan.apps.performance;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, Bundle> aDP = new HashMap();
    private final c aDQ = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.performance.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0150b {
        private static b aEc = new b();
    }

    public static b FH() {
        return C0150b.aEc;
    }

    public Bundle fE(String str) {
        Bundle fG = FI().fG(str);
        if (fG == null) {
            fG = new Bundle();
        }
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> startTargetSwanApp: intent.bundle.ext.size=" + fG.size());
        }
        return fG;
    }

    public void a(final String str, final SwanAppProcessInfo swanAppProcessInfo) {
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> sendToProcess: mActionCache.size=" + this.aDQ.size());
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1
            @Override // java.lang.Runnable
            public void run() {
                final Bundle fE = b.this.fE(str);
                if (b.DEBUG) {
                    Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: ext.size=" + fE.size());
                }
                if (!TextUtils.isEmpty(str) && swanAppProcessInfo.isSwanAppProcess()) {
                    aa.b(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.DEBUG) {
                                Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: action");
                            }
                            com.baidu.swan.apps.process.messaging.service.b.GI().a(swanAppProcessInfo, 109, fE);
                        }
                    }, 2500L);
                }
            }
        }, getClass().getSimpleName());
    }

    public b ar(String str, String str2) {
        return b(str, str2, System.currentTimeMillis());
    }

    public b b(String str, String str2, long j) {
        return c(str, str2, j);
    }

    public b q(String str, final String str2, final String str3) {
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putString(str2, str3);
            }
        });
    }

    public b f(String str, final String str2, final boolean z) {
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putBoolean(str2, z);
            }
        });
    }

    public b e(String str, final String str2, final int i) {
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putInt(str2, i);
            }
        });
    }

    public b c(String str, final String str2, final long j) {
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                bundle.putLong(str2, j);
            }
        });
    }

    private b a(a aVar) {
        this.aDQ.f(aVar);
        return this;
    }

    public synchronized Bundle fF(String str) {
        Bundle bundle;
        synchronized (this.aDP) {
            bundle = getBundle(str);
            if (bundle == null) {
                bundle = new Bundle();
                this.aDP.put(str, bundle);
            }
        }
        return bundle;
    }

    public b FI() {
        this.aDQ.FN();
        return this;
    }

    public Bundle fG(String str) {
        Bundle remove;
        synchronized (this.aDP) {
            remove = this.aDP.remove(str);
        }
        return remove;
    }

    public Bundle getBundle(String str) {
        Bundle bundle;
        synchronized (this.aDP) {
            bundle = this.aDP.get(str);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.swan.apps.an.c.a<Bundle>, Runnable {
        final String aEa;
        final List<Object<Bundle, Boolean>> aEb = new ArrayList();

        public a(String str) {
            this.aEa = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.aEa)) {
                synchronized (b.this.aDP) {
                    D(b.this.fF(this.aEa));
                }
            }
        }
    }
}
