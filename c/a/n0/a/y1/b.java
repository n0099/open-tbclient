package c.a.n0.a.y1;

import c.a.n0.a.a2.d;
import c.a.n0.a.g1.f;
import c.a.n0.a.k;
import c.a.n0.a.v2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9575a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends ResponseCallback<c.a.n0.a.y1.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0464b f9576a;

        public a(InterfaceC0464b interfaceC0464b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0464b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9576a = interfaceC0464b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.n0.a.y1.a aVar, int i2) {
            InterfaceC0464b interfaceC0464b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || (interfaceC0464b = this.f9576a) == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0464b.a(null);
            } else {
                interfaceC0464b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.n0.a.y1.a parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                    return null;
                }
                if (b.f9575a) {
                    String str = "parseResponse: RelateSwanData" + optJSONObject.toString();
                }
                return c.a.n0.a.y1.a.a(optJSONObject);
            }
            return (c.a.n0.a.y1.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0464b interfaceC0464b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (interfaceC0464b = this.f9576a) == null) {
                return;
            }
            interfaceC0464b.a(null);
        }
    }

    /* renamed from: c.a.n0.a.y1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0464b {
        void a(c.a.n0.a.y1.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1227763675, "Lc/a/n0/a/y1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1227763675, "Lc/a/n0/a/y1/b;");
                return;
            }
        }
        f9575a = k.f6803a;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SwanCoreVersion N = f.V().N();
            String h2 = c.a.n0.n.i.f.h(c.a.n0.a.c1.a.n().I());
            HashMap hashMap = new HashMap(4);
            hashMap.put("appkey", d.g().getAppId());
            hashMap.put("swan_core_ver", c.a.n0.a.m2.b.i(N, d.g().l()));
            hashMap.put("swan_game_ver", c.a.n0.a.m2.b.h(1));
            hashMap.put("uid", c.a.n0.a.c1.a.a0().i(c.a.n0.a.c1.a.b()));
            return o0.b(h2, hashMap);
        }
        return (String) invokeV.objValue;
    }

    public static void c(InterfaceC0464b interfaceC0464b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, interfaceC0464b) == null) {
            c.a.n0.m.d.a aVar = new c.a.n0.m.d.a(b(), new a(interfaceC0464b));
            if (c.a.n0.m.e.a.g().c()) {
                aVar.f11571f = true;
            }
            aVar.f11572g = true;
            c.a.n0.m.e.a.g().d(aVar);
        }
    }
}
