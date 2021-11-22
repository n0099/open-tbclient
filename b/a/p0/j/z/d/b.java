package b.a.p0.j.z.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.f2.f.f;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.p1.o.a;
import b.a.p0.j.z.f.e;
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
/* loaded from: classes4.dex */
public class b extends b.a.p0.j.z.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11520a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.z.b f11521b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11522c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.o2.f.d f11523d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11524e;

        public a(b bVar, String str, b.a.p0.j.z.b bVar2, boolean z, b.a.p0.a.o2.f.d dVar) {
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
            this.f11524e = bVar;
            this.f11520a = str;
            this.f11521b = bVar2;
            this.f11522c = z;
            this.f11523d = dVar;
        }

        @Override // b.a.p0.a.p1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f11524e.C(this.f11520a, -1, "downloadFile:fail exceed max file size");
                this.f11521b.cancelTag(this.f11524e.f11510g);
            }
        }

        @Override // b.a.p0.a.p1.o.a.b
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f11524e.l <= 500) {
                return;
            }
            if (j2 <= 52428800 && j <= 52428800) {
                if (i2 <= 100) {
                    b.a.p0.j.z.d.a aVar = new b.a.p0.j.z.d.a(i2, j2, j);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f11524e.dispatchEvent(jSEvent);
                }
                if (this.f11522c && this.f11523d.d().a(j)) {
                    this.f11524e.C(this.f11520a, -1, "downloadFile:fail exceed max file size");
                    this.f11521b.cancelTag(this.f11524e.f11510g);
                }
            } else {
                this.f11524e.C(this.f11520a, -1, "downloadFile:fail exceed max file size");
                this.f11521b.cancelTag(this.f11524e.f11510g);
            }
            this.f11524e.l = System.currentTimeMillis();
        }

        @Override // b.a.p0.a.p1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f11524e.C(this.f11520a, 0, "progress callback fail()");
                this.f11521b.cancelTag(this.f11524e.f11510g);
            }
        }
    }

    /* renamed from: b.a.p0.j.z.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0632b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11525a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11526b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11527c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.o2.f.d f11528d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f11530f;

        public C0632b(b bVar, String str, String str2, String str3, b.a.p0.a.o2.f.d dVar, boolean z) {
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
            this.f11530f = bVar;
            this.f11525a = str;
            this.f11526b = str2;
            this.f11527c = str3;
            this.f11528d = dVar;
            this.f11529e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f11530f.C(this.f11525a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    n.u(0, this.f11525a, 1, iOException.getMessage());
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
                    jSEvent.data = new e(this.f11530f.I(response.headers()));
                    this.f11530f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.m) {
                        e2.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.f11526b)) {
                        str2 = f.A(this.f11530f.I(response.headers()), this.f11527c);
                    } else {
                        str2 = this.f11530f.U(this.f11526b);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (b.m) {
                        String str3 = "the real file path is " + str2;
                    }
                    if (TextUtils.isEmpty(this.f11526b)) {
                        str = this.f11528d.g(str2);
                    } else {
                        str = this.f11526b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f11530f.C(this.f11525a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f11526b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(str2);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f11529e) {
                            this.f11528d.d().b(-length);
                        }
                    }
                    if (this.f11530f.V(byteStream, file)) {
                        if (this.f11529e) {
                            this.f11528d.d().b(file.length());
                        }
                        this.f11530f.D(cVar);
                    } else {
                        this.f11530f.C(this.f11525a, -1, "downloadFile:fail abort");
                    }
                    b.a.p0.w.d.d(byteStream);
                    b.a.p0.w.d.d(response);
                    if (b.m) {
                        String str4 = "onResponse: respCode: " + code + ", url=" + this.f11525a + ", msg=" + message;
                    }
                    n.u(code, this.f11525a, 1, message);
                    return;
                }
                this.f11530f.C(this.f11525a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428185446, "Lb/a/p0/j/z/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1428185446, "Lb/a/p0/j/z/d/b;");
                return;
            }
        }
        m = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.l0.c cVar, b.a.p0.a.y.b.a aVar) {
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
                super((b.a.p0.a.l0.c) objArr2[0], (b.a.p0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11508e = 2;
    }

    @Override // b.a.p0.j.z.a
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            b.a.p0.j.g0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void T(Request request, String str, String str2, b.a.p0.j.z.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            b.a.p0.a.o2.f.d G = b.a.p0.a.g1.f.U().G();
            boolean b2 = G.b(str);
            n.A(httpUrl, 1);
            bVar.call(request, Collections.singletonList(dVar), new C0632b(this, httpUrl, str, str2, G, b2));
        }
    }

    @Nullable
    public String U(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = b.a.p0.a.g1.f.U().G().i(str);
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
                    b.a.p0.w.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            b.a.p0.w.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            b.a.p0.w.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f11509f == null) {
            return;
        }
        String z = z();
        if (TextUtils.isEmpty(z)) {
            return;
        }
        if (b.a.p0.a.d2.e.L() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        b.a.p0.j.z.b bVar = (b.a.p0.j.z.b) b.a.p0.a.d2.e.L().h0();
        String B = this.f11509f.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (b.a.p0.w.d.x(B)) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        b.a.p0.a.o2.f.d G = b.a.p0.a.g1.f.U().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            C(z, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        G(builder, this.f11509f.w("header"), hashMap, false);
        builder.url(z).tag(this.f11510g).build();
        String t = b.a.p0.w.d.t(z);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(this, z, bVar, b2, G));
        T(builder.build(), B, t, bVar, dVar);
    }
}
