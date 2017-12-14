package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.k;
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
                            ApkInfo bY;
                            List<ApkInfo> b;
                            boolean z = true;
                            try {
                                super.run();
                                String action = intent.getAction();
                                if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.BOOT_COMPLETED")) {
                                    com.baidu.sofire.b.d.b(context);
                                    com.baidu.sofire.b.b.a(context, true);
                                    Report.getInstance(context).r(true);
                                    com.baidu.sofire.core.c.a(2);
                                    com.baidu.sofire.core.c.ap(context.getApplicationContext()).a(new Callback() { // from class: com.baidu.sofire.MyReceiver.2.1
                                        @Override // com.baidu.sofire.ac.Callback
                                        public final Object onEnd(Object... objArr) {
                                            com.baidu.sofire.core.e no = com.baidu.sofire.core.e.no();
                                            if (no == null) {
                                                return null;
                                            }
                                            List<ApkInfo> b2 = no.b();
                                            if (b2 == null) {
                                                b2 = new ArrayList<>();
                                            }
                                            com.baidu.sofire.a.a an = com.baidu.sofire.a.a.an(context.getApplicationContext());
                                            for (ApkInfo apkInfo : b2) {
                                                String[] b3 = an.b(apkInfo.packageName);
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
                                } else {
                                    z = false;
                                }
                                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.d.a && !z && com.baidu.sofire.b.d.c(context)) {
                                    new U(context.getApplicationContext(), 3, false).start();
                                }
                                if (!MyReceiver.this.b) {
                                    if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PACKAGE_REMOVED")) {
                                        k.a(context, intent);
                                    }
                                    String stringExtra = intent.getStringExtra("from_plugin_package");
                                    if (TextUtils.isEmpty(stringExtra)) {
                                        com.baidu.sofire.core.e no = com.baidu.sofire.core.e.no();
                                        if (no != null && (b = no.b()) != null) {
                                            for (int i = 0; i < b.size(); i++) {
                                                ApkInfo apkInfo = b.get(i);
                                                if (apkInfo.intentFilters != null) {
                                                    for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                                                        com.baidu.sofire.core.f fVar = apkInfo.intentFilters.get(i2);
                                                        if (fVar.QC.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                            new StringBuilder().append(apkInfo);
                                                            Class<?> loadClass = apkInfo.classLoader.loadClass(fVar.b);
                                                            loadClass.getDeclaredMethod(fVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (context.getPackageName().equals(stringExtra)) {
                                        MyReceiver.a(context.getClassLoader(), intent, context);
                                    } else {
                                        com.baidu.sofire.core.e no2 = com.baidu.sofire.core.e.no();
                                        if (no2 != null && (bY = no2.bY(stringExtra)) != null) {
                                            MyReceiver.a(bY.classLoader, intent, context);
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
