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
    public static long f11071a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f11072b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f11073c = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d  reason: collision with root package name */
    public boolean f11074d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f11075e;

    /* renamed from: f  reason: collision with root package name */
    public C0147a f11076f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11077g = false;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0147a extends BroadcastReceiver {
        public C0147a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            aVar.f11074d = aVar.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.f11074d + " isSticky: " + isInitialStickyBroadcast());
            }
            if (!a.this.f11074d || isInitialStickyBroadcast()) {
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
        NetworkInfo activeNetworkInfo = this.f11075e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public synchronized void exit() {
        if (this.f11077g) {
            this.mContext.unregisterReceiver(this.f11076f);
            this.f11077g = false;
        }
    }

    public static a b() {
        return f11072b;
    }

    public static a a(Context context) {
        if (f11072b == null) {
            synchronized (a.class) {
                if (f11072b == null) {
                    f11072b = new a(context);
                }
            }
        }
        return f11072b;
    }

    public synchronized void a() {
        if (!this.f11077g) {
            this.f11075e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f11073c);
            C0147a c0147a = new C0147a();
            this.f11076f = c0147a;
            this.mContext.registerReceiver(c0147a, intentFilter);
            this.f11077g = true;
        }
    }
}
