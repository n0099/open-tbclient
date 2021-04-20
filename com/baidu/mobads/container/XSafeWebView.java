package com.baidu.mobads.container;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class XSafeWebView extends WebView {
    public final RemoteXAdLogger mAdLogger;

    public XSafeWebView(Context context, RemoteXAdLogger remoteXAdLogger) {
        super(context);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        getSettings().setAllowContentAccess(false);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        this.mAdLogger = remoteXAdLogger;
        removeJavascriptInterfaceForSafe();
    }

    private void removeJavascriptInterfaceForSafe() {
        try {
            if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT > 17) {
                return;
            }
            Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", String.class);
            declaredMethod.invoke(this, "searchBoxJavaBridge_");
            declaredMethod.invoke(this, "accessibility");
            declaredMethod.invoke(this, "accessibilityTraversal");
        } catch (Exception unused) {
        }
    }
}
