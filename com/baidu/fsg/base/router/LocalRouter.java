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
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LocalRouter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5246a = "LocalRouter";

    /* renamed from: b  reason: collision with root package name */
    public static LocalRouter f5247b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, RouterProvider> f5248c;

    /* renamed from: d  reason: collision with root package name */
    public Context f5249d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750556754, "Lcom/baidu/fsg/base/router/LocalRouter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750556754, "Lcom/baidu/fsg/base/router/LocalRouter;");
        }
    }

    public LocalRouter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5248c = null;
        this.f5249d = context;
        this.f5248c = new HashMap<>();
    }

    public static synchronized LocalRouter getInstance() {
        InterceptResult invokeV;
        LocalRouter localRouter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (LocalRouter.class) {
                if (f5247b != null) {
                    localRouter = f5247b;
                } else {
                    throw new RuntimeException("Local Router must be init first");
                }
            }
            return localRouter;
        }
        return (LocalRouter) invokeV.objValue;
    }

    public static synchronized LocalRouter init(Context context) {
        InterceptResult invokeL;
        LocalRouter localRouter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            synchronized (LocalRouter.class) {
                if (f5247b == null) {
                    f5247b = new LocalRouter(context);
                }
                localRouter = f5247b;
            }
            return localRouter;
        }
        return (LocalRouter) invokeL.objValue;
    }

    public void a(String str, RouterProvider routerProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, routerProvider) == null) {
            this.f5248c.put(str, routerProvider);
        }
    }

    public void a(Context context, RouterRequest routerRequest, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, routerRequest, routerCallback) == null) {
            LogUtil.d("LocalRouter", "Process:Local route start: " + System.currentTimeMillis());
            LogUtil.d("LocalRouter", "Process:Local find action start: " + System.currentTimeMillis());
            RouterAction a2 = a(routerRequest);
            LogUtil.d("LocalRouter", "Process:Local find action end: " + System.currentTimeMillis());
            try {
                a2.invoke(context, routerRequest.getData(), routerCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                HashMap hashMap = new HashMap();
                hashMap.put("retMsg", e2.getMessage());
                routerCallback.onResult(RouterCallback.CODE_ERROR, hashMap);
            }
            LogUtil.d("LocalRouter", "Process:Local route end: " + System.currentTimeMillis());
        }
    }

    private RouterAction a(RouterRequest routerRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, routerRequest)) == null) {
            RouterProvider routerProvider = this.f5248c.get(routerRequest.getProvider());
            ErrorAction errorAction = new ErrorAction();
            if (routerProvider == null) {
                for (RouterProvider routerProvider2 : this.f5248c.values()) {
                    RouterAction findAction = routerProvider2.findAction(routerRequest.getAction());
                    if (findAction != null) {
                        return findAction;
                    }
                }
                return errorAction;
            }
            return routerProvider.findAction(routerRequest.getAction());
        }
        return (RouterAction) invokeL.objValue;
    }
}
