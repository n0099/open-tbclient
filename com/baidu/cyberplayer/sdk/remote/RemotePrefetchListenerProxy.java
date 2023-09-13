package com.baidu.cyberplayer.sdk.remote;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.IPrefetchListener;
/* loaded from: classes3.dex */
public class RemotePrefetchListenerProxy extends IPrefetchListener.Stub {
    public CyberPlayerManager.OnPrefetchListener mPrefetchListener;

    public RemotePrefetchListenerProxy(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        this.mPrefetchListener = null;
        this.mPrefetchListener = onPrefetchListener;
    }

    public boolean updatePrefetchListener(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        if (onPrefetchListener == this.mPrefetchListener) {
            return false;
        }
        this.mPrefetchListener = onPrefetchListener;
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IPrefetchListener
    public void onPrefetchStatusChanged(String str, boolean z, int i, String str2) {
        CyberPlayerManager.OnPrefetchListener onPrefetchListener = this.mPrefetchListener;
        if (onPrefetchListener != null) {
            onPrefetchListener.onPrefetchStatusChanged(str, z, i, str2);
        }
    }
}
