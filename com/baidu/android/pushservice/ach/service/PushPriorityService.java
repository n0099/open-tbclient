package com.baidu.android.pushservice.ach.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.baidu.android.pushservice.ach.e.d;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import com.baidu.android.pushservice.ach.service.PushPriorityService;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.manageach.components.BaseAchService;
import com.baidu.android.pushservice.t.a;
import com.baidu.android.pushservice.v.c;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class PushPriorityService extends BaseAchService implements PushScreenReceiver.a {
    public final Handler a = new Handler(Looper.getMainLooper());
    public Runnable b;

    /* loaded from: classes.dex */
    public static final class PushPriorityInnerService extends BaseAchService {
        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public int a(Intent intent, int i, int i2) {
            return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-16063, this, intent, Integer.valueOf(i), Integer.valueOf(i2));
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public IBinder a(Intent intent) {
            return (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-16058, this, intent);
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public void a() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-16057, this, null);
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public void b() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-16060, this, null);
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public boolean b(Intent intent) {
            return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-16059, this, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        try {
            Intent j = e.j(getApplicationContext());
            j.putExtra("push_start_source", 4);
            getApplicationContext().sendBroadcast(j);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public int a(Intent intent, int i, int i2) {
        d.a(getApplicationContext()).a(this, intent, 10340, false);
        a(getApplicationContext());
        e();
        return 1;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public IBinder a(Intent intent) {
        return null;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void a() {
        a.a(getApplicationContext()).a(4);
        c.a().a(getApplicationContext(), this);
        d();
    }

    public final void a(Context context) {
        try {
            startService(new Intent(context, PushPriorityInnerService.class));
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.android.pushservice.ach.receiver.PushScreenReceiver.a
    public void a(boolean z) {
        if (z) {
            d();
            stopSelf();
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void b() {
        Runnable runnable = this.b;
        if (runnable != null) {
            this.a.removeCallbacks(runnable);
        }
        try {
            stopForeground(true);
        } catch (Exception unused) {
        }
        c.a().a(getApplicationContext(), (PushScreenReceiver.a) null);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public boolean b(Intent intent) {
        return false;
    }

    public final void d() {
        Notification c;
        if (Build.VERSION.SDK_INT < 26 || (c = com.baidu.android.pushservice.ach.e.a.c(getApplicationContext())) == null) {
            return;
        }
        try {
            startForeground(10340, c);
            stopForeground(true);
        } catch (Exception unused) {
        }
    }

    public final void e() {
        Runnable runnable = this.b;
        if (runnable == null) {
            this.b = new Runnable() { // from class: com.baidu.tieba.ak
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        PushPriorityService.this.c();
                    }
                }
            };
        } else {
            this.a.removeCallbacks(runnable);
        }
        this.a.postDelayed(this.b, 30000L);
    }
}
