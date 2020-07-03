package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
/* loaded from: classes11.dex */
public class i extends k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public i(com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected PMSDownloadType aaY() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String abk() {
        return com.baidu.swan.apps.core.pms.f.a.abu();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected String abl() {
        return com.baidu.swan.apps.core.pms.f.a.abl();
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.an.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.an.a().bw(13L).by(2907L).pz("小程序Core包 Framework null");
        }
        a.C0398a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        if (DEBUG) {
            Log.d("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        }
        com.baidu.swan.e.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long hD = com.baidu.swan.apps.swancore.d.a.hD(0);
            if (hD > 0) {
                SwanJSVersionUpdateEvent.sendEvent(hD);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, hD);
            }
            return null;
        }
        return new com.baidu.swan.apps.an.a().bw(13L).by(2907L).pz("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.k
    protected com.baidu.swan.apps.an.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.an.a().bw(14L).by(2908L).pz("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cio = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean SJ = com.baidu.swan.apps.u.a.aga().SJ();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + SJ);
            }
            if (SJ) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long adY = com.baidu.swan.apps.extcore.b.fq(0).adM().adY();
                if (adY > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient(121, adY);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.an.a().bw(14L).by(2908L).pz("小程序Extension包更新失败");
    }
}
