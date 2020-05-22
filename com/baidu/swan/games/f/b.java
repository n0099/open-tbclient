package com.baidu.swan.games.f;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes11.dex */
public interface b extends TypedCallbackHandler, JSRuntime, com.baidu.swan.apps.core.container.a {
    byte[] a(JsSerializeValue jsSerializeValue, boolean z);

    EventTarget azB();

    EventTarget azC();

    com.baidu.swan.games.f.a.a azD();

    com.baidu.swan.games.f.b.b azz();

    void ck(String str, String str2);

    JsSerializeValue d(byte[] bArr, boolean z);

    String getInitBasePath();

    void postOnJSThread(Runnable runnable);

    boolean r(Runnable runnable);

    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
