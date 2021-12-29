package c.a.r0.a.p0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.a1.d;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.j.b;
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
public class e extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8384e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8385f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f8386g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8387h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8388i;

        public a(e eVar, CallbackHandler callbackHandler, String str, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, str, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8388i = eVar;
            this.f8384e = callbackHandler;
            this.f8385f = str;
            this.f8386g = context;
            this.f8387h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f8388i.l(this.f8386g, this.f8387h, this.f8385f, this.f8384e);
                } else {
                    c.a.r0.a.h2.c.d.q(iVar, this.f8384e, this.f8385f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8389b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8390c;

        public b(e eVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f8389b = callbackHandler;
            this.f8390c = str;
        }

        @Override // c.a.r0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c2.b.f.e.f(this.a, c.a.r0.a.h.aiapps_debug_swan_core_download_failed).G();
                this.f8389b.handleSchemeDispatchCallback(this.f8390c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // c.a.r0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.r0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File d2 = c.a.r0.a.q2.d.a.d();
                File c2 = c.a.r0.a.q2.d.a.c();
                if (z.f6340b) {
                    String str = "swanCoreZipFile: " + d2 + " swanCoreDir: " + c2;
                }
                if (d2.exists() && c.a.r0.w.d.U(d2.getPath(), c2.getPath())) {
                    c.a.r0.a.x1.a.a.M(true);
                    c.a.r0.a.c2.b.f.e.f(this.a, c.a.r0.a.h.aiapps_debug_swan_core_download_success).G();
                    this.f8389b.handleSchemeDispatchCallback(this.f8390c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                c.a.r0.a.c2.b.f.e.f(this.a, c.a.r0.a.h.aiapps_debug_swan_core_download_failed).G();
                this.f8389b.handleSchemeDispatchCallback(this.f8390c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.r0.a.c2.b.f.e.f(context, c.a.r0.a.h.aiapps_debug_params_empty).G();
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
            c.a.r0.a.c2.b.f.e.f(context, c.a.r0.a.h.aiapps_debug_download_url_empty).G();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, callbackHandler) == null) {
            c.a.r0.a.a1.d.J(str, new b(this, context, callbackHandler, str2));
        }
    }
}
