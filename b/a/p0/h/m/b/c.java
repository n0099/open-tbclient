package b.a.p0.h.m.b;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.a1.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.f.g;
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
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10523f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f10524g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10525h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f10526i;

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
            this.f10526i = cVar;
            this.f10522e = callbackHandler;
            this.f10523f = str;
            this.f10524g = context;
            this.f10525h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f10526i.l(this.f10524g, this.f10525h, this.f10523f, this.f10522e);
                } else {
                    b.a.p0.a.e2.c.d.p(iVar, this.f10522e, this.f10523f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f10527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10528b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10529c;

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
            this.f10527a = context;
            this.f10528b = callbackHandler;
            this.f10529c = str;
        }

        @Override // b.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e.f(this.f10527a, g.aiapps_debug_game_core_download_failed).F();
                this.f10528b.handleSchemeDispatchCallback(this.f10529c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // b.a.p0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // b.a.p0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File c2 = b.a.p0.h.p.a.b.c();
                File b2 = b.a.p0.h.p.a.b.b();
                if (a0.f4160b) {
                    String str = "gameCoreZipFile: " + c2 + " gameCoreDir: " + b2;
                }
                if (c2.exists() && b.a.p0.t.d.T(c2.getPath(), b2.getPath())) {
                    b.a.p0.a.u1.a.a.K(true);
                    b.a.p0.a.z1.b.f.e.f(this.f10527a, g.aiapps_debug_game_core_download_success).F();
                    this.f10528b.handleSchemeDispatchCallback(this.f10529c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                b.a.p0.a.z1.b.f.e.f(this.f10527a, g.aiapps_debug_game_core_download_failed).F();
                this.f10528b.handleSchemeDispatchCallback(this.f10529c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.c2.e eVar) {
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                b.a.p0.a.z1.b.f.e.f(context, g.aiapps_debug_game_core_params_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
                return false;
            }
            String optString = a2.optString("url");
            String optString2 = a2.optString("cb");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                eVar.S().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, context, optString));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            b.a.p0.a.z1.b.f.e.f(context, g.aiapps_debug_game_core_url_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "game core url or cb is null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, callbackHandler) == null) {
            b.a.p0.h.s.a.g(str, new b(this, context, callbackHandler, str2));
        }
    }
}
