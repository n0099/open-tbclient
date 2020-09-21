package com.baidu.swan.apps.process.b;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.i;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c cKT;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cKU = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> cKV = new HashSet();
    private final Set<String> cKW = new HashSet();
    private final Set<Integer> cKX = new HashSet();
    private Exception Qt = null;
    private long cKY = 0;
    private boolean cKZ = false;
    private final Runnable cLa = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.axX();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cKT = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            E("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: axU */
    public b art() {
        return this;
    }

    public String axV() {
        return this.mId;
    }

    public b axW() {
        return bB(cKS);
    }

    public b bB(long j) {
        b art;
        synchronized (this.cKT) {
            if (DEBUG) {
                E(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long bC = bC(j);
                if (DEBUG) {
                    E(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bC);
                }
                com.baidu.swan.apps.process.messaging.a.ayb().a(axY());
                arW();
            } else {
                this.cKT.a(this, new IllegalStateException("invalid session call"));
            }
            art = art();
        }
        return art;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.cKT) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                E(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.Qt + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.Qt;
    }

    public boolean hasException() {
        return this.Qt != null;
    }

    public b fm(boolean z) {
        b art;
        synchronized (this.cKT) {
            this.cKZ = z;
            art = art();
        }
        return art;
    }

    public b iQ(int i) {
        b art;
        synchronized (this.cKT) {
            this.cKX.add(Integer.valueOf(i));
            art = art();
        }
        return art;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.cKV, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.cKU, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.cKT) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.cLa);
                this.cKY = -1L;
                this.Qt = exc;
                this.cKU.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.cKV) {
                    bVar.J(this);
                }
                this.cKV.clear();
                this.cKZ = false;
                this.cKW.clear();
                this.cKX.clear();
                arW();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cKT) {
            z = (!valid() || this.cKU.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.cKU) {
                    bVar.J(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bC(long j) {
        long j2;
        synchronized (this.cKT) {
            if (valid()) {
                this.cKY = Math.max(Math.max(j, cKS), this.cKY);
                Handler mainHandler = d.getMainHandler();
                if (this.cKY > 0) {
                    mainHandler.removeCallbacks(this.cLa);
                    mainHandler.postDelayed(this.cLa, this.cKY);
                }
            }
            j2 = this.cKY;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cKY < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cKT) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axX() {
        synchronized (this.cKT) {
            this.cKT.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c axY() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cKY);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cKT.c(this));
        com.baidu.swan.apps.process.messaging.c fo = new com.baidu.swan.apps.process.messaging.c(axZ(), bundle).fn(true).fo(!SwanAppProcessInfo.current().isSwanService || this.cKZ);
        for (Integer num : this.cKX) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                fo.f(intValue);
            }
        }
        for (String str : this.cKW) {
            if (!TextUtils.isEmpty(str)) {
                fo.u(str);
            }
        }
        if (DEBUG) {
            E("createMsg", "msgCooker=" + fo + " bundle=" + bundle);
        }
        return fo;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cKY;
    }

    private int axZ() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i = z ? 111 : 11;
        if (DEBUG) {
            E("msgType", "service=" + z + " msgType=" + i);
        }
        return i;
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void E(String str, String str2) {
        log(str + ": " + str2);
    }
}
