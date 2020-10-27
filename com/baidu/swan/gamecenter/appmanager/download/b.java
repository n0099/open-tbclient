package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes6.dex */
public class b {
    public static String dJU = "wifi_resume_download_flag";
    private static volatile b dJV;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aPz() {
        if (dJV == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dJV == null) {
                    dJV = new b();
                }
            }
        }
        return dJV;
    }

    public void hd(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dJU, z);
        edit.commit();
    }

    public boolean aPA() {
        return this.mPreferences.getBoolean(dJU, true);
    }
}
