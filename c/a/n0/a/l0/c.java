package c.a.n0.a.l0;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes.dex */
public interface c extends JSRuntime, c.a.n0.a.h0.f.a, TypedCallbackHandler {
    JsSerializeValue C(byte[] bArr, boolean z);

    byte[] M(JsSerializeValue jsSerializeValue, boolean z);

    void a0(String str, String str2);

    c.a.n0.a.l0.l.b d0();

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

    c.a.n0.a.l0.k.a z();
}
