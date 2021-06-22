package com.baidu.tbadk.browser;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import d.a.c.e.m.g;
import d.a.c.e.p.k;
import d.a.n0.s.c.z;
import d.a.o0.e3.l0.c;
/* loaded from: classes3.dex */
public class TbWebChromeClient extends WebChromeClient {
    public c callback;
    public TbWebViewActivity mActivity;

    public TbWebChromeClient(TbWebViewActivity tbWebViewActivity) {
        this.mActivity = tbWebViewActivity;
    }

    private void callJsMethod(WebView webView, String str, String str2) {
        if (webView == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "('" + str2 + "')");
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.mActivity.getPageContext().getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(j2 * 2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        TbWebViewActivity tbWebViewActivity = this.mActivity;
        if (tbWebViewActivity == null || !g.f(tbWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        TbWebViewActivity tbWebViewActivity = this.mActivity;
        if (tbWebViewActivity == null || !g.f(tbWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        TbWebViewActivity tbWebViewActivity = this.mActivity;
        if (tbWebViewActivity == null || !g.f(tbWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        c cVar;
        if (!z.a(str) && str2.startsWith("tiebaapp")) {
            d.a.o0.e3.l0.d.c cVar2 = new d.a.o0.e3.l0.d.c();
            cVar2.s(d.a.o0.e3.l0.d.g.b(str2));
            cVar2.t(301);
            callJsMethod(webView, cVar2.c(), cVar2.d());
        }
        if (z.a(str) && (cVar = this.callback) != null && cVar.onJsPrompt(str2, jsPromptResult)) {
            return true;
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        TbWebViewActivity tbWebViewActivity;
        super.onProgressChanged(webView, i2);
        if (i2 < 80 || (tbWebViewActivity = this.mActivity) == null) {
            return;
        }
        tbWebViewActivity.hideProgressBar();
        this.mActivity.stopLoadTimer();
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        TbWebViewActivity tbWebViewActivity;
        super.onReceivedTitle(webView, str);
        TbWebViewActivity tbWebViewActivity2 = this.mActivity;
        if (tbWebViewActivity2 != null) {
            tbWebViewActivity2.refreshTitle(str);
        }
        if (Build.VERSION.SDK_INT >= 23 || StringUtils.isNull(str)) {
            return;
        }
        if ((str.contains(XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH) || str.contains("500") || str.contains(V8ExceptionInfo.V8_EXCEPTION_ERROR)) && (tbWebViewActivity = this.mActivity) != null) {
            tbWebViewActivity.onReceivedTitle();
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.mActivity.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }

    public void setOnJsPromptCallback(c cVar) {
        this.callback = cVar;
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        this.mActivity.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mActivity.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }
}
