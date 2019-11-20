package com.baidu.swan.games.e;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes2.dex */
public interface b extends TypedCallbackHandler, JSRuntime, com.baidu.swan.apps.core.container.a {
    EventTarget WA();

    com.baidu.swan.games.e.a.a WB();

    com.baidu.swan.games.e.b.b Wy();

    EventTarget Wz();

    byte[] a(JsSerializeValue jsSerializeValue, boolean z);

    void bc(String str, String str2);

    JsSerializeValue d(byte[] bArr, boolean z);

    boolean j(Runnable runnable);

    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
