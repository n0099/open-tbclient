package com.baidu.swan.mini.slave;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.aq.aj;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.core.container.a {
    private BdSailorWebView dkQ;

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isWebView() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        this.dkQ.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (aj.isOnUiThread()) {
            this.dkQ.evaluateJavascript(str, valueCallback);
        } else {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.mini.slave.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dkQ.evaluateJavascript(str, valueCallback);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.dkQ.isDestroyed();
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void onJSLoaded() {
    }

    @Override // com.baidu.swan.apps.core.container.a
    public String getContainerId() {
        return "mini-slave";
    }
}
