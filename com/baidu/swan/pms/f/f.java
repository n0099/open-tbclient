package com.baidu.swan.pms.f;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class f {
    public static SharedPreferences agJ() {
        return AppRuntime.getAppContext().getSharedPreferences("key_pms_sp_name", 0);
    }
}
