package c.a.p0.a.v1.f.g0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.d0.l.b;
import c.a.p0.a.t1.e;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x1.c.d;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
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
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7930e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7931f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7932g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7933h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7934i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f7935j;
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
            this.f7930e = callbackHandler;
            this.f7931f = str;
            this.f7932g = unitedSchemeEntity;
            this.f7933h = str2;
            this.f7934i = str3;
            this.f7935j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.l.m(this.f7932g, this.f7930e, this.f7933h, this.f7934i, this.f7935j, this.k, this.f7931f);
                } else {
                    d.q(iVar, this.f7930e, this.f7931f);
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.v1.f.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0499b implements i.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0248b f7937f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7938g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7939h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7940i;

        public C0499b(b bVar, String str, b.C0248b c0248b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0248b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7936e = str;
            this.f7937f = c0248b;
            this.f7938g = callbackHandler;
            this.f7939h = unitedSchemeEntity;
            this.f7940i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Boolean bool) {
            e L;
            c.a.p0.a.o1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f7936e) && (L = e.L()) != null && (z = L.z()) != null) {
                        z.Z(8, new SwanAppDeleteInfo(this.f7936e).setPurgerScenes(c.a.p0.a.d0.l.c.m(this.f7937f).c()));
                    }
                    c.a.p0.a.u.d.i("history", "remove success");
                    if (z.f8176b) {
                        String str = "RMSwanHistory --- success & appid : " + this.f7936e;
                    }
                    UnitedSchemeUtility.safeCallback(this.f7938g, this.f7939h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f7940i);
                    return;
                }
                c.a.p0.a.u.d.o("history", "execute fail --- no match app id");
                boolean unused = z.f8176b;
                UnitedSchemeUtility.safeCallback(this.f7938g, this.f7939h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f7940i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7942f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7943g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.C0248b f7944h;

        public c(b bVar, String str, String str2, String str3, b.C0248b c0248b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, c0248b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7941e = str;
            this.f7942f = str2;
            this.f7943g = str3;
            this.f7944h = c0248b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(c.a.p0.a.z.c.b.g(AppRuntime.getAppContext().getContentResolver(), this.f7941e, str, this.f7942f, this.f7943g, false, this.f7944h)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.a.v1.e eVar) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.p0.a.u.d.c("history", "none swanApp");
                boolean z = z.f8176b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.a.p0.a.u.d.c("history", "empty joParams");
                boolean z2 = z.f8176b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.u.d.c("history", "empty cb");
                boolean z3 = z.f8176b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            String optString3 = optParamsAsJo.optString("appKey");
            String optString4 = optParamsAsJo.optString("version");
            String optString5 = optParamsAsJo.optString("type");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                c.a.p0.a.u.d.c("history", "empty appKey");
                boolean z4 = z.f8176b;
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
            c.a.p0.a.u.d.i("history", "start remove history");
            c.a.p0.a.d0.l.c l = c.a.p0.a.d0.l.c.l();
            l.n(4);
            b.C0248b k = l.k();
            i.d.f(str2).y(Schedulers.io()).h(new c(this, str, str3, str4, k)).k(i.l.b.a.b()).w(new C0499b(this, str, k, callbackHandler, unitedSchemeEntity, str5));
        }
    }
}
