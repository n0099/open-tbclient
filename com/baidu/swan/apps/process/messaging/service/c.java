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
    private SwanAppCores bJA;
    public PrefetchEvent bJB;
    private long bJC;
    private boolean bJD;
    private b bJE;
    private final Deque<Message> bJF;
    private a bJG;
    private long bJH;
    public final SwanAppProcessInfo bJz;
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
        this.bJC = 0L;
        this.bJD = false;
        this.bJF = new ArrayDeque();
        this.bJH = -1L;
        this.bJz = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo abh() {
        return this.bJz;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abi() {
        return this.bJD;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abj() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores abk() {
        return this.bJA;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.bJA = swanAppCores;
        }
        return this;
    }

    public boolean abl() {
        return abm();
    }

    public boolean abm() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.bJG = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.bJB = prefetchEvent;
    }

    public c abn() {
        synchronized (c.class) {
            abr();
            this.mMessenger = null;
            this.bJA = null;
            g(null);
            abt();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.abu().kB("b4 preload: " + this.bJz);
        this.bJC = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.TW();
        }
        abo();
        Intent intent = new Intent(context, this.bJz.service);
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

    public c abo() {
        e.abu().kB("b4 tryPreBind: " + this.bJz);
        Application TW = com.baidu.swan.apps.w.a.TW();
        if (this.bJE == null) {
            this.bJE = new b();
            Intent intent = new Intent(TW, this.bJz.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                TW.bindService(intent, this.bJE, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            abp();
        }
        return this;
    }

    c abp() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.bJF.isEmpty()) {
            Message peek = this.bJF.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.abu().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.bJF.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && abl()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                aba();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.bJF.offer(message);
        abp();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.bJF.offer(message);
        }
        abp();
        return true;
    }

    public c kv(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.abu().abv().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c abq() {
        abr();
        e.abu().abv().b("event_puppet_unload_app", this);
        return this;
    }

    public c abr() {
        this.mAppId = "";
        g(null);
        this.bJH = -1L;
        return this;
    }

    public c abs() {
        this.bJD = true;
        this.bJC = 0L;
        if (this.bJG != null) {
            this.bJG.b(this);
        }
        return this;
    }

    public c abt() {
        this.bJD = false;
        this.bJC = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.bJz.toString();
        objArr[1] = Integer.valueOf(abl() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.bJD ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.bJC));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            kv(string);
            e.abu().c(string, this);
            com.baidu.swan.apps.process.messaging.a.aaL().ks(string);
            abt();
        }
        return abo();
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
            this.bJH = j;
            e.abu().abv().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aba() {
        this.mMessenger = null;
        this.bJE = null;
        abn();
        e abu = e.abu();
        abu.abv().b("event_puppet_offline", this);
        abu.kB("onSwanClientConnDown => " + this);
        abu.abz();
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
            e abu = e.abu();
            abu.abv().b("event_puppet_online", c.this);
            abu.kB("on main bind to swan: " + c.this.bJz);
            c.this.abp();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aba();
        }
    }
}
