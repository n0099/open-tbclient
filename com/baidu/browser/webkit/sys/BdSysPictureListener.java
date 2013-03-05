package com.baidu.browser.webkit.sys;

import android.graphics.Picture;
import android.webkit.WebView;
import com.baidu.browser.webkit.BdPictureListener;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdSysPictureListener implements WebView.PictureListener {
    private BdPictureListener mPictureListener;

    public BdSysPictureListener(BdPictureListener bdPictureListener) {
        this.mPictureListener = bdPictureListener;
    }

    public BdWebView obtainWebViewWrapper(WebView webView) {
        return (BdWebView) webView.getTag();
    }

    @Override // android.webkit.WebView.PictureListener
    public void onNewPicture(WebView webView, Picture picture) {
        this.mPictureListener.onNewPicture(obtainWebViewWrapper(webView), picture);
    }
}
