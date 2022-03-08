package c.a.p0.a.k.e.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.n;
import c.a.p0.a.f.b.a.h;
import c.a.p0.a.x1.c.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.k.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f5878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5879f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5880g;

        public a(c cVar, h hVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5878e = hVar;
            this.f5879f = callbackHandler;
            this.f5880g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar.c() && c.y(iVar.a)) {
                    JSONObject optJSONObject = iVar.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        n.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(iVar.b());
                    this.f5878e.g(this.f5879f, wrapCallbackParams.toString());
                    n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.f5879f.handleSchemeDispatchCallback(this.f5880g, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.k.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            n.T("checkSession", "create");
            h j2 = c.a.p0.a.s0.b.j();
            CallbackHandler h2 = a().h();
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                j2.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            String N = a0.N();
            if (TextUtils.isEmpty(N)) {
                j2.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new c.a.p0.a.k.h.b(1001, "empty app key");
            }
            JSONObject r = c.a.p0.a.k.c.d.r(str);
            if (r == null) {
                j2.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new c.a.p0.a.k.h.b(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j2.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new c.a.p0.a.k.h.b(201, "cb is empty");
            }
            Context context = getContext();
            if (!a0.M().e(context)) {
                j2.g(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                n.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new c.a.p0.a.k.h.b(10004, "user not logged in");
            }
            n.T("checkSession", "checkSession");
            c.a.p0.a.x1.c.j.c g2 = c.a.p0.a.t1.d.J().y().a().b().g(context, N);
            g2.q("checkSession");
            g2.o(new a(this, j2, h2, optString));
            g2.call();
            return new c.a.p0.a.k.h.b(0);
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }
}
