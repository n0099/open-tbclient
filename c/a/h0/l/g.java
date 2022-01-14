package c.a.h0.l;

import android.os.Handler;
import android.os.Looper;
import c.a.h0.i;
import c.a.h0.r.h;
import c.a.h0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes.dex */
public class g implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3515b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.l.c f3517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.l.a f3518g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f3519h;

        /* renamed from: c.a.h0.l.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0137a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f3520e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f3521f;

            public RunnableC0137a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3521f = aVar;
                this.f3520e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3521f.f3518g.c(this.f3520e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f3522e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f3523f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f3524g;

            public b(a aVar, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3524g = aVar;
                this.f3522e = i2;
                this.f3523f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.h0.l.a aVar = this.f3524g.f3518g;
                    aVar.a(new IOException("status code " + this.f3522e + ", response " + this.f3523f), 119501, this.f3523f);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f3525e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f3526f;

            public c(a aVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3526f = aVar;
                this.f3525e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.h0.l.a aVar = this.f3526f.f3518g;
                    Throwable th = this.f3525e;
                    aVar.a(th, 119501, th.getMessage());
                }
            }
        }

        public a(g gVar, String str, c.a.h0.l.c cVar, c.a.h0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3519h = gVar;
            this.f3516e = str;
            this.f3517f = cVar;
            this.f3518g = aVar;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00ce */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0051 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r5v4, types: [c.a.h0.l.a] */
        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            HttpURLConnection httpURLConnection;
            int responseCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ?? r0 = 119501;
                r0 = 119501;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.f3516e).openConnection();
                    for (Map.Entry<String, String> entry : this.f3517f.c().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                }
                try {
                    if (responseCode >= 200 && responseCode <= 299) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        String c2 = c.a.h0.r.f.c(inputStream);
                        httpURLConnection = inputStream;
                        if (this.f3518g != null) {
                            if (this.f3519h.f3515b) {
                                this.f3519h.a.post(new RunnableC0137a(this, c2));
                                httpURLConnection = inputStream;
                            } else {
                                this.f3518g.c(c2);
                                httpURLConnection = inputStream;
                            }
                        }
                    } else {
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        String c3 = c.a.h0.r.f.c(errorStream);
                        httpURLConnection = errorStream;
                        if (this.f3518g != null) {
                            if (this.f3519h.f3515b) {
                                this.f3519h.a.post(new b(this, responseCode, c3));
                                httpURLConnection = errorStream;
                            } else {
                                c.a.h0.l.a aVar = this.f3518g;
                                StringBuilder sb = new StringBuilder();
                                sb.append("status code ");
                                sb.append(responseCode);
                                sb.append(", response ");
                                sb.append(c3);
                                aVar.a(new IOException(sb.toString()), 119501, c3);
                                httpURLConnection = errorStream;
                            }
                        }
                    }
                    r0 = new Closeable[]{httpURLConnection};
                    c.a.h0.r.f.a(r0);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        if (this.f3518g != null) {
                            h.c("GET FAILED", th);
                            if (this.f3519h.f3515b) {
                                this.f3519h.a.post(new c(this, th));
                            } else {
                                this.f3518g.a(th, r0, th.getMessage());
                            }
                        }
                        c.a.h0.r.f.a(new Closeable[]{httpURLConnection});
                    } catch (Throwable th4) {
                        c.a.h0.r.f.a(new Closeable[]{httpURLConnection});
                        throw th4;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3527e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.l.c f3528f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.l.b f3529g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.l.a f3530h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f3531i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f3532e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f3533f;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3533f = bVar;
                this.f3532e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3533f.f3530h.c(this.f3532e);
                }
            }
        }

        /* renamed from: c.a.h0.l.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0138b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f3534e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f3535f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f3536g;

            public RunnableC0138b(b bVar, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3536g = bVar;
                this.f3534e = i2;
                this.f3535f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.h0.l.a aVar = this.f3536g.f3530h;
                    aVar.a(new IOException("status code " + this.f3534e + ", response " + this.f3535f), this.f3534e, l.a().getResources().getString(i.poly_error_tips));
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f3537e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f3538f;

            public c(b bVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3538f = bVar;
                this.f3537e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3538f.f3530h.a(this.f3537e, -1000, l.a().getResources().getString(i.poly_error_tips));
                }
            }
        }

        public b(g gVar, String str, c.a.h0.l.c cVar, c.a.h0.l.b bVar, c.a.h0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, cVar, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3531i = gVar;
            this.f3527e = str;
            this.f3528f = cVar;
            this.f3529g = bVar;
            this.f3530h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataOutputStream dataOutputStream;
            InputStream errorStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            c.a.h0.p.b.a("1.03", System.currentTimeMillis());
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f3527e).openConnection();
                for (Map.Entry<String, String> entry : this.f3528f.c().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : this.f3529g.c().entrySet()) {
                    String encode = URLEncoder.encode(entry2.getValue());
                    sb.append(entry2.getKey());
                    sb.append("=");
                    sb.append(encode);
                    sb.append("&");
                }
                byte[] bytes = sb.toString().getBytes();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode <= 299) {
                        errorStream = httpURLConnection.getInputStream();
                        String c2 = c.a.h0.r.f.c(errorStream);
                        if (this.f3530h != null) {
                            if (this.f3531i.f3515b) {
                                this.f3531i.a.post(new a(this, c2));
                            } else {
                                this.f3530h.c(c2);
                            }
                        }
                    } else {
                        errorStream = httpURLConnection.getErrorStream();
                        String c3 = c.a.h0.r.f.c(errorStream);
                        if (this.f3530h != null) {
                            if (this.f3531i.f3515b) {
                                this.f3531i.a.post(new RunnableC0138b(this, responseCode, c3));
                            } else {
                                c.a.h0.l.a aVar = this.f3530h;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("status code ");
                                sb2.append(responseCode);
                                sb2.append(", response ");
                                sb2.append(c3);
                                aVar.a(new IOException(sb2.toString()), responseCode, l.a().getResources().getString(i.poly_error_tips));
                            }
                        }
                    }
                    c.a.h0.r.f.a(errorStream, dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    try {
                        h.c("POST FAILED", th);
                        if (this.f3530h != null) {
                            if (this.f3531i.f3515b) {
                                this.f3531i.a.post(new c(this, th));
                            } else {
                                this.f3530h.a(th, -1000, l.a().getResources().getString(i.poly_error_tips));
                            }
                        }
                        c.a.h0.r.f.a(null, dataOutputStream);
                    } catch (Throwable th2) {
                        c.a.h0.r.f.a(null, dataOutputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.h0.l.f
    public void a(String str, c cVar, c.a.h0.l.b bVar, c.a.h0.l.a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, cVar, bVar, aVar) == null) {
            if (!e.b(l.a())) {
                aVar.a(new Exception(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR), 119501, l.a().getResources().getString(i.common_error_tips));
            } else {
                c.a.h0.q.a.a(new b(this, str, cVar, bVar, aVar));
            }
        }
    }

    public void d(String str, c cVar, c.a.h0.l.a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, aVar) == null) {
            c.a.h0.q.a.a(new a(this, str, cVar, aVar));
        }
    }

    public g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.f3515b = z;
    }
}
