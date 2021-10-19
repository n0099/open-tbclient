package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import com.alipay.security.mobile.module.a.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class TMNTokenClient {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static TMNTokenClient f35846a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f35847b;

    /* loaded from: classes4.dex */
    public interface InitResultListener {
        void onResult(String str, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1840349387, "Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1840349387, "Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;");
        }
    }

    public TMNTokenClient(Context context) {
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
        this.f35847b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.f35847b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f35846a == null) {
                synchronized (TMNTokenClient.class) {
                    if (f35846a == null) {
                        f35846a = new TMNTokenClient(context);
                    }
                }
            }
            return f35846a;
        }
        return (TMNTokenClient) invokeL.objValue;
    }

    public void intiToken(String str, String str2, String str3, InitResultListener initResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, initResultListener) == null) {
            if (a.a(str) && initResultListener != null) {
                initResultListener.onResult("", 2);
            }
            if (a.a(str2) && initResultListener != null) {
                initResultListener.onResult("", 3);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(b.f35977g, UtdidWrapper.getUtdid(this.f35847b));
            hashMap.put("tid", "");
            hashMap.put("userId", "");
            hashMap.put("appName", str);
            hashMap.put("appKeyClient", str2);
            hashMap.put("appchannel", "openapi");
            hashMap.put("sessionId", str3);
            hashMap.put("rpcVersion", "8");
            com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable(this, hashMap, initResultListener, str) { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f35848a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ InitResultListener f35849b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f35850c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TMNTokenClient f35851d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap, initResultListener, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35851d = this;
                    this.f35848a = hashMap;
                    this.f35849b = initResultListener;
                    this.f35850c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int a2 = new com.alipay.apmobilesecuritysdk.a.a(this.f35851d.f35847b).a(this.f35848a);
                        InitResultListener initResultListener2 = this.f35849b;
                        if (initResultListener2 == null) {
                            return;
                        }
                        if (a2 != 0) {
                            initResultListener2.onResult("", a2);
                            return;
                        }
                        this.f35849b.onResult(com.alipay.apmobilesecuritysdk.a.a.a(this.f35851d.f35847b, this.f35850c), 0);
                    }
                }
            });
        }
    }
}
