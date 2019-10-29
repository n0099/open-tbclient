package com.baidu.live.adp.base;

import android.content.Intent;
import com.baidu.live.adp.framework.client.socket.link.ServiceOnCreateCallBack;
import com.baidu.megapp.ma.MAService;
/* loaded from: classes6.dex */
public abstract class BdBaseService extends MAService {
    private static ServiceOnCreateCallBack sCallBack;
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

    public static void setServiceOnCreateCallBack(ServiceOnCreateCallBack serviceOnCreateCallBack) {
        sCallBack = serviceOnCreateCallBack;
    }
}
