package com.baidu.searchbox.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsUtil;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f11254a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f11255b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f11256c = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d  reason: collision with root package name */
    public boolean f11257d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f11258e;

    /* renamed from: f  reason: collision with root package name */
    public C0153a f11259f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11260g = false;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0153a extends BroadcastReceiver {
        public C0153a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            aVar.f11257d = aVar.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.f11257d + " isSticky: " + isInitialStickyBroadcast());
            }
            if (!a.this.f11257d || isInitialStickyBroadcast()) {
                return;
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "clear dns cache and force update domain");
            }
            com.baidu.searchbox.dns.a.a.e().clear();
            b.d();
        }
    }

    public a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        NetworkInfo activeNetworkInfo = this.f11258e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public synchronized void exit() {
        if (this.f11260g) {
            this.mContext.unregisterReceiver(this.f11259f);
            this.f11260g = false;
        }
    }

    public static a b() {
        return f11255b;
    }

    public static a a(Context context) {
        if (f11255b == null) {
            synchronized (a.class) {
                if (f11255b == null) {
                    f11255b = new a(context);
                }
            }
        }
        return f11255b;
    }

    public synchronized void a() {
        if (!this.f11260g) {
            this.f11258e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f11256c);
            C0153a c0153a = new C0153a();
            this.f11259f = c0153a;
            this.mContext.registerReceiver(c0153a, intentFilter);
            this.f11260g = true;
        }
    }
}
