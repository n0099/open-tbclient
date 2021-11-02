package b.a.p0.a.e0.h.c;

import b.a.p0.a.e0.h.c.c;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f4763b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1710325413, "Lb/a/p0/a/e0/h/c/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1710325413, "Lb/a/p0/a/e0/h/c/d$a;");
                    return;
                }
            }
            f4763b = k.f6397a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.a aVar) {
            super(aVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // b.a.p0.a.e0.h.c.c.b
        public Map<String, String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Upgrade", "websocket");
                hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
                try {
                    hashMap.put("Sec-WebSocket-Accept", b.a.p0.a.e0.h.d.a.g(this.f4762a.f4757a.get("sec-websocket-key")));
                } catch (NoSuchAlgorithmException unused) {
                    boolean z = f4763b;
                }
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        @Override // b.a.p0.a.e0.h.c.c.b
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "101 Switching Protocols" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f4764b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c.a aVar) {
            super(aVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.a.p0.a.e0.h.c.c.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f4764b == null) {
                    this.f4764b = new b.a.p0.a.e0.h.b().toString();
                }
                return this.f4764b;
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.p0.a.e0.h.c.c.b
        public Map<String, String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json; charset=UTF-8");
                hashMap.put(Util.ACCEPT_RANGES, "bytes");
                hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        @Override // b.a.p0.a.e0.h.c.c.b
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "200 OK" : (String) invokeV.objValue;
        }
    }

    public static c.b a(c.a aVar) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            if (aVar == null || (map = aVar.f4757a) == null || map.size() < 1) {
                return null;
            }
            if (b.a.p0.a.e0.h.d.a.f(aVar.f4757a)) {
                aVar.f4761e = true;
                return new a(aVar);
            }
            aVar.f4761e = false;
            return new b(aVar);
        }
        return (c.b) invokeL.objValue;
    }
}
