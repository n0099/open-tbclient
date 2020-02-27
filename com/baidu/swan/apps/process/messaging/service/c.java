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
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    public PrefetchEvent bJA;
    private long bJB;
    private boolean bJC;
    private b bJD;
    private final Deque<Message> bJE;
    private a bJF;
    private long bJG;
    public final SwanAppProcessInfo bJy;
    private SwanAppCores bJz;
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
        this.bJB = 0L;
        this.bJC = false;
        this.bJE = new ArrayDeque();
        this.bJG = -1L;
        this.bJy = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo abf() {
        return this.bJy;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abg() {
        return this.bJC;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abh() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores abi() {
        return this.bJz;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.bJz = swanAppCores;
        }
        return this;
    }

    public boolean abj() {
        return abk();
    }

    public boolean abk() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.bJF = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.bJA = prefetchEvent;
    }

    public c abl() {
        synchronized (c.class) {
            abp();
            this.mMessenger = null;
            this.bJz = null;
            g(null);
            abr();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.abs().kB("b4 preload: " + this.bJy);
        this.bJB = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.TU();
        }
        abm();
        Intent intent = new Intent(context, this.bJy.service);
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

    public c abm() {
        e.abs().kB("b4 tryPreBind: " + this.bJy);
        Application TU = com.baidu.swan.apps.w.a.TU();
        if (this.bJD == null) {
            this.bJD = new b();
            Intent intent = new Intent(TU, this.bJy.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                TU.bindService(intent, this.bJD, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            abn();
        }
        return this;
    }

    c abn() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.bJE.isEmpty()) {
            Message peek = this.bJE.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.abs().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.bJE.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && abj()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                aaY();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.bJE.offer(message);
        abn();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.bJE.offer(message);
        }
        abn();
        return true;
    }

    public c kv(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.abs().abt().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c abo() {
        abp();
        e.abs().abt().b("event_puppet_unload_app", this);
        return this;
    }

    public c abp() {
        this.mAppId = "";
        g(null);
        this.bJG = -1L;
        return this;
    }

    public c abq() {
        this.bJC = true;
        this.bJB = 0L;
        if (this.bJF != null) {
            this.bJF.b(this);
        }
        return this;
    }

    public c abr() {
        this.bJC = false;
        this.bJB = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.bJy.toString();
        objArr[1] = Integer.valueOf(abj() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.bJC ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.bJB));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            kv(string);
            e.abs().c(string, this);
            com.baidu.swan.apps.process.messaging.a.aaJ().ks(string);
            abr();
        }
        return abm();
    }

    public c L(Bundle bundle) {
        return K(bundle);
    }

    public c M(Bundle bundle) {
        g(null);
        return K(bundle);
    }

    public c aw(long j) {
        if (j > 0) {
            this.bJG = j;
            e.abs().abt().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaY() {
        this.mMessenger = null;
        this.bJD = null;
        abl();
        e abs = e.abs();
        abs.abt().b("event_puppet_offline", this);
        abs.kB("onSwanClientConnDown => " + this);
        abs.abx();
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
            e abs = e.abs();
            abs.abt().b("event_puppet_online", c.this);
            abs.kB("on main bind to swan: " + c.this.bJy);
            c.this.abn();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aaY();
        }
    }
}
