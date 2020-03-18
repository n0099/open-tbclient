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
    public final SwanAppProcessInfo bJL;
    private SwanAppCores bJM;
    public PrefetchEvent bJN;
    private long bJO;
    private boolean bJP;
    private b bJQ;
    private final Deque<Message> bJR;
    private a bJS;
    private long bJT;
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
        this.bJO = 0L;
        this.bJP = false;
        this.bJR = new ArrayDeque();
        this.bJT = -1L;
        this.bJL = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo abk() {
        return this.bJL;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abl() {
        return this.bJP;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abm() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores abn() {
        return this.bJM;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.bJM = swanAppCores;
        }
        return this;
    }

    public boolean abo() {
        return abp();
    }

    public boolean abp() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.bJS = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.bJN = prefetchEvent;
    }

    public c abq() {
        synchronized (c.class) {
            abu();
            this.mMessenger = null;
            this.bJM = null;
            g(null);
            abw();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.abx().kA("b4 preload: " + this.bJL);
        this.bJO = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.TZ();
        }
        abr();
        Intent intent = new Intent(context, this.bJL.service);
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

    public c abr() {
        e.abx().kA("b4 tryPreBind: " + this.bJL);
        Application TZ = com.baidu.swan.apps.w.a.TZ();
        if (this.bJQ == null) {
            this.bJQ = new b();
            Intent intent = new Intent(TZ, this.bJL.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                TZ.bindService(intent, this.bJQ, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            abs();
        }
        return this;
    }

    c abs() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.bJR.isEmpty()) {
            Message peek = this.bJR.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.abx().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.bJR.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && abo()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                abd();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.bJR.offer(message);
        abs();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.bJR.offer(message);
        }
        abs();
        return true;
    }

    public c ku(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.abx().aby().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c abt() {
        abu();
        e.abx().aby().b("event_puppet_unload_app", this);
        return this;
    }

    public c abu() {
        this.mAppId = "";
        g(null);
        this.bJT = -1L;
        return this;
    }

    public c abv() {
        this.bJP = true;
        this.bJO = 0L;
        if (this.bJS != null) {
            this.bJS.b(this);
        }
        return this;
    }

    public c abw() {
        this.bJP = false;
        this.bJO = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.bJL.toString();
        objArr[1] = Integer.valueOf(abo() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.bJP ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.bJO));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            ku(string);
            e.abx().c(string, this);
            com.baidu.swan.apps.process.messaging.a.aaO().kr(string);
            abw();
        }
        return abr();
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
            this.bJT = j;
            e.abx().aby().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abd() {
        this.mMessenger = null;
        this.bJQ = null;
        abq();
        e abx = e.abx();
        abx.aby().b("event_puppet_offline", this);
        abx.kA("onSwanClientConnDown => " + this);
        abx.abC();
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
            e abx = e.abx();
            abx.aby().b("event_puppet_online", c.this);
            abx.kA("on main bind to swan: " + c.this.bJL);
            c.this.abs();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.abd();
        }
    }
}
