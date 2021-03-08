package com.baidu.swan.apps.process.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.h;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class c extends m implements com.baidu.swan.apps.process.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, String> duR;
    private final HashMap<String, b> duS;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        static c duU = new c(d.aIJ());
    }

    private static c aFB() {
        return a.duU;
    }

    public c(h hVar) {
        super(hVar);
        this.duR = new HashMap<>();
        this.duS = new HashMap<>();
        if (DEBUG) {
            log("SwanIpc");
        }
        v(new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                if (c.DEBUG) {
                    c.this.log("onEventCallback msg" + aVar);
                }
                c.this.g(aVar);
            }
        }, "event_messenger_call_out").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.process.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                if (c.DEBUG) {
                    c.this.log("onEventCallback msg" + aVar);
                }
                c.this.f(aVar);
            }
        }, "event_messenger_call_in"));
    }

    public static void init() {
        aFB();
    }

    public static synchronized b rc(@NonNull String str) {
        b re;
        synchronized (c.class) {
            re = aFB().re(str);
        }
        return re;
    }

    public static synchronized b rd(@NonNull String str) {
        b f;
        synchronized (c.class) {
            f = aFB().f(str, null);
        }
        return f;
    }

    public static synchronized b L(@NonNull Bundle bundle) {
        b M;
        synchronized (c.class) {
            M = aFB().M(bundle);
        }
        return M;
    }

    public static synchronized boolean cm(@NonNull String str, @NonNull String str2) {
        boolean a2;
        synchronized (c.class) {
            a2 = aFB().a(rd(str), str2);
        }
        return a2;
    }

    public static synchronized boolean d(@NonNull Bundle bundle, @NonNull String str) {
        boolean a2;
        synchronized (c.class) {
            a2 = aFB().a(L(bundle), str);
        }
        return a2;
    }

    private synchronized b re(String str) {
        b M;
        M = M(null);
        a(M, str);
        if (DEBUG) {
            B(AlbumActivityConfig.FROM_TOPIC, str + " session=" + M);
        }
        return M;
    }

    private synchronized b M(Bundle bundle) {
        return f(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    private synchronized b f(String str, Bundle bundle) {
        b bVar;
        b bVar2 = TextUtils.isEmpty(str) ? null : this.duS.get(str);
        if (bVar2 == null || !bVar2.valid()) {
            a(bVar2, new IllegalStateException("invalid session"));
            b bVar3 = new b(this, str);
            this.duS.put(bVar3.id(), bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        boolean z = bundle != null && a(bVar, bundle);
        if (z) {
            int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i)) {
                bVar.iv(i);
            } else if (SwanAppProcessInfo.SERVICE.index == i) {
                bVar.gD(true);
            }
        }
        bVar.cO(z ? bundle.getLong("ipc_session_timeout") : duH);
        if (DEBUG) {
            B("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.duS) {
                bVar.v(exc);
                this.duS.remove(bVar.id());
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(@NonNull b bVar) {
        return rf(bVar.id());
    }

    String rf(@NonNull String str) {
        return this.duR.get(str);
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
            String str2 = this.duR.get(id);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = !z2 || TextUtils.equals(str2, str);
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.duR.put(id, str);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(i.a aVar) {
        if (DEBUG) {
            B("onCallIn", "msg=" + aVar);
        }
        if (aVar != null) {
            Bundle bundle = aVar.toBundle();
            i.a aVar2 = new i.a("event_messenger_call", bundle);
            b L = L(bundle);
            if (!a(L, bundle) || !L.e(aVar2)) {
                d.aIJ().i(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(i.a aVar) {
        if (DEBUG) {
            B("onCallOut", "msg=" + aVar);
        }
        if (aVar != null) {
            L(aVar.toBundle()).aFy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void B(String str, String str2) {
        log(str + ": " + str2);
    }
}
