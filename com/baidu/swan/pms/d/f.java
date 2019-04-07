package com.baidu.swan.pms.d;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class f {
    public static SharedPreferences Su() {
        return AppRuntime.getAppContext().getSharedPreferences("key_pms_sp_name", 0);
    }
}
