package com.baidu.swan.apps.process.messaging.service;

import android.os.Bundle;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a;
/* loaded from: classes2.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static b aHg = new b();
    }

    public static b IY() {
        return a.aHg;
    }

    public void a(final SwanAppProcessInfo swanAppProcessInfo, final int i, final Bundle bundle) {
        com.baidu.swan.apps.process.a.Iu().b(new a.InterfaceC0156a() { // from class: com.baidu.swan.apps.process.messaging.service.b.1
            @Override // com.baidu.swan.apps.process.a.InterfaceC0156a
            public void onReady() {
                SwanAppMessengerService serviceObject = SwanAppMessengerService.getServiceObject();
                if (serviceObject != null) {
                    serviceObject.sendMessageToClient(swanAppProcessInfo, i, bundle);
                }
            }
        });
    }
}
