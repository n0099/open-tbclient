package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.mobads.sdk.internal.cj;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DpInitKernelSession {
    public DpStatDataList mBaseList;
    public boolean mInited;

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static final DpInitKernelSession INSTANCE = new DpInitKernelSession();
    }

    public DpInitKernelSession() {
        this.mInited = false;
        this.mBaseList = new DpStatDataList(DpStatConstants.SESSION_TYPE_KERNEL);
    }

    public static DpInitKernelSession getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public JSONObject toJson(JSONObject jSONObject) throws JSONException {
        return this.mBaseList.toJson(jSONObject);
    }

    public void init() {
        if (this.mInited) {
            return;
        }
        this.mInited = true;
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        String packageName = applicationContext.getPackageName();
        String str = cj.d;
        if (packageManager != null) {
            try {
                str = packageManager.getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        String networkStatisticsNoOperator = DpNetworkUtils.getNetworkStatisticsNoOperator(applicationContext);
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_name", packageName));
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_version", str));
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SDK_VERSION, CyberVersion.getSDKVersionInternal()));
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, "cuid", CyberPlayerManager.getClientID()));
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, "network", networkStatisticsNoOperator));
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_KERNEL_SESSION_ID, System.currentTimeMillis()));
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_INIT));
        String str2 = CyberPlayerManager.getInstallOpts().get("abtest_sid");
        if (str2 != null) {
            this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, "abtest_sid", str2));
        }
        this.mBaseList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_KERNEL, "abi", Utils.getLoadLibsABI()));
    }
}
