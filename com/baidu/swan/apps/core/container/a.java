package com.baidu.swan.apps.core.container;

import android.webkit.ValueCallback;
/* loaded from: classes2.dex */
public interface a {
    boolean Eq();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    boolean isDestroyed();
}
