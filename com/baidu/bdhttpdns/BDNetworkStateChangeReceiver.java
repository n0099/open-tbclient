package com.baidu.bdhttpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class BDNetworkStateChangeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1571a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1572b = true;
    private boolean c = true;
    private String d = "";
    private boolean e = true;
    private boolean f = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Callable<Object> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            InetSocketAddress inetSocketAddress = new InetSocketAddress("2001:4860:4860::8888", (int) Constants.SOCKET_PORT_SSL);
            try {
                new DatagramSocket().connect(new InetSocketAddress("180.76.76.76", 80));
            } catch (SocketException e) {
                BDNetworkStateChangeReceiver.this.f = false;
            }
            try {
                new DatagramSocket().connect(inetSocketAddress);
            } catch (SocketException e2) {
                BDNetworkStateChangeReceiver.this.e = false;
            }
            l.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(BDNetworkStateChangeReceiver.this.f), Boolean.valueOf(BDNetworkStateChangeReceiver.this.e));
            return null;
        }
    }

    private void a(Context context) {
        l.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.f1572b), Boolean.valueOf(this.c));
        i st = i.st();
        st.b();
        BDHttpDns P = BDHttpDns.P(context);
        refreshIpReachable();
        ArrayList<String> b2 = P.sk().b();
        if (this.f1572b) {
            P.sk().a();
            P.sl().a();
        }
        if (this.c) {
            if (isIPv6Only()) {
                l.a("Now the network is Ipv6 Only, Will not send prefetch request. ", new Object[0]);
            } else if (b2 == null || b2.isEmpty()) {
            } else {
                st.a(b2, new k(context));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f1572b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.c = z;
    }

    public boolean isIPv6Only() {
        return !this.f && this.e;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        ConnectivityManager connectivityManager;
        if (!this.f1571a) {
            this.f1571a = true;
            return;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (RuntimeException e) {
            e = e;
            str = "";
        }
        if (connectivityManager == null) {
            a(context);
            return;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        str = (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) ? (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) ? "" : networkInfo2.getExtraInfo().toString() : networkInfo.getExtraInfo().toString();
        try {
            if (!this.d.equals(str) && str != "") {
                l.a("Current net type: %s.", str);
                a(context);
            }
        } catch (RuntimeException e2) {
            e = e2;
            e.printStackTrace();
            try {
                a(context);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.d = str;
        }
        this.d = str;
    }

    public void refreshIpReachable() {
        Executors.newFixedThreadPool(1).submit(new a());
    }
}
