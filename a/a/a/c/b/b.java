package a.a.a.c.b;

import a.a.a.c.a.ac;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
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
public class b implements a.a.a.c.a.ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f1437a;

    /* renamed from: b  reason: collision with root package name */
    public final ac.bv f1438b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1439c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f1440d;

    public b(String str, ac.bv bvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1437a = str;
        this.f1438b = bvVar;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d("RtcDownSo", "execute connnection");
            this.f1440d = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1437a).openConnection();
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
                        a(httpURLConnection, false);
                    } else if (responseCode != 206) {
                        Log.d("RtcDownSo", "UnSupported response code:" + responseCode);
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    } else {
                        a(httpURLConnection, true);
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

    public final void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f1438b) {
                        this.f1439c = 106;
                        ((a) this.f1438b).d();
                    }
                    return;
                case 107:
                    synchronized (this.f1438b) {
                        this.f1439c = 107;
                        ((a) this.f1438b).b();
                    }
                    return;
                case 108:
                    synchronized (this.f1438b) {
                        this.f1439c = 108;
                        ((a) this.f1438b).a(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void a(HttpURLConnection httpURLConnection, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection, z) == null) {
            Log.d("RtcDownSo", "start parse response");
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            long contentLength = (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField);
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                contentLength = (TextUtils.isEmpty(headerField2) || headerField2.equals("0") || headerField2.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField2);
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            if (b()) {
                throw new DownloadException(107, "Connection Canceled!");
            }
            if (c()) {
                throw new DownloadException(106, "Connection Paused!");
            }
            this.f1439c = 103;
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f1440d;
            a aVar = (a) this.f1438b;
            if (((b) aVar.f1434i).b()) {
                aVar.b();
                return;
            }
            aVar.f1432g = 103;
            ac acVar = aVar.f1427b;
            acVar.f1436b.s(currentTimeMillis - j);
            acVar.f1436b.j(z);
            acVar.f1436b.r(103);
            acVar.f1435a.post(acVar.f1436b);
            aVar.f1433h.a(z);
            aVar.f1433h.f1443c = contentLength;
            aVar.f1432g = 104;
            aVar.j.clear();
            if (z) {
                ArrayList<e> arrayList = new ArrayList();
                int a2 = aVar.f1430e.a();
                int i2 = 0;
                int i3 = 0;
                while (i3 < a2) {
                    long j2 = contentLength / a2;
                    long j3 = j2 * i3;
                    arrayList.add(new e(i3, aVar.f1429d, aVar.f1426a.c(), j3, i3 == a2 + (-1) ? contentLength : (j2 + j3) - 1, 0L));
                    i3++;
                }
                for (e eVar : arrayList) {
                    i2 = (int) (i2 + eVar.f1448d);
                }
                aVar.f1433h.a(i2);
                for (e eVar2 : arrayList) {
                    aVar.j.add(new c(aVar.f1433h, eVar2, aVar));
                }
            } else {
                aVar.j.add(new d(aVar.f1433h, new e(0, aVar.f1429d, aVar.f1426a.c(), 0L, 0L, 0L), aVar));
            }
            for (a.a.a.c.a.bv bvVar : aVar.j) {
                aVar.f1428c.execute(bvVar);
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1439c == 107 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1439c == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.f1439c = 102;
            a aVar = (a) this.f1438b;
            aVar.f1432g = 102;
            ac acVar = aVar.f1427b;
            acVar.f1436b.r(102);
            acVar.f1435a.post(acVar.f1436b);
            try {
                a();
            } catch (DownloadException e2) {
                a(e2);
            }
        }
    }
}
