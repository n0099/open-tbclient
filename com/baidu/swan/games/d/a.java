package com.baidu.swan.games.d;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.c;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class a {
    public static void a(c cVar, JsObject jsObject) {
        boolean z = false;
        b bVar = new b();
        com.baidu.swan.games.binding.model.c cVar2 = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (cVar == null) {
            bVar.errMsg = "openCustomerServiceConversation:fail";
            com.baidu.swan.games.utils.a.a(cVar2, false, bVar);
            return;
        }
        if (com.baidu.swan.games.glsurface.a.b.So()) {
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh != null) {
                if (SchemeRouter.invoke(com.baidu.swan.apps.u.a.Eo(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode("{\"appKey\":\"" + Mh.getAppKey() + "\"}"))) {
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
        com.baidu.swan.games.utils.a.a(cVar2, z, bVar);
    }
}
