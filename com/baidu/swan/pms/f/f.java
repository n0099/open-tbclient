package com.baidu.swan.pms.f;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes9.dex */
public class f {
    public static SharedPreferences agq() {
        return AppRuntime.getAppContext().getSharedPreferences("key_pms_sp_name", 0);
    }
}
