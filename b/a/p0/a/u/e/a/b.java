package b.a.p0.a.u.e.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.j2.k;
import b.a.p0.a.p.b.a.h;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f8008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8010g;

        public a(b bVar, h hVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8008e = hVar;
            this.f8009f = callbackHandler;
            this.f8010g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar.c() && b.r(iVar.f4946a)) {
                    JSONObject optJSONObject = iVar.f4946a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        k.N("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(iVar.b());
                    this.f8008e.g(this.f8009f, wrapCallbackParams.toString());
                    k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.f8009f.handleSchemeDispatchCallback(this.f8010g, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public static boolean r(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    public b.a.p0.a.u.h.b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            k.N("checkSession", "create");
            h j = b.a.p0.a.c1.b.j();
            CallbackHandler g2 = a().g();
            e P = e.P();
            if (P == null) {
                j.g(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new b.a.p0.a.u.h.b(1001, "empty swanApp");
            }
            String k = P.k();
            if (TextUtils.isEmpty(k)) {
                j.g(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new b.a.p0.a.u.h.b(1001, "empty app key");
            }
            JSONObject l = b.a.p0.a.u.c.d.l(str);
            if (l == null) {
                j.g(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new b.a.p0.a.u.h.b(201, "empty joParams");
            }
            String optString = l.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new b.a.p0.a.u.h.b(201, "empty cb");
            }
            Context context = getContext();
            if (!P.j().e(context)) {
                j.g(g2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                k.O("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new b.a.p0.a.u.h.b(10004, "user not logged in");
            }
            k.N("checkSession", "checkSession");
            b.a.p0.a.e2.c.j.c g3 = b.a.p0.a.a2.d.g().y().a().b().g(context, k);
            g3.q("checkSession");
            g3.o(new a(this, j, g2, optString));
            g3.call();
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
