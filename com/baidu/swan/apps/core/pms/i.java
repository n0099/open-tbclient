package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
/* loaded from: classes11.dex */
public class i extends k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.k
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected PMSDownloadType Xh() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String Xt() {
        return com.baidu.swan.apps.core.pms.d.a.XB();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String Xu() {
        return com.baidu.swan.apps.core.pms.d.a.Xu();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.ap.a().bn(13L).bp(2907L).nK("小程序Core包 Framework null");
        }
        a.C0330a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        if (DEBUG) {
            Log.d("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        }
        com.baidu.swan.d.c.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long gX = com.baidu.swan.apps.swancore.e.a.gX(0);
            if (gX > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, gX);
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(13L).bp(2907L).nK("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ap.a().bn(14L).bp(2908L).nK("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bTA = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar)) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean Ps = com.baidu.swan.apps.w.a.abR().Ps();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + Ps);
            }
            if (Ps) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long ZT = com.baidu.swan.apps.extcore.b.eS(0).ZH().ZT();
                if (ZT > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient(121, ZT);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(14L).bp(2908L).nK("小程序Extension包更新失败");
    }
}
