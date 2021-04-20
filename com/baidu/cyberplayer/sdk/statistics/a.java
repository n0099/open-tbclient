package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f5100a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5102c = false;

    /* renamed from: b  reason: collision with root package name */
    public c f5101b = new c(DpStatConstants.SESSION_TYPE_KERNEL);

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f5100a == null) {
                f5100a = new a();
            }
            aVar = f5100a;
        }
        return aVar;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        return this.f5101b.a(jSONObject);
    }

    public void b() {
        if (this.f5102c) {
            return;
        }
        this.f5102c = true;
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        String packageName = applicationContext.getPackageName();
        String str = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        if (packageManager != null) {
            try {
                str = packageManager.getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(applicationContext);
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_APP_NAME, packageName));
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_version", str));
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SDK_VERSION, CyberPlayerManager.getSDKVersion()));
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "cuid", CyberPlayerManager.getClientID()));
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "network", networkStatisticsData));
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_KERNEL_SESSION_ID, System.currentTimeMillis()));
        this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_INIT));
        String str2 = CyberPlayerManager.getInstallOpts().get("abtest_sid");
        if (str2 != null) {
            this.f5101b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "abtest_sid", str2));
        }
    }
}
