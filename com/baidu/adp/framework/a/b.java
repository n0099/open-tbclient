package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> IB = new e();
    public static g<String, String> IC = new e();
    private static Application mContext;

    public static void init(Application application) {
        mContext = application;
        try {
            lv();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void lv() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> lw;
        if (h.lw().size() == 0) {
            lw = a.a(mContext, "com.baidu.tieba.route");
        } else {
            lw = h.lw();
        }
        Log.e("CmdRouter", lw.toString());
        for (String str : lw) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                IC.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                IB.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
