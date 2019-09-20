package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
/* loaded from: classes2.dex */
public class f extends h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.h
    protected int BB() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected PMSDownloadType Bp() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String BC() {
        return com.baidu.swan.apps.core.pms.c.a.BF();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String BD() {
        return com.baidu.swan.apps.core.pms.c.a.BD();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.d dVar) {
        SwanAppMessengerService serviceObject;
        if (dVar == null) {
            return new com.baidu.swan.apps.ak.a().Z(13L).ab(2907L).ih("小程序Core包 Framework null");
        }
        a.C0195a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        if (DEBUG) {
            Log.d("SwanAppUpdateCoreCallback", "SwanCore RemoteCoreUpdateStatus: " + c);
        }
        com.baidu.swan.c.a.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long eo = com.baidu.swan.apps.swancore.e.a.eo(0);
            if (eo > 0 && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
                serviceObject.sendMessageWithDataToAllClient(114, eo);
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(13L).ab(2907L).ih("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ak.a().Z(14L).ab(2908L).ih("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.axs = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.CX().a((com.baidu.swan.apps.extcore.a) aVar)) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "小程序Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(14L).ab(2908L).ih("小程序Extension包更新失败");
    }
}
