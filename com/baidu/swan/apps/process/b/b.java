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
    private final c cAG;
    private final String mId;
    private final Set<com.baidu.swan.apps.aq.e.b<i.a>> cAH = new HashSet();
    private final Set<com.baidu.swan.apps.aq.e.b<b>> cAI = new HashSet();
    private final Set<String> cAJ = new HashSet();
    private final Set<Integer> cAK = new HashSet();
    private Exception Pr = null;
    private long cAL = 0;
    private boolean cAM = false;
    private final Runnable cAN = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.aps();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.cAG = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        C("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.d
    /* renamed from: app */
    public b ajc() {
        return this;
    }

    public String apq() {
        return this.mId;
    }

    public b apr() {
        return bt(cAF);
    }

    public b bt(long j) {
        b ajc;
        synchronized (this.cAG) {
            C(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            if (valid()) {
                C(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + bu(j));
                com.baidu.swan.apps.process.messaging.a.apw().a(apt());
                ajF();
            } else {
                this.cAG.a(this, new IllegalStateException("invalid session call"));
            }
            ajc = ajc();
        }
        return ajc;
    }

    public boolean valid() {
        boolean z = (isFinished() || hasException() || TextUtils.isEmpty(this.mId)) ? false : true;
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.Pr + " id=" + this.mId);
            }
        } else {
            C(CloudControlUBCUtils.KEY_VALID, z + " isFinished=" + isFinished() + " hasException=" + this.Pr + " id=" + this.mId);
        }
        return z;
    }

    public Exception getException() {
        return this.Pr;
    }

    public boolean hasException() {
        return this.Pr != null;
    }

    public b eU(boolean z) {
        b ajc;
        synchronized (this.cAG) {
            this.cAM = z;
            ajc = ajc();
        }
        return ajc;
    }

    public b gA(int i) {
        b ajc;
        synchronized (this.cAG) {
            this.cAK.add(Integer.valueOf(i));
            ajc = ajc();
        }
        return ajc;
    }

    public b m(com.baidu.swan.apps.aq.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.aq.e.b<b>>>) this.cAI, (Set<com.baidu.swan.apps.aq.e.b<b>>) bVar);
    }

    public b n(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.aq.e.b<i.a>>>) this.cAH, (Set<com.baidu.swan.apps.aq.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b r(Exception exc) {
        synchronized (this.cAG) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.cAN);
                this.cAL = -1L;
                this.Pr = exc;
                this.cAH.clear();
                for (com.baidu.swan.apps.aq.e.b<b> bVar : this.cAI) {
                    bVar.H(this);
                }
                this.cAI.clear();
                this.cAM = false;
                this.cAJ.clear();
                this.cAK.clear();
                ajF();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.cAG) {
            z = (!valid() || this.cAH.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.aq.e.b<i.a> bVar : this.cAH) {
                    bVar.H(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long bu(long j) {
        long j2;
        synchronized (this.cAG) {
            if (valid()) {
                long j3 = j > cAF ? j : cAF;
                if (j3 <= this.cAL) {
                    j3 = this.cAL;
                }
                this.cAL = j3;
                Handler mainHandler = d.getMainHandler();
                if (this.cAL > 0) {
                    mainHandler.removeCallbacks(this.cAN);
                    mainHandler.postDelayed(this.cAN, this.cAL);
                }
            }
            j2 = this.cAL;
        }
        return j2;
    }

    boolean isFinished() {
        return this.cAL < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.cAG) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aps() {
        synchronized (this.cAG) {
            this.cAG.a(this, new TimeoutException());
        }
    }

    private com.baidu.swan.apps.process.messaging.c apt() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.cAL);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.cAG.c(this));
        com.baidu.swan.apps.process.messaging.c eW = new com.baidu.swan.apps.process.messaging.c(apu(), bundle).eV(true).eW(!SwanAppProcessInfo.current().isSwanService || this.cAM);
        for (Integer num : this.cAK) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                eW.e(intValue);
            }
        }
        for (String str : this.cAJ) {
            if (!TextUtils.isEmpty(str)) {
                eW.t(str);
            }
        }
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C("createMsg", "msgCooker=" + eW + " bundle=" + bundle);
            }
        } else {
            C("createMsg", "msgCooker=" + eW + " bundle=" + bundle);
        }
        return eW;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.cAL + super.toString();
    }

    private int apu() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i = z ? 111 : 11;
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                C("msgType", "service=" + z + " msgType=" + i);
            }
        } else {
            C("msgType", "service=" + z + " msgType=" + i);
        }
        return i;
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    private void C(String str, String str2) {
        log(str + ": " + str2);
    }
}
