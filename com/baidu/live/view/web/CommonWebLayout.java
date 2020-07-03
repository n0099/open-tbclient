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
/* loaded from: classes3.dex */
public class CommonWebLayout extends FrameLayout {
    private b boW;
    private CommonWebView boX;
    private List<String> boY;
    protected ValueCallback<Uri[]> boZ;
    private SchemeCallback bpa;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.bpa = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.boX.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.boX.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.boW = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.boX != null) {
            if (this.boY == null) {
                this.boY = new ArrayList();
            }
            this.boY.add(str);
            this.boX.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.boX != null) {
            this.boX.loadUrl(str);
        }
    }

    public void reload() {
        if (this.boX != null) {
            this.boX.reload();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.boX != null) {
            this.boX.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.boX != null) {
            this.boX.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.boX.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.boX != null) {
            this.boX.onPause();
        }
    }

    public void release() {
        this.boW = null;
        removeAllViews();
        if (this.boX != null) {
            if (this.boY != null) {
                for (String str : this.boY) {
                    this.boX.removeJavascriptInterface(str);
                }
                this.boY.clear();
            }
            try {
                this.boX.stopLoading();
                this.boX.removeAllViews();
                this.boX.loadUrl("about:blank");
                this.boX.freeMemory();
                this.boX.destroy();
            } catch (Exception e) {
            }
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.boX = new CommonWebView(getContext());
        this.boX.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.boW != null && CommonWebLayout.this.boW.ga(trim)) {
                    return true;
                }
                if (SchemeUtils.checkScheme(trim)) {
                    return SchemeUtils.openScheme(trim, CommonWebLayout.this.bpa);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.KN();
                if (CommonWebLayout.this.boW != null) {
                    CommonWebLayout.this.boW.fY(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.boW != null) {
                    CommonWebLayout.this.boW.fJ(str);
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
                if (CommonWebLayout.this.boW == null || !CommonWebLayout.this.boW.v(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.boX.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.boW != null) {
                    CommonWebLayout.this.boW.dE(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.boW != null) {
                    CommonWebLayout.this.boW.fZ(str);
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
                if (CommonWebLayout.this.boW != null) {
                    CommonWebLayout.this.boW.a(str2, jsResult);
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
        addView(this.boX, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i, String str2) {
        KM();
        if (this.boW != null) {
            this.boW.c(str, i, str2);
        }
    }

    private void KM() {
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
                    if (CommonWebLayout.this.boX != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.boX.getUrl())) {
                            CommonWebLayout.this.boX.loadUrl(CommonWebLayout.this.boX.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.boX.getOriginalUrl())) {
                            CommonWebLayout.this.boX.loadUrl(CommonWebLayout.this.boX.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.boW != null) {
                            CommonWebLayout.this.boW.Hh();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.boX == null) {
            return false;
        }
        return this.boX.canGoBack();
    }

    public void goBack() {
        if (this.boX != null) {
            this.boX.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.boX;
    }

    public SchemeCallback getSchemeCallback() {
        return this.bpa;
    }

    public void b(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.boZ != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.boZ != null) {
                    if (i2 == 0) {
                        this.boZ.onReceiveValue(null);
                        this.boZ = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.boZ.onReceiveValue(new Uri[]{data});
                        this.boZ = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> bpc;
        WeakReference<Activity> bpd;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.bpc = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.bpd = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            CommonWebLayout commonWebLayout = this.bpc.get();
            if (commonWebLayout != null) {
                commonWebLayout.mUploadMessage = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bpd.get();
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
            CommonWebLayout commonWebLayout = this.bpc.get();
            if (commonWebLayout != null) {
                commonWebLayout.boZ = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bpd.get();
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
