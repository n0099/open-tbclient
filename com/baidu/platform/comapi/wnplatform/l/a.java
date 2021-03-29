package com.baidu.platform.comapi.wnplatform.l;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.o.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10303a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static String f10304b;
    public static final Long j = -1L;

    /* renamed from: c  reason: collision with root package name */
    public File f10305c;

    /* renamed from: d  reason: collision with root package name */
    public BufferedReader f10306d;
    public int n;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10307e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f10308f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C0131a f10309g = null;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.platform.comapi.wnplatform.c.b f10310h = null;
    public Object i = new Object();
    public boolean k = true;
    public Long l = 0L;
    public Long m = 600L;
    public Handler o = new b(this);

    /* renamed from: com.baidu.platform.comapi.wnplatform.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0131a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10311a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f10312b;

        public void a() {
            this.f10312b = false;
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WLocData c2 = this.f10311a.c();
            while (this.f10312b && c2 != null) {
                try {
                    if (this.f10311a.k) {
                        String str = a.f10303a;
                        com.baidu.platform.comapi.wnplatform.d.a.a(str, "[文件时间戳]读取轨迹记录点成功，延时" + this.f10311a.m + "ms执行");
                        Thread.sleep(800L);
                    } else {
                        String str2 = a.f10303a;
                        com.baidu.platform.comapi.wnplatform.d.a.a(str2, "[用户设定]读取轨迹记录点成功，延时" + this.f10311a.n + "ms执行");
                        Thread.sleep(800L);
                    }
                } catch (InterruptedException unused) {
                    com.baidu.platform.comapi.wnplatform.d.a.a(a.f10303a, "TrackThread sleep InterruptedException IN");
                }
                Message obtainMessage = this.f10311a.o.obtainMessage(1);
                obtainMessage.obj = c2;
                this.f10311a.o.sendMessage(obtainMessage);
                c2 = this.f10311a.c();
                if (c2 == null) {
                    com.baidu.platform.comapi.wnplatform.d.a.a(a.f10303a, "轨迹点为空，轨迹导航停止");
                    this.f10311a.f10306d = null;
                    a.f(this.f10311a);
                    c2 = this.f10311a.c();
                }
            }
        }
    }

    public a() {
        f10304b = c.a() + "/WNavi/track/track.txt";
    }

    public static /* synthetic */ int f(a aVar) {
        int i = aVar.f10308f;
        aVar.f10308f = i + 1;
        return i;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(3);
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized WLocData c() {
        String readLine;
        File[] listFiles;
        try {
            if (this.f10306d == null && this.f10305c != null && this.f10305c.exists() && (listFiles = this.f10305c.listFiles()) != null && listFiles.length > 0) {
                if (this.f10308f < listFiles.length) {
                    File file = listFiles[this.f10308f];
                    if (file.isFile()) {
                        String name = file.getName();
                        String str = f10303a;
                        com.baidu.platform.comapi.wnplatform.d.a.a(str, "GPS Data fileName = " + name);
                        if (!TextUtils.isEmpty(name) && name.endsWith(DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION)) {
                            this.f10306d = new BufferedReader(new FileReader(file));
                        }
                    }
                } else {
                    this.f10308f = 0;
                }
            }
            readLine = this.f10306d.readLine();
            String str2 = f10303a;
            com.baidu.platform.comapi.wnplatform.d.a.a(str2, "line = " + readLine);
        } catch (Exception unused) {
            return null;
        }
        return a(readLine, true);
    }

    private void d() {
        synchronized (this.i) {
            this.f10305c = null;
            this.f10306d = null;
            this.f10308f = 0;
        }
    }

    public void a() {
        if (this.f10307e) {
            C0131a c0131a = this.f10309g;
            if (c0131a != null && c0131a.isAlive()) {
                com.baidu.platform.comapi.wnplatform.d.a.a(f10303a, "用户中断轨迹复现");
                this.f10309g.a();
                this.l = 0L;
                this.f10309g = null;
            }
            d();
        }
    }

    private WLocData a(String str, boolean z) {
        double d2;
        float f2;
        float f3;
        float parseFloat;
        float parseFloat2;
        WLocData wLocData = new WLocData();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split != null || split.length > 0) {
            int parseInt = Integer.parseInt(split[0]);
            double d3 = 0.0d;
            float f4 = 0.0f;
            if (parseInt == 2) {
                if (split.length == 7) {
                    d3 = Double.parseDouble(split[1]);
                    d2 = Double.parseDouble(split[2]);
                    float parseFloat3 = Float.parseFloat(split[3]);
                    f3 = Float.parseFloat(split[4]);
                    float parseFloat4 = Float.parseFloat(split[5]);
                    this.m = j;
                    f4 = parseFloat4;
                    f2 = parseFloat3;
                } else {
                    if (split.length == 8) {
                        Integer.parseInt(split[0]);
                        d3 = Double.parseDouble(split[1]);
                        d2 = Double.parseDouble(split[2]);
                        parseFloat = Float.parseFloat(split[3]);
                        f3 = Float.parseFloat(split[4]);
                        parseFloat2 = Float.parseFloat(split[5]);
                        this.m = Long.valueOf(Long.parseLong(split[7]));
                    } else if (split.length == 9) {
                        Integer.parseInt(split[0]);
                        d3 = Double.parseDouble(split[1]);
                        d2 = Double.parseDouble(split[2]);
                        parseFloat = Float.parseFloat(split[3]);
                        f3 = Float.parseFloat(split[4]);
                        parseFloat2 = Float.parseFloat(split[5]);
                        if (z) {
                            long parseLong = Long.parseLong(split[8]);
                            this.m = Long.valueOf(Math.abs(parseLong - this.l.longValue()));
                            this.l = Long.valueOf(parseLong);
                            com.baidu.platform.comapi.wnplatform.d.a.a(f10303a, "[文件时间戳] stampTime：" + parseLong + "mRecordInternalTime:" + this.m);
                        }
                    }
                    f2 = parseFloat;
                    f4 = parseFloat2;
                }
                wLocData.accuracy = f4;
                GeoPoint a2 = com.baidu.platform.comapi.wnplatform.o.b.a(d3, d2);
                wLocData.longitude = a2.getLongitudeE6() / 100000.0d;
                wLocData.latitude = a2.getLatitudeE6() / 100000.0d;
                wLocData.speed = f2;
                wLocData.direction = f3;
                com.baidu.platform.comapi.wnplatform.d.a.a(f10303a, wLocData.toString());
                return wLocData;
            } else if (2 == parseInt || parseInt == 0) {
                if (split.length == 2) {
                    this.m = j;
                } else if (split.length == 3) {
                    this.m = Long.valueOf(Long.parseLong(split[2]));
                }
            }
            d2 = 0.0d;
            f2 = 0.0f;
            f3 = 0.0f;
            wLocData.accuracy = f4;
            GeoPoint a22 = com.baidu.platform.comapi.wnplatform.o.b.a(d3, d2);
            wLocData.longitude = a22.getLongitudeE6() / 100000.0d;
            wLocData.latitude = a22.getLatitudeE6() / 100000.0d;
            wLocData.speed = f2;
            wLocData.direction = f3;
            com.baidu.platform.comapi.wnplatform.d.a.a(f10303a, wLocData.toString());
            return wLocData;
        }
        return null;
    }

    public void a(com.baidu.platform.comapi.wnplatform.c.b bVar) {
        this.f10310h = bVar;
    }
}
