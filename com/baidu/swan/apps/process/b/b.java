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
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c cWW;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cWX = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> cWY = new HashSet();
    private final Set<String> cWZ = new HashSet();
    private final Set<Integer> cXa = new HashSet();
    private Exception QK = null;
    private long cXb = 0;
    private boolean cXc = false;
    private final Runnable cXd = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.JX();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cWW = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            E("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: aAF */
    public b auf() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aAG() {
        return bJ(cWV);
    }

    public b bJ(long j) {
        b auf;
        synchronized (this.cWW) {
            if (DEBUG) {
                E(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long bK = bK(j);
                if (DEBUG) {
                    E(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bK);
                }
                com.baidu.swan.apps.process.messaging.a.aAK().a(aAH());
                auI();
            } else {
                this.cWW.a(this, new IllegalStateException("invalid session call"));
            }
            auf = auf();
        }
        return auf;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.cWW) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                E(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.QK + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.QK;
    }

    public boolean hasException() {
        return this.QK != null;
    }

    public b fI(boolean z) {
        b auf;
        synchronized (this.cWW) {
            this.cXc = z;
            auf = auf();
        }
        return auf;
    }

    public b jn(int i) {
        b auf;
        synchronized (this.cWW) {
            this.cXa.add(Integer.valueOf(i));
            auf = auf();
        }
        return auf;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.cWY, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.cWX, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.cWW) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.cXd);
                this.cXb = -1L;
                this.QK = exc;
                this.cWX.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.cWY) {
                    bVar.M(this);
                }
                this.cWY.clear();
                this.cXc = false;
                this.cWZ.clear();
                this.cXa.clear();
                auI();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cWW) {
            z = (!valid() || this.cWX.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.cWX) {
                    bVar.M(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bK(long j) {
        long j2;
        synchronized (this.cWW) {
            if (valid()) {
                this.cXb = Math.max(Math.max(j, cWV), this.cXb);
                Handler mainHandler = d.getMainHandler();
                if (this.cXb > 0) {
                    mainHandler.removeCallbacks(this.cXd);
                    mainHandler.postDelayed(this.cXd, this.cXb);
                }
            }
            j2 = this.cXb;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cXb < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cWW) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JX() {
        synchronized (this.cWW) {
            this.cWW.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aAH() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cXb);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cWW.c(this));
        com.baidu.swan.apps.process.messaging.c fK = new com.baidu.swan.apps.process.messaging.c(aAI(), bundle).fJ(true).fK(!SwanAppProcessInfo.current().isSwanService || this.cXc);
        for (Integer num : this.cXa) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                fK.f(intValue);
            }
        }
        for (String str : this.cWZ) {
            if (!TextUtils.isEmpty(str)) {
                fK.v(str);
            }
        }
        if (DEBUG) {
            E("createMsg", "msgCooker=" + fK + " bundle=" + bundle);
        }
        return fK;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cXb;
    }

    private int aAI() {
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
