package c.a.n0.a.r1;

import android.util.Log;
import c.a.n0.a.p2.o0;
import c.a.n0.a.t1.d;
import c.a.n0.a.w0.f;
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
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends ResponseCallback<c.a.n0.a.r1.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterfaceC0435b a;

        public a(InterfaceC0435b interfaceC0435b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0435b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC0435b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.n0.a.r1.a aVar, int i) {
            InterfaceC0435b interfaceC0435b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) || (interfaceC0435b = this.a) == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0435b.a(null);
            } else {
                interfaceC0435b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.n0.a.r1.a parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                    return null;
                }
                if (b.a) {
                    Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
                }
                return c.a.n0.a.r1.a.a(optJSONObject);
            }
            return (c.a.n0.a.r1.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0435b interfaceC0435b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (interfaceC0435b = this.a) == null) {
                return;
            }
            interfaceC0435b.a(null);
        }
    }

    /* renamed from: c.a.n0.a.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0435b {
        void a(c.a.n0.a.r1.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1221299028, "Lc/a/n0/a/r1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1221299028, "Lc/a/n0/a/r1/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SwanCoreVersion M = f.U().M();
            String i = c.a.n0.q.i.f.i(c.a.n0.a.s0.a.o().L());
            HashMap hashMap = new HashMap(4);
            hashMap.put("appkey", d.J().getAppId());
            hashMap.put("swan_core_ver", c.a.n0.a.g2.b.i(M, d.J().l()));
            hashMap.put("swan_game_ver", c.a.n0.a.g2.b.h(1));
            hashMap.put("uid", c.a.n0.a.s0.a.h0().i(c.a.n0.a.s0.a.c()));
            return o0.b(i, hashMap);
        }
        return (String) invokeV.objValue;
    }

    public static void c(InterfaceC0435b interfaceC0435b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, interfaceC0435b) == null) {
            c.a.n0.p.d.a aVar = new c.a.n0.p.d.a(b(), new a(interfaceC0435b));
            if (c.a.n0.p.e.a.g().c()) {
                aVar.f9110f = true;
            }
            aVar.f9111g = true;
            c.a.n0.p.e.a.g().d(aVar);
        }
    }
}
