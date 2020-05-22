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
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.v.b.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c cts;
    private final String mId;
    private final Set<com.baidu.swan.apps.aq.e.b<i.a>> ctt = new HashSet();
    private final Set<com.baidu.swan.apps.aq.e.b<b>> ctu = new HashSet();
    private final Set<String> ctv = new HashSet();
    private final Set<Integer> ctw = new HashSet();
    private Exception OP = null;
    private long cty = 0;
    private boolean ctz = false;
    private final Runnable ctA = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.amC();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cts = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        D("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.d
    /* renamed from: amz */
    public b agG() {
        return this;
    }

    public String amA() {
        return this.mId;
    }

    public b amB() {
        return bi(ctr);
    }

    public b bi(long j) {
        b agG;
        synchronized (this.cts) {
            D(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            if (valid()) {
                D(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bj(j));
                com.baidu.swan.apps.process.messaging.a.amG().a(amD());
                ahi();
            } else {
                this.cts.a(this, new IllegalStateException("invalid session call"));
            }
            agG = agG();
        }
        return agG;
    }

    public boolean valid() {
        boolean z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
        D(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.OP + " id=" + this.mId);
        return z;
    }

    public Exception getException() {
        return this.OP;
    }

    public boolean hasException() {
        return this.OP != null;
    }

    public b eG(boolean z) {
        b agG;
        synchronized (this.cts) {
            this.ctz = z;
            agG = agG();
        }
        return agG;
    }

    public b gd(int i) {
        b agG;
        synchronized (this.cts) {
            this.ctw.add(Integer.valueOf(i));
            agG = agG();
        }
        return agG;
    }

    public b l(com.baidu.swan.apps.aq.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.aq.e.b<b>>>) this.ctu, (Set<com.baidu.swan.apps.aq.e.b<b>>) bVar);
    }

    public b m(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.aq.e.b<i.a>>>) this.ctt, (Set<com.baidu.swan.apps.aq.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b r(Exception exc) {
        synchronized (this.cts) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.ctA);
                this.cty = -1L;
                this.OP = exc;
                this.ctt.clear();
                for (com.baidu.swan.apps.aq.e.b<b> bVar : this.ctu) {
                    bVar.H(this);
                }
                this.ctu.clear();
                this.ctz = false;
                this.ctv.clear();
                this.ctw.clear();
                ahi();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cts) {
            z = (!valid() || this.ctt.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.aq.e.b<i.a> bVar : this.ctt) {
                    bVar.H(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bj(long j) {
        long j2;
        synchronized (this.cts) {
            if (valid()) {
                long j3 = j > ctr ? j : ctr;
                if (j3 <= this.cty) {
                    j3 = this.cty;
                }
                this.cty = j3;
                Handler mainHandler = d.getMainHandler();
                if (this.cty > 0) {
                    mainHandler.removeCallbacks(this.ctA);
                    mainHandler.postDelayed(this.ctA, this.cty);
                }
            }
            j2 = this.cty;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cty < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cts) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amC() {
        synchronized (this.cts) {
            this.cts.a(this, new TimeoutException());
        }
    }

    private com.baidu.swan.apps.process.messaging.c amD() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cty);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cts.c(this));
        com.baidu.swan.apps.process.messaging.c eI = new com.baidu.swan.apps.process.messaging.c(amE(), bundle).eH(true).eI(!SwanAppProcessInfo.current().isSwanService || this.ctz);
        for (Integer num : this.ctw) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                eI.e(intValue);
            }
        }
        for (String str : this.ctv) {
            if (!TextUtils.isEmpty(str)) {
                eI.u(str);
            }
        }
        D("createMsg", "msgCooker=" + eI + " bundle=" + bundle);
        return eI;
    }

    @Override // com.baidu.swan.apps.v.b.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cty + super.toString();
    }

    private int amE() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i = z ? 111 : 11;
        D("msgType", "service=" + z + " msgType=" + i);
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
