package com.baidu.sapi2.passhost.framework;

import android.content.Context;
import android.util.Pair;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.AbsPassPiSafe;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginFacade {
    private static boolean a = false;

    /* loaded from: classes.dex */
    public static final class a {
        public static final String a = "1.0.5";
    }

    public static void setSwitch(Context context, boolean z) {
        boolean z2 = a;
        a = z;
        if (!z2 && z && SapiUtils.isOnline(context)) {
            onProcessStartAsync(context);
        }
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
