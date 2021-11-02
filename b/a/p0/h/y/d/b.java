package b.a.p0.h.y.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.c2.f.f;
import b.a.p0.a.j2.k;
import b.a.p0.a.n1.o.a;
import b.a.p0.h.y.f.e;
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
public class b extends b.a.p0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10798a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.y.b f10799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10800c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.k2.f.d f10801d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10802e;

        public a(b bVar, String str, b.a.p0.h.y.b bVar2, boolean z, b.a.p0.a.k2.f.d dVar) {
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
            this.f10802e = bVar;
            this.f10798a = str;
            this.f10799b = bVar2;
            this.f10800c = z;
            this.f10801d = dVar;
        }

        @Override // b.a.p0.a.n1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f10802e.B(this.f10798a, -1, "downloadFile:fail exceed max file size");
                this.f10799b.cancelTag(this.f10802e.f10788g);
            }
        }

        @Override // b.a.p0.a.n1.o.a.b
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f10802e.l <= 500) {
                return;
            }
            if (j2 <= 52428800 && j <= 52428800) {
                if (i2 <= 100) {
                    b.a.p0.h.y.d.a aVar = new b.a.p0.h.y.d.a(i2, j2, j);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f10802e.dispatchEvent(jSEvent);
                }
                if (this.f10800c && this.f10801d.d().a(j)) {
                    this.f10802e.B(this.f10798a, -1, "downloadFile:fail exceed max file size");
                    this.f10799b.cancelTag(this.f10802e.f10788g);
                }
            } else {
                this.f10802e.B(this.f10798a, -1, "downloadFile:fail exceed max file size");
                this.f10799b.cancelTag(this.f10802e.f10788g);
            }
            this.f10802e.l = System.currentTimeMillis();
        }

        @Override // b.a.p0.a.n1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f10802e.B(this.f10798a, 0, "progress callback fail()");
                this.f10799b.cancelTag(this.f10802e.f10788g);
            }
        }
    }

    /* renamed from: b.a.p0.h.y.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0598b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10804b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10805c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.k2.f.d f10806d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f10807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10808f;

        public C0598b(b bVar, String str, String str2, String str3, b.a.p0.a.k2.f.d dVar, boolean z) {
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
            this.f10808f = bVar;
            this.f10803a = str;
            this.f10804b = str2;
            this.f10805c = str3;
            this.f10806d = dVar;
            this.f10807e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f10808f.B(this.f10803a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    k.r(0, this.f10803a, 1, iOException.getMessage());
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String S;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f10808f.H(response.headers()));
                    this.f10808f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.m) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(this.f10804b)) {
                    S = f.A(response, this.f10805c);
                } else {
                    S = this.f10808f.S(this.f10804b);
                }
                if (!TextUtils.isEmpty(S)) {
                    if (b.m) {
                        String str2 = "the real file path is " + S;
                    }
                    if (TextUtils.isEmpty(this.f10804b)) {
                        str = this.f10806d.g(S);
                    } else {
                        str = this.f10804b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f10808f.B(this.f10803a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f10804b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(S);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f10807e) {
                            this.f10806d.d().b(-length);
                        }
                    }
                    if (this.f10808f.T(byteStream, file)) {
                        if (this.f10807e) {
                            this.f10806d.d().b(file.length());
                        }
                        this.f10808f.C(cVar);
                    } else {
                        this.f10808f.B(this.f10803a, -1, "downloadFile:fail abort");
                    }
                    b.a.p0.t.d.d(byteStream);
                    b.a.p0.t.d.d(response);
                    if (b.m) {
                        String str3 = "onResponse: respCode: " + code + ", url=" + this.f10803a + ", msg=" + message;
                    }
                    k.r(code, this.f10803a, 1, message);
                    return;
                }
                this.f10808f.B(this.f10803a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2086064375, "Lb/a/p0/h/y/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2086064375, "Lb/a/p0/h/y/d/b;");
                return;
            }
        }
        m = b.a.p0.a.k.f6397a;
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
        this.f10786e = 2;
    }

    @Override // b.a.p0.h.y.a
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            b.a.p0.h.f0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void R(Request request, String str, String str2, b.a.p0.h.y.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            b.a.p0.a.k2.f.d G = b.a.p0.a.g1.f.T().G();
            boolean b2 = G.b(str);
            k.x(httpUrl, 1);
            bVar.call(request, Collections.singletonList(dVar), new C0598b(this, httpUrl, str, str2, G, b2));
        }
    }

    @Nullable
    public String S(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = b.a.p0.a.g1.f.T().G().i(str);
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

    public boolean T(InputStream inputStream, File file) {
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
                    b.a.p0.t.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            b.a.p0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            b.a.p0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f10787f == null) {
            return;
        }
        String y = y();
        if (TextUtils.isEmpty(y)) {
            return;
        }
        if (b.a.p0.a.a2.e.i() == null) {
            B("", -1, "request:swanApp is null");
            return;
        }
        b.a.p0.h.y.b bVar = (b.a.p0.h.y.b) b.a.p0.a.a2.e.i().W();
        String B = this.f10787f.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (b.a.p0.t.d.w(B)) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        b.a.p0.a.k2.f.d G = b.a.p0.a.g1.f.T().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            B(y, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        F(builder, this.f10787f.w("header"), hashMap, false);
        builder.url(y).tag(this.f10788g).build();
        String s = b.a.p0.t.d.s(y);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(this, y, bVar, b2, G));
        R(builder.build(), B, s, bVar, dVar);
    }
}
