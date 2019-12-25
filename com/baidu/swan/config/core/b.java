package com.baidu.swan.config.core;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes9.dex */
public class b {
    public static SharedPreferences agq() {
        return AppRuntime.getAppContext().getSharedPreferences("swan_config_sp_name", 0);
    }
}
