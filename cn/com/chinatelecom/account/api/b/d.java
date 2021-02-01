package cn.com.chinatelecom.account.api.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import cn.com.chinatelecom.account.api.CtAuth;
import java.net.InetAddress;
/* loaded from: classes3.dex */
public class d extends cn.com.chinatelecom.account.api.b.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1110b = d.class.getSimpleName();
    private a f;
    private boolean c = false;
    private ConnectivityManager d = null;
    private ConnectivityManager.NetworkCallback e = null;
    private long g = 0;
    private long h = 0;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(int i, String str, long j);

        void a(Network network, long j);
    }

    public static int a(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (Throwable th) {
            CtAuth.warn(f1110b, "When InetAddress.getByName(),throws exception", th);
            return -1;
        }
    }

    @TargetApi(21)
    private void a(Context context) {
        this.g = 0L;
        this.d = (ConnectivityManager) context.getSystemService("connectivity");
        this.h = System.currentTimeMillis();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        NetworkRequest build = builder.build();
        this.e = new ConnectivityManager.NetworkCallback() { // from class: cn.com.chinatelecom.account.api.b.d.2
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                long currentTimeMillis = System.currentTimeMillis();
                d.this.g = currentTimeMillis - d.this.h;
                d.this.c = true;
                if (d.this.f != null) {
                    d.this.f.a(network, d.this.g);
                }
                if (d.this.d != null) {
                    try {
                        d.this.d.unregisterNetworkCallback(this);
                        d.this.d = null;
                    } catch (Throwable th) {
                        CtAuth.warn(d.f1110b, "switchToMobileForAboveL", th);
                    }
                }
            }
        };
        this.d.requestNetwork(build, this.e);
    }

    public static String b(String str) {
        int indexOf = str.indexOf("://");
        if (indexOf > 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 >= 0) {
            str = str.substring(0, indexOf3);
        }
        int indexOf4 = str.indexOf(63);
        return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (Build.VERSION.SDK_INT < 21 || this.d == null || this.e == null) {
            return;
        }
        try {
            this.d.unregisterNetworkCallback(this.e);
        } catch (Throwable th) {
            CtAuth.warn(f1110b, "unregisterNetworkCallback", th);
        }
        this.d = null;
    }

    private boolean b(Context context, String str) {
        boolean z;
        try {
            Class<?> cls = Class.forName("android.net.ConnectivityManager");
            this.g = 0L;
            this.h = System.currentTimeMillis();
            this.d = (ConnectivityManager) context.getSystemService("connectivity");
            if (this.d.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(this.d, 0, "enableHIPRI");
                for (int i = 0; i < 5 && this.d.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i++) {
                    Thread.sleep(500L);
                }
            }
            z = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(this.d, 5, Integer.valueOf(a(b(str))))).booleanValue();
            try {
                this.g = System.currentTimeMillis() - this.h;
                CtAuth.info(f1110b, "Switch network result ： " + z + " (4.x) , expendTime ：" + this.g);
            } catch (Throwable th) {
                th = th;
                CtAuth.warn(f1110b, "4.x网络切换异常", th);
                return z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        return z;
    }

    public void a(final int i) {
        f.a(new Runnable() { // from class: cn.com.chinatelecom.account.api.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (i > 2500) {
                    try {
                        Thread.sleep(2500L);
                    } catch (Throwable th) {
                        CtAuth.warn(d.f1110b, "timeoutCheckRunnable exception!", th);
                    }
                    if (!d.this.c) {
                        if (d.this.f != null) {
                            d.this.f.a(-720002, "切换移动网络超时", 2500L);
                        }
                        CtAuth.info(d.f1110b, "切换网络超时(L)");
                        d.this.b();
                        return;
                    }
                }
                try {
                    Thread.sleep(i <= 2500 ? i : i - 2500);
                } catch (Throwable th2) {
                    CtAuth.warn(d.f1110b, "timeoutCheckRunnable exception!", th2);
                }
                if (d.this.f != null) {
                    d.this.f.a();
                }
            }
        });
    }

    public void a(Context context, a aVar) {
        this.f = aVar;
        try {
            a(context);
        } catch (Throwable th) {
            CtAuth.warn(f1110b, "switchToMobileForAboveL", th);
            if (this.f != null) {
                this.f.a(-720001, "切换网络出现异常", -1L);
            }
        }
    }

    public boolean a(Context context, String str) {
        return b(context, str);
    }
}
