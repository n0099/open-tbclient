package com.baidu.cyberplayer.sdk.videodownload;

import android.os.Bundle;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.remote.CyberDownloadItem;
import com.baidu.cyberplayer.sdk.videodownload.CyberDownloader;
@Keep
/* loaded from: classes3.dex */
public abstract class DownloaderProvider {
    public abstract void addTask(CyberDownloadItem cyberDownloadItem);

    public abstract void cancelAllTasks();

    public abstract void cancelTask(String str);

    public abstract void clearAllCaches();

    public abstract void clearCacheFile(String str);

    public abstract long getAllCacheSize();

    public abstract Bundle getDownloadInfo(String str);

    public abstract void pauseAllTasks();

    public abstract void pauseTask(String str);

    public abstract void release();

    public abstract void resumeAllTasks();

    public abstract void resumeTask(String str);

    public abstract void setListener(CyberDownloader.DownloaderListener downloaderListener);
}
