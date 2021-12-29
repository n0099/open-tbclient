package c.a.r0.a.u.d;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.e;
import c.a.r0.a.p1.f;
import c.a.r0.a.u.c.d;
import c.a.r0.a.u.h.b;
import c.a.r0.a.z2.w;
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

    /* renamed from: c.a.r0.a.u.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0551a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f9105b;

        public C0551a(a aVar, String str) {
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
            this.f9105b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (jSONObject == null) {
                    this.f9105b.d(this.a, new b(1001, "server response fail"));
                    return;
                }
                int optInt = jSONObject.optInt("errno", 10002);
                String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                if (optInt != 0) {
                    this.f9105b.d(this.a, new b(optInt, optString));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f9105b.d(this.a, new b(optInt, optString));
                    return;
                }
                this.f9105b.d(this.a, new b(0, optString, optJSONObject));
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
                a aVar = this.f9105b;
                String str = this.a;
                aVar.d(str, new b(1001, "operation fail, msg = " + exc.getMessage()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.r0.a.u.c.b bVar) {
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

    public final void A(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, eVar) == null) {
            c.a.r0.a.n2.s.e eVar2 = new c.a.r0.a.n2.s.e();
            eVar2.a = "swan";
            eVar2.f8157b = str;
            eVar2.f8161f = eVar.N();
            eVar2.a("host_app", c.a.r0.a.c1.a.n().a());
            c.a.r0.a.n2.b.i("2267", "83", eVar2.f());
        }
    }

    public final b B(String str, FormBody.Builder builder, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, builder, str2)) == null) {
            c.a.r0.a.p1.d a = c.a.r0.a.p1.d.a(builder.build(), f.f8449b);
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                return new b(202);
            }
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(y, a, new C0551a(this, str2));
            if (c.a.r0.p.e.a.g().c()) {
                aVar.f11718f = true;
            }
            aVar.f11719g = true;
            c.a.r0.p.e.a.g().e(aVar);
            return b.f();
        }
        return (b) invokeLLL.objValue;
    }

    public b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#takeCoupons", false);
            e a0 = e.a0();
            if (a0 == null) {
                return new b(1001, "SwanApp is null");
            }
            A("coupons_take", a0);
            if (!c.a.r0.a.u.e.a.b.y(getContext())) {
                return new b(10007, "is not baidu account");
            }
            if (!a0.M().e(getContext())) {
                return new b(10004, "user not logged in");
            }
            Pair<b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("promotionId");
                if (TextUtils.isEmpty(optString)) {
                    return new b(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", e.f0());
                builder.add("promotionId", optString);
                return B("takeCoupons", builder, optString2);
            }
            return new b(202);
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "Coupon" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanAppCouponApi" : (String) invokeV.objValue;
    }

    public b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getPlatformCoupons", false);
            e a0 = e.a0();
            if (a0 == null) {
                return new b(202, "SwanApp is null");
            }
            A("coupons_appkey", a0);
            if (!c.a.r0.a.u.e.a.b.y(getContext())) {
                return new b(10007, "is not baidu account");
            }
            Pair<b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new b(202, "couponAppKey is invalid");
                }
                boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
                if (optBoolean) {
                    A("coupons_appkey_user", a0);
                    if (!a0.M().e(getContext())) {
                        return new b(10004, "user not logged in");
                    }
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", e.f0());
                builder.add("couponAppKey", optString);
                builder.add("withUserCoupons", String.valueOf(optBoolean));
                return B("getPlatformCoupons", builder, optString2);
            }
            return new b(202);
        }
        return (b) invokeL.objValue;
    }

    public final String y(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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
                    return c.a.r0.a.c1.a.o().j();
                }
                return c.a.r0.a.c1.a.o().f();
            }
            return c.a.r0.a.c1.a.o().K();
        }
        return (String) invokeL.objValue;
    }

    public b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getUserCoupons", false);
            e a0 = e.a0();
            if (a0 == null) {
                return new b(1001, "SwanApp is null");
            }
            A("coupons_user", a0);
            if (!c.a.r0.a.u.e.a.b.y(getContext())) {
                return new b(10007, "is not baidu account");
            }
            if (!a0.M().e(getContext())) {
                return new b(10004, "user not logged in");
            }
            Pair<b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new b(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", e.f0());
                builder.add("couponAppKey", optString);
                return B("getUserCoupons", builder, optString2);
            }
            return new b(202);
        }
        return (b) invokeL.objValue;
    }
}
