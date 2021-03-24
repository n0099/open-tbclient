package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.g.t;
/* loaded from: classes3.dex */
public class MyService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public static long f11610b;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f11611a = 0;

    public static /* synthetic */ int a(MyService myService) {
        int i = myService.f11611a;
        myService.f11611a = i + 1;
        return i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
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
            long j = f11610b;
            if ("teac".equals(intent.getAction())) {
                f11610b = System.currentTimeMillis();
                if (System.currentTimeMillis() - j < 3000) {
                    return super.onStartCommand(intent, i, i2);
                }
                if (com.baidu.sofire.g.d.j != 0 && f11610b - com.baidu.sofire.g.d.j > 5000) {
                    StringBuilder sb = new StringBuilder("persist process alive now:");
                    sb.append(f11610b);
                    sb.append("init:");
                    sb.append(com.baidu.sofire.g.d.j);
                    b.b();
                    return super.onStartCommand(intent, i, i2);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(intent.getAction());
            sb2.append(" ");
            sb2.append(stringExtra);
            b.a();
            t.a(getApplicationContext()).a(new Runnable() { // from class: com.baidu.sofire.MyService.1
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
                                return;
                            }
                            com.baidu.sofire.core.d.a(intExtra, stringExtra2, (Callback) null, new Class[]{Intent.class}, intent);
                            StringBuilder sb3 = new StringBuilder("MyService#onStart2 intent=");
                            sb3.append(intent);
                            sb3.append(", extra=");
                            sb3.append(intent.getExtras());
                            b.a();
                            MyService.this.a();
                        } else {
                            com.baidu.sofire.core.f a2 = com.baidu.sofire.core.f.a();
                            if (a2 == null) {
                                MyService.this.a();
                                return;
                            }
                            ApkInfo d2 = a2.d(stringExtra);
                            new StringBuilder("i=").append(d2);
                            b.a();
                            if (d2 == null) {
                                MyService.this.a();
                                return;
                            }
                            MyService.a(MyService.this, d2.classLoader, intent);
                            MyService.this.a();
                        }
                    } catch (Throwable unused2) {
                        com.baidu.sofire.g.d.a();
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
            this.f11611a--;
            if (this.f11611a <= 0) {
                this.f11611a = 0;
                b.a();
                stopSelf();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public static /* synthetic */ void a(MyService myService, ClassLoader classLoader, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("target_class");
            Class<?> loadClass = classLoader.loadClass(stringExtra);
            Object newInstance = loadClass.newInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(stringExtra);
            sb.append("-");
            sb.append(newInstance);
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
