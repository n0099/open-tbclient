package com.baidu.cyberplayer.sdk.extractor;

import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.IRemoteExtractor;
import com.baidu.cyberplayer.sdk.remote.RemoteDataSource;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
/* loaded from: classes3.dex */
public class RemoteExtractor extends IRemoteExtractor.Stub {
    public static final String TAG = "RemoteExtractor";
    public CyberExtractor mExtractor;
    public RemotePlayerService mRemoteService;

    public RemoteExtractor(RemotePlayerService remotePlayerService) {
        this.mRemoteService = remotePlayerService;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
    public void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException {
        getExtractor().setDataSource(CyberPlayerManager.getApplicationContext(), remoteDataSource.getUri(), remoteDataSource.getHeaders());
    }

    private CyberExtractor getExtractor() {
        if (this.mExtractor == null) {
            synchronized (this) {
                if (this.mExtractor == null) {
                    this.mExtractor = new CyberExtractor(false);
                }
            }
        }
        return this.mExtractor;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
    public Bundle getMediaMeta() throws RemoteException {
        return getExtractor().getMetaData();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
    public void release() throws RemoteException {
        CyberLog.i(TAG, "release");
        synchronized (this) {
            if (this.mExtractor != null) {
                this.mExtractor.release();
                this.mExtractor = null;
            }
        }
        this.mRemoteService = null;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemoteExtractor
    public void setOption(int i, String str, long j) {
        getExtractor().setOption(i, str, j);
    }
}
