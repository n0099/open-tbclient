package com.baidu.swan.apps;

import android.util.Log;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.aw2;
import com.baidu.tieba.d82;
/* loaded from: classes4.dex */
public class SwanAppClearCacheErrorActivity extends SwanAppErrorActivity {
    public volatile boolean v;

    public void F() {
        this.v = true;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (SwanAppErrorActivity.u) {
            Log.d("SwanAppClearCacheErrorActivity", "SwanAppClearCacheErrorActivity#onRestart");
        }
        if (!this.v) {
            return;
        }
        this.v = false;
        try {
            aw2 y = y();
            if (SwanAppNetworkUtils.i(this)) {
                SwanLauncher.j().n(y, null);
                finish();
            }
        } catch (Exception e) {
            d82.l("SwanAppClearCacheErrorActivity", "SwanAppClearCacheErrorActivity#onRestart", e);
        }
    }
}
