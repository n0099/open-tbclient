package c.a.n0.h.y.g;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.g1.f;
import c.a.n0.h.y.f.e;
import c.a.n0.t.d;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c.a.n0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11350a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.h.y.b f11351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f11352c;

        public a(b bVar, String str, c.a.n0.h.y.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11352c = bVar;
            this.f11350a = str;
            this.f11351b = bVar2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f11351b.cancelTag(this.f11352c.f11316g);
                this.f11352c.W(this.f11350a, 0, iOException.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    try {
                        JSEvent jSEvent = new JSEvent("headersReceived");
                        jSEvent.data = new e(this.f11352c.I(response.headers()));
                        this.f11352c.dispatchEvent(jSEvent);
                    } catch (JSONException e2) {
                        try {
                            if (c.a.n0.h.y.a.f11312i) {
                                e2.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            if (c.a.n0.h.y.a.f11312i) {
                            }
                            this.f11352c.C(this.f11350a, -1, e.getMessage());
                        }
                    }
                    c.a.n0.h.y.g.a aVar = new c.a.n0.h.y.g.a();
                    aVar.statusCode = response.code();
                    aVar.header = this.f11352c.I(response.headers());
                    aVar.data = this.f11352c.X(response.body());
                    if (c.a.n0.h.y.a.f11312i) {
                        String str = "onResponse = " + aVar.data;
                    }
                    this.f11352c.D(aVar);
                } catch (IOException e4) {
                    e = e4;
                    if (c.a.n0.h.y.a.f11312i) {
                        Log.getStackTraceString(e);
                    }
                    this.f11352c.C(this.f11350a, -1, e.getMessage());
                }
            }
        }
    }

    /* renamed from: c.a.n0.h.y.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0594b implements c.a.n0.a.n1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f11353a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11354b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f11355c;

        public C0594b(b bVar, long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11355c = bVar;
            this.f11353a = j2;
            this.f11354b = str;
        }

        @Override // c.a.n0.a.n1.p.a
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f11355c.V(this.f11353a, j2, this.f11354b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.n0.a.l0.c cVar, c.a.n0.a.y.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.n0.a.l0.c) objArr2[0], (c.a.n0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0L;
        this.f11314e = 3;
    }

    public static void Y(MultipartBody.Builder builder, c.a.n0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, builder, aVar) == null) || builder == null || aVar == null || aVar.l() < 1) {
            return;
        }
        for (String str : aVar.k()) {
            if (!TextUtils.isEmpty(str)) {
                String I = aVar.I(str);
                if (!TextUtils.isEmpty(I)) {
                    builder.addFormDataPart(str, I);
                }
            }
        }
    }

    @Override // c.a.n0.h.y.a
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            c.a.n0.h.f0.e.k(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String z = z();
            if (!TextUtils.isEmpty(z)) {
                String C = this.f11315f.C("filePath");
                if (TextUtils.isEmpty(C)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (d.w(C)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.f11315f.b("header") && this.f11315f.i("header") != 9) {
                    C(z, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File U = U(z, C);
                    if (U != null) {
                        c.a.n0.a.y.b.a x = this.f11315f.x("formData");
                        Request.Builder builder = new Request.Builder();
                        c.a.n0.a.n1.c cVar = new c.a.n0.a.n1.c(U, IMAudioTransRequest.CONTENT_TYPE, new C0594b(this, U.length(), z));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Y(type, x);
                        type.addFormDataPart(this.f11315f.C("name"), U.getName(), cVar);
                        MultipartBody build = type.build();
                        G(builder, this.f11315f.x("header"), new HashMap(), false);
                        return builder.url(z).tag(this.f11316g).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File U(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = f.V().I().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        C(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.f11315f.C("name"))) {
                        C(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.f11315f.b("formData") || this.f11315f.i("formData") == 9) {
                        return file;
                    } else {
                        C(str, -1, "uploadFile:formData is invalid");
                        return null;
                    }
                }
                C(str, -1, "request:file not exists or not file");
                return null;
            }
            C(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void V(long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str}) == null) || j2 <= 0 || j3 > j2 || j3 == 0) {
            return;
        }
        int floor = (int) Math.floor((100 * j3) / j2);
        if (System.currentTimeMillis() - this.l > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new c(floor, j2, j3)));
            }
            this.l = System.currentTimeMillis();
        }
    }

    public final void W(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            if (c.a.n0.h.y.a.f11312i) {
                String str3 = "onFailure: " + str2;
            }
            C(str, i2, ("Socket is closed".equalsIgnoreCase(str2) || ResponseException.CANCELED.equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public final Object X(ResponseBody responseBody) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseBody)) == null) {
            if (responseBody == null) {
                return null;
            }
            String string = responseBody.string();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return string;
            }
        }
        return invokeL.objValue;
    }

    public void start() {
        Request T;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f11315f == null || (T = T()) == null) {
            return;
        }
        if (c.a.n0.a.a2.e.i() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = T.url().toString();
        c.a.n0.h.y.b bVar = (c.a.n0.h.y.b) c.a.n0.a.a2.e.i().X();
        bVar.b(T, new a(this, httpUrl, bVar));
    }
}
