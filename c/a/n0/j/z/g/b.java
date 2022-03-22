package c.a.n0.j.z.g;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.w0.f;
import c.a.n0.j.z.f.e;
import c.a.n0.w.d;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes2.dex */
public class b extends c.a.n0.j.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public long f8990h;

    /* loaded from: classes2.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.z.b f8991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8992c;

        public a(b bVar, String str, c.a.n0.j.z.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8992c = bVar;
            this.a = str;
            this.f8991b = bVar2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f8991b.cancelTag(this.f8992c.f8965c);
                this.f8992c.X(this.a, 0, iOException.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
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
                        jSEvent.data = new e(this.f8992c.J(response.headers()));
                        this.f8992c.dispatchEvent(jSEvent);
                    } catch (JSONException e2) {
                        try {
                            if (c.a.n0.j.z.a.f8961e) {
                                e2.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            if (c.a.n0.j.z.a.f8961e) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            this.f8992c.D(this.a, -1, e.getMessage());
                        }
                    }
                    c.a.n0.j.z.g.a aVar = new c.a.n0.j.z.g.a();
                    aVar.statusCode = response.code();
                    aVar.header = this.f8992c.J(response.headers());
                    aVar.data = this.f8992c.Y(response.body());
                    if (c.a.n0.j.z.a.f8961e) {
                        Log.d("UploadFileTask", "onResponse = " + aVar.data);
                    }
                    this.f8992c.E(aVar);
                } catch (IOException e4) {
                    e = e4;
                    if (c.a.n0.j.z.a.f8961e) {
                    }
                    this.f8992c.D(this.a, -1, e.getMessage());
                }
            }
        }
    }

    /* renamed from: c.a.n0.j.z.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0742b implements c.a.n0.a.f1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8993b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8994c;

        public C0742b(b bVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8994c = bVar;
            this.a = j;
            this.f8993b = str;
        }

        @Override // c.a.n0.a.f1.p.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f8994c.W(this.a, j, this.f8993b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.n0.a.b0.c cVar, c.a.n0.a.o.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.n0.a.b0.c) objArr2[0], (c.a.n0.a.o.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8990h = 0L;
        this.a = 3;
    }

    public static void Z(MultipartBody.Builder builder, c.a.n0.a.o.b.a aVar) {
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

    @Override // c.a.n0.j.z.a
    public void D(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            super.D(str, i, str2);
            c.a.n0.j.g0.e.k(str, i, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String A = A();
            if (!TextUtils.isEmpty(A)) {
                String B = this.f8964b.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    D(A, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (d.x(B)) {
                    D(A, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.f8964b.b("header") && this.f8964b.getType("header") != 9) {
                    D(A, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File V = V(A, B);
                    if (V != null) {
                        c.a.n0.a.o.b.a w = this.f8964b.w("formData");
                        Request.Builder builder = new Request.Builder();
                        c.a.n0.a.f1.c cVar = new c.a.n0.a.f1.c(V, IMAudioTransRequest.CONTENT_TYPE, new C0742b(this, V.length(), A));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Z(type, w);
                        type.addFormDataPart(this.f8964b.B("name"), V.getName(), cVar);
                        MultipartBody build = type.build();
                        H(builder, this.f8964b.w("header"), new HashMap(), false);
                        return builder.url(A).tag(this.f8965c).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File V(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = f.U().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        D(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.f8964b.B("name"))) {
                        D(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.f8964b.b("formData") || this.f8964b.getType("formData") == 9) {
                        return file;
                    } else {
                        D(str, -1, "uploadFile:formData is invalid");
                        return null;
                    }
                }
                D(str, -1, "request:file not exists or not file");
                return null;
            }
            D(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void W(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) || j <= 0 || j2 > j || j2 == 0) {
            return;
        }
        int floor = (int) Math.floor((100 * j2) / j);
        if (System.currentTimeMillis() - this.f8990h > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new c(floor, j, j2)));
            }
            this.f8990h = System.currentTimeMillis();
        }
    }

    public final void X(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            if (c.a.n0.j.z.a.f8961e) {
                Log.d("UploadFileTask", "onFailure: " + str2);
            }
            D(str, i, ("Socket is closed".equalsIgnoreCase(str2) || "Canceled".equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public final Object Y(ResponseBody responseBody) throws IOException {
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
        Request U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f8964b == null || (U = U()) == null) {
            return;
        }
        if (c.a.n0.a.t1.e.L() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = U.url().toString();
        c.a.n0.j.z.b bVar = (c.a.n0.j.z.b) c.a.n0.a.t1.e.L().h0();
        bVar.call(U, new a(this, httpUrl, bVar));
    }
}
