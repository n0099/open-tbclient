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
/* loaded from: classes10.dex */
public abstract class i implements a.a.a.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    public String f1043a;
    public volatile int e;
    public volatile int f = 0;
    public final c zv;
    public final e zw;
    public final b.a zx;

    public i(c cVar, e eVar, b.a aVar) {
        this.zv = cVar;
        this.zw = eVar;
        this.zx = aVar;
        this.f1043a = c();
        if (TextUtils.isEmpty(this.f1043a)) {
            this.f1043a = getClass().getSimpleName();
        }
    }

    public abstract Map<String, String> a(e eVar);

    public final void a() {
        Throwable th;
        IOException e;
        ProtocolException e2;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.zw.f1039a).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(4000);
                        httpURLConnection2.setReadTimeout(4000);
                        httpURLConnection2.setRequestMethod("GET");
                        a(a(this.zw), httpURLConnection2);
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode == b()) {
                            a(httpURLConnection2);
                            httpURLConnection2.disconnect();
                            return;
                        }
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    } catch (ProtocolException e3) {
                        e2 = e3;
                        throw new DownloadException(108, "Protocol error", e2);
                    } catch (IOException e4) {
                        e = e4;
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
                synchronized (this.zx) {
                    this.e = 106;
                    ((g) this.zx).d();
                }
                return;
            case 107:
                synchronized (this.zx) {
                    this.e = 107;
                    ((g) this.zx).c();
                }
                return;
            case 108:
                synchronized (this.zx) {
                    this.e = 108;
                    ((g) this.zx).b(downloadException);
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
                c(this.zw);
                throw new DownloadException(106, "Download paused!");
            }
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                randomAccessFile.write(bArr, 0, read);
                long j = read;
                this.zw.d += j;
                synchronized (this.zx) {
                    this.zv.d += j;
                    ((g) this.zx).a(this.zv.d, this.zv.c);
                }
            } catch (IOException e) {
                c(this.zw);
                throw new DownloadException(108, e);
            }
        }
        throw new DownloadException(107, "Download canceled!");
    }

    public final void a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        Closeable closeable;
        Throwable th;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    long j = this.zw.f1040b;
                    long j2 = this.zw.d;
                    try {
                        File file = this.zv.f1038b;
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RandomAccessFile c = c(file, this.zv.f1037a, j + j2);
                        try {
                            a(inputStream, c);
                            try {
                                a(inputStream);
                                a(c);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            closeable = c;
                            th = th2;
                            try {
                                a(inputStream);
                                a(closeable);
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
                    closeable = null;
                    th = th3;
                }
            } catch (IOException e5) {
                throw new DownloadException(108, "http get inputStream error", e5);
            }
        } catch (Throwable th4) {
            inputStream = null;
            closeable = null;
            th = th4;
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

    public abstract RandomAccessFile c(File file, String str, long j);

    public abstract String c();

    public abstract void c(e eVar);

    public boolean d() {
        return this.e == 104;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        b(this.zw);
        try {
            this.e = 104;
            a();
            synchronized (this.zx) {
                this.e = 105;
                b.a aVar = this.zx;
                ((g) aVar).a(this.zv.f1038b.getAbsolutePath() + File.separator + this.zv.f1037a);
            }
        } catch (DownloadException e) {
            a(e);
        }
    }
}
