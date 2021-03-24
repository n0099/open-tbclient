package com.baidu.adp.base;

import android.app.Service;
import android.content.Intent;
import d.b.b.c.e.c.k.e;
/* loaded from: classes.dex */
public abstract class BdBaseService extends Service {
    public static e sCallBack = null;
    public static int serviceStartFlag = 1;

    public static void setServiceOnCreateCallBack(e eVar) {
        sCallBack = eVar;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        e eVar = sCallBack;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return serviceStartFlag;
    }
}
