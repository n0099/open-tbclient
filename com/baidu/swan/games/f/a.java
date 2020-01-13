package com.baidu.swan.games.f;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.binding.model.c;
/* loaded from: classes10.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;

    public static void authorizeEval(JsObject jsObject) {
        final c c = c.c(jsObject);
        if (c != null) {
            e aaq = e.aaq();
            if (aaq == null) {
                a(c, false, "authorize:fail internal error");
            } else {
                aaq.aaz().d("mapp_enable_eval", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.games.f.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: c */
                    public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                        if (eVar == null || eVar.forbidden || eVar.bPk != 1) {
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
