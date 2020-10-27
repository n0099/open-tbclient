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
    private b bHY;
    private CommonWebView bHZ;
    private List<String> bIa;
    protected ValueCallback<Uri[]> bIb;
    private SchemeCallback bIc;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.bIc = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.bHZ.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.bHZ.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.bHY = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bHZ != null) {
            if (this.bIa == null) {
                this.bIa = new ArrayList();
            }
            this.bIa.add(str);
            this.bHZ.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.bHZ != null) {
            this.bHZ.loadUrl(str);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.bHZ != null) {
            this.bHZ.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.bHZ != null) {
            this.bHZ.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bHZ.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.bHZ != null) {
            this.bHZ.onPause();
        }
    }

    public void release() {
        this.bHY = null;
        removeAllViews();
        if (this.bHZ != null) {
            if (this.bIa != null) {
                for (String str : this.bIa) {
                    this.bHZ.removeJavascriptInterface(str);
                }
                this.bIa.clear();
            }
            try {
                this.bHZ.stopLoading();
                this.bHZ.removeAllViews();
                this.bHZ.loadUrl("about:blank");
                this.bHZ.freeMemory();
                this.bHZ.destroy();
            } catch (Exception e) {
            }
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.bHZ = new CommonWebView(getContext());
        this.bHZ.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.bHY != null && CommonWebLayout.this.bHY.iD(trim)) {
                    return true;
                }
                if (!SchemeUtils.checkScheme(trim) && !SchemeUtils.checkCommonScheme(trim)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return SchemeUtils.openScheme(trim, CommonWebLayout.this.bIc);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.Uw();
                if (CommonWebLayout.this.bHY != null) {
                    CommonWebLayout.this.bHY.hN(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.bHY != null) {
                    CommonWebLayout.this.bHY.hO(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    CommonWebLayout.this.f(str2, i, str);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    CommonWebLayout.this.f(webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "", webResourceError != null ? webResourceError.getErrorCode() : -1, (webResourceError == null || webResourceError.getDescription() == null) ? "unknown" : webResourceError.getDescription().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                if (CommonWebLayout.this.bHY == null || !CommonWebLayout.this.bHY.E(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.bHZ.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.bHY != null) {
                    CommonWebLayout.this.bHY.fa(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.bHY != null) {
                    CommonWebLayout.this.bHY.iC(str);
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
                if (CommonWebLayout.this.bHY != null) {
                    CommonWebLayout.this.bHY.a(str2, jsResult);
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
        addView(this.bHZ, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        Uv();
        if (this.bHY != null) {
            this.bHY.e(str, i, str2);
        }
    }

    private void Uv() {
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
                    if (CommonWebLayout.this.bHZ != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.bHZ.getUrl())) {
                            CommonWebLayout.this.bHZ.loadUrl(CommonWebLayout.this.bHZ.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.bHZ.getOriginalUrl())) {
                            CommonWebLayout.this.bHZ.loadUrl(CommonWebLayout.this.bHZ.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.bHY != null) {
                            CommonWebLayout.this.bHY.Uu();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.bHZ == null) {
            return false;
        }
        return this.bHZ.canGoBack();
    }

    public void goBack() {
        if (this.bHZ != null) {
            this.bHZ.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.bHZ;
    }

    public SchemeCallback getSchemeCallback() {
        return this.bIc;
    }

    public void b(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.bIb != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.bIb != null) {
                    if (i2 == 0) {
                        this.bIb.onReceiveValue(null);
                        this.bIb = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.bIb.onReceiveValue(new Uri[]{data});
                        this.bIb = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> bIe;
        WeakReference<Activity> bIf;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.bIe = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.bIf = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            CommonWebLayout commonWebLayout = this.bIe.get();
            if (commonWebLayout != null) {
                commonWebLayout.mUploadMessage = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bIf.get();
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
            CommonWebLayout commonWebLayout = this.bIe.get();
            if (commonWebLayout != null) {
                commonWebLayout.bIb = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.bIf.get();
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
