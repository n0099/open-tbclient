package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.games.c.a.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    protected com.baidu.swan.games.e.b bym;

    public e(com.baidu.swan.games.e.b bVar) {
        this.bym = bVar;
    }

    public void setEnableDebug(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            boolean optBoolean = c.optBoolean("enableDebug");
            com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
            if (QZ == null) {
                a(c, false, jF("internal error"));
                return;
            }
            Activity activity = QZ.getActivity();
            if (activity == null) {
                a(c, false, jF("internal error"));
            } else if (optBoolean == com.baidu.swan.apps.console.a.Dc()) {
                a(c, true, "setEnableDebug:ok");
            } else {
                a(QZ, activity, c, optBoolean);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.ae.b bVar, @NonNull final Context context, @NonNull final com.baidu.swan.games.binding.model.c cVar, final boolean z) {
        com.baidu.swan.apps.core.c.c.a(bVar, context, new c.a() { // from class: com.baidu.swan.games.c.e.1
            @Override // com.baidu.swan.apps.core.c.c.a
            public void d(boolean z2, String str) {
                if (z2) {
                    if (z) {
                        e.this.a(context, cVar);
                        return;
                    }
                    com.baidu.swan.apps.console.a.h(context, false);
                    e.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.apps.core.c.c.R(context, str);
                e.this.a(cVar, false, e.this.jF(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.games.c.a.b.Wj().a(new b.a() { // from class: com.baidu.swan.games.c.e.2
            @Override // com.baidu.swan.games.c.a.b.a
            public void bs(boolean z) {
                if (z) {
                    com.baidu.swan.apps.console.a.h(context, true);
                    e.this.a(cVar, true, "setEnableDebug:ok");
                    return;
                }
                com.baidu.swan.games.c.a.b.Wj().a((Activity) context, (DialogInterface.OnClickListener) null);
                e.this.a(cVar, false, "internet error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jF(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.a.a(cVar, z, bVar);
    }

    public static void aP(JSONObject jSONObject) {
        com.baidu.swan.games.e.a v8Engine;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null && QZ.Rl()) {
            Activity activity = QZ.getActivity();
            if (activity instanceof SwanAppActivity) {
                com.baidu.swan.apps.o.d AC = ((SwanAppActivity) activity).AC();
                if ((AC instanceof com.baidu.swan.games.g.a) && (v8Engine = ((com.baidu.swan.games.g.a) AC).getV8Engine()) != null) {
                    v8Engine.dispatchEvent(a.aO(jSONObject));
                }
            }
        }
    }
}
