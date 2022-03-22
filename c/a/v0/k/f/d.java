package c.a.v0.k.f;

import android.os.Process;
import android.text.TextUtils;
import c.a.v0.k.e.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
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
/* loaded from: classes3.dex */
public abstract class d implements c.a.v0.k.e.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final a f21650b;

    /* renamed from: c  reason: collision with root package name */
    public final i f21651c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f21652d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f21653e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f21654f;

    public d(a aVar, i iVar, e.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, iVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21654f = 0;
        this.f21650b = aVar;
        this.f21651c = iVar;
        this.f21652d = aVar2;
        String h2 = h();
        this.a = h2;
        if (TextUtils.isEmpty(h2)) {
            this.a = getClass().getSimpleName();
        }
    }

    public final void a() throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21654f != 107) {
                if (this.f21654f != 106) {
                    return;
                }
                n(this.f21651c);
                throw new DownloadException(106, "Download paused!");
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    public final void b(Closeable closeable) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeable) == null) || closeable == null) {
            return;
        }
        synchronized (d.class) {
            closeable.close();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f21650b.a().getAbsolutePath() + File.separator + this.f21650b.d();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.v0.k.e.e
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21654f = 107;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [c.a.v0.k.f.d, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() throws DownloadException {
        IOException e2;
        ProtocolException e3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
            return;
        }
        try {
            URL url = new URL(this.f21651c.d());
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        httpURLConnection.setRequestMethod("GET");
                        k(f(this.f21651c), httpURLConnection);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == g()) {
                            m(httpURLConnection);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
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

    public abstract RandomAccessFile e(File file, String str, long j) throws IOException;

    public abstract Map<String, String> f(i iVar);

    public abstract int g();

    public abstract String h();

    public final void i(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f21652d) {
                        this.f21653e = 106;
                        this.f21652d.onDownloadPaused();
                    }
                    return;
                case 107:
                    synchronized (this.f21652d) {
                        this.f21653e = 107;
                        this.f21652d.onDownloadCanceled();
                    }
                    return;
                case 108:
                    synchronized (this.f21652d) {
                        this.f21653e = 108;
                        this.f21652d.a(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    @Override // c.a.v0.k.e.e
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f21653e == 105 : invokeV.booleanValue;
    }

    @Override // c.a.v0.k.e.e
    public boolean isDownloading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f21653e == 104 : invokeV.booleanValue;
    }

    public abstract void j(i iVar);

    public final void k(Map<String, String> map, URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, map, uRLConnection) == null) || map == null) {
            return;
        }
        for (String str : map.keySet()) {
            uRLConnection.setRequestProperty(str, map.get(str));
        }
    }

    public final void l(InputStream inputStream, RandomAccessFile randomAccessFile) throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048590, this, inputStream, randomAccessFile) != null) {
            return;
        }
        byte[] bArr = new byte[8192];
        while (true) {
            a();
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                randomAccessFile.write(bArr, 0, read);
                long j = read;
                this.f21651c.e(this.f21651c.b() + j);
                synchronized (this.f21652d) {
                    this.f21650b.f(this.f21650b.b() + j);
                    this.f21652d.onDownloadProgress(this.f21650b.b(), this.f21650b.c());
                }
            } catch (IOException e2) {
                n(this.f21651c);
                throw new DownloadException(108, e2);
            }
        }
    }

    public final void m(HttpURLConnection httpURLConnection) throws DownloadException {
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048591, this, httpURLConnection) != null) {
            return;
        }
        Closeable closeable2 = null;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    long c2 = this.f21651c.c() + this.f21651c.b();
                    try {
                        File a = this.f21650b.a();
                        if (!a.exists()) {
                            a.mkdirs();
                        }
                        RandomAccessFile e2 = e(a, this.f21650b.d(), c2);
                        l(inputStream, e2);
                        try {
                            b(inputStream);
                            b(e2);
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        throw new DownloadException(108, "File occur IOException ", e4);
                    } catch (Exception e5) {
                        throw new DownloadException(108, "Occur Exception ", e5);
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = inputStream;
                    closeable = null;
                    try {
                        b(closeable2);
                        b(closeable);
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e7) {
                throw new DownloadException(108, "http get inputStream error", e7);
            }
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
    }

    public abstract void n(i iVar);

    @Override // c.a.v0.k.e.e
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f21654f = 106;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Process.setThreadPriority(10);
            j(this.f21651c);
            try {
                this.f21653e = 104;
                d();
                synchronized (this.f21652d) {
                    this.f21653e = 105;
                    this.f21652d.onDownloadCompleted(c());
                }
            } catch (DownloadException e2) {
                i(e2);
            }
        }
    }
}
