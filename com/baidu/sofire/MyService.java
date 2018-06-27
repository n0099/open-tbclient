package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.b.t;
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
            com.baidu.sofire.b.e.a(th);
        }
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.a++;
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        new StringBuilder("PPP(service) try do action ").append(intent.toString()).append(" ").append(stringExtra);
        t.a().a.execute(new Runnable() { // from class: com.baidu.sofire.MyService.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    new StringBuilder("PPP(service) do action ").append(intent.toString()).append(" ").append(stringExtra);
                    if (NotifyType.SOUND.equals(intent.getStringExtra(Info.kBaiduTimeKey))) {
                        String stringExtra2 = intent.getStringExtra("c");
                        Intent intent2 = new Intent();
                        intent2.putExtra(Info.kBaiduTimeKey, NotifyType.SOUND);
                        intent2.putExtra("c", stringExtra2);
                        a.a(MyService.this.getApplicationContext(), intent2);
                    }
                    new StringBuilder("p:=").append(stringExtra);
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.a(MyService.this);
                    } else if (MyService.this.getPackageName().equals(stringExtra)) {
                        MyService.a(MyService.this, MyService.this.getClassLoader(), intent);
                        MyService.a(MyService.this);
                    } else {
                        com.baidu.sofire.core.e a = com.baidu.sofire.core.e.a();
                        if (a == null) {
                            MyService.a(MyService.this);
                            return;
                        }
                        ApkInfo d = a.d(stringExtra);
                        new StringBuilder("i=").append(d);
                        if (d == null) {
                            MyService.a(MyService.this);
                            return;
                        }
                        MyService.a(MyService.this, d.classLoader, intent);
                        new StringBuilder("PPP(service) after action ").append(((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f).append(intent.toString()).append(" ").append(stringExtra);
                        MyService.a(MyService.this);
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.b.e.a(th2);
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
                myService.stopSelf();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
