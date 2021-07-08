package a.a.a.c.b;

import a.a.a.c.a.bv;
import android.os.Process;
import android.text.TextUtils;
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
public abstract class uiou implements a.a.a.c.a.bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1452a;

    /* renamed from: b  reason: collision with root package name */
    public final bv f1453b;

    /* renamed from: c  reason: collision with root package name */
    public final lbvzx f1454c;

    /* renamed from: d  reason: collision with root package name */
    public final bv.InterfaceC0007bv f1455d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f1456e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f1457f;

    public uiou(bv bvVar, lbvzx lbvzxVar, bv.InterfaceC0007bv interfaceC0007bv) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bvVar, lbvzxVar, interfaceC0007bv};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1457f = 0;
        this.f1453b = bvVar;
        this.f1454c = lbvzxVar;
        this.f1455d = interfaceC0007bv;
        String c2 = c();
        this.f1452a = c2;
        if (TextUtils.isEmpty(c2)) {
            this.f1452a = getClass().getSimpleName();
        }
    }

    public abstract RandomAccessFile a(File file, String str, long j);

    public abstract Map<String, String> a(lbvzx lbvzxVar);

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1454c.f1436a).openConnection();
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
                    a(a(this.f1454c), httpURLConnection);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == b()) {
                        a(httpURLConnection);
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

    public final void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f1455d) {
                        this.f1456e = 106;
                        ((shuoy) this.f1455d).d();
                    }
                    return;
                case 107:
                    synchronized (this.f1455d) {
                        this.f1456e = 107;
                        ((shuoy) this.f1455d).c();
                    }
                    return;
                case 108:
                    synchronized (this.f1455d) {
                        this.f1456e = 108;
                        ((shuoy) this.f1455d).b(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, closeable) == null) || closeable == null) {
            return;
        }
        synchronized (uiou.class) {
            try {
                closeable.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(InputStream inputStream, RandomAccessFile randomAccessFile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, inputStream, randomAccessFile) == null) {
            byte[] bArr = new byte[8192];
            while (this.f1457f != 107) {
                if (this.f1457f == 106) {
                    c(this.f1454c);
                    throw new DownloadException(106, "Download paused!");
                }
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    long j = read;
                    this.f1454c.f1439d += j;
                    synchronized (this.f1455d) {
                        this.f1453b.f1435d += j;
                        ((shuoy) this.f1455d).a(this.f1453b.f1435d, this.f1453b.f1434c);
                    }
                } catch (IOException e2) {
                    c(this.f1454c);
                    throw new DownloadException(108, e2);
                }
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    public final void a(HttpURLConnection httpURLConnection) {
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
                    long j = this.f1454c.f1437b;
                    long j2 = this.f1454c.f1439d;
                    try {
                        File file = this.f1453b.f1433b;
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RandomAccessFile a2 = a(file, this.f1453b.f1432a, j + j2);
                        a(inputStream, a2);
                        try {
                            a(inputStream);
                            a(a2);
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
                        a(closeable2);
                        a(closeable);
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

    public final void a(Map<String, String> map, URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, map, uRLConnection) == null) || map == null) {
            return;
        }
        for (String str : map.keySet()) {
            uRLConnection.setRequestProperty(str, map.get(str));
        }
    }

    public abstract int b();

    public abstract void b(lbvzx lbvzxVar);

    public abstract String c();

    public abstract void c(lbvzx lbvzxVar);

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1456e == 104 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Process.setThreadPriority(10);
            b(this.f1454c);
            try {
                this.f1456e = 104;
                a();
                synchronized (this.f1455d) {
                    this.f1456e = 105;
                    bv.InterfaceC0007bv interfaceC0007bv = this.f1455d;
                    ((shuoy) interfaceC0007bv).a(this.f1453b.f1433b.getAbsolutePath() + File.separator + this.f1453b.f1432a);
                }
            } catch (DownloadException e2) {
                a(e2);
            }
        }
    }
}
