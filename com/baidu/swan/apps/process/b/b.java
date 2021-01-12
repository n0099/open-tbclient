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
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.u.c.a.c<b> implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final c dqU;
    private final String mId;
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dqV = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<b>> dqW = new HashSet();
    private final Set<String> dqX = new HashSet();
    private final Set<Integer> dqY = new HashSet();
    private Exception RG = null;
    private long dqZ = 0;
    private boolean dra = false;
    private final Runnable drb = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.onTimeout();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.dqU = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            D("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.d
    /* renamed from: aEZ */
    public b ayy() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aFa() {
        return cH(dqT);
    }

    public b cH(long j) {
        b ayy;
        synchronized (this.dqU) {
            if (DEBUG) {
                D(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long cI = cI(j);
                if (DEBUG) {
                    D(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + cI);
                }
                com.baidu.swan.apps.process.messaging.a.aFe().a(aFb());
                azb();
            } else {
                this.dqU.a(this, new IllegalStateException("invalid session call"));
            }
            ayy = ayy();
        }
        return ayy;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.dqU) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                D(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.RG + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.RG;
    }

    public boolean hasException() {
        return this.RG != null;
    }

    public b gB(boolean z) {
        b ayy;
        synchronized (this.dqU) {
            this.dra = z;
            ayy = ayy();
        }
        return ayy;
    }

    public b ir(int i) {
        b ayy;
        synchronized (this.dqU) {
            this.dqY.add(Integer.valueOf(i));
            ayy = ayy();
        }
        return ayy;
    }

    public b t(com.baidu.swan.apps.ao.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<b>>>) this.dqW, (Set<com.baidu.swan.apps.ao.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<i.a>>>) this.dqV, (Set<com.baidu.swan.apps.ao.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b v(Exception exc) {
        synchronized (this.dqU) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.drb);
                this.dqZ = -1L;
                this.RG = exc;
                this.dqV.clear();
                for (com.baidu.swan.apps.ao.e.b<b> bVar : this.dqW) {
                    bVar.L(this);
                }
                this.dqW.clear();
                this.dra = false;
                this.dqX.clear();
                this.dqY.clear();
                azb();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.dqU) {
            z = (!valid() || this.dqV.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ao.e.b<i.a> bVar : this.dqV) {
                    bVar.L(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cI(long j) {
        long j2;
        synchronized (this.dqU) {
            if (valid()) {
                this.dqZ = Math.max(Math.max(j, dqT), this.dqZ);
                Handler mainHandler = d.getMainHandler();
                if (this.dqZ > 0) {
                    mainHandler.removeCallbacks(this.drb);
                    mainHandler.postDelayed(this.drb, this.dqZ);
                }
            }
            j2 = this.dqZ;
        }
        return j2;
    }

    boolean isFinished() {
        return this.dqZ < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.dqU) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeout() {
        synchronized (this.dqU) {
            this.dqU.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aFb() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.dqZ);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.dqU.c(this));
        com.baidu.swan.apps.process.messaging.c gD = new com.baidu.swan.apps.process.messaging.c(aFc(), bundle).gC(true).gD(!SwanAppProcessInfo.current().isSwanService || this.dra);
        for (Integer num : this.dqY) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gD.g(intValue);
            }
        }
        for (String str : this.dqX) {
            if (!TextUtils.isEmpty(str)) {
                gD.D(str);
            }
        }
        if (DEBUG) {
            D("createMsg", "msgCooker=" + gD + " bundle=" + bundle);
        }
        return gD;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.dqZ;
    }

    private int aFc() {
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
