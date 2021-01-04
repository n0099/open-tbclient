package androidx.webkit;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes3.dex */
public class WebSettingsCompat {

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public @interface MenuItemFlags {
    }

    private WebSettingsCompat() {
    }

    @SuppressLint({"NewApi"})
    public static void setOffscreenPreRaster(WebSettings webSettings, boolean z) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("OFF_SCREEN_PRERASTER");
        if (feature.isSupportedByFramework()) {
            webSettings.setOffscreenPreRaster(z);
        } else if (feature.isSupportedByWebView()) {
            getAdapter(webSettings).setOffscreenPreRaster(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean getOffscreenPreRaster(WebSettings webSettings) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("OFF_SCREEN_PRERASTER");
        if (feature.isSupportedByFramework()) {
            return webSettings.getOffscreenPreRaster();
        }
        if (feature.isSupportedByWebView()) {
            return getAdapter(webSettings).getOffscreenPreRaster();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static void setSafeBrowsingEnabled(WebSettings webSettings, boolean z) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_ENABLE");
        if (feature.isSupportedByFramework()) {
            webSettings.setSafeBrowsingEnabled(z);
        } else if (feature.isSupportedByWebView()) {
            getAdapter(webSettings).setSafeBrowsingEnabled(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean getSafeBrowsingEnabled(WebSettings webSettings) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_ENABLE");
        if (feature.isSupportedByFramework()) {
            return webSettings.getSafeBrowsingEnabled();
        }
        if (feature.isSupportedByWebView()) {
            return getAdapter(webSettings).getSafeBrowsingEnabled();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static void setDisabledActionModeMenuItems(WebSettings webSettings, int i) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("DISABLED_ACTION_MODE_MENU_ITEMS");
        if (feature.isSupportedByFramework()) {
            webSettings.setDisabledActionModeMenuItems(i);
        } else if (feature.isSupportedByWebView()) {
            getAdapter(webSettings).setDisabledActionModeMenuItems(i);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static int getDisabledActionModeMenuItems(WebSettings webSettings) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("DISABLED_ACTION_MODE_MENU_ITEMS");
        if (feature.isSupportedByFramework()) {
            return webSettings.getDisabledActionModeMenuItems();
        }
        if (feature.isSupportedByWebView()) {
            return getAdapter(webSettings).getDisabledActionModeMenuItems();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static WebSettingsAdapter getAdapter(WebSettings webSettings) {
        return WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings);
    }
}
