package com.baidu.cyberplayer.sdk.extractor;

import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.cyberplayer.sdk.remote.b;
import com.baidu.cyberplayer.sdk.remote.f;
/* loaded from: classes3.dex */
public class c extends b.a {
    public CyberExtractor a;
    public RemotePlayerService b;

    public c(RemotePlayerService remotePlayerService) {
        this.b = remotePlayerService;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(f fVar) throws RemoteException {
        c().setDataSource(CyberPlayerManager.getApplicationContext(), fVar.a(), fVar.b());
    }

    private CyberExtractor c() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new CyberExtractor(false);
                }
            }
        }
        return this.a;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public Bundle a() throws RemoteException {
        return c().getMetaData();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b() throws RemoteException {
        CyberLog.i("RemoteExtractor", "release");
        synchronized (this) {
            if (this.a != null) {
                this.a.release();
                this.a = null;
            }
        }
        this.b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i, String str, long j) {
        c().setOption(i, str, j);
    }
}
