package com.baidu.swan.games.f;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes8.dex */
public interface b extends TypedCallbackHandler, JSRuntime, com.baidu.swan.apps.core.container.a {
    byte[] a(JsSerializeValue jsSerializeValue, boolean z);

    com.baidu.swan.games.f.b.b aMZ();

    EventTarget aNb();

    EventTarget aNc();

    com.baidu.swan.games.f.a.a aNd();

    void cJ(String str, String str2);

    JsSerializeValue d(byte[] bArr, boolean z);

    String getInitBasePath();

    boolean o(Runnable runnable);

    void postOnJSThread(Runnable runnable);

    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
