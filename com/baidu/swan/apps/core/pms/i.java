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
    protected PMSDownloadType anP() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aoa() {
        return com.baidu.swan.apps.core.pms.f.a.aoj();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aob() {
        return com.baidu.swan.apps.core.pms.f.a.aob();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.am.a().bZ(13L).cb(2907L).tK("小程序Core包 Framework null");
        }
        a.C0476a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long kN = com.baidu.swan.apps.swancore.d.a.kN(0);
            if (kN > 0) {
                SwanJSVersionUpdateEvent.sendEvent(kN);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, kN);
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().bZ(13L).cb(2907L).tK("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.am.a().bZ(14L).cb(2908L).tK("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cOl = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean aei = com.baidu.swan.apps.t.a.aud().aei();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + aei);
            }
            if (aei) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long arM = com.baidu.swan.apps.extcore.b.in(0).arz().arM();
                if (arM > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, arM);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().bZ(14L).cb(2908L).tK("小程序Extension包更新失败");
    }
}
