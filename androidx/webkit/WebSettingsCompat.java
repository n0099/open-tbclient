package androidx.webkit;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes.dex */
public class WebSettingsCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FORCE_DARK_AUTO = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FORCE_DARK_OFF = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FORCE_DARK_ON = 2;

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ForceDark {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface MenuItemFlags {
    }

    public static WebSettingsAdapter getAdapter(WebSettings webSettings) {
        return WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings);
    }

    @SuppressLint({"NewApi"})
    public static int getDisabledActionModeMenuItems(@NonNull WebSettings webSettings) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("DISABLED_ACTION_MODE_MENU_ITEMS");
        if (feature.isSupportedByFramework()) {
            return webSettings.getDisabledActionModeMenuItems();
        }
        if (feature.isSupportedByWebView()) {
            return getAdapter(webSettings).getDisabledActionModeMenuItems();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getForceDark(@NonNull WebSettings webSettings) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("FORCE_DARK");
        if (feature.isSupportedByFramework()) {
            return webSettings.getForceDark();
        }
        if (feature.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static boolean getOffscreenPreRaster(@NonNull WebSettings webSettings) {
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
    public static boolean getSafeBrowsingEnabled(@NonNull WebSettings webSettings) {
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
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean willSuppressErrorPage(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.getFeature("SUPPRESS_ERROR_PAGE").isSupportedByWebView()) {
            return getAdapter(webSettings).willSuppressErrorPage();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static void setDisabledActionModeMenuItems(@NonNull WebSettings webSettings, int i) {
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceDark(@NonNull WebSettings webSettings, int i) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("FORCE_DARK");
        if (feature.isSupportedByFramework()) {
            webSettings.setForceDark(i);
        } else if (feature.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDark(i);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void setOffscreenPreRaster(@NonNull WebSettings webSettings, boolean z) {
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
    public static void setSafeBrowsingEnabled(@NonNull WebSettings webSettings, boolean z) {
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
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setWillSuppressErrorPage(@NonNull WebSettings webSettings, boolean z) {
        if (WebViewFeatureInternal.getFeature("SUPPRESS_ERROR_PAGE").isSupportedByWebView()) {
            getAdapter(webSettings).setWillSuppressErrorPage(z);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
