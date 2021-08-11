package c.a.n0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.u.e.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0396a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8680b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8681c;

        public C0396a(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8681c = aVar;
            this.f8679a = str;
            this.f8680b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("statusCode", String.valueOf(i2));
                    jSONObject2.put("data", jSONObject);
                } catch (JSONException e2) {
                    c.a.n0.a.e0.d.a("CallServiceApi", Log.getStackTraceString(e2));
                }
                c.a.n0.a.e0.d.a("CallServiceApi", "Cloud capability '" + this.f8679a + "' request success: data:" + jSONObject2.toString());
                this.f8681c.d(this.f8680b, new c.a.n0.a.u.h.b(0, jSONObject2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                c.a.n0.a.e0.d.g("CallServiceApi", "Cloud capability request failed: " + this.f8679a + StringUtils.LF + Log.getStackTraceString(exc));
                a aVar = this.f8681c;
                String str2 = this.f8680b;
                if (TextUtils.isEmpty(exc.getMessage())) {
                    str = "请求失败";
                } else {
                    str = exc.getMessage() + "";
                }
                aVar.d(str2, new c.a.n0.a.u.h.b(1001, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.n0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (c.a.n0.a.a2.e.Q() == null) {
                c.a.n0.a.e0.d.a("CallServiceApi", "swan app is null");
                return new c.a.n0.a.u.h.b(1001, "swan app is null");
            }
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("CallServiceApi", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.n0.a.e0.d.a("CallServiceApi", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.e0.d.a("CallServiceApi", "callback is null");
                return new c.a.n0.a.u.h.b(201, "callback is null");
            }
            String optString2 = jSONObject.optString("service");
            if (TextUtils.isEmpty(optString2)) {
                c.a.n0.a.e0.d.a("CallServiceApi", "service is empty");
                return new c.a.n0.a.u.h.b(201, "service is empty");
            }
            s(optString2, jSONObject.optJSONObject("data"), optString);
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void s(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, str2) == null) {
            b bVar = new b();
            bVar.g(str);
            bVar.f(jSONObject);
            bVar.c(new C0396a(this, str, str2));
        }
    }
}
