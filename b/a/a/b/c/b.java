package b.a.a.b.c;

import android.os.Process;
import android.text.TextUtils;
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

    /* renamed from: e  reason: collision with root package name */
    public final String f1014e;

    /* renamed from: f  reason: collision with root package name */
    public final a.InterfaceC0004a f1015f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f1016g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f1017h;

    public b(String str, a.InterfaceC0004a interfaceC0004a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, interfaceC0004a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1014e = str;
        this.f1015f = interfaceC0004a;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1017h = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1014e).openConnection();
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
                    synchronized (this.f1015f) {
                        this.f1016g = 106;
                        ((g) this.f1015f).h();
                    }
                    return;
                case 107:
                    synchronized (this.f1015f) {
                        this.f1016g = 107;
                        ((g) this.f1015f).e();
                    }
                    return;
                case 108:
                    synchronized (this.f1015f) {
                        this.f1016g = 108;
                        ((g) this.f1015f).c(downloadException);
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
                    this.f1016g = 103;
                    long currentTimeMillis = System.currentTimeMillis() - this.f1017h;
                    g gVar = (g) this.f1015f;
                    if (((b) gVar.f1031i).d()) {
                        gVar.e();
                        return;
                    }
                    gVar.f1029g = 103;
                    a aVar = gVar.f1024b;
                    aVar.f1013b.s(currentTimeMillis);
                    aVar.f1013b.j(z);
                    aVar.f1013b.r(103);
                    aVar.a.a(aVar.f1013b);
                    gVar.f1030h.b(z);
                    gVar.f1030h.f1019c = contentLength;
                    gVar.f1029g = 104;
                    gVar.f1032j.clear();
                    if (z) {
                        ArrayList<e> arrayList = new ArrayList();
                        int a = gVar.f1027e.a();
                        int i2 = 0;
                        while (i2 < a) {
                            long j2 = contentLength / a;
                            long j3 = j2 * i2;
                            arrayList.add(new e(i2, gVar.f1026d, gVar.a.c(), j3, i2 == a + (-1) ? contentLength : (j2 + j3) - 1, 0L));
                            i2++;
                        }
                        int i3 = 0;
                        for (e eVar : arrayList) {
                            i3 = (int) (i3 + eVar.f1023d);
                        }
                        gVar.f1030h.a(i3);
                        for (e eVar2 : arrayList) {
                            gVar.f1032j.add(new d(gVar.f1030h, eVar2, gVar));
                        }
                    } else {
                        gVar.f1032j.add(new f(gVar.f1030h, new e(0, gVar.f1026d, gVar.a.c(), 0L, 0L, 0L), gVar));
                    }
                    for (b.a.a.b.a.b bVar : gVar.f1032j) {
                        gVar.f1025c.execute(bVar);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1016g == 107 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1016g == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.f1016g = 102;
            g gVar = (g) this.f1015f;
            gVar.f1029g = 102;
            a aVar = gVar.f1024b;
            aVar.f1013b.r(102);
            aVar.a.a(aVar.f1013b);
            try {
                a();
            } catch (DownloadException e2) {
                b(e2);
            }
        }
    }
}
