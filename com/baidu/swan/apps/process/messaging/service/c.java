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
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    public final SwanAppProcessInfo cXG;
    private SwanAppCores cXH;
    public PrefetchEvent cXI;
    private boolean cXJ;
    private long cXK;
    private long cXL;
    private boolean cXM;
    private b cXN;
    private final Deque<Message> cXO;
    private a cXP;
    private long cXQ;
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
        this.cXJ = true;
        this.cXK = 0L;
        this.cXL = 0L;
        this.cXM = false;
        this.cXO = new ArrayDeque();
        this.cXQ = -1L;
        this.cXG = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aBh() {
        return this.cXG;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aBi() {
        return this.cXM;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aBj() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aBk() {
        return this.cXH;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.cXH = swanAppCores;
        }
        return this;
    }

    public boolean aBl() {
        return aBm();
    }

    public boolean aBm() {
        boolean z;
        synchronized (this.cXG) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean aBn() {
        return this.cXJ;
    }

    public void aBo() {
        this.cXK = System.currentTimeMillis();
    }

    public boolean aBp() {
        return System.currentTimeMillis() - this.cXK < ((long) com.baidu.swan.apps.performance.b.c.azI());
    }

    public long aBq() {
        return System.currentTimeMillis() - this.cXK;
    }

    public void a(a aVar) {
        this.cXP = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.cXI = prefetchEvent;
    }

    public c aBr() {
        synchronized (this.cXG) {
            aBv();
            this.mMessenger = null;
            this.cXH = null;
            g(null);
            aBx();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.aBy().rb("b4 preload: " + this.cXG);
        }
        a(true, context, bundle);
        return this;
    }

    public c aBs() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.aBy().rb("b4 tryPreBind: " + this.cXG);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.asf();
        }
        Intent intent = new Intent(context, this.cXG.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.cXL = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.cXG) {
            try {
                if (this.cXN == null) {
                    this.cXN = new b();
                    context.bindService(intent, this.cXN, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                aBt();
            }
        }
        return this;
    }

    c aBt() {
        log("flushCachedMsgs");
        synchronized (this.cXG) {
            while (this.mMessenger != null && !this.cXO.isEmpty()) {
                Message peek = this.cXO.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.aBy().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.cXO.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.cXG) {
            if (message != null) {
                if (aBl()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        aAZ();
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean L(Message message) {
        this.cXO.offer(message);
        aBt();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.cXO.offer(message);
        }
        aBt();
        return true;
    }

    public c qV(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.aBy().aBz().c("event_puppet_load_app", this);
            this.cXJ = true;
        } else {
            this.cXJ = false;
        }
        return this;
    }

    public c aBu() {
        aBv();
        e.aBy().aBz().c("event_puppet_unload_app", this);
        return this;
    }

    public c aBv() {
        this.mAppId = "";
        g(null);
        this.cXQ = -1L;
        return this;
    }

    public c aBw() {
        this.cXM = true;
        this.cXL = 0L;
        if (this.cXP != null) {
            this.cXP.b(this);
        }
        return this;
    }

    public c aBx() {
        this.cXM = false;
        this.cXL = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.cXG.toString();
        objArr[1] = Integer.valueOf(aBl() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.cXM ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.cXL));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            qV(string);
            e.aBy().d(string, this);
            com.baidu.swan.apps.process.messaging.a.aAK().qS(string);
            aBx();
        }
        return aBs();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c bM(long j) {
        if (j > 0) {
            this.cXQ = j;
            e.aBy().aBz().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        synchronized (this.cXG) {
            this.mMessenger = null;
            this.cXN = null;
            aBr();
            e aBy = e.aBy();
            aBy.aBz().c("event_puppet_offline", this);
            if (DEBUG) {
                aBy.rb("onSwanClientConnDown => " + this);
            }
            aBy.aBD();
        }
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
            synchronized (c.this.cXG) {
                c.this.mMessenger = new Messenger(iBinder);
                e aBy = e.aBy();
                aBy.aBz().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    aBy.rb("on main bind to swan: " + c.this.cXG);
                }
                c.this.aBt();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.aAZ();
        }
    }
}
