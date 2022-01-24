package c.a.r0.a.f2.f.g0;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.d2.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.d;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.n0.l.b;
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
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6099g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6100h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6101i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6102j;
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
            this.f6097e = callbackHandler;
            this.f6098f = str;
            this.f6099g = unitedSchemeEntity;
            this.f6100h = str2;
            this.f6101i = str3;
            this.f6102j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.l.m(this.f6099g, this.f6097e, this.f6100h, this.f6101i, this.f6102j, this.k, this.f6098f);
                } else {
                    d.q(iVar, this.f6097e, this.f6098f);
                }
            }
        }
    }

    /* renamed from: c.a.r0.a.f2.f.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0334b implements i.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0480b f6104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6106h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6107i;

        public C0334b(b bVar, String str, b.C0480b c0480b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0480b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6103e = str;
            this.f6104f = c0480b;
            this.f6105g = callbackHandler;
            this.f6106h = unitedSchemeEntity;
            this.f6107i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Boolean bool) {
            e L;
            c.a.r0.a.y1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f6103e) && (L = e.L()) != null && (z = L.z()) != null) {
                        z.Z(8, new SwanAppDeleteInfo(this.f6103e).setPurgerScenes(c.a.r0.a.n0.l.c.m(this.f6104f).c()));
                    }
                    c.a.r0.a.e0.d.i("history", "remove success");
                    if (z.f6343b) {
                        String str = "RMSwanHistory --- success & appid : " + this.f6103e;
                    }
                    UnitedSchemeUtility.safeCallback(this.f6105g, this.f6106h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f6107i);
                    return;
                }
                c.a.r0.a.e0.d.o("history", "execute fail --- no match app id");
                boolean unused = z.f6343b;
                UnitedSchemeUtility.safeCallback(this.f6105g, this.f6106h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f6107i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6110g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.C0480b f6111h;

        public c(b bVar, String str, String str2, String str3, b.C0480b c0480b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, c0480b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6108e = str;
            this.f6109f = str2;
            this.f6110g = str3;
            this.f6111h = c0480b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(c.a.r0.a.j0.c.b.g(AppRuntime.getAppContext().getContentResolver(), this.f6108e, str, this.f6109f, this.f6110g, false, this.f6111h)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.r0.a.e0.d.c("history", "none swanApp");
                boolean z = z.f6343b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.a.r0.a.e0.d.c("history", "empty joParams");
                boolean z2 = z.f6343b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.r0.a.e0.d.c("history", "empty cb");
                boolean z3 = z.f6343b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            String optString3 = optParamsAsJo.optString("appKey");
            String optString4 = optParamsAsJo.optString("version");
            String optString5 = optParamsAsJo.optString("type");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                c.a.r0.a.e0.d.c("history", "empty appKey");
                boolean z4 = z.f6343b;
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
            c.a.r0.a.e0.d.i("history", "start remove history");
            c.a.r0.a.n0.l.c l = c.a.r0.a.n0.l.c.l();
            l.n(4);
            b.C0480b k = l.k();
            i.d.f(str2).y(Schedulers.io()).h(new c(this, str, str3, str4, k)).k(i.l.b.a.b()).w(new C0334b(this, str, k, callbackHandler, unitedSchemeEntity, str5));
        }
    }
}
