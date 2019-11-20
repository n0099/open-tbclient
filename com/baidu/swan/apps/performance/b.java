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
    private final Map<String, Bundle> aZL = new HashMap();
    private final c aZM = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.performance.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0198b {
        private static b aZY = new b();
    }

    public static b NB() {
        return C0198b.aZY;
    }

    public Bundle gE(String str) {
        Bundle gG = NC().gG(str);
        if (gG == null) {
            gG = new Bundle();
        }
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> startTargetSwanApp: intent.bundle.ext.size=" + gG.size());
        }
        return gG;
    }

    public void a(final String str, final SwanAppProcessInfo swanAppProcessInfo) {
        if (DEBUG) {
            Log.i("UbcBundleHeloer", "xpass -> sendToProcess: mActionCache.size=" + this.aZM.size());
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1
            @Override // java.lang.Runnable
            public void run() {
                final Bundle gE = b.this.gE(str);
                if (b.DEBUG) {
                    Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: ext.size=" + gE.size());
                }
                if (!TextUtils.isEmpty(str) && swanAppProcessInfo.isSwanAppProcess()) {
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.performance.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.DEBUG) {
                                Log.i("UbcBundleHeloer", "xpass -> sendMsgToClient: action");
                            }
                            com.baidu.swan.apps.process.messaging.service.b.OK().a(swanAppProcessInfo, 109, gE);
                        }
                    }, 2500L);
                }
            }
        }, getClass().getSimpleName());
    }

    public b aA(String str, String str2) {
        return b(str, str2, System.currentTimeMillis());
    }

    public b b(String str, String str2, long j) {
        return c(str, str2, j);
    }

    public b u(String str, final String str2, final String str3) {
        b(str, str2, str3);
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void B(Bundle bundle) {
                bundle.putString(str2, str3);
            }
        });
    }

    public b i(String str, final String str2, final boolean z) {
        b(str, str2, Boolean.valueOf(z));
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void B(Bundle bundle) {
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
            public void B(Bundle bundle) {
                bundle.putInt(str2, i);
            }
        });
    }

    public b c(String str, final String str2, final long j) {
        b(str, str2, Long.valueOf(j));
        return a(new a(str) { // from class: com.baidu.swan.apps.performance.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void B(Bundle bundle) {
                bundle.putLong(str2, j);
            }
        });
    }

    private void b(String str, String str2, Object obj) {
        com.baidu.swan.apps.v.c.a.fF(str).fG(String.format("%s: %s", str2, obj)).fJ("[CheckPoint]");
    }

    private b a(a aVar) {
        this.aZM.d(aVar);
        return this;
    }

    public synchronized Bundle gF(String str) {
        Bundle gH;
        synchronized (this.aZL) {
            gH = gH(str);
            if (gH == null) {
                gH = new Bundle();
                this.aZL.put(str, gH);
            }
        }
        return gH;
    }

    public b NC() {
        this.aZM.NH();
        return this;
    }

    public Bundle gG(String str) {
        Bundle remove;
        synchronized (this.aZL) {
            remove = this.aZL.remove(str);
        }
        return remove;
    }

    public Bundle gH(String str) {
        Bundle bundle;
        synchronized (this.aZL) {
            bundle = this.aZL.get(str);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.swan.apps.an.d.a<Bundle>, Runnable {
        final String aZW;
        final List<Object<Bundle, Boolean>> aZX = new ArrayList();

        public a(String str) {
            this.aZW = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.aZW)) {
                synchronized (b.this.aZL) {
                    B(b.this.gF(this.aZW));
                }
            }
        }
    }
}
