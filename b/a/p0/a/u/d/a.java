package b.a.p0.a.u.d;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.n1.f;
import b.a.p0.a.u.c.d;
import b.a.p0.a.u.h.b;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.FormBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0378a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8006a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8007b;

        public C0378a(a aVar, String str) {
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
            this.f8007b = aVar;
            this.f8006a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (jSONObject == null) {
                    this.f8007b.d(this.f8006a, new b(1001, "server response fail"));
                    return;
                }
                int optInt = jSONObject.optInt("errno", 10002);
                String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                if (optInt != 0) {
                    this.f8007b.d(this.f8006a, new b(optInt, optString));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f8007b.d(this.f8006a, new b(optInt, optString));
                    return;
                }
                this.f8007b.d(this.f8006a, new b(0, optString, optJSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            ResponseBody body;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || (body = response.body()) == null) {
                    return null;
                }
                return w.d(body.string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                a aVar = this.f8007b;
                String str = this.f8006a;
                aVar.d(str, new b(1001, "operation fail, msg = " + exc.getMessage()));
            }
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

    public b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.f8000c) {
                String str2 = "handle: " + str;
            }
            e P = e.P();
            if (P == null) {
                return new b(202, "SwanApp is null");
            }
            t("coupons_appkey", P);
            if (!b.a.p0.a.u.e.a.a.r(getContext())) {
                return new b(10007, "is not baidu account");
            }
            Pair<b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            JSONObject jSONObject = (JSONObject) b2.second;
            if (((b) b2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new b(202, "couponAppKey is invalid");
                }
                boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
                if (optBoolean) {
                    t("coupons_appkey_user", P);
                    if (!P.j().e(getContext())) {
                        return new b(10004, "user not logged in");
                    }
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", e.U());
                builder.add("couponAppKey", optString);
                builder.add("withUserCoupons", String.valueOf(optBoolean));
                return u("getPlatformCoupons", builder, optString2);
            }
            return new b(202);
        }
        return (b) invokeL.objValue;
    }

    public final String r(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -1741243770) {
                if (str.equals("takeCoupons")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 15750540) {
                if (hashCode == 1991726820 && str.equals("getPlatformCoupons")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("getUserCoupons")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return null;
                    }
                    return b.a.p0.a.c1.a.n().j();
                }
                return b.a.p0.a.c1.a.n().f();
            }
            return b.a.p0.a.c1.a.n().H();
        }
        return (String) invokeL.objValue;
    }

    public b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.f8000c) {
                String str2 = "handle: " + str;
            }
            e P = e.P();
            if (P == null) {
                return new b(1001, "SwanApp is null");
            }
            t("coupons_user", P);
            if (!b.a.p0.a.u.e.a.a.r(getContext())) {
                return new b(10007, "is not baidu account");
            }
            if (!P.j().e(getContext())) {
                return new b(10004, "user not logged in");
            }
            Pair<b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            JSONObject jSONObject = (JSONObject) b2.second;
            if (((b) b2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new b(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", e.U());
                builder.add("couponAppKey", optString);
                return u("getUserCoupons", builder, optString2);
            }
            return new b(202);
        }
        return (b) invokeL.objValue;
    }

    public final void t(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            b.a.p0.a.j2.p.e eVar2 = new b.a.p0.a.j2.p.e();
            eVar2.f6383a = "swan";
            eVar2.f6384b = str;
            eVar2.f6388f = eVar.k();
            eVar2.a("host_app", b.a.p0.a.c1.a.m().a());
            b.a.p0.a.j2.b.i("2267", "83", eVar2.f());
        }
    }

    public final b u(String str, FormBody.Builder builder, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, builder, str2)) == null) {
            b.a.p0.a.n1.d a2 = b.a.p0.a.n1.d.a(builder.build(), f.f6892b);
            String r = r(str);
            if (TextUtils.isEmpty(r)) {
                return new b(202);
            }
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(r, a2, new C0378a(this, str2));
            if (b.a.p0.m.e.a.g().c()) {
                aVar.f11038f = true;
            }
            aVar.f11039g = true;
            b.a.p0.m.e.a.g().e(aVar);
            return new b(0);
        }
        return (b) invokeLLL.objValue;
    }

    public b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (d.f8000c) {
                String str2 = "handle: " + str;
            }
            e P = e.P();
            if (P == null) {
                return new b(1001, "SwanApp is null");
            }
            t("coupons_take", P);
            if (!b.a.p0.a.u.e.a.a.r(getContext())) {
                return new b(10007, "is not baidu account");
            }
            if (!P.j().e(getContext())) {
                return new b(10004, "user not logged in");
            }
            Pair<b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            JSONObject jSONObject = (JSONObject) b2.second;
            if (((b) b2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("promotionId");
                if (TextUtils.isEmpty(optString)) {
                    return new b(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", e.U());
                builder.add("promotionId", optString);
                return u("takeCoupons", builder, optString2);
            }
            return new b(202);
        }
        return (b) invokeL.objValue;
    }
}
