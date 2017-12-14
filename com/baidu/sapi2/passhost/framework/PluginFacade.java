package com.baidu.sapi2.passhost.framework;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.AbsPassPiSafe;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginFacade {
    private static boolean a = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final String a = "1.0.3";
    }

    public static void setSwitch(Context context, boolean z) {
        boolean z2 = a;
        a = z;
        if (!z2 && z && a(context)) {
            onProcessStartAsync(context);
        }
    }

    private static boolean a(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (packageName.matches("com.baidu.sapi2.(.*)")) {
            return true;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(e);
        }
        Map<String, String> authorizedPackages = SapiContext.getInstance(context).getAuthorizedPackages();
        String packageSign = SapiUtils.getPackageSign(context, packageName);
        for (String str : authorizedPackages.keySet()) {
            if (packageName.matches(str) && packageSign.equals(authorizedPackages.get(str))) {
                return true;
            }
        }
        return false;
    }

    public static AbsPassPiSafe getAbsPassPiSafe() {
        if (!a) {
            return null;
        }
        return com.baidu.sapi2.passhost.framework.a.a().d();
    }

    public static void onProcessStartAsync(final Context context) {
        if (a) {
            ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.passhost.framework.PluginFacade.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.sapi2.passhost.framework.a.a().a(context);
                    com.baidu.sapi2.passhost.framework.a.a().c();
                }
            }));
        }
    }

    public static void onIntoMainUiAsync() {
        if (a && com.baidu.sapi2.passhost.framework.a.a().b()) {
            com.baidu.sapi2.passhost.hostsdk.service.a.a().a(2);
        }
    }

    public static void notify(int i, Object... objArr) {
        if (a && com.baidu.sapi2.passhost.framework.a.a().b()) {
            com.baidu.sapi2.passhost.hostsdk.service.a.a().notify(i, objArr);
        }
    }

    public static Pair<ArrayList<String>, ArrayList<String>> combinePisCookies() {
        if (a && com.baidu.sapi2.passhost.framework.a.a().b()) {
            return com.baidu.sapi2.passhost.framework.a.a().e();
        }
        return null;
    }
}
