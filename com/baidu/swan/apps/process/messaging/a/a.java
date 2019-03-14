package com.baidu.swan.apps.process.messaging.a;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    public static void l(Message message) {
        Bundle bundle;
        String str;
        String str2;
        Bundle bundle2 = (Bundle) message.obj;
        if (bundle2 == null) {
            bundle = null;
            str = null;
            str2 = "";
        } else {
            str = bundle2.getString("ai_apps_delegation_name", null);
            str2 = bundle2.getString("ai_apps_observer_id", "");
            bundle = bundle2.getBundle("ai_apps_data");
        }
        com.baidu.swan.apps.process.b.a.b.a(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, str, str2, bundle);
    }

    public static void u(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.client.a.Gq().e(300, bundle);
    }

    public static void m(Message message) {
        if (!(message.obj instanceof Bundle)) {
            if (DEBUG) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) message.obj;
        com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.h(bundle.getBundle("key_result_data"));
        com.baidu.swan.apps.process.b.b.b.a.Gn().a(bVar);
    }

    public static void n(Message message) {
        Bundle bundle;
        String str;
        String str2;
        if (DEBUG) {
            Log.e(TAG, "MSG_TYPE_CS_DELEGATION");
        }
        int i = message.arg1;
        Bundle bundle2 = (Bundle) message.obj;
        if (bundle2 == null) {
            bundle = null;
            str = null;
            str2 = "";
        } else {
            str = bundle2.getString("ai_apps_delegation_name", null);
            str2 = bundle2.getString("ai_apps_observer_id", "");
            bundle = bundle2.getBundle("ai_apps_data");
        }
        com.baidu.swan.apps.process.b.a.b.a(i, str, str2, bundle);
    }

    public static void d(int i, Bundle bundle) {
        SwanAppMessengerService.getServiceObject().sendMessageToClient(i, 302, bundle);
    }

    public static void o(Message message) {
        if (!(message.obj instanceof Bundle)) {
            if (DEBUG) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) message.obj;
        com.baidu.swan.apps.process.b.b.a.b bVar = new com.baidu.swan.apps.process.b.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.h(bundle.getBundle("key_result_data"));
        com.baidu.swan.apps.process.b.b.b.a.Gn().a(bVar);
    }
}
