package c.a.o0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import c.a.o0.a.a1.e;
import c.a.o0.a.c2.f.a0;
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
/* loaded from: classes.dex */
public class j extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast.makeText(c.a.o0.a.c1.a.b(), c.a.o0.a.h.aiapps_debug_swan_core_download_failed, 1).show();
            }
        }

        @Override // c.a.o0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.o0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File d2 = c.a.o0.a.m2.d.a.d();
                File c2 = c.a.o0.a.m2.d.a.c();
                if (d2.exists() && c.a.o0.t.d.T(d2.getPath(), c2.getPath())) {
                    c.a.o0.a.u1.a.a.L(true);
                    Toast.makeText(c.a.o0.a.c1.a.b(), c.a.o0.a.h.aiapps_debug_swan_core_download_success, 1).show();
                    return;
                }
                Toast.makeText(c.a.o0.a.c1.a.b(), c.a.o0.a.h.aiapps_debug_swan_core_download_failed, 1).show();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debugSwanCore");
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    Toast.makeText(context, c.a.o0.a.h.aiapps_debug_params_empty, 1).show();
                    return false;
                }
                String optString = a2.optString("downloadurl");
                if (TextUtils.isEmpty(optString)) {
                    Toast.makeText(context, c.a.o0.a.h.aiapps_debug_download_url_empty, 1).show();
                    return false;
                }
                c.a.o0.a.a1.e.H(optString, new a(this));
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
