package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
/* loaded from: classes.dex */
public class BdSocketDaemonService extends BdBaseService {
    private b myBinder = new b(this);
    private ServiceConnection conn = new a(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.myBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public void bindServiceInternal() {
        com.baidu.adp.lib.g.j.a(this, new Intent(this, BdSocketLinkService.class), this.conn, 1);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(2147483646, new Notification());
        }
        bindServiceInternal();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unbindService(this.conn);
        Intent intent = new Intent();
        intent.setClass(this, BdSocketDaemonService.class);
        startService(intent);
    }

    public static void startService() {
        com.baidu.adp.lib.g.j.f(BdBaseApplication.getInst().getApp(), new Intent(BdBaseApplication.getInst().getApp(), BdSocketDaemonService.class));
    }
}
