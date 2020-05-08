package com.baidu.searchbox.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsUtil;
/* loaded from: classes13.dex */
public class a {
    private static volatile a b;
    private boolean d;
    private ConnectivityManager e;
    private C0233a f;
    private boolean g = false;
    private Context mContext;
    private static long a = 5000;
    private static String c = "android.net.conn.CONNECTIVITY_CHANGE";

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.g) {
            this.e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(c);
            this.f = new C0233a();
            this.mContext.registerReceiver(this.f, intentFilter);
            this.g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void exit() {
        if (this.g) {
            this.mContext.unregisterReceiver(this.f);
            this.g = false;
        }
    }

    public static a b() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        NetworkInfo activeNetworkInfo = this.e.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private class C0233a extends BroadcastReceiver {
        private C0233a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a.this.d = a.this.c();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + a.this.d + " isSticky: " + isInitialStickyBroadcast());
            }
            DnsUtil.initNetworkStackType();
            if (a.this.d && !isInitialStickyBroadcast()) {
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "clear dns cache and force update domain");
                }
                com.baidu.searchbox.dns.a.a.e().clear();
                b.d();
            }
        }
    }
}
