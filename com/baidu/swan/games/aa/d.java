package com.baidu.swan.games.aa;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public class d {
    private b dnq;

    public d(JsObject jsObject) {
        this.dnq = b.l(com.baidu.swan.games.binding.model.c.e(jsObject));
        a.aGL().a(this);
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        final SwanAppActivity akb = f.akr().akb();
        if (akb == null) {
            com.baidu.swan.apps.console.c.e("UpdateManagerApi", "applyUpdate activity is null");
            return false;
        } else if (akb.isDestroyed() || akb.getIntent() == null) {
            return false;
        } else {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.aa.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.utils.a.n(akb);
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
        if (this.dnq != null && JSEvent.isValid(cVar)) {
            com.baidu.swan.apps.console.c.i("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", cVar.type, Boolean.valueOf(cVar.hasUpdate)));
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
                    this.dnq.b(cVar);
                    return;
                case true:
                    this.dnq.aGN();
                    return;
                case true:
                    this.dnq.aGO();
                    return;
                default:
                    return;
            }
        }
    }
}
