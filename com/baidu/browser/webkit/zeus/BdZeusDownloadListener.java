package com.baidu.browser.webkit.zeus;

import com.baidu.browser.webkit.BdDownloadListener;
import com.baidu.zeus.DownloadListener;
/* loaded from: classes.dex */
public class BdZeusDownloadListener implements DownloadListener {
    private BdDownloadListener mDownloadListener;

    public BdZeusDownloadListener(BdDownloadListener bdDownloadListener) {
        this.mDownloadListener = bdDownloadListener;
    }

    @Override // com.baidu.zeus.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.mDownloadListener.onDownloadStart(str, str2, str3, str4, j);
    }

    @Override // com.baidu.zeus.DownloadListener
    public void onPlayVideo(String str) {
        this.mDownloadListener.onPlayVideo(str);
    }

    @Override // com.baidu.zeus.DownloadListener
    public void onDownLoadFlash(String str) {
        this.mDownloadListener.onDownLoadFlash(str);
    }
}
