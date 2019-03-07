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
    protected com.baidu.swan.games.e.b aZY;

    public d(com.baidu.swan.games.e.b bVar) {
        this.aZY = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c b = com.baidu.swan.games.binding.model.c.b(jsObject);
        if (b != null) {
            boolean optBoolean = b.optBoolean("enableDebug");
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            if (IX == null) {
                a(b, false, ij("internal error"));
                return;
            }
            Activity activity = IX.getActivity();
            if (activity == null) {
                a(b, false, ij("internal error"));
            } else {
                a(IX, activity, b, optBoolean);
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
                d.this.a(cVar, false, d.this.ij(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.games.c.a.b.NF().a(new b.a() { // from class: com.baidu.swan.games.c.d.2
            @Override // com.baidu.swan.games.c.a.b.a
            public void aV(boolean z) {
                if (z) {
                    if (!com.baidu.swan.apps.console.a.wI()) {
                        com.baidu.swan.apps.console.a.j(context, true);
                    }
                    d.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.games.c.a.b.NF().a((Activity) context, (DialogInterface.OnClickListener) null);
                d.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ij(String str) {
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
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.Jj()) {
            Activity activity = IX.getActivity();
            if (activity instanceof SwanAppActivity) {
                com.baidu.swan.apps.o.d uu = ((SwanAppActivity) activity).uu();
                if ((uu instanceof com.baidu.swan.games.g.a) && (v8Engine = ((com.baidu.swan.games.g.a) uu).getV8Engine()) != null) {
                    v8Engine.dispatchEvent(a.ao(jSONObject));
                }
            }
        }
    }
}
