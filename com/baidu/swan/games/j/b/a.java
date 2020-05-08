package com.baidu.swan.games.j.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.k;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.d.c;
import com.baidu.swan.pms.model.d;
/* loaded from: classes11.dex */
public class a extends k {
    private static final boolean DEBUG = b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.k
    protected int getCategory() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected PMSDownloadType Xg() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String Xs() {
        return com.baidu.swan.apps.core.pms.d.a.XB();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String Xt() {
        return com.baidu.swan.apps.core.pms.d.a.XC();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a g(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.ap.a().bn(13L).bp(2907L).nK("小游戏GameCore包 Framework null");
        }
        a.C0351a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, 1);
        c.deleteFile(dVar.filePath);
        if (c.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long gX = com.baidu.swan.apps.swancore.e.a.gX(1);
            if (gX > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, gX);
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(13L).bp(2907L).nK("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ap.a().bn(14L).bp(2908L).nK("小游戏Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bTG = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(1, aVar)) {
            if (DEBUG) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(14L).bp(2908L).nK("小游戏Extension包更新失败");
    }
}
