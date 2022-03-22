package c.a.n0.a.v1.f.g0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.d0.l.b;
import c.a.n0.a.t1.e;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.d;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
import g.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6711b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6712c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6713d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6716g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f6717h;

        public a(b bVar, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, unitedSchemeEntity, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6717h = bVar;
            this.a = callbackHandler;
            this.f6711b = str;
            this.f6712c = unitedSchemeEntity;
            this.f6713d = str2;
            this.f6714e = str3;
            this.f6715f = str4;
            this.f6716g = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f6717h.m(this.f6712c, this.a, this.f6713d, this.f6714e, this.f6715f, this.f6716g, this.f6711b);
                } else {
                    d.q(iVar, this.a, this.f6711b);
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.v1.f.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0491b implements g.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.C0236b f6718b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6719c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6720d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6721e;

        public C0491b(b bVar, String str, b.C0236b c0236b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0236b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f6718b = c0236b;
            this.f6719c = callbackHandler;
            this.f6720d = unitedSchemeEntity;
            this.f6721e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.b
        public void call(Boolean bool) {
            e L;
            c.a.n0.a.o1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.a) && (L = e.L()) != null && (z = L.z()) != null) {
                        z.Z(8, new SwanAppDeleteInfo(this.a).setPurgerScenes(c.a.n0.a.d0.l.c.m(this.f6718b).c()));
                    }
                    c.a.n0.a.u.d.i("history", "remove success");
                    if (z.f6924b) {
                        Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.a);
                    }
                    UnitedSchemeUtility.safeCallback(this.f6719c, this.f6720d, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f6721e);
                    return;
                }
                c.a.n0.a.u.d.o("history", "execute fail --- no match app id");
                if (z.f6924b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
                }
                UnitedSchemeUtility.safeCallback(this.f6719c, this.f6720d, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f6721e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6722b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6723c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.C0236b f6724d;

        public c(b bVar, String str, String str2, String str3, b.C0236b c0236b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, c0236b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f6722b = str2;
            this.f6723c = str3;
            this.f6724d = c0236b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(c.a.n0.a.z.c.b.g(AppRuntime.getAppContext().getContentResolver(), this.a, str, this.f6722b, this.f6723c, false, this.f6724d)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/deleteHistory");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.n0.a.u.d.c("history", "none swanApp");
                if (z.f6924b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.a.n0.a.u.d.c("history", "empty joParams");
                if (z.f6924b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.u.d.c("history", "empty cb");
                if (z.f6924b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            String optString3 = optParamsAsJo.optString("appKey");
            String optString4 = optParamsAsJo.optString("version");
            String optString5 = optParamsAsJo.optString("type");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                c.a.n0.a.u.d.c("history", "empty appKey");
                if (z.f6924b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty appKey");
                }
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
            c.a.n0.a.u.d.i("history", "start remove history");
            c.a.n0.a.d0.l.c l = c.a.n0.a.d0.l.c.l();
            l.n(4);
            b.C0236b k = l.k();
            g.d.f(str2).y(Schedulers.io()).h(new c(this, str, str3, str4, k)).k(g.l.b.a.b()).w(new C0491b(this, str, k, callbackHandler, unitedSchemeEntity, str5));
        }
    }
}
