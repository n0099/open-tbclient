package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes6.dex */
public class b {
    public static String dBx = "wifi_resume_download_flag";
    private static volatile b dBy;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aNF() {
        if (dBy == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dBy == null) {
                    dBy = new b();
                }
            }
        }
        return dBy;
    }

    public void gQ(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dBx, z);
        edit.commit();
    }

    public boolean aNG() {
        return this.mPreferences.getBoolean(dBx, true);
    }
}
