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
/* loaded from: classes7.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c djL;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> djM = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> djN = new HashSet();
    private final Set<String> djO = new HashSet();
    private final Set<Integer> djP = new HashSet();
    private Exception QM = null;
    private long djQ = 0;
    private boolean djR = false;
    private final Runnable djS = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.Ki();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.djL = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            D("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: aEr */
    public b axR() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aEs() {
        return ch(djK);
    }

    public b ch(long j) {
        b axR;
        synchronized (this.djL) {
            if (DEBUG) {
                D(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long ci = ci(j);
                if (DEBUG) {
                    D(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + ci);
                }
                com.baidu.swan.apps.process.messaging.a.aEw().a(aEt());
                ayu();
            } else {
                this.djL.a(this, new IllegalStateException("invalid session call"));
            }
            axR = axR();
        }
        return axR;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.djL) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                D(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.QM + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.QM;
    }

    public boolean hasException() {
        return this.QM != null;
    }

    public b gh(boolean z) {
        b axR;
        synchronized (this.djL) {
            this.djR = z;
            axR = axR();
        }
        return axR;
    }

    public b jE(int i) {
        b axR;
        synchronized (this.djL) {
            this.djP.add(Integer.valueOf(i));
            axR = axR();
        }
        return axR;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.djN, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.djM, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.djL) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.djS);
                this.djQ = -1L;
                this.QM = exc;
                this.djM.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.djN) {
                    bVar.M(this);
                }
                this.djN.clear();
                this.djR = false;
                this.djO.clear();
                this.djP.clear();
                ayu();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.djL) {
            z = (!valid() || this.djM.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.djM) {
                    bVar.M(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ci(long j) {
        long j2;
        synchronized (this.djL) {
            if (valid()) {
                this.djQ = Math.max(Math.max(j, djK), this.djQ);
                Handler mainHandler = d.getMainHandler();
                if (this.djQ > 0) {
                    mainHandler.removeCallbacks(this.djS);
                    mainHandler.postDelayed(this.djS, this.djQ);
                }
            }
            j2 = this.djQ;
        }
        return j2;
    }

    boolean isFinished() {
        return this.djQ < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.djL) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        synchronized (this.djL) {
            this.djL.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aEt() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.djQ);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.djL.c(this));
        com.baidu.swan.apps.process.messaging.c gj = new com.baidu.swan.apps.process.messaging.c(aEu(), bundle).gi(true).gj(!SwanAppProcessInfo.current().isSwanService || this.djR);
        for (Integer num : this.djP) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gj.f(intValue);
            }
        }
        for (String str : this.djO) {
            if (!TextUtils.isEmpty(str)) {
                gj.w(str);
            }
        }
        if (DEBUG) {
            D("createMsg", "msgCooker=" + gj + " bundle=" + bundle);
        }
        return gj;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.djQ;
    }

    private int aEu() {
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
