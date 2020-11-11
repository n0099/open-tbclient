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
    protected PMSDownloadType aqq() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqB() {
        return com.baidu.swan.apps.core.pms.f.a.aqK();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqC() {
        return com.baidu.swan.apps.core.pms.f.a.aqC();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.am.a().cv(13L).cx(2907L).tY("小程序Core包 Framework null");
        }
        a.C0488a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long kX = com.baidu.swan.apps.swancore.d.a.kX(0);
            if (kX > 0) {
                SwanJSVersionUpdateEvent.sendEvent(kX);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, kX);
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(13L).cx(2907L).tY("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.am.a().cv(14L).cx(2908L).tY("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cUe = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean agI = com.baidu.swan.apps.t.a.awD().agI();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + agI);
            }
            if (agI) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long aun = com.baidu.swan.apps.extcore.b.ix(0).aua().aun();
                if (aun > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, aun);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(14L).cx(2908L).tY("小程序Extension包更新失败");
    }
}
