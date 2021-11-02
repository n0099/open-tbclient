package b.a.p0.a.l0;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes.dex */
public interface c extends JSRuntime, b.a.p0.a.h0.f.a, TypedCallbackHandler {
    JsSerializeValue B(byte[] bArr, boolean z);

    byte[] L(JsSerializeValue jsSerializeValue, boolean z);

    void Z(String str, String str2);

    b.a.p0.a.l0.l.b c0();

    String getInitBasePath();

    int getInvokeSourceType();

    EventTarget n();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget x();

    b.a.p0.a.l0.k.a y();
}
