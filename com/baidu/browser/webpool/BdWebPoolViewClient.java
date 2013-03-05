package com.baidu.browser.webpool;

import android.graphics.Bitmap;
import com.baidu.browser.webkit.BdHttpAuthHandler;
import com.baidu.browser.webkit.BdSslError;
import com.baidu.browser.webkit.BdSslErrorHandler;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdWebPoolViewClient {
    public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
        return false;
    }

    public void onPageStarted(BdWebPoolView bdWebPoolView, String str, Bitmap bitmap) {
    }

    public void onPageFinished(BdWebPoolView bdWebPoolView, String str) {
    }

    public void onLoadResource(BdWebPoolView bdWebPoolView, String str) {
    }

    public void onReceivedError(BdWebPoolView bdWebPoolView, int i, String str, String str2) {
    }

    public void onReceivedSslError(BdWebPoolView bdWebPoolView, BdSslErrorHandler bdSslErrorHandler, BdSslError bdSslError) {
    }

    public void onReceivedHttpAuthRequest(BdWebPoolView bdWebPoolView, BdHttpAuthHandler bdHttpAuthHandler, String str, String str2) {
    }

    public void onGoBack(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
    }

    public void onGoForward(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
    }

    public void onReload(BdWebPoolView bdWebPoolView) {
    }

    public void onWebViewChanged(BdWebPoolView bdWebPoolView, BdWebPoolCustomView bdWebPoolCustomView, BdWebPoolCustomView bdWebPoolCustomView2) {
    }

    public void onWebViewAttached(BdWebPoolCustomView bdWebPoolCustomView) {
    }

    public void onWebViewDestory(BdWebView bdWebView) {
    }

    public void onNewItem(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
    }

    public void onBaiduSearchPVCollected(BdWebPoolView bdWebPoolView) {
    }

    public void onFirstLayoutDid(BdWebPoolView bdWebPoolView, String str) {
    }

    public void onSubjectsCollected(BdWebPoolView bdWebPoolView, boolean z, int i) {
    }

    public boolean shouldShowSubject(BdWebPoolView bdWebPoolView, String str, String str2, String str3) {
        return false;
    }

    public void onMainActionsCollected(BdWebPoolView bdWebPoolView, boolean z, int i) {
    }

    public void onPageCanBeScaled(BdWebPoolView bdWebPoolView) {
    }

    public void onFullScreenMode(BdWebPoolView bdWebPoolView, boolean z, int i, int i2) {
    }

    public void onHasVideo(BdWebPoolView bdWebPoolView) {
    }
}
