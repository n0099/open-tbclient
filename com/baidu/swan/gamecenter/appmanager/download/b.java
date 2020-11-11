package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes6.dex */
public class b {
    public static String dPM = "wifi_resume_download_flag";
    private static volatile b dPN;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aRZ() {
        if (dPN == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dPN == null) {
                    dPN = new b();
                }
            }
        }
        return dPN;
    }

    public void hm(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dPM, z);
        edit.commit();
    }

    public boolean aSa() {
        return this.mPreferences.getBoolean(dPM, true);
    }
}
