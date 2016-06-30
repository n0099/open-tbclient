package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
/* loaded from: classes.dex */
public class BdSocketDaemonService extends BdBaseService {
    private static g sCallBack;
    private a myBinder = new a();
    private ServiceConnection conn = new com.baidu.adp.framework.client.socket.link.a(this);

    public static void setLinkServiceDisconnectCallBack(g gVar) {
        sCallBack = gVar;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.myBinder;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public void bindServiceInternal() {
        com.baidu.adp.lib.h.i.bindService(this, new Intent(this, BdSocketLinkService.class), this.conn, 1);
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(2147483646, new Notification());
            } catch (Exception e) {
                com.baidu.adp.lib.stats.d al = com.baidu.adp.lib.stats.a.dO().al("dbg");
                al.q("loc", String.valueOf(getClass().getName()) + "-onCreate-startForeground");
                com.baidu.adp.lib.stats.a.dO().b("PARCEL_NULLPOINT", al);
            }
        }
        bindServiceInternal();
    }

    /* loaded from: classes.dex */
    class a extends Binder {
        a() {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            unbindService(this.conn);
        } catch (Exception e) {
            com.baidu.adp.lib.stats.d al = com.baidu.adp.lib.stats.a.dO().al("dbg");
            al.q("loc", String.valueOf(getClass().getName()) + "-onDestroy-unbindService");
            com.baidu.adp.lib.stats.a.dO().b("PARCEL_NULLPOINT", al);
        }
        Intent intent = new Intent();
        intent.setClass(this, BdSocketDaemonService.class);
        try {
            startService(intent);
        } catch (Exception e2) {
            com.baidu.adp.lib.stats.d al2 = com.baidu.adp.lib.stats.a.dO().al("dbg");
            al2.q("loc", String.valueOf(getClass().getName()) + "-onDestroy-startService");
            com.baidu.adp.lib.stats.a.dO().b("PARCEL_NULLPOINT", al2);
        }
    }

    public static void startService() {
        com.baidu.adp.lib.h.i.c(BdBaseApplication.getInst().getApp(), new Intent(BdBaseApplication.getInst().getApp(), BdSocketDaemonService.class));
    }
}
