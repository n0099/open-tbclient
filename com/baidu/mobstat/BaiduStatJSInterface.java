package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Bitmap;
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
/* loaded from: classes2.dex */
public class BaiduStatJSInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface IWebviewPageLoadCallback {
        void onPageFinished(WebView webView, String str, bk bkVar);

        void onPageStarted(WebView webView, String str, bk bkVar);
    }

    /* loaded from: classes2.dex */
    public class CustomWebChromeViewClient extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference a;
        public WebChromeClient b;
        public ArrayList c;
        public bk d;
        public int e;

        public CustomWebChromeViewClient(Context context, WebChromeClient webChromeClient, ArrayList arrayList, bk bkVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, webChromeClient, arrayList, bkVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = 0;
            this.a = new WeakReference(context);
            this.b = webChromeClient;
            this.c = arrayList;
            this.d = bkVar;
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, webView) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, consoleMessage)) == null) {
                WebChromeClient webChromeClient = this.b;
                if (webChromeClient != null) {
                    return webChromeClient.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, permissionRequest) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, permissionRequest) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048596, this, webView) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onConsoleMessage(String str, int i, String str2) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048595, this, webView, str, z) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onShowCustomView(View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048597, this, view2, i, customViewCallback) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onShowCustomView(view2, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, webView, valueCallback, fileChooserParams)) == null) {
                WebChromeClient webChromeClient = this.b;
                if (webChromeClient != null) {
                    return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
                }
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return invokeLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
                WebChromeClient webChromeClient = this.b;
                if (webChromeClient != null) {
                    return webChromeClient.onCreateWindow(webView, z, z2, message);
                }
                return super.onCreateWindow(webView, z, z2, message);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public boolean onJsTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                WebChromeClient webChromeClient = this.b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsTimeout();
                }
                return super.onJsTimeout();
            }
            return invokeV.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048582, this, str, callback) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048593, this, webView, bitmap) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048594, this, webView, str) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048598, this, view2, customViewCallback) == null) && (webChromeClient = this.b) != null) {
                webChromeClient.onShowCustomView(view2, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, str2, jsResult)) == null) {
                WebChromeClient webChromeClient = this.b;
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
                WebChromeClient webChromeClient = this.b;
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
                WebChromeClient webChromeClient = this.b;
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
                WebChromeClient webChromeClient = this.b;
                if (webChromeClient != null) {
                    return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048591, this, webView, i) == null) {
                ArrayList arrayList = this.c;
                if (arrayList != null) {
                    if (this.e == 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            IWebviewPageLoadCallback iWebviewPageLoadCallback = (IWebviewPageLoadCallback) it.next();
                            if (iWebviewPageLoadCallback != null) {
                                iWebviewPageLoadCallback.onPageStarted(webView, webView.getUrl(), this.d);
                            }
                        }
                    }
                    this.e = i;
                    if (i == 100) {
                        Iterator it2 = this.c.iterator();
                        while (it2.hasNext()) {
                            IWebviewPageLoadCallback iWebviewPageLoadCallback2 = (IWebviewPageLoadCallback) it2.next();
                            if (iWebviewPageLoadCallback2 != null) {
                                iWebviewPageLoadCallback2.onPageFinished(webView, webView.getUrl(), this.d);
                            }
                        }
                    }
                }
                WebChromeClient webChromeClient = this.b;
                if (webChromeClient != null) {
                    webChromeClient.onProgressChanged(webView, i);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class CustomWebViewClient extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference a;
        public WebViewClient b;
        public IWebviewPageLoadCallback c;
        public bk d;

        public CustomWebViewClient(Context context, WebViewClient webViewClient, IWebviewPageLoadCallback iWebviewPageLoadCallback, bk bkVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, webViewClient, iWebviewPageLoadCallback, bkVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference(context);
            this.b = webViewClient;
            this.c = iWebviewPageLoadCallback;
            this.d = bkVar;
        }

        private HashMap a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
                HashMap hashMap = null;
                if (jSONObject == null) {
                    return null;
                }
                if (jSONObject.length() != 0) {
                    hashMap = new HashMap();
                }
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

        private void a(String str) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("action");
                JSONObject jSONObject2 = jSONObject.getJSONObject("obj");
                Context context = (Context) this.a.get();
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
                    int i = jSONObject2.getInt("acc");
                    if (TextUtils.isEmpty(string4)) {
                        return;
                    }
                    try {
                        jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                    } catch (Exception unused) {
                    }
                    BDStatCore.instance().onEvent(context, string4, string5, i, (ExtraInfo) null, (Map) a(jSONObject3), false, true);
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
                    long j = jSONObject2.getLong("duration");
                    if (TextUtils.isEmpty(string10)) {
                        return;
                    }
                    try {
                        jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                    } catch (Exception unused3) {
                    }
                    BDStatCore.instance().onEventDuration(context, string10, string11, j, null, a(jSONObject3), false, true);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) && (webViewClient = this.b) != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) && (webViewClient = this.b) != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) && (webViewClient = this.b) != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, webResourceRequest, webResourceError) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048586, this, webView, webResourceRequest, webResourceResponse) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048588, this, webView, sslErrorHandler, sslError) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{webView, Float.valueOf(f), Float.valueOf(f2)}) == null) && (webViewClient = this.b) != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048591, this, webView, message, message2) == null) && (webViewClient = this.b) != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) && (webViewClient = this.b) != null) {
                webViewClient.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) && (webViewClient = this.b) != null) {
                webViewClient.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) && (webViewClient = this.b) != null) {
                webViewClient.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048582, this, webView, clientCertRequest) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, renderProcessGoneDetail)) == null) {
                WebViewClient webViewClient = this.b;
                if (webViewClient != null) {
                    return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048592, this, webView, keyEvent) == null) && (webViewClient = this.b) != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, webResourceRequest)) == null) {
                WebViewClient webViewClient = this.b;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, keyEvent)) == null) {
                WebViewClient webViewClient = this.b;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
                }
                return super.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, webView, webResourceRequest)) == null) {
                WebViewClient webViewClient = this.b;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLILL(1048583, this, webView, i, str, str2) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLL(1048585, this, webView, httpAuthHandler, str, str2) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLL(1048587, this, webView, str, str2, str3) == null) && (webViewClient = this.b) != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, str)) == null) {
                WebViewClient webViewClient = this.b;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, str);
                }
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) invokeLL.objValue;
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
                WebViewClient webViewClient = this.b;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    public BaiduStatJSInterface() {
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
}
