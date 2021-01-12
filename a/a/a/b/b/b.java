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
    public final String f1036a;
    public volatile int c;
    public volatile long d;
    public final a.InterfaceC0000a zm;

    public b(String str, a.InterfaceC0000a interfaceC0000a) {
        this.f1036a = str;
        this.zm = interfaceC0000a;
    }

    public final void a() {
        Throwable th;
        IOException e;
        ProtocolException e2;
        HttpURLConnection httpURLConnection = null;
        Log.d("RtcDownSo", "execute connnection");
        this.d = System.currentTimeMillis();
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f1036a).openConnection();
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
                    } catch (ProtocolException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        throw new DownloadException(108, "Protocol error", e2);
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        throw new DownloadException(108, "IO error", e);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (ProtocolException e5) {
                    e2 = e5;
                } catch (IOException e6) {
                    e = e6;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (MalformedURLException e7) {
            throw new DownloadException(108, "Bad url.", e7);
        }
    }

    public final void a(DownloadException downloadException) {
        switch (downloadException.getErrorCode()) {
            case 106:
                synchronized (this.zm) {
                    this.c = 106;
                    ((g) this.zm).d();
                }
                return;
            case 107:
                synchronized (this.zm) {
                    this.c = 107;
                    ((g) this.zm).b();
                }
                return;
            case 108:
                synchronized (this.zm) {
                    this.c = 108;
                    ((g) this.zm).a(downloadException);
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
        g gVar = (g) this.zm;
        if (((b) gVar.zs).b()) {
            gVar.b();
            return;
        }
        gVar.g = 103;
        a aVar = gVar.zo;
        aVar.zl.setTime(currentTimeMillis - j2);
        aVar.zl.setAcceptRanges(z);
        aVar.zl.setStatus(103);
        aVar.zk.a(aVar.zl);
        gVar.zr.a(z);
        gVar.zr.c = j;
        gVar.g = 104;
        gVar.j.clear();
        if (z) {
            ArrayList<e> arrayList = new ArrayList();
            int a2 = gVar.zp.a();
            int i2 = 0;
            while (i2 < a2) {
                long j3 = j / a2;
                long j4 = i2 * j3;
                arrayList.add(new e(i2, gVar.d, gVar.zn.getUri(), j4, i2 == a2 + (-1) ? j : (j3 + j4) - 1, 0L));
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
            gVar.zr.a(i);
            for (e eVar : arrayList) {
                gVar.j.add(new d(gVar.zr, eVar, gVar));
            }
        } else {
            gVar.j.add(new f(gVar.zr, new e(0, gVar.d, gVar.zn.getUri(), 0L, 0L, 0L), gVar));
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
        g gVar = (g) this.zm;
        gVar.g = 102;
        a aVar = gVar.zo;
        aVar.zl.setStatus(102);
        aVar.zk.a(aVar.zl);
        try {
            a();
        } catch (DownloadException e) {
            a(e);
        }
    }
}
