package com.baidu.swan.games.k.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.l;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
import com.baidu.swan.pms.model.d;
/* loaded from: classes8.dex */
public class a extends l {
    private static final boolean DEBUG = b.DEBUG;

    public a(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected int getCategory() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected PMSDownloadType aqn() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqy() {
        return com.baidu.swan.apps.core.pms.f.a.aqI();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqz() {
        return com.baidu.swan.apps.core.pms.f.a.aqJ();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a g(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).tm("小游戏GameCore包 Framework null");
        }
        a.C0474a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, 1);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (h.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long jQ = com.baidu.swan.apps.swancore.d.a.jQ(1);
            if (jQ > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, jQ);
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).tm("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).tm("小游戏Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cZt = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(1, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).tm("小游戏Extension包更新失败");
    }
}
