package com.baidu.swan.games.u;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class d {
    private b bET;

    public d(JsObject jsObject) {
        this.bET = b.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        a.Yn().a(this);
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        final SwanAppActivity Lp = e.LD().Lp();
        if (Lp == null) {
            com.baidu.swan.apps.console.c.e("UpdateManagerApi", "applyUpdate activity is null");
            return false;
        } else if (Lp.AJ() == null) {
            com.baidu.swan.apps.console.c.e("UpdateManagerApi", "applyUpdate getLaunchInfo is null");
            return false;
        } else {
            final String KF = Lp.AJ().KF();
            if (TextUtils.isEmpty(KF)) {
                com.baidu.swan.apps.console.c.e("UpdateManagerApi", "applyUpdate launchScheme is empty");
                return false;
            }
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.u.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Lp.AI();
                    SchemeRouter.invoke(com.baidu.swan.apps.u.a.Ji(), KF);
                }
            });
            return true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r4.equals("checkForUpdate") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(c cVar) {
        boolean z = false;
        if (this.bET != null && JSEvent.isValid(cVar)) {
            com.baidu.swan.apps.console.c.d("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", cVar.type, Boolean.valueOf(cVar.hasUpdate)));
            String str = cVar.type;
            switch (str.hashCode()) {
                case -1330233754:
                    if (str.equals("updateFailed")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1317168438:
                    break;
                case -585906598:
                    if (str.equals("updateReady")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    this.bET.b(cVar);
                    return;
                case true:
                    this.bET.Yp();
                    return;
                case true:
                    this.bET.Yq();
                    return;
                default:
                    return;
            }
        }
    }
}
