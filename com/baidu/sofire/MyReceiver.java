package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.a;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.m;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MyReceiver extends BroadcastReceiver {
    Callback a = new Callback() { // from class: com.baidu.sofire.MyReceiver.1
        @Override // com.baidu.sofire.ac.Callback
        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };
    private boolean b = false;
    private long c = 0;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.sofire.MyReceiver$2] */
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        try {
            new StringBuilder().append(intent);
            if (intent != null) {
                if (!this.b || System.currentTimeMillis() - this.c >= 2000) {
                    new Thread() { // from class: com.baidu.sofire.MyReceiver.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            boolean z;
                            ApkInfo d;
                            List<ApkInfo> b;
                            try {
                                super.run();
                                if ("r".equals(intent.getStringExtra(Info.kBaiduTimeKey))) {
                                    String stringExtra = intent.getStringExtra("c");
                                    Intent intent2 = new Intent();
                                    intent2.putExtra(Info.kBaiduTimeKey, "r");
                                    intent2.putExtra("c", stringExtra);
                                    new a.AnonymousClass1(context, intent2).start();
                                }
                                String action = intent.getAction();
                                if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.BOOT_COMPLETED")) {
                                    com.baidu.sofire.b.d.b(context);
                                    com.baidu.sofire.b.b.a(context, true);
                                    Report.getInstance(context).r(true);
                                    com.baidu.sofire.core.c.a(2);
                                    com.baidu.sofire.core.c.a(context.getApplicationContext()).a(new Callback() { // from class: com.baidu.sofire.MyReceiver.2.1
                                        @Override // com.baidu.sofire.ac.Callback
                                        public final Object onEnd(Object... objArr) {
                                            com.baidu.sofire.core.e a = com.baidu.sofire.core.e.a();
                                            if (a == null) {
                                                return null;
                                            }
                                            List<ApkInfo> b2 = a.b();
                                            if (b2 == null) {
                                                b2 = new ArrayList<>();
                                            }
                                            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context.getApplicationContext());
                                            for (ApkInfo apkInfo : b2) {
                                                String[] b3 = a2.b(apkInfo.packageName);
                                                if (b3 != null) {
                                                    try {
                                                        Class<?> loadClass = apkInfo.classLoader.loadClass(b3[0]);
                                                        loadClass.getDeclaredMethod(b3[1], Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                                    } catch (Throwable th) {
                                                        th.getMessage();
                                                    }
                                                }
                                            }
                                            return super.onEnd(objArr);
                                        }
                                    });
                                    return;
                                }
                                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.d.d(context) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                    new U(context.getApplicationContext(), 3, false).start();
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.d.a && !z && com.baidu.sofire.b.d.c(context)) {
                                    new U(context.getApplicationContext(), 3, false).start();
                                }
                                if (!MyReceiver.this.b) {
                                    if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PACKAGE_REMOVED")) {
                                        m.a(context, intent);
                                    }
                                    String stringExtra2 = intent.getStringExtra("from_plugin_package");
                                    if (TextUtils.isEmpty(stringExtra2)) {
                                        com.baidu.sofire.core.e a = com.baidu.sofire.core.e.a();
                                        if (a != null && (b = a.b()) != null) {
                                            for (int i = 0; i < b.size(); i++) {
                                                ApkInfo apkInfo = b.get(i);
                                                if (apkInfo.intentFilters != null) {
                                                    for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                                                        com.baidu.sofire.core.f fVar = apkInfo.intentFilters.get(i2);
                                                        if (fVar.d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                            new StringBuilder().append(apkInfo);
                                                            Class<?> loadClass = apkInfo.classLoader.loadClass(fVar.b);
                                                            loadClass.getDeclaredMethod(fVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (context.getPackageName().equals(stringExtra2)) {
                                        MyReceiver.a(context.getClassLoader(), intent, context);
                                    } else {
                                        com.baidu.sofire.core.e a2 = com.baidu.sofire.core.e.a();
                                        if (a2 != null && (d = a2.d(stringExtra2)) != null) {
                                            MyReceiver.a(d.classLoader, intent, context);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.b.d.a(th);
                            }
                        }
                    }.start();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    public final MyReceiver a() {
        try {
            this.c = System.currentTimeMillis();
            this.b = true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
        return this;
    }

    static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
