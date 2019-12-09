package com.baidu.swan.games.h.b;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.h;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.pms.model.d;
/* loaded from: classes2.dex */
public class b extends h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.h
    protected int getCategory() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected PMSDownloadType Gl() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String Gx() {
        return com.baidu.swan.apps.core.pms.c.a.GB();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String Gy() {
        return com.baidu.swan.apps.core.pms.c.a.GC();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.ak.a().ar(13L).at(2907L).iK("小游戏GameCore包 Framework null");
        }
        a.C0222a d = com.baidu.swan.apps.swancore.e.a.d(dVar.versionName, dVar.filePath, dVar.sign, 1);
        com.baidu.swan.c.a.deleteFile(dVar.filePath);
        if (d.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().ar(13L).at(2907L).iK("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar) {
        if (DEBUG) {
            Log.e("SwanGameUpdateCoreCallback", "Error !!!!,小游戏无Extension包");
        }
        return new com.baidu.swan.apps.ak.a().ar(13L).at(2908L).iK("小游戏无Extension包");
    }
}
