package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {
    public static String dZn = "wifi_resume_download_flag";
    private static volatile b dZo;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aSX() {
        if (dZo == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dZo == null) {
                    dZo = new b();
                }
            }
        }
        return dZo;
    }

    public void hS(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dZn, z);
        edit.commit();
    }

    public boolean aSY() {
        return this.mPreferences.getBoolean(dZn, true);
    }
}
