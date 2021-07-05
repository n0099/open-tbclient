package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class APSecuritySdk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static APSecuritySdk f1727a;

    /* renamed from: c  reason: collision with root package name */
    public static Object f1728c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f1729b;

    /* loaded from: classes.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* loaded from: classes.dex */
    public class TokenResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ APSecuritySdk f1733a;
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult(APSecuritySdk aPSecuritySdk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aPSecuritySdk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1733a = aPSecuritySdk;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(671428337, "Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(671428337, "Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;");
                return;
            }
        }
        f1728c = new Object();
    }

    public APSecuritySdk(Context context) {
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
        this.f1729b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f1727a == null) {
                synchronized (f1728c) {
                    if (f1727a == null) {
                        f1727a = new APSecuritySdk(context);
                    }
                }
            }
            return f1727a;
        }
        return (APSecuritySdk) invokeL.objValue;
    }

    public static String getUtdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? UtdidWrapper.getUtdid(context) : (String) invokeL.objValue;
    }

    public String getApdidToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = a.a(this.f1729b, "");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                initToken(0, new HashMap(), null);
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public String getSdkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "APPSecuritySDK-ALIPAYSDK" : (String) invokeV.objValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "3.3.0.1905151001" : (String) invokeV.objValue;
    }

    public synchronized TokenResult getTokenResult() {
        InterceptResult invokeV;
        TokenResult tokenResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                tokenResult = new TokenResult(this);
                try {
                    tokenResult.apdidToken = a.a(this.f1729b, "");
                    tokenResult.clientKey = h.f(this.f1729b);
                    tokenResult.apdid = a.a(this.f1729b);
                    tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f1729b);
                    if (com.alipay.security.mobile.module.a.a.a(tokenResult.apdid) || com.alipay.security.mobile.module.a.a.a(tokenResult.apdidToken) || com.alipay.security.mobile.module.a.a.a(tokenResult.clientKey)) {
                        initToken(0, new HashMap(), null);
                    }
                } catch (Throwable unused) {
                }
            }
            return tokenResult;
        }
        return (TokenResult) invokeV.objValue;
    }

    public void initToken(int i2, Map<String, String> map, InitResultListener initResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, map, initResultListener) == null) {
            com.alipay.apmobilesecuritysdk.b.a.a().a(i2);
            String b2 = h.b(this.f1729b);
            String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
            if (com.alipay.security.mobile.module.a.a.b(b2) && !com.alipay.security.mobile.module.a.a.a(b2, c2)) {
                com.alipay.apmobilesecuritysdk.e.a.a(this.f1729b);
                d.a(this.f1729b);
                g.a(this.f1729b);
                i.h();
            }
            if (!com.alipay.security.mobile.module.a.a.a(b2, c2)) {
                h.c(this.f1729b, c2);
            }
            String a2 = com.alipay.security.mobile.module.a.a.a(map, b.f1846g, "");
            String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
            String a4 = com.alipay.security.mobile.module.a.a.a(map, "userId", "");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                a2 = UtdidWrapper.getUtdid(this.f1729b);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(b.f1846g, a2);
            hashMap.put("tid", a3);
            hashMap.put("userId", a4);
            hashMap.put("appName", "");
            hashMap.put("appKeyClient", "");
            hashMap.put("appchannel", "");
            hashMap.put("rpcVersion", "8");
            com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable(this, hashMap, initResultListener) { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f1730a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ InitResultListener f1731b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ APSecuritySdk f1732c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap, initResultListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f1732c = this;
                    this.f1730a = hashMap;
                    this.f1731b = initResultListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new a(this.f1732c.f1729b).a(this.f1730a);
                        InitResultListener initResultListener2 = this.f1731b;
                        if (initResultListener2 != null) {
                            initResultListener2.onResult(this.f1732c.getTokenResult());
                        }
                    }
                }
            });
        }
    }
}
