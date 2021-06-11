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
    public static long f10070a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f10071b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10072c = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d  reason: collision with root package name */
    public boolean f10073d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f10074e;

    /* renamed from: f  reason: collision with root package name */
    public C0133a f10075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10076g = false;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0133a extends BroadcastReceiver {
        public C0133a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            aVar.f10073d = aVar.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.f10073d + " isSticky: " + isInitialStickyBroadcast());
            }
            if (!a.this.f10073d || isInitialStickyBroadcast()) {
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
        NetworkInfo activeNetworkInfo = this.f10074e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public synchronized void exit() {
        if (this.f10076g) {
            this.mContext.unregisterReceiver(this.f10075f);
            this.f10076g = false;
        }
    }

    public static a b() {
        return f10071b;
    }

    public static a a(Context context) {
        if (f10071b == null) {
            synchronized (a.class) {
                if (f10071b == null) {
                    f10071b = new a(context);
                }
            }
        }
        return f10071b;
    }

    public synchronized void a() {
        if (!this.f10076g) {
            this.f10074e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f10072c);
            C0133a c0133a = new C0133a();
            this.f10075f = c0133a;
            this.mContext.registerReceiver(c0133a, intentFilter);
            this.f10076g = true;
        }
    }
}
