package c.a.n0.j.z.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.d2.n;
import c.a.n0.a.f1.o.a;
import c.a.n0.a.v1.f.f;
import c.a.n0.j.z.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class b extends c.a.n0.j.z.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public long f8971h;

    /* loaded from: classes2.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.z.b f8972b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f8973c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.e2.f.d f8974d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8975e;

        public a(b bVar, String str, c.a.n0.j.z.b bVar2, boolean z, c.a.n0.a.e2.f.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, bVar2, Boolean.valueOf(z), dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8975e = bVar;
            this.a = str;
            this.f8972b = bVar2;
            this.f8973c = z;
            this.f8974d = dVar;
        }

        @Override // c.a.n0.a.f1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f8975e.D(this.a, -1, "downloadFile:fail exceed max file size");
                this.f8972b.cancelTag(this.f8975e.f8965c);
            }
        }

        @Override // c.a.n0.a.f1.o.a.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f8975e.f8971h <= 500) {
                return;
            }
            if (j2 <= 52428800 && j <= 52428800) {
                if (i <= 100) {
                    c.a.n0.j.z.d.a aVar = new c.a.n0.j.z.d.a(i, j2, j);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f8975e.dispatchEvent(jSEvent);
                }
                if (this.f8973c && this.f8974d.d().a(j)) {
                    this.f8975e.D(this.a, -1, "downloadFile:fail exceed max file size");
                    this.f8972b.cancelTag(this.f8975e.f8965c);
                }
            } else {
                this.f8975e.D(this.a, -1, "downloadFile:fail exceed max file size");
                this.f8972b.cancelTag(this.f8975e.f8965c);
            }
            this.f8975e.f8971h = System.currentTimeMillis();
        }

        @Override // c.a.n0.a.f1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f8975e.D(this.a, 0, "progress callback fail()");
                this.f8972b.cancelTag(this.f8975e.f8965c);
            }
        }
    }

    /* renamed from: c.a.n0.j.z.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0741b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8976b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8977c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.e2.f.d f8978d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8980f;

        public C0741b(b bVar, String str, String str2, String str3, c.a.n0.a.e2.f.d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8980f = bVar;
            this.a = str;
            this.f8976b = str2;
            this.f8977c = str3;
            this.f8978d = dVar;
            this.f8979e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f8980f.D(this.a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    n.u(0, this.a, 1, iOException.getMessage());
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f8980f.J(response.headers()));
                    this.f8980f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.i) {
                        e2.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.f8976b)) {
                        str2 = f.A(this.f8980f.J(response.headers()), this.f8977c);
                    } else {
                        str2 = this.f8980f.V(this.f8976b);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (b.i) {
                        Log.d("DownloadTask", "the real file path is " + str2);
                    }
                    if (TextUtils.isEmpty(this.f8976b)) {
                        str = this.f8978d.g(str2);
                    } else {
                        str = this.f8976b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f8980f.D(this.a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f8976b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(str2);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f8979e) {
                            this.f8978d.d().b(-length);
                        }
                    }
                    if (this.f8980f.W(byteStream, file)) {
                        if (this.f8979e) {
                            this.f8978d.d().b(file.length());
                        }
                        this.f8980f.E(cVar);
                    } else {
                        this.f8980f.D(this.a, -1, "downloadFile:fail abort");
                    }
                    c.a.n0.w.d.d(byteStream);
                    c.a.n0.w.d.d(response);
                    if (b.i) {
                        Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message);
                    }
                    n.u(code, this.a, 1, message);
                    return;
                }
                this.f8980f.D(this.a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2060294619, "Lc/a/n0/j/z/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2060294619, "Lc/a/n0/j/z/d/b;");
                return;
            }
        }
        i = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.n0.a.b0.c cVar, c.a.n0.a.o.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.n0.a.b0.c) objArr2[0], (c.a.n0.a.o.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 2;
    }

    @Override // c.a.n0.j.z.a
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            c.a.n0.j.g0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void U(Request request, String str, String str2, c.a.n0.j.z.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            c.a.n0.a.e2.f.d G = c.a.n0.a.w0.f.U().G();
            boolean b2 = G.b(str);
            n.A(httpUrl, 1);
            bVar.call(request, Collections.singletonList(dVar), new C0741b(this, httpUrl, str, str2, G, b2));
        }
    }

    @Nullable
    public String V(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = c.a.n0.a.w0.f.U().G().i(str);
            if (i2 == null) {
                return null;
            }
            boolean endsWith = i2.endsWith(File.separator);
            File parentFile = new File(i2).getParentFile();
            boolean z = parentFile != null && parentFile.exists();
            if (endsWith || !z) {
                return null;
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }

    public boolean W(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    c.a.n0.w.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            c.a.n0.w.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            c.a.n0.w.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f8964b == null) {
            return;
        }
        String A = A();
        if (TextUtils.isEmpty(A)) {
            return;
        }
        if (c.a.n0.a.t1.e.L() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        c.a.n0.j.z.b bVar = (c.a.n0.j.z.b) c.a.n0.a.t1.e.L().h0();
        String B = this.f8964b.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (c.a.n0.w.d.x(B)) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        c.a.n0.a.e2.f.d G = c.a.n0.a.w0.f.U().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            D(A, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        H(builder, this.f8964b.w("header"), hashMap, false);
        builder.url(A).tag(this.f8965c).build();
        String t = c.a.n0.w.d.t(A);
        this.f8971h = 0L;
        d dVar = new d();
        dVar.c(new a(this, A, bVar, b2, G));
        U(builder.build(), B, t, bVar, dVar);
    }
}
