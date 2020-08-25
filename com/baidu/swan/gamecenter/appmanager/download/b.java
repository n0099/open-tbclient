package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {
    public static String dnm = "wifi_resume_download_flag";
    private static volatile b dnn;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aKl() {
        if (dnn == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dnn == null) {
                    dnn = new b();
                }
            }
        }
        return dnn;
    }

    public void gv(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dnm, z);
        edit.commit();
    }

    public boolean aKm() {
        return this.mPreferences.getBoolean(dnm, true);
    }
}
