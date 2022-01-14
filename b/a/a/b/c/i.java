package b.a.a.b.c;

import android.os.Process;
import android.text.TextUtils;
import b.a.a.b.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class i implements b.a.a.b.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f1036e;

    /* renamed from: f  reason: collision with root package name */
    public final c f1037f;

    /* renamed from: g  reason: collision with root package name */
    public final e f1038g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a f1039h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f1040i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f1041j;

    public i(c cVar, e eVar, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, eVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1041j = 0;
        this.f1037f = cVar;
        this.f1038g = eVar;
        this.f1039h = aVar;
        String k = k();
        this.f1036e = k;
        if (TextUtils.isEmpty(k)) {
            this.f1036e = getClass().getSimpleName();
        }
    }

    public abstract RandomAccessFile a(File file, String str, long j2);

    public abstract Map<String, String> b(e eVar);

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0058 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [b.a.a.b.c.i, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        IOException e2;
        ProtocolException e3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        try {
            URL url = new URL(this.f1038g.a);
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        httpURLConnection.setRequestMethod("GET");
                        h(b(this.f1038g), httpURLConnection);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == i()) {
                            g(httpURLConnection);
                            httpURLConnection.disconnect();
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("UnSupported response code:");
                        sb.append(responseCode);
                        throw new DownloadException(108, sb.toString());
                    } catch (ProtocolException e4) {
                        e3 = e4;
                        throw new DownloadException(108, "Protocol error", e3);
                    } catch (IOException e5) {
                        e2 = e5;
                        throw new DownloadException(108, "IO error", e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = url;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (ProtocolException e6) {
                e3 = e6;
            } catch (IOException e7) {
                e2 = e7;
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                }
                throw th;
            }
        } catch (MalformedURLException e8) {
            throw new DownloadException(108, "Bad url.", e8);
        }
    }

    public final void d(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f1039h) {
                        this.f1040i = 106;
                        ((g) this.f1039h).h();
                    }
                    return;
                case 107:
                    synchronized (this.f1039h) {
                        this.f1040i = 107;
                        ((g) this.f1039h).g();
                    }
                    return;
                case 108:
                    synchronized (this.f1039h) {
                        this.f1040i = 108;
                        ((g) this.f1039h).f(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void e(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, closeable) == null) || closeable == null) {
            return;
        }
        synchronized (i.class) {
            closeable.close();
        }
    }

    public final void f(InputStream inputStream, RandomAccessFile randomAccessFile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, inputStream, randomAccessFile) == null) {
            byte[] bArr = new byte[8192];
            while (this.f1041j != 107) {
                if (this.f1041j != 106) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            return;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        long j2 = read;
                        this.f1038g.f1023d += j2;
                        synchronized (this.f1039h) {
                            this.f1037f.f1020d += j2;
                            ((g) this.f1039h).b(this.f1037f.f1020d, this.f1037f.f1019c);
                        }
                    } catch (IOException e2) {
                        l(this.f1038g);
                        throw new DownloadException(108, e2);
                    }
                } else {
                    l(this.f1038g);
                    throw new DownloadException(106, "Download paused!");
                }
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    public final void g(HttpURLConnection httpURLConnection) {
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, httpURLConnection) != null) {
            return;
        }
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    long j2 = this.f1038g.f1021b + this.f1038g.f1023d;
                    try {
                        File file = this.f1037f.f1018b;
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RandomAccessFile a = a(file, this.f1037f.a, j2);
                        f(inputStream, a);
                        try {
                            e(inputStream);
                            e(a);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (IOException e3) {
                        throw new DownloadException(108, "File occur IOException ", e3);
                    } catch (Exception e4) {
                        throw new DownloadException(108, "Occur Exception ", e4);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        e(inputStream);
                        e(null);
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                throw new DownloadException(108, "http get inputStream error", e6);
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public final void h(Map<String, String> map, URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, map, uRLConnection) == null) || map == null) {
            return;
        }
        for (String str : map.keySet()) {
            uRLConnection.setRequestProperty(str, map.get(str));
        }
    }

    public abstract int i();

    public abstract void j(e eVar);

    public abstract String k();

    public abstract void l(e eVar);

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1040i == 104 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Process.setThreadPriority(10);
            j(this.f1038g);
            try {
                this.f1040i = 104;
                c();
                synchronized (this.f1039h) {
                    this.f1040i = 105;
                    b.a aVar = this.f1039h;
                    ((g) aVar).d(this.f1037f.f1018b.getAbsolutePath() + File.separator + this.f1037f.a);
                }
            } catch (DownloadException e2) {
                d(e2);
            }
        }
    }
}
