package c.a.s0.a.l0;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes.dex */
public interface c extends JSRuntime, c.a.s0.a.h0.f.a, TypedCallbackHandler {
    JsSerializeValue C(byte[] bArr, boolean z);

    byte[] N(JsSerializeValue jsSerializeValue, boolean z);

    void c0(String str, String str2);

    boolean dispatchEvent(JSEvent jSEvent);

    c.a.s0.a.l0.m.b f0();

    String getInitBasePath();

    int getInvokeSourceType();

    EventTarget o();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget y();

    c.a.s0.a.l0.l.a z();
}
