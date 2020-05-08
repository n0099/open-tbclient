package com.baidu.swan.games.utils;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes11.dex */
public class a {
    public static void m(SwanAppActivity swanAppActivity) {
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
            com.baidu.swan.apps.runtime.d.akJ().v(new String[0]);
            com.baidu.swan.apps.runtime.d.akJ().c(bundle, "update_tag_by_activity_on_relaunch");
        }
    }
}
