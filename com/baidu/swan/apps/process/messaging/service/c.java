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
/* loaded from: classes25.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    private long drA;
    private boolean drB;
    private b drC;
    private final Deque<Message> drD;
    private a drE;
    private long drF;
    public final SwanAppProcessInfo drv;
    private SwanAppCores drw;
    public PrefetchEvent drx;
    private boolean dry;
    private long drz;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes25.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.dry = true;
        this.drz = 0L;
        this.drA = 0L;
        this.drB = false;
        this.drD = new ArrayDeque();
        this.drF = -1L;
        this.drv = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aIb() {
        return this.drv;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aIc() {
        return this.drB;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aId() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aIe() {
        return this.drw;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.drw = swanAppCores;
        }
        return this;
    }

    public boolean aIf() {
        return aIg();
    }

    public boolean aIg() {
        boolean z;
        synchronized (this.drv) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aIh() {
        return this.dry;
    }

    public void aIi() {
        this.drz = System.currentTimeMillis();
    }

    public boolean aIj() {
        return System.currentTimeMillis() - this.drz < ((long) com.baidu.swan.apps.performance.b.c.aGC());
    }

    public long aIk() {
        return System.currentTimeMillis() - this.drz;
    }

    public void a(a aVar) {
        this.drE = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.drx = prefetchEvent;
    }

    public c aIl() {
        synchronized (this.drv) {
            aIp();
            this.mMessenger = null;
            this.drw = null;
            g(null);
            aIr();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aIs().sj("b4 preload: " + this.drv);
        }
        a(true, context, bundle);
        return this;
    }

    public c aIm() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aIs().sj("b4 tryPreBind: " + this.drv);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.aza();
        }
        Intent intent = new Intent(context, this.drv.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.drA = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.drv) {
            try {
                if (this.drC == null) {
                    this.drC = new b();
                    context.bindService(intent, this.drC, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aIn();
            }
        }
        return this;
    }

    c aIn() {
        log("flushCachedMsgs");
        synchronized (this.drv) {
            while (this.mMessenger != null && !this.drD.isEmpty()) {
                Message peek = this.drD.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aIs().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.drD.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.drv) {
            if (message != null) {
                if (aIf()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aHT();
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
        this.drD.offer(message);
        aIn();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.drD.offer(message);
        }
        aIn();
        return true;
    }

    public c sd(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aIs().aIt().c("event_puppet_load_app", this);
            this.dry = true;
        } else {
            this.dry = false;
        }
        return this;
    }

    public c aIo() {
        aIp();
        e.aIs().aIt().c("event_puppet_unload_app", this);
        return this;
    }

    public c aIp() {
        this.mAppId = "";
        g(null);
        this.drF = -1L;
        return this;
    }

    public c aIq() {
        this.drB = true;
        this.drA = 0L;
        if (this.drE != null) {
            this.drE.b(this);
        }
        return this;
    }

    public c aIr() {
        this.drB = false;
        this.drA = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.drv.toString();
        objArr[1] = Integer.valueOf(aIf() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.drB ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.drA));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            sd(string);
            e.aIs().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aHE().sa(string);
            aIr();
        }
        return aIm();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c cJ(long j) {
        if (j > 0) {
            this.drF = j;
            e.aIs().aIt().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHT() {
        synchronized (this.drv) {
            this.mMessenger = null;
            this.drC = null;
            aIl();
            e aIs = e.aIs();
            aIs.aIt().c("event_puppet_offline", this);
            if (DEBUG) {
                aIs.sj("onSwanClientConnDown => " + this);
            }
            aIs.aIx();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.drv) {
                c.this.mMessenger = new Messenger(iBinder);
                e aIs = e.aIs();
                aIs.aIt().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aIs.sj("on main bind to swan: " + c.this.drv);
                }
                c.this.aIn();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aHT();
        }
    }
}
