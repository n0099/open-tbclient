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
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    private a bFA;
    private long bFB;
    public final SwanAppProcessInfo bFt;
    private SwanAppCores bFu;
    public PrefetchEvent bFv;
    private long bFw;
    private boolean bFx;
    private b bFy;
    private final Deque<Message> bFz;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes10.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.bFw = 0L;
        this.bFx = false;
        this.bFz = new ArrayDeque();
        this.bFB = -1L;
        this.bFt = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo YR() {
        return this.bFt;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean YS() {
        return this.bFx;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean YT() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores YU() {
        return this.bFu;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.bFu = swanAppCores;
        }
        return this;
    }

    public boolean YV() {
        return YW();
    }

    public boolean YW() {
        return this.mMessenger != null;
    }

    public void a(a aVar) {
        this.bFA = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.bFv = prefetchEvent;
    }

    public c YX() {
        synchronized (c.class) {
            Zb();
            this.mMessenger = null;
            this.bFu = null;
            g(null);
            Zd();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        e.Ze().km("b4 preload: " + this.bFt);
        this.bFw = System.currentTimeMillis();
        if (context == null) {
            context = com.baidu.swan.apps.w.a.RG();
        }
        YY();
        Intent intent = new Intent(context, this.bFt.service);
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

    public c YY() {
        e.Ze().km("b4 tryPreBind: " + this.bFt);
        Application RG = com.baidu.swan.apps.w.a.RG();
        if (this.bFy == null) {
            this.bFy = new b();
            Intent intent = new Intent(RG, this.bFt.service);
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            try {
                RG.bindService(intent, this.bFy, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMessenger != null) {
            YZ();
        }
        return this;
    }

    c YZ() {
        log("flushCachedMsgs");
        while (this.mMessenger != null && !this.bFz.isEmpty()) {
            Message peek = this.bFz.peek();
            if (peek.replyTo == null) {
                peek.replyTo = e.Ze().mMessenger;
            }
            if (!I(peek)) {
                break;
            }
            this.bFz.poll();
        }
        return this;
    }

    private boolean I(Message message) {
        if (message != null && YV()) {
            try {
                this.mMessenger.send(message);
                return true;
            } catch (RemoteException e) {
                YK();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean J(Message message) {
        this.bFz.offer(message);
        YZ();
        return true;
    }

    public boolean e(Collection<Message> collection) {
        for (Message message : collection) {
            this.bFz.offer(message);
        }
        YZ();
        return true;
    }

    public c kg(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.Ze().Zf().b("event_puppet_load_app", this);
        }
        return this;
    }

    public c Za() {
        Zb();
        e.Ze().Zf().b("event_puppet_unload_app", this);
        return this;
    }

    public c Zb() {
        this.mAppId = "";
        g(null);
        this.bFB = -1L;
        return this;
    }

    public c Zc() {
        this.bFx = true;
        this.bFw = 0L;
        if (this.bFA != null) {
            this.bFA.b(this);
        }
        return this;
    }

    public c Zd() {
        this.bFx = false;
        this.bFw = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.bFt.toString();
        objArr[1] = Integer.valueOf(YV() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.bFx ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.bFw));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c K(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            kg(string);
            e.Ze().c(string, this);
            com.baidu.swan.apps.process.messaging.a.Yv().kd(string);
            Zd();
        }
        return YY();
    }

    public c L(Bundle bundle) {
        return K(bundle);
    }

    public c M(Bundle bundle) {
        g(null);
        return K(bundle);
    }

    public c as(long j) {
        if (j > 0) {
            this.bFB = j;
            e.Ze().Zf().b("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YK() {
        this.mMessenger = null;
        this.bFy = null;
        YX();
        e Ze = e.Ze();
        Ze.Zf().b("event_puppet_offline", this);
        Ze.km("onSwanClientConnDown => " + this);
        Ze.Zj();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.mMessenger = new Messenger(iBinder);
            e Ze = e.Ze();
            Ze.Zf().b("event_puppet_online", c.this);
            Ze.km("on main bind to swan: " + c.this.bFt);
            c.this.YZ();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.YK();
        }
    }
}
