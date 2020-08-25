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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.tbadk.coreExtra.data.x;
/* loaded from: classes2.dex */
public class TbWebChromeClient extends WebChromeClient {
    private com.baidu.tieba.tbadkCore.e.c callback;
    private TbWebViewActivity mActivity;

    public TbWebChromeClient(TbWebViewActivity tbWebViewActivity) {
        this.mActivity = tbWebViewActivity;
    }

    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        this.callback = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(2 * j2);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.mActivity.getPageContext().getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.mActivity.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
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
        intent.setType("image/*");
        this.mActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mActivity == null || !g.a(this.mActivity.getPageContext())) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mActivity == null || !g.a(this.mActivity.getPageContext())) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mActivity == null || !g.a(this.mActivity.getPageContext())) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!x.AV(str) || this.callback == null || !this.callback.onJsPrompt(str2, jsPromptResult)) {
            jsPromptResult.cancel();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.mActivity != null) {
            this.mActivity.refreshTitle(str);
        }
        if (Build.VERSION.SDK_INT < 23 && !StringUtils.isNull(str)) {
            if ((str.contains("404") || str.contains("500") || str.contains(V8ExceptionInfo.V8_EXCEPTION_ERROR)) && this.mActivity != null) {
                this.mActivity.onReceivedTitle();
            }
        }
    }
}
