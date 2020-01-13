package com.baidu.swan.config.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.config.c;
import com.baidu.swan.d.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class c {
    private static c cbo;
    private a cbp = new a();
    private String cbq = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_dialog_msg);
    private String cbr = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_toast_msg);

    public static c agS() {
        if (cbo == null) {
            synchronized (c.class) {
                if (cbo == null) {
                    cbo = new c();
                }
            }
        }
        return cbo;
    }

    private c() {
    }

    public int getVersion() {
        return this.cbp.getInt("tips_config_version", 0);
    }

    public String aP(long j) {
        return this.cbp.getString(String.format("%04d", Long.valueOf(j)), this.cbq);
    }

    public String aQ(long j) {
        return this.cbp.getString(String.format("%04d", Long.valueOf(j)), this.cbr);
    }

    public void c(HashMap<String, String> hashMap, int i) {
        if (hashMap != null && !hashMap.isEmpty() && i > 0) {
            SharedPreferences.Editor edit = this.cbp.edit();
            edit.clear();
            edit.putInt("tips_config_version", i);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends e {
        a() {
            super("swan_launch_tips_config_sp_name");
        }
    }
}
