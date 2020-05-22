package com.baidu.swan.games.d;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.binding.c;
import java.net.URLEncoder;
/* loaded from: classes11.dex */
public class a {
    public static void a(c cVar, JsObject jsObject) {
        boolean z = false;
        b bVar = new b();
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        if (cVar == null) {
            bVar.errMsg = "openCustomerServiceConversation:fail";
            com.baidu.swan.games.utils.b.a(e, false, bVar);
            return;
        }
        if (com.baidu.swan.games.glsurface.a.b.aAz()) {
            e aoF = e.aoF();
            if (aoF != null) {
                if (SchemeRouter.invoke(com.baidu.swan.apps.u.a.aeR(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode("{\"appKey\":\"" + aoF.getAppKey() + "\"}"))) {
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
        com.baidu.swan.games.utils.b.a(e, z, bVar);
    }
}
