package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.o;
import com.baidu.sofire.b.t;
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent != null) {
            try {
                if (!this.b || System.currentTimeMillis() - this.c >= 2000) {
                    new StringBuilder("PPP(receiver) try do action ").append(intent.toString());
                    final boolean z = this.b;
                    t a = t.a();
                    a.a.execute(new Runnable() { // from class: com.baidu.sofire.MyReceiver.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ApkInfo d;
                            try {
                                new StringBuilder("PPP(receiver) now do action ").append(intent.toString());
                                long currentTimeMillis = System.currentTimeMillis();
                                if ("r".equals(intent.getStringExtra("t"))) {
                                    String stringExtra = intent.getStringExtra("c");
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("t", "r");
                                    intent2.putExtra("c", stringExtra);
                                    a.a(context, intent2);
                                }
                                String action = intent.getAction();
                                if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.BOOT_COMPLETED")) {
                                    com.baidu.sofire.b.e.b(context);
                                    com.baidu.sofire.b.b.a(context, true);
                                    Report.getInstance(context).r(true);
                                    com.baidu.sofire.core.c.a(2);
                                    com.baidu.sofire.core.c.a(context.getApplicationContext()).a(new Callback() { // from class: com.baidu.sofire.MyReceiver.2.1
                                        @Override // com.baidu.sofire.ac.Callback
                                        public final Object onEnd(Object... objArr) {
                                            com.baidu.sofire.core.e a2 = com.baidu.sofire.core.e.a();
                                            if (a2 == null) {
                                                return null;
                                            }
                                            List<ApkInfo> b = a2.b();
                                            if (b == null) {
                                                b = new ArrayList<>();
                                            }
                                            com.baidu.sofire.a.a a3 = com.baidu.sofire.a.a.a(context.getApplicationContext());
                                            for (ApkInfo apkInfo : b) {
                                                String[] b2 = a3.b(apkInfo.packageName);
                                                if (b2 != null) {
                                                    try {
                                                        Class<?> loadClass = apkInfo.classLoader.loadClass(b2[0]);
                                                        loadClass.getDeclaredMethod(b2[1], Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
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
                                boolean z2 = false;
                                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.e.d(context) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                    z2 = true;
                                    new U(context.getApplicationContext(), 3, false).start();
                                }
                                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.e.a && !z2 && com.baidu.sofire.b.e.c(context)) {
                                    new U(context.getApplicationContext(), 3, false).start();
                                }
                                if (!z) {
                                    if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PACKAGE_REMOVED")) {
                                        o.a(context, intent);
                                    }
                                    String stringExtra2 = intent.getStringExtra("from_plugin_package");
                                    if (TextUtils.isEmpty(stringExtra2)) {
                                        com.baidu.sofire.core.e a2 = com.baidu.sofire.core.e.a();
                                        if (a2 != null) {
                                            List<ApkInfo> b = a2.b();
                                            if (b != null) {
                                                for (int i = 0; i < b.size(); i++) {
                                                    ApkInfo apkInfo = b.get(i);
                                                    if (apkInfo.intentFilters != null) {
                                                        int i2 = 0;
                                                        while (true) {
                                                            int i3 = i2;
                                                            if (i3 < apkInfo.intentFilters.size()) {
                                                                com.baidu.sofire.core.f fVar = apkInfo.intentFilters.get(i3);
                                                                if (fVar.d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                                    new StringBuilder().append(apkInfo);
                                                                    Class<?> loadClass = apkInfo.classLoader.loadClass(fVar.b);
                                                                    loadClass.getDeclaredMethod(fVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                                                }
                                                                i2 = i3 + 1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            new StringBuilder("PPP(receiver) end1 do action ").append(((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f).append(intent.toString());
                                        }
                                    } else if (context.getPackageName().equals(stringExtra2)) {
                                        MyReceiver.a(context.getClassLoader(), intent, context);
                                    } else {
                                        com.baidu.sofire.core.e a3 = com.baidu.sofire.core.e.a();
                                        if (a3 != null && (d = a3.d(stringExtra2)) != null) {
                                            MyReceiver.a(d.classLoader, intent, context);
                                            new StringBuilder("PPP(receiver) end2 do action ").append(((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f).append(intent.toString());
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.b.e.a(th);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    public final MyReceiver a() {
        try {
            this.c = System.currentTimeMillis();
            this.b = true;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
