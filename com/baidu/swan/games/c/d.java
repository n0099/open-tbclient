package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.b.c;
import com.baidu.swan.games.c.a.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    protected com.baidu.swan.games.e.b bac;

    public d(com.baidu.swan.games.e.b bVar) {
        this.bac = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c b = com.baidu.swan.games.binding.model.c.b(jsObject);
        if (b != null) {
            boolean optBoolean = b.optBoolean("enableDebug");
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (IV == null) {
                a(b, false, ik("internal error"));
                return;
            }
            Activity activity = IV.getActivity();
            if (activity == null) {
                a(b, false, ik("internal error"));
            } else {
                a(IV, activity, b, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.ae.b bVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.b.c.a(bVar, context, new c.a() { // from class: com.baidu.swan.games.c.d.1
            @Override // com.baidu.swan.apps.core.b.c.a
            public void c(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        d.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.j(context, false);
                    d.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.b.c.af(context, str);
                d.this.a(cVar, false, d.this.ik(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.games.c.a.b.ND().a(new b.a() { // from class: com.baidu.swan.games.c.d.2
            @Override // com.baidu.swan.games.c.a.b.a
            public void aV(boolean z) {
                if (z) {
                    if (!com.baidu.swan.apps.console.a.wH()) {
                        com.baidu.swan.apps.console.a.j(context, true);
                    }
                    d.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.games.c.a.b.ND().a((Activity) context, (DialogInterface.OnClickListener) null);
                d.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ik(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.a.a(cVar, z, bVar);
    }

    public static void ap(JSONObject jSONObject) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.Jh()) {
            Activity activity = IV.getActivity();
            if (activity instanceof SwanAppActivity) {
                com.baidu.swan.apps.o.d ut = ((SwanAppActivity) activity).ut();
                if ((ut instanceof com.baidu.swan.games.g.a) && (v8Engine = ((com.baidu.swan.games.g.a) ut).getV8Engine()) != null) {
                    v8Engine.dispatchEvent(a.ao(jSONObject));
                }
            }
        }
    }
}
