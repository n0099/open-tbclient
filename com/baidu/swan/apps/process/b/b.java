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
    private final c cIT;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cIU = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> cIV = new HashSet();
    private final Set<String> cIW = new HashSet();
    private final Set<Integer> cIX = new HashSet();
    private Exception Qb = null;
    private long cIY = 0;
    private boolean cIZ = false;
    private final Runnable cJa = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.axo();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cIT = cVar;
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
        return bA(cIS);
    }

    public b bA(long j) {
        b aqJ;
        synchronized (this.cIT) {
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
                this.cIT.a(this, new IllegalStateException("invalid session call"));
            }
            aqJ = aqJ();
        }
        return aqJ;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.cIT) {
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

    public b fo(boolean z) {
        b aqJ;
        synchronized (this.cIT) {
            this.cIZ = z;
            aqJ = aqJ();
        }
        return aqJ;
    }

    public b iG(int i) {
        b aqJ;
        synchronized (this.cIT) {
            this.cIX.add(Integer.valueOf(i));
            aqJ = aqJ();
        }
        return aqJ;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.cIV, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.cIU, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.cIT) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.cJa);
                this.cIY = -1L;
                this.Qb = exc;
                this.cIU.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.cIV) {
                    bVar.I(this);
                }
                this.cIV.clear();
                this.cIZ = false;
                this.cIW.clear();
                this.cIX.clear();
                arm();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cIT) {
            z = (!valid() || this.cIU.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.cIU) {
                    bVar.I(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bB(long j) {
        long j2;
        synchronized (this.cIT) {
            if (valid()) {
                this.cIY = Math.max(Math.max(j, cIS), this.cIY);
                Handler mainHandler = d.getMainHandler();
                if (this.cIY > 0) {
                    mainHandler.removeCallbacks(this.cJa);
                    mainHandler.postDelayed(this.cJa, this.cIY);
                }
            }
            j2 = this.cIY;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cIY < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cIT) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axo() {
        synchronized (this.cIT) {
            this.cIT.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c axp() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cIY);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cIT.c(this));
        com.baidu.swan.apps.process.messaging.c fq = new com.baidu.swan.apps.process.messaging.c(axq(), bundle).fp(true).fq(!SwanAppProcessInfo.current().isSwanService || this.cIZ);
        for (Integer num : this.cIX) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                fq.f(intValue);
            }
        }
        for (String str : this.cIW) {
            if (!TextUtils.isEmpty(str)) {
                fq.u(str);
            }
        }
        if (DEBUG) {
            E("createMsg", "msgCooker=" + fq + " bundle=" + bundle);
        }
        return fq;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cIY;
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
