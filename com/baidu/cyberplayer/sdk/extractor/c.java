package com.baidu.cyberplayer.sdk.extractor;

import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.cyberplayer.sdk.remote.a;
import com.baidu.cyberplayer.sdk.remote.e;
/* loaded from: classes12.dex */
public class c extends a.AbstractBinderC0111a {

    /* renamed from: a  reason: collision with root package name */
    private CyberExtractor f1382a;
    private RemotePlayerService b;

    public c(RemotePlayerService remotePlayerService) {
        this.b = remotePlayerService;
    }

    private CyberExtractor c() {
        if (this.f1382a == null) {
            synchronized (this) {
                if (this.f1382a == null) {
                    this.f1382a = new CyberExtractor(false);
                }
            }
        }
        return this.f1382a;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public Bundle a() throws RemoteException {
        return c().getMetaData();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(int i, String str, long j) {
        c().setOption(i, str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(e eVar) throws RemoteException {
        c().setDataSource(CyberPlayerManager.getApplicationContext(), eVar.a(), eVar.b());
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void b() throws RemoteException {
        CyberLog.i("RemoteExtractor", "release");
        synchronized (this) {
            if (this.f1382a != null) {
                this.f1382a.release();
                this.f1382a = null;
            }
        }
        this.b = null;
    }
}
