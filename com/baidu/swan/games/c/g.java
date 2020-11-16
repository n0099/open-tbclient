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
/* loaded from: classes7.dex */
public class g {
    protected com.baidu.swan.games.f.b dPn;

    public g(com.baidu.swan.games.f.b bVar) {
        this.dPn = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            boolean optBoolean = e.optBoolean("enableDebug");
            com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
            if (aGM == null) {
                a(e, false, wh("internal error"));
                return;
            }
            SwanAppActivity aGG = aGM.aGG();
            if (aGG == null) {
                a(e, false, wh("internal error"));
            } else if (optBoolean == com.baidu.swan.apps.console.a.akN()) {
                a(e, true, "setEnableDebug:ok");
            } else {
                a(aGM, aGG, e, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.c.c.a(eVar, context, new c.a() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c.c.a
            public void k(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        g.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.m(context, false);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.c.c.Y(context, str);
                g.this.a(cVar, false, g.this.wh(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        d.aTI().a(new d.a() { // from class: com.baidu.swan.games.c.g.2
            @Override // com.baidu.swan.games.c.d.a
            public void eK(boolean z) {
                if (z) {
                    com.baidu.swan.apps.console.a.m(context, true);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                d.aTI().a((Activity) context, (DialogInterface.OnClickListener) null);
                g.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String wh(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }

    public static void cp(JSONObject jSONObject) {
        SwanAppActivity aGG;
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && aGM.aHf() && (aGG = aGM.aGG()) != null) {
            com.baidu.swan.apps.framework.c aeX = aGG.aeX();
            if ((aeX instanceof com.baidu.swan.games.j.b) && (v8Engine = ((com.baidu.swan.games.j.b) aeX).getV8Engine()) != null) {
                v8Engine.dispatchEvent(a.co(jSONObject));
            }
        }
    }
}
