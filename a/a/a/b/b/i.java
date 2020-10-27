package a.a.a.b.b;

import a.a.a.b.a.b;
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
/* loaded from: classes9.dex */
public abstract class i implements a.a.a.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    public String f957a;
    public volatile int e;
    public volatile int f = 0;
    public final c yG;
    public final e yH;
    public final b.a yI;

    public i(c cVar, e eVar, b.a aVar) {
        this.yG = cVar;
        this.yH = eVar;
        this.yI = aVar;
        this.f957a = c();
        if (TextUtils.isEmpty(this.f957a)) {
            this.f957a = getClass().getSimpleName();
        }
    }

    public abstract RandomAccessFile a(File file, String str, long j);

    public abstract Map<String, String> a(e eVar);

    public final void a() {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.yH.f954a).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(4000);
                        httpURLConnection2.setReadTimeout(4000);
                        httpURLConnection2.setRequestMethod("GET");
                        a(a(this.yH), httpURLConnection2);
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode == b()) {
                            a(httpURLConnection2);
                            httpURLConnection2.disconnect();
                            return;
                        }
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    } catch (ProtocolException e) {
                        e = e;
                        throw new DownloadException(108, "Protocol error", e);
                    } catch (IOException e2) {
                        e = e2;
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
                synchronized (this.yI) {
                    this.e = 106;
                    ((g) this.yI).d();
                }
                return;
            case 107:
                synchronized (this.yI) {
                    this.e = 107;
                    ((g) this.yI).c();
                }
                return;
            case 108:
                synchronized (this.yI) {
                    this.e = 108;
                    ((g) this.yI).b(downloadException);
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown state");
        }
    }

    public final void a(Closeable closeable) {
        if (closeable != null) {
            synchronized (i.class) {
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
        while (this.f != 107) {
            if (this.f == 106) {
                c(this.yH);
                throw new DownloadException(106, "Download paused!");
            }
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                randomAccessFile.write(bArr, 0, read);
                long j = read;
                this.yH.d += j;
                synchronized (this.yI) {
                    this.yG.d += j;
                    ((g) this.yI).a(this.yG.d, this.yG.c);
                }
            } catch (IOException e) {
                c(this.yH);
                throw new DownloadException(108, e);
            }
        }
        throw new DownloadException(107, "Download canceled!");
    }

    public final void a(HttpURLConnection httpURLConnection) {
        Throwable th;
        Closeable closeable;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    long j = this.yH.b;
                    long j2 = this.yH.d;
                    try {
                        File file = this.yG.b;
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        randomAccessFile = a(file, this.yG.f953a, j + j2);
                        try {
                            a(inputStream, randomAccessFile);
                            try {
                                a(inputStream);
                                a(randomAccessFile);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = inputStream;
                            try {
                                a(closeable);
                                a(randomAccessFile);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        throw new DownloadException(108, "File occur IOException ", e3);
                    } catch (Exception e4) {
                        throw new DownloadException(108, "Occur Exception ", e4);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = inputStream;
                }
            } catch (IOException e5) {
                throw new DownloadException(108, "http get inputStream error", e5);
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
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

    public abstract void b(e eVar);

    public abstract String c();

    public abstract void c(e eVar);

    public boolean d() {
        return this.e == 104;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        b(this.yH);
        try {
            this.e = 104;
            a();
            synchronized (this.yI) {
                this.e = 105;
                b.a aVar = this.yI;
                ((g) aVar).a(this.yG.b.getAbsolutePath() + File.separator + this.yG.f953a);
            }
        } catch (DownloadException e) {
            a(e);
        }
    }
}
