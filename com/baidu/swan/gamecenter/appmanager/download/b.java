package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes20.dex */
public class b {
    public static String ddd = "wifi_resume_download_flag";
    private static volatile b dde;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aBv() {
        if (dde == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dde == null) {
                    dde = new b();
                }
            }
        }
        return dde;
    }

    public void fZ(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(ddd, z);
        edit.commit();
    }

    public boolean aBw() {
        return this.mPreferences.getBoolean(ddd, true);
    }
}
