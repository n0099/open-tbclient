package a.a.a.c.b;

import a.a.a.c.a.bv;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cloudbase.download.exception.DownloadException;
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
/* loaded from: classes.dex */
public abstract class uiou implements a.a.a.c.a.bv {

    /* renamed from: a  reason: collision with root package name */
    public String f1449a;

    /* renamed from: b  reason: collision with root package name */
    public final bv f1450b;

    /* renamed from: c  reason: collision with root package name */
    public final lbvzx f1451c;

    /* renamed from: d  reason: collision with root package name */
    public final bv.InterfaceC0007bv f1452d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f1453e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f1454f = 0;

    public uiou(bv bvVar, lbvzx lbvzxVar, bv.InterfaceC0007bv interfaceC0007bv) {
        this.f1450b = bvVar;
        this.f1451c = lbvzxVar;
        this.f1452d = interfaceC0007bv;
        String c2 = c();
        this.f1449a = c2;
        if (TextUtils.isEmpty(c2)) {
            this.f1449a = getClass().getSimpleName();
        }
    }

    public abstract RandomAccessFile a(File file, String str, long j);

    public abstract Map<String, String> a(lbvzx lbvzxVar);

    public final void a() {
        HttpURLConnection httpURLConnection;
        try {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.f1451c.f1433a).openConnection();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpURLConnection.setConnectTimeout(4000);
                    httpURLConnection.setReadTimeout(4000);
                    httpURLConnection.setRequestMethod("GET");
                    a(a(this.f1451c), httpURLConnection);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == b()) {
                        a(httpURLConnection);
                        httpURLConnection.disconnect();
                        return;
                    }
                    throw new DownloadException(108, "UnSupported response code:" + responseCode);
                } catch (ProtocolException e2) {
                    e = e2;
                    throw new DownloadException(108, "Protocol error", e);
                } catch (IOException e3) {
                    e = e3;
                    throw new DownloadException(108, "IO error", e);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (ProtocolException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (MalformedURLException e6) {
            throw new DownloadException(108, "Bad url.", e6);
        }
    }

    public final void a(DownloadException downloadException) {
        switch (downloadException.getErrorCode()) {
            case 106:
                synchronized (this.f1452d) {
                    this.f1453e = 106;
                    ((shuoy) this.f1452d).d();
                }
                return;
            case 107:
                synchronized (this.f1452d) {
                    this.f1453e = 107;
                    ((shuoy) this.f1452d).c();
                }
                return;
            case 108:
                synchronized (this.f1452d) {
                    this.f1453e = 108;
                    ((shuoy) this.f1452d).b(downloadException);
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown state");
        }
    }

    public final void a(Closeable closeable) {
        if (closeable != null) {
            synchronized (uiou.class) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void a(InputStream inputStream, RandomAccessFile randomAccessFile) {
        byte[] bArr = new byte[8192];
        while (this.f1454f != 107) {
            if (this.f1454f == 106) {
                c(this.f1451c);
                throw new DownloadException(106, "Download paused!");
            }
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                randomAccessFile.write(bArr, 0, read);
                long j = read;
                this.f1451c.f1436d += j;
                synchronized (this.f1452d) {
                    this.f1450b.f1432d += j;
                    ((shuoy) this.f1452d).a(this.f1450b.f1432d, this.f1450b.f1431c);
                }
            } catch (IOException e2) {
                c(this.f1451c);
                throw new DownloadException(108, e2);
            }
        }
        throw new DownloadException(107, "Download canceled!");
    }

    public final void a(HttpURLConnection httpURLConnection) {
        Throwable th;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    long j = this.f1451c.f1434b;
                    long j2 = this.f1451c.f1436d;
                    try {
                        try {
                            File file = this.f1450b.f1430b;
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            RandomAccessFile a2 = a(file, this.f1450b.f1429a, j + j2);
                            a(inputStream, a2);
                            try {
                                a(inputStream);
                                a(a2);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (IOException e3) {
                            throw new DownloadException(108, "File occur IOException ", e3);
                        }
                    } catch (Exception e4) {
                        throw new DownloadException(108, "Occur Exception ", e4);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = inputStream;
                    closeable = null;
                    try {
                        a(closeable2);
                        a(closeable);
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
            }
        } catch (IOException e6) {
            throw new DownloadException(108, "http get inputStream error", e6);
        }
    }

    public final void a(Map<String, String> map, URLConnection uRLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                uRLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    public abstract int b();

    public abstract void b(lbvzx lbvzxVar);

    public abstract String c();

    public abstract void c(lbvzx lbvzxVar);

    public boolean d() {
        return this.f1453e == 104;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        b(this.f1451c);
        try {
            this.f1453e = 104;
            a();
            synchronized (this.f1452d) {
                this.f1453e = 105;
                bv.InterfaceC0007bv interfaceC0007bv = this.f1452d;
                ((shuoy) interfaceC0007bv).a(this.f1450b.f1430b.getAbsolutePath() + File.separator + this.f1450b.f1429a);
            }
        } catch (DownloadException e2) {
            a(e2);
        }
    }
}
