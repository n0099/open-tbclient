package c.a.h0.a.h;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f3324a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.h0.a.k.b f3325b;

    /* renamed from: c  reason: collision with root package name */
    public b f3326c;

    /* renamed from: d  reason: collision with root package name */
    public c f3327d;

    /* renamed from: e  reason: collision with root package name */
    public String f3328e;

    /* renamed from: f  reason: collision with root package name */
    public String f3329f;

    /* renamed from: g  reason: collision with root package name */
    public String f3330g;

    /* renamed from: h  reason: collision with root package name */
    public String f3331h;

    /* renamed from: i  reason: collision with root package name */
    public int f3332i;

    /* renamed from: j  reason: collision with root package name */
    public int f3333j;
    public boolean k;
    public Uri.Builder l;
    public int m;

    /* renamed from: c.a.h0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076a extends c.a.h0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f3334g;

        public C0076a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3334g = aVar;
        }

        @Override // c.a.h0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f3334g.i();
                this.f3334g.e();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onFail(String str, int i2);

        void onSuccess(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onFail(String str, int i2);

        void onSuccess(InputStream inputStream, String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2, String str) {
        this(i2, str, "GET");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            this.f3327d = cVar;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.m == 1) {
                    c.a.h0.a.l.c.a().c(new C0076a(this));
                } else {
                    c.a.h0.a.l.c.a().c(new C0076a(this));
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
                    this.f3324a.connect();
                    c.a.h0.a.k.b bVar = this.f3325b;
                    bVar.b(OAdURLConnection.TAG, this.f3324a.getRequestMethod() + " connect code :" + this.f3324a.getResponseCode());
                    int responseCode = this.f3324a.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        this.f3324a.setInstanceFollowRedirects(false);
                        HttpURLConnection g2 = g(this.f3324a);
                        this.f3324a = g2;
                        responseCode = g2.getResponseCode();
                    }
                    if (responseCode / 100 != 2) {
                        if (this.f3326c != null) {
                            this.f3326c.onFail(this.f3324a.getResponseMessage(), responseCode);
                        }
                        if (this.f3327d != null) {
                            this.f3327d.onFail(this.f3324a.getResponseMessage(), responseCode);
                        }
                    } else {
                        String a2 = c.a.h0.a.l.a.a(this.f3328e);
                        if (this.f3326c != null) {
                            this.f3326c.onSuccess(f(), a2);
                        }
                        if (this.f3327d != null) {
                            this.f3327d.onSuccess(this.f3324a.getInputStream(), a2);
                        }
                    }
                    httpURLConnection = this.f3324a;
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (Exception e2) {
                    if (this.f3326c != null) {
                        b bVar2 = this.f3326c;
                        bVar2.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    if (this.f3327d != null) {
                        c cVar = this.f3327d;
                        cVar.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    httpURLConnection = this.f3324a;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.f3324a;
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
                inputStream = this.f3324a.getInputStream();
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
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || TextUtils.isEmpty(this.f3328e)) {
            return;
        }
        try {
            HttpURLConnection b2 = c.a.h0.a.l.a.b(new URL(this.f3328e));
            this.f3324a = b2;
            b2.setConnectTimeout(this.f3332i);
            this.f3324a.setReadTimeout(this.f3333j);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f3324a.setRequestMethod(this.f3329f);
            this.f3324a.setUseCaches(this.k);
            if (!TextUtils.isEmpty(this.f3330g)) {
                this.f3324a.setRequestProperty("User-Agent", this.f3330g);
            }
            this.f3324a.setRequestProperty("Content-type", this.f3331h);
            this.f3324a.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.f3324a.setRequestProperty("Cache-Control", "no-cache");
            if (this.f3329f.equals("POST")) {
                this.f3324a.setDoInput(true);
                this.f3324a.setDoOutput(true);
                if (this.l != null) {
                    h(this.l.build().getEncodedQuery(), this.f3324a);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            b bVar = this.f3326c;
            if (bVar != null) {
                bVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f3327d;
            if (cVar != null) {
                cVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            b bVar2 = this.f3326c;
            if (bVar2 != null) {
                bVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
            c cVar2 = this.f3327d;
            if (cVar2 != null) {
                cVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3325b = c.a.h0.a.k.b.i();
        this.f3326c = null;
        this.f3327d = null;
        this.f3331h = "text/plain";
        this.f3332i = 10000;
        this.f3333j = 10000;
        this.k = false;
        this.l = null;
        this.m = i2;
        this.f3328e = str;
        this.f3329f = str2;
    }
}
