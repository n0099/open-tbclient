package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
/* loaded from: classes2.dex */
public interface ISailorDownloadListener extends INoProGuard {
    void onDownloadFlash(String str);

    void onDownloadStart(String str, String str2, String str3, String str4, long j);

    void onPlayVideo(String str);
}
