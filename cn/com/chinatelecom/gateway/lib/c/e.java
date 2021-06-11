package cn.com.chinatelecom.gateway.lib.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.appcompat.widget.TooltipCompatHandler;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import java.lang.reflect.Method;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1587a = "e";

    /* renamed from: e  reason: collision with root package name */
    public a f1591e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1588b = false;

    /* renamed from: c  reason: collision with root package name */
    public ConnectivityManager f1589c = null;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f1590d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f1592f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f1593g = 0;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i2, String str, long j);

        void a(Network network, long j);
    }

    public static int a(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (Throwable th) {
            CtAuth.warn(f1587a, "When InetAddress.getByName(),throws exception", th);
            return -1;
        }
    }

    @TargetApi(21)
    private void a(Context context) {
        this.f1592f = 0L;
        this.f1589c = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1593g = System.currentTimeMillis();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        NetworkRequest build = builder.build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: cn.com.chinatelecom.gateway.lib.c.e.2
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                long currentTimeMillis = System.currentTimeMillis();
                e eVar = e.this;
                eVar.f1592f = currentTimeMillis - eVar.f1593g;
                e.this.f1588b = true;
                if (e.this.f1591e != null) {
                    e.this.f1591e.a(network, e.this.f1592f);
                }
                if (e.this.f1589c != null) {
                    try {
                        e.this.f1589c.unregisterNetworkCallback(this);
                        e.this.f1589c = null;
                    } catch (Throwable th) {
                        CtAuth.warn(e.f1587a, "switchToMobileForAboveL", th);
                    }
                }
            }
        };
        this.f1590d = networkCallback;
        this.f1589c.requestNetwork(build, networkCallback);
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
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback;
        if (Build.VERSION.SDK_INT < 21 || (connectivityManager = this.f1589c) == null || (networkCallback = this.f1590d) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            CtAuth.warn(f1587a, "unregisterNetworkCallback", th);
        }
        this.f1589c = null;
    }

    private boolean b(Context context, String str) {
        boolean z = false;
        try {
            Class<?> cls = Class.forName("android.net.ConnectivityManager");
            this.f1592f = 0L;
            this.f1593g = System.currentTimeMillis();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f1589c = connectivityManager;
            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                Method method = cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class);
                ConnectivityManager connectivityManager2 = this.f1589c;
                Object[] objArr = new Object[2];
                objArr[0] = 0;
                objArr[1] = "enableHIPRI";
                method.invoke(connectivityManager2, objArr);
                for (int i2 = 0; i2 < 5 && this.f1589c.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i2++) {
                    Thread.sleep(500L);
                }
            }
            z = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(this.f1589c, 5, Integer.valueOf(a(b(str))))).booleanValue();
            this.f1592f = System.currentTimeMillis() - this.f1593g;
            String str2 = f1587a;
            StringBuilder sb = new StringBuilder();
            sb.append("Switch network result ： ");
            sb.append(z);
            sb.append(" (4.x) , expendTime ：");
            sb.append(this.f1592f);
            CtAuth.info(str2, sb.toString());
        } catch (Throwable th) {
            CtAuth.warn(f1587a, "4.x网络切换异常", th);
        }
        return z;
    }

    public void a(final int i2) {
        i.a(new Runnable() { // from class: cn.com.chinatelecom.gateway.lib.c.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (i2 > 2500) {
                    try {
                        Thread.sleep(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                    } catch (Throwable th) {
                        CtAuth.warn(e.f1587a, "timeoutCheckRunnable exception!", th);
                    }
                    if (!e.this.f1588b) {
                        if (e.this.f1591e != null) {
                            e.this.f1591e.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                        }
                        CtAuth.info(e.f1587a, "切换网络超时(L)");
                        e.this.b();
                        return;
                    }
                }
                try {
                    Thread.sleep(i2 <= 2500 ? i2 : i2 - 2500);
                } catch (Throwable th2) {
                    CtAuth.warn(e.f1587a, "timeoutCheckRunnable exception!", th2);
                }
                if (e.this.f1591e != null) {
                    e.this.f1591e.a();
                }
            }
        });
    }

    public void a(Context context, a aVar) {
        this.f1591e = aVar;
        try {
            a(context);
        } catch (Throwable th) {
            CtAuth.warn(f1587a, "switchToMobileForAboveL", th);
            a aVar2 = this.f1591e;
            if (aVar2 != null) {
                aVar2.a(80801, "WIFI切换异常", -1L);
            }
        }
    }

    public boolean a(Context context, String str) {
        return b(context, str);
    }
}
