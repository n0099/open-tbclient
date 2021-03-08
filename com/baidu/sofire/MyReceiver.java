package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.i.w;
import java.util.List;
/* loaded from: classes4.dex */
public class MyReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Callback f3491a = new Callback() { // from class: com.baidu.sofire.MyReceiver.1
        @Override // com.baidu.sofire.ac.Callback
        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };
    private boolean b = false;
    private long c = 0;
    private long d = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if (intent != null) {
            try {
                new StringBuilder().append(intent.toString()).append(", ins=").append(this);
                b.a();
                if (!this.b || System.currentTimeMillis() - this.c >= 2000) {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        if (System.currentTimeMillis() - this.d >= 100 && com.baidu.sofire.i.e.f(context)) {
                            this.d = System.currentTimeMillis();
                        } else {
                            return;
                        }
                    }
                    new StringBuilder("_2_").append(intent.toString());
                    b.a();
                    final Context applicationContext = context.getApplicationContext();
                    final boolean z = this.b;
                    w.a().a(new Runnable() { // from class: com.baidu.sofire.MyReceiver.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ApkInfo d;
                            List<ApkInfo> b;
                            boolean z2 = true;
                            try {
                                new StringBuilder().append(intent.toString());
                                b.a();
                                if ("r".equals(intent.getStringExtra("t"))) {
                                    String stringExtra = intent.getStringExtra("c");
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("t", "r");
                                    intent2.putExtra("c", stringExtra);
                                    a.a(applicationContext, intent2);
                                }
                                String action = intent.getAction();
                                if (z && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.i.e.f(applicationContext) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                    new U(applicationContext.getApplicationContext(), 3, false).start();
                                } else {
                                    z2 = false;
                                }
                                if (z && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.i.e.f3535a && !z2 && com.baidu.sofire.i.e.e(applicationContext)) {
                                    new U(applicationContext.getApplicationContext(), 3, false).start();
                                }
                                if (!z) {
                                    String stringExtra2 = intent.getStringExtra("from_plugin_package");
                                    if (TextUtils.isEmpty(stringExtra2)) {
                                        com.baidu.sofire.core.f a2 = com.baidu.sofire.core.f.a();
                                        if (a2 != null && (b = a2.b()) != null) {
                                            for (int i = 0; i < b.size(); i++) {
                                                ApkInfo apkInfo = b.get(i);
                                                if (apkInfo.intentFilters != null) {
                                                    for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                                                        com.baidu.sofire.core.g gVar = apkInfo.intentFilters.get(i2);
                                                        if (gVar.d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                            new StringBuilder().append(apkInfo);
                                                            b.a();
                                                            Class<?> loadClass = apkInfo.classLoader.loadClass(gVar.b);
                                                            loadClass.getDeclaredMethod(gVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), applicationContext.getApplicationContext(), intent);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (applicationContext.getPackageName().equals(stringExtra2)) {
                                        MyReceiver.a(applicationContext.getClassLoader(), intent, applicationContext);
                                    } else {
                                        com.baidu.sofire.core.f a3 = com.baidu.sofire.core.f.a();
                                        if (a3 != null && (d = a3.d(stringExtra2)) != null) {
                                            MyReceiver.a(d.classLoader, intent, applicationContext);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.i.e.a();
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }

    public final MyReceiver a() {
        try {
            this.c = System.currentTimeMillis();
            this.b = true;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        return this;
    }

    static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.c();
        }
    }
}
