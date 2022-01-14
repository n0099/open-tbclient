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
        public final /* synthetic */ CallbackHandler f5955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5956f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5957g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5958h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5959i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f5960j;
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
            this.f5955e = callbackHandler;
            this.f5956f = str;
            this.f5957g = unitedSchemeEntity;
            this.f5958h = str2;
            this.f5959i = str3;
            this.f5960j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.l.m(this.f5957g, this.f5955e, this.f5958h, this.f5959i, this.f5960j, this.k, this.f5956f);
                } else {
                    d.q(iVar, this.f5955e, this.f5956f);
                }
            }
        }
    }

    /* renamed from: c.a.r0.a.f2.f.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0325b implements i.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0471b f5962f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5963g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5964h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5965i;

        public C0325b(b bVar, String str, b.C0471b c0471b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0471b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5961e = str;
            this.f5962f = c0471b;
            this.f5963g = callbackHandler;
            this.f5964h = unitedSchemeEntity;
            this.f5965i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Boolean bool) {
            e L;
            c.a.r0.a.y1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f5961e) && (L = e.L()) != null && (z = L.z()) != null) {
                        z.Z(8, new SwanAppDeleteInfo(this.f5961e).setPurgerScenes(c.a.r0.a.n0.l.c.m(this.f5962f).c()));
                    }
                    c.a.r0.a.e0.d.i("history", "remove success");
                    if (z.f6201b) {
                        String str = "RMSwanHistory --- success & appid : " + this.f5961e;
                    }
                    UnitedSchemeUtility.safeCallback(this.f5963g, this.f5964h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f5965i);
                    return;
                }
                c.a.r0.a.e0.d.o("history", "execute fail --- no match app id");
                boolean unused = z.f6201b;
                UnitedSchemeUtility.safeCallback(this.f5963g, this.f5964h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f5965i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5967f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5968g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.C0471b f5969h;

        public c(b bVar, String str, String str2, String str3, b.C0471b c0471b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, c0471b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5966e = str;
            this.f5967f = str2;
            this.f5968g = str3;
            this.f5969h = c0471b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(c.a.r0.a.j0.c.b.g(AppRuntime.getAppContext().getContentResolver(), this.f5966e, str, this.f5967f, this.f5968g, false, this.f5969h)) : (Boolean) invokeL.objValue;
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
                boolean z = z.f6201b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.a.r0.a.e0.d.c("history", "empty joParams");
                boolean z2 = z.f6201b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.r0.a.e0.d.c("history", "empty cb");
                boolean z3 = z.f6201b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            String optString3 = optParamsAsJo.optString("appKey");
            String optString4 = optParamsAsJo.optString("version");
            String optString5 = optParamsAsJo.optString("type");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                c.a.r0.a.e0.d.c("history", "empty appKey");
                boolean z4 = z.f6201b;
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
            b.C0471b k = l.k();
            i.d.f(str2).y(Schedulers.io()).h(new c(this, str, str3, str4, k)).k(i.l.b.a.b()).w(new C0325b(this, str, k, callbackHandler, unitedSchemeEntity, str5));
        }
    }
}
