package com.baidu.swan.games.e;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes2.dex */
public interface b extends TypedCallbackHandler, JSRuntime, com.baidu.swan.apps.core.container.a {
    com.baidu.swan.games.e.b.b QM();

    EventTarget QN();

    EventTarget QO();

    com.baidu.swan.games.e.a.a QP();

    byte[] a(JsSerializeValue jsSerializeValue, boolean z);

    void aV(String str, String str2);

    JsSerializeValue c(byte[] bArr, boolean z);

    boolean post(Runnable runnable);

    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
