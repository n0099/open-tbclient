package com.baidu.nadcore.player.remote;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.tieba.zw0;
/* loaded from: classes3.dex */
public class BDRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getKernelNetHandle() {
        return zw0.c.a().getNetHandle();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        return zw0.c.a().getNetHandle();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public IBinder onBind(Intent intent) {
        zw0.c.a().a(this);
        return super.onBind(intent);
    }
}
