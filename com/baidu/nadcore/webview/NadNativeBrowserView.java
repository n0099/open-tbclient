package com.baidu.nadcore.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.b51;
import com.baidu.tieba.ba1;
import com.baidu.tieba.ca1;
import com.baidu.tieba.ck0;
import com.baidu.tieba.d71;
import com.baidu.tieba.j91;
import com.baidu.tieba.k91;
import com.baidu.tieba.n91;
import com.baidu.tieba.nj0;
import com.baidu.tieba.v81;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\bO\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bO\u0010IJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010\u001fJ\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\nJ\u000f\u0010&\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010\rJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\nJ\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010\rJ\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\rJ\u000f\u0010+\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010\rJ)\u0010/\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00042\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J;\u00105\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u00042\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001022\u0006\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\nJ\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\nJ\u000f\u00109\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010\nJ#\u0010<\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010\nJ\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\nJ\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u000bH\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\nJ\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\nJ\u000f\u0010E\u001a\u00020\u0006H\u0016¢\u0006\u0004\bE\u0010\nJ\u000f\u0010F\u001a\u00020\u0006H\u0016¢\u0006\u0004\bF\u0010\nJ\u001f\u0010H\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010LR\u0016\u0010M\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/baidu/nadcore/webview/NadNativeBrowserView;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "", "obj", "", "name", "", "addJavaScriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "addWebViewToParent", "()V", "", "canGoBack", "()Z", "canGoForward", "clearHistory", "clearView", "Landroid/content/Context;", "context", "disableAccessibility", "(Landroid/content/Context;)V", "freeMemory", "isForward", "getPrePageUrl", "(Z)Ljava/lang/String;", "getSettings", "()Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "", "getTouchMode", "()I", "getUrl", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "getWebViewScrollY", "goBack", "handleBack", "initSettings", "initWebView", "isDestroyed", "isScrolledTop", "isZeusLoaded", "js", "Landroid/webkit/ValueCallback;", WebChromeClient.KEY_ARG_CALLBACK, "loadJavaScript", "(Ljava/lang/String;Landroid/webkit/ValueCallback;)V", "url", "", Constants.EXTRA_PARAM, StickerDataChangeType.REPLACE, "loadUrl", "(Ljava/lang/String;Ljava/util/Map;Z)V", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "", "postData", "postUrl", "(Ljava/lang/String;[B)V", "reload", "removeWebViewFromParent", "isAllow", "setAcceptThirdPartyCookies", "(Z)V", "setWebChromeClient", "setWebViewClient", "setWebViewClients", "setWebViewDownloadListener", "asWebView", "wrapHostWebView", "(Landroid/content/Context;Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "Z", "webView", "Landroid/webkit/WebView;", "<init>", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadNativeBrowserView extends AbsNadBrowserView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String s;
    public WebView t;
    public boolean u;

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public int getTouchMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadNativeBrowserView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public a(NadNativeBrowserView nadNativeBrowserView, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadNativeBrowserView, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadNativeBrowserView;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.b;
                Intrinsics.checkNotNull(str);
                if (!StringsKt__StringsJVMKt.startsWith$default(str, "javascript:", false, 2, null)) {
                    str = "javascript:" + str;
                }
                n91 n91Var = n91.b;
                if (b51.b.c()) {
                    NadNativeBrowserView.W(this.a).evaluateJavascript(str, this.c);
                } else {
                    NadNativeBrowserView.W(this.a).loadUrl(str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadNativeBrowserView a;

        public b(NadNativeBrowserView nadNativeBrowserView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadNativeBrowserView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadNativeBrowserView;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                v81 downloadListener = this.a.getDownloadListener();
                if (downloadListener != null) {
                    Context context = this.a.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    if (downloadListener.a(context, str, str2, str3, str4, j, this.a.Y(true))) {
                        return;
                    }
                }
                n91.c(this.a.getContext(), "downloadPlugin 没有接管下载！");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadNativeBrowserView(Context context) {
        super(context, null, 0, null, 14, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (k91) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.s = "NadNativeBrowserView";
    }

    public static final /* synthetic */ WebView W(NadNativeBrowserView nadNativeBrowserView) {
        WebView webView = nadNativeBrowserView.t;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        return webView;
    }

    private final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            try {
                CookieSyncManager.createInstance(getContext());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                th.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
                WebView webView = this.t;
                if (webView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                cookieManager.setAcceptThirdPartyCookies(webView, z);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void A(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, valueCallback) == null) {
            super.A(str, valueCallback);
            ck0.b(new a(this, str, valueCallback));
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    @SuppressLint({"JavascriptInterface"})
    public void a(Object obj, String name) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, obj, name) == null) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(name, "name");
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.addJavascriptInterface(obj, name);
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void D(String str, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z) == null) {
            super.D(str, map, z);
            n91.c(getContext(), "LOADING URL ...");
            String str2 = this.s;
            n91.a(str2, "loading url, url is " + str + " and header is " + String.valueOf(map));
            setFirstPage(true);
            if (map == null) {
                WebView webView = this.t;
                if (webView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                Intrinsics.checkNotNull(str);
                webView.loadUrl(str);
                return;
            }
            WebView webView2 = this.t;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            Intrinsics.checkNotNull(str);
            webView2.loadUrl(str, map);
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.I();
            this.u = true;
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.stopLoading();
            WebView webView2 = this.t;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView2.clearFocus();
            g();
            f();
            R();
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.R();
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            ViewParent parent = webView.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                WebView webView2 = this.t;
                if (webView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                viewGroup.removeView(webView2);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.c();
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            if (webView.getParent() == null) {
                WebView webView2 = this.t;
                if (webView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                addView(webView2, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            WebView a2 = j91.a().a(getContext());
            Intrinsics.checkNotNullExpressionValue(a2, "NativeWebViewRuntime.get…().createWebView(context)");
            this.t = a2;
            n91.a(this.s, "A native webView created");
            super.r();
            d71.c().d(getContext());
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.K();
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.onPause();
            if (getNeedPageLifeCycle()) {
                AbsNadBrowserView.C(this, "(function(){var event = document.createEvent('HTMLEvents');event.initEvent(\"baiduboxapppagehide\", true, true);document.dispatchEvent(event);})();", null, 2, null);
            }
            l();
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.L();
            this.u = false;
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.onResume();
            if (getNeedPageLifeCycle()) {
                AbsNadBrowserView.C(this, "(function(){var event = document.createEvent('HTMLEvents');event.initEvent(\"baiduboxapppageshow\", true, true);document.dispatchEvent(event);})();", null, 2, null);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.Q();
            if (!this.u) {
                setFirstPage(true);
                WebView webView = this.t;
                if (webView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                webView.reload();
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && d()) {
            setFirstPage(true);
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.goBack();
            getNeedPageLifeCycle();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.setWebChromeClient(new ba1(this, getWebChromeClientProxy()));
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.setWebViewClient(new ca1(this, getWebViewClientProxy()));
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            return webView.canGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.f();
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.clearHistory();
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.g();
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.clearView();
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public Object getSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings = webView.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
            return settings;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            String title = webView.getTitle();
            if (title == null) {
                return "";
            }
            return title;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            return webView.getUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public int getWebViewScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            return webView.getScrollY();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (d()) {
                Z();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void setWebViewClients() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.setWebViewClients();
            b0();
            a0();
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void setWebViewDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.setWebViewDownloadListener();
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.setDownloadListener(new b(this));
        }
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (getWebViewScrollY() <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                Object systemService = context.getSystemService("accessibility");
                if (systemService != null) {
                    AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
                    if (!accessibilityManager.isEnabled()) {
                        return;
                    }
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "am.javaClass.getDeclared…:class.javaPrimitiveType)");
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String Y(boolean z) {
        InterceptResult invokeZ;
        String url;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebBackForwardList historyList = webView.copyBackForwardList();
            Intrinsics.checkNotNullExpressionValue(historyList, "historyList");
            if (historyList.getSize() <= 0) {
                return "";
            }
            int currentIndex = historyList.getCurrentIndex();
            WebHistoryItem webHistoryItem = null;
            if (z) {
                if (currentIndex > 0 && currentIndex - 1 < historyList.getSize()) {
                    webHistoryItem = historyList.getItemAtIndex(i);
                }
            } else {
                int i2 = currentIndex + 1;
                if (i2 < historyList.getSize()) {
                    webHistoryItem = historyList.getItemAtIndex(i2);
                }
            }
            if (webHistoryItem == null || (url = webHistoryItem.getUrl()) == null) {
                return "";
            }
            return url;
        }
        return (String) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            return webView;
        }
        return (WebView) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.webview.view.AbsNadBrowserView
    public void o() {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.o();
            X(getContext());
            WebView webView = this.t;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView.setScrollbarFadingEnabled(true);
            WebView webView2 = this.t;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView2.setVerticalScrollBarEnabled(true);
            WebView webView3 = this.t;
            if (webView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView3.setHorizontalScrollBarEnabled(false);
            WebView webView4 = this.t;
            if (webView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings = webView4.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
            settings.setLightTouchEnabled(false);
            WebView webView5 = this.t;
            if (webView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings2 = webView5.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings2, "webView.settings");
            settings2.setUserAgentString(nj0.e());
            WebView webView6 = this.t;
            if (webView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings3 = webView6.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings3, "webView.settings");
            settings3.setDefaultTextEncodingName("UTF-8");
            WebView webView7 = this.t;
            if (webView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView7.getSettings().setSupportZoom(true);
            WebView webView8 = this.t;
            if (webView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings4 = webView8.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings4, "webView.settings");
            settings4.setJavaScriptEnabled(true);
            WebView webView9 = this.t;
            if (webView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings5 = webView9.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings5, "webView.settings");
            settings5.setAllowFileAccess(false);
            WebView webView10 = this.t;
            if (webView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings6 = webView10.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings6, "webView.settings");
            settings6.setUseWideViewPort(true);
            WebView webView11 = this.t;
            if (webView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings7 = webView11.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings7, "webView.settings");
            settings7.setPluginState(WebSettings.PluginState.ON);
            WebView webView12 = this.t;
            if (webView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings8 = webView12.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings8, "webView.settings");
            settings8.setCacheMode(-1);
            WebView webView13 = this.t;
            if (webView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings9 = webView13.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings9, "webView.settings");
            settings9.setJavaScriptCanOpenWindowsAutomatically(true);
            WebView webView14 = this.t;
            if (webView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings10 = webView14.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings10, "webView.settings");
            settings10.setAllowContentAccess(true);
            if (Build.VERSION.SDK_INT >= 21) {
                WebView webView15 = this.t;
                if (webView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                WebSettings settings11 = webView15.getSettings();
                Intrinsics.checkNotNullExpressionValue(settings11, "webView.settings");
                settings11.setMixedContentMode(0);
            }
            WebView webView16 = this.t;
            if (webView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings12 = webView16.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings12, "webView.settings");
            settings12.setLoadsImagesAutomatically(true);
            Context context = getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null && (window = activity.getWindow()) != null) {
                window.setFlags(16777216, 16777216);
            }
            WebView webView17 = this.t;
            if (webView17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings13 = webView17.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings13, "webView.settings");
            settings13.setDomStorageEnabled(true);
            WebView webView18 = this.t;
            if (webView18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            WebSettings settings14 = webView18.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings14, "webView.settings");
            settings14.setLoadWithOverviewMode(true);
            WebView webView19 = this.t;
            if (webView19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView19.clearFocus();
            WebView webView20 = this.t;
            if (webView20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView20.clearHistory();
            WebView webView21 = this.t;
            if (webView21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView21.clearView();
            WebView webView22 = this.t;
            if (webView22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView22.setScrollBarStyle(0);
            setAcceptThirdPartyCookies(true);
        }
    }
}
