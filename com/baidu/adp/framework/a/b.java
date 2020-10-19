package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> Je = new e();
    public static g<String, String> Jf = new e();
    private static Application mContext;

    public static void init(Application application) {
        mContext = application;
        try {
            lA();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void lA() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> lB;
        if (h.lB().size() == 0) {
            lB = a.a(mContext, "com.baidu.tieba.route");
        } else {
            lB = h.lB();
        }
        Log.e("CmdRouter", lB.toString());
        for (String str : lB) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                Jf.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                Je.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
