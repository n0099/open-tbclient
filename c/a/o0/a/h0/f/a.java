package c.a.o0.a.h0.f;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface a {
    void addJavascriptInterface(@NonNull Object obj, @NonNull String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    String getContainerId();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();

    boolean post(Runnable runnable);
}
