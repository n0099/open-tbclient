package com.baidu.swan.games.e;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes9.dex */
public interface b extends TypedCallbackHandler, JSRuntime, com.baidu.swan.apps.core.container.a {
    byte[] a(JsSerializeValue jsSerializeValue, boolean z);

    com.baidu.swan.games.e.b.b akL();

    EventTarget akN();

    EventTarget akO();

    com.baidu.swan.games.e.a.a akP();

    void bv(String str, String str2);

    JsSerializeValue c(byte[] bArr, boolean z);

    String getInitBasePath();

    boolean m(Runnable runnable);

    void postOnJSThread(Runnable runnable);

    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
