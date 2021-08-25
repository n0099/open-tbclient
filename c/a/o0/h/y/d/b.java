package c.a.o0.h.y.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.c2.f.f;
import c.a.o0.a.j2.k;
import c.a.o0.a.n1.o.a;
import c.a.o0.h.y.f.e;
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
/* loaded from: classes3.dex */
public class b extends c.a.o0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.y.b f11573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11574c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.k2.f.d f11575d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11576e;

        public a(b bVar, String str, c.a.o0.h.y.b bVar2, boolean z, c.a.o0.a.k2.f.d dVar) {
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
            this.f11576e = bVar;
            this.f11572a = str;
            this.f11573b = bVar2;
            this.f11574c = z;
            this.f11575d = dVar;
        }

        @Override // c.a.o0.a.n1.o.a.b
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f11576e.C(this.f11572a, -1, "downloadFile:fail exceed max file size");
                this.f11573b.cancelTag(this.f11576e.f11562g);
            }
        }

        @Override // c.a.o0.a.n1.o.a.b
        public void b(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || System.currentTimeMillis() - this.f11576e.l <= 500) {
                return;
            }
            if (j3 <= 52428800 && j2 <= 52428800) {
                if (i2 <= 100) {
                    c.a.o0.h.y.d.a aVar = new c.a.o0.h.y.d.a(i2, j3, j2);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f11576e.dispatchEvent(jSEvent);
                }
                if (this.f11574c && this.f11575d.d().a(j2)) {
                    this.f11576e.C(this.f11572a, -1, "downloadFile:fail exceed max file size");
                    this.f11573b.cancelTag(this.f11576e.f11562g);
                }
            } else {
                this.f11576e.C(this.f11572a, -1, "downloadFile:fail exceed max file size");
                this.f11573b.cancelTag(this.f11576e.f11562g);
            }
            this.f11576e.l = System.currentTimeMillis();
        }

        @Override // c.a.o0.a.n1.o.a.b
        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f11576e.C(this.f11572a, 0, "progress callback fail()");
                this.f11573b.cancelTag(this.f11576e.f11562g);
            }
        }
    }

    /* renamed from: c.a.o0.h.y.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0601b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11578b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11579c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.k2.f.d f11580d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11581e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f11582f;

        public C0601b(b bVar, String str, String str2, String str3, c.a.o0.a.k2.f.d dVar, boolean z) {
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
            this.f11582f = bVar;
            this.f11577a = str;
            this.f11578b = str2;
            this.f11579c = str3;
            this.f11580d = dVar;
            this.f11581e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f11582f.C(this.f11577a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    k.r(0, this.f11577a, 1, iOException.getMessage());
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String T;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f11582f.I(response.headers()));
                    this.f11582f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.m) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(this.f11578b)) {
                    T = f.A(response, this.f11579c);
                } else {
                    T = this.f11582f.T(this.f11578b);
                }
                if (!TextUtils.isEmpty(T)) {
                    if (b.m) {
                        String str2 = "the real file path is " + T;
                    }
                    if (TextUtils.isEmpty(this.f11578b)) {
                        str = this.f11580d.g(T);
                    } else {
                        str = this.f11578b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f11582f.C(this.f11577a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f11578b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(T);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f11581e) {
                            this.f11580d.d().b(-length);
                        }
                    }
                    if (this.f11582f.U(byteStream, file)) {
                        if (this.f11581e) {
                            this.f11580d.d().b(file.length());
                        }
                        this.f11582f.D(cVar);
                    } else {
                        this.f11582f.C(this.f11577a, -1, "downloadFile:fail abort");
                    }
                    c.a.o0.t.d.d(byteStream);
                    c.a.o0.t.d.d(response);
                    if (b.m) {
                        String str3 = "onResponse: respCode: " + code + ", url=" + this.f11577a + ", msg=" + message;
                    }
                    k.r(code, this.f11577a, 1, message);
                    return;
                }
                this.f11582f.C(this.f11577a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1218438793, "Lc/a/o0/h/y/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1218438793, "Lc/a/o0/h/y/d/b;");
                return;
            }
        }
        m = c.a.o0.a.k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.o0.a.l0.c cVar, c.a.o0.a.y.b.a aVar) {
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
                super((c.a.o0.a.l0.c) objArr2[0], (c.a.o0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11560e = 2;
    }

    @Override // c.a.o0.h.y.a
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            c.a.o0.h.f0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void S(Request request, String str, String str2, c.a.o0.h.y.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            c.a.o0.a.k2.f.d I = c.a.o0.a.g1.f.V().I();
            boolean b2 = I.b(str);
            k.x(httpUrl, 1);
            bVar.a(request, Collections.singletonList(dVar), new C0601b(this, httpUrl, str, str2, I, b2));
        }
    }

    @Nullable
    public String T(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = c.a.o0.a.g1.f.V().I().i(str);
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

    public boolean U(InputStream inputStream, File file) {
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
                    c.a.o0.t.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            c.a.o0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            c.a.o0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f11561f == null) {
            return;
        }
        String z = z();
        if (TextUtils.isEmpty(z)) {
            return;
        }
        if (c.a.o0.a.a2.e.i() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        c.a.o0.h.y.b bVar = (c.a.o0.h.y.b) c.a.o0.a.a2.e.i().X();
        String C = this.f11561f.C("filePath");
        if (!TextUtils.isEmpty(C)) {
            if (c.a.o0.t.d.w(C)) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = C.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        c.a.o0.a.k2.f.d I = c.a.o0.a.g1.f.V().I();
        boolean b2 = I.b(C);
        if (b2 && I.d().a(0L)) {
            C(z, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        G(builder, this.f11561f.x("header"), hashMap, false);
        builder.url(z).tag(this.f11562g).build();
        String s = c.a.o0.t.d.s(z);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(this, z, bVar, b2, I));
        S(builder.build(), C, s, bVar, dVar);
    }
}
