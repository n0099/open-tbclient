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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.p0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0348a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7924g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7925h;

        public C0348a(a aVar, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7925h = aVar;
            this.f7922e = callbackHandler;
            this.f7923f = str;
            this.f7924g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f7925h.k(this.f7924g, this.f7923f, this.f7922e);
                } else {
                    c.a.p0.a.e2.c.d.p(iVar, this.f7922e, this.f7923f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7926a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7928c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7926a = callbackHandler;
            this.f7927b = jSONObject;
            this.f7928c = str;
        }

        @Override // c.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7926a == null) {
                    c.a.p0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    c.a.p0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                    c.a.p0.a.z1.b.f.e.f(c.a.p0.a.c1.a.b(), c.a.p0.a.h.aiapps_debug_extension_core_download_failed).F();
                    this.f7927b.put("status", -1);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f7926a.handleSchemeDispatchCallback(this.f7928c, UnitedSchemeUtility.wrapCallbackParams(this.f7927b, 1001).toString());
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
                if (this.f7926a == null) {
                    c.a.p0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File c2 = c.a.p0.a.p0.f.c.c();
                    File b2 = c.a.p0.a.p0.f.c.b();
                    if (c2.exists() && c.a.p0.t.d.T(c2.getPath(), b2.getPath())) {
                        c.a.p0.a.e0.d.b("ExtCore-DebugDownload", "download success");
                        c.a.p0.a.z1.b.f.e.f(c.a.p0.a.c1.a.b(), c.a.p0.a.h.aiapps_debug_extension_core_download_success).F();
                        this.f7927b.put("status", 0);
                        this.f7926a.handleSchemeDispatchCallback(this.f7928c, UnitedSchemeUtility.wrapCallbackParams(this.f7927b, 0).toString());
                    } else {
                        c.a.p0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                        c.a.p0.a.z1.b.f.e.f(c.a.p0.a.c1.a.b(), c.a.p0.a.h.aiapps_debug_extension_core_download_failed).F();
                        this.f7927b.put("status", -1);
                        this.f7926a.handleSchemeDispatchCallback(this.f7928c, UnitedSchemeUtility.wrapCallbackParams(this.f7927b, 1001).toString());
                    }
                } catch (JSONException e2) {
                    c.a.p0.a.e0.d.c("ExtCore-DebugDownload", "build result with exception", e2);
                    e2.printStackTrace();
                    this.f7926a.handleSchemeDispatchCallback(this.f7928c, UnitedSchemeUtility.wrapCallbackParams(this.f7927b, 1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/downloadExtension");
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
                c.a.p0.a.e0.d.b("ExtCore-DebugDownload", "params is null");
                c.a.p0.a.z1.b.f.e.f(context, c.a.p0.a.h.aiapps_debug_params_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = a2.optString("url");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.e0.d.b("ExtCore-DebugDownload", "url is null");
                c.a.p0.a.z1.b.f.e.f(context, c.a.p0.a.h.aiapps_debug_download_url_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = a2.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                c.a.p0.a.e0.d.b("ExtCore-DebugDownload", "cb is null");
                c.a.p0.a.z1.b.f.e.f(context, c.a.p0.a.h.aiapps_debug_extension_core_cb_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            eVar.T().g(context, "mapp_cts_debug", new C0348a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, callbackHandler) == null) {
            c.a.p0.a.a1.e.G(str, new b(this, callbackHandler, new JSONObject(), str2));
        }
    }
}
