package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.i.w;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes15.dex */
public class MyService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static long f5464b = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f5465a = 0;

    static /* synthetic */ int a(MyService myService) {
        int i = myService.f5465a;
        myService.f5465a = i + 1;
        return i;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        Bundle bundleExtra = intent.getBundleExtra("bundle");
        if (bundleExtra != null) {
            String[] stringArray = bundleExtra.getStringArray("appkey");
            int[] intArray = bundleExtra.getIntArray("key");
            int i3 = bundleExtra.getInt("delay");
            if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                com.baidu.sofire.core.d.a(getApplicationContext(), i3, stringArray[0], stringArray[1], intArray);
                return super.onStartCommand(intent, i, i2);
            }
        }
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(intent.getAction())) {
            a();
        } else {
            long j = f5464b;
            if ("teac".equals(intent.getAction())) {
                f5464b = System.currentTimeMillis();
                if (System.currentTimeMillis() - j < IMConnection.RETRY_DELAY_TIMES) {
                    return super.onStartCommand(intent, i, i2);
                }
                if (com.baidu.sofire.i.e.j != 0 && f5464b - com.baidu.sofire.i.e.j > 5000) {
                    new StringBuilder("persist process alive now:").append(f5464b).append("init:").append(com.baidu.sofire.i.e.j);
                    b.b();
                    return super.onStartCommand(intent, i, i2);
                }
            }
            new StringBuilder().append(intent.getAction()).append(" ").append(stringExtra);
            b.a();
            w.a().a(new Runnable() { // from class: com.baidu.sofire.MyService.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        MyService.a(MyService.this);
                        if (MyService.this.getPackageName().equals(stringExtra)) {
                            MyService.a(MyService.this, MyService.this.getClassLoader(), intent);
                            MyService.this.a();
                        } else if ("teac".equals(intent.getAction())) {
                            int intExtra = intent.getIntExtra("plugin_id", 100041);
                            String stringExtra2 = intent.getStringExtra("target_method");
                            if (TextUtils.isEmpty(stringExtra2)) {
                                MyService.this.a();
                            } else {
                                com.baidu.sofire.core.d.a(intExtra, stringExtra2, (Callback) null, new Class[]{Intent.class}, intent);
                                new StringBuilder("MyService#onStart2 intent=").append(intent).append(", extra=").append(intent.getExtras());
                                b.a();
                                MyService.this.a();
                            }
                        } else {
                            com.baidu.sofire.core.f a2 = com.baidu.sofire.core.f.a();
                            if (a2 == null) {
                                MyService.this.a();
                            } else {
                                ApkInfo d = a2.d(stringExtra);
                                new StringBuilder("i=").append(d);
                                b.a();
                                if (d == null) {
                                    MyService.this.a();
                                } else {
                                    MyService.a(MyService.this, d.classLoader, intent);
                                    MyService.this.a();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        com.baidu.sofire.i.e.a();
                        MyService.this.a();
                    }
                }
            });
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.f5465a--;
            if (this.f5465a <= 0) {
                this.f5465a = 0;
                b.a();
                stopSelf();
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
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
