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
    private final c dfx;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dfy = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> dfz = new HashSet();
    private final Set<String> dfA = new HashSet();
    private final Set<Integer> dfB = new HashSet();
    private Exception QL = null;
    private long dfC = 0;
    private boolean dfD = false;
    private final Runnable dfE = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.Kr();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.dfx = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            E("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: aCz */
    public b avZ() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aCA() {
        return bL(dfw);
    }

    public b bL(long j) {
        b avZ;
        synchronized (this.dfx) {
            if (DEBUG) {
                E(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long bM = bM(j);
                if (DEBUG) {
                    E(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bM);
                }
                com.baidu.swan.apps.process.messaging.a.aCE().a(aCB());
                awC();
            } else {
                this.dfx.a(this, new IllegalStateException("invalid session call"));
            }
            avZ = avZ();
        }
        return avZ;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.dfx) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                E(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.QL + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.QL;
    }

    public boolean hasException() {
        return this.QL != null;
    }

    public b fV(boolean z) {
        b avZ;
        synchronized (this.dfx) {
            this.dfD = z;
            avZ = avZ();
        }
        return avZ;
    }

    public b jy(int i) {
        b avZ;
        synchronized (this.dfx) {
            this.dfB.add(Integer.valueOf(i));
            avZ = avZ();
        }
        return avZ;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.dfz, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.dfy, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.dfx) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.dfE);
                this.dfC = -1L;
                this.QL = exc;
                this.dfy.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.dfz) {
                    bVar.M(this);
                }
                this.dfz.clear();
                this.dfD = false;
                this.dfA.clear();
                this.dfB.clear();
                awC();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.dfx) {
            z = (!valid() || this.dfy.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.dfy) {
                    bVar.M(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bM(long j) {
        long j2;
        synchronized (this.dfx) {
            if (valid()) {
                this.dfC = Math.max(Math.max(j, dfw), this.dfC);
                Handler mainHandler = d.getMainHandler();
                if (this.dfC > 0) {
                    mainHandler.removeCallbacks(this.dfE);
                    mainHandler.postDelayed(this.dfE, this.dfC);
                }
            }
            j2 = this.dfC;
        }
        return j2;
    }

    boolean isFinished() {
        return this.dfC < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.dfx) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr() {
        synchronized (this.dfx) {
            this.dfx.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aCB() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.dfC);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.dfx.c(this));
        com.baidu.swan.apps.process.messaging.c fX = new com.baidu.swan.apps.process.messaging.c(aCC(), bundle).fW(true).fX(!SwanAppProcessInfo.current().isSwanService || this.dfD);
        for (Integer num : this.dfB) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                fX.f(intValue);
            }
        }
        for (String str : this.dfA) {
            if (!TextUtils.isEmpty(str)) {
                fX.w(str);
            }
        }
        if (DEBUG) {
            E("createMsg", "msgCooker=" + fX + " bundle=" + bundle);
        }
        return fX;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.dfC;
    }

    private int aCC() {
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
