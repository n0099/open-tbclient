package com.baidu.swan.config.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.config.c;
import com.baidu.swan.d.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class c {
    private static c cfv;
    private a cfw = new a();
    private String cfx = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_dialog_msg);
    private String cfy = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_toast_msg);

    public static c aji() {
        if (cfv == null) {
            synchronized (c.class) {
                if (cfv == null) {
                    cfv = new c();
                }
            }
        }
        return cfv;
    }

    private c() {
    }

    public int getVersion() {
        return this.cfw.getInt("tips_config_version", 0);
    }

    public String aT(long j) {
        return this.cfw.getString(String.format("%04d", Long.valueOf(j)), this.cfx);
    }

    public String aU(long j) {
        return this.cfw.getString(String.format("%04d", Long.valueOf(j)), this.cfy);
    }

    public void c(HashMap<String, String> hashMap, int i) {
        if (hashMap != null && !hashMap.isEmpty() && i > 0) {
            SharedPreferences.Editor edit = this.cfw.edit();
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
