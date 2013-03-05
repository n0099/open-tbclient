package com.baidu.browser.webkit;

import com.baidu.browser.webkit.sys.BdSysDownloadListener;
import com.baidu.browser.webkit.zeus.BdZeusDownloadListener;
/* loaded from: classes.dex */
public class BdDownloadListener {
    private BdSysDownloadListener mSysDownloadListener;
    private BdZeusDownloadListener mZeusDownloadListener;

    public BdDownloadListener() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            this.mZeusDownloadListener = new BdZeusDownloadListener(this);
        } else {
            this.mSysDownloadListener = new BdSysDownloadListener(this);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdDownloadListener) && unwrap() == ((BdDownloadListener) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusDownloadListener != null ? this.mZeusDownloadListener.hashCode() : this.mSysDownloadListener.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusDownloadListener != null ? this.mZeusDownloadListener == obj : this.mSysDownloadListener == obj;
    }

    public Object unwrap() {
        return this.mZeusDownloadListener != null ? this.mZeusDownloadListener : this.mSysDownloadListener;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
    }

    public void onPlayVideo(String str) {
    }

    public void onDownLoadFlash(String str) {
    }
}
