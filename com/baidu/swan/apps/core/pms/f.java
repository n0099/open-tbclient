package com.baidu.swan.apps.core.pms;

import android.util.Log;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
/* loaded from: classes2.dex */
public class f extends h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.core.pms.h
    protected int AP() {
        return 0;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected PMSDownloadType AD() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String AQ() {
        return com.baidu.swan.apps.core.pms.c.a.AT();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected String AR() {
        return com.baidu.swan.apps.core.pms.c.a.AR();
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.d dVar) {
        SwanAppMessengerService serviceObject;
        if (dVar == null) {
            return new com.baidu.swan.apps.ak.a().Y(13L).aa(2907L).hY("小程序Core包 Framework null");
        }
        a.C0184a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, 0);
        if (DEBUG) {
            Log.d("SwanAppUpdateCoreCallback", "SwanCore RemoteCoreUpdateStatus: " + c);
        }
        com.baidu.swan.c.a.deleteFile(dVar.filePath);
        if (c.isOk()) {
            long ek = com.baidu.swan.apps.swancore.e.a.ek(0);
            if (ek > 0 && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
                serviceObject.sendMessageWithDataToAllClient(114, ek);
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Y(13L).aa(2907L).hY("小程序Core包更新失败");
    }

    @Override // com.baidu.swan.apps.core.pms.h
    protected com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.ak.a().Y(14L).aa(2908L).hY("小程序Extension包 Extension null");
        }
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.awp = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.Ck().a((com.baidu.swan.apps.extcore.a) aVar)) {
            if (DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "小程序Extension包解压成功");
            }
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Y(14L).aa(2908L).hY("小程序Extension包更新失败");
    }
}
