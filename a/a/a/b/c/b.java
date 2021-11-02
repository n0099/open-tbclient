package a.a.a.b.c;

import a.a.a.b.a.a;
import android.os.Process;
import android.text.TextUtils;
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
public class b implements a.a.a.b.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f1021e;

    /* renamed from: f  reason: collision with root package name */
    public final a.InterfaceC0000a f1022f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f1023g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f1024h;

    public b(String str, a.InterfaceC0000a interfaceC0000a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, interfaceC0000a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1021e = str;
        this.f1022f = interfaceC0000a;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1024h = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1021e).openConnection();
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
                        r0 = "UnSupported response code:" + responseCode;
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
                    synchronized (this.f1022f) {
                        this.f1023g = 106;
                        ((g) this.f1022f).h();
                    }
                    return;
                case 107:
                    synchronized (this.f1022f) {
                        this.f1023g = 107;
                        ((g) this.f1022f).e();
                    }
                    return;
                case 108:
                    synchronized (this.f1022f) {
                        this.f1023g = 108;
                        ((g) this.f1022f).c(downloadException);
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
                    this.f1023g = 103;
                    long currentTimeMillis = System.currentTimeMillis() - this.f1024h;
                    g gVar = (g) this.f1022f;
                    if (((b) gVar.f1041i).d()) {
                        gVar.e();
                        return;
                    }
                    gVar.f1039g = 103;
                    a aVar = gVar.f1034b;
                    aVar.f1020b.s(currentTimeMillis);
                    aVar.f1020b.j(z);
                    aVar.f1020b.r(103);
                    aVar.f1019a.a(aVar.f1020b);
                    gVar.f1040h.b(z);
                    gVar.f1040h.f1027c = contentLength;
                    gVar.f1039g = 104;
                    gVar.j.clear();
                    if (z) {
                        ArrayList<e> arrayList = new ArrayList();
                        int a2 = gVar.f1037e.a();
                        int i2 = 0;
                        while (i2 < a2) {
                            long j = contentLength / a2;
                            long j2 = j * i2;
                            arrayList.add(new e(i2, gVar.f1036d, gVar.f1033a.c(), j2, i2 == a2 + (-1) ? contentLength : (j + j2) - 1, 0L));
                            i2++;
                        }
                        int i3 = 0;
                        for (e eVar : arrayList) {
                            i3 = (int) (i3 + eVar.f1032d);
                        }
                        gVar.f1040h.a(i3);
                        for (e eVar2 : arrayList) {
                            gVar.j.add(new d(gVar.f1040h, eVar2, gVar));
                        }
                    } else {
                        gVar.j.add(new f(gVar.f1040h, new e(0, gVar.f1036d, gVar.f1033a.c(), 0L, 0L, 0L), gVar));
                    }
                    for (a.a.a.b.a.b bVar : gVar.j) {
                        gVar.f1035c.execute(bVar);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1023g == 107 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1023g == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.f1023g = 102;
            g gVar = (g) this.f1022f;
            gVar.f1039g = 102;
            a aVar = gVar.f1034b;
            aVar.f1020b.r(102);
            aVar.f1019a.a(aVar.f1020b);
            try {
                a();
            } catch (DownloadException e2) {
                b(e2);
            }
        }
    }
}
