package com.baidu.swan.apps.core.j;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.g;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes9.dex */
class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cYP = "swan_preset" + File.separator + "preset_list.json";

    @Override // com.baidu.swan.apps.core.j.b
    protected String auT() {
        return g.loadAssetsFile(com.baidu.swan.apps.t.a.aAr(), cYP);
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String nV(String str) {
        return g.loadAssetsFile(com.baidu.swan.apps.t.a.aAr(), "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null) {
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + cVar.ewI + File.separator + cVar.cYT;
            try {
                File c = c(cVar.category, cVar.ewI, cVar.versionCode);
                if (c == null) {
                    if (DEBUG) {
                        Log.e("AssetPresetController", "获取解压路径失败");
                    }
                } else {
                    z = a(new BufferedInputStream(appContext.getAssets().open(str)), c);
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
