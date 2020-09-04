package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {
    public static String dnq = "wifi_resume_download_flag";
    private static volatile b dnr;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aKl() {
        if (dnr == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dnr == null) {
                    dnr = new b();
                }
            }
        }
        return dnr;
    }

    public void gw(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dnq, z);
        edit.commit();
    }

    public boolean aKm() {
        return this.mPreferences.getBoolean(dnq, true);
    }
}
