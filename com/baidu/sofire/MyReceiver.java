package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.g.t;
import java.util.List;
/* loaded from: classes2.dex */
public class MyReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Callback f11603a = new Callback() { // from class: com.baidu.sofire.MyReceiver.1
        @Override // com.baidu.sofire.ac.Callback
        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public boolean f11604b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f11605c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f11606d = 0;

    public final MyReceiver a() {
        try {
            this.f11605c = System.currentTimeMillis();
            this.f11604b = true;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        return this;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(intent.toString());
            sb.append(", ins=");
            sb.append(this);
            b.a();
            if (!this.f11604b || System.currentTimeMillis() - this.f11605c >= 2000) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (System.currentTimeMillis() - this.f11606d < 100 || !com.baidu.sofire.g.d.g(context)) {
                        return;
                    }
                    this.f11606d = System.currentTimeMillis();
                }
                new StringBuilder("_2_").append(intent.toString());
                b.a();
                final Context applicationContext = context.getApplicationContext();
                final boolean z = this.f11604b;
                t.a(applicationContext).a(new Runnable() { // from class: com.baidu.sofire.MyReceiver.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z2;
                        ApkInfo d2;
                        List<ApkInfo> b2;
                        try {
                            new StringBuilder().append(intent.toString());
                            b.a();
                            if (r.f7664a.equals(intent.getStringExtra("t"))) {
                                String stringExtra = intent.getStringExtra("c");
                                Intent intent2 = new Intent();
                                intent2.putExtra("t", r.f7664a);
                                intent2.putExtra("c", stringExtra);
                                a.a(applicationContext, intent2);
                            }
                            String action = intent.getAction();
                            if (z && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.g.d.g(applicationContext) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                new U(applicationContext.getApplicationContext(), 3, false).start();
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.g.d.f11748a && !z2 && com.baidu.sofire.g.d.f(applicationContext)) {
                                new U(applicationContext.getApplicationContext(), 3, false).start();
                            }
                            if (z) {
                                return;
                            }
                            String stringExtra2 = intent.getStringExtra("from_plugin_package");
                            if (TextUtils.isEmpty(stringExtra2)) {
                                com.baidu.sofire.core.f a2 = com.baidu.sofire.core.f.a();
                                if (a2 == null || (b2 = a2.b()) == null) {
                                    return;
                                }
                                for (int i = 0; i < b2.size(); i++) {
                                    ApkInfo apkInfo = b2.get(i);
                                    if (apkInfo.intentFilters != null) {
                                        for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                                            com.baidu.sofire.core.g gVar = apkInfo.intentFilters.get(i2);
                                            if (gVar.f11711d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                new StringBuilder().append(apkInfo);
                                                b.a();
                                                Class<?> loadClass = apkInfo.classLoader.loadClass(gVar.f11709b);
                                                loadClass.getDeclaredMethod(gVar.f11710c, Context.class, Intent.class).invoke(loadClass.newInstance(), applicationContext.getApplicationContext(), intent);
                                            }
                                        }
                                    }
                                }
                            } else if (applicationContext.getPackageName().equals(stringExtra2)) {
                                MyReceiver.a(applicationContext.getClassLoader(), intent, applicationContext);
                            } else {
                                com.baidu.sofire.core.f a3 = com.baidu.sofire.core.f.a();
                                if (a3 == null || (d2 = a3.d(stringExtra2)) == null) {
                                    return;
                                }
                                MyReceiver.a(d2.classLoader, intent, applicationContext);
                            }
                        } catch (Throwable unused) {
                            com.baidu.sofire.g.d.a();
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.c();
        }
    }
}
