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
    private final c duI;
    private final String mId;
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> duJ = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<b>> duK = new HashSet();
    private final Set<String> duL = new HashSet();
    private final Set<Integer> duM = new HashSet();
    private Exception Td = null;
    private long duN = 0;
    private boolean duO = false;
    private final Runnable duP = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.onTimeout();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.duI = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            B("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.d
    /* renamed from: aFx */
    public b ayZ() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aFy() {
        return cN(duH);
    }

    public b cN(long j) {
        b ayZ;
        synchronized (this.duI) {
            if (DEBUG) {
                B(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long cO = cO(j);
                if (DEBUG) {
                    B(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + cO);
                }
                com.baidu.swan.apps.process.messaging.a.aFC().a(aFz());
                azC();
            } else {
                this.duI.a(this, new IllegalStateException("invalid session call"));
            }
            ayZ = ayZ();
        }
        return ayZ;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.duI) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                B(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.Td + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.Td;
    }

    public boolean hasException() {
        return this.Td != null;
    }

    public b gD(boolean z) {
        b ayZ;
        synchronized (this.duI) {
            this.duO = z;
            ayZ = ayZ();
        }
        return ayZ;
    }

    public b iv(int i) {
        b ayZ;
        synchronized (this.duI) {
            this.duM.add(Integer.valueOf(i));
            ayZ = ayZ();
        }
        return ayZ;
    }

    public b t(com.baidu.swan.apps.ao.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<b>>>) this.duK, (Set<com.baidu.swan.apps.ao.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<i.a>>>) this.duJ, (Set<com.baidu.swan.apps.ao.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b v(Exception exc) {
        synchronized (this.duI) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.duP);
                this.duN = -1L;
                this.Td = exc;
                this.duJ.clear();
                for (com.baidu.swan.apps.ao.e.b<b> bVar : this.duK) {
                    bVar.N(this);
                }
                this.duK.clear();
                this.duO = false;
                this.duL.clear();
                this.duM.clear();
                azC();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.duI) {
            z = (!valid() || this.duJ.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ao.e.b<i.a> bVar : this.duJ) {
                    bVar.N(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cO(long j) {
        long j2;
        synchronized (this.duI) {
            if (valid()) {
                this.duN = Math.max(Math.max(j, duH), this.duN);
                Handler mainHandler = d.getMainHandler();
                if (this.duN > 0) {
                    mainHandler.removeCallbacks(this.duP);
                    mainHandler.postDelayed(this.duP, this.duN);
                }
            }
            j2 = this.duN;
        }
        return j2;
    }

    boolean isFinished() {
        return this.duN < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.duI) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeout() {
        synchronized (this.duI) {
            this.duI.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aFz() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.duN);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.duI.c(this));
        com.baidu.swan.apps.process.messaging.c gF = new com.baidu.swan.apps.process.messaging.c(aFA(), bundle).gE(true).gF(!SwanAppProcessInfo.current().isSwanService || this.duO);
        for (Integer num : this.duM) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gF.g(intValue);
            }
        }
        for (String str : this.duL) {
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
        return "IpcSession: id=" + this.mId + " timeout=" + this.duN;
    }

    private int aFA() {
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
