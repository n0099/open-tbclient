package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes15.dex */
public class b {
    public static String ebu = "wifi_resume_download_flag";
    private static volatile b ebv;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aTj() {
        if (ebv == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (ebv == null) {
                    ebv = new b();
                }
            }
        }
        return ebv;
    }

    public void hU(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(ebu, z);
        edit.commit();
    }

    public boolean aTk() {
        return this.mPreferences.getBoolean(ebu, true);
    }
}
