package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
/* loaded from: classes8.dex */
public class i extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public i(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected PMSDownloadType aqO() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqZ() {
        return com.baidu.swan.apps.core.pms.f.a.ari();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String ara() {
        return com.baidu.swan.apps.core.pms.f.a.ara();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.al.a().db(13L).dd(2907L).tM("小程序Core包 Framework null");
        }
        a.C0477a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + h);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (h.isOk()) {
            long jU = com.baidu.swan.apps.swancore.d.a.jU(0);
            if (jU > 0) {
                SwanJSVersionUpdateEvent.sendEvent(jU);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, jU);
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(13L).dd(2907L).tM("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.al.a().db(14L).dd(2908L).tM("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ddh = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean agY = com.baidu.swan.apps.t.a.axc().agY();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + agY);
            }
            if (agY) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long auN = com.baidu.swan.apps.extcore.b.hk(0).auA().auN();
                if (auN > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, auN);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(14L).dd(2908L).tM("小程序Extension包更新失败");
    }
}
