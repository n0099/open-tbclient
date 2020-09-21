package com.baidu.mobads.openad.b;

import android.content.Context;
import android.os.Environment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
/* loaded from: classes3.dex */
public class a extends Observable implements IOAdDownloader, Runnable {
    protected Context a;
    protected URL b;
    protected URL c;
    protected String d;
    protected int e;
    protected String g;
    protected int h;
    protected IOAdDownloader.DownloadStatus i;
    protected volatile int j;
    protected int k;
    protected ArrayList<RunnableC0222a> l;
    private String n;
    private String o;
    protected Boolean f = true;
    g m = null;
    private boolean p = false;

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public boolean isPausedManually() {
        return this.p;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void setPausedManually(boolean z) {
        this.p = z;
    }

    public a(Context context, URL url, String str, String str2, int i, String str3, String str4) {
        this.a = context;
        this.b = url;
        this.d = str;
        this.e = i;
        if (str2 != null && str2.trim().length() > 0) {
            this.g = str2;
        } else {
            String file = url.getFile();
            this.g = file.substring(file.lastIndexOf(47) + 1);
        }
        this.h = -1;
        this.i = IOAdDownloader.DownloadStatus.NONE;
        this.j = 0;
        this.k = 0;
        this.n = str3;
        this.o = str4;
        this.l = new ArrayList<>();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void pause() {
        try {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "execute Pause; state = " + this.i);
            if (this.i == IOAdDownloader.DownloadStatus.DOWNLOADING || this.i == IOAdDownloader.DownloadStatus.ERROR || this.i == IOAdDownloader.DownloadStatus.NONE) {
                if (this.l != null) {
                    for (int i = 0; i < this.l.size(); i++) {
                        if (!this.l.get(i).a()) {
                            this.l.get(i).c();
                        }
                    }
                }
                a(IOAdDownloader.DownloadStatus.PAUSED);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "pause exception");
            com.baidu.mobads.c.a.a().a("apk download pause failed: " + e.toString());
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void resume() {
        try {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "execute Resume; state = " + this.i);
            if (this.i == IOAdDownloader.DownloadStatus.PAUSED || this.i == IOAdDownloader.DownloadStatus.ERROR || this.i == IOAdDownloader.DownloadStatus.CANCELLED) {
                a(IOAdDownloader.DownloadStatus.INITING);
                setPausedManually(true);
                new Thread(this).start();
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "resume exception");
            com.baidu.mobads.c.a.a().a("apk download resume failed: " + e.toString());
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void cancel() {
        try {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "execute Cancel; state = " + this.i);
            if (this.i == IOAdDownloader.DownloadStatus.PAUSED || this.i == IOAdDownloader.DownloadStatus.DOWNLOADING) {
                if (this.l != null) {
                    for (int i = 0; i < this.l.size(); i++) {
                        if (!this.l.get(i).a()) {
                            this.l.get(i).c();
                        }
                    }
                }
                a(IOAdDownloader.DownloadStatus.CANCELLED);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "cancel exception");
            com.baidu.mobads.c.a.a().a("apk download cancel failed: " + e.toString());
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getURL() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public int getFileSize() {
        return this.h;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public float getProgress() {
        return Math.abs((this.j / this.h) * 100.0f);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getTitle() {
        return this.n;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getPackageName() {
        return this.o;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public IOAdDownloader.DownloadStatus getState() {
        return this.i;
    }

    protected void a(IOAdDownloader.DownloadStatus downloadStatus) {
        this.i = downloadStatus;
        a();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void start() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "execute Start; state = " + this.i);
        if (this.i == IOAdDownloader.DownloadStatus.NONE) {
            a(IOAdDownloader.DownloadStatus.INITING);
            setPausedManually(true);
            new Thread(this).start();
        }
    }

    protected synchronized void a(int i) {
        this.j += i;
        int progress = (int) getProgress();
        if (this.k < progress) {
            this.k = progress;
            a();
        }
    }

    protected void a() {
        setChanged();
        notifyObservers();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getOutputPath() {
        return this.d + this.g;
    }

    protected synchronized void b() {
        this.i = IOAdDownloader.DownloadStatus.ERROR;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.l.size()) {
                if (!this.l.get(i2).a()) {
                    this.l.get(i2).c();
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0261 A[EDGE_INSN: B:143:0x0261->B:73:0x0261 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0288 A[EDGE_INSN: B:146:0x0288->B:80:0x0288 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(HttpURLConnection httpURLConnection) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        ArrayList arrayList;
        Exception e;
        List<h> b;
        String url = this.c.toString();
        String str = (this.d + this.g) + ".tmp";
        if (this.l.size() == 0) {
            File file = new File(this.d);
            if (!file.exists()) {
                file.mkdirs();
            }
            ArrayList<h> arrayList2 = null;
            File file2 = new File(str);
            if (this.f.booleanValue() && file2.exists() && file2.length() == this.h) {
                try {
                    this.m = new g(this.a);
                    b = this.m.b(url, str);
                } catch (Exception e2) {
                    arrayList = null;
                    e = e2;
                }
                if (b != null && b.size() > 0) {
                    arrayList = new ArrayList();
                    try {
                        HashSet hashSet = new HashSet();
                        for (h hVar : b) {
                            if (!hashSet.contains(Integer.valueOf(hVar.c()))) {
                                hashSet.add(Integer.valueOf(hVar.c()));
                                arrayList.add(hVar);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "resume from db: start=" + hVar.d() + ";end =" + hVar.e() + ";complete=" + hVar.a());
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", e);
                        arrayList2 = arrayList;
                        if (arrayList2 != null) {
                        }
                        if (file2.exists()) {
                        }
                        try {
                            file2.createNewFile();
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
                            randomAccessFile.setLength(this.h);
                            randomAccessFile.close();
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = -1;
                            int i7 = 0;
                            if (this.e <= 1) {
                            }
                            while (r3.hasNext()) {
                            }
                            if (this.f.booleanValue()) {
                            }
                            this.j = i;
                            this.k = (int) getProgress();
                            a(IOAdDownloader.DownloadStatus.DOWNLOADING);
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "Downloader starts unfinished threads and waits threads end");
                            i2 = 0;
                            while (true) {
                                i3 = i2;
                                if (i3 < this.l.size()) {
                                }
                                i2 = i3 + 1;
                            }
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < this.l.size()) {
                                }
                                i4 = i5 + 1;
                            }
                            if (this.i != IOAdDownloader.DownloadStatus.DOWNLOADING) {
                            }
                            if (this.i == IOAdDownloader.DownloadStatus.COMPLETED) {
                            }
                        } catch (Exception e4) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", " 建立文件失败:");
                            a(IOAdDownloader.DownloadStatus.ERROR);
                            return;
                        }
                    }
                    arrayList2 = arrayList;
                }
            }
            if (arrayList2 != null || arrayList2.size() < 1) {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rwd");
                randomAccessFile2.setLength(this.h);
                randomAccessFile2.close();
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                ArrayList arrayList32 = new ArrayList();
                int i62 = -1;
                int i72 = 0;
                if (this.e <= 1) {
                    int round = Math.round((this.h / this.e) / 102400.0f) * BdStatsConstant.MAX_WRITE_LOG_SIZE;
                    while (i62 < this.h) {
                        int i8 = i62 + 1;
                        if (i62 + round < this.h) {
                            i62 += round;
                        } else {
                            i62 = this.h;
                        }
                        i72++;
                        arrayList32.add(new h(i72, url, str, i8, i62, 0));
                    }
                    arrayList2 = arrayList32;
                } else {
                    arrayList32.add(new h(1, url, str, 0, this.h, 0));
                    arrayList2 = arrayList32;
                }
            }
            for (h hVar2 : arrayList2) {
                RunnableC0222a runnableC0222a = new RunnableC0222a(hVar2.c(), this.c, hVar2.f(), hVar2.d(), hVar2.e(), hVar2.a());
                if (hVar2.d() == 0 && hVar2.a() == 0) {
                    runnableC0222a.a(httpURLConnection);
                }
                this.l.add(runnableC0222a);
            }
        }
        if (this.f.booleanValue()) {
            i = 0;
        } else {
            int i9 = 0;
            i = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.l.size()) {
                    break;
                }
                i += this.l.get(i10).f;
                i9 = i10 + 1;
            }
        }
        this.j = i;
        this.k = (int) getProgress();
        a(IOAdDownloader.DownloadStatus.DOWNLOADING);
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "Downloader starts unfinished threads and waits threads end");
        i2 = 0;
        while (true) {
            i3 = i2;
            if (i3 < this.l.size()) {
                break;
            }
            if (!this.l.get(i3).a()) {
                this.l.get(i3).b();
            }
            i2 = i3 + 1;
        }
        i4 = 0;
        while (true) {
            i5 = i4;
            if (i5 < this.l.size()) {
                break;
            }
            if (!this.l.get(i5).a()) {
                this.l.get(i5).d();
            }
            i4 = i5 + 1;
        }
        if (this.i != IOAdDownloader.DownloadStatus.DOWNLOADING) {
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= this.l.size()) {
                    z = false;
                    break;
                } else if (this.l.get(i12).a()) {
                    i11 = i12 + 1;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                a(IOAdDownloader.DownloadStatus.ERROR);
            } else {
                a(this.l);
                a(IOAdDownloader.DownloadStatus.COMPLETED);
            }
        } else if (this.i == IOAdDownloader.DownloadStatus.ERROR) {
            a(IOAdDownloader.DownloadStatus.ERROR);
        } else if (this.i == IOAdDownloader.DownloadStatus.CANCELLED) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "Downloader is cancelled");
        } else if (this.i == IOAdDownloader.DownloadStatus.PAUSED) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "Downloader is paused");
        }
        if (this.i == IOAdDownloader.DownloadStatus.COMPLETED) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "save database now");
            if (this.f.booleanValue()) {
                try {
                    if (this.m == null) {
                        this.m = new g(this.a);
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator<RunnableC0222a> it = this.l.iterator();
                    while (it.hasNext()) {
                        RunnableC0222a next = it.next();
                        arrayList4.add(new h(next.a, url, str, next.d, next.e, next.f));
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "save to db: start=" + next.d + ";end =" + next.e + ";complete=" + next.f);
                    }
                    if (this.m.a(url, str)) {
                        this.m.b(arrayList4);
                    } else {
                        this.m.a(arrayList4);
                    }
                } catch (Exception e5) {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", e5);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [564=9, 566=8, 567=8, 568=8] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        HttpURLConnection httpURLConnection;
        Throwable th;
        IXAdLogger adLogger;
        Object[] objArr;
        HttpURLConnection httpURLConnection2 = null;
        if (this.c != null && this.h >= 1) {
            try {
                a((HttpURLConnection) null);
                return;
            } catch (Exception e) {
                a(IOAdDownloader.DownloadStatus.ERROR);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", e);
                return;
            }
        }
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection3 = XAdSDKFoundationFacade.getInstance().getURIUitls().getHttpURLConnection(this.b);
                    httpURLConnection3.setRequestProperty(Headers.RANGE, "bytes=0-");
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setInstanceFollowRedirects(true);
                    httpURLConnection3.connect();
                    int responseCode = httpURLConnection3.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        httpURLConnection3.setInstanceFollowRedirects(false);
                        httpURLConnection3 = b(httpURLConnection3);
                        responseCode = httpURLConnection3.getResponseCode();
                    }
                    if (responseCode / 100 != 2) {
                        a(IOAdDownloader.DownloadStatus.ERROR);
                        if (httpURLConnection3 == null) {
                            return;
                        }
                        try {
                            httpURLConnection3.disconnect();
                            return;
                        } catch (Exception e2) {
                            adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                            objArr = new Object[]{"Downloader", e2.getMessage()};
                        }
                    } else if (httpURLConnection3.getContentType().equals("text/html")) {
                        a(IOAdDownloader.DownloadStatus.ERROR);
                        if (httpURLConnection3 == null) {
                            return;
                        }
                        try {
                            httpURLConnection3.disconnect();
                            return;
                        } catch (Exception e3) {
                            adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                            objArr = new Object[]{"Downloader", e3.getMessage()};
                        }
                    } else {
                        int contentLength = httpURLConnection3.getContentLength();
                        if (contentLength < 1) {
                            a(IOAdDownloader.DownloadStatus.ERROR);
                            if (httpURLConnection3 == null) {
                                return;
                            }
                            try {
                                httpURLConnection3.disconnect();
                                return;
                            } catch (Exception e4) {
                                adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                objArr = new Object[]{"Downloader", e4.getMessage()};
                            }
                        } else {
                            if (contentLength < 5120000) {
                                this.e = 1;
                            }
                            this.c = httpURLConnection3.getURL();
                            if ("mounted".equals(Environment.getExternalStorageState())) {
                                String a = l.a(this.a);
                                String str = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(this.c.toString()) + ".apk";
                                this.d = a;
                                this.g = str;
                                if (new File(a + str).exists()) {
                                    a(IOAdDownloader.DownloadStatus.COMPLETED);
                                    if (httpURLConnection3 == null) {
                                        return;
                                    }
                                    try {
                                        httpURLConnection3.disconnect();
                                        return;
                                    } catch (Exception e5) {
                                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                        objArr = new Object[]{"Downloader", e5.getMessage()};
                                    }
                                } else {
                                    if (httpURLConnection3.getHeaderField(Headers.CONTENT_RANGE) == null && (httpURLConnection3.getHeaderField("Accept-Ranges") == null || httpURLConnection3.getHeaderField("Accept-Ranges").equalsIgnoreCase("none"))) {
                                        this.f = false;
                                        this.e = 1;
                                    }
                                    if (this.h == -1) {
                                        this.h = contentLength;
                                    }
                                    a(httpURLConnection3);
                                    if (httpURLConnection3 == null) {
                                        return;
                                    }
                                    try {
                                        httpURLConnection3.disconnect();
                                        return;
                                    } catch (Exception e6) {
                                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                        objArr = new Object[]{"Downloader", e6.getMessage()};
                                    }
                                }
                            } else {
                                a(IOAdDownloader.DownloadStatus.ERROR);
                                if (httpURLConnection3 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection3.disconnect();
                                    return;
                                } catch (Exception e7) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"Downloader", e7.getMessage()};
                                }
                            }
                        }
                    }
                    adLogger.w(objArr);
                } catch (Throwable th2) {
                    httpURLConnection = null;
                    th = th2;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e8) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("Downloader", e8.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                a(IOAdDownloader.DownloadStatus.ERROR);
                if (0 == 0) {
                    return;
                }
                try {
                    httpURLConnection2.disconnect();
                } catch (Exception e10) {
                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                    objArr = new Object[]{"Downloader", e10.getMessage()};
                }
            }
        } catch (Throwable th3) {
            httpURLConnection = null;
            th = th3;
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    protected void a(ArrayList<RunnableC0222a> arrayList) {
        XAdSDKFoundationFacade.getInstance().getIoUtils().renameFile(this.d + this.g + ".tmp", this.d + this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.mobads.openad.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0222a implements Runnable {
        protected int a;
        protected URL b;
        protected String c;
        protected int d;
        protected int e;
        protected int f;
        protected Thread h;
        private HttpURLConnection l;
        private volatile boolean j = false;
        private volatile int k = 0;
        protected boolean g = false;

        public RunnableC0222a(int i, URL url, String str, int i2, int i3, int i4) {
            this.a = i;
            this.b = url;
            this.c = str;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public boolean a() {
            return this.g;
        }

        public synchronized void b() {
            this.j = false;
            this.h = new Thread(this);
            this.h.start();
        }

        public synchronized void c() {
            this.j = true;
            this.k++;
        }

        public void a(HttpURLConnection httpURLConnection) {
            this.l = httpURLConnection;
        }

        public void d() {
            if (this.h != null) {
                this.h.join();
            } else {
                XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", "Warning: mThread in DownloadThread.waitFinish is null");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [770=6, 772=6, 773=6, 774=6, 778=6, 780=6, 781=6, 782=6, 785=6, 787=6, 788=6, 789=6, 765=6, 766=6, 767=6] */
        /* JADX WARN: Removed duplicated region for block: B:171:0x035f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:183:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:187:0x0369 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:191:0x0364 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:197:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:201:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0143 A[Catch: all -> 0x04fb, TRY_LEAVE, TryCatch #13 {all -> 0x04fb, blocks: (B:39:0x012d, B:41:0x0143), top: B:185:0x012d }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            BufferedInputStream bufferedInputStream;
            HttpURLConnection httpURLConnection;
            RandomAccessFile randomAccessFile;
            HttpURLConnection httpURLConnection2;
            IXAdLogger adLogger;
            Object[] objArr;
            int i;
            int read;
            RandomAccessFile randomAccessFile2 = null;
            r2 = null;
            randomAccessFile2 = null;
            randomAccessFile2 = null;
            r2 = null;
            randomAccessFile2 = null;
            r2 = null;
            randomAccessFile2 = null;
            BufferedInputStream bufferedInputStream2 = null;
            int i2 = this.k;
            BufferedInputStream bufferedInputStream3 = null;
            RandomAccessFile randomAccessFile3 = null;
            try {
                if (this.d + this.f >= this.e) {
                    this.g = true;
                    randomAccessFile = null;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                } else {
                    if (this.l == null) {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.b.openConnection();
                        try {
                            if (a.this.f.booleanValue()) {
                                httpURLConnection3.setRequestProperty(Headers.RANGE, "bytes=" + ((this.d + this.f) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.e));
                            } else {
                                this.f = 0;
                            }
                            httpURLConnection3.connect();
                            int responseCode = httpURLConnection3.getResponseCode();
                            if (i2 != this.k) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                                if (0 != 0) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (Exception e) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (Exception e2) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e2.getMessage());
                                    }
                                }
                                if (httpURLConnection3 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection3.disconnect();
                                    return;
                                } catch (Exception e3) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"DownloadThread", e3.getMessage()};
                                }
                            } else if (responseCode / 100 != 2) {
                                a.this.b();
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                                if (0 != 0) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (Exception e4) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e4.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (Exception e5) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e5.getMessage());
                                    }
                                }
                                if (httpURLConnection3 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection3.disconnect();
                                    return;
                                } catch (Exception e6) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"DownloadThread", e6.getMessage()};
                                }
                            } else if (httpURLConnection3.getContentType().equals("text/html")) {
                                a.this.b();
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                                if (0 != 0) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (Exception e7) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e7.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (Exception e8) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e8.getMessage());
                                    }
                                }
                                if (httpURLConnection3 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection3.disconnect();
                                    return;
                                } catch (Exception e9) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"DownloadThread", e9.getMessage()};
                                }
                            } else {
                                httpURLConnection = httpURLConnection3;
                            }
                        } catch (Exception e10) {
                            httpURLConnection2 = httpURLConnection3;
                            e = e10;
                            randomAccessFile = null;
                            try {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                                if (i2 == this.k) {
                                    a.this.b();
                                }
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception e11) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e11.getMessage());
                                    }
                                }
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception e12) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e12.getMessage());
                                    }
                                }
                                if (httpURLConnection2 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Exception e13) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"DownloadThread", e13.getMessage()};
                                }
                            } catch (Throwable th) {
                                th = th;
                                httpURLConnection = httpURLConnection2;
                                bufferedInputStream = bufferedInputStream2;
                                randomAccessFile2 = randomAccessFile;
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception e14) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e14.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e15) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e15.getMessage());
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e16) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e16.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            bufferedInputStream = null;
                            httpURLConnection = httpURLConnection3;
                            th = th2;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile2 != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                        adLogger.w(objArr);
                        return;
                    }
                    HttpURLConnection httpURLConnection4 = this.l;
                    try {
                        this.l = null;
                        httpURLConnection = httpURLConnection4;
                    } catch (Exception e17) {
                        e = e17;
                        httpURLConnection2 = httpURLConnection4;
                        randomAccessFile = null;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                        if (i2 == this.k) {
                        }
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile != null) {
                        }
                        if (bufferedInputStream2 != null) {
                        }
                        if (httpURLConnection2 == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                        httpURLConnection = httpURLConnection4;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile2 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            i = this.d + this.f;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "tmpStartByte = " + i);
                            randomAccessFile = new RandomAccessFile(this.c, "rw");
                        } catch (Exception e18) {
                            e = e18;
                            randomAccessFile = null;
                            bufferedInputStream2 = bufferedInputStream;
                            httpURLConnection2 = httpURLConnection;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        randomAccessFile = null;
                        httpURLConnection2 = httpURLConnection;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                    try {
                        randomAccessFile.seek(i);
                        byte[] bArr = new byte[BdStatsConstant.MAX_WRITE_LOG_SIZE];
                        while (true) {
                            if (a.this.i != IOAdDownloader.DownloadStatus.DOWNLOADING || (read = bufferedInputStream.read(bArr, 0, BdStatsConstant.MAX_WRITE_LOG_SIZE)) == -1 || i >= this.e || i2 != this.k) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                            this.f += read;
                            i += read;
                            a.this.a(read);
                            synchronized (this) {
                                if (this.j) {
                                }
                            }
                            break;
                        }
                        if (i >= this.e) {
                            this.g = true;
                        }
                    } catch (Exception e20) {
                        e = e20;
                        bufferedInputStream2 = bufferedInputStream;
                        httpURLConnection2 = httpURLConnection;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                        if (i2 == this.k) {
                        }
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile != null) {
                        }
                        if (bufferedInputStream2 != null) {
                        }
                        if (httpURLConnection2 == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        randomAccessFile2 = randomAccessFile;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile2 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.a + "] ver(" + i2 + ") executed end; isFinished=" + this.g);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e21) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e21.getMessage());
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e22) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e22.getMessage());
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e23) {
                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                    objArr = new Object[]{"DownloadThread", e23.getMessage()};
                }
            } catch (Exception e24) {
                e = e24;
                randomAccessFile = null;
                httpURLConnection2 = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = null;
                httpURLConnection = null;
            }
        }
    }

    private HttpURLConnection b(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        Exception e;
        HttpURLConnection httpURLConnection3 = httpURLConnection;
        while (true) {
            try {
                int responseCode = httpURLConnection3.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection3;
                }
                this.b = new URL(httpURLConnection3.getHeaderField(Headers.LOCATION));
                httpURLConnection2 = (HttpURLConnection) this.b.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty(Headers.RANGE, "bytes=0-");
                    httpURLConnection3 = httpURLConnection2;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return httpURLConnection2;
                }
            } catch (Exception e3) {
                httpURLConnection2 = httpURLConnection3;
                e = e3;
            }
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void removeObservers() {
        deleteObservers();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getTargetURL() {
        if (this.c == null) {
            return null;
        }
        return this.c.toString();
    }
}
