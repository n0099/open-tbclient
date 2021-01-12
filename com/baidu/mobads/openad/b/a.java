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
/* loaded from: classes14.dex */
public class a extends Observable implements IOAdDownloader, Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3394a;

    /* renamed from: b  reason: collision with root package name */
    protected URL f3395b;
    protected URL c;
    protected String d;
    protected int e;
    protected String g;
    protected int h;
    protected IOAdDownloader.DownloadStatus i;
    protected volatile int j;
    protected int k;
    protected ArrayList<RunnableC0261a> l;
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
        this.f3394a = context;
        this.f3395b = url;
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
        return this.f3395b.toString();
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

    /* JADX WARN: Removed duplicated region for block: B:105:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025f A[EDGE_INSN: B:143:0x025f->B:72:0x025f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0286 A[EDGE_INSN: B:146:0x0286->B:79:0x0286 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(HttpURLConnection httpURLConnection) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        Exception exc;
        ArrayList arrayList;
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
                    this.m = new g(this.f3394a);
                    List<h> b2 = this.m.b(url, str);
                    if (b2 != null && b2.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        try {
                            HashSet hashSet = new HashSet();
                            for (h hVar : b2) {
                                if (!hashSet.contains(Integer.valueOf(hVar.c()))) {
                                    hashSet.add(Integer.valueOf(hVar.c()));
                                    arrayList3.add(hVar);
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "resume from db: start=" + hVar.d() + ";end =" + hVar.e() + ";complete=" + hVar.a());
                                }
                            }
                            arrayList2 = arrayList3;
                        } catch (Exception e) {
                            exc = e;
                            arrayList = arrayList3;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", exc);
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
                                ArrayList arrayList4 = new ArrayList();
                                int i5 = -1;
                                int i6 = 0;
                                if (this.e <= 1) {
                                }
                                while (r3.hasNext()) {
                                }
                                int i7 = 0;
                                if (this.f.booleanValue()) {
                                }
                                this.j = i7;
                                this.k = (int) getProgress();
                                a(IOAdDownloader.DownloadStatus.DOWNLOADING);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "Downloader starts unfinished threads and waits threads end");
                                i = 0;
                                while (true) {
                                    i2 = i;
                                    if (i2 < this.l.size()) {
                                    }
                                    i = i2 + 1;
                                }
                                i3 = 0;
                                while (true) {
                                    i4 = i3;
                                    if (i4 < this.l.size()) {
                                    }
                                    i3 = i4 + 1;
                                }
                                if (this.i != IOAdDownloader.DownloadStatus.DOWNLOADING) {
                                }
                                if (this.i == IOAdDownloader.DownloadStatus.COMPLETED) {
                                }
                            } catch (Exception e2) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", " 建立文件失败:");
                                a(IOAdDownloader.DownloadStatus.ERROR);
                                return;
                            }
                        }
                    }
                } catch (Exception e3) {
                    exc = e3;
                    arrayList = null;
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
                ArrayList arrayList42 = new ArrayList();
                int i52 = -1;
                int i62 = 0;
                if (this.e <= 1) {
                    int round = Math.round((this.h / this.e) / 102400.0f) * BdStatsConstant.MAX_WRITE_LOG_SIZE;
                    while (i52 < this.h) {
                        int i8 = i52 + 1;
                        if (i52 + round < this.h) {
                            i52 += round;
                        } else {
                            i52 = this.h;
                        }
                        i62++;
                        arrayList42.add(new h(i62, url, str, i8, i52, 0));
                    }
                    arrayList2 = arrayList42;
                } else {
                    arrayList42.add(new h(1, url, str, 0, this.h, 0));
                    arrayList2 = arrayList42;
                }
            }
            for (h hVar2 : arrayList2) {
                RunnableC0261a runnableC0261a = new RunnableC0261a(hVar2.c(), this.c, hVar2.f(), hVar2.d(), hVar2.e(), hVar2.a());
                if (hVar2.d() == 0 && hVar2.a() == 0) {
                    runnableC0261a.a(httpURLConnection);
                }
                this.l.add(runnableC0261a);
            }
        }
        int i72 = 0;
        if (this.f.booleanValue()) {
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.l.size()) {
                    break;
                }
                i72 += this.l.get(i10).f;
                i9 = i10 + 1;
            }
        }
        this.j = i72;
        this.k = (int) getProgress();
        a(IOAdDownloader.DownloadStatus.DOWNLOADING);
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "Downloader starts unfinished threads and waits threads end");
        i = 0;
        while (true) {
            i2 = i;
            if (i2 < this.l.size()) {
                break;
            }
            if (!this.l.get(i2).a()) {
                this.l.get(i2).b();
            }
            i = i2 + 1;
        }
        i3 = 0;
        while (true) {
            i4 = i3;
            if (i4 < this.l.size()) {
                break;
            }
            if (!this.l.get(i4).a()) {
                this.l.get(i4).d();
            }
            i3 = i4 + 1;
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
                        this.m = new g(this.f3394a);
                    }
                    ArrayList arrayList5 = new ArrayList();
                    Iterator<RunnableC0261a> it = this.l.iterator();
                    while (it.hasNext()) {
                        RunnableC0261a next = it.next();
                        arrayList5.add(new h(next.f3396a, url, str, next.d, next.e, next.f));
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "save to db: start=" + next.d + ";end =" + next.e + ";complete=" + next.f);
                    }
                    if (this.m.a(url, str)) {
                        this.m.b(arrayList5);
                    } else {
                        this.m.a(arrayList5);
                    }
                } catch (Exception e4) {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", e4);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [564=8, 566=8, 567=8, 568=8] */
    @Override // java.lang.Runnable
    public void run() {
        IXAdLogger adLogger;
        Object[] objArr;
        HttpURLConnection httpURLConnection = null;
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
                HttpURLConnection httpURLConnection2 = XAdSDKFoundationFacade.getInstance().getURIUitls().getHttpURLConnection(this.f3395b);
                httpURLConnection2.setRequestProperty(Headers.RANGE, "bytes=0-");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2 = b(httpURLConnection2);
                    responseCode = httpURLConnection2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    a(IOAdDownloader.DownloadStatus.ERROR);
                    if (httpURLConnection2 == null) {
                        return;
                    }
                    try {
                        httpURLConnection2.disconnect();
                        return;
                    } catch (Exception e2) {
                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                        objArr = new Object[]{"Downloader", e2.getMessage()};
                    }
                } else if (httpURLConnection2.getContentType().equals("text/html")) {
                    a(IOAdDownloader.DownloadStatus.ERROR);
                    if (httpURLConnection2 == null) {
                        return;
                    }
                    try {
                        httpURLConnection2.disconnect();
                        return;
                    } catch (Exception e3) {
                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                        objArr = new Object[]{"Downloader", e3.getMessage()};
                    }
                } else {
                    int contentLength = httpURLConnection2.getContentLength();
                    if (contentLength < 1) {
                        a(IOAdDownloader.DownloadStatus.ERROR);
                        if (httpURLConnection2 == null) {
                            return;
                        }
                        try {
                            httpURLConnection2.disconnect();
                            return;
                        } catch (Exception e4) {
                            adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                            objArr = new Object[]{"Downloader", e4.getMessage()};
                        }
                    } else {
                        if (contentLength < 5120000) {
                            this.e = 1;
                        }
                        this.c = httpURLConnection2.getURL();
                        if ("mounted".equals(Environment.getExternalStorageState())) {
                            String a2 = l.a(this.f3394a);
                            String str = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(this.c.toString()) + ".apk";
                            this.d = a2;
                            this.g = str;
                            if (new File(a2 + str).exists()) {
                                a(IOAdDownloader.DownloadStatus.COMPLETED);
                                if (httpURLConnection2 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Exception e5) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"Downloader", e5.getMessage()};
                                }
                            } else {
                                if (httpURLConnection2.getHeaderField(Headers.CONTENT_RANGE) == null && (httpURLConnection2.getHeaderField("Accept-Ranges") == null || httpURLConnection2.getHeaderField("Accept-Ranges").equalsIgnoreCase("none"))) {
                                    this.f = false;
                                    this.e = 1;
                                }
                                if (this.h == -1) {
                                    this.h = contentLength;
                                }
                                a(httpURLConnection2);
                                if (httpURLConnection2 == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Exception e6) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"Downloader", e6.getMessage()};
                                }
                            }
                        } else {
                            a(IOAdDownloader.DownloadStatus.ERROR);
                            if (httpURLConnection2 == null) {
                                return;
                            }
                            try {
                                httpURLConnection2.disconnect();
                                return;
                            } catch (Exception e7) {
                                adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                objArr = new Object[]{"Downloader", e7.getMessage()};
                            }
                        }
                    }
                }
                adLogger.w(objArr);
            } catch (Throwable th) {
                if (0 != 0) {
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
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                objArr = new Object[]{"Downloader", e10.getMessage()};
            }
        }
    }

    protected void a(ArrayList<RunnableC0261a> arrayList) {
        XAdSDKFoundationFacade.getInstance().getIoUtils().renameFile(this.d + this.g + ".tmp", this.d + this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.mobads.openad.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class RunnableC0261a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f3396a;

        /* renamed from: b  reason: collision with root package name */
        protected URL f3397b;
        protected String c;
        protected int d;
        protected int e;
        protected int f;
        protected Thread h;
        private HttpURLConnection l;
        private volatile boolean j = false;
        private volatile int k = 0;
        protected boolean g = false;

        public RunnableC0261a(int i, URL url, String str, int i2, int i3, int i4) {
            this.f3396a = i;
            this.f3397b = url;
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

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [770=6, 772=6, 773=6, 774=6, 778=6, 780=6, 781=6, 782=6, 785=6, 787=6, 788=6, 789=6, 758=4, 765=6, 766=6, 767=6] */
        /* JADX WARN: Removed duplicated region for block: B:172:0x0363 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:176:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:178:0x036d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0368 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:190:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0143 A[Catch: all -> 0x0323, TRY_LEAVE, TryCatch #2 {all -> 0x0323, blocks: (B:82:0x02ce, B:83:0x02d6, B:85:0x02de, B:87:0x02e9, B:89:0x02ed, B:104:0x030b, B:105:0x0319, B:112:0x0322, B:91:0x02f1, B:93:0x02f5, B:39:0x012d, B:41:0x0143), top: B:169:0x0008 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th;
            BufferedInputStream bufferedInputStream;
            HttpURLConnection httpURLConnection;
            Exception e;
            RandomAccessFile randomAccessFile;
            IXAdLogger adLogger;
            Object[] objArr;
            int read;
            int i = this.k;
            BufferedInputStream bufferedInputStream2 = null;
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    if (this.d + this.f >= this.e) {
                        this.g = true;
                        randomAccessFile = null;
                        bufferedInputStream = null;
                        httpURLConnection = null;
                    } else {
                        if (this.l == null) {
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.f3397b.openConnection();
                            try {
                                if (a.this.f.booleanValue()) {
                                    httpURLConnection2.setRequestProperty(Headers.RANGE, "bytes=" + ((this.d + this.f) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.e));
                                } else {
                                    this.f = 0;
                                }
                                httpURLConnection2.connect();
                                int responseCode = httpURLConnection2.getResponseCode();
                                if (i != this.k) {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                    if (0 != 0) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception e2) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e2.getMessage());
                                        }
                                    }
                                    if (0 != 0) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e3) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e3.getMessage());
                                        }
                                    }
                                    if (httpURLConnection2 == null) {
                                        return;
                                    }
                                    try {
                                        httpURLConnection2.disconnect();
                                        return;
                                    } catch (Exception e4) {
                                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                        objArr = new Object[]{"DownloadThread", e4.getMessage()};
                                    }
                                } else if (responseCode / 100 != 2) {
                                    a.this.b();
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                    if (0 != 0) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception e5) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e5.getMessage());
                                        }
                                    }
                                    if (0 != 0) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e6) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e6.getMessage());
                                        }
                                    }
                                    if (httpURLConnection2 == null) {
                                        return;
                                    }
                                    try {
                                        httpURLConnection2.disconnect();
                                        return;
                                    } catch (Exception e7) {
                                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                        objArr = new Object[]{"DownloadThread", e7.getMessage()};
                                    }
                                } else if (httpURLConnection2.getContentType().equals("text/html")) {
                                    a.this.b();
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                    if (0 != 0) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception e8) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e8.getMessage());
                                        }
                                    }
                                    if (0 != 0) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e9) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e9.getMessage());
                                        }
                                    }
                                    if (httpURLConnection2 == null) {
                                        return;
                                    }
                                    try {
                                        httpURLConnection2.disconnect();
                                        return;
                                    } catch (Exception e10) {
                                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                        objArr = new Object[]{"DownloadThread", e10.getMessage()};
                                    }
                                } else {
                                    httpURLConnection = httpURLConnection2;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                randomAccessFile = null;
                                bufferedInputStream = null;
                                httpURLConnection = httpURLConnection2;
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                                if (i == this.k) {
                                }
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection == null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile2 = null;
                                bufferedInputStream = null;
                                httpURLConnection = httpURLConnection2;
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception e12) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e12.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e13) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e13.getMessage());
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e14) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e14.getMessage());
                                    }
                                }
                                throw th;
                            }
                            adLogger.w(objArr);
                            return;
                        }
                        httpURLConnection = this.l;
                        try {
                            this.l = null;
                        } catch (Exception e15) {
                            e = e15;
                            randomAccessFile = null;
                            bufferedInputStream = null;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                            if (i == this.k) {
                            }
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection == null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = null;
                            bufferedInputStream = null;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile2 != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            int i2 = this.d + this.f;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "tmpStartByte = " + i2);
                            randomAccessFile = new RandomAccessFile(this.c, "rw");
                            try {
                                randomAccessFile.seek(i2);
                                byte[] bArr = new byte[BdStatsConstant.MAX_WRITE_LOG_SIZE];
                                while (true) {
                                    if (a.this.i != IOAdDownloader.DownloadStatus.DOWNLOADING || (read = bufferedInputStream.read(bArr, 0, BdStatsConstant.MAX_WRITE_LOG_SIZE)) == -1 || i2 >= this.e || i != this.k) {
                                        break;
                                    }
                                    randomAccessFile.write(bArr, 0, read);
                                    this.f += read;
                                    i2 += read;
                                    a.this.a(read);
                                    synchronized (this) {
                                        if (this.j) {
                                            break;
                                        }
                                    }
                                }
                                if (i2 >= this.e) {
                                    this.g = true;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                                if (i == this.k) {
                                    a.this.b();
                                }
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception e17) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e17.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e18) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e18.getMessage());
                                    }
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                                try {
                                    httpURLConnection.disconnect();
                                    return;
                                } catch (Exception e19) {
                                    adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                    objArr = new Object[]{"DownloadThread", e19.getMessage()};
                                }
                            }
                        } catch (Exception e20) {
                            e = e20;
                            randomAccessFile = null;
                        } catch (Throwable th4) {
                            th = th4;
                            randomAccessFile2 = null;
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile2 != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    }
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", "Thread[" + this.f3396a + "] ver(" + i + ") executed end; isFinished=" + this.g);
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
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e24) {
                e = e24;
                randomAccessFile = null;
                bufferedInputStream = null;
                httpURLConnection = null;
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile2 = null;
                bufferedInputStream = null;
                httpURLConnection = null;
            }
        }
    }

    private HttpURLConnection b(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3 = httpURLConnection;
        while (true) {
            try {
                int responseCode = httpURLConnection3.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection3;
                }
                this.f3395b = new URL(httpURLConnection3.getHeaderField(Headers.LOCATION));
                httpURLConnection2 = (HttpURLConnection) this.f3395b.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty(Headers.RANGE, "bytes=0-");
                    httpURLConnection3 = httpURLConnection2;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return httpURLConnection2;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection2 = httpURLConnection3;
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
