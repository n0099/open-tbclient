package c.a.d0.k.a;

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
    public Handler f1742a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1743b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.k.a.c f1745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.k.a.b f1746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.k.a.a f1747h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f1748i;

        /* renamed from: c.a.d0.k.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0023a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f1749e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f1750f;

            public RunnableC0023a(a aVar, String str) {
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
                this.f1750f = aVar;
                this.f1749e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1750f.f1747h.a(this.f1749e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f1751e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f1752f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f1753g;

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
                this.f1753g = aVar;
                this.f1751e = i2;
                this.f1752f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.d0.k.a.a aVar = this.f1753g.f1747h;
                    aVar.b(new IOException("status code " + this.f1751e + ", response " + this.f1752f), null);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f1754e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f1755f;

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
                this.f1755f = aVar;
                this.f1754e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1755f.f1747h.b(this.f1754e, null);
                }
            }
        }

        public a(f fVar, String str, c.a.d0.k.a.c cVar, c.a.d0.k.a.b bVar, c.a.d0.k.a.a aVar) {
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
            this.f1748i = fVar;
            this.f1744e = str;
            this.f1745f = cVar;
            this.f1746g = bVar;
            this.f1747h = aVar;
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
                    httpURLConnection = (HttpURLConnection) new URL(this.f1744e).openConnection();
                    for (Map.Entry<String, String> entry : this.f1745f.d().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry2 : this.f1746g.d().entrySet()) {
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
                            String a2 = c.a.d0.n.c.a(inputStream);
                            httpURLConnection = inputStream;
                            if (this.f1747h != null) {
                                if (this.f1748i.f1743b) {
                                    this.f1748i.f1742a.post(new RunnableC0023a(this, a2));
                                    httpURLConnection = inputStream;
                                } else {
                                    this.f1747h.a(a2);
                                    httpURLConnection = inputStream;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            httpURLConnection = null;
                            try {
                                c.a.d0.n.d.a("POST FAILED", th);
                                if (this.f1747h != null) {
                                    if (this.f1748i.f1743b) {
                                        this.f1748i.f1742a.post(new c(this, th));
                                    } else {
                                        this.f1747h.b(th, null);
                                    }
                                }
                                Closeable[] closeableArr = new Closeable[i2];
                                closeableArr[0] = httpURLConnection;
                                closeableArr[1] = dataOutputStream;
                                c.a.d0.n.c.c(closeableArr);
                            } catch (Throwable th5) {
                                Closeable[] closeableArr2 = new Closeable[i2];
                                closeableArr2[0] = httpURLConnection;
                                closeableArr2[1] = dataOutputStream;
                                c.a.d0.n.c.c(closeableArr2);
                                throw th5;
                            }
                        }
                    } else {
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        String a3 = c.a.d0.n.c.a(errorStream);
                        httpURLConnection = errorStream;
                        if (this.f1747h != null) {
                            if (this.f1748i.f1743b) {
                                this.f1748i.f1742a.post(new b(this, responseCode, a3));
                                httpURLConnection = errorStream;
                            } else {
                                c.a.d0.k.a.a aVar = this.f1747h;
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
                    c.a.d0.n.c.c(i2);
                } catch (Throwable th6) {
                    th = th6;
                    c.a.d0.n.d.a("POST FAILED", th);
                    if (this.f1747h != null) {
                    }
                    Closeable[] closeableArr3 = new Closeable[i2];
                    closeableArr3[0] = httpURLConnection;
                    closeableArr3[1] = dataOutputStream;
                    c.a.d0.n.c.c(closeableArr3);
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

    @Override // c.a.d0.k.a.e
    public void a(String str, c cVar, b bVar, c.a.d0.k.a.a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, cVar, bVar, aVar) == null) {
            c.a.d0.m.a.a(new a(this, str, cVar, bVar, aVar));
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
        this.f1742a = new Handler(Looper.getMainLooper());
        this.f1743b = z;
    }
}
