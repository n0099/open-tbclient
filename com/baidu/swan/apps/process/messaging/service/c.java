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
    public final SwanAppProcessInfo cud;
    private SwanAppCores cue;
    public PrefetchEvent cuf;
    private long cug;
    private boolean cuh;
    private b cui;
    private final Deque<Message> cuj;
    private a cuk;
    private long cul;
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
        this.cug = 0L;
        this.cuh = false;
        this.cuj = new ArrayDeque();
        this.cul = -1L;
        this.cud = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo anc() {
        return this.cud;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean and() {
        return this.cuh;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean ane() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores anf() {
        return this.cue;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.cue = swanAppCores;
        }
        return this;
    }

    public boolean ang() {
        return anh();
    }

    public boolean anh() {
        boolean z;
        synchronized (this.cud) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public void a(a aVar) {
        this.cuk = aVar;
    }

    public void h(PrefetchEvent prefetchEvent) {
        this.cuf = prefetchEvent;
    }

    public c ani() {
        synchronized (this.cud) {
            anm();
            this.mMessenger = null;
            this.cue = null;
            h(null);
            ano();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.anp().ni("b4 preload: " + this.cud);
        a(true, context, bundle);
        return this;
    }

    public c anj() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        e.anp().ni("b4 tryPreBind: " + this.cud);
        if (context == null) {
            context = com.baidu.swan.apps.u.a.aeR();
        }
        Intent intent = new Intent(context, this.cud.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.cug = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.cud) {
            try {
                if (this.cui == null) {
                    this.cui = new b();
                    context.bindService(intent, this.cui, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                ank();
            }
        }
        return this;
    }

    c ank() {
        log("flushCachedMsgs");
        synchronized (this.cud) {
            while (this.mMessenger != null && !this.cuj.isEmpty()) {
                Message peek = this.cuj.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.anp().mMessenger;
                }
                if (!J(peek)) {
                    break;
                }
                this.cuj.poll();
            }
        }
        return this;
    }

    private boolean J(Message message) {
        synchronized (this.cud) {
            if (message != null) {
                if (ang()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        amV();
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
        this.cuj.offer(message);
        ank();
        return true;
    }

    public boolean g(Collection<Message> collection) {
        for (Message message : collection) {
            this.cuj.offer(message);
        }
        ank();
        return true;
    }

    public c nc(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.anp().anq().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c anl() {
        anm();
        e.anp().anq().b("event_puppet_unload_app", this);
        return this;
    }

    public c anm() {
        this.mAppId = "";
        h(null);
        this.cul = -1L;
        return this;
    }

    public c ann() {
        this.cuh = true;
        this.cug = 0L;
        if (this.cuk != null) {
            this.cuk.b(this);
        }
        return this;
    }

    public c ano() {
        this.cuh = false;
        this.cug = 0L;
        h(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.cud.toString();
        objArr[1] = Integer.valueOf(ang() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.cuh ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.cug));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c Q(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            nc(string);
            e.anp().c(string, this);
            com.baidu.swan.apps.process.messaging.a.amG().mZ(string);
            ano();
        }
        return anj();
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
            this.cul = j;
            e.anp().anq().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amV() {
        synchronized (this.cud) {
            this.mMessenger = null;
            this.cui = null;
            ani();
            e anp = e.anp();
            anp.anq().b("event_puppet_offline", this);
            anp.ni("onSwanClientConnDown => " + this);
            anp.anu();
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
            synchronized (c.this.cud) {
                c.this.mMessenger = new Messenger(iBinder);
                e anp = e.anp();
                anp.anq().b("event_puppet_online", c.this);
                anp.ni("on main bind to swan: " + c.this.cud);
                c.this.ank();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.amV();
        }
    }
}
