package b.a.p0.a.u.e.m;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.d2.e;
import b.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.u.e.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f8848a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8848a = cVar;
        }

        @Override // b.a.p0.a.u.c.d.a
        public b.a.p0.a.u.h.b a(e eVar, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) ? this.f8848a.E(eVar, jSONObject, str) : (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8849a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8850b;

        public b(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8850b = cVar;
            this.f8849a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f8850b.B(this.f8849a, exc == null ? "" : exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f8850b.d(this.f8849a, this.f8850b.D(response));
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, str) == null) {
            b.a.p0.p.d.a aVar = new b.a.p0.p.d.a(request.url().toString(), request.body(), new b(this, str));
            aVar.f11728i = request.tag();
            aVar.f11725f = true;
            aVar.f11726g = true;
            aVar.f11727h = true;
            b.a.p0.p.e.a.g().e(aVar);
        }
    }

    public final void B(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            d(str, new b.a.p0.a.u.h.b(500106, str2));
        }
    }

    public final RequestBody C(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String N = eVar.N();
            String optString2 = jSONObject.optString("templateId");
            if (TextUtils.isEmpty(N) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return null;
            }
            return new FormBody.Builder().add("appkey", N).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
        }
        return (RequestBody) invokeLL.objValue;
    }

    public b.a.p0.a.u.h.b D(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new b.a.p0.a.u.h.b(0, optJSONObject, false);
                    }
                    return new b.a.p0.a.u.h.b(500106, "subscribe fail");
                } catch (Exception e2) {
                    return new b.a.p0.a.u.h.b(500106, Log.getStackTraceString(e2));
                }
            }
            return new b.a.p0.a.u.h.b(500106, "response body is null");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b E(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, eVar, jSONObject, str)) == null) {
            Pair<Request, Integer> z = z(eVar, jSONObject);
            Request request = (Request) z.first;
            if (request == null) {
                return new b.a.p0.a.u.h.b(((Integer) z.second).intValue(), "params error");
            }
            A(request, str);
            return new b.a.p0.a.u.h.b(0, "success");
        }
        return (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public b.a.p0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#subscribe params=" + str, false);
            return l(str, true, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "SubscribeServiceApi" : (String) invokeV.objValue;
    }

    public final Pair<Request, Integer> z(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, eVar, jSONObject)) == null) {
            RequestBody C = C(eVar, jSONObject);
            if (C == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(b.a.p0.a.c1.a.W().a()).post(C).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }
}
