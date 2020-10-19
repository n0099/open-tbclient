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
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class BaiduStatJSInterface {

    /* loaded from: classes17.dex */
    public interface IWebviewPageLoadCallback {
        void onPageFinished(WebView webView, String str, bl blVar);

        void onPageStarted(WebView webView, String str, bl blVar);
    }

    /* loaded from: classes17.dex */
    public static class CustomWebViewClient extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Context> f2485a;
        private WebViewClient b;
        private IWebviewPageLoadCallback c;
        private bl d;

        public CustomWebViewClient(Context context, WebViewClient webViewClient, IWebviewPageLoadCallback iWebviewPageLoadCallback, bl blVar) {
            this.f2485a = new WeakReference<>(context);
            this.b = webViewClient;
            this.c = iWebviewPageLoadCallback;
            this.d = blVar;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2;
            try {
                str2 = URLDecoder.decode(str, "UTF-8");
                try {
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("bmtj:")) {
                        a(str2.substring(5));
                        return true;
                    }
                } catch (UnsupportedEncodingException e) {
                } catch (JSONException e2) {
                }
            } catch (UnsupportedEncodingException e3) {
                str2 = str;
            } catch (JSONException e4) {
                str2 = str;
            }
            if (this.b != null) {
                return this.b.shouldOverrideUrlLoading(webView, str2);
            }
            return super.shouldOverrideUrlLoading(webView, str2);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return this.b != null ? this.b.shouldOverrideUrlLoading(webView, webResourceRequest) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        private void a(String str) throws JSONException {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            JSONObject jSONObject4 = new JSONObject(str);
            String string = jSONObject4.getString("action");
            JSONObject jSONObject5 = jSONObject4.getJSONObject(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Context context = this.f2485a.get();
            if (context != null) {
                if ("onPageStart".equals(string)) {
                    String string2 = jSONObject5.getString("page");
                    if (!TextUtils.isEmpty(string2)) {
                        BDStatCore.instance().onPageStart(context, string2);
                    }
                } else if ("onPageEnd".equals(string)) {
                    String string3 = jSONObject5.getString("page");
                    if (!TextUtils.isEmpty(string3)) {
                        BDStatCore.instance().onPageEnd(context, string3, null, true);
                    }
                } else if ("onEvent".equals(string)) {
                    String string4 = jSONObject5.getString("event_id");
                    String string5 = jSONObject5.getString("label");
                    int i = jSONObject5.getInt("acc");
                    if (!TextUtils.isEmpty(string4)) {
                        try {
                            jSONObject3 = (JSONObject) jSONObject5.get("attributes");
                        } catch (Exception e) {
                            jSONObject3 = null;
                        }
                        BDStatCore.instance().onEvent(context, string4, string5, i, (ExtraInfo) null, (Map<String, String>) a(jSONObject3), false, true);
                    }
                } else if ("onEventStart".equals(string)) {
                    String string6 = jSONObject5.getString("event_id");
                    String string7 = jSONObject5.getString("label");
                    if (!TextUtils.isEmpty(string6)) {
                        BDStatCore.instance().onEventStart(context, string6, string7, false);
                    }
                } else if ("onEventEnd".equals(string)) {
                    String string8 = jSONObject5.getString("event_id");
                    String string9 = jSONObject5.getString("label");
                    if (!TextUtils.isEmpty(string8)) {
                        try {
                            jSONObject2 = (JSONObject) jSONObject5.get("attributes");
                        } catch (Exception e2) {
                            jSONObject2 = null;
                        }
                        BDStatCore.instance().onEventEnd(context, string8, string9, null, a(jSONObject2), true);
                    }
                } else if ("onEventDuration".equals(string)) {
                    String string10 = jSONObject5.getString("event_id");
                    String string11 = jSONObject5.getString("label");
                    long j = jSONObject5.getLong("duration");
                    if (!TextUtils.isEmpty(string10)) {
                        try {
                            jSONObject = (JSONObject) jSONObject5.get("attributes");
                        } catch (Exception e3) {
                            jSONObject = null;
                        }
                        BDStatCore.instance().onEventDuration(context, string10, string11, j, null, a(jSONObject), false, true);
                    }
                }
            }
        }

        private HashMap<String, String> a(JSONObject jSONObject) {
            HashMap<String, String> hashMap;
            if (jSONObject == null) {
                return null;
            }
            if (jSONObject.length() == 0) {
                hashMap = null;
            } else {
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
                } catch (Exception e) {
                }
            }
            return hashMap;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.b != null) {
                this.b.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.b != null) {
                this.b.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (this.b != null) {
                this.b.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            if (this.b != null) {
                this.b.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (this.b != null) {
                this.b.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (this.b != null) {
                this.b.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.b != null) {
                this.b.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (this.b != null) {
                this.b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return this.b != null ? this.b.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.b != null) {
                this.b.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            if (this.b != null) {
                this.b.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (this.b != null) {
                this.b.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            if (this.b != null) {
                this.b.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return this.b != null ? this.b.shouldInterceptRequest(webView, str) : super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return this.b != null ? this.b.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onPageCommitVisible(WebView webView, String str) {
            if (this.b != null) {
                this.b.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (this.b != null) {
                this.b.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (this.b != null) {
                this.b.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (this.b != null) {
                this.b.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return this.b != null ? this.b.onRenderProcessGone(webView, renderProcessGoneDetail) : super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    /* loaded from: classes17.dex */
    public static class CustomWebChromeViewClient extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Context> f2484a;
        private WebChromeClient b;
        private ArrayList<IWebviewPageLoadCallback> c;
        private bl d;
        private int e = 0;

        public CustomWebChromeViewClient(Context context, WebChromeClient webChromeClient, ArrayList<IWebviewPageLoadCallback> arrayList, bl blVar) {
            this.f2484a = new WeakReference<>(context);
            this.b = webChromeClient;
            this.c = arrayList;
            this.d = blVar;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (this.c != null) {
                if (this.e == 0) {
                    Iterator<IWebviewPageLoadCallback> it = this.c.iterator();
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
            if (this.b != null) {
                this.b.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return this.b != null ? this.b.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return this.b != null ? this.b.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return this.b != null ? this.b.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onConsoleMessage(String str, int i, String str2) {
            if (this.b != null) {
                this.b.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (this.b != null) {
                this.b.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (this.b != null) {
                this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (this.b != null) {
                this.b.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (this.b != null) {
                this.b.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (this.b != null) {
                this.b.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return this.b != null ? this.b.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return this.b != null ? this.b.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return this.b != null ? this.b.onJsPrompt(webView, str, str2, str3, jsPromptResult) : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public boolean onJsTimeout() {
            return this.b != null ? this.b.onJsTimeout() : super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (this.b != null) {
                this.b.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (this.b != null) {
                this.b.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (this.b != null) {
                this.b.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (this.b != null) {
                this.b.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (this.b != null) {
                this.b.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (this.b != null) {
                this.b.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (this.b != null) {
                this.b.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.b != null) {
                this.b.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        @Deprecated
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.b != null) {
                this.b.onShowCustomView(view, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @SuppressLint({"NewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return this.b != null ? this.b.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }
}
