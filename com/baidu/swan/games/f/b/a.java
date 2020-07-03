package com.baidu.swan.games.f.b;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes11.dex */
public class a {
    private V8Engine mV8Engine;

    public a(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    public void cm(String str, String str2) {
        this.mV8Engine.requireJSFile(str, str2);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.mV8Engine.evaluateJavascript(str, valueCallback, "mainContextEvaluate");
    }

    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        this.mV8Engine.addJavascriptInterface(obj, str);
    }

    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.mV8Engine.throwJSException(jSExceptionType, str);
    }
}
