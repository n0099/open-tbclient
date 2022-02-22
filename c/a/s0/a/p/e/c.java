package c.a.s0.a.p.e;

import android.view.View;
import android.webkit.ValueCallback;
/* loaded from: classes.dex */
public interface c extends c.a.s0.a.h0.f.a {
    boolean canGoBack();

    View covertToView();

    void destroy();

    @Override // c.a.s0.a.h0.f.a
    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    View getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i2, int i3, String str);

    void webViewScrollTo(int i2, int i3);
}
