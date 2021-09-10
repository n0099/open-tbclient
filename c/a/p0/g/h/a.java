package c.a.p0.g.h;

import android.text.TextUtils;
import c.a.p0.a.h;
import c.a.p0.a.z1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import com.baidu.swan.gamecenter.network.models.ReservationGameResultData;
import com.baidu.swan.gamecenter.network.models.ResultData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Gson f10940a;

    /* renamed from: c.a.p0.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0548a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.g.h.b f10941a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10942b;

        /* renamed from: c.a.p0.g.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0549a extends TypeToken<ResultData<ReservationGameResultData>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0549a(C0548a c0548a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0548a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public C0548a(a aVar, c.a.p0.g.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10942b = aVar;
            this.f10941a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || TextUtils.isEmpty(str) || this.f10941a == null) {
                return;
            }
            ResultData resultData = (ResultData) this.f10942b.f10940a.fromJson(str, new C0549a(this).getType());
            if (resultData == null) {
                this.f10941a.onFail("result is null");
            } else if (resultData.errno == 0) {
                T t = resultData.data;
                if (t != 0 && ((ReservationGameResultData) t).apps != null) {
                    this.f10941a.onSuccess(((ReservationGameResultData) t).apps);
                    return;
                }
                this.f10941a.onFail("result data is null");
            } else {
                c.a.p0.g.h.b bVar = this.f10941a;
                if (bVar != null) {
                    bVar.onFail(resultData.errmsg);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            c.a.p0.g.h.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) || (bVar = this.f10941a) == null) {
                return;
            }
            bVar.onFail(exc.toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f10943a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1486848915, "Lc/a/p0/g/h/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1486848915, "Lc/a/p0/g/h/a$c;");
                    return;
                }
            }
            f10943a = new a(null);
        }
    }

    public /* synthetic */ a(C0548a c0548a) {
        this();
    }

    public static final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f10943a : (a) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                e.f(AppRuntime.getAppContext(), h.aiapps_net_error).F();
            } else if (TextUtils.isEmpty(str)) {
            } else {
                String l = c.a.p0.h.t.a.b().l();
                c.a.p0.a.e2.c.h a2 = c.a.p0.a.c1.a.p().a();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", Long.valueOf(str));
                    c.a.p0.m.e.a.g().getRequest().cookieManager(a2).url(l).addUrlParam("data", jSONObject.toString()).build().executeAsync(new b(this));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void d(c.a.p0.g.h.b<List<ReservationGameInfo>> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            String b2 = c.a.p0.h.t.a.b().b();
            c.a.p0.a.e2.c.h a2 = c.a.p0.a.c1.a.p().a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 2);
                c.a.p0.m.e.a.g().getRequest().cookieManager(a2).url(b2).addUrlParam("data", jSONObject.toString()).build().executeAsync(new C0548a(this, bVar));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public a() {
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
        this.f10940a = new Gson();
    }
}
