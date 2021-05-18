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
    public static long f10108a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f10109b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10110c = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d  reason: collision with root package name */
    public boolean f10111d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f10112e;

    /* renamed from: f  reason: collision with root package name */
    public C0132a f10113f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10114g = false;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0132a extends BroadcastReceiver {
        public C0132a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            aVar.f10111d = aVar.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.f10111d + " isSticky: " + isInitialStickyBroadcast());
            }
            if (!a.this.f10111d || isInitialStickyBroadcast()) {
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
        NetworkInfo activeNetworkInfo = this.f10112e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public synchronized void exit() {
        if (this.f10114g) {
            this.mContext.unregisterReceiver(this.f10113f);
            this.f10114g = false;
        }
    }

    public static a b() {
        return f10109b;
    }

    public static a a(Context context) {
        if (f10109b == null) {
            synchronized (a.class) {
                if (f10109b == null) {
                    f10109b = new a(context);
                }
            }
        }
        return f10109b;
    }

    public synchronized void a() {
        if (!this.f10114g) {
            this.f10112e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f10110c);
            C0132a c0132a = new C0132a();
            this.f10113f = c0132a;
            this.mContext.registerReceiver(c0132a, intentFilter);
            this.f10114g = true;
        }
    }
}
