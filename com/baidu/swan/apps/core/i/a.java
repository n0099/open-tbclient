package com.baidu.swan.apps.core.i;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes11.dex */
class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String bqW = "swan_preset" + File.separator + "preset_list.json";

    @Override // com.baidu.swan.apps.core.i.b
    protected String PQ() {
        return com.baidu.swan.apps.as.e.loadAssetsFile(com.baidu.swan.apps.w.a.TU(), bqW);
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected String hp(String str) {
        return com.baidu.swan.apps.as.e.loadAssetsFile(com.baidu.swan.apps.w.a.TU(), "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null) {
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + cVar.cAX + File.separator + cVar.bra;
            try {
                File d = d(cVar.category, cVar.cAX, cVar.versionCode);
                if (d == null) {
                    if (DEBUG) {
                        Log.e("AssetPresetController", "获取解压路径失败");
                    }
                } else {
                    z = a(new BufferedInputStream(appContext.getAssets().open(str)), d);
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }
}
