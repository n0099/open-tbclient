package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.games.c.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    protected com.baidu.swan.games.f.b dQV;

    public g(com.baidu.swan.games.f.b bVar) {
        this.dQV = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            boolean optBoolean = e.optBoolean("enableDebug");
            com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
            if (aHu == null) {
                a(e, false, wm("internal error"));
                return;
            }
            SwanAppActivity aHo = aHu.aHo();
            if (aHo == null) {
                a(e, false, wm("internal error"));
            } else if (optBoolean == com.baidu.swan.apps.console.a.alv()) {
                a(e, true, "setEnableDebug:ok");
            } else {
                a(aHu, aHo, e, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.c.c.a(eVar, context, new c.a() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c.c.a
            public void j(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        g.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.n(context, false);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.c.c.ab(context, str);
                g.this.a(cVar, false, g.this.wm(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        d.aUq().a(new d.a() { // from class: com.baidu.swan.games.c.g.2
            @Override // com.baidu.swan.games.c.d.a
            public void eH(boolean z) {
                if (z) {
                    com.baidu.swan.apps.console.a.n(context, true);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                d.aUq().a((Activity) context, (DialogInterface.OnClickListener) null);
                g.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String wm(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }

    public static void cv(JSONObject jSONObject) {
        SwanAppActivity aHo;
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && aHu.aHN() && (aHo = aHu.aHo()) != null) {
            com.baidu.swan.apps.framework.c afF = aHo.afF();
            if ((afF instanceof com.baidu.swan.games.j.b) && (v8Engine = ((com.baidu.swan.games.j.b) afF).getV8Engine()) != null) {
                v8Engine.dispatchEvent(a.cu(jSONObject));
            }
        }
    }
}
