package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes16.dex */
public class b {
    public static String dVc = "wifi_resume_download_flag";
    private static volatile b dVd;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aUw() {
        if (dVd == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dVd == null) {
                    dVd = new b();
                }
            }
        }
        return dVd;
    }

    public void hE(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dVc, z);
        edit.commit();
    }

    public boolean aUx() {
        return this.mPreferences.getBoolean(dVc, true);
    }
}
