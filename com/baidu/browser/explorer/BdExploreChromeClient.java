package com.baidu.browser.explorer;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.baidu.browser.webkit.BdWebChromeClient;
import com.baidu.browser.webkit.BdWebStorage;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webpool.BdWebPoolChromeClient;
import com.baidu.browser.webpool.BdWebPoolView;
/* loaded from: classes.dex */
public class BdExploreChromeClient extends BdWebPoolChromeClient {
    private BdExploreView mExpView;

    public BdExploreChromeClient(BdExploreView bdExploreView) {
        this.mExpView = bdExploreView;
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onProgressChanged(BdWebPoolView bdWebPoolView, int i) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onReceivedTitle(BdWebPoolView bdWebPoolView, String str) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onReceivedIcon(BdWebPoolView bdWebPoolView, Bitmap bitmap) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onReceivedTouchIconUrl(BdWebPoolView bdWebPoolView, String str, boolean z) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onShowCustomView(View view, BdWebChromeClient.BdCustomViewCallback bdCustomViewCallback) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onHideCustomView() {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public boolean onCreateWindow(BdWebPoolView bdWebPoolView, boolean z, boolean z2, Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
        return false;
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onRequestFocus(BdWebPoolView bdWebPoolView) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onCloseWindow(BdWebPoolView bdWebPoolView) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
        this.mExpView.getWebStorageSizeManagerInstance().onExceededDatabaseQuota(str, str2, j, j2, j3, bdQuotaUpdater);
    }
}
