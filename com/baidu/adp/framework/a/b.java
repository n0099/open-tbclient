package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> KM = new e();
    public static g<String, String> KN = new e();
    private static Application mContext;

    public static void c(Application application) {
        mContext = application;
        try {
            kV();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void kV() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> kW;
        if (h.kW().size() == 0) {
            kW = a.a(mContext, "com.baidu.tieba.route");
        } else {
            kW = h.kW();
        }
        Log.e("CmdRouter", kW.toString());
        for (String str : kW) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                KN.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                KM.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
