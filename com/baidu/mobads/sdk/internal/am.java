package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class am {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "OAdURLConnection";
    public static final String b = "POST";
    public static final String c = "GET";
    public static final String d = "application/json";
    public static final String e = "text/plain";
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection f;
    public br g;
    public b h;
    public c i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public boolean p;
    public Uri.Builder q;

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, int i);

        void a(String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i);
    }

    /* loaded from: classes3.dex */
    public class a extends h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am b;

        public a(am amVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {amVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = amVar;
        }

        @Override // com.baidu.mobads.sdk.internal.h
        public Object i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.objValue;
            }
            this.b.e();
            this.b.f();
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public am(String str) {
        this(str, "GET");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, this, httpURLConnection)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                        httpURLConnection = httpURLConnection2;
                    } catch (Exception unused) {
                        return httpURLConnection2;
                    }
                } else {
                    return httpURLConnection;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public am(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = br.a();
        this.h = null;
        this.i = null;
        this.m = "text/plain";
        this.n = 10000;
        this.o = 10000;
        this.p = false;
        this.q = null;
        this.j = str;
        this.k = str2;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, httpURLConnection) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && !TextUtils.isEmpty(this.j) && co.a().f(this.j)) {
            try {
                HttpURLConnection a2 = co.a().a(new URL(this.j));
                this.f = a2;
                a2.setConnectTimeout(this.n);
                if (Integer.parseInt(bj.a((Context) null).b()) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                this.f.setRequestMethod(this.k);
                this.f.setUseCaches(this.p);
                if (!TextUtils.isEmpty(this.l)) {
                    this.f.setRequestProperty("User-Agent", this.l);
                }
                this.f.setRequestProperty("Content-type", this.m);
                this.f.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                this.f.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                if (this.k.equals("POST")) {
                    this.f.setDoInput(true);
                    this.f.setDoOutput(true);
                    if (this.q != null) {
                        a(this.q.build().getEncodedQuery(), this.f);
                    }
                }
            } catch (Exception e2) {
                b bVar = this.h;
                if (bVar != null) {
                    bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
                }
                c cVar = this.i;
                if (cVar != null) {
                    cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                try {
                    this.f.connect();
                    br brVar = this.g;
                    brVar.a(a, this.f.getRequestMethod() + " connect code :" + this.f.getResponseCode());
                    int responseCode = this.f.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        this.f.setInstanceFollowRedirects(false);
                        HttpURLConnection a2 = a(this.f);
                        this.f = a2;
                        responseCode = a2.getResponseCode();
                    }
                    if (responseCode / 100 != 2) {
                        if (this.h != null) {
                            this.h.a(this.f.getResponseMessage(), responseCode);
                        }
                        if (this.i != null) {
                            this.i.a(this.f.getResponseMessage(), responseCode);
                        }
                    } else {
                        String g = co.a().g(this.j);
                        if (this.h != null) {
                            this.h.a(c(), g);
                        }
                        if (this.i != null) {
                            this.i.a(this.f.getInputStream(), g);
                        }
                    }
                    httpURLConnection = this.f;
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (Exception e2) {
                    if (this.h != null) {
                        b bVar = this.h;
                        bVar.a("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    if (this.i != null) {
                        c cVar = this.i;
                        cVar.a("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    httpURLConnection = this.f;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.f;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e();
            HttpURLConnection httpURLConnection = this.f;
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getResponseCode() / 100 != 2) {
                        HttpURLConnection httpURLConnection2 = this.f;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return null;
                    }
                    String c2 = c();
                    HttpURLConnection httpURLConnection3 = this.f;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    return c2;
                } catch (Throwable unused) {
                    HttpURLConnection httpURLConnection4 = this.f;
                    if (httpURLConnection4 != null) {
                        httpURLConnection4.disconnect();
                    }
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.f.getInputStream();
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

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.n = i;
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.o = i;
        }
    }

    public void a(Uri.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder) == null) {
            this.q = builder;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.h = bVar;
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && this.f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                ba.a().a((h) new a(this));
            } catch (Exception unused) {
            }
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (httpURLConnection = this.f) != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                av.h(a).f(e2.toString());
            }
        }
    }
}
