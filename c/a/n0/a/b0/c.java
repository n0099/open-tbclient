package c.a.n0.a.b0;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes.dex */
public interface c extends JSRuntime, c.a.n0.a.x.f.a, TypedCallbackHandler {
    c.a.n0.a.b0.l.a A();

    JsSerializeValue D(byte[] bArr, boolean z);

    byte[] O(JsSerializeValue jsSerializeValue, boolean z);

    void a0(String str, String str2);

    boolean dispatchEvent(JSEvent jSEvent);

    c.a.n0.a.b0.m.b g0();

    String getInitBasePath();

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    int getInvokeSourceType();

    EventTarget p();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget y();
}
