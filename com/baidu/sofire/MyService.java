package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.b.r;
import com.baidu.sofire.core.ApkInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class MyService extends Service {
    private volatile int a = 0;

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.a++;
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        b.a("PPP(service) try do action " + intent.getAction() + " " + stringExtra);
        r.a().a(new Runnable() { // from class: com.baidu.sofire.MyService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    b.a("PPP(service) do action " + intent.getAction() + " " + stringExtra);
                    if ("s".equals(intent.getStringExtra("t"))) {
                        String stringExtra2 = intent.getStringExtra("c");
                        Intent intent2 = new Intent();
                        intent2.putExtra("t", "s");
                        intent2.putExtra("c", stringExtra2);
                        a.a(MyService.this.getApplicationContext(), intent2);
                    }
                    b.a("p:=" + stringExtra);
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.this.a();
                    } else if (MyService.this.getPackageName().equals(stringExtra)) {
                        MyService.this.a(MyService.this.getClassLoader(), intent);
                        MyService.this.a();
                    } else {
                        com.baidu.sofire.core.g a = com.baidu.sofire.core.g.a();
                        if (a == null) {
                            MyService.this.a();
                            return;
                        }
                        ApkInfo d = a.d(stringExtra);
                        b.a("i=" + d);
                        if (d == null) {
                            MyService.this.a();
                            return;
                        }
                        MyService.this.a(d.classLoader, intent);
                        b.a("PPP(service) after action " + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f) + intent.toString() + " " + stringExtra);
                        MyService.this.a();
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.b.e.a(th2);
                    MyService.this.a();
                }
            }
        });
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.a--;
            if (this.a <= 0) {
                this.a = 0;
                b.a("MyService call stopSelf");
                stopSelf();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ClassLoader classLoader, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("target_class");
            Class<?> loadClass = classLoader.loadClass(stringExtra);
            Object newInstance = loadClass.newInstance();
            b.a("targetClass=" + stringExtra + Constants.ACCEPT_TIME_SEPARATOR_SERVER + newInstance);
            String stringExtra2 = intent.getStringExtra("target_method");
            b.a("targetMethod=" + stringExtra2);
            loadClass.getDeclaredMethod(stringExtra2, Context.class, Intent.class).invoke(newInstance, getApplicationContext(), intent);
        } catch (Throwable th) {
            b.a(th.getMessage(), th);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
