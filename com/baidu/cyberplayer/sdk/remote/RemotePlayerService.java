package com.baidu.cyberplayer.sdk.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.cyberplayer.sdk.remote.g;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class RemotePlayerService extends Service {
    public long getKernelNetHandle() {
        return 0L;
    }

    public long getPCDNNetHandle() {
        return 0L;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            CyberPlayerManager.install(getApplicationContext(), intent.getStringExtra("clientID"), null, intent.getIntExtra("installType", 1), null, (Map) intent.getSerializableExtra("installOpts"), null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return new g.a(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (!n.n()) {
            Process.killProcess(Process.myPid());
        }
        return super.onUnbind(intent);
    }
}
