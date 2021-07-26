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
public class adfad implements a.a.a.c.a.ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f1461a;

    /* renamed from: b  reason: collision with root package name */
    public final ac.bv f1462b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1463c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f1464d;

    public adfad(String str, ac.bv bvVar) {
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
        this.f1461a = str;
        this.f1462b = bvVar;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d("RtcDownSo", "execute connnection");
            this.f1464d = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.f1461a).openConnection();
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
                    synchronized (this.f1462b) {
                        this.f1463c = 106;
                        ((shuoy) this.f1462b).d();
                    }
                    return;
                case 107:
                    synchronized (this.f1462b) {
                        this.f1463c = 107;
                        ((shuoy) this.f1462b).b();
                    }
                    return;
                case 108:
                    synchronized (this.f1462b) {
                        this.f1463c = 108;
                        ((shuoy) this.f1462b).a(downloadException);
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
            this.f1463c = 103;
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f1464d;
            shuoy shuoyVar = (shuoy) this.f1462b;
            if (((adfad) shuoyVar.f1481i).b()) {
                shuoyVar.b();
                return;
            }
            shuoyVar.f1479g = 103;
            ac acVar = shuoyVar.f1474b;
            acVar.f1460b.s(currentTimeMillis - j);
            acVar.f1460b.j(z);
            acVar.f1460b.r(103);
            acVar.f1459a.post(acVar.f1460b);
            shuoyVar.f1480h.a(z);
            shuoyVar.f1480h.f1467c = contentLength;
            shuoyVar.f1479g = 104;
            shuoyVar.j.clear();
            if (z) {
                ArrayList<lbvzx> arrayList = new ArrayList();
                int a2 = shuoyVar.f1477e.a();
                int i2 = 0;
                int i3 = 0;
                while (i3 < a2) {
                    long j2 = contentLength / a2;
                    long j3 = j2 * i3;
                    arrayList.add(new lbvzx(i3, shuoyVar.f1476d, shuoyVar.f1473a.c(), j3, i3 == a2 + (-1) ? contentLength : (j2 + j3) - 1, 0L));
                    i3++;
                }
                for (lbvzx lbvzxVar : arrayList) {
                    i2 = (int) (i2 + lbvzxVar.f1472d);
                }
                shuoyVar.f1480h.a(i2);
                for (lbvzx lbvzxVar2 : arrayList) {
                    shuoyVar.j.add(new gasd(shuoyVar.f1480h, lbvzxVar2, shuoyVar));
                }
            } else {
                shuoyVar.j.add(new rwq(shuoyVar.f1480h, new lbvzx(0, shuoyVar.f1476d, shuoyVar.f1473a.c(), 0L, 0L, 0L), shuoyVar));
            }
            for (a.a.a.c.a.bv bvVar : shuoyVar.j) {
                shuoyVar.f1475c.execute(bvVar);
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1463c == 107 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1463c == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.f1463c = 102;
            shuoy shuoyVar = (shuoy) this.f1462b;
            shuoyVar.f1479g = 102;
            ac acVar = shuoyVar.f1474b;
            acVar.f1460b.r(102);
            acVar.f1459a.post(acVar.f1460b);
            try {
                a();
            } catch (DownloadException e2) {
                a(e2);
            }
        }
    }
}
