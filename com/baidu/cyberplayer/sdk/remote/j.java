package com.baidu.cyberplayer.sdk.remote;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.a;
/* loaded from: classes3.dex */
public class j extends a.AbstractBinderC0094a {
    public CyberPlayerManager.OnPrefetchListener a;

    public j(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        this.a = null;
        this.a = onPrefetchListener;
    }

    public boolean a(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        if (onPrefetchListener == this.a) {
            return false;
        }
        this.a = onPrefetchListener;
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(String str, boolean z, int i, String str2) {
        CyberPlayerManager.OnPrefetchListener onPrefetchListener = this.a;
        if (onPrefetchListener != null) {
            onPrefetchListener.onPrefetchStatusChanged(str, z, i, str2);
        }
    }
}
