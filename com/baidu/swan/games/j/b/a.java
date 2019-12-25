package com.baidu.swan.games.j.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.k;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.d.c;
import com.baidu.swan.pms.model.d;
/* loaded from: classes9.dex */
public class a extends k {
    private static final boolean DEBUG = b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.k
    protected int getCategory() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected PMSDownloadType MD() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String MP() {
        return com.baidu.swan.apps.core.pms.d.a.MY();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String MQ() {
        return com.baidu.swan.apps.core.pms.d.a.MZ();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a g(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.ap.a().aB(13L).aD(2907L).mg("小游戏GameCore包 Framework null");
        }
        a.C0288a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, 1);
        c.deleteFile(dVar.filePath);
        if (c.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long gy = com.baidu.swan.apps.swancore.e.a.gy(1);
            if (gy > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, gy);
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(13L).aD(2907L).mg("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ap.a().aB(14L).aD(2908L).mg("小游戏Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bqi = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(1, aVar)) {
            if (DEBUG) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(14L).aD(2908L).mg("小游戏Extension包更新失败");
    }
}
