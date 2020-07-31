package com.baidu.swan.apps.process.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.h;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class c extends m implements com.baidu.swan.apps.process.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, String> cAP;
    private final HashMap<String, b> cAQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        static c cAS = new c(d.arr());
    }

    private static c apv() {
        return a.cAS;
    }

    public c(h hVar) {
        super(hVar);
        this.cAP = new HashMap<>();
        this.cAQ = new HashMap<>();
        log("SwanIpc");
        o(new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    if (c.DEBUG) {
                        c.this.log("onEventCallback msg" + aVar);
                    }
                } else {
                    c.this.log("onEventCallback msg" + aVar);
                }
                c.this.g(aVar);
            }
        }, "event_messenger_call_out").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    if (c.DEBUG) {
                        c.this.log("onEventCallback msg" + aVar);
                    }
                } else {
                    c.this.log("onEventCallback msg" + aVar);
                }
                c.this.f(aVar);
            }
        }, "event_messenger_call_in"));
    }

    public static void init() {
        apv();
    }

    public static synchronized b nJ(@NonNull String str) {
        b nL;
        synchronized (c.class) {
            nL = apv().nL(str);
        }
        return nL;
    }

    public static synchronized b nK(@NonNull String str) {
        b f;
        synchronized (c.class) {
            f = apv().f(str, null);
        }
        return f;
    }

    public static synchronized b N(@NonNull Bundle bundle) {
        b O;
        synchronized (c.class) {
            O = apv().O(bundle);
        }
        return O;
    }

    public static synchronized boolean bN(@NonNull String str, @NonNull String str2) {
        boolean a2;
        synchronized (c.class) {
            a2 = apv().a(nK(str), str2);
        }
        return a2;
    }

    public static synchronized boolean c(@NonNull Bundle bundle, @NonNull String str) {
        boolean a2;
        synchronized (c.class) {
            a2 = apv().a(N(bundle), str);
        }
        return a2;
    }

    private synchronized b nL(String str) {
        b O;
        O = O(null);
        a(O, str);
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C("topic", str + " session=" + O);
            }
        } else {
            C("topic", str + " session=" + O);
        }
        return O;
    }

    private synchronized b O(Bundle bundle) {
        return f(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    private synchronized b f(String str, Bundle bundle) {
        b bVar;
        b bVar2 = TextUtils.isEmpty(str) ? null : this.cAQ.get(str);
        if (bVar2 == null || !bVar2.valid()) {
            a(bVar2, new IllegalStateException("invalid session"));
            b bVar3 = new b(this, str);
            this.cAQ.put(bVar3.apq(), bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        boolean z = bundle != null && a(bVar, bundle);
        if (z) {
            int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i)) {
                bVar.gA(i);
            } else if (SwanAppProcessInfo.SERVICE.index == i) {
                bVar.eU(true);
            }
        }
        bVar.bu(z ? bundle.getLong("ipc_session_timeout") : cAF);
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C("session", "id=" + str + " session=" + bundle + " session=" + bVar);
            }
        } else {
            C("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.cAQ) {
                bVar.r(exc);
                this.cAQ.remove(bVar.apq());
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(@NonNull b bVar) {
        return nM(bVar.apq());
    }

    String nM(@NonNull String str) {
        return this.cAP.get(str);
    }

    private synchronized boolean a(@NonNull b bVar, @NonNull Bundle bundle) {
        boolean z;
        if (bVar.valid()) {
            z = a(bVar, bundle.getString("ipc_topic", ""));
        }
        return z;
    }

    private synchronized boolean a(@NonNull b bVar, @NonNull String str) {
        boolean z;
        if (bVar.valid()) {
            String apq = bVar.apq();
            String str2 = this.cAP.get(apq);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = !z2 || TextUtils.equals(str2, str);
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.cAP.put(apq, str);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(i.a aVar) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C("onCallIn", "msg=" + aVar);
            }
        } else {
            C("onCallIn", "msg=" + aVar);
        }
        if (aVar != null) {
            Bundle bundle = aVar.toBundle();
            i.a aVar2 = new i.a("event_messenger_call", bundle);
            b N = N(bundle);
            if (!a(N, bundle) || !N.e(aVar2)) {
                d.arr().i(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(i.a aVar) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C("onCallOut", "msg=" + aVar);
            }
        } else {
            C("onCallOut", "msg=" + aVar);
        }
        if (aVar != null) {
            N(aVar.toBundle()).apr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void C(String str, String str2) {
        log(str + ": " + str2);
    }
}
