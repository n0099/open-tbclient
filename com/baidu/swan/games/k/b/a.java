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
    protected PMSDownloadType aqO() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqZ() {
        return com.baidu.swan.apps.core.pms.f.a.arj();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String ara() {
        return com.baidu.swan.apps.core.pms.f.a.ark();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a g(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.al.a().db(13L).dd(2907L).tM("小游戏GameCore包 Framework null");
        }
        a.C0477a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, 1);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (h.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long jU = com.baidu.swan.apps.swancore.d.a.jU(1);
            if (jU > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, jU);
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(13L).dd(2907L).tM("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.al.a().db(14L).dd(2908L).tM("小游戏Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ddh = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(1, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(14L).dd(2908L).tM("小游戏Extension包更新失败");
    }
}
