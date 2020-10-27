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
/* loaded from: classes10.dex */
public final class c extends m implements com.baidu.swan.apps.process.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, String> dfG;
    private final HashMap<String, b> dfH;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        static c dfJ = new c(d.aEQ());
    }

    private static c aCD() {
        return a.dfJ;
    }

    public c(h hVar) {
        super(hVar);
        this.dfG = new HashMap<>();
        this.dfH = new HashMap<>();
        if (DEBUG) {
            log("SwanIpc");
        }
        v(new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                if (c.DEBUG) {
                    c.this.log("onEventCallback msg" + aVar);
                }
                c.this.g(aVar);
            }
        }, "event_messenger_call_out").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                if (c.DEBUG) {
                    c.this.log("onEventCallback msg" + aVar);
                }
                c.this.f(aVar);
            }
        }, "event_messenger_call_in"));
    }

    public static void init() {
        aCD();
    }

    public static synchronized b rg(@NonNull String str) {
        b ri;
        synchronized (c.class) {
            ri = aCD().ri(str);
        }
        return ri;
    }

    public static synchronized b rh(@NonNull String str) {
        b e;
        synchronized (c.class) {
            e = aCD().e(str, (Bundle) null);
        }
        return e;
    }

    public static synchronized b L(@NonNull Bundle bundle) {
        b M;
        synchronized (c.class) {
            M = aCD().M(bundle);
        }
        return M;
    }

    public static synchronized boolean co(@NonNull String str, @NonNull String str2) {
        boolean a2;
        synchronized (c.class) {
            a2 = aCD().a(rh(str), str2);
        }
        return a2;
    }

    public static synchronized boolean d(@NonNull Bundle bundle, @NonNull String str) {
        boolean a2;
        synchronized (c.class) {
            a2 = aCD().a(L(bundle), str);
        }
        return a2;
    }

    private synchronized b ri(String str) {
        b M;
        M = M(null);
        a(M, str);
        if (DEBUG) {
            E("topic", str + " session=" + M);
        }
        return M;
    }

    private synchronized b M(Bundle bundle) {
        return e(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    private synchronized b e(String str, Bundle bundle) {
        b bVar;
        b bVar2 = TextUtils.isEmpty(str) ? null : this.dfH.get(str);
        if (bVar2 == null || !bVar2.valid()) {
            a(bVar2, new IllegalStateException("invalid session"));
            b bVar3 = new b(this, str);
            this.dfH.put(bVar3.id(), bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        boolean z = bundle != null && a(bVar, bundle);
        if (z) {
            int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i)) {
                bVar.jy(i);
            } else if (SwanAppProcessInfo.SERVICE.index == i) {
                bVar.fV(true);
            }
        }
        bVar.bM(z ? bundle.getLong("ipc_session_timeout") : dfw);
        if (DEBUG) {
            E("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.dfH) {
                bVar.u(exc);
                this.dfH.remove(bVar.id());
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(@NonNull b bVar) {
        return rj(bVar.id());
    }

    String rj(@NonNull String str) {
        return this.dfG.get(str);
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
            String id = bVar.id();
            String str2 = this.dfG.get(id);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = !z2 || TextUtils.equals(str2, str);
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.dfG.put(id, str);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(i.a aVar) {
        if (DEBUG) {
            E("onCallIn", "msg=" + aVar);
        }
        if (aVar != null) {
            Bundle bundle = aVar.toBundle();
            i.a aVar2 = new i.a("event_messenger_call", bundle);
            b L = L(bundle);
            if (!a(L, bundle) || !L.e(aVar2)) {
                d.aEQ().i(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(i.a aVar) {
        if (DEBUG) {
            E("onCallOut", "msg=" + aVar);
        }
        if (aVar != null) {
            L(aVar.toBundle()).aCA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void E(String str, String str2) {
        log(str + ": " + str2);
    }
}
