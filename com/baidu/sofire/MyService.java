package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.b.r;
import com.baidu.sofire.core.ApkInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
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
        Bundle bundleExtra = intent.getBundleExtra("bundle");
        if (bundleExtra != null) {
            b.a();
            String[] stringArray = bundleExtra.getStringArray("appkey");
            int[] intArray = bundleExtra.getIntArray("key");
            int i3 = bundleExtra.getInt("delay");
            if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                com.baidu.sofire.core.e.a(getApplicationContext(), i3, stringArray[0], stringArray[1], intArray);
            }
            return super.onStartCommand(intent, i, i2);
        }
        this.a++;
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        new StringBuilder().append(intent.getAction()).append(" ").append(stringExtra);
        b.a();
        r.a().a(new Runnable() { // from class: com.baidu.sofire.MyService.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.a(MyService.this);
                    } else if (MyService.this.getPackageName().equals(stringExtra)) {
                        MyService.a(MyService.this, MyService.this.getClassLoader(), intent);
                        MyService.a(MyService.this);
                    } else {
                        com.baidu.sofire.core.g a = com.baidu.sofire.core.g.a();
                        if (a == null) {
                            MyService.a(MyService.this);
                        } else {
                            ApkInfo d = a.d(stringExtra);
                            new StringBuilder("i=").append(d);
                            b.a();
                            if (d == null) {
                                MyService.a(MyService.this);
                            } else {
                                MyService.a(MyService.this, d.classLoader, intent);
                                MyService.a(MyService.this);
                            }
                        }
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
            new StringBuilder().append(stringExtra).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(newInstance);
            b.a();
            String stringExtra2 = intent.getStringExtra("target_method");
            new StringBuilder().append(stringExtra2);
            b.a();
            loadClass.getDeclaredMethod(stringExtra2, Context.class, Intent.class).invoke(newInstance, myService.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.c();
        }
    }
}
