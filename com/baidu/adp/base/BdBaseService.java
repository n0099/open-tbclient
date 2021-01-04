package com.baidu.adp.base;

import android.app.Service;
import android.content.Intent;
/* loaded from: classes.dex */
public abstract class BdBaseService extends Service {
    private static com.baidu.adp.framework.client.socket.link.e sCallBack;
    public static int serviceStartFlag = 1;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (sCallBack != null) {
            sCallBack.onServiceCreate();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return serviceStartFlag;
    }

    public static void setServiceOnCreateCallBack(com.baidu.adp.framework.client.socket.link.e eVar) {
        sCallBack = eVar;
    }
}
