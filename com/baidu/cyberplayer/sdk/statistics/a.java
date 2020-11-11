package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1430a;
    private boolean c = false;
    private c b = new c(DpStatConstants.SESSION_TYPE_KERNEL);

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1430a == null) {
                f1430a = new a();
            }
            aVar = f1430a;
        }
        return aVar;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        return this.b.a(jSONObject);
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
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_name", packageName));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_version", str));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SDK_VERSION, CyberPlayerManager.getSDKVersion()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "cuid", CyberPlayerManager.getClientID()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "network", networkStatisticsData));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_KERNEL_SESSION_ID, System.currentTimeMillis()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_INIT));
        String str2 = CyberPlayerManager.getInstallOpts().get("abtest_sid");
        if (str2 != null) {
            this.b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "abtest_sid", str2));
        }
    }
}
