package c.a.p0.a.x.f;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface a {
    void addJavascriptInterface(@NonNull Object obj, @NonNull String str);

    void continueTimer();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    String getContainerId();

    String getUrl();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();

    void suspendTimer();
}
