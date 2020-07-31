package com.baidu.swan.apps.core.j;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.g;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cfH = "swan_preset" + File.separator + "preset_list.json";

    @Override // com.baidu.swan.apps.core.j.b
    protected String acN() {
        return g.loadAssetsFile(com.baidu.swan.apps.t.a.ahj(), cfH);
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String kj(String str) {
        return g.loadAssetsFile(com.baidu.swan.apps.t.a.ahj(), "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null) {
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + cVar.dvZ + File.separator + cVar.cfL;
            try {
                File d = d(cVar.category, cVar.dvZ, cVar.versionCode);
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
