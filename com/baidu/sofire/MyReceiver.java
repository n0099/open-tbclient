package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.r;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.h;
import com.baidu.sofire.rp.Report;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MyReceiver extends BroadcastReceiver {
    Callback a = new Callback() { // from class: com.baidu.sofire.MyReceiver.1
        @Override // com.baidu.sofire.ac.Callback
        public Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };
    private boolean b = false;
    private long c = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (!this.b || System.currentTimeMillis() - this.c >= SystemScreenshotManager.DELAY_TIME) {
                    b.a("PPP(receiver) try do action " + intent.toString());
                    a(context, intent, this.b);
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    private static void a(final Context context, final Intent intent, final boolean z) {
        r.a().a(new Runnable() { // from class: com.baidu.sofire.MyReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                ApkInfo d;
                try {
                    b.a("PPP(receiver) now do action " + intent.toString());
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
                        com.baidu.sofire.b.e.d(context);
                        com.baidu.sofire.b.b.a(context, true);
                        Report.getInstance(context).r(true);
                        com.baidu.sofire.core.d.b(2);
                        com.baidu.sofire.core.d.a(context.getApplicationContext()).a(new Callback() { // from class: com.baidu.sofire.MyReceiver.2.1
                            @Override // com.baidu.sofire.ac.Callback
                            public Object onEnd(Object... objArr) {
                                com.baidu.sofire.core.g a = com.baidu.sofire.core.g.a();
                                if (a == null) {
                                    return null;
                                }
                                List<ApkInfo> b = a.b();
                                if (b == null) {
                                    b = new ArrayList<>();
                                }
                                com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context.getApplicationContext());
                                for (ApkInfo apkInfo : b) {
                                    String[] b2 = a2.b(apkInfo.packageName);
                                    if (b2 != null) {
                                        try {
                                            Class<?> loadClass = apkInfo.classLoader.loadClass(b2[0]);
                                            loadClass.getDeclaredMethod(b2[1], Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                        } catch (Throwable th) {
                                            b.a(th.getMessage(), th);
                                        }
                                    }
                                }
                                return super.onEnd(objArr);
                            }
                        });
                        return;
                    }
                    boolean z2 = false;
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.e.g(context) && U.sMonitorNetworkWhenUpgradeNoNet) {
                        z2 = true;
                        new U(context.getApplicationContext(), 3, false).start();
                    }
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.b.e.a && !z2 && com.baidu.sofire.b.e.f(context)) {
                        new U(context.getApplicationContext(), 3, false).start();
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PACKAGE_REMOVED")) {
                            com.baidu.sofire.b.e.a(context, intent);
                        }
                        String stringExtra2 = intent.getStringExtra("from_plugin_package");
                        if (TextUtils.isEmpty(stringExtra2)) {
                            com.baidu.sofire.core.g a = com.baidu.sofire.core.g.a();
                            if (a != null) {
                                List<ApkInfo> b = a.b();
                                if (b != null) {
                                    for (int i = 0; i < b.size(); i++) {
                                        ApkInfo apkInfo = b.get(i);
                                        if (apkInfo.intentFilters != null) {
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = i2;
                                                if (i3 < apkInfo.intentFilters.size()) {
                                                    h hVar = apkInfo.intentFilters.get(i3);
                                                    if (hVar.d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                        b.a("receive match info:" + apkInfo);
                                                        Class<?> loadClass = apkInfo.classLoader.loadClass(hVar.b);
                                                        loadClass.getDeclaredMethod(hVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                                    }
                                                    i2 = i3 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                                b.a("PPP(receiver) end1 do action " + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f) + intent.toString());
                            }
                        } else if (context.getPackageName().equals(stringExtra2)) {
                            MyReceiver.b(context.getClassLoader(), intent, context);
                        } else {
                            com.baidu.sofire.core.g a2 = com.baidu.sofire.core.g.a();
                            if (a2 != null && (d = a2.d(stringExtra2)) != null) {
                                MyReceiver.b(d.classLoader, intent, context);
                                b.a("PPP(receiver) end2 do action " + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f) + intent.toString());
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
        } catch (Throwable th) {
            b.a(th.getMessage(), th);
        }
    }

    public MyReceiver a() {
        try {
            this.c = System.currentTimeMillis();
            this.b = true;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        return this;
    }
}
