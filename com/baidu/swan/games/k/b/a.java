package com.baidu.swan.games.k.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.l;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
import com.baidu.swan.pms.model.d;
/* loaded from: classes10.dex */
public class a extends l {
    private static final boolean DEBUG = b.DEBUG;

    public a(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected int getCategory() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected PMSDownloadType anP() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aoa() {
        return com.baidu.swan.apps.core.pms.f.a.aok();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aob() {
        return com.baidu.swan.apps.core.pms.f.a.aol();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a g(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.am.a().bZ(13L).cb(2907L).tK("小游戏GameCore包 Framework null");
        }
        a.C0476a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 1);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long kN = com.baidu.swan.apps.swancore.d.a.kN(1);
            if (kN > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, kN);
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().bZ(13L).cb(2907L).tK("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.am.a().bZ(14L).cb(2908L).tK("小游戏Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cOl = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(1, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().bZ(14L).cb(2908L).tK("小游戏Extension包更新失败");
    }
}
