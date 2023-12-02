package com.baidu.swan.apps;

import android.util.Log;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.hr2;
import com.baidu.tieba.k32;
/* loaded from: classes4.dex */
public class SwanAppClearCacheErrorActivity extends SwanAppErrorActivity {
    public volatile boolean v;

    public void G() {
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
            hr2 z = z();
            if (SwanAppNetworkUtils.i(this)) {
                SwanLauncher.j().n(z, null);
                finish();
            }
        } catch (Exception e) {
            k32.l("SwanAppClearCacheErrorActivity", "SwanAppClearCacheErrorActivity#onRestart", e);
        }
    }
}
