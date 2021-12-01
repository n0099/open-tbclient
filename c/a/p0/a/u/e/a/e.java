package c.a.p0.a.u.e.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.h2.c.i;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.p0.a.u.e.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8087f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f8089f;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8089f = eVar;
            this.f8088e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.p0.a.u.h.b bVar = new c.a.p0.a.u.h.b();
                String z = this.f8089f.z(iVar);
                if (TextUtils.isEmpty(z)) {
                    bVar.f8485b = 1001;
                    bVar.f8486c = "openid is empty";
                    this.f8089f.d(this.f8088e, bVar);
                    return;
                }
                bVar.g("openid", z);
                bVar.f8485b = 0;
                this.f8089f.d(this.f8088e, bVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123084063, "Lc/a/p0/a/u/e/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123084063, "Lc/a/p0/a/u/e/a/e;");
                return;
            }
        }
        f8087f = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "OpenIdApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getOpenId", false);
            if (f8087f) {
                String str2 = "#getOpenId params = " + str;
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            if (!((c.a.p0.a.u.h.b) s.first).isSuccess()) {
                return (c.a.p0.a.u.h.b) s.first;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.p0.a.u.h.b(202, "cb is empty");
            }
            c.a.p0.a.h2.c.j.d f2 = c.a.p0.a.d2.d.J().y().a().b().f(c.a.p0.a.d2.d.J());
            f2.o(new a(this, optString));
            f2.call();
            return c.a.p0.a.u.h.b.f();
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final String z(i<JSONObject> iVar) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar)) == null) ? (!iVar.c() || (jSONObject = iVar.a) == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) ? "" : optJSONObject.optString("openid") : (String) invokeL.objValue;
    }
}
