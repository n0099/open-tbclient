package com.baidu.fsg.base.router;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class RouterManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "MaApplication";

    /* renamed from: b  reason: collision with root package name */
    public static RouterManager f34259b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ApplicationLogicWrapper> f34260c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1262005246, "Lcom/baidu/fsg/base/router/RouterManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1262005246, "Lcom/baidu/fsg/base/router/RouterManager;");
                return;
            }
        }
        f34259b = new RouterManager();
    }

    public RouterManager() {
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
        this.f34260c = new ArrayList<>();
    }

    private void a(Context context, HashMap<String, Object> hashMap) {
        ArrayList<ApplicationLogicWrapper> arrayList;
        BaseApplicationLogic baseApplicationLogic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, context, hashMap) == null) || (arrayList = this.f34260c) == null || arrayList.size() < 1) {
            return;
        }
        Iterator<ApplicationLogicWrapper> it = this.f34260c.iterator();
        while (it.hasNext()) {
            ApplicationLogicWrapper next = it.next();
            if (next != null) {
                try {
                    next.instance = next.logicClass.newInstance();
                } catch (IllegalAccessException unused) {
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
                if (next != null && (baseApplicationLogic = next.instance) != null) {
                    baseApplicationLogic.onCreate(context, hashMap);
                }
            }
        }
    }

    public static RouterManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f34259b : (RouterManager) invokeV.objValue;
    }

    public void init(Context context, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, hashMap) == null) {
            if (context == null) {
                throw new RuntimeException("Router manager init with context null");
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                throw new RuntimeException("Router manager init with applciation context null");
            }
            LogUtil.d(a, "Application onCreate start: " + System.currentTimeMillis());
            LocalRouter.init(applicationContext);
            a(applicationContext, hashMap);
            LogUtil.d(a, "Application onCreate end: " + System.currentTimeMillis());
        }
    }

    public boolean registerApplicationLogic(Class<? extends BaseApplicationLogic> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            ArrayList<ApplicationLogicWrapper> arrayList = this.f34260c;
            if (arrayList != null) {
                Iterator<ApplicationLogicWrapper> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().logicClass.equals(cls)) {
                        throw new RuntimeException(cls.getName() + " has registered.");
                    }
                }
                this.f34260c.add(new ApplicationLogicWrapper(cls));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void registerProvider(String str, RouterProvider routerProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, routerProvider) == null) {
            LocalRouter.getInstance().a(str, routerProvider);
        }
    }

    public void route(Context context, RouterRequest routerRequest, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, routerRequest, routerCallback) == null) {
            LocalRouter.getInstance().a(context, routerRequest, routerCallback);
        }
    }
}
