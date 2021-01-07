package com.baidu.swan.apps.process.messaging.a;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.swan.apps.process.messaging.c;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void n(Message message) {
        Bundle bundle;
        String str;
        Bundle bundle2 = (Bundle) message.obj;
        String str2 = "";
        if (bundle2 != null) {
            str = bundle2.getString("ai_apps_delegation_name", null);
            String string = bundle2.getString("ai_apps_observer_id", "");
            bundle = bundle2.getBundle("ai_apps_data");
            str2 = string;
        } else {
            bundle = null;
            str = null;
        }
        com.baidu.swan.apps.process.a.a.b.a(-1000, str, str2, bundle);
    }

    public static void N(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.aIY().a(new c(21, bundle));
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
        bVar.k(bundle.getBundle("key_result_data"));
        com.baidu.swan.apps.process.a.b.b.a.aIR().a(bVar);
    }

    public static void p(Message message) {
        Bundle bundle;
        String str;
        if (DEBUG) {
            Log.e("ChannelMsgProcessor", "MSG_TYPE_CS_DELEGATION");
        }
        int i = message.arg1;
        Bundle bundle2 = (Bundle) message.obj;
        String str2 = "";
        if (bundle2 != null) {
            str = bundle2.getString("ai_apps_delegation_name", null);
            String string = bundle2.getString("ai_apps_observer_id", "");
            bundle = bundle2.getBundle("ai_apps_data");
            str2 = string;
        } else {
            bundle = null;
            str = null;
        }
        com.baidu.swan.apps.process.a.a.b.a(i, str, str2, bundle);
    }

    public static void c(int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.aIY().a(new c(Opcodes.IAND, bundle).g(i));
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
        bVar.k(bundle.getBundle("key_result_data"));
        com.baidu.swan.apps.process.a.b.b.a.aIR().a(bVar);
    }
}
