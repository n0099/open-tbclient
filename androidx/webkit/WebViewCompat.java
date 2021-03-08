package androidx.webkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.internal.WebMessagePortImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import androidx.webkit.internal.WebViewProviderFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
/* loaded from: classes5.dex */
public class WebViewCompat {
    private static final Uri WILDCARD_URI = Uri.parse("*");
    private static final Uri EMPTY_URI = Uri.parse("");

    /* loaded from: classes5.dex */
    public interface VisualStateCallback {
        void onComplete(long j);
    }

    private WebViewCompat() {
    }

    public static void postVisualStateCallback(@NonNull WebView webView, long j, @NonNull final VisualStateCallback visualStateCallback) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("VISUAL_STATE_CALLBACK");
        if (feature.isSupportedByFramework()) {
            webView.postVisualStateCallback(j, new WebView.VisualStateCallback() { // from class: androidx.webkit.WebViewCompat.1
                @Override // android.webkit.WebView.VisualStateCallback
                public void onComplete(long j2) {
                    VisualStateCallback.this.onComplete(j2);
                }
            });
        } else if (feature.isSupportedByWebView()) {
            checkThread(webView);
            getProvider(webView).insertVisualStateCallback(j, visualStateCallback);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void startSafeBrowsing(@NonNull Context context, @Nullable ValueCallback<Boolean> valueCallback) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("START_SAFE_BROWSING");
        if (feature.isSupportedByFramework()) {
            WebView.startSafeBrowsing(context, valueCallback);
        } else if (feature.isSupportedByWebView()) {
            getFactory().getStatics().initSafeBrowsing(context, valueCallback);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void setSafeBrowsingWhitelist(@NonNull List<String> list, @Nullable ValueCallback<Boolean> valueCallback) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_WHITELIST");
        if (feature.isSupportedByFramework()) {
            WebView.setSafeBrowsingWhitelist(list, valueCallback);
        } else if (feature.isSupportedByWebView()) {
            getFactory().getStatics().setSafeBrowsingWhitelist(list, valueCallback);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public static Uri getSafeBrowsingPrivacyPolicyUrl() {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_PRIVACY_POLICY_URL");
        if (feature.isSupportedByFramework()) {
            return WebView.getSafeBrowsingPrivacyPolicyUrl();
        }
        if (feature.isSupportedByWebView()) {
            return getFactory().getStatics().getSafeBrowsingPrivacyPolicyUrl();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Nullable
    public static PackageInfo getCurrentWebViewPackage(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return WebView.getCurrentWebViewPackage();
        }
        try {
            PackageInfo loadedWebViewPackageInfo = getLoadedWebViewPackageInfo();
            return loadedWebViewPackageInfo == null ? getNotYetLoadedWebViewPackageInfo(context) : loadedWebViewPackageInfo;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (NoSuchMethodException e3) {
            return null;
        } catch (InvocationTargetException e4) {
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static PackageInfo getLoadedWebViewPackageInfo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
    }

    @SuppressLint({"PrivateApi"})
    private static PackageInfo getNotYetLoadedWebViewPackageInfo(Context context) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23) {
                str = (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
            } else {
                str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
            }
            if (str == null) {
                return null;
            }
            try {
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        } catch (ClassNotFoundException e2) {
            return null;
        } catch (IllegalAccessException e3) {
            return null;
        } catch (NoSuchMethodException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            return null;
        }
    }

    private static WebViewProviderAdapter getProvider(WebView webView) {
        return new WebViewProviderAdapter(createProvider(webView));
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public static WebMessagePortCompat[] createWebMessageChannel(@NonNull WebView webView) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("CREATE_WEB_MESSAGE_CHANNEL");
        if (feature.isSupportedByFramework()) {
            return WebMessagePortImpl.portsToCompat(webView.createWebMessageChannel());
        }
        if (feature.isSupportedByWebView()) {
            return getProvider(webView).createWebMessageChannel();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static void postWebMessage(@NonNull WebView webView, @NonNull WebMessageCompat webMessageCompat, @NonNull Uri uri) {
        if (WILDCARD_URI.equals(uri)) {
            uri = EMPTY_URI;
        }
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("POST_WEB_MESSAGE");
        if (feature.isSupportedByFramework()) {
            webView.postWebMessage(WebMessagePortImpl.compatToFrameworkMessage(webMessageCompat), uri);
        } else if (feature.isSupportedByWebView()) {
            getProvider(webView).postWebMessage(webMessageCompat, uri);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    private static WebViewProviderFactory getFactory() {
        return WebViewGlueCommunicator.getFactory();
    }

    private static WebViewProviderBoundaryInterface createProvider(WebView webView) {
        return getFactory().createWebView(webView);
    }

    private static void checkThread(WebView webView) {
        if (Build.VERSION.SDK_INT >= 28) {
            if (webView.getWebViewLooper() != Looper.myLooper()) {
                throw new RuntimeException("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + webView.getWebViewLooper() + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
            }
            return;
        }
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("checkThread", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(webView, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
