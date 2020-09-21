package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes14.dex */
public class b {
    public static String dpt = "wifi_resume_download_flag";
    private static volatile b dpu;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aKW() {
        if (dpu == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (dpu == null) {
                    dpu = new b();
                }
            }
        }
        return dpu;
    }

    public void gu(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(dpt, z);
        edit.commit();
    }

    public boolean aKX() {
        return this.mPreferences.getBoolean(dpt, true);
    }
}
