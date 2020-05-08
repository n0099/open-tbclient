package com.baidu.swan.apps.process.messaging.service;

import android.app.Application;
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
    public final SwanAppProcessInfo ciB;
    private SwanAppCores ciC;
    public PrefetchEvent ciD;
    private long ciE;
    private boolean ciF;
    private b ciG;
    private final Deque<Message> ciH;
    private a ciI;
    private long ciJ;
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
        this.ciE = 0L;
        this.ciF = false;
        this.ciH = new ArrayDeque();
        this.ciJ = -1L;
        this.ciB = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ajo() {
        return this.ciB;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean ajp() {
        return this.ciF;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean ajq() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores ajr() {
        return this.ciC;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.ciC = swanAppCores;
        }
        return this;
    }

    public boolean ajs() {
        return ajt();
    }

    public boolean ajt() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.ciI = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.ciD = prefetchEvent;
    }

    public c aju() {
        synchronized (c.class) {
            ajy();
            this.mMessenger = null;
            this.ciC = null;
            g(null);
            ajA();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.ajB().lN("b4 preload: " + this.ciB);
        this.ciE = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.abN();
        }
        ajv();
        Intent intent = new Intent(context, this.ciB.service);
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            context.startService(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public c ajv() {
        e.ajB().lN("b4 tryPreBind: " + this.ciB);
        Application abN = com.baidu.swan.apps.w.a.abN();
        if (this.ciG == null) {
            this.ciG = new b();
            Intent intent = new Intent(abN, this.ciB.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                abN.bindService(intent, this.ciG, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            ajw();
        }
        return this;
    }

    c ajw() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.ciH.isEmpty()) {
            Message peek = this.ciH.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.ajB().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.ciH.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && ajs()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                ajh();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.ciH.offer(message);
        ajw();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.ciH.offer(message);
        }
        ajw();
        return true;
    }

    public c lH(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.ajB().ajC().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c ajx() {
        ajy();
        e.ajB().ajC().b("event_puppet_unload_app", this);
        return this;
    }

    public c ajy() {
        this.mAppId = "";
        g(null);
        this.ciJ = -1L;
        return this;
    }

    public c ajz() {
        this.ciF = true;
        this.ciE = 0L;
        if (this.ciI != null) {
            this.ciI.b(this);
        }
        return this;
    }

    public c ajA() {
        this.ciF = false;
        this.ciE = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.ciB.toString();
        objArr[1] = Integer.valueOf(ajs() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.ciF ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.ciE));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            lH(string);
            e.ajB().c(string, this);
            com.baidu.swan.apps.process.messaging.a.aiS().lE(string);
            ajA();
        }
        return ajv();
    }

    public c L(Bundle bundle) {
        return K(bundle);
    }

    public c M(Bundle bundle) {
        g(null);
        return K(bundle);
    }

    public c bb(long j) {
        if (j > 0) {
            this.ciJ = j;
            e.ajB().ajC().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        this.mMessenger = null;
        this.ciG = null;
        aju();
        e ajB = e.ajB();
        ajB.ajC().b("event_puppet_offline", this);
        ajB.lN("onSwanClientConnDown => " + this);
        ajB.ajG();
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
            c.this.mMessenger = new Messenger(iBinder);
            e ajB = e.ajB();
            ajB.ajC().b("event_puppet_online", c.this);
            ajB.lN("on main bind to swan: " + c.this.ciB);
            c.this.ajw();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.ajh();
        }
    }
}
