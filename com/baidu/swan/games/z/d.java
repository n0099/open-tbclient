package com.baidu.swan.games.z;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class d {
    private b cRS;

    public d(JsObject jsObject) {
        this.cRS = b.l(com.baidu.swan.games.binding.model.c.c(jsObject));
        a.ayh().a(this);
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        final SwanAppActivity aev = f.aeK().aev();
        if (aev == null) {
            com.baidu.swan.apps.console.c.e("UpdateManagerApi", "applyUpdate activity is null");
            return false;
        } else if (aev.isDestroyed() || aev.getIntent() == null) {
            return false;
        } else {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.z.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.games.utils.a.m(aev);
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
        if (this.cRS != null && JSEvent.isValid(cVar)) {
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
                    this.cRS.b(cVar);
                    return;
                case true:
                    this.cRS.ayj();
                    return;
                case true:
                    this.cRS.Xw();
                    return;
                default:
                    return;
            }
        }
    }
}
