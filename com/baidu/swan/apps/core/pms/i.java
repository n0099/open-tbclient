package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
/* loaded from: classes9.dex */
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
    protected PMSDownloadType aui() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aut() {
        return com.baidu.swan.apps.core.pms.f.a.auC();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String auu() {
        return com.baidu.swan.apps.core.pms.f.a.auu();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).ux("小程序Core包 Framework null");
        }
        a.C0491a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.bs("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + h);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (h.isOk()) {
            long lw = com.baidu.swan.apps.swancore.d.a.lw(0);
            if (lw > 0) {
                SwanJSVersionUpdateEvent.sendEvent(lw);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, lw);
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).ux("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).ux("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.dej = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean akr = com.baidu.swan.apps.t.a.aAv().akr();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + akr);
            }
            if (akr) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long ayg = com.baidu.swan.apps.extcore.b.iM(0).axT().ayg();
                if (ayg > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, ayg);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).ux("小程序Extension包更新失败");
    }
}
