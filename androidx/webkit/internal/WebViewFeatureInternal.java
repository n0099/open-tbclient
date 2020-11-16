package androidx.webkit.internal;

import android.os.Build;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes7.dex */
public enum WebViewFeatureInternal {
    VISUAL_STATE_CALLBACK_FEATURE(Features.VISUAL_STATE_CALLBACK, 23),
    OFF_SCREEN_PRERASTER(Features.OFF_SCREEN_PRERASTER, 23),
    SAFE_BROWSING_ENABLE(Features.SAFE_BROWSING_ENABLE, 26),
    DISABLED_ACTION_MODE_MENU_ITEMS(Features.DISABLED_ACTION_MODE_MENU_ITEMS, 24),
    START_SAFE_BROWSING(Features.START_SAFE_BROWSING, 27),
    SAFE_BROWSING_WHITELIST(Features.SAFE_BROWSING_WHITELIST, 27),
    SAFE_BROWSING_PRIVACY_POLICY_URL(Features.SAFE_BROWSING_PRIVACY_POLICY_URL, 27),
    SERVICE_WORKER_BASIC_USAGE(Features.SERVICE_WORKER_BASIC_USAGE, 24),
    SERVICE_WORKER_CACHE_MODE(Features.SERVICE_WORKER_CACHE_MODE, 24),
    SERVICE_WORKER_CONTENT_ACCESS(Features.SERVICE_WORKER_CONTENT_ACCESS, 24),
    SERVICE_WORKER_FILE_ACCESS(Features.SERVICE_WORKER_FILE_ACCESS, 24),
    SERVICE_WORKER_BLOCK_NETWORK_LOADS(Features.SERVICE_WORKER_BLOCK_NETWORK_LOADS, 24),
    SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST(Features.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST, 24),
    RECEIVE_WEB_RESOURCE_ERROR(Features.RECEIVE_WEB_RESOURCE_ERROR, 23),
    RECEIVE_HTTP_ERROR(Features.RECEIVE_HTTP_ERROR, 23),
    SHOULD_OVERRIDE_WITH_REDIRECTS(Features.SHOULD_OVERRIDE_WITH_REDIRECTS, 24),
    SAFE_BROWSING_HIT(Features.SAFE_BROWSING_HIT, 27),
    WEB_RESOURCE_REQUEST_IS_REDIRECT(Features.WEB_RESOURCE_REQUEST_IS_REDIRECT, 24),
    WEB_RESOURCE_ERROR_GET_DESCRIPTION(Features.WEB_RESOURCE_ERROR_GET_DESCRIPTION, 23),
    WEB_RESOURCE_ERROR_GET_CODE(Features.WEB_RESOURCE_ERROR_GET_CODE, 23),
    SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY(Features.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY, 27),
    SAFE_BROWSING_RESPONSE_PROCEED(Features.SAFE_BROWSING_RESPONSE_PROCEED, 27),
    SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL(Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL, 27),
    WEB_MESSAGE_PORT_POST_MESSAGE(Features.WEB_MESSAGE_PORT_POST_MESSAGE, 23),
    WEB_MESSAGE_PORT_CLOSE(Features.WEB_MESSAGE_PORT_CLOSE, 23),
    WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK(Features.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK, 23),
    CREATE_WEB_MESSAGE_CHANNEL(Features.CREATE_WEB_MESSAGE_CHANNEL, 23),
    POST_WEB_MESSAGE(Features.POST_WEB_MESSAGE, 23),
    WEB_MESSAGE_CALLBACK_ON_MESSAGE(Features.WEB_MESSAGE_CALLBACK_ON_MESSAGE, 23);
    
    private final String mFeatureValue;
    private final int mOsVersion;

    /* loaded from: classes7.dex */
    private static class a {
        static final String[] Aj = d.hT().hO();
    }

    WebViewFeatureInternal(String str, int i) {
        this.mFeatureValue = str;
        this.mOsVersion = i;
    }

    public static WebViewFeatureInternal getFeature(String str) {
        WebViewFeatureInternal[] values;
        for (WebViewFeatureInternal webViewFeatureInternal : values()) {
            if (webViewFeatureInternal.mFeatureValue.equals(str)) {
                return webViewFeatureInternal;
            }
        }
        throw new RuntimeException("Unknown feature " + str);
    }

    public boolean isSupportedByFramework() {
        return Build.VERSION.SDK_INT >= this.mOsVersion;
    }

    public boolean isSupportedByWebView() {
        for (String str : a.Aj) {
            if (str.equals(this.mFeatureValue)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getWebViewApkFeaturesForTesting() {
        return a.Aj;
    }

    public static UnsupportedOperationException getUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }
}
