package c.a.q0.a.r;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7889b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7890c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f7891d;

        public a(d dVar, String str, String str2, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7891d = dVar;
            this.a = str;
            this.f7889b = str2;
            this.f7890c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d dVar = this.f7891d;
                CallbackHandler callbackHandler = this.f7890c;
                String str = this.f7889b;
                dVar.r(callbackHandler, str, null, "downloadFile:fail" + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f7891d.s(response, this.a, this.f7889b, this.f7890c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.q0.a.f2.e eVar) {
        super(eVar, "/swanAPI/cloudDownloadFile");
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
                super((c.a.q0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.a.r.c, c.a.q0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.q0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) ? super.d(context, unitedSchemeEntity, callbackHandler, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.q0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) {
            if (!response.isSuccessful()) {
                k(callbackHandler, str, 1001, "downloadFile:fail");
                return;
            }
            String header = response.header("Content-Type", "");
            if (header != null && header.contains("application/json")) {
                JSONObject m = c.a.q0.a.r.a.m(response);
                if (m != null && response.isSuccessful()) {
                    String optString = m.optString("errno", String.valueOf(0));
                    String optString2 = m.optString("errmsg");
                    if (c.a.q0.a.r.a.o(optString)) {
                        r(callbackHandler, str, optString, optString2);
                        return;
                    }
                    String optString3 = m.optString("DownloadUrl");
                    if (TextUtils.isEmpty(optString3)) {
                        r(callbackHandler, str, optString, optString2);
                        return;
                    } else {
                        p(optString3, callbackHandler, str);
                        return;
                    }
                }
                k(callbackHandler, str, 1001, "downloadFile:fail");
                return;
            }
            k(callbackHandler, str, 1001, "downloadFile:fail");
        }
    }

    public void p(String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, callbackHandler, str2) == null) {
            if (c.a.q0.a.d2.e.L() == null) {
                r(callbackHandler, str2, null, null);
            } else {
                q(str, str2, callbackHandler);
            }
        }
    }

    public final void q(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, callbackHandler) == null) {
            c.a.q0.p.d.a aVar = new c.a.q0.p.d.a(str, new a(this, str, str2, callbackHandler));
            aVar.f10983f = true;
            aVar.f10984g = false;
            aVar.f10985h = true;
            c.a.q0.p.e.a.g().d(aVar);
        }
    }

    public final void r(CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, callbackHandler, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                k(callbackHandler, str, 1001, "downloadFile:fail");
            } else {
                k(callbackHandler, str, 1001, c.a.q0.a.r.a.k(str3));
            }
        }
    }

    public final void s(Response response, String str, String str2, CallbackHandler callbackHandler) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, response, str, str2, callbackHandler) == null) {
            if (!response.isSuccessful()) {
                r(callbackHandler, str2, null, "downloadFile:fail");
                return;
            }
            try {
                str3 = c.a.q0.a.f2.f.f.A(c.a.q0.a.p1.a.s(response.headers()), c.a.q0.w.d.t(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                r(callbackHandler, str2, null, null);
                return;
            }
            String g2 = c.a.q0.a.g1.f.U().G().g(str3);
            if (TextUtils.isEmpty(g2)) {
                r(callbackHandler, str2, null, null);
            } else if (t(response, str3)) {
                m(callbackHandler, str2, c.a.q0.a.r.a.n(null, g2, "downloadFile:ok"));
            } else {
                r(callbackHandler, str2, null, null);
            }
        }
    }

    public boolean t(Response response, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, response, str)) == null) {
            InputStream byteStream = response.body() != null ? response.body().byteStream() : null;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    if (c.f7886c) {
                        e2.printStackTrace();
                    }
                }
            }
            return c.a.q0.w.g.a(byteStream, file);
        }
        return invokeLL.booleanValue;
    }
}
