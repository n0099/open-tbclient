package com.baidu.swan.games.k.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.l;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
import com.baidu.swan.pms.model.d;
/* loaded from: classes7.dex */
public class a extends l {
    private static final boolean DEBUG = b.DEBUG;

    public a(com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected int getCategory() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected PMSDownloadType acb() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String acm() {
        return com.baidu.swan.apps.core.pms.f.a.acw();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String acn() {
        return com.baidu.swan.apps.core.pms.f.a.acx();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.an.a g(d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.an.a().bJ(13L).bL(2907L).qk("小游戏GameCore包 Framework null");
        }
        a.C0404a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 1);
        com.baidu.swan.d.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            if (DEBUG) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long hM = com.baidu.swan.apps.swancore.d.a.hM(1);
            if (hM > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, hM);
            }
            return null;
        }
        return new com.baidu.swan.apps.an.a().bJ(13L).bL(2907L).qk("小游戏GameCore包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.an.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.an.a().bJ(14L).bL(2908L).qk("小游戏Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ckm = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(1, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.an.a().bJ(14L).bL(2908L).qk("小游戏Extension包更新失败");
    }
}
