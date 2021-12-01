package androidx.webkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.internal.WebMessagePortImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import androidx.webkit.internal.WebViewProviderFactory;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
/* loaded from: classes.dex */
public class WebViewCompat {
    public static /* synthetic */ Interceptable $ic;
    public static final Uri EMPTY_URI;
    public static final Uri WILDCARD_URI;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface VisualStateCallback {
        @UiThread
        void onComplete(long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(349542163, "Landroidx/webkit/WebViewCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(349542163, "Landroidx/webkit/WebViewCompat;");
                return;
            }
        }
        WILDCARD_URI = Uri.parse(ProxyConfig.MATCH_ALL_SCHEMES);
        EMPTY_URI = Uri.parse("");
    }

    public WebViewCompat() {
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

    public static void checkThread(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webView) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (webView.getWebViewLooper() == Looper.myLooper()) {
                    return;
                }
                throw new RuntimeException("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + webView.getWebViewLooper() + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + SmallTailInfo.EMOTION_SUFFIX);
            }
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("checkThread", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(webView, new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public static WebViewProviderBoundaryInterface createProvider(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, webView)) == null) ? getFactory().createWebView(webView) : (WebViewProviderBoundaryInterface) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public static WebMessagePortCompat[] createWebMessageChannel(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("CREATE_WEB_MESSAGE_CHANNEL");
            if (feature.isSupportedByFramework()) {
                return WebMessagePortImpl.portsToCompat(webView.createWebMessageChannel());
            }
            if (feature.isSupportedByWebView()) {
                return getProvider(webView).createWebMessageChannel();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (WebMessagePortCompat[]) invokeL.objValue;
    }

    @Nullable
    public static PackageInfo getCurrentWebViewPackage(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                return null;
            }
            if (i2 >= 26) {
                return WebView.getCurrentWebViewPackage();
            }
            try {
                PackageInfo loadedWebViewPackageInfo = getLoadedWebViewPackageInfo();
                return loadedWebViewPackageInfo != null ? loadedWebViewPackageInfo : getNotYetLoadedWebViewPackageInfo(context);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static WebViewProviderFactory getFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? WebViewGlueCommunicator.getFactory() : (WebViewProviderFactory) invokeV.objValue;
    }

    @SuppressLint({"PrivateApi"})
    public static PackageInfo getLoadedWebViewPackageInfo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]) : (PackageInfo) invokeV.objValue;
    }

    @SuppressLint({"PrivateApi"})
    public static PackageInfo getNotYetLoadedWebViewPackageInfo(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23) {
                    str = (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
                } else {
                    str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
                }
                if (str == null) {
                    return null;
                }
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static WebViewProviderAdapter getProvider(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, webView)) == null) ? new WebViewProviderAdapter(createProvider(webView)) : (WebViewProviderAdapter) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public static Uri getSafeBrowsingPrivacyPolicyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_PRIVACY_POLICY_URL");
            if (feature.isSupportedByFramework()) {
                return WebView.getSafeBrowsingPrivacyPolicyUrl();
            }
            if (feature.isSupportedByWebView()) {
                return getFactory().getStatics().getSafeBrowsingPrivacyPolicyUrl();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (Uri) invokeV.objValue;
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public static WebChromeClient getWebChromeClient(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, webView)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("GET_WEB_CHROME_CLIENT");
            if (feature.isSupportedByFramework()) {
                return webView.getWebChromeClient();
            }
            if (feature.isSupportedByWebView()) {
                return getProvider(webView).getWebChromeClient();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (WebChromeClient) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public static WebViewClient getWebViewClient(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, webView)) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("GET_WEB_VIEW_CLIENT");
            if (feature.isSupportedByFramework()) {
                return webView.getWebViewClient();
            }
            if (feature.isSupportedByWebView()) {
                return getProvider(webView).getWebViewClient();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (WebViewClient) invokeL.objValue;
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public static WebViewRenderProcess getWebViewRenderProcess(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, webView)) == null) {
            if (WebViewFeatureInternal.getFeature("GET_WEB_VIEW_RENDERER").isSupportedByWebView()) {
                return getProvider(webView).getWebViewRenderProcess();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (WebViewRenderProcess) invokeL.objValue;
    }

    @Nullable
    public static WebViewRenderProcessClient getWebViewRenderProcessClient(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, webView)) == null) {
            if (WebViewFeatureInternal.getFeature("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE").isSupportedByWebView()) {
                return getProvider(webView).getWebViewRenderProcessClient();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return (WebViewRenderProcessClient) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isMultiProcessEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (WebViewFeatureInternal.getFeature("MULTI_PROCESS_QUERY").isSupportedByWebView()) {
                return getFactory().getStatics().isMultiProcessEnabled();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        return invokeV.booleanValue;
    }

    public static void postVisualStateCallback(@NonNull WebView webView, long j2, @NonNull VisualStateCallback visualStateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{webView, Long.valueOf(j2), visualStateCallback}) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("VISUAL_STATE_CALLBACK");
            if (feature.isSupportedByFramework()) {
                webView.postVisualStateCallback(j2, new WebView.VisualStateCallback(visualStateCallback) { // from class: androidx.webkit.WebViewCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VisualStateCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {visualStateCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = visualStateCallback;
                    }

                    @Override // android.webkit.WebView.VisualStateCallback
                    public void onComplete(long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j3) == null) {
                            this.val$callback.onComplete(j3);
                        }
                    }
                });
            } else if (feature.isSupportedByWebView()) {
                checkThread(webView);
                getProvider(webView).insertVisualStateCallback(j2, visualStateCallback);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void postWebMessage(@NonNull WebView webView, @NonNull WebMessageCompat webMessageCompat, @NonNull Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, webView, webMessageCompat, uri) == null) {
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
    }

    @SuppressLint({"NewApi"})
    public static void setSafeBrowsingWhitelist(@NonNull List<String> list, @Nullable ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, list, valueCallback) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_WHITELIST");
            if (feature.isSupportedByFramework()) {
                WebView.setSafeBrowsingWhitelist(list, valueCallback);
            } else if (feature.isSupportedByWebView()) {
                getFactory().getStatics().setSafeBrowsingWhitelist(list, valueCallback);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    public static void setWebViewRenderProcessClient(@NonNull WebView webView, @NonNull Executor executor, @NonNull WebViewRenderProcessClient webViewRenderProcessClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, webView, executor, webViewRenderProcessClient) == null) {
            if (WebViewFeatureInternal.getFeature("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE").isSupportedByWebView()) {
                getProvider(webView).setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void startSafeBrowsing(@NonNull Context context, @Nullable ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, valueCallback) == null) {
            WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("START_SAFE_BROWSING");
            if (feature.isSupportedByFramework()) {
                WebView.startSafeBrowsing(context, valueCallback);
            } else if (feature.isSupportedByWebView()) {
                getFactory().getStatics().initSafeBrowsing(context, valueCallback);
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }

    public static void setWebViewRenderProcessClient(@NonNull WebView webView, @Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, webView, webViewRenderProcessClient) == null) {
            if (WebViewFeatureInternal.getFeature("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE").isSupportedByWebView()) {
                getProvider(webView).setWebViewRenderProcessClient(null, webViewRenderProcessClient);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
