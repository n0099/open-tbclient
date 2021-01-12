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
    protected PMSDownloadType aqn() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqy() {
        return com.baidu.swan.apps.core.pms.f.a.aqH();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String aqz() {
        return com.baidu.swan.apps.core.pms.f.a.aqz();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).tm("小程序Core包 Framework null");
        }
        a.C0474a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.br("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + h);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (h.isOk()) {
            long jQ = com.baidu.swan.apps.swancore.d.a.jQ(0);
            if (jQ > 0) {
                SwanJSVersionUpdateEvent.sendEvent(jQ);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, jQ);
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).tm("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).tm("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cZt = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean agx = com.baidu.swan.apps.t.a.awB().agx();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + agx);
            }
            if (agx) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long aum = com.baidu.swan.apps.extcore.b.hg(0).atZ().aum();
                if (aum > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, aum);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).tm("小程序Extension包更新失败");
    }
}
