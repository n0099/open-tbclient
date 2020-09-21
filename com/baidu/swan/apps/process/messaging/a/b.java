package com.baidu.swan.apps.process.messaging.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a.b.c.c;
import com.baidu.swan.apps.process.messaging.service.e;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable c cVar) {
        if (DEBUG) {
            Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, (int) Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
        obtain.replyTo = e.ayP().mMessenger;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.axR());
            com.baidu.swan.apps.process.a.b.b.a.axS().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(obtain).a(swanAppProcessInfo));
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls) {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = e.ayP().ayR().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next != null && next.ayC()) {
                a(next.cLD, bundle, cls, null);
            }
        }
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable c cVar) {
        com.baidu.swan.apps.process.messaging.client.a.ayl().b(bundle, cls, cVar);
    }
}
