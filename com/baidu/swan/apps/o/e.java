package com.baidu.swan.apps.o;

import android.content.Intent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.n;
/* loaded from: classes2.dex */
public class e {
    public static d b(SwanAppActivity swanAppActivity, int i) {
        switch (i) {
            case 0:
                return new com.baidu.swan.apps.o.a.a(swanAppActivity);
            case 1:
                return new com.baidu.swan.games.g.a(swanAppActivity);
            default:
                return new com.baidu.swan.apps.o.a.a(swanAppActivity);
        }
    }

    public static int E(Intent intent) {
        return n.a(intent, "aiapps_app_frame_type", 0);
    }
}
