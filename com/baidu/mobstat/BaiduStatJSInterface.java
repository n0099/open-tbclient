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

    /* loaded from: classes2.dex */
    public interface IWebviewPageLoadCallback {
        void onPageFinished(WebView webView, String str, bk bkVar);

        void onPageStarted(WebView webView, String str, bk bkVar);
    }

    /* loaded from: classes2.dex */
    public static class CustomWebChromeViewClient extends WebChromeClient {
        public WeakReference<Context> a;
        public WebChromeClient b;
        public ArrayList<IWebviewPageLoadCallback> c;
        public bk d;
        public int e = 0;

        public CustomWebChromeViewClient(Context context, WebChromeClient webChromeClient, ArrayList<IWebviewPageLoadCallback> arrayList, bk bkVar) {
            this.a = new WeakReference<>(context);
            this.b = webChromeClient;
            this.c = arrayList;
            this.d = bkVar;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onCreateWindow(webView, z, z2, message);
            }
            return super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onConsoleMessage(String str, int i, String str2) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        @Deprecated
        public void onShowCustomView(View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view2, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public boolean onJsTimeout() {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onJsTimeout();
            }
            return super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view2, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            WebChromeClient webChromeClient = this.b;
            if (webChromeClient != null) {
                return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ArrayList<IWebviewPageLoadCallback> arrayList = this.c;
            if (arrayList != null) {
                if (this.e == 0) {
                    Iterator<IWebviewPageLoadCallback> it = arrayList.iterator();
                    while (it.hasNext()) {
                        IWebviewPageLoadCallback next = it.next();
                        if (next != null) {
                            next.onPageStarted(webView, webView.getUrl(), this.d);
                        }
                    }
                }
                this.e = i;
                if (i == 100) {
                    Iterator<IWebviewPageLoadCallback> it2 = this.c.iterator();
                    while (it2.hasNext()) {
                        IWebviewPageLoadCallback next2 = it2.next();
                        if (next2 != null) {
                            next2.onPageFinished(webView, webView.getUrl(), this.d);
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

    /* loaded from: classes2.dex */
    public static class CustomWebViewClient extends WebViewClient {
        public WeakReference<Context> a;
        public WebViewClient b;
        public IWebviewPageLoadCallback c;
        public bk d;

        public CustomWebViewClient(Context context, WebViewClient webViewClient, IWebviewPageLoadCallback iWebviewPageLoadCallback, bk bkVar) {
            this.a = new WeakReference<>(context);
            this.b = webViewClient;
            this.c = iWebviewPageLoadCallback;
            this.d = bkVar;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        private HashMap<String, String> a(JSONObject jSONObject) {
            HashMap<String, String> hashMap = null;
            if (jSONObject == null) {
                return null;
            }
            if (jSONObject.length() != 0) {
                hashMap = new HashMap<>();
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

        private void a(String str) throws JSONException {
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
                int i = jSONObject2.getInt("acc");
                if (TextUtils.isEmpty(string4)) {
                    return;
                }
                try {
                    jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                } catch (Exception unused) {
                }
                BDStatCore.instance().onEvent(context, string4, string5, i, (ExtraInfo) null, (Map<String, String>) a(jSONObject3), false, true);
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

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
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
    }
}
