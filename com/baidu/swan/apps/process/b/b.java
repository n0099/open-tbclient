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
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c cIP;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cIQ = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> cIR = new HashSet();
    private final Set<String> cIS = new HashSet();
    private final Set<Integer> cIT = new HashSet();
    private Exception Qb = null;
    private long cIU = 0;
    private boolean cIV = false;
    private final Runnable cIW = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.axo();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cIP = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            E("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: axl */
    public b aqJ() {
        return this;
    }

    public String axm() {
        return this.mId;
    }

    public b axn() {
        return bA(cIO);
    }

    public b bA(long j) {
        b aqJ;
        synchronized (this.cIP) {
            if (DEBUG) {
                E(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long bB = bB(j);
                if (DEBUG) {
                    E(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bB);
                }
                com.baidu.swan.apps.process.messaging.a.axs().a(axp());
                arm();
            } else {
                this.cIP.a(this, new IllegalStateException("invalid session call"));
            }
            aqJ = aqJ();
        }
        return aqJ;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.cIP) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                E(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.Qb + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.Qb;
    }

    public boolean hasException() {
        return this.Qb != null;
    }

    public b fn(boolean z) {
        b aqJ;
        synchronized (this.cIP) {
            this.cIV = z;
            aqJ = aqJ();
        }
        return aqJ;
    }

    public b iG(int i) {
        b aqJ;
        synchronized (this.cIP) {
            this.cIT.add(Integer.valueOf(i));
            aqJ = aqJ();
        }
        return aqJ;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.cIR, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.cIQ, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.cIP) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.cIW);
                this.cIU = -1L;
                this.Qb = exc;
                this.cIQ.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.cIR) {
                    bVar.I(this);
                }
                this.cIR.clear();
                this.cIV = false;
                this.cIS.clear();
                this.cIT.clear();
                arm();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cIP) {
            z = (!valid() || this.cIQ.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.cIQ) {
                    bVar.I(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bB(long j) {
        long j2;
        synchronized (this.cIP) {
            if (valid()) {
                this.cIU = Math.max(Math.max(j, cIO), this.cIU);
                Handler mainHandler = d.getMainHandler();
                if (this.cIU > 0) {
                    mainHandler.removeCallbacks(this.cIW);
                    mainHandler.postDelayed(this.cIW, this.cIU);
                }
            }
            j2 = this.cIU;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cIU < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cIP) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axo() {
        synchronized (this.cIP) {
            this.cIP.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c axp() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cIU);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cIP.c(this));
        com.baidu.swan.apps.process.messaging.c fp = new com.baidu.swan.apps.process.messaging.c(axq(), bundle).fo(true).fp(!SwanAppProcessInfo.current().isSwanService || this.cIV);
        for (Integer num : this.cIT) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                fp.f(intValue);
            }
        }
        for (String str : this.cIS) {
            if (!TextUtils.isEmpty(str)) {
                fp.u(str);
            }
        }
        if (DEBUG) {
            E("createMsg", "msgCooker=" + fp + " bundle=" + bundle);
        }
        return fp;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cIU;
    }

    private int axq() {
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
