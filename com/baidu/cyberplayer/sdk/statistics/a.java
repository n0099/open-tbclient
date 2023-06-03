package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public c a;
    public boolean b;

    /* renamed from: com.baidu.cyberplayer.sdk.statistics.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0100a {
        public static final a a = new a();
    }

    public a() {
        this.b = false;
        this.a = new c(DpStatConstants.SESSION_TYPE_KERNEL);
    }

    public static a a() {
        return C0100a.a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        return this.a.a(jSONObject);
    }

    public void b() {
        if (this.b) {
            return;
        }
        this.b = true;
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
        String networkStatisticsNoOperator = DpNetworkUtils.getNetworkStatisticsNoOperator(applicationContext);
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_name", packageName));
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_version", str));
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SDK_VERSION, CyberVersion.getSDKVersionInternal()));
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "cuid", CyberPlayerManager.getClientID()));
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "network", networkStatisticsNoOperator));
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_KERNEL_SESSION_ID, System.currentTimeMillis()));
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_INIT));
        String str2 = CyberPlayerManager.getInstallOpts().get("abtest_sid");
        if (str2 != null) {
            this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "abtest_sid", str2));
        }
        this.a.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "abi", q.q()));
    }
}
