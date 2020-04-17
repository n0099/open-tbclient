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
    private b ciA;
    private final Deque<Message> ciB;
    private a ciC;
    private long ciD;
    public final SwanAppProcessInfo civ;
    private SwanAppCores ciw;
    public PrefetchEvent cix;
    private long ciy;
    private boolean ciz;
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
        this.ciy = 0L;
        this.ciz = false;
        this.ciB = new ArrayDeque();
        this.ciD = -1L;
        this.civ = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ajp() {
        return this.civ;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean ajq() {
        return this.ciz;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean ajr() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores ajs() {
        return this.ciw;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.ciw = swanAppCores;
        }
        return this;
    }

    public boolean ajt() {
        return aju();
    }

    public boolean aju() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.ciC = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.cix = prefetchEvent;
    }

    public c ajv() {
        synchronized (c.class) {
            ajz();
            this.mMessenger = null;
            this.ciw = null;
            g(null);
            ajB();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.ajC().lN("b4 preload: " + this.civ);
        this.ciy = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.abO();
        }
        ajw();
        Intent intent = new Intent(context, this.civ.service);
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

    public c ajw() {
        e.ajC().lN("b4 tryPreBind: " + this.civ);
        Application abO = com.baidu.swan.apps.w.a.abO();
        if (this.ciA == null) {
            this.ciA = new b();
            Intent intent = new Intent(abO, this.civ.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                abO.bindService(intent, this.ciA, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            ajx();
        }
        return this;
    }

    c ajx() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.ciB.isEmpty()) {
            Message peek = this.ciB.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.ajC().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.ciB.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && ajt()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                aji();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.ciB.offer(message);
        ajx();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.ciB.offer(message);
        }
        ajx();
        return true;
    }

    public c lH(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.ajC().ajD().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c ajy() {
        ajz();
        e.ajC().ajD().b("event_puppet_unload_app", this);
        return this;
    }

    public c ajz() {
        this.mAppId = "";
        g(null);
        this.ciD = -1L;
        return this;
    }

    public c ajA() {
        this.ciz = true;
        this.ciy = 0L;
        if (this.ciC != null) {
            this.ciC.b(this);
        }
        return this;
    }

    public c ajB() {
        this.ciz = false;
        this.ciy = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.civ.toString();
        objArr[1] = Integer.valueOf(ajt() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.ciz ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.ciy));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            lH(string);
            e.ajC().c(string, this);
            com.baidu.swan.apps.process.messaging.a.aiT().lE(string);
            ajB();
        }
        return ajw();
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
            this.ciD = j;
            e.ajC().ajD().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aji() {
        this.mMessenger = null;
        this.ciA = null;
        ajv();
        e ajC = e.ajC();
        ajC.ajD().b("event_puppet_offline", this);
        ajC.lN("onSwanClientConnDown => " + this);
        ajC.ajH();
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
            e ajC = e.ajC();
            ajC.ajD().b("event_puppet_online", c.this);
            ajC.lN("on main bind to swan: " + c.this.civ);
            c.this.ajx();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aji();
        }
    }
}
