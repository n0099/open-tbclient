package com.baidu.swan.config.core;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class b {
    public static SharedPreferences agJ() {
        return AppRuntime.getAppContext().getSharedPreferences("swan_config_sp_name", 0);
    }
}
