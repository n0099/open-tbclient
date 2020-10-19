package com.baidu.swan.games.utils;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes10.dex */
public class a {
    public static void n(SwanAppActivity swanAppActivity) {
        Intent intent;
        if (swanAppActivity != null && (intent = swanAppActivity.getIntent()) != null) {
            Bundle bundle = new Bundle();
            bundle.putAll(intent.getExtras());
            bundle.putBoolean("should_ignore_launch_time", true);
            Bundle bundle2 = bundle.getBundle("mExtraData");
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle("mExtraData", bundle2);
            }
            bundle2.putLong("launch_flag_for_statistic", System.currentTimeMillis());
            bundle2.putLong("page_display_flag_for_statistic", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aCW().x(new String[0]);
            bundle.remove("pms_db_info_onload");
            bundle.remove("pms_db_info_updated");
            bundle.putString("launch_id", SwanLauncher.aoQ());
            com.baidu.swan.apps.runtime.d.aCW().e(bundle, "update_tag_by_activity_on_relaunch");
        }
    }
}
