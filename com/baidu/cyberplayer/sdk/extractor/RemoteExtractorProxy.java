package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.remote.IRemoteExtractor;
import com.baidu.cyberplayer.sdk.remote.RemoteDataSource;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import java.io.FileDescriptor;
import java.util.Map;
/* loaded from: classes3.dex */
public class RemoteExtractorProxy extends ExtractorProvider {
    public static final String TAG = "RemoteExtractorProxy";
    public IRemoteExtractor mRemoteExtractor;

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    public RemoteExtractorProxy(IRemoteExtractor iRemoteExtractor) {
        this.mRemoteExtractor = iRemoteExtractor;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        setDataSource(Uri.parse(str), (Map<String, String>) null);
    }

    public static ExtractorProvider createExtractor() {
        IRemoteExtractor asInterface = IRemoteExtractor.Stub.asInterface(RemotePlayerFactory.getInstance().createExtractor());
        if (asInterface != null) {
            return new RemoteExtractorProxy(asInterface);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        IRemoteExtractor iRemoteExtractor = this.mRemoteExtractor;
        if (iRemoteExtractor == null) {
            return null;
        }
        try {
            return iRemoteExtractor.getMediaMeta();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        CyberLog.i(TAG, "release");
        IRemoteExtractor iRemoteExtractor = this.mRemoteExtractor;
        if (iRemoteExtractor == null) {
            return;
        }
        try {
            try {
                iRemoteExtractor.release();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } finally {
            this.mRemoteExtractor = null;
        }
    }

    private void setDataSource(Uri uri, Map<String, String> map) {
        IRemoteExtractor iRemoteExtractor = this.mRemoteExtractor;
        if (iRemoteExtractor == null) {
            return;
        }
        try {
            iRemoteExtractor.setDataSource(new RemoteDataSource(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        setDataSource(uri, (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        setDataSource(uri, map);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setOption(int i, String str, long j) {
        IRemoteExtractor iRemoteExtractor = this.mRemoteExtractor;
        if (iRemoteExtractor == null) {
            return;
        }
        try {
            iRemoteExtractor.setOption(i, str, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
