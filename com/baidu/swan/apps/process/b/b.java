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
    private final c dvJ;
    private final String mId;
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dvK = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<b>> dvL = new HashSet();
    private final Set<String> dvM = new HashSet();
    private final Set<Integer> dvN = new HashSet();
    private Exception RI = null;
    private long dvO = 0;
    private boolean dvP = false;
    private final Runnable dvQ = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.onTimeout();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.dvJ = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            D("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.d
    /* renamed from: aIT */
    public b aCs() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aIU() {
        return cH(dvI);
    }

    public b cH(long j) {
        b aCs;
        synchronized (this.dvJ) {
            if (DEBUG) {
                D(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long cI = cI(j);
                if (DEBUG) {
                    D(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + cI);
                }
                com.baidu.swan.apps.process.messaging.a.aIY().a(aIV());
                aCV();
            } else {
                this.dvJ.a(this, new IllegalStateException("invalid session call"));
            }
            aCs = aCs();
        }
        return aCs;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.dvJ) {
            z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
            if (DEBUG) {
                D(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.RI + " id=" + this.mId);
            }
        }
        return z;
    }

    public Exception getException() {
        return this.RI;
    }

    public boolean hasException() {
        return this.RI != null;
    }

    public b gF(boolean z) {
        b aCs;
        synchronized (this.dvJ) {
            this.dvP = z;
            aCs = aCs();
        }
        return aCs;
    }

    public b jX(int i) {
        b aCs;
        synchronized (this.dvJ) {
            this.dvN.add(Integer.valueOf(i));
            aCs = aCs();
        }
        return aCs;
    }

    public b t(com.baidu.swan.apps.ao.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<b>>>) this.dvL, (Set<com.baidu.swan.apps.ao.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ao.e.b<i.a>>>) this.dvK, (Set<com.baidu.swan.apps.ao.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b v(Exception exc) {
        synchronized (this.dvJ) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.dvQ);
                this.dvO = -1L;
                this.RI = exc;
                this.dvK.clear();
                for (com.baidu.swan.apps.ao.e.b<b> bVar : this.dvL) {
                    bVar.L(this);
                }
                this.dvL.clear();
                this.dvP = false;
                this.dvM.clear();
                this.dvN.clear();
                aCV();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.dvJ) {
            z = (!valid() || this.dvK.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ao.e.b<i.a> bVar : this.dvK) {
                    bVar.L(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cI(long j) {
        long j2;
        synchronized (this.dvJ) {
            if (valid()) {
                this.dvO = Math.max(Math.max(j, dvI), this.dvO);
                Handler mainHandler = d.getMainHandler();
                if (this.dvO > 0) {
                    mainHandler.removeCallbacks(this.dvQ);
                    mainHandler.postDelayed(this.dvQ, this.dvO);
                }
            }
            j2 = this.dvO;
        }
        return j2;
    }

    boolean isFinished() {
        return this.dvO < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.dvJ) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeout() {
        synchronized (this.dvJ) {
            this.dvJ.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aIV() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.dvO);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.dvJ.c(this));
        com.baidu.swan.apps.process.messaging.c gH = new com.baidu.swan.apps.process.messaging.c(aIW(), bundle).gG(true).gH(!SwanAppProcessInfo.current().isSwanService || this.dvP);
        for (Integer num : this.dvN) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gH.g(intValue);
            }
        }
        for (String str : this.dvM) {
            if (!TextUtils.isEmpty(str)) {
                gH.D(str);
            }
        }
        if (DEBUG) {
            D("createMsg", "msgCooker=" + gH + " bundle=" + bundle);
        }
        return gH;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.dvO;
    }

    private int aIW() {
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
