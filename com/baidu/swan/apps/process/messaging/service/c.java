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
    public final SwanAppProcessInfo dgh;
    private SwanAppCores dgi;
    public PrefetchEvent dgj;
    private boolean dgk;
    private long dgl;
    private long dgm;
    private boolean dgn;
    private b dgo;
    private final Deque<Message> dgp;
    private a dgq;
    private long dgr;
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
        this.dgk = true;
        this.dgl = 0L;
        this.dgm = 0L;
        this.dgn = false;
        this.dgp = new ArrayDeque();
        this.dgr = -1L;
        this.dgh = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aDb() {
        return this.dgh;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aDc() {
        return this.dgn;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aDd() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aDe() {
        return this.dgi;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.dgi = swanAppCores;
        }
        return this;
    }

    public boolean aDf() {
        return aDg();
    }

    public boolean aDg() {
        boolean z;
        synchronized (this.dgh) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aDh() {
        return this.dgk;
    }

    public void aDi() {
        this.dgl = System.currentTimeMillis();
    }

    public boolean aDj() {
        return System.currentTimeMillis() - this.dgl < ((long) com.baidu.swan.apps.performance.b.c.aBC());
    }

    public long aDk() {
        return System.currentTimeMillis() - this.dgl;
    }

    public void a(a aVar) {
        this.dgq = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.dgj = prefetchEvent;
    }

    public c aDl() {
        synchronized (this.dgh) {
            aDp();
            this.mMessenger = null;
            this.dgi = null;
            g(null);
            aDr();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aDs().ru("b4 preload: " + this.dgh);
        }
        a(true, context, bundle);
        return this;
    }

    public c aDm() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aDs().ru("b4 tryPreBind: " + this.dgh);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.aua();
        }
        Intent intent = new Intent(context, this.dgh.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.dgm = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.dgh) {
            try {
                if (this.dgo == null) {
                    this.dgo = new b();
                    context.bindService(intent, this.dgo, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aDn();
            }
        }
        return this;
    }

    c aDn() {
        log("flushCachedMsgs");
        synchronized (this.dgh) {
            while (this.mMessenger != null && !this.dgp.isEmpty()) {
                Message peek = this.dgp.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aDs().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.dgp.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.dgh) {
            if (message != null) {
                if (aDf()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aCT();
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
        this.dgp.offer(message);
        aDn();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.dgp.offer(message);
        }
        aDn();
        return true;
    }

    public c ro(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aDs().aDt().c("event_puppet_load_app", this);
            this.dgk = true;
        } else {
            this.dgk = false;
        }
        return this;
    }

    public c aDo() {
        aDp();
        e.aDs().aDt().c("event_puppet_unload_app", this);
        return this;
    }

    public c aDp() {
        this.mAppId = "";
        g(null);
        this.dgr = -1L;
        return this;
    }

    public c aDq() {
        this.dgn = true;
        this.dgm = 0L;
        if (this.dgq != null) {
            this.dgq.b(this);
        }
        return this;
    }

    public c aDr() {
        this.dgn = false;
        this.dgm = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.dgh.toString();
        objArr[1] = Integer.valueOf(aDf() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.dgn ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.dgm));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            ro(string);
            e.aDs().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aCE().rl(string);
            aDr();
        }
        return aDm();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c bO(long j) {
        if (j > 0) {
            this.dgr = j;
            e.aDs().aDt().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCT() {
        synchronized (this.dgh) {
            this.mMessenger = null;
            this.dgo = null;
            aDl();
            e aDs = e.aDs();
            aDs.aDt().c("event_puppet_offline", this);
            if (DEBUG) {
                aDs.ru("onSwanClientConnDown => " + this);
            }
            aDs.aDx();
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
            synchronized (c.this.dgh) {
                c.this.mMessenger = new Messenger(iBinder);
                e aDs = e.aDs();
                aDs.aDt().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aDs.ru("on main bind to swan: " + c.this.dgh);
                }
                c.this.aDn();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aCT();
        }
    }
}
