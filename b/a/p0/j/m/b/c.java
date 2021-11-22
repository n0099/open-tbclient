package b.a.p0.j.m.b;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.a1.d;
import b.a.p0.a.c2.b.f.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.h.g;
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
/* loaded from: classes4.dex */
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f11229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f11231g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11232h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f11233i;

        public a(c cVar, CallbackHandler callbackHandler, String str, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, str, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11233i = cVar;
            this.f11229e = callbackHandler;
            this.f11230f = str;
            this.f11231g = context;
            this.f11232h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f11233i.l(this.f11231g, this.f11232h, this.f11230f, this.f11229e);
                } else {
                    b.a.p0.a.h2.c.d.q(iVar, this.f11229e, this.f11230f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f11234a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f11235b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11236c;

        public b(c cVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11234a = context;
            this.f11235b = callbackHandler;
            this.f11236c = str;
        }

        @Override // b.a.p0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.f(this.f11234a, g.aiapps_debug_game_core_download_failed).G();
                this.f11235b.handleSchemeDispatchCallback(this.f11236c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // b.a.p0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // b.a.p0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File c2 = b.a.p0.j.p.a.b.c();
                File b2 = b.a.p0.j.p.a.b.b();
                if (z.f5228b) {
                    String str = "gameCoreZipFile: " + c2 + " gameCoreDir: " + b2;
                }
                if (c2.exists() && b.a.p0.w.d.U(c2.getPath(), b2.getPath())) {
                    b.a.p0.a.x1.a.a.L(true);
                    e.f(this.f11234a, g.aiapps_debug_game_core_download_success).G();
                    this.f11235b.handleSchemeDispatchCallback(this.f11236c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                e.f(this.f11234a, g.aiapps_debug_game_core_download_failed).G();
                this.f11235b.handleSchemeDispatchCallback(this.f11236c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/debug/replaceGameCore");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                e.f(context, g.aiapps_debug_game_core_params_empty).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
                return false;
            }
            String optString = a2.optString("url");
            String optString2 = a2.optString("cb");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                eVar.d0().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, context, optString));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            e.f(context, g.aiapps_debug_game_core_url_empty).G();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "game core url or cb is null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, callbackHandler) == null) {
            b.a.p0.j.t.a.g(str, new b(this, context, callbackHandler, str2));
        }
    }
}
