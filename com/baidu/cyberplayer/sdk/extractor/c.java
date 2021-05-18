package com.baidu.cyberplayer.sdk.extractor;

import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.cyberplayer.sdk.remote.a;
import com.baidu.cyberplayer.sdk.remote.e;
/* loaded from: classes2.dex */
public class c extends a.AbstractBinderC0071a {

    /* renamed from: a  reason: collision with root package name */
    public CyberExtractor f4944a;

    /* renamed from: b  reason: collision with root package name */
    public RemotePlayerService f4945b;

    public c(RemotePlayerService remotePlayerService) {
        this.f4945b = remotePlayerService;
    }

    private CyberExtractor c() {
        if (this.f4944a == null) {
            synchronized (this) {
                if (this.f4944a == null) {
                    this.f4944a = new CyberExtractor(false);
                }
            }
        }
        return this.f4944a;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public Bundle a() throws RemoteException {
        return c().getMetaData();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(int i2, String str, long j) {
        c().setOption(i2, str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(e eVar) throws RemoteException {
        c().setDataSource(CyberPlayerManager.getApplicationContext(), eVar.a(), eVar.b());
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void b() throws RemoteException {
        CyberLog.i("RemoteExtractor", "release");
        synchronized (this) {
            if (this.f4944a != null) {
                this.f4944a.release();
                this.f4944a = null;
            }
        }
        this.f4945b = null;
    }
}
