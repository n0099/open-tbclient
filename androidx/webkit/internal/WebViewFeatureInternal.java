package androidx.webkit.internal;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class WebViewFeatureInternal {
    public static final /* synthetic */ WebViewFeatureInternal[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final WebViewFeatureInternal CREATE_WEB_MESSAGE_CHANNEL;
    public static final WebViewFeatureInternal DISABLED_ACTION_MODE_MENU_ITEMS;
    public static final WebViewFeatureInternal OFF_SCREEN_PRERASTER;
    public static final WebViewFeatureInternal POST_WEB_MESSAGE;
    public static final WebViewFeatureInternal RECEIVE_HTTP_ERROR;
    public static final WebViewFeatureInternal RECEIVE_WEB_RESOURCE_ERROR;
    public static final WebViewFeatureInternal SAFE_BROWSING_ENABLE;
    public static final WebViewFeatureInternal SAFE_BROWSING_HIT;
    public static final WebViewFeatureInternal SAFE_BROWSING_PRIVACY_POLICY_URL;
    public static final WebViewFeatureInternal SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY;
    public static final WebViewFeatureInternal SAFE_BROWSING_RESPONSE_PROCEED;
    public static final WebViewFeatureInternal SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL;
    public static final WebViewFeatureInternal SAFE_BROWSING_WHITELIST;
    public static final WebViewFeatureInternal SERVICE_WORKER_BASIC_USAGE;
    public static final WebViewFeatureInternal SERVICE_WORKER_BLOCK_NETWORK_LOADS;
    public static final WebViewFeatureInternal SERVICE_WORKER_CACHE_MODE;
    public static final WebViewFeatureInternal SERVICE_WORKER_CONTENT_ACCESS;
    public static final WebViewFeatureInternal SERVICE_WORKER_FILE_ACCESS;
    public static final WebViewFeatureInternal SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST;
    public static final WebViewFeatureInternal SHOULD_OVERRIDE_WITH_REDIRECTS;
    public static final WebViewFeatureInternal START_SAFE_BROWSING;
    public static final WebViewFeatureInternal VISUAL_STATE_CALLBACK_FEATURE;
    public static final WebViewFeatureInternal WEB_MESSAGE_CALLBACK_ON_MESSAGE;
    public static final WebViewFeatureInternal WEB_MESSAGE_PORT_CLOSE;
    public static final WebViewFeatureInternal WEB_MESSAGE_PORT_POST_MESSAGE;
    public static final WebViewFeatureInternal WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK;
    public static final WebViewFeatureInternal WEB_RESOURCE_ERROR_GET_CODE;
    public static final WebViewFeatureInternal WEB_RESOURCE_ERROR_GET_DESCRIPTION;
    public static final WebViewFeatureInternal WEB_RESOURCE_REQUEST_IS_REDIRECT;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mFeatureValue;
    public final int mOsVersion;

    /* loaded from: classes.dex */
    public static class LAZY_HOLDER {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] WEBVIEW_APK_FEATURES;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1520128305, "Landroidx/webkit/internal/WebViewFeatureInternal$LAZY_HOLDER;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1520128305, "Landroidx/webkit/internal/WebViewFeatureInternal$LAZY_HOLDER;");
                    return;
                }
            }
            WEBVIEW_APK_FEATURES = WebViewGlueCommunicator.getFactory().getWebViewFeatures();
        }

        public LAZY_HOLDER() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-986581726, "Landroidx/webkit/internal/WebViewFeatureInternal;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-986581726, "Landroidx/webkit/internal/WebViewFeatureInternal;");
                return;
            }
        }
        VISUAL_STATE_CALLBACK_FEATURE = new WebViewFeatureInternal("VISUAL_STATE_CALLBACK_FEATURE", 0, "VISUAL_STATE_CALLBACK", 23);
        OFF_SCREEN_PRERASTER = new WebViewFeatureInternal("OFF_SCREEN_PRERASTER", 1, "OFF_SCREEN_PRERASTER", 23);
        SAFE_BROWSING_ENABLE = new WebViewFeatureInternal("SAFE_BROWSING_ENABLE", 2, "SAFE_BROWSING_ENABLE", 26);
        DISABLED_ACTION_MODE_MENU_ITEMS = new WebViewFeatureInternal("DISABLED_ACTION_MODE_MENU_ITEMS", 3, "DISABLED_ACTION_MODE_MENU_ITEMS", 24);
        START_SAFE_BROWSING = new WebViewFeatureInternal("START_SAFE_BROWSING", 4, "START_SAFE_BROWSING", 27);
        SAFE_BROWSING_WHITELIST = new WebViewFeatureInternal("SAFE_BROWSING_WHITELIST", 5, "SAFE_BROWSING_WHITELIST", 27);
        SAFE_BROWSING_PRIVACY_POLICY_URL = new WebViewFeatureInternal("SAFE_BROWSING_PRIVACY_POLICY_URL", 6, "SAFE_BROWSING_PRIVACY_POLICY_URL", 27);
        SERVICE_WORKER_BASIC_USAGE = new WebViewFeatureInternal("SERVICE_WORKER_BASIC_USAGE", 7, "SERVICE_WORKER_BASIC_USAGE", 24);
        SERVICE_WORKER_CACHE_MODE = new WebViewFeatureInternal("SERVICE_WORKER_CACHE_MODE", 8, "SERVICE_WORKER_CACHE_MODE", 24);
        SERVICE_WORKER_CONTENT_ACCESS = new WebViewFeatureInternal("SERVICE_WORKER_CONTENT_ACCESS", 9, "SERVICE_WORKER_CONTENT_ACCESS", 24);
        SERVICE_WORKER_FILE_ACCESS = new WebViewFeatureInternal("SERVICE_WORKER_FILE_ACCESS", 10, "SERVICE_WORKER_FILE_ACCESS", 24);
        SERVICE_WORKER_BLOCK_NETWORK_LOADS = new WebViewFeatureInternal("SERVICE_WORKER_BLOCK_NETWORK_LOADS", 11, "SERVICE_WORKER_BLOCK_NETWORK_LOADS", 24);
        SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST = new WebViewFeatureInternal("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", 12, "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", 24);
        RECEIVE_WEB_RESOURCE_ERROR = new WebViewFeatureInternal("RECEIVE_WEB_RESOURCE_ERROR", 13, "RECEIVE_WEB_RESOURCE_ERROR", 23);
        RECEIVE_HTTP_ERROR = new WebViewFeatureInternal("RECEIVE_HTTP_ERROR", 14, "RECEIVE_HTTP_ERROR", 23);
        SHOULD_OVERRIDE_WITH_REDIRECTS = new WebViewFeatureInternal("SHOULD_OVERRIDE_WITH_REDIRECTS", 15, "SHOULD_OVERRIDE_WITH_REDIRECTS", 24);
        SAFE_BROWSING_HIT = new WebViewFeatureInternal("SAFE_BROWSING_HIT", 16, "SAFE_BROWSING_HIT", 27);
        WEB_RESOURCE_REQUEST_IS_REDIRECT = new WebViewFeatureInternal("WEB_RESOURCE_REQUEST_IS_REDIRECT", 17, "WEB_RESOURCE_REQUEST_IS_REDIRECT", 24);
        WEB_RESOURCE_ERROR_GET_DESCRIPTION = new WebViewFeatureInternal("WEB_RESOURCE_ERROR_GET_DESCRIPTION", 18, "WEB_RESOURCE_ERROR_GET_DESCRIPTION", 23);
        WEB_RESOURCE_ERROR_GET_CODE = new WebViewFeatureInternal("WEB_RESOURCE_ERROR_GET_CODE", 19, "WEB_RESOURCE_ERROR_GET_CODE", 23);
        SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY = new WebViewFeatureInternal("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", 20, "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", 27);
        SAFE_BROWSING_RESPONSE_PROCEED = new WebViewFeatureInternal("SAFE_BROWSING_RESPONSE_PROCEED", 21, "SAFE_BROWSING_RESPONSE_PROCEED", 27);
        SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL = new WebViewFeatureInternal("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", 22, "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", 27);
        WEB_MESSAGE_PORT_POST_MESSAGE = new WebViewFeatureInternal("WEB_MESSAGE_PORT_POST_MESSAGE", 23, "WEB_MESSAGE_PORT_POST_MESSAGE", 23);
        WEB_MESSAGE_PORT_CLOSE = new WebViewFeatureInternal("WEB_MESSAGE_PORT_CLOSE", 24, "WEB_MESSAGE_PORT_CLOSE", 23);
        WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK = new WebViewFeatureInternal("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", 25, "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", 23);
        CREATE_WEB_MESSAGE_CHANNEL = new WebViewFeatureInternal("CREATE_WEB_MESSAGE_CHANNEL", 26, "CREATE_WEB_MESSAGE_CHANNEL", 23);
        POST_WEB_MESSAGE = new WebViewFeatureInternal("POST_WEB_MESSAGE", 27, "POST_WEB_MESSAGE", 23);
        WebViewFeatureInternal webViewFeatureInternal = new WebViewFeatureInternal("WEB_MESSAGE_CALLBACK_ON_MESSAGE", 28, "WEB_MESSAGE_CALLBACK_ON_MESSAGE", 23);
        WEB_MESSAGE_CALLBACK_ON_MESSAGE = webViewFeatureInternal;
        $VALUES = new WebViewFeatureInternal[]{VISUAL_STATE_CALLBACK_FEATURE, OFF_SCREEN_PRERASTER, SAFE_BROWSING_ENABLE, DISABLED_ACTION_MODE_MENU_ITEMS, START_SAFE_BROWSING, SAFE_BROWSING_WHITELIST, SAFE_BROWSING_PRIVACY_POLICY_URL, SERVICE_WORKER_BASIC_USAGE, SERVICE_WORKER_CACHE_MODE, SERVICE_WORKER_CONTENT_ACCESS, SERVICE_WORKER_FILE_ACCESS, SERVICE_WORKER_BLOCK_NETWORK_LOADS, SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST, RECEIVE_WEB_RESOURCE_ERROR, RECEIVE_HTTP_ERROR, SHOULD_OVERRIDE_WITH_REDIRECTS, SAFE_BROWSING_HIT, WEB_RESOURCE_REQUEST_IS_REDIRECT, WEB_RESOURCE_ERROR_GET_DESCRIPTION, WEB_RESOURCE_ERROR_GET_CODE, SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY, SAFE_BROWSING_RESPONSE_PROCEED, SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL, WEB_MESSAGE_PORT_POST_MESSAGE, WEB_MESSAGE_PORT_CLOSE, WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK, CREATE_WEB_MESSAGE_CHANNEL, POST_WEB_MESSAGE, webViewFeatureInternal};
    }

    public WebViewFeatureInternal(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFeatureValue = str2;
        this.mOsVersion = i3;
    }

    public static WebViewFeatureInternal getFeature(String str) {
        InterceptResult invokeL;
        WebViewFeatureInternal[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (WebViewFeatureInternal webViewFeatureInternal : values()) {
                if (webViewFeatureInternal.mFeatureValue.equals(str)) {
                    return webViewFeatureInternal;
                }
            }
            throw new RuntimeException("Unknown feature " + str);
        }
        return (WebViewFeatureInternal) invokeL.objValue;
    }

    public static UnsupportedOperationException getUnsupportedOperationException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK") : (UnsupportedOperationException) invokeV.objValue;
    }

    public static String[] getWebViewApkFeaturesForTesting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? LAZY_HOLDER.WEBVIEW_APK_FEATURES : (String[]) invokeV.objValue;
    }

    public static WebViewFeatureInternal valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (WebViewFeatureInternal) Enum.valueOf(WebViewFeatureInternal.class, str) : (WebViewFeatureInternal) invokeL.objValue;
    }

    public static WebViewFeatureInternal[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (WebViewFeatureInternal[]) $VALUES.clone() : (WebViewFeatureInternal[]) invokeV.objValue;
    }

    public boolean isSupportedByFramework() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Build.VERSION.SDK_INT >= this.mOsVersion : invokeV.booleanValue;
    }

    public boolean isSupportedByWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (String str : LAZY_HOLDER.WEBVIEW_APK_FEATURES) {
                if (str.equals(this.mFeatureValue)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
