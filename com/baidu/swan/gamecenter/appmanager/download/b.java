package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes14.dex */
public class b {
    public static String ecV = "wifi_resume_download_flag";
    private static volatile b ecW;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aTm() {
        if (ecW == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (ecW == null) {
                    ecW = new b();
                }
            }
        }
        return ecW;
    }

    public void hU(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(ecV, z);
        edit.commit();
    }

    public boolean aTn() {
        return this.mPreferences.getBoolean(ecV, true);
    }
}
