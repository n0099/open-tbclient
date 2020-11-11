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
    private final c dls;
    private final String mId;
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dlt = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<b>> dlu = new HashSet();
    private final Set<String> dlv = new HashSet();
    private final Set<Integer> dlw = new HashSet();
    private Exception QL = null;
    private long dlx = 0;
    private boolean dly = false;
    private final Runnable dlz = new Runnable() { // from class: com.baidu.swan.apps.process.b.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.KR();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull c cVar, String str) {
        this.dls = cVar;
        this.mId = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (DEBUG) {
            E("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.mId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.d
    /* renamed from: aEZ */
    public b ayz() {
        return this;
    }

    public String id() {
        return this.mId;
    }

    public b aFa() {
        return ch(dlr);
    }

    public b ch(long j) {
        b ayz;
        synchronized (this.dls) {
            if (DEBUG) {
                E(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (valid()) {
                long ci = ci(j);
                if (DEBUG) {
                    E(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + ci);
                }
                com.baidu.swan.apps.process.messaging.a.aFe().a(aFb());
                azc();
            } else {
                this.dls.a(this, new IllegalStateException("invalid session call"));
            }
            ayz = ayz();
        }
        return ayz;
    }

    public boolean valid() {
        boolean z;
        synchronized (this.dls) {
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

    public b ge(boolean z) {
        b ayz;
        synchronized (this.dls) {
            this.dly = z;
            ayz = ayz();
        }
        return ayz;
    }

    public b jI(int i) {
        b ayz;
        synchronized (this.dls) {
            this.dlw.add(Integer.valueOf(i));
            ayz = ayz();
        }
        return ayz;
    }

    public b t(com.baidu.swan.apps.ap.e.b<b> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<b>>>) this.dlu, (Set<com.baidu.swan.apps.ap.e.b<b>>) bVar);
    }

    public b u(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        return a((Set<Set<com.baidu.swan.apps.ap.e.b<i.a>>>) this.dlt, (Set<com.baidu.swan.apps.ap.e.b<i.a>>) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b u(Exception exc) {
        synchronized (this.dls) {
            if (!isFinished()) {
                d.getMainHandler().removeCallbacks(this.dlz);
                this.dlx = -1L;
                this.QL = exc;
                this.dlt.clear();
                for (com.baidu.swan.apps.ap.e.b<b> bVar : this.dlu) {
                    bVar.M(this);
                }
                this.dlu.clear();
                this.dly = false;
                this.dlv.clear();
                this.dlw.clear();
                azc();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(i.a aVar) {
        boolean z;
        synchronized (this.dls) {
            z = (!valid() || this.dlt.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (com.baidu.swan.apps.ap.e.b<i.a> bVar : this.dlt) {
                    bVar.M(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ci(long j) {
        long j2;
        synchronized (this.dls) {
            if (valid()) {
                this.dlx = Math.max(Math.max(j, dlr), this.dlx);
                Handler mainHandler = d.getMainHandler();
                if (this.dlx > 0) {
                    mainHandler.removeCallbacks(this.dlz);
                    mainHandler.postDelayed(this.dlz, this.dlx);
                }
            }
            j2 = this.dlx;
        }
        return j2;
    }

    boolean isFinished() {
        return this.dlx < 0;
    }

    private <CallBackT> b a(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.dls) {
            if (valid() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KR() {
        synchronized (this.dls) {
            this.dls.a(this, new TimeoutException("timeout"));
        }
    }

    private com.baidu.swan.apps.process.messaging.c aFb() {
        Bundle bundle = toBundle();
        bundle.putString("ipc_session_id", this.mId);
        bundle.putLong("ipc_session_timeout", this.dlx);
        bundle.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        bundle.putString("ipc_topic", this.dls.c(this));
        com.baidu.swan.apps.process.messaging.c gg = new com.baidu.swan.apps.process.messaging.c(aFc(), bundle).gf(true).gg(!SwanAppProcessInfo.current().isSwanService || this.dly);
        for (Integer num : this.dlw) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                gg.f(intValue);
            }
        }
        for (String str : this.dlv) {
            if (!TextUtils.isEmpty(str)) {
                gg.w(str);
            }
        }
        if (DEBUG) {
            E("createMsg", "msgCooker=" + gg + " bundle=" + bundle);
        }
        return gg;
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.mId + " timeout=" + this.dlx;
    }

    private int aFc() {
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
