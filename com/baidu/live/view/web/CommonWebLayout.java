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
    private b bpr;
    private CommonWebView bps;
    private List<String> bpt;
    protected ValueCallback<Uri[]> bpu;
    private SchemeCallback bpv;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.bpv = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.bps.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.bps.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.bpr = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bps != null) {
            if (this.bpt == null) {
                this.bpt = new ArrayList();
            }
            this.bpt.add(str);
            this.bps.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.bps != null) {
            this.bps.loadUrl(str);
        }
    }

    public void reload() {
        if (this.bps != null) {
            this.bps.reload();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.bps != null) {
            this.bps.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.bps != null) {
            this.bps.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bps.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.bps != null) {
            this.bps.onPause();
        }
    }

    public void release() {
        this.bpr = null;
        removeAllViews();
        if (this.bps != null) {
            if (this.bpt != null) {
                for (String str : this.bpt) {
                    this.bps.removeJavascriptInterface(str);
                }
                this.bpt.clear();
            }
            try {
                this.bps.stopLoading();
                this.bps.removeAllViews();
                this.bps.loadUrl("about:blank");
                this.bps.freeMemory();
                this.bps.destroy();
            } catch (Exception e) {
            }
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.bps = new CommonWebView(getContext());
        this.bps.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.bpr != null && CommonWebLayout.this.bpr.fZ(trim)) {
                    return true;
                }
                if (SchemeUtils.checkScheme(trim)) {
                    return SchemeUtils.openScheme(trim, CommonWebLayout.this.bpv);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.KU();
                if (CommonWebLayout.this.bpr != null) {
                    CommonWebLayout.this.bpr.fX(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.bpr != null) {
                    CommonWebLayout.this.bpr.fH(str);
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
                if (CommonWebLayout.this.bpr == null || !CommonWebLayout.this.bpr.v(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.bps.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.bpr != null) {
                    CommonWebLayout.this.bpr.dE(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.bpr != null) {
                    CommonWebLayout.this.bpr.fY(str);
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
                if (CommonWebLayout.this.bpr != null) {
                    CommonWebLayout.this.bpr.a(str2, jsResult);
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
        addView(this.bps, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i, String str2) {
        KT();
        if (this.bpr != null) {
            this.bpr.c(str, i, str2);
        }
    }

    private void KT() {
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
                    if (CommonWebLayout.this.bps != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.bps.getUrl())) {
                            CommonWebLayout.this.bps.loadUrl(CommonWebLayout.this.bps.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.bps.getOriginalUrl())) {
                            CommonWebLayout.this.bps.loadUrl(CommonWebLayout.this.bps.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.bpr != null) {
                            CommonWebLayout.this.bpr.Hn();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.bps == null) {
            return false;
        }
        return this.bps.canGoBack();
    }

    public void goBack() {
        if (this.bps != null) {
            this.bps.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.bps;
    }

    public SchemeCallback getSchemeCallback() {
        return this.bpv;
    }

    public void b(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.bpu != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.bpu != null) {
                    if (i2 == 0) {
                        this.bpu.onReceiveValue(null);
                        this.bpu = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.bpu.onReceiveValue(new Uri[]{data});
                        this.bpu = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> bpx;
        WeakReference<Activity> bpy;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.bpx = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.bpy = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            CommonWebLayout commonWebLayout = this.bpx.get();
            if (commonWebLayout != null) {
                commonWebLayout.mUploadMessage = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bpy.get();
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
            CommonWebLayout commonWebLayout = this.bpx.get();
            if (commonWebLayout != null) {
                commonWebLayout.bpu = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bpy.get();
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
