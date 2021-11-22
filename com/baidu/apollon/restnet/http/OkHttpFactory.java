package com.baidu.apollon.restnet.http;

import b.c.b.u;
import b.c.b.w;
import b.c.b.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLStreamHandler;
/* loaded from: classes6.dex */
public class OkHttpFactory implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final x f36946a;

    /* renamed from: b  reason: collision with root package name */
    public URLStreamHandler f36947b;

    /* renamed from: com.baidu.apollon.restnet.http.OkHttpFactory$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final OkHttpFactory f36948a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1965121819, "Lcom/baidu/apollon/restnet/http/OkHttpFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1965121819, "Lcom/baidu/apollon/restnet/http/OkHttpFactory$a;");
                    return;
                }
            }
            f36948a = new OkHttpFactory(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ OkHttpFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static OkHttpFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f36948a : (OkHttpFactory) invokeV.objValue;
    }

    public w client() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36946a.a() : (w) invokeV.objValue;
    }

    public URLStreamHandler getURLStreamHandler(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if ("http".equals(str) || "https".equals(str)) {
                if (this.f36947b == null) {
                    this.f36947b = this.f36946a.createURLStreamHandler(str);
                }
                return this.f36947b;
            }
            return null;
        }
        return (URLStreamHandler) invokeL.objValue;
    }

    public void setClient(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) || wVar == null) {
            return;
        }
        this.f36946a.f(wVar);
    }

    public OkHttpFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        w.b t = new w().t();
        t.e(new u(d.a()));
        t.h(b.f36958e);
        this.f36946a = new x(t.a());
    }
}
