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
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    public final SwanAppProcessInfo dmc;
    private SwanAppCores dmd;
    public PrefetchEvent dme;
    private boolean dmf;
    private long dmg;
    private long dmh;
    private boolean dmi;
    private b dmj;
    private final Deque<Message> dmk;
    private a dml;
    private long dmm;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes10.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.dmf = true;
        this.dmg = 0L;
        this.dmh = 0L;
        this.dmi = false;
        this.dmk = new ArrayDeque();
        this.dmm = -1L;
        this.dmc = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFB() {
        return this.dmc;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFC() {
        return this.dmi;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFD() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aFE() {
        return this.dmd;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.dmd = swanAppCores;
        }
        return this;
    }

    public boolean aFF() {
        return aFG();
    }

    public boolean aFG() {
        boolean z;
        synchronized (this.dmc) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aFH() {
        return this.dmf;
    }

    public void aFI() {
        this.dmg = System.currentTimeMillis();
    }

    public boolean aFJ() {
        return System.currentTimeMillis() - this.dmg < ((long) com.baidu.swan.apps.performance.b.c.aEc());
    }

    public long aFK() {
        return System.currentTimeMillis() - this.dmg;
    }

    public void a(a aVar) {
        this.dml = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.dme = prefetchEvent;
    }

    public c aFL() {
        synchronized (this.dmc) {
            aFP();
            this.mMessenger = null;
            this.dmd = null;
            g(null);
            aFR();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aFS().rI("b4 preload: " + this.dmc);
        }
        a(true, context, bundle);
        return this;
    }

    public c aFM() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aFS().rI("b4 tryPreBind: " + this.dmc);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.awA();
        }
        Intent intent = new Intent(context, this.dmc.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.dmh = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.dmc) {
            try {
                if (this.dmj == null) {
                    this.dmj = new b();
                    context.bindService(intent, this.dmj, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aFN();
            }
        }
        return this;
    }

    c aFN() {
        log("flushCachedMsgs");
        synchronized (this.dmc) {
            while (this.mMessenger != null && !this.dmk.isEmpty()) {
                Message peek = this.dmk.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aFS().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.dmk.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.dmc) {
            if (message != null) {
                if (aFF()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aFt();
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
        this.dmk.offer(message);
        aFN();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.dmk.offer(message);
        }
        aFN();
        return true;
    }

    public c rC(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aFS().aFT().c("event_puppet_load_app", this);
            this.dmf = true;
        } else {
            this.dmf = false;
        }
        return this;
    }

    public c aFO() {
        aFP();
        e.aFS().aFT().c("event_puppet_unload_app", this);
        return this;
    }

    public c aFP() {
        this.mAppId = "";
        g(null);
        this.dmm = -1L;
        return this;
    }

    public c aFQ() {
        this.dmi = true;
        this.dmh = 0L;
        if (this.dml != null) {
            this.dml.b(this);
        }
        return this;
    }

    public c aFR() {
        this.dmi = false;
        this.dmh = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.dmc.toString();
        objArr[1] = Integer.valueOf(aFF() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.dmi ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.dmh));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            rC(string);
            e.aFS().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aFe().rz(string);
            aFR();
        }
        return aFM();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c ck(long j) {
        if (j > 0) {
            this.dmm = j;
            e.aFS().aFT().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFt() {
        synchronized (this.dmc) {
            this.mMessenger = null;
            this.dmj = null;
            aFL();
            e aFS = e.aFS();
            aFS.aFT().c("event_puppet_offline", this);
            if (DEBUG) {
                aFS.rI("onSwanClientConnDown => " + this);
            }
            aFS.aFX();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.dmc) {
                c.this.mMessenger = new Messenger(iBinder);
                e aFS = e.aFS();
                aFS.aFT().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aFS.rI("on main bind to swan: " + c.this.dmc);
                }
                c.this.aFN();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aFt();
        }
    }
}
