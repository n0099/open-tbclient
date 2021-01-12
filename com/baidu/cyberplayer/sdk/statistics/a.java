package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1832a;
    private boolean c = false;

    /* renamed from: b  reason: collision with root package name */
    private c f1833b = new c(DpStatConstants.SESSION_TYPE_KERNEL);

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1832a == null) {
                f1832a = new a();
            }
            aVar = f1832a;
        }
        return aVar;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        return this.f1833b.a(jSONObject);
    }

    public void b() {
        if (this.c) {
            return;
        }
        this.c = true;
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        String packageName = applicationContext.getPackageName();
        String str = "0.0";
        if (packageManager != null) {
            try {
                str = packageManager.getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(applicationContext);
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_name", packageName));
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_version", str));
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SDK_VERSION, CyberPlayerManager.getSDKVersion()));
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "cuid", CyberPlayerManager.getClientID()));
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "network", networkStatisticsData));
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_KERNEL_SESSION_ID, System.currentTimeMillis()));
        this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_INIT));
        String str2 = CyberPlayerManager.getInstallOpts().get("abtest_sid");
        if (str2 != null) {
            this.f1833b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "abtest_sid", str2));
        }
    }
}
