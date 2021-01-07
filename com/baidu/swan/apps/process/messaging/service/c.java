package com.baidu.swan.apps.process.messaging.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    private b dwA;
    private final Deque<Message> dwB;
    private a dwC;
    private long dwD;
    public final SwanAppProcessInfo dwt;
    private SwanAppCores dwu;
    public PrefetchEvent dwv;
    private boolean dww;
    private long dwx;
    private long dwy;
    private boolean dwz;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes9.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.dww = true;
        this.dwx = 0L;
        this.dwy = 0L;
        this.dwz = false;
        this.dwB = new ArrayDeque();
        this.dwD = -1L;
        this.dwt = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aJv() {
        return this.dwt;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aJw() {
        return this.dwz;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aJx() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aJy() {
        return this.dwu;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.dwu = swanAppCores;
        }
        return this;
    }

    public boolean aJz() {
        return aJA();
    }

    public boolean aJA() {
        boolean z;
        synchronized (this.dwt) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aJB() {
        return this.dww;
    }

    public void aJC() {
        this.dwx = System.currentTimeMillis();
    }

    public boolean aJD() {
        return System.currentTimeMillis() - this.dwx < ((long) com.baidu.swan.apps.performance.b.c.aHW());
    }

    public long aJE() {
        return System.currentTimeMillis() - this.dwx;
    }

    public void a(a aVar) {
        this.dwC = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.dwv = prefetchEvent;
    }

    public c aJF() {
        synchronized (this.dwt) {
            aJJ();
            this.mMessenger = null;
            this.dwu = null;
            g(null);
            aJL();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aJM().sc("b4 preload: " + this.dwt);
        }
        a(true, context, bundle);
        return this;
    }

    public c aJG() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aJM().sc("b4 tryPreBind: " + this.dwt);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.aAs();
        }
        Intent intent = new Intent(context, this.dwt.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.dwy = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.dwt) {
            try {
                if (this.dwA == null) {
                    this.dwA = new b();
                    context.bindService(intent, this.dwA, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aJH();
            }
        }
        return this;
    }

    c aJH() {
        log("flushCachedMsgs");
        synchronized (this.dwt) {
            while (this.mMessenger != null && !this.dwB.isEmpty()) {
                Message peek = this.dwB.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aJM().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.dwB.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.dwt) {
            if (message != null) {
                if (aJz()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aJn();
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean L(Message message) {
        this.dwB.offer(message);
        aJH();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.dwB.offer(message);
        }
        aJH();
        return true;
    }

    public c rW(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aJM().aJN().c("event_puppet_load_app", this);
            this.dww = true;
        } else {
            this.dww = false;
        }
        return this;
    }

    public c aJI() {
        aJJ();
        e.aJM().aJN().c("event_puppet_unload_app", this);
        return this;
    }

    public c aJJ() {
        this.mAppId = "";
        g(null);
        this.dwD = -1L;
        return this;
    }

    public c aJK() {
        this.dwz = true;
        this.dwy = 0L;
        if (this.dwC != null) {
            this.dwC.b(this);
        }
        return this;
    }

    public c aJL() {
        this.dwz = false;
        this.dwy = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.dwt.toString();
        objArr[1] = Integer.valueOf(aJz() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.dwz ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.dwy));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            rW(string);
            e.aJM().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aIY().rT(string);
            aJL();
        }
        return aJG();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c cK(long j) {
        if (j > 0) {
            this.dwD = j;
            e.aJM().aJN().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJn() {
        synchronized (this.dwt) {
            this.mMessenger = null;
            this.dwA = null;
            aJF();
            e aJM = e.aJM();
            aJM.aJN().c("event_puppet_offline", this);
            if (DEBUG) {
                aJM.sc("onSwanClientConnDown => " + this);
            }
            aJM.aJR();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.dwt) {
                c.this.mMessenger = new Messenger(iBinder);
                e aJM = e.aJM();
                aJM.aJN().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aJM.sc("on main bind to swan: " + c.this.dwt);
                }
                c.this.aJH();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aJn();
        }
    }
}
