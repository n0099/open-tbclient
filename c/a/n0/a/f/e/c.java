package c.a.n0.a.f.e;

import android.view.View;
import android.webkit.ValueCallback;
/* loaded from: classes.dex */
public interface c extends c.a.n0.a.x.f.a {
    boolean canGoBack();

    View covertToView();

    void destroy();

    @Override // c.a.n0.a.x.f.a
    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    View getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i, int i2, String str);

    void webViewScrollTo(int i, int i2);
}
