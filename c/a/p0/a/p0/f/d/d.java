package c.a.p0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.a1.e;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7938f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7939g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7940h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f7941i;

        public a(d dVar, CallbackHandler callbackHandler, String str, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, str, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7941i = dVar;
            this.f7937e = callbackHandler;
            this.f7938f = str;
            this.f7939g = context;
            this.f7940h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f7941i.l(this.f7939g, this.f7940h, this.f7938f, this.f7937e);
                } else {
                    c.a.p0.a.e2.c.d.p(iVar, this.f7937e, this.f7938f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f7942a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7943b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7944c;

        public b(d dVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7942a = context;
            this.f7943b = callbackHandler;
            this.f7944c = str;
        }

        @Override // c.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.z1.b.f.e.f(this.f7942a, c.a.p0.a.h.aiapps_debug_swan_core_download_failed).F();
                this.f7943b.handleSchemeDispatchCallback(this.f7944c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File d2 = c.a.p0.a.m2.d.a.d();
                File c2 = c.a.p0.a.m2.d.a.c();
                if (a0.f4766b) {
                    String str = "swanCoreZipFile: " + d2 + " swanCoreDir: " + c2;
                }
                if (d2.exists() && c.a.p0.t.d.T(d2.getPath(), c2.getPath())) {
                    c.a.p0.a.u1.a.a.L(true);
                    c.a.p0.a.z1.b.f.e.f(this.f7942a, c.a.p0.a.h.aiapps_debug_swan_core_download_success).F();
                    this.f7943b.handleSchemeDispatchCallback(this.f7944c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                c.a.p0.a.z1.b.f.e.f(this.f7942a, c.a.p0.a.h.aiapps_debug_swan_core_download_failed).F();
                this.f7943b.handleSchemeDispatchCallback(this.f7944c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/replaceSwanCore");
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.p0.a.z1.b.f.e.f(context, c.a.p0.a.h.aiapps_debug_params_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
                return false;
            }
            String optString = a2.optString("url");
            String optString2 = a2.optString("cb");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, context, optString));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            c.a.p0.a.z1.b.f.e.f(context, c.a.p0.a.h.aiapps_debug_download_url_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, callbackHandler) == null) {
            c.a.p0.a.a1.e.H(str, new b(this, context, callbackHandler, str2));
        }
    }
}
