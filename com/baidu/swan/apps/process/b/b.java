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
    private final c cyg;
    private final String mId;
    private final Set<com.baidu.swan.apps.aq.e.b<i.a>> cyh = new HashSet();
    private final Set<com.baidu.swan.apps.aq.e.b<b>> cyi = new HashSet();
    private final Set<String> cyj = new HashSet();
    private final Set<Integer> cyk = new HashSet();
    private Exception Pr = null;
    private long cyl = 0;
    private boolean cym = false;
    private final Runnable cyn = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.anI();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cyg = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        D("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.d
    /* renamed from: anF */
    public b ahM() {
        return this;
    }

    public String anG() {
        return this.mId;
    }

    public b anH() {
        return bi(cyf);
    }

    public b bi(long j) {
        b ahM;
        synchronized (this.cyg) {
            D(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            if (valid()) {
                D(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bj(j));
                com.baidu.swan.apps.process.messaging.a.anM().a(anJ());
                aio();
            } else {
                this.cyg.a(this, new IllegalStateException("invalid session call"));
            }
            ahM = ahM();
        }
        return ahM;
    }

    public boolean valid() {
        boolean z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
        D(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.Pr + " id=" + this.mId);
        return z;
    }

    public Exception getException() {
        return this.Pr;
    }

    public boolean hasException() {
        return this.Pr != null;
    }

    public b eL(boolean z) {
        b ahM;
        synchronized (this.cyg) {
            this.cym = z;
            ahM = ahM();
        }
        return ahM;
    }

    public b gr(int i) {
        b ahM;
        synchronized (this.cyg) {
            this.cyk.add(Integer.valueOf(i));
            ahM = ahM();
        }
        return ahM;
    }

    public b l(com.baidu.swan.apps.aq.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.aq.e.b<b>>>) this.cyi, (Set<com.baidu.swan.apps.aq.e.b<b>>) bVar);
    }

    public b m(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.aq.e.b<i.a>>>) this.cyh, (Set<com.baidu.swan.apps.aq.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b r(Exception exc) {
        synchronized (this.cyg) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.cyn);
                this.cyl = -1L;
                this.Pr = exc;
                this.cyh.clear();
                for (com.baidu.swan.apps.aq.e.b<b> bVar : this.cyi) {
                    bVar.H(this);
                }
                this.cyi.clear();
                this.cym = false;
                this.cyj.clear();
                this.cyk.clear();
                aio();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cyg) {
            z = (!valid() || this.cyh.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.aq.e.b<i.a> bVar : this.cyh) {
                    bVar.H(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bj(long j) {
        long j2;
        synchronized (this.cyg) {
            if (valid()) {
                long j3 = j > cyf ? j : cyf;
                if (j3 <= this.cyl) {
                    j3 = this.cyl;
                }
                this.cyl = j3;
                Handler mainHandler = d.getMainHandler();
                if (this.cyl > 0) {
                    mainHandler.removeCallbacks(this.cyn);
                    mainHandler.postDelayed(this.cyn, this.cyl);
                }
            }
            j2 = this.cyl;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cyl < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cyg) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anI() {
        synchronized (this.cyg) {
            this.cyg.a(this, new TimeoutException());
        }
    }

    private com.baidu.swan.apps.process.messaging.c anJ() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cyl);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cyg.c(this));
        com.baidu.swan.apps.process.messaging.c eN = new com.baidu.swan.apps.process.messaging.c(anK(), bundle).eM(true).eN(!SwanAppProcessInfo.current().isSwanService || this.cym);
        for (Integer num : this.cyk) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                eN.e(intValue);
            }
        }
        for (String str : this.cyj) {
            if (!TextUtils.isEmpty(str)) {
                eN.t(str);
            }
        }
        D("createMsg", "msgCooker=" + eN + " bundle=" + bundle);
        return eN;
    }

    @Override // com.baidu.swan.apps.v.b.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cyl + super.toString();
    }

    private int anK() {
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
