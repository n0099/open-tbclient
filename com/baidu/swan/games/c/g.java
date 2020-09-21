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
/* loaded from: classes3.dex */
public class g {
    protected com.baidu.swan.games.f.b dqC;

    public g(com.baidu.swan.games.f.b bVar) {
        this.dqC = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            boolean optBoolean = e.optBoolean("enableDebug");
            com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
            if (aAr == null) {
                a(e, false, uT("internal error"));
                return;
            }
            SwanAppActivity aAl = aAr.aAl();
            if (aAl == null) {
                a(e, false, uT("internal error"));
            } else if (optBoolean == com.baidu.swan.apps.console.a.aeq()) {
                a(e, true, "setEnableDebug:ok");
            } else {
                a(aAr, aAl, e, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.c.c.a(eVar, context, new c.a() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c.c.a
            public void h(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        g.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.m(context, false);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.c.c.X(context, str);
                g.this.a(cVar, false, g.this.uT(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        d.aNn().a(new d.a() { // from class: com.baidu.swan.games.c.g.2
            @Override // com.baidu.swan.games.c.d.a
            public void dP(boolean z) {
                if (z) {
                    com.baidu.swan.apps.console.a.m(context, true);
                    g.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                d.aNn().a((Activity) context, (DialogInterface.OnClickListener) null);
                g.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uT(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }

    public static void cf(JSONObject jSONObject) {
        SwanAppActivity aAl;
        com.baidu.swan.games.f.a v8Engine;
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && aAr.aAK() && (aAl = aAr.aAl()) != null) {
            com.baidu.swan.apps.framework.c Yz = aAl.Yz();
            if ((Yz instanceof com.baidu.swan.games.j.b) && (v8Engine = ((com.baidu.swan.games.j.b) Yz).getV8Engine()) != null) {
                v8Engine.dispatchEvent(a.ce(jSONObject));
            }
        }
    }
}
