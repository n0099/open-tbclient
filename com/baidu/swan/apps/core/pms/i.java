package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
/* loaded from: classes9.dex */
public class i extends k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.k
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected PMSDownloadType MD() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String MP() {
        return com.baidu.swan.apps.core.pms.d.a.MX();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String MQ() {
        return com.baidu.swan.apps.core.pms.d.a.MQ();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.ap.a().aB(13L).aD(2907L).mg("小程序Core包 Framework null");
        }
        a.C0288a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        if (DEBUG) {
            Log.d("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        }
        com.baidu.swan.d.c.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long gy = com.baidu.swan.apps.swancore.e.a.gy(0);
            if (gy > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, gy);
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(13L).aD(2907L).mg("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ap.a().aB(14L).aD(2908L).mg("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bqi = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar)) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean EN = com.baidu.swan.apps.w.a.Rn().EN();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + EN);
            }
            if (EN) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long Pp = com.baidu.swan.apps.extcore.b.ew(0).Pd().Pp();
                if (Pp > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient(121, Pp);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(14L).aD(2908L).mg("小程序Extension包更新失败");
    }
}
