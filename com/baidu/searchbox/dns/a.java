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
    public static long f10008a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f10009b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10010c = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d  reason: collision with root package name */
    public boolean f10011d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f10012e;

    /* renamed from: f  reason: collision with root package name */
    public C0133a f10013f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10014g = false;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0133a extends BroadcastReceiver {
        public C0133a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            aVar.f10011d = aVar.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.f10011d + " isSticky: " + isInitialStickyBroadcast());
            }
            if (!a.this.f10011d || isInitialStickyBroadcast()) {
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
        NetworkInfo activeNetworkInfo = this.f10012e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public synchronized void exit() {
        if (this.f10014g) {
            this.mContext.unregisterReceiver(this.f10013f);
            this.f10014g = false;
        }
    }

    public static a b() {
        return f10009b;
    }

    public static a a(Context context) {
        if (f10009b == null) {
            synchronized (a.class) {
                if (f10009b == null) {
                    f10009b = new a(context);
                }
            }
        }
        return f10009b;
    }

    public synchronized void a() {
        if (!this.f10014g) {
            this.f10012e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f10010c);
            C0133a c0133a = new C0133a();
            this.f10013f = c0133a;
            this.mContext.registerReceiver(c0133a, intentFilter);
            this.f10014g = true;
        }
    }
}
