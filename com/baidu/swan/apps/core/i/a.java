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
    private static final String bPw = "swan_preset" + File.separator + "preset_list.json";

    @Override // com.baidu.swan.apps.core.i.b
    protected String XJ() {
        return com.baidu.swan.apps.as.e.loadAssetsFile(com.baidu.swan.apps.w.a.abN(), bPw);
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected String iC(String str) {
        return com.baidu.swan.apps.as.e.loadAssetsFile(com.baidu.swan.apps.w.a.abN(), "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null) {
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + cVar.dan + File.separator + cVar.bPA;
            try {
                File d = d(cVar.category, cVar.dan, cVar.versionCode);
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
