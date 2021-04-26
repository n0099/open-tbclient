package com.baidu.adp.base;

import android.app.Service;
import android.content.Intent;
import d.a.c.c.e.c.k.e;
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
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        return serviceStartFlag;
    }
}
