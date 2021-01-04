package com.baidu.swan.games.f;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes9.dex */
public interface b extends TypedCallbackHandler, JSRuntime, com.baidu.swan.apps.core.container.a {
    byte[] a(JsSerializeValue jsSerializeValue, boolean z);

    com.baidu.swan.games.f.b.b aZE();

    EventTarget aZG();

    EventTarget aZH();

    com.baidu.swan.games.f.a.a aZI();

    JsSerializeValue d(byte[] bArr, boolean z);

    void da(String str, String str2);

    String getInitBasePath();

    boolean n(Runnable runnable);

    void postOnJSThread(Runnable runnable);

    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
