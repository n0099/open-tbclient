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
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CommonWebLayout extends FrameLayout {
    private b atJ;
    private CommonWebView atK;
    private List<String> atL;
    protected ValueCallback<Uri[]> atM;
    private SchemeCallback atN;
    protected ValueCallback<Uri> mUploadMessage;

    public CommonWebLayout(@NonNull Context context) {
        super(context);
        this.atN = new SchemeCallback() { // from class: com.baidu.live.view.web.CommonWebLayout.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        CommonWebLayout.this.atK.evaluateJavascript(assembJavaScript, null);
                    } else {
                        CommonWebLayout.this.atK.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(b bVar) {
        this.atJ = bVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.atK != null) {
            if (this.atL == null) {
                this.atL = new ArrayList();
            }
            this.atL.add(str);
            this.atK.addJavascriptInterface(obj, str);
        }
    }

    public void loadUrl(String str) {
        if (this.atK != null) {
            this.atK.loadUrl(str);
        }
    }

    public void reload() {
        if (this.atK != null) {
            this.atK.reload();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19 && this.atK != null) {
            this.atK.evaluateJavascript(str, valueCallback);
        }
    }

    public void onResume() {
        if (this.atK != null) {
            this.atK.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.atK.resumeTimers();
            }
        }
    }

    public void onPause() {
        if (this.atK != null) {
            this.atK.onPause();
        }
    }

    public void release() {
        this.atJ = null;
        removeAllViews();
        if (this.atK != null) {
            if (this.atL != null) {
                for (String str : this.atL) {
                    this.atK.removeJavascriptInterface(str);
                }
                this.atL.clear();
            }
            this.atK.stopLoading();
            this.atK.removeAllViews();
            this.atK.loadUrl("about:blank");
            this.atK.freeMemory();
            this.atK.destroy();
            this.mUploadMessage = null;
        }
    }

    private void init() {
        setBackgroundColor(0);
        this.atK = new CommonWebView(getContext());
        this.atK.setWebViewClient(new WebViewClient() { // from class: com.baidu.live.view.web.CommonWebLayout.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String trim = str.toLowerCase().trim();
                if (CommonWebLayout.this.atJ != null && CommonWebLayout.this.atJ.dd(trim)) {
                    return true;
                }
                if (SchemeUtils.checkScheme(trim)) {
                    return SchemeUtils.openScheme(trim, CommonWebLayout.this.atN);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                CommonWebLayout.this.wN();
                if (CommonWebLayout.this.atJ != null) {
                    CommonWebLayout.this.atJ.da(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CommonWebLayout.this.atJ != null) {
                    CommonWebLayout.this.atJ.db(str);
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
                if (CommonWebLayout.this.atJ == null || !CommonWebLayout.this.atJ.i(str, z)) {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        });
        this.atK.setWebChromeClient(new a(this, (Activity) getContext()) { // from class: com.baidu.live.view.web.CommonWebLayout.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (CommonWebLayout.this.atJ != null) {
                    CommonWebLayout.this.atJ.cr(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (CommonWebLayout.this.atJ != null) {
                    CommonWebLayout.this.atJ.dc(str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                return CommonWebLayout.this.atJ != null ? CommonWebLayout.this.atJ.a(str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
            }
        });
        addView(this.atK, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i, String str2) {
        wM();
        if (this.atJ != null) {
            this.atJ.b(str, i, str2);
        }
    }

    private void wM() {
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
                    if (CommonWebLayout.this.atK != null) {
                        if (!TextUtils.isEmpty(CommonWebLayout.this.atK.getUrl())) {
                            CommonWebLayout.this.atK.loadUrl(CommonWebLayout.this.atK.getUrl());
                        } else if (!TextUtils.isEmpty(CommonWebLayout.this.atK.getOriginalUrl())) {
                            CommonWebLayout.this.atK.loadUrl(CommonWebLayout.this.atK.getOriginalUrl());
                        }
                        if (CommonWebLayout.this.atJ != null) {
                            CommonWebLayout.this.atJ.wL();
                        }
                    }
                }
            });
            commonEmptyView.setBackgroundColor(Color.parseColor("#FF000000"));
            addView(commonEmptyView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof CommonEmptyView) {
                getChildAt(i).setVisibility(8);
                return;
            }
        }
    }

    public boolean canGoBack() {
        if (this.atK == null) {
            return false;
        }
        return this.atK.canGoBack();
    }

    public void goBack() {
        if (this.atK != null) {
            this.atK.goBack();
        }
    }

    public CommonWebView getWebView() {
        return this.atK;
    }

    public SchemeCallback getSchemeCallback() {
        return this.atN;
    }

    public void a(int i, int i2, Intent intent) {
        if (i == 25049) {
            if (this.mUploadMessage != null || this.atM != null) {
                if (this.mUploadMessage != null) {
                    if (i2 == 0) {
                        this.mUploadMessage.onReceiveValue(null);
                        this.mUploadMessage = null;
                        return;
                    }
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.atM != null) {
                    if (i2 == 0) {
                        this.atM.onReceiveValue(null);
                        this.atM = null;
                        return;
                    }
                    Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.atM.onReceiveValue(new Uri[]{data});
                        this.atM = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends WebChromeClient {
        WeakReference<CommonWebLayout> atP;
        WeakReference<Activity> atQ;

        public a(CommonWebLayout commonWebLayout, Context context) {
            this.atP = new WeakReference<>(commonWebLayout);
            if (context != null && (context instanceof Activity)) {
                this.atQ = new WeakReference<>((Activity) context);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            CommonWebLayout commonWebLayout = this.atP.get();
            if (commonWebLayout != null) {
                commonWebLayout.atM = valueCallback;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            Activity activity = this.atQ.get();
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
