package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes16.dex */
public class b {
    public static String dOe = "wifi_resume_download_flag";
    private static volatile b dOf;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aRr() {
        if (dOf == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dOf == null) {
                    dOf = new b();
                }
            }
        }
        return dOf;
    }

    public void hp(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dOe, z);
        edit.commit();
    }

    public boolean aRs() {
        return this.mPreferences.getBoolean(dOe, true);
    }
}
