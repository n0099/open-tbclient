package b.a.p0.a.c2.f.h0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.d;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.n0.l.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4264h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f4265i;

        public a(b bVar, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4265i = bVar;
            this.f4261e = callbackHandler;
            this.f4262f = str;
            this.f4263g = unitedSchemeEntity;
            this.f4264h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f4265i.m(this.f4263g, this.f4261e, this.f4264h, this.f4262f);
                } else {
                    d.p(iVar, this.f4261e, this.f4262f);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.c2.f.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130b implements h.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4266e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0310b f4267f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4268g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4269h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4270i;

        public C0130b(b bVar, String str, b.C0310b c0310b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0310b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4266e = str;
            this.f4267f = c0310b;
            this.f4268g = callbackHandler;
            this.f4269h = unitedSchemeEntity;
            this.f4270i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Boolean bool) {
            e i2;
            b.a.p0.a.v1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f4266e) && (i2 = e.i()) != null && (z = i2.z()) != null) {
                        z.O(8, new SwanAppDeleteInfo(this.f4266e).setPurgerScenes(b.a.p0.a.n0.l.c.m(this.f4267f).c()));
                    }
                    b.a.p0.a.e0.d.g("history", "remove success");
                    if (a0.f4160b) {
                        String str = "RMSwanHistory --- success & appid : " + this.f4266e;
                    }
                    UnitedSchemeUtility.safeCallback(this.f4268g, this.f4269h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f4270i);
                    return;
                }
                b.a.p0.a.e0.d.l("history", "execute fail --- no match app id");
                boolean unused = a0.f4160b;
                UnitedSchemeUtility.safeCallback(this.f4268g, this.f4269h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f4270i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0310b f4271e;

        public c(b bVar, b.C0310b c0310b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0310b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4271e = c0310b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(b.a.p0.a.j0.c.b.f(AppRuntime.getAppContext().getContentResolver(), str, false, this.f4271e)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/deleteHistory");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
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
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                b.a.p0.a.e0.d.b("history", "none swanApp");
                boolean z = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                b.a.p0.a.e0.d.b("history", "empty joParams");
                boolean z2 = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("history", "empty cb");
                boolean z3 = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            if (TextUtils.isEmpty(optString2)) {
                b.a.p0.a.e0.d.b("history", "empty appId");
                boolean z4 = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
                return false;
            }
            eVar.S().g(context, "mapp_i_delete_history", new a(this, callbackHandler, optString, unitedSchemeEntity, optString2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, str, str2) == null) {
            b.a.p0.a.e0.d.g("history", "start remove history");
            b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
            l.n(4);
            b.C0310b k = l.k();
            h.d.f(str).y(Schedulers.io()).h(new c(this, k)).k(h.l.b.a.b()).w(new C0130b(this, str, k, callbackHandler, unitedSchemeEntity, str2));
        }
    }
}
