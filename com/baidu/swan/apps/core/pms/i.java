package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
/* loaded from: classes7.dex */
public class i extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public i(com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        super(bVar);
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected PMSDownloadType acb() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String acm() {
        return com.baidu.swan.apps.core.pms.f.a.acv();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String acn() {
        return com.baidu.swan.apps.core.pms.f.a.acn();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.an.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.an.a().bJ(13L).bL(2907L).qk("小程序Core包 Framework null");
        }
        a.C0404a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.aW("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        com.baidu.swan.d.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long hM = com.baidu.swan.apps.swancore.d.a.hM(0);
            if (hM > 0) {
                SwanJSVersionUpdateEvent.sendEvent(hM);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, hM);
            }
            return null;
        }
        return new com.baidu.swan.apps.an.a().bJ(13L).bL(2907L).qk("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.an.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.an.a().bJ(14L).bL(2908L).qk("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ckm = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean SZ = com.baidu.swan.apps.t.a.ahm().SZ();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + SZ);
            }
            if (SZ) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long afp = com.baidu.swan.apps.extcore.b.fz(0).afc().afp();
                if (afp > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient(121, afp);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.an.a().bJ(14L).bL(2908L).qk("小程序Extension包更新失败");
    }
}
