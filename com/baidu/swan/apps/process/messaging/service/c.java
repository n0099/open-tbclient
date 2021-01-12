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
    public final SwanAppProcessInfo drF;
    private SwanAppCores drG;
    public PrefetchEvent drH;
    private boolean drI;
    private long drJ;
    private long drK;
    private boolean drL;
    private b drM;
    private final Deque<Message> drN;
    private a drO;
    private long drP;
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
        this.drI = true;
        this.drJ = 0L;
        this.drK = 0L;
        this.drL = false;
        this.drN = new ArrayDeque();
        this.drP = -1L;
        this.drF = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFB() {
        return this.drF;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFC() {
        return this.drL;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFD() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aFE() {
        return this.drG;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.drG = swanAppCores;
        }
        return this;
    }

    public boolean aFF() {
        return aFG();
    }

    public boolean aFG() {
        boolean z;
        synchronized (this.drF) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aFH() {
        return this.drI;
    }

    public void aFI() {
        this.drJ = System.currentTimeMillis();
    }

    public boolean aFJ() {
        return System.currentTimeMillis() - this.drJ < ((long) com.baidu.swan.apps.performance.b.c.aEc());
    }

    public long aFK() {
        return System.currentTimeMillis() - this.drJ;
    }

    public void a(a aVar) {
        this.drO = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.drH = prefetchEvent;
    }

    public c aFL() {
        synchronized (this.drF) {
            aFP();
            this.mMessenger = null;
            this.drG = null;
            g(null);
            aFR();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aFS().qR("b4 preload: " + this.drF);
        }
        a(true, context, bundle);
        return this;
    }

    public c aFM() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aFS().qR("b4 tryPreBind: " + this.drF);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.awy();
        }
        Intent intent = new Intent(context, this.drF.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.drK = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.drF) {
            try {
                if (this.drM == null) {
                    this.drM = new b();
                    context.bindService(intent, this.drM, 1);
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
        synchronized (this.drF) {
            while (this.mMessenger != null && !this.drN.isEmpty()) {
                Message peek = this.drN.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aFS().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.drN.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.drF) {
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
        this.drN.offer(message);
        aFN();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.drN.offer(message);
        }
        aFN();
        return true;
    }

    public c qL(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aFS().aFT().c("event_puppet_load_app", this);
            this.drI = true;
        } else {
            this.drI = false;
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
        this.drP = -1L;
        return this;
    }

    public c aFQ() {
        this.drL = true;
        this.drK = 0L;
        if (this.drO != null) {
            this.drO.b(this);
        }
        return this;
    }

    public c aFR() {
        this.drL = false;
        this.drK = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.drF.toString();
        objArr[1] = Integer.valueOf(aFF() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.drL ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.drK));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            qL(string);
            e.aFS().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aFe().qI(string);
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

    public c cK(long j) {
        if (j > 0) {
            this.drP = j;
            e.aFS().aFT().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFt() {
        synchronized (this.drF) {
            this.mMessenger = null;
            this.drM = null;
            aFL();
            e aFS = e.aFS();
            aFS.aFT().c("event_puppet_offline", this);
            if (DEBUG) {
                aFS.qR("onSwanClientConnDown => " + this);
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
    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.drF) {
                c.this.mMessenger = new Messenger(iBinder);
                e aFS = e.aFS();
                aFS.aFT().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aFS.qR("on main bind to swan: " + c.this.drF);
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
