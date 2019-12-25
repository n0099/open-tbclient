package com.baidu.swan.games.r;

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
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cmG;

    public void reload(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        e ZM = d.ZP().ZM();
        if (!ZM.available()) {
            b(c, "reload failed, api internal error.");
            return;
        }
        final SwanAppActivity ZO = ZM.ZO();
        final b.a ZV = ZM.ZV();
        if (ZO == null) {
            b(c, "reload failed, api internal error.");
            return;
        }
        final String optString = c.optString("content");
        if (TextUtils.isEmpty(optString)) {
            optString = ZO.getString(a.h.swangame_reload_dialog_content);
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.r.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(ZO, optString, c, ZV);
            }
        });
    }

    private void b(com.baidu.swan.games.binding.model.c cVar, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, @NonNull String str, @NonNull final com.baidu.swan.games.binding.model.c cVar, @NonNull final com.baidu.swan.apps.x.b.b bVar) {
        if (this.cmG != null && this.cmG.isShowing()) {
            b(cVar, "reload failed, the reload dialog has been displayed.");
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.em(a.h.swangame_reload_dialog_title).kr(str).Zy().a(new com.baidu.swan.apps.view.c.a()).dr(false);
        aVar.d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.r.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.baidu.swan.games.utils.b.a(cVar, true, new c(false));
            }
        });
        aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.r.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.baidu.swan.games.utils.b.a(cVar, true, new c(true));
                a.this.q(bVar);
            }
        });
        this.cmG = aVar.ZC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(@NonNull com.baidu.swan.apps.x.b.b bVar) {
        String appId = bVar.getAppId();
        String g = com.baidu.swan.apps.x.b.c.g(bVar.getAppId(), bVar.SW(), bVar.getAppFrameType());
        Bundle bundle = new Bundle();
        bundle.putString("appId", appId);
        bundle.putString(SuspensionBallEntity.KEY_SCHEME, g);
        bundle.putInt("target", SwanAppProcessInfo.current().index);
        if (DEBUG) {
            Log.d("SwanGameReloadApi", "reload-appid:" + bVar.getAppId());
        }
        com.baidu.swan.apps.process.messaging.client.a.Yi().a(bundle, b.class);
    }
}
