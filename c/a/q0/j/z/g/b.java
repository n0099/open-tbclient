package c.a.q0.j.z.g;

import android.text.TextUtils;
import android.util.Log;
import c.a.q0.a.g1.f;
import c.a.q0.j.z.f.e;
import c.a.q0.w.d;
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
/* loaded from: classes6.dex */
public class b extends c.a.q0.j.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes6.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.j.z.b f10841b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10842c;

        public a(b bVar, String str, c.a.q0.j.z.b bVar2) {
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
            this.f10842c = bVar;
            this.a = str;
            this.f10841b = bVar2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f10841b.cancelTag(this.f10842c.f10815g);
                this.f10842c.W(this.a, 0, iOException.getMessage());
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
                        jSEvent.data = new e(this.f10842c.I(response.headers()));
                        this.f10842c.dispatchEvent(jSEvent);
                    } catch (JSONException e2) {
                        try {
                            if (c.a.q0.j.z.a.f10810i) {
                                e2.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            if (c.a.q0.j.z.a.f10810i) {
                            }
                            this.f10842c.C(this.a, -1, e.getMessage());
                        }
                    }
                    c.a.q0.j.z.g.a aVar = new c.a.q0.j.z.g.a();
                    aVar.statusCode = response.code();
                    aVar.header = this.f10842c.I(response.headers());
                    aVar.data = this.f10842c.X(response.body());
                    if (c.a.q0.j.z.a.f10810i) {
                        String str = "onResponse = " + aVar.data;
                    }
                    this.f10842c.D(aVar);
                } catch (IOException e4) {
                    e = e4;
                    if (c.a.q0.j.z.a.f10810i) {
                        Log.getStackTraceString(e);
                    }
                    this.f10842c.C(this.a, -1, e.getMessage());
                }
            }
        }
    }

    /* renamed from: c.a.q0.j.z.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0723b implements c.a.q0.a.p1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10844c;

        public C0723b(b bVar, long j2, String str) {
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
            this.f10844c = bVar;
            this.a = j2;
            this.f10843b = str;
        }

        @Override // c.a.q0.a.p1.p.a
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f10844c.V(this.a, j2, this.f10843b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.q0.a.l0.c cVar, c.a.q0.a.y.b.a aVar) {
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
                super((c.a.q0.a.l0.c) objArr2[0], (c.a.q0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0L;
        this.f10813e = 3;
    }

    public static void Y(MultipartBody.Builder builder, c.a.q0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, builder, aVar) == null) || builder == null || aVar == null || aVar.k() < 1) {
            return;
        }
        for (String str : aVar.j()) {
            if (!TextUtils.isEmpty(str)) {
                String H = aVar.H(str);
                if (!TextUtils.isEmpty(H)) {
                    builder.addFormDataPart(str, H);
                }
            }
        }
    }

    @Override // c.a.q0.j.z.a
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            c.a.q0.j.g0.e.k(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String z = z();
            if (!TextUtils.isEmpty(z)) {
                String B = this.f10814f.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (d.x(B)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.f10814f.b("header") && this.f10814f.getType("header") != 9) {
                    C(z, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File U = U(z, B);
                    if (U != null) {
                        c.a.q0.a.y.b.a w = this.f10814f.w("formData");
                        Request.Builder builder = new Request.Builder();
                        c.a.q0.a.p1.c cVar = new c.a.q0.a.p1.c(U, IMAudioTransRequest.CONTENT_TYPE, new C0723b(this, U.length(), z));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Y(type, w);
                        type.addFormDataPart(this.f10814f.B("name"), U.getName(), cVar);
                        MultipartBody build = type.build();
                        G(builder, this.f10814f.w("header"), new HashMap(), false);
                        return builder.url(z).tag(this.f10815g).post(build).build();
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
            String a2 = f.U().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        C(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.f10814f.B("name"))) {
                        C(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.f10814f.b("formData") || this.f10814f.getType("formData") == 9) {
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
            if (c.a.q0.j.z.a.f10810i) {
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f10814f == null || (T = T()) == null) {
            return;
        }
        if (c.a.q0.a.d2.e.L() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = T.url().toString();
        c.a.q0.j.z.b bVar = (c.a.q0.j.z.b) c.a.q0.a.d2.e.L().h0();
        bVar.call(T, new a(this, httpUrl, bVar));
    }
}
