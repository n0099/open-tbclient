package com.baidu.swan.config.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.config.c;
import com.baidu.swan.d.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class c {
    private static c cfu;
    private a cfv = new a();
    private String cfw = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_dialog_msg);
    private String cfx = AppRuntime.getAppContext().getString(c.a.swan_launch_failed_default_toast_msg);

    public static c ajg() {
        if (cfu == null) {
            synchronized (c.class) {
                if (cfu == null) {
                    cfu = new c();
                }
            }
        }
        return cfu;
    }

    private c() {
    }

    public int getVersion() {
        return this.cfv.getInt("tips_config_version", 0);
    }

    public String aT(long j) {
        return this.cfv.getString(String.format("%04d", Long.valueOf(j)), this.cfw);
    }

    public String aU(long j) {
        return this.cfv.getString(String.format("%04d", Long.valueOf(j)), this.cfx);
    }

    public void c(HashMap<String, String> hashMap, int i) {
        if (hashMap != null && !hashMap.isEmpty() && i > 0) {
            SharedPreferences.Editor edit = this.cfv.edit();
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
