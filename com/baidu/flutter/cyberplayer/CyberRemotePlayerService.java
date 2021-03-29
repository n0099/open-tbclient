package com.baidu.flutter.cyberplayer;

import android.content.Intent;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerService;
/* loaded from: classes.dex */
public class CyberRemotePlayerService extends RemotePlayerService {
    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService
    public long getPCDNNetHandle() {
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            intent.getBooleanExtra("pcdn", false);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
