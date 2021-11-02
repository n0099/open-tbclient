package b.a.p0.a.u.e.n;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
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
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0410a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8335a;

        public C0410a(a aVar) {
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
                    return;
                }
            }
            this.f8335a = aVar;
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(e eVar, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) ? this.f8335a.x(eVar, jSONObject, str) : (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8336a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8337b;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8337b = aVar;
            this.f8336a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f8337b.u(this.f8336a, exc == null ? "" : exc.getMessage());
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
                this.f8337b.d(this.f8336a, this.f8337b.w(response));
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public final Pair<Request, Integer> s(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, jSONObject)) == null) {
            RequestBody v = v(eVar, jSONObject);
            if (v == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(b.a.p0.a.c1.a.R().b()).post(v).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public final void t(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str) == null) {
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(request.url().toString(), request.body(), new b(this, str));
            aVar.f11041i = request.tag();
            aVar.f11038f = true;
            aVar.f11039g = true;
            aVar.f11040h = true;
            b.a.p0.m.e.a.g().e(aVar);
        }
    }

    public final void u(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            d(str, new b.a.p0.a.u.h.b(500106, str2));
        }
    }

    public final RequestBody v(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String k = eVar.k();
            String optString2 = jSONObject.optString("templateId");
            if (TextUtils.isEmpty(k) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return null;
            }
            return new FormBody.Builder().add("appkey", k).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
        }
        return (RequestBody) invokeLL.objValue;
    }

    public b.a.p0.a.u.h.b w(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    String string = response.body().string();
                    boolean z = d.f8000c;
                    JSONObject jSONObject = new JSONObject(string);
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new b.a.p0.a.u.h.b(0, optJSONObject, false);
                    }
                    return new b.a.p0.a.u.h.b(500106, "subscribe fail");
                } catch (Exception e2) {
                    if (d.f8000c) {
                        e2.printStackTrace();
                    }
                    return new b.a.p0.a.u.h.b(500106, Log.getStackTraceString(e2));
                }
            }
            return new b.a.p0.a.u.h.b(500106, "response body is null");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b x(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, eVar, jSONObject, str)) == null) {
            Pair<Request, Integer> s = s(eVar, jSONObject);
            Request request = (Request) s.first;
            if (request == null) {
                return new b.a.p0.a.u.h.b(((Integer) s.second).intValue(), "params error");
            }
            t(request, str);
            return new b.a.p0.a.u.h.b(0, "success");
        }
        return (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (d.f8000c) {
                String str2 = "subscribe with json string:  " + str;
            }
            return i(str, true, new C0410a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
