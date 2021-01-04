package com.baidu.swan.games.g;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.binding.model.c;
/* loaded from: classes9.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;

    public static void authorizeEval(JsObject jsObject) {
        final c e = c.e(jsObject);
        if (e != null) {
            e aMl = e.aMl();
            if (aMl == null) {
                a(e, false, "authorize:fail internal error");
            } else {
                aMl.aMw().e("mapp_enable_eval", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.games.g.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: c */
                    public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                        if (eVar == null || eVar.forbidden || eVar.dLO != 1) {
                            a.a(c.this, false, "system deny");
                        } else {
                            a.a(c.this, true, "authorize:ok");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, boolean z, String str) {
        if (DEBUG) {
            Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
        }
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }
}
