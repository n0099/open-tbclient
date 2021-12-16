package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
/* loaded from: classes9.dex */
public interface ISailorDownloadListener extends INoProGuard {
    void onDownloadFlash(String str);

    void onDownloadStart(String str, String str2, String str3, String str4, long j2);

    void onPlayVideo(String str);
}
