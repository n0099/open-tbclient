package c.a.r0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.r0.a.u.e.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9232b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9233c;

        public a(b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9233c = bVar;
            this.a = str;
            this.f9232b = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.r0.a.e0.d.i("CallServiceApi", "Cloud capability request failed: " + this.a + StringUtils.LF + Log.getStackTraceString(exc));
                b bVar = this.f9233c;
                String str2 = this.f9232b;
                if (TextUtils.isEmpty(exc.getMessage())) {
                    str = "请求失败";
                } else {
                    str = exc.getMessage() + "";
                }
                bVar.d(str2, new c.a.r0.a.u.h.b(1001, str));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, String.valueOf(i2));
                    jSONObject2.put("data", jSONObject);
                } catch (JSONException e2) {
                    c.a.r0.a.e0.d.b("CallServiceApi", Log.getStackTraceString(e2));
                }
                c.a.r0.a.e0.d.b("CallServiceApi", "Cloud capability '" + this.a + "' request success: data:" + jSONObject2.toString());
                this.f9233c.d(this.f9232b, new c.a.r0.a.u.h.b(0, jSONObject2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CallServiceApi" : (String) invokeV.objValue;
    }

    public c.a.r0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#callService", false);
            if (c.a.r0.a.d2.e.a0() == null) {
                c.a.r0.a.e0.d.b("CallServiceApi", "swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.e0.d.b("CallServiceApi", "cb is empty");
                    return new c.a.r0.a.u.h.b(201, "cb is empty");
                }
                String optString2 = jSONObject.optString("service");
                if (TextUtils.isEmpty(optString2)) {
                    c.a.r0.a.e0.d.b("CallServiceApi", "service is empty");
                    return new c.a.r0.a.u.h.b(201, "service is empty");
                }
                y(optString2, jSONObject.optJSONObject("data"), optString);
                return new c.a.r0.a.u.h.b(0);
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final void y(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, str2) == null) {
            c cVar = new c();
            cVar.g(str);
            cVar.f(jSONObject);
            cVar.c(new a(this, str, str2));
        }
    }
}
