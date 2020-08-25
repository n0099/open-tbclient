package com.baidu.searchbox.player.remote;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
import com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper;
/* loaded from: classes19.dex */
public class BDRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public IBinder onBind(Intent intent) {
        BDPlayerServiceProxyWrapper.Impl.get().onServiceBind(this);
        return super.onBind(intent);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        return BDPlayerServiceProxyWrapper.Impl.get().getNetHandle();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getKernelNetHandle() {
        return BDPlayerServiceProxyWrapper.Impl.get().getNetHandle();
    }
}
