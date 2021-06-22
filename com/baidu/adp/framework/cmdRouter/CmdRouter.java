package com.baidu.adp.framework.cmdRouter;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.b.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class CmdRouter {
    public static final String ROUTE_ROOT_PAKCAGE = "com.baidu.tieba.route";
    public static final String SDK_NAME = "CmdRouter";
    public static final String TAG = "CmdRouter";
    public static Application mContext;
    public static CmdRouter sInstance;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public static MultiValueMap<String, ArrayList<String>> configMaps = new LinkedMultiValueMap();
    public static MultiValueMap<String, String> cmdMaps = new LinkedMultiValueMap();

    public static CmdRouter getsInstance() {
        if (sInstance == null) {
            synchronized (CmdRouter.class) {
                if (sInstance == null) {
                    sInstance = new CmdRouter();
                }
            }
        }
        return sInstance;
    }

    public static void init(Application application) {
        mContext = application;
        try {
            loadInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("CmdRouter", "初始化失败!", e2);
        }
    }

    public static void loadInfo() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> loadCmdClasses;
        TiebaCmdClassesArray tiebaCmdClassesArray = new TiebaCmdClassesArray();
        try {
            Class<?> cls = Class.forName("com.baidu.adp.framework.cmdRouter.TiebaCmdArray");
            Object newInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField("cmdClassesArray");
            declaredField.setAccessible(true);
            tiebaCmdClassesArray.cmdClassesArray = (String[]) declaredField.get(newInstance);
        } catch (Exception e2) {
            Log.e("cmdClassesArray: ", a.g0);
            e2.printStackTrace();
        }
        Log.e("cmdClassesArray: ", "" + tiebaCmdClassesArray.cmdClassesArray.length);
        if (tiebaCmdClassesArray.loadCmdClasses().size() == 0) {
            loadCmdClasses = ClassUtils.getFileNameByPackageName(mContext, ROUTE_ROOT_PAKCAGE);
        } else {
            loadCmdClasses = tiebaCmdClassesArray.loadCmdClasses();
        }
        Log.e("CmdRouter", loadCmdClasses.toString());
        for (String str : loadCmdClasses) {
            if (str.startsWith("com.baidu.tieba.route.")) {
                cmdMaps.addAll(((ICmdRouter) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getCmdRouterMap());
                configMaps.addAll(((ICmdRouter) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).getConfigRouterMap());
            }
        }
    }
}
