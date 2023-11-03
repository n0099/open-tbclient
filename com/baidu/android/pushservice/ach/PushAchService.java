package com.baidu.android.pushservice.ach;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.pushservice.ach.c.b;
import com.baidu.android.pushservice.manageach.components.BaseAchService;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public class PushAchService extends BaseAchService {
    public final String a = PushAchService.class.getName();

    /* loaded from: classes.dex */
    public class a implements b.d {
        public a() {
        }

        @Override // com.baidu.android.pushservice.ach.c.b.d
        public void a(int i) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15908, this, Integer.valueOf(i));
        }

        @Override // com.baidu.android.pushservice.ach.c.b.d
        public void a(boolean z, int i) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15907, this, Boolean.valueOf(z), Integer.valueOf(i));
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public int a(Intent intent, int i, int i2) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15934, this, intent, Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public IBinder a(Intent intent) {
        return (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15933, this, intent);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void a() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15936, this, null);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void b() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15935, this, null);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public boolean b(Intent intent) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15930, this, intent);
    }

    public final void c(Intent intent) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15929, this, intent);
    }
}
