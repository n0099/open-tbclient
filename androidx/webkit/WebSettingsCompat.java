package androidx.webkit;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes.dex */
public class WebSettingsCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface MenuItemFlags {
    }

    public WebSettingsCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static WebSettingsAdapter getAdapter(WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webSettings)) == null) ? WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings) : (WebSettingsAdapter) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static int getDisabledActionModeMenuItems(WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webSettings)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("DISABLED_ACTION_MODE_MENU_ITEMS");
            if (feature.isSupportedByFramework()) {
                return webSettings.getDisabledActionModeMenuItems();
            }
            if (feature.isSupportedByWebView()) {
                return getAdapter(webSettings).getDisabledActionModeMenuItems();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeL.intValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean getOffscreenPreRaster(WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, webSettings)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("OFF_SCREEN_PRERASTER");
            if (feature.isSupportedByFramework()) {
                return webSettings.getOffscreenPreRaster();
            }
            if (feature.isSupportedByWebView()) {
                return getAdapter(webSettings).getOffscreenPreRaster();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean getSafeBrowsingEnabled(WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, webSettings)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_ENABLE");
            if (feature.isSupportedByFramework()) {
                return webSettings.getSafeBrowsingEnabled();
            }
            if (feature.isSupportedByWebView()) {
                return getAdapter(webSettings).getSafeBrowsingEnabled();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static void setDisabledActionModeMenuItems(WebSettings webSettings, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, webSettings, i2) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("DISABLED_ACTION_MODE_MENU_ITEMS");
            if (feature.isSupportedByFramework()) {
                webSettings.setDisabledActionModeMenuItems(i2);
            } else if (feature.isSupportedByWebView()) {
                getAdapter(webSettings).setDisabledActionModeMenuItems(i2);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void setOffscreenPreRaster(WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, webSettings, z) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("OFF_SCREEN_PRERASTER");
            if (feature.isSupportedByFramework()) {
                webSettings.setOffscreenPreRaster(z);
            } else if (feature.isSupportedByWebView()) {
                getAdapter(webSettings).setOffscreenPreRaster(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void setSafeBrowsingEnabled(WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, webSettings, z) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_ENABLE");
            if (feature.isSupportedByFramework()) {
                webSettings.setSafeBrowsingEnabled(z);
            } else if (feature.isSupportedByWebView()) {
                getAdapter(webSettings).setSafeBrowsingEnabled(z);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }
}
