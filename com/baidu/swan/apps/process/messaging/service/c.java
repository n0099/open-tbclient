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
/* loaded from: classes9.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    public final SwanAppProcessInfo bEI;
    private SwanAppCores bEJ;
    public PrefetchEvent bEK;
    private long bEL;
    private boolean bEM;
    private b bEN;
    private final Deque<Message> bEO;
    private a bEP;
    private long bEQ;
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
        this.bEL = 0L;
        this.bEM = false;
        this.bEO = new ArrayDeque();
        this.bEQ = -1L;
        this.bEI = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo Yu() {
        return this.bEI;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean Yv() {
        return this.bEM;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean Yw() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores Yx() {
        return this.bEJ;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.bEJ = swanAppCores;
        }
        return this;
    }

    public boolean Yy() {
        return Yz();
    }

    public boolean Yz() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.bEP = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.bEK = prefetchEvent;
    }

    public c YA() {
        synchronized (c.class) {
            YE();
            this.mMessenger = null;
            this.bEJ = null;
            g(null);
            YG();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.YH().kj("b4 preload: " + this.bEI);
        this.bEL = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.Rk();
        }
        YB();
        Intent intent = new Intent(context, this.bEI.service);
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

    public c YB() {
        e.YH().kj("b4 tryPreBind: " + this.bEI);
        Application Rk = com.baidu.swan.apps.w.a.Rk();
        if (this.bEN == null) {
            this.bEN = new b();
            Intent intent = new Intent(Rk, this.bEI.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                Rk.bindService(intent, this.bEN, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            YC();
        }
        return this;
    }

    c YC() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.bEO.isEmpty()) {
            Message peek = this.bEO.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.YH().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.bEO.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && Yy()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                Yn();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.bEO.offer(message);
        YC();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.bEO.offer(message);
        }
        YC();
        return true;
    }

    public c kd(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.YH().YI().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c YD() {
        YE();
        e.YH().YI().b("event_puppet_unload_app", this);
        return this;
    }

    public c YE() {
        this.mAppId = "";
        g(null);
        this.bEQ = -1L;
        return this;
    }

    public c YF() {
        this.bEM = true;
        this.bEL = 0L;
        if (this.bEP != null) {
            this.bEP.b(this);
        }
        return this;
    }

    public c YG() {
        this.bEM = false;
        this.bEL = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.bEI.toString();
        objArr[1] = Integer.valueOf(Yy() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.bEM ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.bEL));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            kd(string);
            e.YH().c(string, this);
            com.baidu.swan.apps.process.messaging.a.XY().ka(string);
            YG();
        }
        return YB();
    }

    public c L(Bundle bundle) {
        return K(bundle);
    }

    public c M(Bundle bundle) {
        g(null);
        return K(bundle);
    }

    public c ap(long j) {
        if (j > 0) {
            this.bEQ = j;
            e.YH().YI().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yn() {
        this.mMessenger = null;
        this.bEN = null;
        YA();
        e YH = e.YH();
        YH.YI().b("event_puppet_offline", this);
        YH.kj("onSwanClientConnDown => " + this);
        YH.YM();
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
            c.this.mMessenger = new Messenger(iBinder);
            e YH = e.YH();
            YH.YI().b("event_puppet_online", c.this);
            YH.kj("on main bind to swan: " + c.this.bEI);
            c.this.YC();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.Yn();
        }
    }
}
