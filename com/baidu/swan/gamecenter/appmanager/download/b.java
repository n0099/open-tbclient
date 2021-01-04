package com.baidu.swan.gamecenter.appmanager.download;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class b {
    public static String edZ = "wifi_resume_download_flag";
    private static volatile b eea;
    private SharedPreferences mPreferences = AppRuntime.getAppContext().getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);

    private b() {
    }

    public static b aWQ() {
        if (eea == null) {
            synchronized (com.baidu.swan.gamecenter.appmanager.a.class) {
                if (eea == null) {
                    eea = new b();
                }
            }
        }
        return eea;
    }

    public void hW(boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putBoolean(edZ, z);
        edit.commit();
    }

    public boolean aWR() {
        return this.mPreferences.getBoolean(edZ, true);
    }
}
