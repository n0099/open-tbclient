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
/* loaded from: classes11.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    public final SwanAppProcessInfo cyQ;
    private SwanAppCores cyR;
    public PrefetchEvent cyS;
    private long cyT;
    private boolean cyU;
    private b cyV;
    private final Deque<Message> cyW;
    private a cyX;
    private long cyY;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes11.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.cyT = 0L;
        this.cyU = false;
        this.cyW = new ArrayDeque();
        this.cyY = -1L;
        this.cyQ = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aoi() {
        return this.cyQ;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aoj() {
        return this.cyU;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aok() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aol() {
        return this.cyR;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.cyR = swanAppCores;
        }
        return this;
    }

    public boolean aom() {
        return aon();
    }

    public boolean aon() {
        boolean z;
        synchronized (this.cyQ) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public void a(a aVar) {
        this.cyX = aVar;
    }

    public void h(PrefetchEvent prefetchEvent) {
        this.cyS = prefetchEvent;
    }

    public c aoo() {
        synchronized (this.cyQ) {
            aos();
            this.mMessenger = null;
            this.cyR = null;
            h(null);
            aou();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.aov().nq("b4 preload: " + this.cyQ);
        a(true, context, bundle);
        return this;
    }

    public c aop() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        e.aov().nq("b4 tryPreBind: " + this.cyQ);
        if (context == null) {
            context = com.baidu.swan.apps.u.a.afX();
        }
        Intent intent = new Intent(context, this.cyQ.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.cyT = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.cyQ) {
            try {
                if (this.cyV == null) {
                    this.cyV = new b();
                    context.bindService(intent, this.cyV, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aoq();
            }
        }
        return this;
    }

    c aoq() {
        log("flushCachedMsgs");
        synchronized (this.cyQ) {
            while (this.mMessenger != null && !this.cyW.isEmpty()) {
                Message peek = this.cyW.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aov().mMessenger;
                }
                if (!J(peek)) {
                    break;
                }
                this.cyW.poll();
            }
        }
        return this;
    }

    private boolean J(Message message) {
        synchronized (this.cyQ) {
            if (message != null) {
                if (aom()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aob();
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean K(Message message) {
        this.cyW.offer(message);
        aoq();
        return true;
    }

    public boolean g(Collection<Message> collection) {
        for (Message message : collection) {
            this.cyW.offer(message);
        }
        aoq();
        return true;
    }

    public c nk(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aov().aow().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c aor() {
        aos();
        e.aov().aow().b("event_puppet_unload_app", this);
        return this;
    }

    public c aos() {
        this.mAppId = "";
        h(null);
        this.cyY = -1L;
        return this;
    }

    public c aot() {
        this.cyU = true;
        this.cyT = 0L;
        if (this.cyX != null) {
            this.cyX.b(this);
        }
        return this;
    }

    public c aou() {
        this.cyU = false;
        this.cyT = 0L;
        h(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.cyQ.toString();
        objArr[1] = Integer.valueOf(aom() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.cyU ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.cyT));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c Q(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            nk(string);
            e.aov().c(string, this);
            com.baidu.swan.apps.process.messaging.a.anM().nh(string);
            aou();
        }
        return aop();
    }

    public c R(Bundle bundle) {
        return Q(bundle);
    }

    public c S(Bundle bundle) {
        h(null);
        return Q(bundle);
    }

    public c bl(long j) {
        if (j > 0) {
            this.cyY = j;
            e.aov().aow().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aob() {
        synchronized (this.cyQ) {
            this.mMessenger = null;
            this.cyV = null;
            aoo();
            e aov = e.aov();
            aov.aow().b("event_puppet_offline", this);
            aov.nq("onSwanClientConnDown => " + this);
            aov.aoA();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.cyQ) {
                c.this.mMessenger = new Messenger(iBinder);
                e aov = e.aov();
                aov.aow().b("event_puppet_online", c.this);
                aov.nq("on main bind to swan: " + c.this.cyQ);
                c.this.aoq();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aob();
        }
    }
}
