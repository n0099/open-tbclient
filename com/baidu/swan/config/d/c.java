package com.baidu.swan.config.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.config.c;
import com.baidu.swan.d.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class c {
    private static c cEF;
    private a cEG = new a();
    private String cEH = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_dialog_msg);
    private String cEI = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_toast_msg);

    public static c art() {
        if (cEF == null) {
            synchronized (c.class) {
                if (cEF == null) {
                    cEF = new c();
                }
            }
        }
        return cEF;
    }

    private c() {
    }

    public int getVersion() {
        return this.cEG.getInt("tips_config_version", 0);
    }

    public String by(long j) {
        return this.cEG.getString(String.format("%04d", Long.valueOf(j)), this.cEH);
    }

    public String bz(long j) {
        return this.cEG.getString(String.format("%04d", Long.valueOf(j)), this.cEI);
    }

    public void c(HashMap<String, String> hashMap, int i) {
        if (hashMap != null && !hashMap.isEmpty() && i > 0) {
            SharedPreferences.Editor edit = this.cEG.edit();
            edit.clear();
            edit.putInt("tips_config_version", i);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    /* loaded from: classes11.dex */
    private static class a extends e {
        a() {
            super("swan_launch_tips_config_sp_name");
        }
    }
}
