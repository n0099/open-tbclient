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
    private final Deque<Message> dvA;
    private a dvB;
    private long dvC;
    public final SwanAppProcessInfo dvs;
    private SwanAppCores dvt;
    public PrefetchEvent dvu;
    private boolean dvv;
    private long dvw;
    private long dvx;
    private boolean dvy;
    private b dvz;
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
        this.dvv = true;
        this.dvw = 0L;
        this.dvx = 0L;
        this.dvy = false;
        this.dvA = new ArrayDeque();
        this.dvC = -1L;
        this.dvs = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFZ() {
        return this.dvs;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aGa() {
        return this.dvy;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aGb() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aGc() {
        return this.dvt;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.dvt = swanAppCores;
        }
        return this;
    }

    public boolean aGd() {
        return aGe();
    }

    public boolean aGe() {
        boolean z;
        synchronized (this.dvs) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aGf() {
        return this.dvv;
    }

    public void aGg() {
        this.dvw = System.currentTimeMillis();
    }

    public boolean aGh() {
        return System.currentTimeMillis() - this.dvw < ((long) com.baidu.swan.apps.performance.b.c.aEA());
    }

    public long aGi() {
        return System.currentTimeMillis() - this.dvw;
    }

    public void a(a aVar) {
        this.dvB = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.dvu = prefetchEvent;
    }

    public c aGj() {
        synchronized (this.dvs) {
            aGn();
            this.mMessenger = null;
            this.dvt = null;
            g(null);
            aGp();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aGq().rr("b4 preload: " + this.dvs);
        }
        a(true, context, bundle);
        return this;
    }

    public c aGk() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aGq().rr("b4 tryPreBind: " + this.dvs);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.awZ();
        }
        Intent intent = new Intent(context, this.dvs.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.dvx = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.dvs) {
            try {
                if (this.dvz == null) {
                    this.dvz = new b();
                    context.bindService(intent, this.dvz, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aGl();
            }
        }
        return this;
    }

    c aGl() {
        log("flushCachedMsgs");
        synchronized (this.dvs) {
            while (this.mMessenger != null && !this.dvA.isEmpty()) {
                Message peek = this.dvA.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aGq().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.dvA.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.dvs) {
            if (message != null) {
                if (aGd()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aFR();
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
        this.dvA.offer(message);
        aGl();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.dvA.offer(message);
        }
        aGl();
        return true;
    }

    public c rk(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aGq().aGr().c("event_puppet_load_app", this);
            this.dvv = true;
        } else {
            this.dvv = false;
        }
        return this;
    }

    public c aGm() {
        aGn();
        e.aGq().aGr().c("event_puppet_unload_app", this);
        return this;
    }

    public c aGn() {
        this.mAppId = "";
        g(null);
        this.dvC = -1L;
        return this;
    }

    public c aGo() {
        this.dvy = true;
        this.dvx = 0L;
        if (this.dvB != null) {
            this.dvB.b(this);
        }
        return this;
    }

    public c aGp() {
        this.dvy = false;
        this.dvx = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.dvs.toString();
        objArr[1] = Integer.valueOf(aGd() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.dvy ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.dvx));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            rk(string);
            e.aGq().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aFC().rh(string);
            aGp();
        }
        return aGk();
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
            this.dvC = j;
            e.aGq().aGr().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFR() {
        synchronized (this.dvs) {
            this.mMessenger = null;
            this.dvz = null;
            aGj();
            e aGq = e.aGq();
            aGq.aGr().c("event_puppet_offline", this);
            if (DEBUG) {
                aGq.rr("onSwanClientConnDown => " + this);
            }
            aGq.aGv();
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
            synchronized (c.this.dvs) {
                c.this.mMessenger = new Messenger(iBinder);
                e aGq = e.aGq();
                aGq.aGr().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aGq.rr("on main bind to swan: " + c.this.dvs);
                }
                c.this.aGl();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aFR();
        }
    }
}
