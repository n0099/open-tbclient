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
/* loaded from: classes7.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    private long dkA;
    private boolean dkB;
    private b dkC;
    private final Deque<Message> dkD;
    private a dkE;
    private long dkF;
    public final SwanAppProcessInfo dkv;
    private SwanAppCores dkw;
    public PrefetchEvent dkx;
    private boolean dky;
    private long dkz;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes7.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.dky = true;
        this.dkz = 0L;
        this.dkA = 0L;
        this.dkB = false;
        this.dkD = new ArrayDeque();
        this.dkF = -1L;
        this.dkv = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aET() {
        return this.dkv;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aEU() {
        return this.dkB;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aEV() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aEW() {
        return this.dkw;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.dkw = swanAppCores;
        }
        return this;
    }

    public boolean aEX() {
        return aEY();
    }

    public boolean aEY() {
        boolean z;
        synchronized (this.dkv) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aEZ() {
        return this.dky;
    }

    public void aFa() {
        this.dkz = System.currentTimeMillis();
    }

    public boolean aFb() {
        return System.currentTimeMillis() - this.dkz < ((long) com.baidu.swan.apps.performance.b.c.aDu());
    }

    public long aFc() {
        return System.currentTimeMillis() - this.dkz;
    }

    public void a(a aVar) {
        this.dkE = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.dkx = prefetchEvent;
    }

    public c aFd() {
        synchronized (this.dkv) {
            aFh();
            this.mMessenger = null;
            this.dkw = null;
            g(null);
            aFj();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aFk().rC("b4 preload: " + this.dkv);
        }
        a(true, context, bundle);
        return this;
    }

    public c aFe() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aFk().rC("b4 tryPreBind: " + this.dkv);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.avS();
        }
        Intent intent = new Intent(context, this.dkv.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.dkA = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.dkv) {
            try {
                if (this.dkC == null) {
                    this.dkC = new b();
                    context.bindService(intent, this.dkC, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aFf();
            }
        }
        return this;
    }

    c aFf() {
        log("flushCachedMsgs");
        synchronized (this.dkv) {
            while (this.mMessenger != null && !this.dkD.isEmpty()) {
                Message peek = this.dkD.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aFk().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.dkD.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.dkv) {
            if (message != null) {
                if (aEX()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aEL();
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
        this.dkD.offer(message);
        aFf();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.dkD.offer(message);
        }
        aFf();
        return true;
    }

    public c rw(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aFk().aFl().c("event_puppet_load_app", this);
            this.dky = true;
        } else {
            this.dky = false;
        }
        return this;
    }

    public c aFg() {
        aFh();
        e.aFk().aFl().c("event_puppet_unload_app", this);
        return this;
    }

    public c aFh() {
        this.mAppId = "";
        g(null);
        this.dkF = -1L;
        return this;
    }

    public c aFi() {
        this.dkB = true;
        this.dkA = 0L;
        if (this.dkE != null) {
            this.dkE.b(this);
        }
        return this;
    }

    public c aFj() {
        this.dkB = false;
        this.dkA = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.dkv.toString();
        objArr[1] = Integer.valueOf(aEX() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.dkB ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.dkA));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            rw(string);
            e.aFk().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aEw().rt(string);
            aFj();
        }
        return aFe();
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
            this.dkF = j;
            e.aFk().aFl().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEL() {
        synchronized (this.dkv) {
            this.mMessenger = null;
            this.dkC = null;
            aFd();
            e aFk = e.aFk();
            aFk.aFl().c("event_puppet_offline", this);
            if (DEBUG) {
                aFk.rC("onSwanClientConnDown => " + this);
            }
            aFk.aFp();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.dkv) {
                c.this.mMessenger = new Messenger(iBinder);
                e aFk = e.aFk();
                aFk.aFl().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aFk.rC("on main bind to swan: " + c.this.dkv);
                }
                c.this.aFf();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aEL();
        }
    }
}
