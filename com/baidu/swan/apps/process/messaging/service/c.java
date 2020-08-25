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
/* loaded from: classes8.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    private SwanAppCores cJA;
    public PrefetchEvent cJB;
    private boolean cJC;
    private long cJD;
    private long cJE;
    private boolean cJF;
    private b cJG;
    private final Deque<Message> cJH;
    private a cJI;
    private long cJJ;
    public final SwanAppProcessInfo cJz;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes8.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.cJC = true;
        this.cJD = 0L;
        this.cJE = 0L;
        this.cJF = false;
        this.cJH = new ArrayDeque();
        this.cJJ = -1L;
        this.cJz = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo axP() {
        return this.cJz;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean axQ() {
        return this.cJF;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean axR() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores axS() {
        return this.cJA;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.cJA = swanAppCores;
        }
        return this;
    }

    public boolean axT() {
        return axU();
    }

    public boolean axU() {
        boolean z;
        synchronized (this.cJz) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean axV() {
        return this.cJC;
    }

    public void axW() {
        this.cJD = System.currentTimeMillis();
    }

    public boolean axX() {
        return System.currentTimeMillis() - this.cJD < ((long) com.baidu.swan.apps.performance.b.c.awo());
    }

    public long axY() {
        return System.currentTimeMillis() - this.cJD;
    }

    public void a(a aVar) {
        this.cJI = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.cJB = prefetchEvent;
    }

    public c axZ() {
        synchronized (this.cJz) {
            ayd();
            this.mMessenger = null;
            this.cJA = null;
            g(null);
            ayf();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.ayg().pV("b4 preload: " + this.cJz);
        }
        a(true, context, bundle);
        return this;
    }

    public c aya() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.ayg().pV("b4 tryPreBind: " + this.cJz);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.aoJ();
        }
        Intent intent = new Intent(context, this.cJz.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.cJE = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.cJz) {
            try {
                if (this.cJG == null) {
                    this.cJG = new b();
                    context.bindService(intent, this.cJG, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                ayb();
            }
        }
        return this;
    }

    c ayb() {
        log("flushCachedMsgs");
        synchronized (this.cJz) {
            while (this.mMessenger != null && !this.cJH.isEmpty()) {
                Message peek = this.cJH.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.ayg().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.cJH.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.cJz) {
            if (message != null) {
                if (axT()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        axH();
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
        this.cJH.offer(message);
        ayb();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.cJH.offer(message);
        }
        ayb();
        return true;
    }

    public c pP(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.ayg().ayh().c("event_puppet_load_app", this);
            this.cJC = true;
        } else {
            this.cJC = false;
        }
        return this;
    }

    public c ayc() {
        ayd();
        e.ayg().ayh().c("event_puppet_unload_app", this);
        return this;
    }

    public c ayd() {
        this.mAppId = "";
        g(null);
        this.cJJ = -1L;
        return this;
    }

    public c aye() {
        this.cJF = true;
        this.cJE = 0L;
        if (this.cJI != null) {
            this.cJI.b(this);
        }
        return this;
    }

    public c ayf() {
        this.cJF = false;
        this.cJE = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.cJz.toString();
        objArr[1] = Integer.valueOf(axT() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.cJF ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.cJE));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            pP(string);
            e.ayg().d(string, this);
            com.baidu.swan.apps.process.messaging.a.axs().pM(string);
            ayf();
        }
        return aya();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c bD(long j) {
        if (j > 0) {
            this.cJJ = j;
            e.ayg().ayh().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axH() {
        synchronized (this.cJz) {
            this.mMessenger = null;
            this.cJG = null;
            axZ();
            e ayg = e.ayg();
            ayg.ayh().c("event_puppet_offline", this);
            if (DEBUG) {
                ayg.pV("onSwanClientConnDown => " + this);
            }
            ayg.ayl();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.cJz) {
                c.this.mMessenger = new Messenger(iBinder);
                e ayg = e.ayg();
                ayg.ayh().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    ayg.pV("on main bind to swan: " + c.this.cJz);
                }
                c.this.ayb();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.axH();
        }
    }
}
