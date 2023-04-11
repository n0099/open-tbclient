package com.baidu.nadcore.player.remote;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.tieba.lz0;
/* loaded from: classes2.dex */
public class BDRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getKernelNetHandle() {
        return lz0.c.a().getNetHandle();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        return lz0.c.a().getNetHandle();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public IBinder onBind(Intent intent) {
        lz0.c.a().onServiceBind(this);
        return super.onBind(intent);
    }
}
