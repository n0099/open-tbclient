package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.utility.x;
import java.util.List;
/* loaded from: classes2.dex */
public class MyReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Callback f10154a = new Callback() { // from class: com.baidu.sofire.MyReceiver.1
        @Override // com.baidu.sofire.ac.Callback
        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public boolean f10155b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f10156c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f10157d = 0;

    public final MyReceiver a() {
        try {
            this.f10156c = System.currentTimeMillis();
            this.f10155b = true;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return this;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!this.f10155b || System.currentTimeMillis() - this.f10156c >= 2000) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (System.currentTimeMillis() - this.f10157d < 100 || !com.baidu.sofire.utility.c.f(context)) {
                        return;
                    }
                    this.f10157d = System.currentTimeMillis();
                }
                final Context applicationContext = context.getApplicationContext();
                final boolean z = this.f10155b;
                x.a(applicationContext).a(new Runnable() { // from class: com.baidu.sofire.MyReceiver.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z2;
                        ApkInfo d2;
                        List<ApkInfo> b2;
                        try {
                            if (r.f7715a.equals(intent.getStringExtra("t"))) {
                                String stringExtra = intent.getStringExtra("c");
                                Intent intent2 = new Intent();
                                intent2.putExtra("t", r.f7715a);
                                intent2.putExtra("c", stringExtra);
                                a.a(applicationContext, intent2);
                            }
                            String action = intent.getAction();
                            if (z && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.utility.c.f(applicationContext) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                x.a(applicationContext).b(new U(applicationContext.getApplicationContext(), 3, false));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.utility.c.f10399a && !z2 && com.baidu.sofire.utility.c.e(applicationContext)) {
                                x.a(applicationContext).b(new U(applicationContext.getApplicationContext(), 3, false));
                            }
                            if (z) {
                                return;
                            }
                            String stringExtra2 = intent.getStringExtra("from_plugin_package");
                            if (TextUtils.isEmpty(stringExtra2)) {
                                f a2 = f.a();
                                if (a2 == null || (b2 = a2.b()) == null) {
                                    return;
                                }
                                for (int i2 = 0; i2 < b2.size(); i2++) {
                                    ApkInfo apkInfo = b2.get(i2);
                                    if (apkInfo.intentFilters != null) {
                                        for (int i3 = 0; i3 < apkInfo.intentFilters.size(); i3++) {
                                            g gVar = apkInfo.intentFilters.get(i3);
                                            if (gVar.f10287d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                Class<?> loadClass = apkInfo.classLoader.loadClass(gVar.f10285b);
                                                loadClass.getDeclaredMethod(gVar.f10286c, Context.class, Intent.class).invoke(loadClass.newInstance(), applicationContext.getApplicationContext(), intent);
                                            }
                                        }
                                    }
                                }
                            } else if (applicationContext.getPackageName().equals(stringExtra2)) {
                                MyReceiver.a(applicationContext.getClassLoader(), intent, applicationContext);
                            } else {
                                f a3 = f.a();
                                if (a3 == null || (d2 = a3.d(stringExtra2)) == null) {
                                    return;
                                }
                                MyReceiver.a(d2.classLoader, intent, applicationContext);
                            }
                        } catch (Throwable unused) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
    }
}
