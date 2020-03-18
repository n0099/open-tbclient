package com.baidu.swan.config.core;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes11.dex */
public class b {
    public static SharedPreferences ajc() {
        return AppRuntime.getAppContext().getSharedPreferences("swan_config_sp_name", 0);
    }
}
