package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> Jw = new e();
    public static g<String, String> Jx = new e();
    private static Application mContext;

    public static void c(Application application) {
        mContext = application;
        try {
            kW();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void kW() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> kX;
        if (h.kX().size() == 0) {
            kX = a.a(mContext, "com.baidu.tieba.route");
        } else {
            kX = h.kX();
        }
        Log.e("CmdRouter", kX.toString());
        for (String str : kX) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                Jx.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                Jw.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
