package com.baidu.cyberplayer.sdk.videodownload;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public interface IDuMediaDownload {
    void addTask(DuMediaDownloadItem duMediaDownloadItem);

    void cancelTask(String str);

    void clearCacheFile(String str);

    long getAllCacheSize();

    void pauseTask(String str);

    void resumeTask(String str);
}
