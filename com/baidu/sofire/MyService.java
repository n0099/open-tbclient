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

    static /* synthetic */ void a(MyService myService) {
        try {
            myService.a--;
            if (myService.a <= 0) {
                myService.a = 0;
                b.a();
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
            String str = stringExtra + Constants.ACCEPT_TIME_SEPARATOR_SERVER + newInstance;
            b.a();
            String stringExtra2 = intent.getStringExtra("target_method");
            String str2 = stringExtra2;
            b.a();
            loadClass.getDeclaredMethod(stringExtra2, Context.class, Intent.class).invoke(newInstance, myService.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }

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
                    String str = "p:=" + stringExtra;
                    b.a();
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.a(MyService.this);
                    } else if (MyService.this.getPackageName().equals(stringExtra)) {
                        MyService.a(MyService.this, MyService.this.getClassLoader(), intent);
                        MyService.a(MyService.this);
                    } else {
                        com.baidu.sofire.core.e nk = com.baidu.sofire.core.e.nk();
                        if (nk == null) {
                            MyService.a(MyService.this);
                        } else {
                            ApkInfo bS = nk.bS(stringExtra);
                            String str2 = "i=" + bS;
                            b.a();
                            if (bS == null) {
                                MyService.a(MyService.this);
                            } else {
                                MyService.a(MyService.this, bS.classLoader, intent);
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
}
