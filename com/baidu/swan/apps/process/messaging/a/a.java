package com.baidu.swan.apps.process.messaging.a;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.process.messaging.c;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    public static void n(Message message) {
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
        com.baidu.swan.apps.process.a.a.b.a(-1000, str, str2, bundle);
    }

    public static void I(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.aaO().a(new c(300, bundle));
    }

    public static void o(Message message) {
        if (!(message.obj instanceof Bundle)) {
            if (DEBUG) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) message.obj;
        com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.l(bundle.getBundle("key_result_data"));
        com.baidu.swan.apps.process.a.b.b.a.aaM().a(bVar);
    }

    public static void p(Message message) {
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
        com.baidu.swan.apps.process.a.a.b.a(i, str, str2, bundle);
    }

    public static void d(int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.aaO().a(new c(302, bundle).e(i));
    }

    public static void q(Message message) {
        if (!(message.obj instanceof Bundle)) {
            if (DEBUG) {
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            return;
        }
        Bundle bundle = (Bundle) message.obj;
        com.baidu.swan.apps.process.a.b.a.b bVar = new com.baidu.swan.apps.process.a.b.a.b(bundle.getString("key_observer_id", ""));
        bVar.l(bundle.getBundle("key_result_data"));
        com.baidu.swan.apps.process.a.b.b.a.aaM().a(bVar);
    }
}
