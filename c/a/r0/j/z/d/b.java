package c.a.r0.j.z.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.f2.f.f;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.p1.o.a;
import c.a.r0.j.z.f.e;
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
/* loaded from: classes6.dex */
public class b extends c.a.r0.j.z.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes6.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j.z.b f11299b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11300c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.o2.f.d f11301d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11302e;

        public a(b bVar, String str, c.a.r0.j.z.b bVar2, boolean z, c.a.r0.a.o2.f.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, bVar2, Boolean.valueOf(z), dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11302e = bVar;
            this.a = str;
            this.f11299b = bVar2;
            this.f11300c = z;
            this.f11301d = dVar;
        }

        @Override // c.a.r0.a.p1.o.a.b
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f11302e.C(this.a, -1, "downloadFile:fail exceed max file size");
                this.f11299b.cancelTag(this.f11302e.f11290g);
            }
        }

        @Override // c.a.r0.a.p1.o.a.b
        public void b(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || System.currentTimeMillis() - this.f11302e.l <= 500) {
                return;
            }
            if (j3 <= 52428800 && j2 <= 52428800) {
                if (i2 <= 100) {
                    c.a.r0.j.z.d.a aVar = new c.a.r0.j.z.d.a(i2, j3, j2);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f11302e.dispatchEvent(jSEvent);
                }
                if (this.f11300c && this.f11301d.d().a(j2)) {
                    this.f11302e.C(this.a, -1, "downloadFile:fail exceed max file size");
                    this.f11299b.cancelTag(this.f11302e.f11290g);
                }
            } else {
                this.f11302e.C(this.a, -1, "downloadFile:fail exceed max file size");
                this.f11299b.cancelTag(this.f11302e.f11290g);
            }
            this.f11302e.l = System.currentTimeMillis();
        }

        @Override // c.a.r0.a.p1.o.a.b
        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f11302e.C(this.a, 0, "progress callback fail()");
                this.f11299b.cancelTag(this.f11302e.f11290g);
            }
        }
    }

    /* renamed from: c.a.r0.j.z.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0781b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11303b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11304c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.o2.f.d f11305d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f11307f;

        public C0781b(b bVar, String str, String str2, String str3, c.a.r0.a.o2.f.d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11307f = bVar;
            this.a = str;
            this.f11303b = str2;
            this.f11304c = str3;
            this.f11305d = dVar;
            this.f11306e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f11307f.C(this.a, 0, iOException.getMessage());
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
                    jSEvent.data = new e(this.f11307f.I(response.headers()));
                    this.f11307f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.m) {
                        e2.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.f11303b)) {
                        str2 = f.A(this.f11307f.I(response.headers()), this.f11304c);
                    } else {
                        str2 = this.f11307f.U(this.f11303b);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (b.m) {
                        String str3 = "the real file path is " + str2;
                    }
                    if (TextUtils.isEmpty(this.f11303b)) {
                        str = this.f11305d.g(str2);
                    } else {
                        str = this.f11303b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f11307f.C(this.a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f11303b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(str2);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f11306e) {
                            this.f11305d.d().b(-length);
                        }
                    }
                    if (this.f11307f.V(byteStream, file)) {
                        if (this.f11306e) {
                            this.f11305d.d().b(file.length());
                        }
                        this.f11307f.D(cVar);
                    } else {
                        this.f11307f.C(this.a, -1, "downloadFile:fail abort");
                    }
                    c.a.r0.w.d.d(byteStream);
                    c.a.r0.w.d.d(response);
                    if (b.m) {
                        String str4 = "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message;
                    }
                    n.u(code, this.a, 1, message);
                    return;
                }
                this.f11307f.C(this.a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-658165463, "Lc/a/r0/j/z/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-658165463, "Lc/a/r0/j/z/d/b;");
                return;
            }
        }
        m = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.r0.a.l0.c cVar, c.a.r0.a.y.b.a aVar) {
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
                super((c.a.r0.a.l0.c) objArr2[0], (c.a.r0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11288e = 2;
    }

    @Override // c.a.r0.j.z.a
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            c.a.r0.j.g0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void T(Request request, String str, String str2, c.a.r0.j.z.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            c.a.r0.a.o2.f.d G = c.a.r0.a.g1.f.U().G();
            boolean b2 = G.b(str);
            n.A(httpUrl, 1);
            bVar.call(request, Collections.singletonList(dVar), new C0781b(this, httpUrl, str, str2, G, b2));
        }
    }

    @Nullable
    public String U(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = c.a.r0.a.g1.f.U().G().i(str);
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

    public boolean V(InputStream inputStream, File file) {
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
                    c.a.r0.w.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            c.a.r0.w.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            c.a.r0.w.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f11289f == null) {
            return;
        }
        String z = z();
        if (TextUtils.isEmpty(z)) {
            return;
        }
        if (c.a.r0.a.d2.e.L() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        c.a.r0.j.z.b bVar = (c.a.r0.j.z.b) c.a.r0.a.d2.e.L().h0();
        String B = this.f11289f.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (c.a.r0.w.d.x(B)) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        c.a.r0.a.o2.f.d G = c.a.r0.a.g1.f.U().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            C(z, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        G(builder, this.f11289f.w("header"), hashMap, false);
        builder.url(z).tag(this.f11290g).build();
        String t = c.a.r0.w.d.t(z);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(this, z, bVar, b2, G));
        T(builder.build(), B, t, bVar, dVar);
    }
}
