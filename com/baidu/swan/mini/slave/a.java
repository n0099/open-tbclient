package com.baidu.swan.mini.slave;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.as.ai;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.core.container.a {
    private BdSailorWebView cAx;

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isWebView() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        this.cAx.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (ai.isOnUiThread()) {
            this.cAx.evaluateJavascript(str, valueCallback);
        } else {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.mini.slave.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cAx.evaluateJavascript(str, valueCallback);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.cAx.isDestroyed();
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void onJSLoaded() {
    }

    @Override // com.baidu.swan.apps.core.container.a
    public String getContainerId() {
        return "mini-slave";
    }
}
