package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.d.a;
/* loaded from: classes7.dex */
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
    protected PMSDownloadType apI() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String apT() {
        return com.baidu.swan.apps.core.pms.f.a.aqc();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected String apU() {
        return com.baidu.swan.apps.core.pms.f.a.apU();
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar) {
        if (dVar == null) {
            return new com.baidu.swan.apps.am.a().cv(13L).cx(2907L).tT("小程序Core包 Framework null");
        }
        a.C0486a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        com.baidu.swan.apps.console.c.bm("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
        com.baidu.swan.c.d.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long kT = com.baidu.swan.apps.swancore.d.a.kT(0);
            if (kT > 0) {
                SwanJSVersionUpdateEvent.sendEvent(kT);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, kT);
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(13L).cx(2907L).tT("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.l
    protected com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.am.a().cv(14L).cx(2908L).tT("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cSu = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(0, aVar) == null) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean aga = com.baidu.swan.apps.t.a.avV().aga();
            if (DEBUG) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + aga);
            }
            if (aga) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long atF = com.baidu.swan.apps.extcore.b.it(0).ats().atF();
                if (atF > 0) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, atF);
                }
            }
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(14L).cx(2908L).tT("小程序Extension包更新失败");
    }
}
