package b.a.p0.j.h;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import b.a.p0.a.a1.d;
import b.a.p0.a.f2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.h.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0599a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11168a;

        public C0599a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11168a = aVar;
        }

        @Override // b.a.p0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11168a.l(g.aiapps_game_dashboard_download_failed);
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
                File c2 = b.c();
                File b2 = b.b();
                if (!c2.exists() || !b.a.p0.w.d.U(c2.getPath(), b2.getPath())) {
                    this.f11168a.l(g.aiapps_game_dashboard_download_failed);
                } else {
                    this.f11168a.l(g.aiapps_game_dashboard_download_success);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/debug/dashboardConnect");
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
            if (z.f5228b) {
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    l(g.aiapps_debug_game_core_params_empty);
                    return false;
                }
                String optString = a2.optString("meterUrl");
                if (TextUtils.isEmpty(optString)) {
                    l(g.aiapps_debug_game_core_url_empty);
                    return false;
                }
                b.a();
                d.C0111d c0111d = new d.C0111d();
                c0111d.f3995a = k(context, optString);
                new b.a.p0.a.k0.b().e(c0111d, b.c().getPath(), new C0599a(this));
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            String i2 = b.a.p0.a.c1.a.h0().i(context);
            String str2 = new String(b.a.p0.j.u.a.g().a("BASE64", (i2 + "\u0000\u0000").getBytes()));
            String str3 = str.contains("?") ? "&" : "?";
            return str + str3 + "cuid=" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Toast.makeText(b.a.p0.a.c1.a.c(), i2, 1).show();
        }
    }
}
