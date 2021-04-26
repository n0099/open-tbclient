package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import d.a.c.c.e.c.k.c;
import d.a.c.e.m.f;
/* loaded from: classes.dex */
public class BdSocketDaemonService extends BdBaseService {
    public static c sCallBack;
    public b myBinder = new b();
    public ServiceConnection conn = new a();

    /* loaded from: classes.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (BdSocketDaemonService.sCallBack != null) {
                BdSocketDaemonService.sCallBack.a();
            } else {
                BdSocketLinkService.startService(false, "restart");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Binder {
        public b() {
        }
    }

    public static void setLinkServiceDisconnectCallBack(c cVar) {
        sCallBack = cVar;
    }

    public static void startService() {
        f.c(BdBaseApplication.getInst().getApp(), new Intent(BdBaseApplication.getInst().getApp(), BdSocketDaemonService.class));
    }

    public void bindServiceInternal() {
        f.a(this, new Intent(this, BdSocketLinkService.class), this.conn, 1);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.myBinder;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(2147483646, new Notification());
            } catch (Exception unused) {
                d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", BdSocketDaemonService.class.getName() + "-onCreate-startForeground");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
        }
        bindServiceInternal();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            unbindService(this.conn);
        } catch (Exception unused) {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("loc", BdSocketDaemonService.class.getName() + "-onDestroy-unbindService");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
        }
        Intent intent = new Intent();
        intent.setClass(this, BdSocketDaemonService.class);
        try {
            startService(intent);
        } catch (Exception unused2) {
            d.a.c.e.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.b("loc", BdSocketDaemonService.class.getName() + "-onDestroy-startService");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }
}
