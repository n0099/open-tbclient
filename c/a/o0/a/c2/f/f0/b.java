package c.a.o0.a.c2.f.f0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.j2.k;
import c.a.o0.a.v2.w;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f4779c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4780d;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4782f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f4783g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4784h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f4785i;

        public a(b bVar, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, eVar, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4785i = bVar;
            this.f4781e = callbackHandler;
            this.f4782f = str;
            this.f4783g = eVar;
            this.f4784h = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    c.a.o0.a.e2.c.d.p(iVar, this.f4781e, this.f4782f);
                    this.f4785i.l(this.f4783g, this.f4784h, this.f4781e, this.f4782f);
                    return;
                }
                this.f4785i.k(this.f4783g, this.f4784h, this.f4781e, this.f4782f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.o0.a.c2.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4779c = null;
        this.f4780d = false;
    }

    public static void m(String str, String str2, String str3) {
        c.a.o0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) || (Q = c.a.o0.a.a2.e.Q()) == null) {
            return;
        }
        c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
        b.a L = Q.L();
        eVar.f7035a = k.m(L.G());
        eVar.f7039e = str3;
        eVar.f7036b = DI.BD.FAVOR;
        eVar.f7040f = Q.D();
        SwanCoreVersion i0 = L.i0();
        String O = Q.O();
        String str4 = i0 != null ? i0.swanCoreVersionName : "";
        eVar.a("appName", O);
        eVar.a("isFavor", str);
        eVar.a("favorBy", str2);
        eVar.a("swan", str4);
        c.a.o0.a.j2.b.i("2571", "89", eVar.f());
    }

    @Override // c.a.o0.a.c2.f.a0
    public final boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.o0.a.e0.d.b("favorite", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4738b;
                return false;
            }
            JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
            String optString = d2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("favorite", "none cb");
                boolean z2 = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            this.f4780d = d2.optBoolean("isFavorButton", false);
            if (!j(eVar, unitedSchemeEntity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
                return false;
            }
            String optString2 = d2.optString("slaveId");
            String U = c.a.o0.a.g1.f.V().U();
            if (TextUtils.equals(optString2, c.a.o0.a.g1.f.V().D()) && (TextUtils.equals(U, "pages/swan-news-showcase/index") || TextUtils.equals(U, "pages/swan-operate-news/index"))) {
                k(eVar, unitedSchemeEntity, callbackHandler, optString);
            } else if (!o(unitedSchemeEntity)) {
                eVar.T().g(context, this.f4780d ? "scope_favorite_button" : "mapp_favorite", new a(this, callbackHandler, optString, eVar, unitedSchemeEntity));
            } else {
                k(eVar, unitedSchemeEntity, callbackHandler, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public abstract boolean j(c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public void l(c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
        }
    }

    public void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e2) {
                if (c.a.o0.a.k.f7049a) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }

    public boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
