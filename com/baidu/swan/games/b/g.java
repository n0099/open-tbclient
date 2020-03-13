package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.games.b.d;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    protected com.baidu.swan.games.e.b ckb;

    public g(com.baidu.swan.games.e.b bVar) {
        this.ckb = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            boolean optBoolean = c.optBoolean("enableDebug");
            com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
            if (acF == null) {
                a(c, false, op("internal error"));
                return;
            }
            SwanAppActivity acB = acF.acB();
            if (acB == null) {
                a(c, false, op("internal error"));
            } else if (optBoolean == com.baidu.swan.apps.console.a.Lr()) {
                a(c, true, "setEnableDebug:ok");
            } else {
                a(acF, acB, c, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.c.c.a(eVar, context, new c.a() { // from class: com.baidu.swan.games.b.g.1
            @Override // com.baidu.swan.apps.core.c.c.a
            public void f(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        g.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.i(context, false);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.c.c.aj(context, str);
                g.this.a(cVar, false, g.this.op(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        d.amX().a(new d.a() { // from class: com.baidu.swan.games.b.g.2
            @Override // com.baidu.swan.games.b.d.a
            public void cn(boolean z) {
                if (z) {
                    com.baidu.swan.apps.console.a.i(context, true);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                d.amX().a((Activity) context, (DialogInterface.OnClickListener) null);
                g.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String op(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }

    public static void bx(JSONObject jSONObject) {
        SwanAppActivity acB;
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null && acF.acW() && (acB = acF.acB()) != null) {
            com.baidu.swan.apps.framework.c Gv = acB.Gv();
            if ((Gv instanceof com.baidu.swan.games.i.b) && (v8Engine = ((com.baidu.swan.games.i.b) Gv).getV8Engine()) != null) {
                v8Engine.dispatchEvent(a.bw(jSONObject));
            }
        }
    }
}
