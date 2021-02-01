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
    public final SwanAppProcessInfo dtR;
    private SwanAppCores dtS;
    public PrefetchEvent dtT;
    private boolean dtU;
    private long dtV;
    private long dtW;
    private boolean dtX;
    private b dtY;
    private final Deque<Message> dtZ;
    private a dua;
    private long dub;
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
        this.dtU = true;
        this.dtV = 0L;
        this.dtW = 0L;
        this.dtX = false;
        this.dtZ = new ArrayDeque();
        this.dub = -1L;
        this.dtR = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFW() {
        return this.dtR;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFX() {
        return this.dtX;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFY() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aFZ() {
        return this.dtS;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.dtS = swanAppCores;
        }
        return this;
    }

    public boolean aGa() {
        return aGb();
    }

    public boolean aGb() {
        boolean z;
        synchronized (this.dtR) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aGc() {
        return this.dtU;
    }

    public void aGd() {
        this.dtV = System.currentTimeMillis();
    }

    public boolean aGe() {
        return System.currentTimeMillis() - this.dtV < ((long) com.baidu.swan.apps.performance.b.c.aEx());
    }

    public long aGf() {
        return System.currentTimeMillis() - this.dtV;
    }

    public void a(a aVar) {
        this.dua = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.dtT = prefetchEvent;
    }

    public c aGg() {
        synchronized (this.dtR) {
            aGk();
            this.mMessenger = null;
            this.dtS = null;
            g(null);
            aGm();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aGn().rj("b4 preload: " + this.dtR);
        }
        a(true, context, bundle);
        return this;
    }

    public c aGh() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aGn().rj("b4 tryPreBind: " + this.dtR);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.awW();
        }
        Intent intent = new Intent(context, this.dtR.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.dtW = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.dtR) {
            try {
                if (this.dtY == null) {
                    this.dtY = new b();
                    context.bindService(intent, this.dtY, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aGi();
            }
        }
        return this;
    }

    c aGi() {
        log("flushCachedMsgs");
        synchronized (this.dtR) {
            while (this.mMessenger != null && !this.dtZ.isEmpty()) {
                Message peek = this.dtZ.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aGn().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.dtZ.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.dtR) {
            if (message != null) {
                if (aGa()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aFO();
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
        this.dtZ.offer(message);
        aGi();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.dtZ.offer(message);
        }
        aGi();
        return true;
    }

    public c rd(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aGn().aGo().c("event_puppet_load_app", this);
            this.dtU = true;
        } else {
            this.dtU = false;
        }
        return this;
    }

    public c aGj() {
        aGk();
        e.aGn().aGo().c("event_puppet_unload_app", this);
        return this;
    }

    public c aGk() {
        this.mAppId = "";
        g(null);
        this.dub = -1L;
        return this;
    }

    public c aGl() {
        this.dtX = true;
        this.dtW = 0L;
        if (this.dua != null) {
            this.dua.b(this);
        }
        return this;
    }

    public c aGm() {
        this.dtX = false;
        this.dtW = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.dtR.toString();
        objArr[1] = Integer.valueOf(aGa() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.dtX ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.dtW));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            rd(string);
            e.aGn().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aFz().ra(string);
            aGm();
        }
        return aGh();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c cQ(long j) {
        if (j > 0) {
            this.dub = j;
            e.aGn().aGo().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFO() {
        synchronized (this.dtR) {
            this.mMessenger = null;
            this.dtY = null;
            aGg();
            e aGn = e.aGn();
            aGn.aGo().c("event_puppet_offline", this);
            if (DEBUG) {
                aGn.rj("onSwanClientConnDown => " + this);
            }
            aGn.aGs();
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
            synchronized (c.this.dtR) {
                c.this.mMessenger = new Messenger(iBinder);
                e aGn = e.aGn();
                aGn.aGo().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aGn.rj("on main bind to swan: " + c.this.dtR);
                }
                c.this.aGi();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aFO();
        }
    }
}
