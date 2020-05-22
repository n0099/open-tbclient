package com.baidu.swan.apps.process.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.h;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class c extends m implements com.baidu.swan.apps.process.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, String> ctC;
    private final HashMap<String, b> ctD;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static c ctF = new c(d.aoB());
    }

    private static c amF() {
        return a.ctF;
    }

    public c(h hVar) {
        super(hVar);
        this.ctC = new HashMap<>();
        this.ctD = new HashMap<>();
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
        amF();
    }

    public static synchronized b mU(@NonNull String str) {
        b mW;
        synchronized (c.class) {
            mW = amF().mW(str);
        }
        return mW;
    }

    public static synchronized b mV(@NonNull String str) {
        b f;
        synchronized (c.class) {
            f = amF().f(str, null);
        }
        return f;
    }

    public static synchronized b M(@NonNull Bundle bundle) {
        b N;
        synchronized (c.class) {
            N = amF().N(bundle);
        }
        return N;
    }

    public static synchronized boolean bJ(@NonNull String str, @NonNull String str2) {
        boolean a2;
        synchronized (c.class) {
            a2 = amF().a(mV(str), str2);
        }
        return a2;
    }

    public static synchronized boolean c(@NonNull Bundle bundle, @NonNull String str) {
        boolean a2;
        synchronized (c.class) {
            a2 = amF().a(M(bundle), str);
        }
        return a2;
    }

    private synchronized b mW(String str) {
        b N;
        N = N(null);
        a(N, str);
        D(UgcConstant.TOPIC, str + " session=" + N);
        return N;
    }

    private synchronized b N(Bundle bundle) {
        return f(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    private synchronized b f(String str, Bundle bundle) {
        b bVar;
        b bVar2 = TextUtils.isEmpty(str) ? null : this.ctD.get(str);
        if (bVar2 == null || !bVar2.valid()) {
            a(bVar2, new IllegalStateException("invalid session"));
            b bVar3 = new b(this, str);
            this.ctD.put(bVar3.amA(), bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        boolean z = bundle != null && a(bVar, bundle);
        if (z) {
            int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i)) {
                bVar.gd(i);
            } else if (SwanAppProcessInfo.SERVICE.index == i) {
                bVar.eG(true);
            }
        }
        bVar.bj(z ? bundle.getLong("ipc_session_timeout") : ctr);
        D("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.ctD) {
                bVar.r(exc);
                this.ctD.remove(bVar.amA());
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(@NonNull b bVar) {
        return mX(bVar.amA());
    }

    String mX(@NonNull String str) {
        return this.ctC.get(str);
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
            String amA = bVar.amA();
            String str2 = this.ctC.get(amA);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = !z2 || TextUtils.equals(str2, str);
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.ctC.put(amA, str);
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
                d.aoB().i(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(i.a aVar) {
        D("onCallOut", "msg=" + aVar);
        if (aVar != null) {
            M(aVar.toBundle()).amB();
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
