package c.a.i0.a.i;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection a;

    /* renamed from: b  reason: collision with root package name */
    public b f3059b;

    /* renamed from: c  reason: collision with root package name */
    public c f3060c;

    /* renamed from: d  reason: collision with root package name */
    public String f3061d;

    /* renamed from: e  reason: collision with root package name */
    public String f3062e;

    /* renamed from: f  reason: collision with root package name */
    public String f3063f;

    /* renamed from: g  reason: collision with root package name */
    public String f3064g;

    /* renamed from: h  reason: collision with root package name */
    public int f3065h;
    public int i;
    public boolean j;
    public Uri.Builder k;
    public int l;

    /* renamed from: c.a.i0.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0154a extends c.a.i0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3066c;

        public C0154a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3066c = aVar;
        }

        @Override // c.a.i0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f3066c.i();
                this.f3066c.e();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, int i);

        void onSuccess(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, int i);

        void b(InputStream inputStream, String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i, String str) {
        this(i, str, "GET");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f3060c = cVar;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.l == 1) {
                    c.a.i0.a.m.c.a().c(new C0154a(this));
                } else {
                    c.a.i0.a.m.c.a().c(new C0154a(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    public final void e() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                try {
                    this.a.connect();
                    int responseCode = this.a.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        this.a.setInstanceFollowRedirects(false);
                        HttpURLConnection g2 = g(this.a);
                        this.a = g2;
                        responseCode = g2.getResponseCode();
                    }
                    if (responseCode / 100 != 2) {
                        if (this.f3059b != null) {
                            this.f3059b.a(this.a.getResponseMessage(), responseCode);
                        }
                        if (this.f3060c != null) {
                            this.f3060c.a(this.a.getResponseMessage(), responseCode);
                        }
                    } else {
                        String a = c.a.i0.a.m.a.a(this.f3061d);
                        if (this.f3059b != null) {
                            this.f3059b.onSuccess(f(), a);
                        }
                        if (this.f3060c != null) {
                            this.f3060c.b(this.a.getInputStream(), a);
                        }
                    }
                    httpURLConnection = this.a;
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (Exception e2) {
                    if (this.f3059b != null) {
                        b bVar = this.f3059b;
                        bVar.a("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    if (this.f3060c != null) {
                        c cVar = this.f3060c;
                        cVar.a("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    httpURLConnection = this.a;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.a;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }

    public String f() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.a.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[128];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toString();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return (String) invokeV.objValue;
    }

    public final HttpURLConnection g(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, httpURLConnection)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(Headers.LOCATION)).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public final void h(String str, HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, str, httpURLConnection) != null) {
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || TextUtils.isEmpty(this.f3061d)) {
            return;
        }
        try {
            HttpURLConnection b2 = c.a.i0.a.m.a.b(new URL(this.f3061d));
            this.a = b2;
            b2.setConnectTimeout(this.f3065h);
            this.a.setReadTimeout(this.i);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.a.setRequestMethod(this.f3062e);
            this.a.setUseCaches(this.j);
            if (!TextUtils.isEmpty(this.f3063f)) {
                this.a.setRequestProperty("User-Agent", this.f3063f);
            }
            this.a.setRequestProperty("Content-type", this.f3064g);
            this.a.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.a.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
            if (this.f3062e.equals("POST")) {
                this.a.setDoInput(true);
                this.a.setDoOutput(true);
                if (this.k != null) {
                    h(this.k.build().getEncodedQuery(), this.a);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            b bVar = this.f3059b;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f3060c;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            b bVar2 = this.f3059b;
            if (bVar2 != null) {
                bVar2.a("Net Create RuntimeError: " + th.toString(), 0);
            }
            c cVar2 = this.f3060c;
            if (cVar2 != null) {
                cVar2.a("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3059b = null;
        this.f3060c = null;
        this.f3064g = "text/plain";
        this.f3065h = 10000;
        this.i = 10000;
        this.j = false;
        this.k = null;
        this.l = i;
        this.f3061d = str;
        this.f3062e = str2;
    }
}
