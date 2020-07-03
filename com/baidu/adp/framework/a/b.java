package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> HX = new e();
    public static g<String, String> HY = new e();
    private static Application mContext;

    public static void init(Application application) {
        mContext = application;
        try {
            jW();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void jW() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> jX;
        if (h.jX().size() == 0) {
            jX = a.a(mContext, "com.baidu.tieba.route");
        } else {
            jX = h.jX();
        }
        Log.e("CmdRouter", jX.toString());
        for (String str : jX) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                HY.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                HX.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
