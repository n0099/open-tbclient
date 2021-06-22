package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.utility.x;
import com.yy.gslbsdk.db.DelayTB;
/* loaded from: classes2.dex */
public class MyService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public static long f10162b;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f10163a = 0;

    public static /* synthetic */ int a(MyService myService) {
        int i2 = myService.f10163a;
        myService.f10163a = i2 + 1;
        return i2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i2, int i3) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (intent == null) {
            return super.onStartCommand(intent, i2, i3);
        }
        Bundle bundleExtra = intent.getBundleExtra("bundle");
        if (bundleExtra != null) {
            String[] stringArray = bundleExtra.getStringArray("appkey");
            int[] intArray = bundleExtra.getIntArray("key");
            int i4 = bundleExtra.getInt(DelayTB.DELAY);
            if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                com.baidu.sofire.core.d.a(getApplicationContext(), i4, stringArray[0], stringArray[1], intArray);
                return super.onStartCommand(intent, i2, i3);
            }
        }
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(intent.getAction())) {
            a();
        } else {
            long j = f10162b;
            if ("teac".equals(intent.getAction())) {
                f10162b = System.currentTimeMillis();
                if (System.currentTimeMillis() - j < 3000) {
                    return super.onStartCommand(intent, i2, i3);
                }
                if (com.baidu.sofire.utility.c.j != 0 && f10162b - com.baidu.sofire.utility.c.j > 5000) {
                    return super.onStartCommand(intent, i2, i3);
                }
            }
            x.a(getApplicationContext()).a(new Runnable() { // from class: com.baidu.sofire.MyService.1
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
                            MyService.this.a();
                        } else {
                            f a2 = f.a();
                            if (a2 == null) {
                                MyService.this.a();
                                return;
                            }
                            ApkInfo d2 = a2.d(stringExtra);
                            if (d2 == null) {
                                MyService.this.a();
                                return;
                            }
                            MyService.a(MyService.this, d2.classLoader, intent);
                            MyService.this.a();
                        }
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
                        MyService.this.a();
                    }
                }
            });
        }
        return super.onStartCommand(intent, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.f10163a--;
            if (this.f10163a <= 0) {
                this.f10163a = 0;
                stopSelf();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static /* synthetic */ void a(MyService myService, ClassLoader classLoader, Intent intent) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), myService.getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
    }
}
