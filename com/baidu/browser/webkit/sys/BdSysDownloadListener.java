package com.baidu.browser.webkit.sys;

import android.webkit.DownloadListener;
import com.baidu.browser.webkit.BdDownloadListener;
/* loaded from: classes.dex */
public class BdSysDownloadListener implements DownloadListener {
    private BdDownloadListener mDownloadListener;

    public BdSysDownloadListener(BdDownloadListener bdDownloadListener) {
        this.mDownloadListener = bdDownloadListener;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.mDownloadListener.onDownloadStart(str, str2, str3, str4, j);
    }
}
