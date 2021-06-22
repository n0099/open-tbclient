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
    public static long f10102a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f10103b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10104c = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d  reason: collision with root package name */
    public boolean f10105d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f10106e;

    /* renamed from: f  reason: collision with root package name */
    public C0134a f10107f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10108g = false;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0134a extends BroadcastReceiver {
        public C0134a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            aVar.f10105d = aVar.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.f10105d + " isSticky: " + isInitialStickyBroadcast());
            }
            if (!a.this.f10105d || isInitialStickyBroadcast()) {
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
        NetworkInfo activeNetworkInfo = this.f10106e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public synchronized void exit() {
        if (this.f10108g) {
            this.mContext.unregisterReceiver(this.f10107f);
            this.f10108g = false;
        }
    }

    public static a b() {
        return f10103b;
    }

    public static a a(Context context) {
        if (f10103b == null) {
            synchronized (a.class) {
                if (f10103b == null) {
                    f10103b = new a(context);
                }
            }
        }
        return f10103b;
    }

    public synchronized void a() {
        if (!this.f10108g) {
            this.f10106e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f10104c);
            C0134a c0134a = new C0134a();
            this.f10107f = c0134a;
            this.mContext.registerReceiver(c0134a, intentFilter);
            this.f10108g = true;
        }
    }
}
