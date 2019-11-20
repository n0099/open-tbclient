package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
/* loaded from: classes2.dex */
public class f extends h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.h
    protected int getCategory() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected PMSDownloadType Gl() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String Gx() {
        return com.baidu.swan.apps.core.pms.c.a.GA();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String Gy() {
        return com.baidu.swan.apps.core.pms.c.a.Gy();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.d dVar) {
        SwanAppMessengerService serviceObject;
        if (dVar == null) {
            return new com.baidu.swan.apps.ak.a().ar(13L).at(2907L).iK("小程序Core包 Framework null");
        }
        a.C0227a d = com.baidu.swan.apps.swancore.e.a.d(dVar.versionName, dVar.filePath, dVar.sign, 0);
        if (DEBUG) {
            Log.d("SwanAppUpdateCoreCallback", "SwanCore RemoteCoreUpdateStatus: " + d);
        }
        com.baidu.swan.c.a.deleteFile(dVar.filePath);
        if (d.isOk()) {
            long fj = com.baidu.swan.apps.swancore.e.a.fj(0);
            if (fj > 0 && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
                serviceObject.sendMessageWithDataToAllClient(114, fj);
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().ar(13L).at(2907L).iK("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ak.a().ar(14L).at(2908L).iK("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.aQp = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.HS().a((com.baidu.swan.apps.extcore.a) aVar)) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "小程序Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().ar(14L).at(2908L).iK("小程序Extension包更新失败");
    }
}
