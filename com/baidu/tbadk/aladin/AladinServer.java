package com.baidu.tbadk.aladin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AladinServerConfig;
/* loaded from: classes.dex */
public class AladinServer extends BdBaseService {
    private a mTcpListener = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AladinServerConfig.class, AladinServer.class);
    }

    public static void start(Context context) {
        j.f(context, new Intent(context, AladinServer.class));
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        reStartListener();
        return super.onStartCommand(intent, i, i2);
    }

    public void reStartListener() {
        if (this.mTcpListener == null || !this.mTcpListener.kN()) {
            if (this.mTcpListener != null) {
                this.mTcpListener.quit();
            }
            this.mTcpListener = new a(this);
            this.mTcpListener.start();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mTcpListener != null) {
            this.mTcpListener.quit();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
