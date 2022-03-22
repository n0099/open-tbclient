package c.a.n0.a.f0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.q0.d;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.R;
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

    /* renamed from: c.a.n0.a.f0.f.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0269a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4358b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4359c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4360d;

        public C0269a(a aVar, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4360d = aVar;
            this.a = callbackHandler;
            this.f4358b = str;
            this.f4359c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f4360d.k(this.f4359c, this.f4358b, this.a);
                } else {
                    c.a.n0.a.x1.c.d.q(iVar, this.a, this.f4358b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4362c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f4361b = jSONObject;
            this.f4362c = str;
        }

        @Override // c.a.n0.a.q0.d.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // c.a.n0.a.q0.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a == null) {
                    c.a.n0.a.u.d.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    c.a.n0.a.u.d.c("ExtCore-DebugDownload", "download failed");
                    c.a.n0.a.s1.b.f.e.f(c.a.n0.a.s0.a.c(), R.string.obfuscated_res_0x7f0f0121).G();
                    this.f4361b.put("status", -1);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.a.handleSchemeDispatchCallback(this.f4362c, UnitedSchemeUtility.wrapCallbackParams(this.f4361b, 1001).toString());
            }
        }

        @Override // c.a.n0.a.q0.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a == null) {
                    c.a.n0.a.u.d.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File c2 = c.a.n0.a.f0.f.d.c();
                    File b2 = c.a.n0.a.f0.f.d.b();
                    if (c2.exists() && c.a.n0.w.d.U(c2.getPath(), b2.getPath())) {
                        c.a.n0.a.u.d.c("ExtCore-DebugDownload", "download success");
                        c.a.n0.a.s1.b.f.e.f(c.a.n0.a.s0.a.c(), R.string.obfuscated_res_0x7f0f0122).G();
                        this.f4361b.put("status", 0);
                        this.a.handleSchemeDispatchCallback(this.f4362c, UnitedSchemeUtility.wrapCallbackParams(this.f4361b, 0).toString());
                    } else {
                        c.a.n0.a.u.d.c("ExtCore-DebugDownload", "download failed");
                        c.a.n0.a.s1.b.f.e.f(c.a.n0.a.s0.a.c(), R.string.obfuscated_res_0x7f0f0121).G();
                        this.f4361b.put("status", -1);
                        this.a.handleSchemeDispatchCallback(this.f4362c, UnitedSchemeUtility.wrapCallbackParams(this.f4361b, 1001).toString());
                    }
                } catch (JSONException e2) {
                    c.a.n0.a.u.d.d("ExtCore-DebugDownload", "build result with exception", e2);
                    e2.printStackTrace();
                    this.a.handleSchemeDispatchCallback(this.f4362c, UnitedSchemeUtility.wrapCallbackParams(this.f4361b, 1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/debug/downloadExtension");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a = z.a(unitedSchemeEntity, "params");
            if (a == null) {
                c.a.n0.a.u.d.c("ExtCore-DebugDownload", "params is null");
                c.a.n0.a.s1.b.f.e.f(context, R.string.obfuscated_res_0x7f0f013e).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = a.optString("url");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.u.d.c("ExtCore-DebugDownload", "url is null");
                c.a.n0.a.s1.b.f.e.f(context, R.string.obfuscated_res_0x7f0f0113).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = a.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                c.a.n0.a.u.d.c("ExtCore-DebugDownload", "cb is null");
                c.a.n0.a.s1.b.f.e.f(context, R.string.obfuscated_res_0x7f0f0120).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            eVar.d0().g(context, "mapp_cts_debug", new C0269a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, callbackHandler) == null) {
            c.a.n0.a.q0.d.I(str, new b(this, callbackHandler, new JSONObject(), str2));
        }
    }
}
