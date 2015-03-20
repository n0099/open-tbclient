package com.baidu.adp.base;

import android.content.Intent;
import com.baidu.megapp.ma.MAService;
/* loaded from: classes.dex */
public abstract class BdBaseService extends MAService {
    private static com.baidu.adp.framework.client.socket.link.l sCallBack;
    public static int serviceStartFlag = 1;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (sCallBack != null) {
            sCallBack.eN();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return serviceStartFlag;
    }

    public static void setServiceOnCreateCallBack(com.baidu.adp.framework.client.socket.link.l lVar) {
        sCallBack = lVar;
    }
}
