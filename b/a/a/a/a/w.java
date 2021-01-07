package b.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class w {
    private static w AW;
    public final x AX;
    public final WifiManager AY;
    public final LocationManager AZ;
    public final SharedPreferences Ba;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1082a;
    public final ExecutorService c;
    final PackageManager d;
    public final TelephonyManager e;

    private w(Context context) {
        this.f1082a = context;
        this.d = this.f1082a.getPackageManager();
        this.e = (TelephonyManager) this.f1082a.getSystemService("phone");
        this.AY = (WifiManager) this.f1082a.getApplicationContext().getSystemService("wifi");
        this.AZ = (LocationManager) this.f1082a.getSystemService("location");
        this.Ba = this.f1082a.getSharedPreferences("loc_sdk_lite", 0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, AppStatusRules.DEFAULT_GRANULARITY, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        this.c = threadPoolExecutor;
        this.AX = new x(this);
        this.AX.a();
    }

    public static w G(Context context) {
        if (AW == null) {
            synchronized (w.class) {
                try {
                    if (AW == null) {
                        AW = new w(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return AW;
    }

    public final boolean a() {
        return this.e != null;
    }

    public final boolean b() {
        return this.AY != null;
    }

    public final boolean c() {
        return this.AZ != null;
    }

    public final String d() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1082a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase() + "[" + activeNetworkInfo.getSubtypeName() + "]";
        } catch (Throwable th) {
            return "NONE";
        }
    }
}
