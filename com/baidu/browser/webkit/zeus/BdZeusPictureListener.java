package com.baidu.browser.webkit.zeus;

import android.graphics.Picture;
import com.baidu.browser.webkit.BdPictureListener;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.zeus.WebView;
/* loaded from: classes.dex */
public class BdZeusPictureListener implements WebView.PictureListener {
    private BdPictureListener mPictureListener;

    public BdZeusPictureListener(BdPictureListener bdPictureListener) {
        this.mPictureListener = bdPictureListener;
    }

    public BdWebView obtainWebViewWrapper(WebView webView) {
        return (BdWebView) webView.getTag();
    }

    @Override // com.baidu.zeus.WebView.PictureListener
    public void onNewPicture(WebView webView, Picture picture) {
        this.mPictureListener.onNewPicture(obtainWebViewWrapper(webView), picture);
    }
}
