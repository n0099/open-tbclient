package b.a.a.b.c;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import b.a.a.b.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b implements b.a.a.b.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final a.InterfaceC0004a f990b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f991c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f992d;

    public b(String str, a.InterfaceC0004a interfaceC0004a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, interfaceC0004a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f990b = interfaceC0004a;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d("RtcDownSo", "execute connnection");
            this.f992d = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
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
                    httpURLConnection.setRequestProperty("Range", "bytes=0-");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        c(httpURLConnection, false);
                    } else if (responseCode == 206) {
                        c(httpURLConnection, true);
                    } else {
                        Log.d("RtcDownSo", "UnSupported response code:" + responseCode);
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    }
                    httpURLConnection.disconnect();
                } catch (ProtocolException e4) {
                    e = e4;
                    e.printStackTrace();
                    throw new DownloadException(108, "Protocol error", e);
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
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

    public final void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f990b) {
                        this.f991c = 106;
                        ((g) this.f990b).h();
                    }
                    return;
                case 107:
                    synchronized (this.f990b) {
                        this.f991c = 107;
                        ((g) this.f990b).e();
                    }
                    return;
                case 108:
                    synchronized (this.f990b) {
                        this.f991c = 108;
                        ((g) this.f990b).c(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void c(HttpURLConnection httpURLConnection, boolean z) {
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection, z) == null) {
            Log.d("RtcDownSo", "start parse response");
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
                contentLength = Long.parseLong(headerField);
            } else {
                contentLength = httpURLConnection.getContentLength();
            }
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                if (!TextUtils.isEmpty(headerField2) && !headerField2.equals("0") && !headerField2.equals("-1")) {
                    contentLength = Long.parseLong(headerField2);
                } else {
                    contentLength = httpURLConnection.getContentLength();
                }
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            if (!d()) {
                if (!e()) {
                    this.f991c = 103;
                    long currentTimeMillis = System.currentTimeMillis() - this.f992d;
                    g gVar = (g) this.f990b;
                    if (((b) gVar.i).d()) {
                        gVar.e();
                        return;
                    }
                    gVar.f1004g = 103;
                    a aVar = gVar.f999b;
                    aVar.f989b.s(currentTimeMillis);
                    aVar.f989b.j(z);
                    aVar.f989b.r(103);
                    aVar.a.a(aVar.f989b);
                    gVar.f1005h.b(z);
                    gVar.f1005h.f994c = contentLength;
                    gVar.f1004g = 104;
                    gVar.j.clear();
                    if (z) {
                        ArrayList<e> arrayList = new ArrayList();
                        int a = gVar.f1002e.a();
                        int i = 0;
                        while (i < a) {
                            long j = contentLength / a;
                            long j2 = j * i;
                            arrayList.add(new e(i, gVar.f1001d, gVar.a.c(), j2, i == a + (-1) ? contentLength : (j + j2) - 1, 0L));
                            i++;
                        }
                        int i2 = 0;
                        for (e eVar : arrayList) {
                            i2 = (int) (i2 + eVar.f998d);
                        }
                        gVar.f1005h.a(i2);
                        for (e eVar2 : arrayList) {
                            gVar.j.add(new d(gVar.f1005h, eVar2, gVar));
                        }
                    } else {
                        gVar.j.add(new f(gVar.f1005h, new e(0, gVar.f1001d, gVar.a.c(), 0L, 0L, 0L), gVar));
                    }
                    for (b.a.a.b.a.b bVar : gVar.j) {
                        gVar.f1000c.execute(bVar);
                    }
                    return;
                }
                throw new DownloadException(106, "Connection Paused!");
            }
            throw new DownloadException(107, "Connection Canceled!");
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f991c == 107 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f991c == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.f991c = 102;
            g gVar = (g) this.f990b;
            gVar.f1004g = 102;
            a aVar = gVar.f999b;
            aVar.f989b.r(102);
            aVar.a.a(aVar.f989b);
            try {
                a();
            } catch (DownloadException e2) {
                b(e2);
            }
        }
    }
}
