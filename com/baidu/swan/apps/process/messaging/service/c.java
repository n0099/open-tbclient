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
    public final SwanAppProcessInfo cBq;
    private SwanAppCores cBr;
    public PrefetchEvent cBs;
    private long cBt;
    private boolean cBu;
    private b cBv;
    private final Deque<Message> cBw;
    private a cBx;
    private long cBy;
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
        this.cBt = 0L;
        this.cBu = false;
        this.cBw = new ArrayDeque();
        this.cBy = -1L;
        this.cBq = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo apS() {
        return this.cBq;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean apT() {
        return this.cBu;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean apU() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores apV() {
        return this.cBr;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.cBr = swanAppCores;
        }
        return this;
    }

    public boolean apW() {
        return apX();
    }

    public boolean apX() {
        boolean z;
        synchronized (this.cBq) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public void a(a aVar) {
        this.cBx = aVar;
    }

    public void h(PrefetchEvent prefetchEvent) {
        this.cBs = prefetchEvent;
    }

    public c apY() {
        synchronized (this.cBq) {
            aqc();
            this.mMessenger = null;
            this.cBr = null;
            h(null);
            aqe();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                e.aqf().nX("b4 preload: " + this.cBq);
            }
        } else {
            e.aqf().nX("b4 preload: " + this.cBq);
        }
        a(true, context, bundle);
        return this;
    }

    public c apZ() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                e.aqf().nX("b4 tryPreBind: " + this.cBq);
            }
        } else {
            e.aqf().nX("b4 tryPreBind: " + this.cBq);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.ahj();
        }
        Intent intent = new Intent(context, this.cBq.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.cBt = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.cBq) {
            try {
                if (this.cBv == null) {
                    this.cBv = new b();
                    context.bindService(intent, this.cBv, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aqa();
            }
        }
        return this;
    }

    c aqa() {
        log("flushCachedMsgs");
        synchronized (this.cBq) {
            while (this.mMessenger != null && !this.cBw.isEmpty()) {
                Message peek = this.cBw.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aqf().mMessenger;
                }
                if (!J(peek)) {
                    break;
                }
                this.cBw.poll();
            }
        }
        return this;
    }

    private boolean J(Message message) {
        synchronized (this.cBq) {
            if (message != null) {
                if (apW()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        apL();
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
        this.cBw.offer(message);
        aqa();
        return true;
    }

    public boolean g(Collection<Message> collection) {
        for (Message message : collection) {
            this.cBw.offer(message);
        }
        aqa();
        return true;
    }

    public c nR(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aqf().aqg().c("event_puppet_load_app", this);
        }
        return this;
    }

    public c aqb() {
        aqc();
        e.aqf().aqg().c("event_puppet_unload_app", this);
        return this;
    }

    public c aqc() {
        this.mAppId = "";
        h(null);
        this.cBy = -1L;
        return this;
    }

    public c aqd() {
        this.cBu = true;
        this.cBt = 0L;
        if (this.cBx != null) {
            this.cBx.b(this);
        }
        return this;
    }

    public c aqe() {
        this.cBu = false;
        this.cBt = 0L;
        h(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.cBq.toString();
        objArr[1] = Integer.valueOf(apW() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.cBu ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.cBt));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c R(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            nR(string);
            e.aqf().d(string, this);
            com.baidu.swan.apps.process.messaging.a.apw().nO(string);
            aqe();
        }
        return apZ();
    }

    public c S(Bundle bundle) {
        return R(bundle);
    }

    public c T(Bundle bundle) {
        h(null);
        return R(bundle);
    }

    public c bw(long j) {
        if (j > 0) {
            this.cBy = j;
            e.aqf().aqg().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apL() {
        synchronized (this.cBq) {
            this.mMessenger = null;
            this.cBv = null;
            apY();
            e aqf = e.aqf();
            aqf.aqg().c("event_puppet_offline", this);
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                if (DEBUG) {
                    aqf.nX("onSwanClientConnDown => " + this);
                }
            } else {
                aqf.nX("onSwanClientConnDown => " + this);
            }
            aqf.aqk();
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
            synchronized (c.this.cBq) {
                c.this.mMessenger = new Messenger(iBinder);
                e aqf = e.aqf();
                aqf.aqg().c("event_puppet_online", c.this);
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    if (c.DEBUG) {
                        aqf.nX("on main bind to swan: " + c.this.cBq);
                    }
                } else {
                    aqf.nX("on main bind to swan: " + c.this.cBq);
                }
                c.this.aqa();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.apL();
        }
    }
}
