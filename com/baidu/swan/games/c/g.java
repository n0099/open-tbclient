package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.games.c.d;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g {
    protected com.baidu.swan.games.f.b ecD;

    public g(com.baidu.swan.games.f.b bVar) {
        this.ecD = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            boolean optBoolean = e.optBoolean("enableDebug");
            com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
            if (aIK == null) {
                a(e, false, vV("internal error"));
                return;
            }
            SwanAppActivity aIE = aIK.aIE();
            if (aIE == null) {
                a(e, false, vV("internal error"));
            } else if (optBoolean == com.baidu.swan.apps.console.a.alL()) {
                a(e, true, "setEnableDebug:ok");
            } else {
                a(aIK, aIE, e, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.c.c.a(eVar, context, new c.a() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c.c.a
            public void n(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        g.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.q(context, false);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.c.c.af(context, str);
                g.this.a(cVar, false, g.this.vV(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        d.aVA().a(new d.a() { // from class: com.baidu.swan.games.c.g.2
            @Override // com.baidu.swan.games.c.d.a
            public void fg(boolean z) {
                if (z) {
                    com.baidu.swan.apps.console.a.q(context, true);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                d.aVA().a((Activity) context, (DialogInterface.OnClickListener) null);
                g.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String vV(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }

    public static void cw(JSONObject jSONObject) {
        SwanAppActivity aIE;
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && aIK.aJd() && (aIE = aIK.aIE()) != null) {
            com.baidu.swan.apps.framework.c afQ = aIE.afQ();
            if ((afQ instanceof com.baidu.swan.games.j.b) && (v8Engine = ((com.baidu.swan.games.j.b) afQ).getV8Engine()) != null) {
                v8Engine.dispatchEvent(a.cv(jSONObject));
            }
        }
    }
}
