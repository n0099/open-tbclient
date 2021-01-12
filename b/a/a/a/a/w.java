package b.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class w {
    private static w AV;
    public final x AW;
    public final WifiManager AX;
    public final LocationManager AY;
    public final SharedPreferences AZ;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1081a;
    public final ExecutorService c;
    final PackageManager d;
    public final TelephonyManager e;

    private w(Context context) {
        this.f1081a = context;
        this.d = this.f1081a.getPackageManager();
        this.e = (TelephonyManager) this.f1081a.getSystemService("phone");
        this.AX = (WifiManager) this.f1081a.getApplicationContext().getSystemService("wifi");
        this.AY = (LocationManager) this.f1081a.getSystemService(Headers.LOCATION);
        this.AZ = this.f1081a.getSharedPreferences("loc_sdk_lite", 0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, AppStatusRules.DEFAULT_GRANULARITY, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        this.c = threadPoolExecutor;
        this.AW = new x(this);
        this.AW.a();
    }

    public static w G(Context context) {
        if (AV == null) {
            synchronized (w.class) {
                try {
                    if (AV == null) {
                        AV = new w(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return AV;
    }

    public final boolean a() {
        return this.e != null;
    }

    public final boolean b() {
        return this.AX != null;
    }

    public final boolean c() {
        return this.AY != null;
    }

    public final String d() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1081a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase() + "[" + activeNetworkInfo.getSubtypeName() + "]";
        } catch (Throwable th) {
            return "NONE";
        }
    }
}
