package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.core.ApkInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class MyService extends Service {
    private volatile int a = 0;

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.sofire.MyService$1] */
    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.a++;
        new Thread() { // from class: com.baidu.sofire.MyService.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                    String stringExtra = intent.getStringExtra("from_plugin_package");
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.a(MyService.this);
                    } else if (MyService.this.getPackageName().equals(stringExtra)) {
                        MyService.a(MyService.this, MyService.this.getClassLoader(), intent);
                        MyService.a(MyService.this);
                    } else {
                        com.baidu.sofire.core.e no = com.baidu.sofire.core.e.no();
                        if (no == null) {
                            MyService.a(MyService.this);
                        } else {
                            ApkInfo bY = no.bY(stringExtra);
                            new StringBuilder("i=").append(bY);
                            if (bY == null) {
                                MyService.a(MyService.this);
                            } else {
                                MyService.a(MyService.this, bY.classLoader, intent);
                                MyService.a(MyService.this);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.b.d.a(th2);
                    MyService.a(MyService.this);
                }
            }
        }.start();
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
                myService.stopSelf();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    static /* synthetic */ void a(MyService myService, ClassLoader classLoader, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("target_class");
            Class<?> loadClass = classLoader.loadClass(stringExtra);
            Object newInstance = loadClass.newInstance();
            new StringBuilder().append(stringExtra).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(newInstance);
            String stringExtra2 = intent.getStringExtra("target_method");
            new StringBuilder().append(stringExtra2);
            loadClass.getDeclaredMethod(stringExtra2, Context.class, Intent.class).invoke(newInstance, myService.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
