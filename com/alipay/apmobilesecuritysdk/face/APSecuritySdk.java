package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
    public static APSecuritySdk f1761a;

    /* renamed from: c  reason: collision with root package name */
    public static Object f1762c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f1763b;

    /* loaded from: classes.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* loaded from: classes.dex */
    public class TokenResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ APSecuritySdk f1767a;
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
            this.f1767a = aPSecuritySdk;
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
        f1762c = new Object();
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
        this.f1763b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f1761a == null) {
                synchronized (f1762c) {
                    if (f1761a == null) {
                        f1761a = new APSecuritySdk(context);
                    }
                }
            }
            return f1761a;
        }
        return (APSecuritySdk) invokeL.objValue;
    }

    public static String getUtdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? UtdidWrapper.getUtdid(context) : (String) invokeL.objValue;
    }

    public String getApdidToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = a.a(this.f1763b, "");
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
                    tokenResult.apdidToken = a.a(this.f1763b, "");
                    tokenResult.clientKey = h.f(this.f1763b);
                    tokenResult.apdid = a.a(this.f1763b);
                    tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f1763b);
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
            String b2 = h.b(this.f1763b);
            String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
            if (com.alipay.security.mobile.module.a.a.b(b2) && !com.alipay.security.mobile.module.a.a.a(b2, c2)) {
                com.alipay.apmobilesecuritysdk.e.a.a(this.f1763b);
                d.a(this.f1763b);
                g.a(this.f1763b);
                i.h();
            }
            if (!com.alipay.security.mobile.module.a.a.a(b2, c2)) {
                h.c(this.f1763b, c2);
            }
            String a2 = com.alipay.security.mobile.module.a.a.a(map, b.f1880g, "");
            String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
            String a4 = com.alipay.security.mobile.module.a.a.a(map, "userId", "");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                a2 = UtdidWrapper.getUtdid(this.f1763b);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(b.f1880g, a2);
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
                public final /* synthetic */ Map f1764a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ InitResultListener f1765b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ APSecuritySdk f1766c;

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
                    this.f1766c = this;
                    this.f1764a = hashMap;
                    this.f1765b = initResultListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new a(this.f1766c.f1763b).a(this.f1764a);
                        InitResultListener initResultListener2 = this.f1765b;
                        if (initResultListener2 != null) {
                            initResultListener2.onResult(this.f1766c.getTokenResult());
                        }
                    }
                }
            });
        }
    }
}
