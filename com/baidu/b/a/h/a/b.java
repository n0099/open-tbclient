package com.baidu.b.a.h.a;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class b {
    private static ApplicationInfo Zl;
    private static b aaD;
    private a aaE;
    private Context mAppContext;

    public static synchronized b bl(Context context) {
        b bVar;
        synchronized (b.class) {
            if (aaD == null) {
                aaD = new b(context);
            }
            bVar = aaD;
        }
        return bVar;
    }

    private b(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public synchronized a so() {
        Class<?> cls;
        if (this.aaE == null && com.baidu.b.a.h.b.isMainProcess()) {
            try {
                try {
                    ApplicationInfo sp = sp();
                    if (sp != null && sp.metaData != null) {
                        String string = sp.metaData.getString("dynamic.download.callback.statistic");
                        if (!TextUtils.isEmpty(string) && (cls = Class.forName(string)) != null) {
                            this.aaE = (a) cls.newInstance();
                        }
                    }
                } catch (IllegalAccessException e) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        e.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e2) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    e2.printStackTrace();
                }
            } catch (InstantiationException e3) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    e3.printStackTrace();
                }
            }
        }
        if (this.aaE == null) {
            this.aaE = new com.baidu.b.a.h.a.a.a();
        }
        return this.aaE;
    }

    private static ApplicationInfo sp() {
        synchronized (b.class) {
            if (Zl == null) {
                try {
                    Application application = AppRuntime.getApplication();
                    Zl = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException e) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        e.printStackTrace();
                    }
                } catch (RuntimeException e2) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return Zl;
    }
}
