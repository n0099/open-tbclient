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
/* loaded from: classes3.dex */
public final class c extends com.baidu.swan.apps.process.messaging.b {
    static final boolean DEBUG = com.baidu.swan.apps.process.messaging.a.DEBUG;
    public final SwanAppProcessInfo cLD;
    private SwanAppCores cLE;
    public PrefetchEvent cLF;
    private boolean cLG;
    private long cLH;
    private long cLI;
    private boolean cLJ;
    private b cLK;
    private final Deque<Message> cLL;
    private a cLM;
    private long cLN;
    public String mAppId;
    private Messenger mMessenger;

    /* loaded from: classes3.dex */
    public interface a {
        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new com.baidu.swan.apps.runtime.c());
        this.mAppId = "";
        this.mMessenger = null;
        this.cLG = true;
        this.cLH = 0L;
        this.cLI = 0L;
        this.cLJ = false;
        this.cLL = new ArrayDeque();
        this.cLN = -1L;
        this.cLD = swanAppProcessInfo;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ayy() {
        return this.cLD;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean ayz() {
        return this.cLJ;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean ayA() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores ayB() {
        return this.cLE;
    }

    public c a(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.cLE = swanAppCores;
        }
        return this;
    }

    public boolean ayC() {
        return ayD();
    }

    public boolean ayD() {
        boolean z;
        synchronized (this.cLD) {
            z = this.mMessenger != null;
        }
        return z;
    }

    public boolean ayE() {
        return this.cLG;
    }

    public void ayF() {
        this.cLH = System.currentTimeMillis();
    }

    public boolean ayG() {
        return System.currentTimeMillis() - this.cLH < ((long) com.baidu.swan.apps.performance.b.c.awX());
    }

    public long ayH() {
        return System.currentTimeMillis() - this.cLH;
    }

    public void a(a aVar) {
        this.cLM = aVar;
    }

    public void g(PrefetchEvent prefetchEvent) {
        this.cLF = prefetchEvent;
    }

    public c ayI() {
        synchronized (this.cLD) {
            ayM();
            this.mMessenger = null;
            this.cLE = null;
            g(null);
            ayO();
        }
        return this;
    }

    public c e(Context context, Bundle bundle) {
        if (DEBUG) {
            e.ayP().qp("b4 preload: " + this.cLD);
        }
        a(true, context, bundle);
        return this;
    }

    public c ayJ() {
        return a(false, null, null);
    }

    public c a(boolean z, Context context, Bundle bundle) {
        if (DEBUG) {
            e.ayP().qp("b4 tryPreBind: " + this.cLD);
        }
        if (context == null) {
            context = com.baidu.swan.apps.t.a.apu();
        }
        Intent intent = new Intent(context, this.cLD.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.cLI = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.cLD) {
            try {
                if (this.cLK == null) {
                    this.cLK = new b();
                    context.bindService(intent, this.cLK, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (this.mMessenger != null) {
                ayK();
            }
        }
        return this;
    }

    c ayK() {
        log("flushCachedMsgs");
        synchronized (this.cLD) {
            while (this.mMessenger != null && !this.cLL.isEmpty()) {
                Message peek = this.cLL.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.ayP().mMessenger;
                }
                if (!K(peek)) {
                    break;
                }
                this.cLL.poll();
            }
        }
        return this;
    }

    private boolean K(Message message) {
        synchronized (this.cLD) {
            if (message != null) {
                if (ayC()) {
                    try {
                        this.mMessenger.send(message);
                        return true;
                    } catch (RemoteException | RuntimeException e) {
                        ayq();
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
        this.cLL.offer(message);
        ayK();
        return true;
    }

    public boolean i(Collection<Message> collection) {
        for (Message message : collection) {
            this.cLL.offer(message);
        }
        ayK();
        return true;
    }

    public c qj(String str) {
        if (!TextUtils.equals(str, this.mAppId)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.mAppId = str;
            e.ayP().ayQ().c("event_puppet_load_app", this);
            this.cLG = true;
        } else {
            this.cLG = false;
        }
        return this;
    }

    public c ayL() {
        ayM();
        e.ayP().ayQ().c("event_puppet_unload_app", this);
        return this;
    }

    public c ayM() {
        this.mAppId = "";
        g(null);
        this.cLN = -1L;
        return this;
    }

    public c ayN() {
        this.cLJ = true;
        this.cLI = 0L;
        if (this.cLM != null) {
            this.cLM.b(this);
        }
        return this;
    }

    public c ayO() {
        this.cLJ = false;
        this.cLI = 0L;
        g(null);
        return this;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        objArr[0] = this.cLD.toString();
        objArr[1] = Integer.valueOf(ayC() ? 1 : 0);
        objArr[2] = Integer.valueOf(this.cLJ ? 1 : 0);
        objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.cLI));
        objArr[4] = this.mAppId;
        return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
    }

    private c P(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        a(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString("app_id");
        if (!TextUtils.isEmpty(string)) {
            qj(string);
            e.ayP().d(string, this);
            com.baidu.swan.apps.process.messaging.a.ayb().qg(string);
            ayO();
        }
        return ayJ();
    }

    public c Q(Bundle bundle) {
        return P(bundle);
    }

    public c R(Bundle bundle) {
        g(null);
        return P(bundle);
    }

    public c bE(long j) {
        if (j > 0) {
            this.cLN = j;
            e.ayP().ayQ().c("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayq() {
        synchronized (this.cLD) {
            this.mMessenger = null;
            this.cLK = null;
            ayI();
            e ayP = e.ayP();
            ayP.ayQ().c("event_puppet_offline", this);
            if (DEBUG) {
                ayP.qp("onSwanClientConnDown => " + this);
            }
            ayP.ayU();
        }
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanClientPuppet", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.cLD) {
                c.this.mMessenger = new Messenger(iBinder);
                e ayP = e.ayP();
                ayP.ayQ().c("event_puppet_online", c.this);
                if (c.DEBUG) {
                    ayP.qp("on main bind to swan: " + c.this.cLD);
                }
                c.this.ayK();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.ayq();
        }
    }
}
