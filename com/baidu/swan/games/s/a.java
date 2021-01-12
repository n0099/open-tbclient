package com.baidu.swan.games.s;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dZN;

    public void reload(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        e aIj = d.aIn().aIj();
        if (!aIj.available()) {
            b(e, "reload failed, api internal error.");
            return;
        }
        final SwanAppActivity aIl = aIj.aIl();
        final b.a aIv = aIj.aIv();
        if (aIl == null) {
            b(e, "reload failed, api internal error.");
            return;
        }
        final String optString = e.optString("content");
        if (TextUtils.isEmpty(optString)) {
            optString = aIl.getString(a.h.swangame_reload_dialog_content);
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.s.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aIl, optString, e, aIv);
            }
        });
    }

    private void b(com.baidu.swan.games.binding.model.c cVar, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, @NonNull String str, @NonNull final com.baidu.swan.games.binding.model.c cVar, @NonNull final com.baidu.swan.apps.u.c.b bVar) {
        if (this.dZN != null && this.dZN.isShowing()) {
            b(cVar, "reload failed, the reload dialog has been displayed.");
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.gO(a.h.swangame_reload_dialog_title).re(str).aHz().a(new com.baidu.swan.apps.view.c.a()).gR(false);
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
                a.this.r(bVar);
            }
        });
        this.dZN = aVar.aHE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        String appId = bVar.getAppId();
        String i = com.baidu.swan.apps.u.c.c.i(bVar.getAppId(), bVar.ayC(), bVar.getAppFrameType());
        Bundle bundle = new Bundle();
        bundle.putString("appId", appId);
        bundle.putString("scheme", i);
        bundle.putInt("target", SwanAppProcessInfo.current().index);
        if (DEBUG) {
            Log.d("SwanGameReloadApi", "reload-appid:" + bVar.getAppId());
        }
        com.baidu.swan.apps.process.messaging.client.a.aFo().b(bundle, b.class);
    }
}
