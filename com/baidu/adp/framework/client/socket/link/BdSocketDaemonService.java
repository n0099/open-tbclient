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
import com.baidu.adp.lib.g.f;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class BdSocketDaemonService extends BdBaseService {
    private static c sCallBack;
    private a myBinder = new a();
    private ServiceConnection conn = new ServiceConnection() { // from class: com.baidu.adp.framework.client.socket.link.BdSocketDaemonService.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (BdSocketDaemonService.sCallBack != null) {
                BdSocketDaemonService.sCallBack.onLinkServiceDisconnect();
            } else {
                BdSocketLinkService.startService(false, "restart");
            }
        }
    };

    public static void setLinkServiceDisconnectCallBack(c cVar) {
        sCallBack = cVar;
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
        f.bindService(this, new Intent(this, BdSocketLinkService.class), this.conn, 1);
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(2147483646, new Notification());
            } catch (Exception e) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("loc", getClass().getName() + "-onCreate-startForeground");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
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
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("loc", getClass().getName() + "-onDestroy-unbindService");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
        }
        Intent intent = new Intent();
        intent.setClass(this, BdSocketDaemonService.class);
        try {
            startService(intent);
        } catch (Exception e2) {
            com.baidu.adp.lib.stats.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.append("loc", getClass().getName() + "-onDestroy-startService");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem2);
        }
    }

    public static void startService() {
        f.startService(BdBaseApplication.getInst().getApp(), new Intent(BdBaseApplication.getInst().getApp(), BdSocketDaemonService.class));
    }
}
