package com.baidu.swan.apps.core.container;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
/* loaded from: classes25.dex */
public interface a {
    void addJavascriptInterface(@NonNull Object obj, @NonNull String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    String getContainerId();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();
}
