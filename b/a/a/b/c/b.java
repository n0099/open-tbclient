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
    public final String f1530e;

    /* renamed from: f  reason: collision with root package name */
    public final a.InterfaceC0010a f1531f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f1532g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f1533h;

    public b(String str, a.InterfaceC0010a interfaceC0010a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, interfaceC0010a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1530e = str;
        this.f1531f = interfaceC0010a;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1533h = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1530e).openConnection();
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
                    } else if (responseCode != 206) {
                        r0 = "UnSupported response code:" + responseCode;
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    } else {
                        c(httpURLConnection, true);
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
                    synchronized (this.f1531f) {
                        this.f1532g = 106;
                        ((g) this.f1531f).h();
                    }
                    return;
                case 107:
                    synchronized (this.f1531f) {
                        this.f1532g = 107;
                        ((g) this.f1531f).e();
                    }
                    return;
                case 108:
                    synchronized (this.f1531f) {
                        this.f1532g = 108;
                        ((g) this.f1531f).c(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void c(HttpURLConnection httpURLConnection, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection, z) == null) {
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            long contentLength = (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField);
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                contentLength = (TextUtils.isEmpty(headerField2) || headerField2.equals("0") || headerField2.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField2);
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            if (d()) {
                throw new DownloadException(107, "Connection Canceled!");
            }
            if (e()) {
                throw new DownloadException(106, "Connection Paused!");
            }
            this.f1532g = 103;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f1533h;
            g gVar = (g) this.f1531f;
            if (((b) gVar.f1550i).d()) {
                gVar.e();
                return;
            }
            gVar.f1548g = 103;
            a aVar = gVar.f1543b;
            aVar.f1529b.s(currentTimeMillis - j2);
            aVar.f1529b.j(z);
            aVar.f1529b.r(103);
            aVar.f1528a.a(aVar.f1529b);
            gVar.f1549h.b(z);
            gVar.f1549h.f1536c = contentLength;
            gVar.f1548g = 104;
            gVar.f1551j.clear();
            if (z) {
                ArrayList<e> arrayList = new ArrayList();
                int a2 = gVar.f1546e.a();
                int i2 = 0;
                int i3 = 0;
                while (i3 < a2) {
                    long j3 = contentLength / a2;
                    long j4 = j3 * i3;
                    arrayList.add(new e(i3, gVar.f1545d, gVar.f1542a.c(), j4, i3 == a2 + (-1) ? contentLength : (j3 + j4) - 1, 0L));
                    i3++;
                }
                for (e eVar : arrayList) {
                    i2 = (int) (i2 + eVar.f1541d);
                }
                gVar.f1549h.a(i2);
                for (e eVar2 : arrayList) {
                    gVar.f1551j.add(new d(gVar.f1549h, eVar2, gVar));
                }
            } else {
                gVar.f1551j.add(new f(gVar.f1549h, new e(0, gVar.f1545d, gVar.f1542a.c(), 0L, 0L, 0L), gVar));
            }
            for (b.a.a.b.a.b bVar : gVar.f1551j) {
                gVar.f1544c.execute(bVar);
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1532g == 107 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1532g == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.f1532g = 102;
            g gVar = (g) this.f1531f;
            gVar.f1548g = 102;
            a aVar = gVar.f1543b;
            aVar.f1529b.r(102);
            aVar.f1528a.a(aVar.f1529b);
            try {
                a();
            } catch (DownloadException e2) {
                b(e2);
            }
        }
    }
}
