package c.a.o0.a.c2.f.h0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.d;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.n0.l.b;
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
import i.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4842g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4843h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f4844i;

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
            this.f4844i = bVar;
            this.f4840e = callbackHandler;
            this.f4841f = str;
            this.f4842g = unitedSchemeEntity;
            this.f4843h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f4844i.m(this.f4842g, this.f4840e, this.f4843h, this.f4841f);
                } else {
                    d.p(iVar, this.f4840e, this.f4841f);
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.c2.f.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0133b implements i.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0313b f4846f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4847g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4848h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4849i;

        public C0133b(b bVar, String str, b.C0313b c0313b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0313b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4845e = str;
            this.f4846f = c0313b;
            this.f4847g = callbackHandler;
            this.f4848h = unitedSchemeEntity;
            this.f4849i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            e i2;
            c.a.o0.a.v1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f4845e) && (i2 = e.i()) != null && (z = i2.z()) != null) {
                        z.O(8, new SwanAppDeleteInfo(this.f4845e).setPurgerScenes(c.a.o0.a.n0.l.c.m(this.f4846f).c()));
                    }
                    c.a.o0.a.e0.d.g("history", "remove success");
                    if (a0.f4738b) {
                        String str = "RMSwanHistory --- success & appid : " + this.f4845e;
                    }
                    UnitedSchemeUtility.safeCallback(this.f4847g, this.f4848h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f4849i);
                    return;
                }
                c.a.o0.a.e0.d.l("history", "execute fail --- no match app id");
                boolean unused = a0.f4738b;
                UnitedSchemeUtility.safeCallback(this.f4847g, this.f4848h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f4849i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0313b f4850e;

        public c(b bVar, b.C0313b c0313b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0313b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4850e = c0313b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(c.a.o0.a.j0.c.b.f(AppRuntime.getAppContext().getContentResolver(), str, false, this.f4850e)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.o0.a.e0.d.b("history", "none swanApp");
                boolean z = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.a.o0.a.e0.d.b("history", "empty joParams");
                boolean z2 = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("history", "empty cb");
                boolean z3 = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            if (TextUtils.isEmpty(optString2)) {
                c.a.o0.a.e0.d.b("history", "empty appId");
                boolean z4 = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
                return false;
            }
            eVar.T().g(context, "mapp_i_delete_history", new a(this, callbackHandler, optString, unitedSchemeEntity, optString2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, str, str2) == null) {
            c.a.o0.a.e0.d.g("history", "start remove history");
            c.a.o0.a.n0.l.c l = c.a.o0.a.n0.l.c.l();
            l.n(4);
            b.C0313b k = l.k();
            i.d.i(str).D(Schedulers.io()).k(new c(this, k)).o(i.l.b.a.b()).B(new C0133b(this, str, k, callbackHandler, unitedSchemeEntity, str2));
        }
    }
}
