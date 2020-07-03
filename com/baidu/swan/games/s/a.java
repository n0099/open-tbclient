package com.baidu.swan.games.s;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cXV;

    public void reload(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        e apE = d.apI().apE();
        if (!apE.available()) {
            b(e, "reload failed, api internal error.");
            return;
        }
        final SwanAppActivity apG = apE.apG();
        final b.a apQ = apE.apQ();
        if (apG == null) {
            b(e, "reload failed, api internal error.");
            return;
        }
        final String optString = e.optString("content");
        if (TextUtils.isEmpty(optString)) {
            optString = apG.getString(a.h.swangame_reload_dialog_content);
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.s.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(apG, optString, e, apQ);
            }
        });
    }

    private void b(com.baidu.swan.games.binding.model.c cVar, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, @NonNull String str, @NonNull final com.baidu.swan.games.binding.model.c cVar, @NonNull final com.baidu.swan.apps.v.b.b bVar) {
        if (this.cXV != null && this.cXV.isShowing()) {
            b(cVar, "reload failed, the reload dialog has been displayed.");
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.fe(a.h.swangame_reload_dialog_title).ny(str).apq().a(new com.baidu.swan.apps.view.c.a()).eY(false);
        aVar.d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.s.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.baidu.swan.games.utils.b.a(cVar, true, new c(false));
            }
        });
        aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.s.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.baidu.swan.games.utils.b.a(cVar, true, new c(true));
                a.this.s(bVar);
            }
        });
        this.cXV = aVar.apu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        String appId = bVar.getAppId();
        String e = com.baidu.swan.apps.v.b.c.e(bVar.getAppId(), bVar.ahQ(), bVar.getAppFrameType());
        Bundle bundle = new Bundle();
        bundle.putString("appId", appId);
        bundle.putString(SuspensionBallEntity.KEY_SCHEME, e);
        bundle.putInt("target", SwanAppProcessInfo.current().index);
        if (DEBUG) {
            Log.d("SwanGameReloadApi", "reload-appid:" + bVar.getAppId());
        }
        com.baidu.swan.apps.process.messaging.client.a.anW().b(bundle, b.class);
    }
}
