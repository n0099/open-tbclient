package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BaiduStatJSInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface IWebviewPageLoadCallback {
        void onPageFinished(WebView webView, String str, bl blVar);

        void onPageStarted(WebView webView, String str, bl blVar);
    }

    public BaiduStatJSInterface() {
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

    /* loaded from: classes8.dex */
    public static class CustomWebChromeViewClient extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;

        /* renamed from: b  reason: collision with root package name */
        public WebChromeClient f36862b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<IWebviewPageLoadCallback> f36863c;

        /* renamed from: d  reason: collision with root package name */
        public bl f36864d;

        /* renamed from: e  reason: collision with root package name */
        public int f36865e;

        public CustomWebChromeViewClient(Context context, WebChromeClient webChromeClient, ArrayList<IWebviewPageLoadCallback> arrayList, bl blVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, webChromeClient, arrayList, blVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36865e = 0;
            this.a = new WeakReference<>(context);
            this.f36862b = webChromeClient;
            this.f36863c = arrayList;
            this.f36864d = blVar;
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, webView) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onCloseWindow(webView);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, consoleMessage)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onCreateWindow(webView, z, z2, message);
                }
                return super.onCreateWindow(webView, z, z2, message);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), quotaUpdater}) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onGeolocationPermissionsHidePrompt();
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, callback) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onHideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, str2, jsResult)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsAlert(webView, str, str2, jsResult);
                }
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, webView, str, str2, jsResult)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
                }
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, webView, str, str2, jsResult)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
                }
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048587, this, webView, str, str2, str3, jsPromptResult)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public boolean onJsTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsTimeout();
                }
                return super.onJsTimeout();
            }
            return invokeV.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, permissionRequest) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onPermissionRequest(permissionRequest);
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, permissionRequest) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onPermissionRequestCanceled(permissionRequest);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048591, this, webView, i2) == null) {
                ArrayList<IWebviewPageLoadCallback> arrayList = this.f36863c;
                if (arrayList != null) {
                    if (this.f36865e == 0) {
                        Iterator<IWebviewPageLoadCallback> it = arrayList.iterator();
                        while (it.hasNext()) {
                            IWebviewPageLoadCallback next = it.next();
                            if (next != null) {
                                next.onPageStarted(webView, webView.getUrl(), this.f36864d);
                            }
                        }
                    }
                    this.f36865e = i2;
                    if (i2 == 100) {
                        Iterator<IWebviewPageLoadCallback> it2 = this.f36863c.iterator();
                        while (it2.hasNext()) {
                            IWebviewPageLoadCallback next2 = it2.next();
                            if (next2 != null) {
                                next2.onPageFinished(webView, webView.getUrl(), this.f36864d);
                            }
                        }
                    }
                }
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    webChromeClient.onProgressChanged(webView, i2);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onReachedMaxAppCacheSize(j2, j3, quotaUpdater);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048593, this, webView, bitmap) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onReceivedIcon(webView, bitmap);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048594, this, webView, str) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onReceivedTitle(webView, str);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048595, this, webView, str, z) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onReceivedTouchIconUrl(webView, str, z);
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048596, this, webView) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onRequestFocus(webView);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048598, this, view, customViewCallback) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onShowCustomView(view, customViewCallback);
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, webView, valueCallback, fileChooserParams)) == null) {
                WebChromeClient webChromeClient = this.f36862b;
                if (webChromeClient != null) {
                    return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
                }
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return invokeLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        @Deprecated
        public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048597, this, view, i2, customViewCallback) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onShowCustomView(view, i2, customViewCallback);
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onConsoleMessage(String str, int i2, String str2) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) || (webChromeClient = this.f36862b) == null) {
                return;
            }
            webChromeClient.onConsoleMessage(str, i2, str2);
        }
    }

    /* loaded from: classes8.dex */
    public static class CustomWebViewClient extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;

        /* renamed from: b  reason: collision with root package name */
        public WebViewClient f36866b;

        /* renamed from: c  reason: collision with root package name */
        public IWebviewPageLoadCallback f36867c;

        /* renamed from: d  reason: collision with root package name */
        public bl f36868d;

        public CustomWebViewClient(Context context, WebViewClient webViewClient, IWebviewPageLoadCallback iWebviewPageLoadCallback, bl blVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, webViewClient, iWebviewPageLoadCallback, blVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(context);
            this.f36866b = webViewClient;
            this.f36867c = iWebviewPageLoadCallback;
            this.f36868d = blVar;
        }

        private void a(String str) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("action");
                JSONObject jSONObject2 = jSONObject.getJSONObject("obj");
                Context context = this.a.get();
                if (context == null) {
                    return;
                }
                if ("onPageStart".equals(string)) {
                    String string2 = jSONObject2.getString("page");
                    if (TextUtils.isEmpty(string2)) {
                        return;
                    }
                    BDStatCore.instance().onPageStart(context, string2);
                    return;
                }
                JSONObject jSONObject3 = null;
                if ("onPageEnd".equals(string)) {
                    String string3 = jSONObject2.getString("page");
                    if (TextUtils.isEmpty(string3)) {
                        return;
                    }
                    BDStatCore.instance().onPageEnd(context, string3, null, true);
                } else if ("onEvent".equals(string)) {
                    String string4 = jSONObject2.getString("event_id");
                    String string5 = jSONObject2.getString("label");
                    int i2 = jSONObject2.getInt("acc");
                    if (TextUtils.isEmpty(string4)) {
                        return;
                    }
                    try {
                        jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                    } catch (Exception unused) {
                    }
                    BDStatCore.instance().onEvent(context, string4, string5, i2, (ExtraInfo) null, (Map<String, String>) a(jSONObject3), false, true);
                } else if ("onEventStart".equals(string)) {
                    String string6 = jSONObject2.getString("event_id");
                    String string7 = jSONObject2.getString("label");
                    if (TextUtils.isEmpty(string6)) {
                        return;
                    }
                    BDStatCore.instance().onEventStart(context, string6, string7, false);
                } else if ("onEventEnd".equals(string)) {
                    String string8 = jSONObject2.getString("event_id");
                    String string9 = jSONObject2.getString("label");
                    if (TextUtils.isEmpty(string8)) {
                        return;
                    }
                    try {
                        jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                    } catch (Exception unused2) {
                    }
                    BDStatCore.instance().onEventEnd(context, string8, string9, null, a(jSONObject3), true);
                } else if ("onEventDuration".equals(string)) {
                    String string10 = jSONObject2.getString("event_id");
                    String string11 = jSONObject2.getString("label");
                    long j2 = jSONObject2.getLong("duration");
                    if (TextUtils.isEmpty(string10)) {
                        return;
                    }
                    try {
                        jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                    } catch (Exception unused3) {
                    }
                    BDStatCore.instance().onEventDuration(context, string10, string11, j2, null, a(jSONObject3), false, true);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onFormResubmission(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onPageCommitVisible(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048582, this, webView, clientCertRequest) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLILL(1048583, this, webView, i2, str, str2) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, webView, httpAuthHandler, str, str2) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048586, this, webView, webResourceRequest, webResourceResponse) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, webView, str, str2, str3) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048588, this, webView, sslErrorHandler, sslError) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, renderProcessGoneDetail)) == null) {
                WebViewClient webViewClient = this.f36866b;
                if (webViewClient != null) {
                    return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f2, float f3) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{webView, Float.valueOf(f2), Float.valueOf(f3)}) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onScaleChanged(webView, f2, f3);
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048591, this, webView, message, message2) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onTooManyRedirects(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048592, this, webView, keyEvent) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, str)) == null) {
                WebViewClient webViewClient = this.f36866b;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, str);
                }
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, keyEvent)) == null) {
                WebViewClient webViewClient = this.f36866b;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
                }
                return super.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, webView, str)) == null) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                    if (!TextUtils.isEmpty(str) && str.startsWith("bmtj:")) {
                        a(str.substring(5));
                        return true;
                    }
                } catch (UnsupportedEncodingException | JSONException unused) {
                }
                WebViewClient webViewClient = this.f36866b;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, webResourceRequest, webResourceError) == null) || (webViewClient = this.f36866b) == null) {
                return;
            }
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, webResourceRequest)) == null) {
                WebViewClient webViewClient = this.f36866b;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, webView, webResourceRequest)) == null) {
                WebViewClient webViewClient = this.f36866b;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return invokeLL.booleanValue;
        }

        private HashMap<String, String> a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                HashMap<String, String> hashMap = jSONObject.length() != 0 ? new HashMap<>() : null;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        String string = jSONObject.getString(next);
                        if (hashMap != null) {
                            hashMap.put(next, string);
                        }
                    } catch (Exception unused) {
                    }
                }
                return hashMap;
            }
            return (HashMap) invokeL.objValue;
        }
    }
}
