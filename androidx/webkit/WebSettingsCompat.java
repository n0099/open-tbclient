package androidx.webkit;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
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
    public static /* synthetic */ Interceptable $ic = null;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FORCE_DARK_AUTO = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FORCE_DARK_OFF = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FORCE_DARK_ON = 2;
    public transient /* synthetic */ FieldHolder $fh;

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

    public WebSettingsCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public static int getDisabledActionModeMenuItems(@NonNull WebSettings webSettings) {
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getForceDark(@NonNull WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, webSettings)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("FORCE_DARK");
            if (feature.isSupportedByFramework()) {
                return webSettings.getForceDark();
            }
            if (feature.isSupportedByWebView()) {
                return getAdapter(webSettings).getForceDark();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeL.intValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean getOffscreenPreRaster(@NonNull WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webSettings)) == null) {
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
    public static boolean getSafeBrowsingEnabled(@NonNull WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, webSettings)) == null) {
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
    public static void setDisabledActionModeMenuItems(@NonNull WebSettings webSettings, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, webSettings, i) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("DISABLED_ACTION_MODE_MENU_ITEMS");
            if (feature.isSupportedByFramework()) {
                webSettings.setDisabledActionModeMenuItems(i);
            } else if (feature.isSupportedByWebView()) {
                getAdapter(webSettings).setDisabledActionModeMenuItems(i);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceDark(@NonNull WebSettings webSettings, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, webSettings, i) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("FORCE_DARK");
            if (feature.isSupportedByFramework()) {
                webSettings.setForceDark(i);
            } else if (feature.isSupportedByWebView()) {
                getAdapter(webSettings).setForceDark(i);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void setOffscreenPreRaster(@NonNull WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, webSettings, z) == null) {
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
    public static void setSafeBrowsingEnabled(@NonNull WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, webSettings, z) == null) {
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

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setWillSuppressErrorPage(@NonNull WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, webSettings, z) == null) {
            if (WebViewFeatureInternal.getFeature("SUPPRESS_ERROR_PAGE").isSupportedByWebView()) {
                getAdapter(webSettings).setWillSuppressErrorPage(z);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean willSuppressErrorPage(@NonNull WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, webSettings)) == null) {
            if (WebViewFeatureInternal.getFeature("SUPPRESS_ERROR_PAGE").isSupportedByWebView()) {
                return getAdapter(webSettings).willSuppressErrorPage();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }
}
