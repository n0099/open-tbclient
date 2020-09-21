package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static g<String, ArrayList<String>> IK = new e();
    public static g<String, String> IL = new e();
    private static Application mContext;

    public static void init(Application application) {
        mContext = application;
        try {
            lz();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e);
        }
    }

    private static void lz() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> lA;
        if (h.lA().size() == 0) {
            lA = a.a(mContext, "com.baidu.tieba.route");
        } else {
            lA = h.lA();
        }
        Log.e("CmdRouter", lA.toString());
        for (String str : lA) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                IL.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                IK.d(((d) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
