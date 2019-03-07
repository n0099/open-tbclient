package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.b.r;
import com.baidu.sofire.core.ApkInfo;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class MyService extends Service {
    private volatile int a = 0;

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.a++;
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        new StringBuilder("PPP(service) try do action ").append(intent.getAction()).append(" ").append(stringExtra);
        b.a();
        r.a().a(new Runnable() { // from class: com.baidu.sofire.MyService.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    new StringBuilder("PPP(service) do action ").append(intent.getAction()).append(" ").append(stringExtra);
                    b.a();
                    if (NotifyType.SOUND.equals(intent.getStringExtra(Info.kBaiduTimeKey))) {
                        String stringExtra2 = intent.getStringExtra("c");
                        Intent intent2 = new Intent();
                        intent2.putExtra(Info.kBaiduTimeKey, NotifyType.SOUND);
                        intent2.putExtra("c", stringExtra2);
                        a.a(MyService.this.getApplicationContext(), intent2);
                    }
                    new StringBuilder("p:=").append(stringExtra);
                    b.a();
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.a(MyService.this);
                    } else if (MyService.this.getPackageName().equals(stringExtra)) {
                        MyService.a(MyService.this, MyService.this.getClassLoader(), intent);
                        MyService.a(MyService.this);
                    } else {
                        com.baidu.sofire.core.g a = com.baidu.sofire.core.g.a();
                        if (a == null) {
                            MyService.a(MyService.this);
                            return;
                        }
                        ApkInfo d = a.d(stringExtra);
                        new StringBuilder("i=").append(d);
                        b.a();
                        if (d == null) {
                            MyService.a(MyService.this);
                            return;
                        }
                        MyService.a(MyService.this, d.classLoader, intent);
                        new StringBuilder("PPP(service) after action ").append(((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f).append(intent.toString()).append(" ").append(stringExtra);
                        b.a();
                        MyService.a(MyService.this);
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.b.e.a();
                    MyService.a(MyService.this);
                }
            }
        });
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    static /* synthetic */ void a(MyService myService) {
        try {
            myService.a--;
            if (myService.a <= 0) {
                myService.a = 0;
                b.a();
                myService.stopSelf();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }

    static /* synthetic */ void a(MyService myService, ClassLoader classLoader, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("target_class");
            Class<?> loadClass = classLoader.loadClass(stringExtra);
            Object newInstance = loadClass.newInstance();
            new StringBuilder("targetClass=").append(stringExtra).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(newInstance);
            b.a();
            String stringExtra2 = intent.getStringExtra("target_method");
            b.a();
            loadClass.getDeclaredMethod(stringExtra2, Context.class, Intent.class).invoke(newInstance, myService.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.c();
        }
    }
}
