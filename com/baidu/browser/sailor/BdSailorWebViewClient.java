package com.baidu.browser.sailor;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
/* loaded from: classes2.dex */
public class BdSailorWebViewClient implements INoProGuard {
    public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
    }

    public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onPageCommitVisible(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
    }

    public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
        clientCertRequest.cancel();
    }

    public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
    }

    public void onReceivedError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
    }

    public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.cancel();
    }

    public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
    }

    public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
    }

    public boolean onRenderProcessGone(BdSailorWebView bdSailorWebView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return false;
    }

    public void onScaleChanged(BdSailorWebView bdSailorWebView, float f2, float f3) {
    }

    public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
    }

    public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
        return null;
    }

    public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
        return false;
    }
}
