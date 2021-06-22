package com.baidu.sofire;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.sofire.utility.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class MyActivity extends Activity {
    public static String a(Activity activity) {
        if (activity == null) {
            return "";
        }
        try {
            Method method = Class.forName("android.app.Activity").getMethod("getActivityToken", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(activity, new Object[0]);
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Method method2 = cls.getMethod("getDefault", new Class[0]);
            method2.setAccessible(true);
            Object invoke2 = method2.invoke(cls, new Object[0]);
            Method method3 = invoke2.getClass().getMethod("getLaunchedFromUid", IBinder.class);
            method3.setAccessible(true);
            return activity.getPackageManager().getNameForUid(((Integer) method3.invoke(invoke2, invoke)).intValue());
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            final Intent intent = getIntent();
            if ("teac".equals(intent.getAction())) {
                Intent intent2 = new Intent(intent);
                intent2.setAction("teac");
                intent2.setComponent(new ComponentName(getApplicationContext().getPackageName(), MyService.class.getCanonicalName()));
                startService(intent2);
            }
            if ("a".equals(intent.getStringExtra("t"))) {
                final WeakReference weakReference = new WeakReference(this);
                final Context applicationContext = getApplicationContext();
                x.a(applicationContext).a(new Runnable() { // from class: com.baidu.sofire.MyActivity.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String stringExtra = intent.getStringExtra("c");
                            Intent intent3 = new Intent();
                            intent3.putExtra("t", "a");
                            intent3.putExtra("c", stringExtra);
                            String a2 = MyActivity.a((Activity) weakReference.get());
                            if (a2 == null) {
                                a2 = "";
                            }
                            intent3.putExtra("source", a2);
                            a.a(applicationContext.getApplicationContext(), intent3);
                        } catch (Throwable unused) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                });
            }
            super.onCreate(bundle);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        finish();
    }
}
