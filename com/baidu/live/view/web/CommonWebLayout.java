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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CommonWebLayout extends FrameLayout {
    private b aCf;
    private CommonWebView aCg;
    private List<String> aCh;
    protected ValueCallback<Uri[]> aCi;
    private SchemeCallback aCj;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.aCj = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.aCg.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.aCg.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.aCf = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aCg != null) {
            if (this.aCh == null) {
                this.aCh = new ArrayList();
            }
            this.aCh.add(str);
            this.aCg.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.aCg != null) {
            this.aCg.loadUrl(str);
        }
    }

    public void reload() {
        if (this.aCg != null) {
            this.aCg.reload();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.aCg != null) {
            this.aCg.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.aCg != null) {
            this.aCg.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aCg.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.aCg != null) {
            this.aCg.onPause();
        }
    }

    public void release() {
        this.aCf = null;
        removeAllViews();
        if (this.aCg != null) {
            if (this.aCh != null) {
                for (String str : this.aCh) {
                    this.aCg.removeJavascriptInterface(str);
                }
                this.aCh.clear();
            }
            this.aCg.stopLoading();
            this.aCg.removeAllViews();
            this.aCg.loadUrl("about:blank");
            this.aCg.freeMemory();
            this.aCg.destroy();
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.aCg = new CommonWebView(getContext());
        this.aCg.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.aCf != null && CommonWebLayout.this.aCf.dZ(trim)) {
                    return true;
                }
                if (SchemeUtils.checkScheme(trim)) {
                    return SchemeUtils.openScheme(trim, CommonWebLayout.this.aCj);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.zj();
                if (CommonWebLayout.this.aCf != null) {
                    CommonWebLayout.this.aCf.dW(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.aCf != null) {
                    CommonWebLayout.this.aCf.dX(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    CommonWebLayout.this.c(str2, i, str);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    CommonWebLayout.this.c(webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "", webResourceError != null ? webResourceError.getErrorCode() : -1, (webResourceError == null || webResourceError.getDescription() == null) ? "unknown" : webResourceError.getDescription().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                if (CommonWebLayout.this.aCf == null || !CommonWebLayout.this.aCf.l(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.aCg.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.aCf != null) {
                    CommonWebLayout.this.aCf.cH(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.aCf != null) {
                    CommonWebLayout.this.aCf.dY(str);
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
                if (CommonWebLayout.this.aCf != null) {
                    CommonWebLayout.this.aCf.a(str2, jsResult);
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
        addView(this.aCg, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i, String str2) {
        zi();
        if (this.aCf != null) {
            this.aCf.b(str, i, str2);
        }
    }

    private void zi() {
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
                    if (CommonWebLayout.this.aCg != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.aCg.getUrl())) {
                            CommonWebLayout.this.aCg.loadUrl(CommonWebLayout.this.aCg.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.aCg.getOriginalUrl())) {
                            CommonWebLayout.this.aCg.loadUrl(CommonWebLayout.this.aCg.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.aCf != null) {
                            CommonWebLayout.this.aCf.zh();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.aCg == null) {
            return false;
        }
        return this.aCg.canGoBack();
    }

    public void goBack() {
        if (this.aCg != null) {
            this.aCg.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.aCg;
    }

    public SchemeCallback getSchemeCallback() {
        return this.aCj;
    }

    public void b(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.aCi != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.aCi != null) {
                    if (i2 == 0) {
                        this.aCi.onReceiveValue(null);
                        this.aCi = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.aCi.onReceiveValue(new Uri[]{data});
                        this.aCi = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> aCl;
        WeakReference<Activity> aCm;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.aCl = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.aCm = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            CommonWebLayout commonWebLayout = this.aCl.get();
            if (commonWebLayout != null) {
                commonWebLayout.mUploadMessage = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.aCm.get();
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
            CommonWebLayout commonWebLayout = this.aCl.get();
            if (commonWebLayout != null) {
                commonWebLayout.aCi = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.aCm.get();
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
