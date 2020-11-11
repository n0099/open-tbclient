package a.a.a.b.b;

import a.a.a.b.a.a;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b implements a.a.a.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f954a;
    public volatile int c;
    public volatile long d;
    public final a.InterfaceC0000a yx;

    public b(String str, a.InterfaceC0000a interfaceC0000a) {
        this.f954a = str;
        this.yx = interfaceC0000a;
    }

    public final void a() {
        HttpURLConnection httpURLConnection = null;
        Log.d("RtcDownSo", "execute connnection");
        this.d = System.currentTimeMillis();
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f954a).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(4000);
                        httpURLConnection2.setReadTimeout(4000);
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setRequestProperty(Headers.RANGE, "bytes=0-");
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode == 200) {
                            a(httpURLConnection2, false);
                        } else if (responseCode != 206) {
                            Log.d("RtcDownSo", "UnSupported response code:" + responseCode);
                            throw new DownloadException(108, "UnSupported response code:" + responseCode);
                        } else {
                            a(httpURLConnection2, true);
                        }
                        httpURLConnection2.disconnect();
                    } catch (ProtocolException e) {
                        e = e;
                        e.printStackTrace();
                        throw new DownloadException(108, "Protocol error", e);
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        throw new DownloadException(108, "IO error", e);
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (ProtocolException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (MalformedURLException e5) {
            throw new DownloadException(108, "Bad url.", e5);
        }
    }

    public final void a(DownloadException downloadException) {
        switch (downloadException.getErrorCode()) {
            case 106:
                synchronized (this.yx) {
                    this.c = 106;
                    ((g) this.yx).d();
                }
                return;
            case 107:
                synchronized (this.yx) {
                    this.c = 107;
                    ((g) this.yx).b();
                }
                return;
            case 108:
                synchronized (this.yx) {
                    this.c = 108;
                    ((g) this.yx).a(downloadException);
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown state");
        }
    }

    public final void a(HttpURLConnection httpURLConnection, boolean z) {
        long j;
        int i;
        Log.d("RtcDownSo", "start parse response");
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        long contentLength = (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField);
        if (contentLength <= 0) {
            String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
            long contentLength2 = (TextUtils.isEmpty(headerField2) || headerField2.equals("0") || headerField2.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField2);
            if (contentLength2 <= 0) {
                throw new DownloadException(108, "length <= 0");
            }
            j = contentLength2;
        } else {
            j = contentLength;
        }
        if (b()) {
            throw new DownloadException(107, "Connection Canceled!");
        }
        if (c()) {
            throw new DownloadException(106, "Connection Paused!");
        }
        this.c = 103;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.d;
        g gVar = (g) this.yx;
        if (((b) gVar.yD).b()) {
            gVar.b();
            return;
        }
        gVar.g = 103;
        a aVar = gVar.yz;
        aVar.yw.setTime(currentTimeMillis - j2);
        aVar.yw.setAcceptRanges(z);
        aVar.yw.setStatus(103);
        aVar.yv.a(aVar.yw);
        gVar.yC.a(z);
        gVar.yC.c = j;
        gVar.g = 104;
        gVar.j.clear();
        if (z) {
            ArrayList<e> arrayList = new ArrayList();
            int a2 = gVar.yA.a();
            int i2 = 0;
            while (i2 < a2) {
                long j3 = j / a2;
                long j4 = i2 * j3;
                arrayList.add(new e(i2, gVar.d, gVar.yy.getUri(), j4, i2 == a2 + (-1) ? j : (j3 + j4) - 1, 0L));
                i2++;
            }
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                i = i3;
                if (!it.hasNext()) {
                    break;
                }
                i3 = (int) (((e) it.next()).d + i);
            }
            gVar.yC.a(i);
            for (e eVar : arrayList) {
                gVar.j.add(new d(gVar.yC, eVar, gVar));
            }
        } else {
            gVar.j.add(new f(gVar.yC, new e(0, gVar.d, gVar.yy.getUri(), 0L, 0L, 0L), gVar));
        }
        for (a.a.a.b.a.b bVar : gVar.j) {
            gVar.c.execute(bVar);
        }
    }

    public boolean b() {
        return this.c == 107;
    }

    public boolean c() {
        return this.c == 106;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.c = 102;
        g gVar = (g) this.yx;
        gVar.g = 102;
        a aVar = gVar.yz;
        aVar.yw.setStatus(102);
        aVar.yv.a(aVar.yw);
        try {
            a();
        } catch (DownloadException e) {
            a(e);
        }
    }
}
