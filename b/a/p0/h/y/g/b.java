package b.a.p0.h.y.g;

import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.g1.f;
import b.a.p0.h.y.f.e;
import b.a.p0.t.d;
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
/* loaded from: classes4.dex */
public class b extends b.a.p0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes4.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.y.b f10823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10824c;

        public a(b bVar, String str, b.a.p0.h.y.b bVar2) {
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
            this.f10824c = bVar;
            this.f10822a = str;
            this.f10823b = bVar2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f10823b.cancelTag(this.f10824c.f10788g);
                this.f10824c.V(this.f10822a, 0, iOException.getMessage());
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
                        jSEvent.data = new e(this.f10824c.H(response.headers()));
                        this.f10824c.dispatchEvent(jSEvent);
                    } catch (JSONException e2) {
                        try {
                            if (b.a.p0.h.y.a.f10785i) {
                                e2.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            if (b.a.p0.h.y.a.f10785i) {
                            }
                            this.f10824c.B(this.f10822a, -1, e.getMessage());
                        }
                    }
                    b.a.p0.h.y.g.a aVar = new b.a.p0.h.y.g.a();
                    aVar.statusCode = response.code();
                    aVar.header = this.f10824c.H(response.headers());
                    aVar.data = this.f10824c.W(response.body());
                    if (b.a.p0.h.y.a.f10785i) {
                        String str = "onResponse = " + aVar.data;
                    }
                    this.f10824c.C(aVar);
                } catch (IOException e4) {
                    e = e4;
                    if (b.a.p0.h.y.a.f10785i) {
                        Log.getStackTraceString(e);
                    }
                    this.f10824c.B(this.f10822a, -1, e.getMessage());
                }
            }
        }
    }

    /* renamed from: b.a.p0.h.y.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0599b implements b.a.p0.a.n1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f10825a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10827c;

        public C0599b(b bVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10827c = bVar;
            this.f10825a = j;
            this.f10826b = str;
        }

        @Override // b.a.p0.a.n1.p.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f10827c.U(this.f10825a, j, this.f10826b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.l0.c cVar, b.a.p0.a.y.b.a aVar) {
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
                super((b.a.p0.a.l0.c) objArr2[0], (b.a.p0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0L;
        this.f10786e = 3;
    }

    public static void X(MultipartBody.Builder builder, b.a.p0.a.y.b.a aVar) {
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

    @Override // b.a.p0.h.y.a
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            b.a.p0.h.f0.e.k(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String y = y();
            if (!TextUtils.isEmpty(y)) {
                String B = this.f10787f.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    B(y, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (d.w(B)) {
                    B(y, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.f10787f.b("header") && this.f10787f.getType("header") != 9) {
                    B(y, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File T = T(y, B);
                    if (T != null) {
                        b.a.p0.a.y.b.a w = this.f10787f.w("formData");
                        Request.Builder builder = new Request.Builder();
                        b.a.p0.a.n1.c cVar = new b.a.p0.a.n1.c(T, IMAudioTransRequest.CONTENT_TYPE, new C0599b(this, T.length(), y));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        X(type, w);
                        type.addFormDataPart(this.f10787f.B("name"), T.getName(), cVar);
                        MultipartBody build = type.build();
                        F(builder, this.f10787f.w("header"), new HashMap(), false);
                        return builder.url(y).tag(this.f10788g).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File T(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = f.T().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        B(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.f10787f.B("name"))) {
                        B(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.f10787f.b("formData") || this.f10787f.getType("formData") == 9) {
                        return file;
                    } else {
                        B(str, -1, "uploadFile:formData is invalid");
                        return null;
                    }
                }
                B(str, -1, "request:file not exists or not file");
                return null;
            }
            B(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void U(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) || j <= 0 || j2 > j || j2 == 0) {
            return;
        }
        int floor = (int) Math.floor((100 * j2) / j);
        if (System.currentTimeMillis() - this.l > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new c(floor, j, j2)));
            }
            this.l = System.currentTimeMillis();
        }
    }

    public final void V(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            if (b.a.p0.h.y.a.f10785i) {
                String str3 = "onFailure: " + str2;
            }
            B(str, i2, ("Socket is closed".equalsIgnoreCase(str2) || ResponseException.CANCELED.equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public final Object W(ResponseBody responseBody) throws IOException {
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
        Request S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f10787f == null || (S = S()) == null) {
            return;
        }
        if (b.a.p0.a.a2.e.i() == null) {
            B("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = S.url().toString();
        b.a.p0.h.y.b bVar = (b.a.p0.h.y.b) b.a.p0.a.a2.e.i().W();
        bVar.call(S, new a(this, httpUrl, bVar));
    }
}
