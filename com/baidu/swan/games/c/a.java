package com.baidu.swan.games.c;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.binding.c;
import java.net.URLEncoder;
/* loaded from: classes10.dex */
public class a {
    public static void a(c cVar, JsObject jsObject) {
        boolean z = false;
        b bVar = new b();
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        if (cVar == null) {
            bVar.errMsg = "openCustomerServiceConversation:fail";
            com.baidu.swan.games.utils.b.a(c, false, bVar);
            return;
        }
        if (com.baidu.swan.games.glsurface.a.b.amf()) {
            e aap = e.aap();
            if (aap != null) {
                if (SchemeRouter.invoke(com.baidu.swan.apps.w.a.RG(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode("{\"appKey\":\"" + aap.getAppKey() + "\"}"))) {
                    bVar.errMsg = "openCustomerServiceConversation:ok";
                    z = true;
                } else {
                    bVar.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                bVar.errMsg = "openCustomerServiceConversation:fail";
            }
        } else {
            bVar.errMsg = "openCustomerServiceConversation:fail require user interaction";
        }
        com.baidu.swan.games.utils.b.a(c, z, bVar);
    }
}
