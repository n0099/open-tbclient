package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
/* loaded from: classes10.dex */
public class i extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public i(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected PMSDownloadType alV() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String amg() {
        return com.baidu.swan.apps.core.pms.f.a.amp();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String amh() {
        return com.baidu.swan.apps.core.pms.f.a.amh();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.am.a().bX(13L).bZ(2907L).tr("小程序Core包 Framework null");
        }
        a.C0462a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.bg("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long kC = com.baidu.swan.apps.swancore.d.a.kC(0);
            if (kC > 0) {
                SwanJSVersionUpdateEvent.sendEvent(kC);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, kC);
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().bX(13L).bZ(2907L).tr("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.am.a().bX(14L).bZ(2908L).tr("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cFP = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean aco = com.baidu.swan.apps.t.a.asi().aco();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + aco);
            }
            if (aco) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long apS = com.baidu.swan.apps.extcore.b.ic(0).apF().apS();
                if (apS > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, apS);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().bX(14L).bZ(2908L).tr("小程序Extension包更新失败");
    }
}
