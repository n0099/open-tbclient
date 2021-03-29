package com.baidu.bdhttpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import d.b.g.j;
import d.b.g.k;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class BDNetworkStateChangeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4280a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4281b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4282c = true;

    /* renamed from: d  reason: collision with root package name */
    public String f4283d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f4284e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4285f = true;

    /* loaded from: classes.dex */
    public class a implements Callable<Object> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            InetSocketAddress inetSocketAddress = new InetSocketAddress("2001:4860:4860::8888", (int) Constants.SOCKET_PORT_SSL);
            try {
                new DatagramSocket().connect(new InetSocketAddress("180.76.76.76", 80));
            } catch (SocketException unused) {
                BDNetworkStateChangeReceiver.this.f4285f = false;
            }
            try {
                new DatagramSocket().connect(inetSocketAddress);
            } catch (SocketException unused2) {
                BDNetworkStateChangeReceiver.this.f4284e = false;
            }
            k.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(BDNetworkStateChangeReceiver.this.f4285f), Boolean.valueOf(BDNetworkStateChangeReceiver.this.f4284e));
            return null;
        }
    }

    private void a(Context context) {
        k.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.f4281b), Boolean.valueOf(this.f4282c));
        i b2 = i.b();
        b2.r();
        BDHttpDns j = BDHttpDns.j(context);
        refreshIpReachable();
        ArrayList<String> e2 = j.a().e();
        if (this.f4281b) {
            j.a().b();
            j.d().b();
        }
        if (this.f4282c) {
            if (isIPv6Only()) {
                k.a("Now the network is Ipv6 Only, Will not send prefetch request. ", new Object[0]);
            } else if (e2 == null || e2.isEmpty()) {
            } else {
                b2.o(e2, new j(context));
            }
        }
    }

    public void a(boolean z) {
        this.f4281b = z;
    }

    public void b(boolean z) {
        this.f4282c = z;
    }

    public boolean isIPv6Only() {
        return !this.f4285f && this.f4284e;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(1:(6:38|17|18|(1:21)|23|24)(1:37))(1:15)|16|17|18|(1:21)|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        r6 = r0;
        r0 = r9;
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
        a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        r0 = r9;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        ConnectivityManager connectivityManager;
        String extraInfo;
        String str2 = "";
        if (!this.f4280a) {
            this.f4280a = true;
            return;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (RuntimeException e2) {
            e = e2;
        }
        if (connectivityManager == null) {
            a(context);
            return;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            extraInfo = networkInfo.getExtraInfo();
        } else if (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) {
            str = "";
            if (!this.f4283d.equals(str) && str != "") {
                k.a("Current net type: %s.", str);
                a(context);
            }
            this.f4283d = str;
        } else {
            extraInfo = networkInfo2.getExtraInfo();
        }
        str = extraInfo.toString();
        if (!this.f4283d.equals(str)) {
            k.a("Current net type: %s.", str);
            a(context);
        }
        this.f4283d = str;
    }

    public void refreshIpReachable() {
        Executors.newFixedThreadPool(1).submit(new a());
    }
}
