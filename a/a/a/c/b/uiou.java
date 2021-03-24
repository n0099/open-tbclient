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
    public String f1431a;

    /* renamed from: b  reason: collision with root package name */
    public final bv f1432b;

    /* renamed from: c  reason: collision with root package name */
    public final lbvzx f1433c;

    /* renamed from: d  reason: collision with root package name */
    public final bv.InterfaceC0007bv f1434d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f1435e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f1436f = 0;

    public uiou(bv bvVar, lbvzx lbvzxVar, bv.InterfaceC0007bv interfaceC0007bv) {
        this.f1432b = bvVar;
        this.f1433c = lbvzxVar;
        this.f1434d = interfaceC0007bv;
        String c2 = c();
        this.f1431a = c2;
        if (TextUtils.isEmpty(c2)) {
            this.f1431a = getClass().getSimpleName();
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
                    httpURLConnection = (HttpURLConnection) new URL(this.f1433c.f1416a).openConnection();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpURLConnection.setConnectTimeout(4000);
                    httpURLConnection.setReadTimeout(4000);
                    httpURLConnection.setRequestMethod("GET");
                    a(a(this.f1433c), httpURLConnection);
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
                synchronized (this.f1434d) {
                    this.f1435e = 106;
                    ((shuoy) this.f1434d).d();
                }
                return;
            case 107:
                synchronized (this.f1434d) {
                    this.f1435e = 107;
                    ((shuoy) this.f1434d).c();
                }
                return;
            case 108:
                synchronized (this.f1434d) {
                    this.f1435e = 108;
                    ((shuoy) this.f1434d).b(downloadException);
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
        while (this.f1436f != 107) {
            if (this.f1436f == 106) {
                c(this.f1433c);
                throw new DownloadException(106, "Download paused!");
            }
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                randomAccessFile.write(bArr, 0, read);
                long j = read;
                this.f1433c.f1419d += j;
                synchronized (this.f1434d) {
                    this.f1432b.f1415d += j;
                    ((shuoy) this.f1434d).a(this.f1432b.f1415d, this.f1432b.f1414c);
                }
            } catch (IOException e2) {
                c(this.f1433c);
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
                    long j = this.f1433c.f1417b;
                    long j2 = this.f1433c.f1419d;
                    try {
                        try {
                            File file = this.f1432b.f1413b;
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            RandomAccessFile a2 = a(file, this.f1432b.f1412a, j + j2);
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
        return this.f1435e == 104;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        b(this.f1433c);
        try {
            this.f1435e = 104;
            a();
            synchronized (this.f1434d) {
                this.f1435e = 105;
                bv.InterfaceC0007bv interfaceC0007bv = this.f1434d;
                ((shuoy) interfaceC0007bv).a(this.f1432b.f1413b.getAbsolutePath() + File.separator + this.f1432b.f1412a);
            }
        } catch (DownloadException e2) {
            a(e2);
        }
    }
}
