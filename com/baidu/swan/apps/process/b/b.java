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
/* loaded from: classes25.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c dqK;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dqL = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> dqM = new HashSet();
    private final Set<String> dqN = new HashSet();
    private final Set<Integer> dqO = new HashSet();
    private Exception RF = null;
    private long dqP = 0;
    private boolean dqQ = false;
    private final Runnable dqR = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.Mk();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.dqK = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            D("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: aHz */
    public b aBa() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aHA() {
        return cG(dqJ);
    }

    public b cG(long j) {
        b aBa;
        synchronized (this.dqK) {
            if (DEBUG) {
                D(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long cH = cH(j);
                if (DEBUG) {
                    D(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + cH);
                }
                com.baidu.swan.apps.process.messaging.a.aHE().a(aHB());
                aBD();
            } else {
                this.dqK.a(this, new IllegalStateException("invalid session call"));
            }
            aBa = aBa();
        }
        return aBa;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.dqK) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                D(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.RF + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.RF;
    }

    public boolean hasException() {
        return this.RF != null;
    }

    public b gw(boolean z) {
        b aBa;
        synchronized (this.dqK) {
            this.dqQ = z;
            aBa = aBa();
        }
        return aBa;
    }

    public b kc(int i) {
        b aBa;
        synchronized (this.dqK) {
            this.dqO.add(Integer.valueOf(i));
            aBa = aBa();
        }
        return aBa;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.dqM, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.dqL, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.dqK) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.dqR);
                this.dqP = -1L;
                this.RF = exc;
                this.dqL.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.dqM) {
                    bVar.M(this);
                }
                this.dqM.clear();
                this.dqQ = false;
                this.dqN.clear();
                this.dqO.clear();
                aBD();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.dqK) {
            z = (!valid() || this.dqL.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.dqL) {
                    bVar.M(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cH(long j) {
        long j2;
        synchronized (this.dqK) {
            if (valid()) {
                this.dqP = Math.max(Math.max(j, dqJ), this.dqP);
                Handler mainHandler = d.getMainHandler();
                if (this.dqP > 0) {
                    mainHandler.removeCallbacks(this.dqR);
                    mainHandler.postDelayed(this.dqR, this.dqP);
                }
            }
            j2 = this.dqP;
        }
        return j2;
    }

    boolean isFinished() {
        return this.dqP < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.dqK) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mk() {
        synchronized (this.dqK) {
            this.dqK.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aHB() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.dqP);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.dqK.c(this));
        com.baidu.swan.apps.process.messaging.c gy = new com.baidu.swan.apps.process.messaging.c(aHC(), bundle).gx(true).gy(!SwanAppProcessInfo.current().isSwanService || this.dqQ);
        for (Integer num : this.dqO) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gy.f(intValue);
            }
        }
        for (String str : this.dqN) {
            if (!TextUtils.isEmpty(str)) {
                gy.w(str);
            }
        }
        if (DEBUG) {
            D("createMsg", "msgCooker=" + gy + " bundle=" + bundle);
        }
        return gy;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.dqP;
    }

    private int aHC() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i = z ? 111 : 11;
        if (DEBUG) {
            D("msgType", "service=" + z + " msgType=" + i);
        }
        return i;
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void D(String str, String str2) {
        log(str + ": " + str2);
    }
}
