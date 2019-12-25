package com.baidu.swan.config.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.config.c;
import com.baidu.swan.d.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    private static c cbc;
    private a cbd = new a();
    private String cbe = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_dialog_msg);
    private String cbf = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_toast_msg);

    public static c agz() {
        if (cbc == null) {
            synchronized (c.class) {
                if (cbc == null) {
                    cbc = new c();
                }
            }
        }
        return cbc;
    }

    private c() {
    }

    public int getVersion() {
        return this.cbd.getInt("tips_config_version", 0);
    }

    public String aM(long j) {
        return this.cbd.getString(String.format("%04d", Long.valueOf(j)), this.cbe);
    }

    public String aN(long j) {
        return this.cbd.getString(String.format("%04d", Long.valueOf(j)), this.cbf);
    }

    public void c(HashMap<String, String> hashMap, int i) {
        if (hashMap != null && !hashMap.isEmpty() && i > 0) {
            SharedPreferences.Editor edit = this.cbd.edit();
            edit.clear();
            edit.putInt("tips_config_version", i);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    /* loaded from: classes9.dex */
    private static class a extends e {
        a() {
            super("swan_launch_tips_config_sp_name");
        }
    }
}
