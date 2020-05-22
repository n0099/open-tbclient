package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> Hw = new e();
    public static g<String, String> Hx = new e();
    private static Application mContext;

    public static void init(Application application) {
        mContext = application;
        try {
            jG();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void jG() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> jH;
        if (h.jH().size() == 0) {
            jH = a.a(mContext, "com.baidu.tieba.route");
        } else {
            jH = h.jH();
        }
        Log.e("CmdRouter", jH.toString());
        for (String str : jH) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                Hx.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                Hw.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
