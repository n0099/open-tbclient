package com.baidu.live.view.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonWebLayout extends FrameLayout {
    private b bcv;
    private CommonWebView bcw;
    private List<String> bcx;
    protected ValueCallback<Uri[]> bcy;
    private SchemeCallback bcz;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.bcz = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.bcw.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.bcw.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.bcv = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bcw != null) {
            if (this.bcx == null) {
                this.bcx = new ArrayList();
            }
            this.bcx.add(str);
            this.bcw.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.bcw != null) {
            this.bcw.loadUrl(str);
        }
    }

    public void reload() {
        if (this.bcw != null) {
            this.bcw.reload();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.bcw != null) {
            this.bcw.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.bcw != null) {
            this.bcw.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bcw.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.bcw != null) {
            this.bcw.onPause();
        }
    }

    public void release() {
        this.bcv = null;
        removeAllViews();
        if (this.bcw != null) {
            if (this.bcx != null) {
                for (String str : this.bcx) {
                    this.bcw.removeJavascriptInterface(str);
                }
                this.bcx.clear();
            }
            this.bcw.stopLoading();
            this.bcw.removeAllViews();
            this.bcw.loadUrl("about:blank");
            this.bcw.freeMemory();
            this.bcw.destroy();
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.bcw = new CommonWebView(getContext());
        this.bcw.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.bcv != null && CommonWebLayout.this.bcv.fg(trim)) {
                    return true;
                }
                if (SchemeUtils.checkScheme(trim)) {
                    return SchemeUtils.openScheme(trim, CommonWebLayout.this.bcz);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.HL();
                if (CommonWebLayout.this.bcv != null) {
                    CommonWebLayout.this.bcv.fd(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.bcv != null) {
                    CommonWebLayout.this.bcv.fe(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    CommonWebLayout.this.d(str2, i, str);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    CommonWebLayout.this.d(webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "", webResourceError != null ? webResourceError.getErrorCode() : -1, (webResourceError == null || webResourceError.getDescription() == null) ? "unknown" : webResourceError.getDescription().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                if (CommonWebLayout.this.bcv == null || !CommonWebLayout.this.bcv.p(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.bcw.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.bcv != null) {
                    CommonWebLayout.this.bcv.dm(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.bcv != null) {
                    CommonWebLayout.this.bcv.ff(str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (jsResult != null) {
                    jsResult.cancel();
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (CommonWebLayout.this.bcv != null) {
                    CommonWebLayout.this.bcv.a(str2, jsResult);
                    return true;
                } else if (jsResult != null) {
                    jsResult.cancel();
                    return true;
                } else {
                    return true;
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (jsPromptResult != null) {
                    jsPromptResult.cancel();
                    return true;
                }
                return true;
            }
        });
        addView(this.bcw, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i, String str2) {
        HK();
        if (this.bcv != null) {
            this.bcv.c(str, i, str2);
        }
    }

    private void HK() {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            } else if (!(getChildAt(i) instanceof CommonEmptyView)) {
                i++;
            } else {
                getChildAt(i).setVisibility(0);
                z = true;
                break;
            }
        }
        if (!z) {
            CommonEmptyView commonEmptyView = new CommonEmptyView(getContext());
            commonEmptyView.reset();
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.view.web.CommonWebLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommonWebLayout.this.bcw != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.bcw.getUrl())) {
                            CommonWebLayout.this.bcw.loadUrl(CommonWebLayout.this.bcw.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.bcw.getOriginalUrl())) {
                            CommonWebLayout.this.bcw.loadUrl(CommonWebLayout.this.bcw.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.bcv != null) {
                            CommonWebLayout.this.bcv.HJ();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.bcw == null) {
            return false;
        }
        return this.bcw.canGoBack();
    }

    public void goBack() {
        if (this.bcw != null) {
            this.bcw.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.bcw;
    }

    public SchemeCallback getSchemeCallback() {
        return this.bcz;
    }

    public void b(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.bcy != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.bcy != null) {
                    if (i2 == 0) {
                        this.bcy.onReceiveValue(null);
                        this.bcy = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.bcy.onReceiveValue(new Uri[]{data});
                        this.bcy = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> bcB;
        WeakReference<Activity> bcC;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.bcB = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.bcC = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            CommonWebLayout commonWebLayout = this.bcB.get();
            if (commonWebLayout != null) {
                commonWebLayout.mUploadMessage = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bcC.get();
            if (activity != null) {
                try {
                    activity.startActivityForResult(intent, RequestResponseCode.REQUESTCODE_FILECHOOSER);
                } catch (Throwable th) {
                    th.toString();
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            openFileChooser(valueCallback, "");
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            openFileChooser(valueCallback, "");
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            CommonWebLayout commonWebLayout = this.bcB.get();
            if (commonWebLayout != null) {
                commonWebLayout.bcy = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bcC.get();
            if (activity != null) {
                try {
                    activity.startActivityForResult(intent, RequestResponseCode.REQUESTCODE_FILECHOOSER);
                    return true;
                } catch (Throwable th) {
                    th.toString();
                    return true;
                }
            }
            return true;
        }
    }
}
