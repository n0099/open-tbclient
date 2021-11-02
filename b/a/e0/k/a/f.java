package b.a.e0.k.a;

import android.os.Handler;
import android.os.Looper;
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
public class f implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f2548a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2549b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.k.a.c f2551f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.k.a.b f2552g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.k.a.a f2553h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f2554i;

        /* renamed from: b.a.e0.k.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0047a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f2555e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f2556f;

            public RunnableC0047a(a aVar, String str) {
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
                this.f2556f = aVar;
                this.f2555e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f2556f.f2553h.a(this.f2555e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f2557e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f2558f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f2559g;

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
                this.f2559g = aVar;
                this.f2557e = i2;
                this.f2558f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.e0.k.a.a aVar = this.f2559g.f2553h;
                    aVar.b(new IOException("status code " + this.f2557e + ", response " + this.f2558f), null);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f2560e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f2561f;

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
                this.f2561f = aVar;
                this.f2560e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f2561f.f2553h.b(this.f2560e, null);
                }
            }
        }

        public a(f fVar, String str, b.a.e0.k.a.c cVar, b.a.e0.k.a.b bVar, b.a.e0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, cVar, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2554i = fVar;
            this.f2550e = str;
            this.f2551f = cVar;
            this.f2552g = bVar;
            this.f2553h = aVar;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00ee */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x00bf */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.io.Closeable[] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.io.Closeable[] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0153 A[Catch: all -> 0x0179, TryCatch #3 {all -> 0x0179, blocks: (B:57:0x014c, B:59:0x0153, B:61:0x015b, B:62:0x016a), top: B:77:0x014c }] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r0v9 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            DataOutputStream dataOutputStream;
            Throwable th;
            HttpURLConnection httpURLConnection;
            int responseCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = 2;
                i2 = 2;
                i2 = 2;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.f2550e).openConnection();
                    for (Map.Entry<String, String> entry : this.f2551f.d().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry2 : this.f2552g.d().entrySet()) {
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
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    dataOutputStream = null;
                    th = th3;
                    httpURLConnection = null;
                }
                try {
                    if (responseCode >= 200 && responseCode <= 299) {
                        try {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            String a2 = b.a.e0.n.c.a(inputStream);
                            httpURLConnection = inputStream;
                            if (this.f2553h != null) {
                                if (this.f2554i.f2549b) {
                                    this.f2554i.f2548a.post(new RunnableC0047a(this, a2));
                                    httpURLConnection = inputStream;
                                } else {
                                    this.f2553h.a(a2);
                                    httpURLConnection = inputStream;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            httpURLConnection = null;
                            try {
                                b.a.e0.n.d.a("POST FAILED", th);
                                if (this.f2553h != null) {
                                    if (this.f2554i.f2549b) {
                                        this.f2554i.f2548a.post(new c(this, th));
                                    } else {
                                        this.f2553h.b(th, null);
                                    }
                                }
                                Closeable[] closeableArr = new Closeable[i2];
                                closeableArr[0] = httpURLConnection;
                                closeableArr[1] = dataOutputStream;
                                b.a.e0.n.c.c(closeableArr);
                            } catch (Throwable th5) {
                                Closeable[] closeableArr2 = new Closeable[i2];
                                closeableArr2[0] = httpURLConnection;
                                closeableArr2[1] = dataOutputStream;
                                b.a.e0.n.c.c(closeableArr2);
                                throw th5;
                            }
                        }
                    } else {
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        String a3 = b.a.e0.n.c.a(errorStream);
                        httpURLConnection = errorStream;
                        if (this.f2553h != null) {
                            if (this.f2554i.f2549b) {
                                this.f2554i.f2548a.post(new b(this, responseCode, a3));
                                httpURLConnection = errorStream;
                            } else {
                                b.a.e0.k.a.a aVar = this.f2553h;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("status code ");
                                sb2.append(responseCode);
                                sb2.append(", response ");
                                sb2.append(a3);
                                aVar.b(new IOException(sb2.toString()), null);
                                httpURLConnection = errorStream;
                            }
                        }
                    }
                    i2 = new Closeable[]{httpURLConnection, dataOutputStream};
                    b.a.e0.n.c.c(i2);
                } catch (Throwable th6) {
                    th = th6;
                    b.a.e0.n.d.a("POST FAILED", th);
                    if (this.f2553h != null) {
                    }
                    Closeable[] closeableArr3 = new Closeable[i2];
                    closeableArr3[0] = httpURLConnection;
                    closeableArr3[1] = dataOutputStream;
                    b.a.e0.n.c.c(closeableArr3);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f() {
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

    @Override // b.a.e0.k.a.e
    public void a(String str, c cVar, b bVar, b.a.e0.k.a.a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, cVar, bVar, aVar) == null) {
            b.a.e0.m.a.a(new a(this, str, cVar, bVar, aVar));
        }
    }

    public f(boolean z) {
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
        this.f2548a = new Handler(Looper.getMainLooper());
        this.f2549b = z;
    }
}
