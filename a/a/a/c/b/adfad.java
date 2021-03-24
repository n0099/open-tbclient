package a.a.a.c.b;

import a.a.a.c.a.ac;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudbase.download.exception.DownloadException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class adfad implements a.a.a.c.a.ac {

    /* renamed from: a  reason: collision with root package name */
    public final String f1408a;

    /* renamed from: b  reason: collision with root package name */
    public final ac.bv f1409b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1410c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f1411d;

    public adfad(String str, ac.bv bvVar) {
        this.f1408a = str;
        this.f1409b = bvVar;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Log.d("RtcDownSo", "execute connnection");
        this.f1411d = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.f1408a).openConnection();
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

    public final void a(DownloadException downloadException) {
        switch (downloadException.getErrorCode()) {
            case 106:
                synchronized (this.f1409b) {
                    this.f1410c = 106;
                    ((shuoy) this.f1409b).d();
                }
                return;
            case 107:
                synchronized (this.f1409b) {
                    this.f1410c = 107;
                    ((shuoy) this.f1409b).b();
                }
                return;
            case 108:
                synchronized (this.f1409b) {
                    this.f1410c = 108;
                    ((shuoy) this.f1409b).a(downloadException);
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown state");
        }
    }

    public final void a(HttpURLConnection httpURLConnection, boolean z) {
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
        this.f1410c = 103;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f1411d;
        shuoy shuoyVar = (shuoy) this.f1409b;
        if (((adfad) shuoyVar.i).b()) {
            shuoyVar.b();
            return;
        }
        shuoyVar.f1426g = 103;
        ac acVar = shuoyVar.f1421b;
        acVar.f1407b.s(currentTimeMillis - j);
        acVar.f1407b.j(z);
        acVar.f1407b.r(103);
        acVar.f1406a.post(acVar.f1407b);
        shuoyVar.f1427h.a(z);
        shuoyVar.f1427h.f1414c = contentLength;
        shuoyVar.f1426g = 104;
        shuoyVar.j.clear();
        if (z) {
            ArrayList<lbvzx> arrayList = new ArrayList();
            int a2 = shuoyVar.f1424e.a();
            int i = 0;
            int i2 = 0;
            while (i2 < a2) {
                long j2 = contentLength / a2;
                long j3 = j2 * i2;
                arrayList.add(new lbvzx(i2, shuoyVar.f1423d, shuoyVar.f1420a.c(), j3, i2 == a2 + (-1) ? contentLength : (j2 + j3) - 1, 0L));
                i2++;
            }
            for (lbvzx lbvzxVar : arrayList) {
                i = (int) (i + lbvzxVar.f1419d);
            }
            shuoyVar.f1427h.a(i);
            for (lbvzx lbvzxVar2 : arrayList) {
                shuoyVar.j.add(new gasd(shuoyVar.f1427h, lbvzxVar2, shuoyVar));
            }
        } else {
            shuoyVar.j.add(new rwq(shuoyVar.f1427h, new lbvzx(0, shuoyVar.f1423d, shuoyVar.f1420a.c(), 0L, 0L, 0L), shuoyVar));
        }
        for (a.a.a.c.a.bv bvVar : shuoyVar.j) {
            shuoyVar.f1422c.execute(bvVar);
        }
    }

    public boolean b() {
        return this.f1410c == 107;
    }

    public boolean c() {
        return this.f1410c == 106;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.f1410c = 102;
        shuoy shuoyVar = (shuoy) this.f1409b;
        shuoyVar.f1426g = 102;
        ac acVar = shuoyVar.f1421b;
        acVar.f1407b.r(102);
        acVar.f1406a.post(acVar.f1407b);
        try {
            a();
        } catch (DownloadException e2) {
            a(e2);
        }
    }
}
