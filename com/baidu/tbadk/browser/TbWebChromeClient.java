package com.baidu.tbadk.browser;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class TbWebChromeClient extends WebChromeClient {
    private TbWebViewActivity mActivity;

    public TbWebChromeClient(TbWebViewActivity tbWebViewActivity) {
        this.mActivity = tbWebViewActivity;
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
        return super.onJsAlert(webView, str, str2, jsResult);
    }
}
