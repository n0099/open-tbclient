package b.a.p0.a.p0.f.g;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.a1.d;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.c.j.b;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.p0.f.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0355a implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7643f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7644g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7645h;

        public C0355a(a aVar, CallbackHandler callbackHandler, String str, String str2) {
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
            this.f7645h = aVar;
            this.f7642e = callbackHandler;
            this.f7643f = str;
            this.f7644g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f7645h.k(this.f7644g, this.f7643f, this.f7642e);
                } else {
                    b.a.p0.a.h2.c.d.q(iVar, this.f7642e, this.f7643f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7647b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7648c;

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
            this.f7646a = callbackHandler;
            this.f7647b = jSONObject;
            this.f7648c = str;
        }

        @Override // b.a.p0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7646a == null) {
                    b.a.p0.a.e0.d.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    b.a.p0.a.e0.d.c("ExtCore-DebugDownload", "download failed");
                    b.a.p0.a.c2.b.f.e.f(b.a.p0.a.c1.a.c(), b.a.p0.a.h.aiapps_debug_extension_core_download_failed).G();
                    this.f7647b.put("status", -1);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f7646a.handleSchemeDispatchCallback(this.f7648c, UnitedSchemeUtility.wrapCallbackParams(this.f7647b, 1001).toString());
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
                if (this.f7646a == null) {
                    b.a.p0.a.e0.d.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File c2 = b.a.p0.a.p0.f.d.c();
                    File b2 = b.a.p0.a.p0.f.d.b();
                    if (c2.exists() && b.a.p0.w.d.U(c2.getPath(), b2.getPath())) {
                        b.a.p0.a.e0.d.c("ExtCore-DebugDownload", "download success");
                        b.a.p0.a.c2.b.f.e.f(b.a.p0.a.c1.a.c(), b.a.p0.a.h.aiapps_debug_extension_core_download_success).G();
                        this.f7647b.put("status", 0);
                        this.f7646a.handleSchemeDispatchCallback(this.f7648c, UnitedSchemeUtility.wrapCallbackParams(this.f7647b, 0).toString());
                    } else {
                        b.a.p0.a.e0.d.c("ExtCore-DebugDownload", "download failed");
                        b.a.p0.a.c2.b.f.e.f(b.a.p0.a.c1.a.c(), b.a.p0.a.h.aiapps_debug_extension_core_download_failed).G();
                        this.f7647b.put("status", -1);
                        this.f7646a.handleSchemeDispatchCallback(this.f7648c, UnitedSchemeUtility.wrapCallbackParams(this.f7647b, 1001).toString());
                    }
                } catch (JSONException e2) {
                    b.a.p0.a.e0.d.d("ExtCore-DebugDownload", "build result with exception", e2);
                    e2.printStackTrace();
                    this.f7646a.handleSchemeDispatchCallback(this.f7648c, UnitedSchemeUtility.wrapCallbackParams(this.f7647b, 1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                b.a.p0.a.e0.d.c("ExtCore-DebugDownload", "params is null");
                b.a.p0.a.c2.b.f.e.f(context, b.a.p0.a.h.aiapps_debug_params_empty).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = a2.optString("url");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.c("ExtCore-DebugDownload", "url is null");
                b.a.p0.a.c2.b.f.e.f(context, b.a.p0.a.h.aiapps_debug_download_url_empty).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = a2.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                b.a.p0.a.e0.d.c("ExtCore-DebugDownload", "cb is null");
                b.a.p0.a.c2.b.f.e.f(context, b.a.p0.a.h.aiapps_debug_extension_core_cb_empty).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            eVar.d0().g(context, "mapp_cts_debug", new C0355a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, callbackHandler) == null) {
            b.a.p0.a.a1.d.I(str, new b(this, callbackHandler, new JSONObject(), str2));
        }
    }
}
