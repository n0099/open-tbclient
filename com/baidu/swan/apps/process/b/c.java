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
/* loaded from: classes11.dex */
public final class c extends m implements com.baidu.swan.apps.process.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, String> cyp;
    private final HashMap<String, b> cyq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static c cys = new c(d.apI());
    }

    private static c anL() {
        return a.cys;
    }

    public c(h hVar) {
        super(hVar);
        this.cyp = new HashMap<>();
        this.cyq = new HashMap<>();
        log("SwanIpc");
        n(new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                c.this.log("onEventCallback msg" + aVar);
                c.this.g(aVar);
            }
        }, "event_messenger_call_out").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                c.this.log("onEventCallback msg" + aVar);
                c.this.f(aVar);
            }
        }, "event_messenger_call_in"));
    }

    public static void init() {
        anL();
    }

    public static synchronized b nc(@NonNull String str) {
        b ne;
        synchronized (c.class) {
            ne = anL().ne(str);
        }
        return ne;
    }

    public static synchronized b nd(@NonNull String str) {
        b f;
        synchronized (c.class) {
            f = anL().f(str, null);
        }
        return f;
    }

    public static synchronized b M(@NonNull Bundle bundle) {
        b N;
        synchronized (c.class) {
            N = anL().N(bundle);
        }
        return N;
    }

    public static synchronized boolean bL(@NonNull String str, @NonNull String str2) {
        boolean a2;
        synchronized (c.class) {
            a2 = anL().a(nd(str), str2);
        }
        return a2;
    }

    public static synchronized boolean c(@NonNull Bundle bundle, @NonNull String str) {
        boolean a2;
        synchronized (c.class) {
            a2 = anL().a(M(bundle), str);
        }
        return a2;
    }

    private synchronized b ne(String str) {
        b N;
        N = N(null);
        a(N, str);
        D("topic", str + " session=" + N);
        return N;
    }

    private synchronized b N(Bundle bundle) {
        return f(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    private synchronized b f(String str, Bundle bundle) {
        b bVar;
        b bVar2 = TextUtils.isEmpty(str) ? null : this.cyq.get(str);
        if (bVar2 == null || !bVar2.valid()) {
            a(bVar2, new IllegalStateException("invalid session"));
            b bVar3 = new b(this, str);
            this.cyq.put(bVar3.anG(), bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        boolean z = bundle != null && a(bVar, bundle);
        if (z) {
            int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i)) {
                bVar.gr(i);
            } else if (SwanAppProcessInfo.SERVICE.index == i) {
                bVar.eL(true);
            }
        }
        bVar.bj(z ? bundle.getLong("ipc_session_timeout") : cyf);
        D("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.cyq) {
                bVar.r(exc);
                this.cyq.remove(bVar.anG());
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(@NonNull b bVar) {
        return nf(bVar.anG());
    }

    String nf(@NonNull String str) {
        return this.cyp.get(str);
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
            String anG = bVar.anG();
            String str2 = this.cyp.get(anG);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = !z2 || TextUtils.equals(str2, str);
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.cyp.put(anG, str);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(i.a aVar) {
        D("onCallIn", "msg=" + aVar);
        if (aVar != null) {
            Bundle bundle = aVar.toBundle();
            i.a aVar2 = new i.a("event_messenger_call", bundle);
            b M = M(bundle);
            if (!a(M, bundle) || !M.e(aVar2)) {
                d.apI().i(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(i.a aVar) {
        D("onCallOut", "msg=" + aVar);
        if (aVar != null) {
            M(aVar.toBundle()).anH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void D(String str, String str2) {
        log(str + ": " + str2);
    }
}
