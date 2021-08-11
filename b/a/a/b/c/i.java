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
    public String f1556e;

    /* renamed from: f  reason: collision with root package name */
    public final c f1557f;

    /* renamed from: g  reason: collision with root package name */
    public final e f1558g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a f1559h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f1560i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f1561j;

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
        this.f1561j = 0;
        this.f1557f = cVar;
        this.f1558g = eVar;
        this.f1559h = aVar;
        String k = k();
        this.f1556e = k;
        if (TextUtils.isEmpty(k)) {
            this.f1556e = getClass().getSimpleName();
        }
    }

    public abstract RandomAccessFile a(File file, String str, long j2);

    public abstract Map<String, String> b(e eVar);

    public final void c() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1558g.f1538a).openConnection();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (ProtocolException e2) {
                    e = e2;
                } catch (IOException e3) {
                    e = e3;
                }
                try {
                    httpURLConnection.setConnectTimeout(4000);
                    httpURLConnection.setReadTimeout(4000);
                    httpURLConnection.setRequestMethod("GET");
                    h(b(this.f1558g), httpURLConnection);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == i()) {
                        g(httpURLConnection);
                        httpURLConnection.disconnect();
                        return;
                    }
                    throw new DownloadException(108, "UnSupported response code:" + responseCode);
                } catch (ProtocolException e4) {
                    e = e4;
                    throw new DownloadException(108, "Protocol error", e);
                } catch (IOException e5) {
                    e = e5;
                    throw new DownloadException(108, "IO error", e);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (MalformedURLException e6) {
                throw new DownloadException(108, "Bad url.", e6);
            }
        }
    }

    public final void d(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f1559h) {
                        this.f1560i = 106;
                        ((g) this.f1559h).h();
                    }
                    return;
                case 107:
                    synchronized (this.f1559h) {
                        this.f1560i = 107;
                        ((g) this.f1559h).g();
                    }
                    return;
                case 108:
                    synchronized (this.f1559h) {
                        this.f1560i = 108;
                        ((g) this.f1559h).f(downloadException);
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
            try {
                closeable.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(InputStream inputStream, RandomAccessFile randomAccessFile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, inputStream, randomAccessFile) == null) {
            byte[] bArr = new byte[8192];
            while (this.f1561j != 107) {
                if (this.f1561j == 106) {
                    l(this.f1558g);
                    throw new DownloadException(106, "Download paused!");
                }
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    long j2 = read;
                    this.f1558g.f1541d += j2;
                    synchronized (this.f1559h) {
                        this.f1557f.f1537d += j2;
                        ((g) this.f1559h).b(this.f1557f.f1537d, this.f1557f.f1536c);
                    }
                } catch (IOException e2) {
                    l(this.f1558g);
                    throw new DownloadException(108, e2);
                }
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    public final void g(HttpURLConnection httpURLConnection) {
        Throwable th;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, httpURLConnection) != null) {
            return;
        }
        Closeable closeable2 = null;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    long j2 = this.f1558g.f1539b;
                    long j3 = this.f1558g.f1541d;
                    try {
                        File file = this.f1557f.f1535b;
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RandomAccessFile a2 = a(file, this.f1557f.f1534a, j2 + j3);
                        f(inputStream, a2);
                        try {
                            e(inputStream);
                            e(a2);
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
                    closeable2 = inputStream;
                    closeable = null;
                    try {
                        e(closeable2);
                        e(closeable);
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
            closeable = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1560i == 104 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Process.setThreadPriority(10);
            j(this.f1558g);
            try {
                this.f1560i = 104;
                c();
                synchronized (this.f1559h) {
                    this.f1560i = 105;
                    b.a aVar = this.f1559h;
                    ((g) aVar).d(this.f1557f.f1535b.getAbsolutePath() + File.separator + this.f1557f.f1534a);
                }
            } catch (DownloadException e2) {
                d(e2);
            }
        }
    }
}
