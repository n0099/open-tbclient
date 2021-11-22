package b.a.p0.a.f2.f.g0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.d2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.c.d;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
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
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4971g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4972h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4973i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ b l;

        public a(b bVar, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, unitedSchemeEntity, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
            this.f4969e = callbackHandler;
            this.f4970f = str;
            this.f4971g = unitedSchemeEntity;
            this.f4972h = str2;
            this.f4973i = str3;
            this.j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.l.m(this.f4971g, this.f4969e, this.f4972h, this.f4973i, this.j, this.k, this.f4970f);
                } else {
                    d.q(iVar, this.f4969e, this.f4970f);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.f2.f.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0176b implements h.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0322b f4975f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4976g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4977h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4978i;

        public C0176b(b bVar, String str, b.C0322b c0322b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0322b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4974e = str;
            this.f4975f = c0322b;
            this.f4976g = callbackHandler;
            this.f4977h = unitedSchemeEntity;
            this.f4978i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Boolean bool) {
            e L;
            b.a.p0.a.y1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f4974e) && (L = e.L()) != null && (z = L.z()) != null) {
                        z.Z(8, new SwanAppDeleteInfo(this.f4974e).setPurgerScenes(b.a.p0.a.n0.l.c.m(this.f4975f).c()));
                    }
                    b.a.p0.a.e0.d.i("history", "remove success");
                    if (z.f5228b) {
                        String str = "RMSwanHistory --- success & appid : " + this.f4974e;
                    }
                    UnitedSchemeUtility.safeCallback(this.f4976g, this.f4977h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f4978i);
                    return;
                }
                b.a.p0.a.e0.d.o("history", "execute fail --- no match app id");
                boolean unused = z.f5228b;
                UnitedSchemeUtility.safeCallback(this.f4976g, this.f4977h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f4978i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4980f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4981g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.C0322b f4982h;

        public c(b bVar, String str, String str2, String str3, b.C0322b c0322b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, c0322b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4979e = str;
            this.f4980f = str2;
            this.f4981g = str3;
            this.f4982h = c0322b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(b.a.p0.a.j0.c.b.g(AppRuntime.getAppContext().getContentResolver(), this.f4979e, str, this.f4980f, this.f4981g, false, this.f4982h)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                b.a.p0.a.e0.d.c("history", "none swanApp");
                boolean z = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                b.a.p0.a.e0.d.c("history", "empty joParams");
                boolean z2 = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.c("history", "empty cb");
                boolean z3 = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            String optString3 = optParamsAsJo.optString("appKey");
            String optString4 = optParamsAsJo.optString("version");
            String optString5 = optParamsAsJo.optString("type");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                b.a.p0.a.e0.d.c("history", "empty appKey");
                boolean z4 = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
                return false;
            }
            eVar.d0().g(context, "mapp_i_delete_history", new a(this, callbackHandler, optString, unitedSchemeEntity, optString2, optString3, optString4, optString5));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, str, str2, str3, str4, str5}) == null) {
            b.a.p0.a.e0.d.i("history", "start remove history");
            b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
            l.n(4);
            b.C0322b k = l.k();
            h.d.f(str2).y(Schedulers.io()).h(new c(this, str, str3, str4, k)).k(h.l.b.a.b()).w(new C0176b(this, str, k, callbackHandler, unitedSchemeEntity, str5));
        }
    }
}
