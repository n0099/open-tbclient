package c.a.f0.l;

import android.os.Handler;
import android.os.Looper;
import c.a.f0.i;
import c.a.f0.r.h;
import c.a.f0.r.l;
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
    public boolean f3092b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.l.c f3094f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.l.a f3095g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f3096h;

        /* renamed from: c.a.f0.l.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0104a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f3097e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f3098f;

            public RunnableC0104a(a aVar, String str) {
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
                this.f3098f = aVar;
                this.f3097e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3098f.f3095g.c(this.f3097e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f3099e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f3100f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f3101g;

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
                this.f3101g = aVar;
                this.f3099e = i2;
                this.f3100f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.f0.l.a aVar = this.f3101g.f3095g;
                    aVar.a(new IOException("status code " + this.f3099e + ", response " + this.f3100f), 119501, this.f3100f);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f3102e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f3103f;

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
                this.f3103f = aVar;
                this.f3102e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.f0.l.a aVar = this.f3103f.f3095g;
                    Throwable th = this.f3102e;
                    aVar.a(th, 119501, th.getMessage());
                }
            }
        }

        public a(g gVar, String str, c.a.f0.l.c cVar, c.a.f0.l.a aVar) {
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
            this.f3096h = gVar;
            this.f3093e = str;
            this.f3094f = cVar;
            this.f3095g = aVar;
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
        /* JADX WARN: Type inference failed for: r5v4, types: [c.a.f0.l.a] */
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
                    httpURLConnection = (HttpURLConnection) new URL(this.f3093e).openConnection();
                    for (Map.Entry<String, String> entry : this.f3094f.c().entrySet()) {
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
                        String c2 = c.a.f0.r.f.c(inputStream);
                        httpURLConnection = inputStream;
                        if (this.f3095g != null) {
                            if (this.f3096h.f3092b) {
                                this.f3096h.a.post(new RunnableC0104a(this, c2));
                                httpURLConnection = inputStream;
                            } else {
                                this.f3095g.c(c2);
                                httpURLConnection = inputStream;
                            }
                        }
                    } else {
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        String c3 = c.a.f0.r.f.c(errorStream);
                        httpURLConnection = errorStream;
                        if (this.f3095g != null) {
                            if (this.f3096h.f3092b) {
                                this.f3096h.a.post(new b(this, responseCode, c3));
                                httpURLConnection = errorStream;
                            } else {
                                c.a.f0.l.a aVar = this.f3095g;
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
                    c.a.f0.r.f.a(r0);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        if (this.f3095g != null) {
                            h.c("GET FAILED", th);
                            if (this.f3096h.f3092b) {
                                this.f3096h.a.post(new c(this, th));
                            } else {
                                this.f3095g.a(th, r0, th.getMessage());
                            }
                        }
                        c.a.f0.r.f.a(new Closeable[]{httpURLConnection});
                    } catch (Throwable th4) {
                        c.a.f0.r.f.a(new Closeable[]{httpURLConnection});
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
        public final /* synthetic */ String f3104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.l.c f3105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.l.b f3106g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.l.a f3107h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f3108i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f3109e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f3110f;

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
                this.f3110f = bVar;
                this.f3109e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3110f.f3107h.c(this.f3109e);
                }
            }
        }

        /* renamed from: c.a.f0.l.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0105b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f3111e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f3112f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f3113g;

            public RunnableC0105b(b bVar, int i2, String str) {
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
                this.f3113g = bVar;
                this.f3111e = i2;
                this.f3112f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.f0.l.a aVar = this.f3113g.f3107h;
                    aVar.a(new IOException("status code " + this.f3111e + ", response " + this.f3112f), this.f3111e, l.a().getResources().getString(i.poly_error_tips));
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f3114e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f3115f;

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
                this.f3115f = bVar;
                this.f3114e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3115f.f3107h.a(this.f3114e, -1000, l.a().getResources().getString(i.poly_error_tips));
                }
            }
        }

        public b(g gVar, String str, c.a.f0.l.c cVar, c.a.f0.l.b bVar, c.a.f0.l.a aVar) {
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
            this.f3108i = gVar;
            this.f3104e = str;
            this.f3105f = cVar;
            this.f3106g = bVar;
            this.f3107h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataOutputStream dataOutputStream;
            InputStream errorStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            c.a.f0.p.b.a("1.03", System.currentTimeMillis());
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f3104e).openConnection();
                for (Map.Entry<String, String> entry : this.f3105f.c().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : this.f3106g.c().entrySet()) {
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
                        String c2 = c.a.f0.r.f.c(errorStream);
                        if (this.f3107h != null) {
                            if (this.f3108i.f3092b) {
                                this.f3108i.a.post(new a(this, c2));
                            } else {
                                this.f3107h.c(c2);
                            }
                        }
                    } else {
                        errorStream = httpURLConnection.getErrorStream();
                        String c3 = c.a.f0.r.f.c(errorStream);
                        if (this.f3107h != null) {
                            if (this.f3108i.f3092b) {
                                this.f3108i.a.post(new RunnableC0105b(this, responseCode, c3));
                            } else {
                                c.a.f0.l.a aVar = this.f3107h;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("status code ");
                                sb2.append(responseCode);
                                sb2.append(", response ");
                                sb2.append(c3);
                                aVar.a(new IOException(sb2.toString()), responseCode, l.a().getResources().getString(i.poly_error_tips));
                            }
                        }
                    }
                    c.a.f0.r.f.a(errorStream, dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    try {
                        h.c("POST FAILED", th);
                        if (this.f3107h != null) {
                            if (this.f3108i.f3092b) {
                                this.f3108i.a.post(new c(this, th));
                            } else {
                                this.f3107h.a(th, -1000, l.a().getResources().getString(i.poly_error_tips));
                            }
                        }
                        c.a.f0.r.f.a(null, dataOutputStream);
                    } catch (Throwable th2) {
                        c.a.f0.r.f.a(null, dataOutputStream);
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

    @Override // c.a.f0.l.f
    public void a(String str, c cVar, c.a.f0.l.b bVar, c.a.f0.l.a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, cVar, bVar, aVar) == null) {
            if (!e.b(l.a())) {
                aVar.a(new Exception(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR), 119501, l.a().getResources().getString(i.common_error_tips));
            } else {
                c.a.f0.q.a.a(new b(this, str, cVar, bVar, aVar));
            }
        }
    }

    public void d(String str, c cVar, c.a.f0.l.a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, aVar) == null) {
            c.a.f0.q.a.a(new a(this, str, cVar, aVar));
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
        this.f3092b = z;
    }
}
