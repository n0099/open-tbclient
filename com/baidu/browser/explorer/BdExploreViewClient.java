package com.baidu.browser.explorer;

import android.graphics.Bitmap;
import com.baidu.browser.webpool.BdWebPoolCustomView;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.browser.webpool.BdWebPoolViewClient;
/* loaded from: classes.dex */
public class BdExploreViewClient extends BdWebPoolViewClient {
    private BdExploreView mExploreView;

    public BdExploreViewClient(BdExploreView bdExploreView) {
        this.mExploreView = bdExploreView;
    }

    @Override // com.baidu.browser.webpool.BdWebPoolViewClient
    public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
        return false;
    }

    @Override // com.baidu.browser.webpool.BdWebPoolViewClient
    public void onPageStarted(BdWebPoolView bdWebPoolView, String str, Bitmap bitmap) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolViewClient
    public void onPageFinished(BdWebPoolView bdWebPoolView, String str) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolViewClient
    public void onLoadResource(BdWebPoolView bdWebPoolView, String str) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolViewClient
    public void onReceivedError(BdWebPoolView bdWebPoolView, int i, String str, String str2) {
    }

    @Override // com.baidu.browser.webpool.BdWebPoolViewClient
    public void onWebViewAttached(BdWebPoolCustomView bdWebPoolCustomView) {
    }
}
