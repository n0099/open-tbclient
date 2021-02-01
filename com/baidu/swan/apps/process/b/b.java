package com.baidu.swan.apps.process.b;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.i;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c dtg;
    private final String mId;
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dth = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<b>> dti = new HashSet();
    private final Set<String> dtj = new HashSet();
    private final Set<Integer> dtk = new HashSet();
    private Exception RE = null;
    private long dtl = 0;
    private boolean dtm = false;
    private final Runnable dtn = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.onTimeout();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.dtg = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            B("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.d
    /* renamed from: aFu */
    public b ayW() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aFv() {
        return cN(dtf);
    }

    public b cN(long j) {
        b ayW;
        synchronized (this.dtg) {
            if (DEBUG) {
                B(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long cO = cO(j);
                if (DEBUG) {
                    B(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + cO);
                }
                com.baidu.swan.apps.process.messaging.a.aFz().a(aFw());
                azz();
            } else {
                this.dtg.a(this, new IllegalStateException("invalid session call"));
            }
            ayW = ayW();
        }
        return ayW;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.dtg) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                B(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.RE + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.RE;
    }

    public boolean hasException() {
        return this.RE != null;
    }

    public b gD(boolean z) {
        b ayW;
        synchronized (this.dtg) {
            this.dtm = z;
            ayW = ayW();
        }
        return ayW;
    }

    public b iu(int i) {
        b ayW;
        synchronized (this.dtg) {
            this.dtk.add(Integer.valueOf(i));
            ayW = ayW();
        }
        return ayW;
    }

    public b t(com.baidu.swan.apps.ao.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<b>>>) this.dti, (Set<com.baidu.swan.apps.ao.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<i.a>>>) this.dth, (Set<com.baidu.swan.apps.ao.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b v(Exception exc) {
        synchronized (this.dtg) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.dtn);
                this.dtl = -1L;
                this.RE = exc;
                this.dth.clear();
                for (com.baidu.swan.apps.ao.e.b<b> bVar : this.dti) {
                    bVar.L(this);
                }
                this.dti.clear();
                this.dtm = false;
                this.dtj.clear();
                this.dtk.clear();
                azz();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.dtg) {
            z = (!valid() || this.dth.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ao.e.b<i.a> bVar : this.dth) {
                    bVar.L(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cO(long j) {
        long j2;
        synchronized (this.dtg) {
            if (valid()) {
                this.dtl = Math.max(Math.max(j, dtf), this.dtl);
                Handler mainHandler = d.getMainHandler();
                if (this.dtl > 0) {
                    mainHandler.removeCallbacks(this.dtn);
                    mainHandler.postDelayed(this.dtn, this.dtl);
                }
            }
            j2 = this.dtl;
        }
        return j2;
    }

    boolean isFinished() {
        return this.dtl < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.dtg) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeout() {
        synchronized (this.dtg) {
            this.dtg.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aFw() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.dtl);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.dtg.c(this));
        com.baidu.swan.apps.process.messaging.c gF = new com.baidu.swan.apps.process.messaging.c(aFx(), bundle).gE(true).gF(!SwanAppProcessInfo.current().isSwanService || this.dtm);
        for (Integer num : this.dtk) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gF.g(intValue);
            }
        }
        for (String str : this.dtj) {
            if (!TextUtils.isEmpty(str)) {
                gF.D(str);
            }
        }
        if (DEBUG) {
            B("createMsg", "msgCooker=" + gF + " bundle=" + bundle);
        }
        return gF;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.dtl;
    }

    private int aFx() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i = z ? 111 : 11;
        if (DEBUG) {
            B("msgType", "service=" + z + " msgType=" + i);
        }
        return i;
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void B(String str, String str2) {
        log(str + ": " + str2);
    }
}
