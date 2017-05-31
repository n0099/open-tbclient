package com.baidu.location.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
/* loaded from: classes.dex */
public class h {
    private static h Ny = null;
    private a Nz = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;
    final Handler a = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || h.this.a == null) {
                return;
            }
            h.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.d && com.baidu.location.c.b.mE().e() && com.baidu.location.e.d.mM().d()) {
                new l(this).start();
            }
            if (h.this.d && com.baidu.location.c.b.mE().e()) {
                f.mI().d();
            }
            if (!h.this.d || !h.this.g) {
                h.this.f = false;
                return;
            }
            h.this.a.postDelayed(this, com.baidu.location.h.i.N);
            h.this.f = true;
        }
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        NetworkInfo.State state;
        NetworkInfo.State state2 = NetworkInfo.State.UNKNOWN;
        try {
            state = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (NetworkInfo.State.CONNECTED != state) {
            this.d = false;
        } else if (this.d) {
        } else {
            this.d = true;
            this.a.postDelayed(new b(), com.baidu.location.h.i.N);
            this.f = true;
        }
    }

    public static synchronized h mK() {
        h hVar;
        synchronized (h.class) {
            if (Ny == null) {
                Ny = new h();
            }
            hVar = Ny;
        }
        return hVar;
    }

    public synchronized void b() {
        if (com.baidu.location.f.isServing && !this.h) {
            try {
                this.Nz = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                com.baidu.location.f.getServiceContext().registerReceiver(this.Nz, intentFilter);
                this.e = true;
                f();
            } catch (Exception e) {
            }
            this.g = true;
            this.h = true;
        }
    }

    public synchronized void c() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.Nz);
            } catch (Exception e) {
            }
            this.g = false;
            this.h = false;
            this.f = false;
            this.Nz = null;
        }
    }

    public void d() {
        if (this.h) {
            this.g = true;
            if (this.f || !this.g) {
                return;
            }
            this.a.postDelayed(new b(), com.baidu.location.h.i.N);
            this.f = true;
        }
    }

    public void e() {
        this.g = false;
    }
}
