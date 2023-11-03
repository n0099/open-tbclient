package com.baidu.android.pushservice.ach;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.pushservice.manageach.components.BaseAchService;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public abstract class DefaultAchService extends BaseAchService {
    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public int a(Intent intent, int i, int i2) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15918, this, intent, Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public IBinder a(Intent intent) {
        return (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15917, this, intent);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void a() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15920, this, null);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void b() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15919, this, null);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public boolean b(Intent intent) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15914, this, intent);
    }

    public abstract String c();
}
