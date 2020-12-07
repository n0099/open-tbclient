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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonWebLayout extends FrameLayout {
    private b bQY;
    private CommonWebView bQZ;
    private List<String> bRa;
    protected ValueCallback<Uri[]> bRb;
    private SchemeCallback bRc;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.bRc = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.bQZ.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.bQZ.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.bQY = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bQZ != null) {
            if (this.bRa == null) {
                this.bRa = new ArrayList();
            }
            this.bRa.add(str);
            this.bQZ.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.bQZ != null) {
            this.bQZ.loadUrl(str);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.bQZ != null) {
            this.bQZ.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.bQZ != null) {
            this.bQZ.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bQZ.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.bQZ != null) {
            this.bQZ.onPause();
        }
    }

    public void release() {
        this.bQY = null;
        removeAllViews();
        if (this.bQZ != null) {
            if (this.bRa != null) {
                for (String str : this.bRa) {
                    this.bQZ.removeJavascriptInterface(str);
                }
                this.bRa.clear();
            }
            try {
                this.bQZ.stopLoading();
                this.bQZ.removeAllViews();
                this.bQZ.loadUrl("about:blank");
                this.bQZ.freeMemory();
                this.bQZ.destroy();
            } catch (Exception e) {
            }
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.bQZ = new CommonWebView(getContext());
        this.bQZ.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.bQY != null && CommonWebLayout.this.bQY.jo(trim)) {
                    return true;
                }
                if (!SchemeUtils.checkScheme(trim) && !SchemeUtils.checkCommonScheme(trim)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return SchemeUtils.openScheme(trim, CommonWebLayout.this.bRc);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.YN();
                if (CommonWebLayout.this.bQY != null) {
                    CommonWebLayout.this.bQY.is(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.bQY != null) {
                    CommonWebLayout.this.bQY.it(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    CommonWebLayout.this.g(str2, i, str);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    CommonWebLayout.this.g(webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "", webResourceError != null ? webResourceError.getErrorCode() : -1, (webResourceError == null || webResourceError.getDescription() == null) ? "unknown" : webResourceError.getDescription().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                if (CommonWebLayout.this.bQY == null || !CommonWebLayout.this.bQY.F(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.bQZ.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.bQY != null) {
                    CommonWebLayout.this.bQY.fu(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.bQY != null) {
                    CommonWebLayout.this.bQY.jn(str);
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
                if (CommonWebLayout.this.bQY != null) {
                    CommonWebLayout.this.bQY.a(str2, jsResult);
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
        addView(this.bQZ, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, String str2) {
        YM();
        if (this.bQY != null) {
            this.bQY.e(str, i, str2);
        }
    }

    private void YM() {
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
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.view.web.CommonWebLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommonWebLayout.this.bQZ != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.bQZ.getUrl())) {
                            CommonWebLayout.this.bQZ.loadUrl(CommonWebLayout.this.bQZ.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.bQZ.getOriginalUrl())) {
                            CommonWebLayout.this.bQZ.loadUrl(CommonWebLayout.this.bQZ.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.bQY != null) {
                            CommonWebLayout.this.bQY.YL();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YN() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.bQZ == null) {
            return false;
        }
        return this.bQZ.canGoBack();
    }

    public void goBack() {
        if (this.bQZ != null) {
            this.bQZ.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.bQZ;
    }

    public SchemeCallback getSchemeCallback() {
        return this.bRc;
    }

    public void b(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.bRb != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.bRb != null) {
                    if (i2 == 0) {
                        this.bRb.onReceiveValue(null);
                        this.bRb = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.bRb.onReceiveValue(new Uri[]{data});
                        this.bRb = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> bRe;
        WeakReference<Activity> bRf;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.bRe = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.bRf = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            CommonWebLayout commonWebLayout = this.bRe.get();
            if (commonWebLayout != null) {
                commonWebLayout.mUploadMessage = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bRf.get();
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
            CommonWebLayout commonWebLayout = this.bRe.get();
            if (commonWebLayout != null) {
                commonWebLayout.bRb = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bRf.get();
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
