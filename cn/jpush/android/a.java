package cn.jpush.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.i;
import cn.jpush.android.d.f;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class a {
    public static int b;
    public static String c;
    public static String d;
    public static Context e;
    public static final String a = SdkType.JPUSH.name();
    public static boolean f = false;
    private static final AtomicInteger g = new AtomicInteger(-1);
    private static final Object h = new Object();

    public static boolean a(Context context) {
        return c(context) == 0;
    }

    public static Context b(Context context) {
        if (e == null && context != null) {
            e = context.getApplicationContext();
            c = context.getPackageName();
        }
        return e;
    }

    private static int c(Context context) {
        boolean z = true;
        if (g.get() == 0) {
            return 0;
        }
        synchronized (h) {
            if (g.get() == 0) {
                return 0;
            }
            Context b2 = b(context);
            if (b2 == null) {
                g.set(1);
                return 1;
            }
            f.a("AndroidUtil", "action:checkValidManifest");
            if (cn.jpush.android.d.a.a(b2, PushActivity.class)) {
                if (!cn.jpush.android.d.a.a(b2, PopWinActivity.class)) {
                    f.c("AndroidUtil", "AndroidManifest.xml missing activity: " + PopWinActivity.class.getCanonicalName());
                    f.c("AndroidUtil", "You will unable to use pop-window rich push type.");
                }
                if (!cn.jpush.android.d.a.d(b2, "cn.jpush.android.ui.PushActivity")) {
                    f.d("AndroidUtil", "AndroidManifest.xml missing required intent filter for PushActivity: cn.jpush.android.ui.PushActivity");
                    z = false;
                }
            } else {
                f.d("AndroidUtil", "AndroidManifest.xml missing required activity: " + PushActivity.class.getCanonicalName());
                z = false;
            }
            if (!z) {
                g.set(2);
                return 2;
            }
            g.set(0);
            try {
                String string = i.getString(b2, "jpush_sdk_version", "");
                if (!"3.1.6".equals(string)) {
                    TextUtils.isEmpty(string);
                }
                i.f(b2, "jpush_sdk_version", "3.1.6");
            } catch (Throwable th) {
            }
            try {
                ApplicationInfo applicationInfo = b2.getPackageManager().getApplicationInfo(b2.getPackageName(), 0);
                if (applicationInfo == null) {
                    f.d("JPushGlobal", "JPush get NULL appInfo.");
                } else {
                    b = applicationInfo.icon;
                    d = b2.getPackageManager().getApplicationLabel(applicationInfo).toString();
                }
            } catch (Throwable th2) {
                f.c("JPushGlobal", "get packageIconId and appName error:" + th2);
            }
            ServiceInterface.a(b2);
            return 0;
        }
    }
}
