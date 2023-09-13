package com.baidu.cyberplayer.sdk.remote;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.remote.IRemoteDownloader;
import com.baidu.cyberplayer.sdk.videodownload.CyberDownloader;
/* loaded from: classes3.dex */
public class RemoteDownloader extends IRemoteDownloader.Stub implements CyberDownloader.DownloaderListener {
    public static final String TAG = "RemoteDownloader";
    public CyberDownloader mDownloader;
    public RemoteCallbackList<IRemoteDownloaderListener> mListenerList = new RemoteCallbackList<>();
    public RemotePlayerService mRemoteService;

    public RemoteDownloader(int i, String str, PrefetchOptions prefetchOptions, RemotePlayerService remotePlayerService) {
        this.mRemoteService = remotePlayerService;
        CyberDownloader cyberDownloader = new CyberDownloader(i, str, prefetchOptions, false);
        this.mDownloader = cyberDownloader;
        cyberDownloader.setListener(this);
        CyberLog.i(TAG, "RemoteDownloader mDownloader = " + this.mDownloader);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void addListener(IRemoteDownloaderListener iRemoteDownloaderListener) {
        this.mListenerList.register(iRemoteDownloaderListener);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void addTask(CyberDownloadItem cyberDownloadItem) throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.addTask(cyberDownloadItem);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void cancelTask(String str) throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.cancelTask(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void clearCacheFile(String str) throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.clearCacheFile(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public Bundle getDownloadInfo(String str) throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            return cyberDownloader.getDownloadInfo(str);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void pauseTask(String str) throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.pauseTask(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void removeListener(IRemoteDownloaderListener iRemoteDownloaderListener) {
        this.mListenerList.unregister(iRemoteDownloaderListener);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void resumeTask(String str) throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.resumeTask(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void cancelAllTasks() throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.cancelAllTasks();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void clearAllCaches() throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.clearAllCaches();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public long getAllCacheSize() throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            return cyberDownloader.getAllCacheSize();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void pauseAllTasks() throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.pauseAllTasks();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void release() throws RemoteException {
        synchronized (this) {
            if (this.mDownloader != null) {
                this.mDownloader.release();
                this.mDownloader = null;
            }
        }
        synchronized (this.mListenerList) {
            this.mListenerList.kill();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloader
    public void resumeAllTasks() throws RemoteException {
        CyberDownloader cyberDownloader = this.mDownloader;
        if (cyberDownloader != null) {
            cyberDownloader.resumeAllTasks();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.CyberDownloader.DownloaderListener
    public boolean onTransfer(String str, int i, int i2, Object obj) {
        synchronized (this.mListenerList) {
            CyberLog.i(TAG, "onTransfer key = " + str + ", what = " + i + ", extra = " + i2);
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                IRemoteDownloaderListener broadcastItem = this.mListenerList.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onCallback(str, i, i2, (Bundle) obj);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
        return true;
    }
}
