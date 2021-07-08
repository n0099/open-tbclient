package com.baidu.adp.framework.cmdRouter;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class CmdRouter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ROUTE_ROOT_PAKCAGE = "com.baidu.tieba.route";
    public static final String SDK_NAME = "CmdRouter";
    public static final String TAG = "CmdRouter";
    public static MultiValueMap<String, String> cmdMaps;
    public static MultiValueMap<String, ArrayList<String>> configMaps;
    public static Application mContext;
    public static CmdRouter sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228625573, "Lcom/baidu/adp/framework/cmdRouter/CmdRouter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(228625573, "Lcom/baidu/adp/framework/cmdRouter/CmdRouter;");
                return;
            }
        }
        configMaps = new LinkedMultiValueMap();
        cmdMaps = new LinkedMultiValueMap();
    }

    public CmdRouter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static CmdRouter getsInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (CmdRouter.class) {
                    if (sInstance == null) {
                        sInstance = new CmdRouter();
                    }
                }
            }
            return sInstance;
        }
        return (CmdRouter) invokeV.objValue;
    }

    public static void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            mContext = application;
            try {
                loadInfo();
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("CmdRouter", "初始化失败!", e2);
            }
        }
    }

    public static void loadInfo() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<String> loadCmdClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
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
}
