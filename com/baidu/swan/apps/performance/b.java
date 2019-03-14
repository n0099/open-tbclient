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
    private final Map<String, Bundle> aDM = new HashMap();
    private final c aDN = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.performance.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0150b {
        private static b aDZ = new b();
    }

    public static b FJ() {
        return C0150b.aDZ;
    }

    public Bundle fD(String str) {
        Bundle fF = FK().fF(str);
        if (fF == null) {
            fF = new Bundle();
        }
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> startTargetSwanApp: intent.bundle.ext.size=" + fF.size());
        }
        return fF;
    }

    public void a(final String str, final SwanAppProcessInfo swanAppProcessInfo) {
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> sendToProcess: mActionCache.size=" + this.aDN.size());
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1
            @Override // java.lang.Runnable
            public void run() {
                final Bundle fD = b.this.fD(str);
                if (b.DEBUG) {
                    Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: ext.size=" + fD.size());
                }
                if (!TextUtils.isEmpty(str) && swanAppProcessInfo.isSwanAppProcess()) {
                    aa.b(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.DEBUG) {
                                Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: action");
                            }
                            com.baidu.swan.apps.process.messaging.service.b.GK().a(swanAppProcessInfo, 109, fD);
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
        this.aDN.f(aVar);
        return this;
    }

    public synchronized Bundle fE(String str) {
        Bundle bundle;
        synchronized (this.aDM) {
            bundle = getBundle(str);
            if (bundle == null) {
                bundle = new Bundle();
                this.aDM.put(str, bundle);
            }
        }
        return bundle;
    }

    public b FK() {
        this.aDN.FP();
        return this;
    }

    public Bundle fF(String str) {
        Bundle remove;
        synchronized (this.aDM) {
            remove = this.aDM.remove(str);
        }
        return remove;
    }

    public Bundle getBundle(String str) {
        Bundle bundle;
        synchronized (this.aDM) {
            bundle = this.aDM.get(str);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.swan.apps.an.c.a<Bundle>, Runnable {
        final String aDX;
        final List<Object<Bundle, Boolean>> aDY = new ArrayList();

        public a(String str) {
            this.aDX = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.aDX)) {
                synchronized (b.this.aDM) {
                    D(b.this.fE(this.aDX));
                }
            }
        }
    }
}
