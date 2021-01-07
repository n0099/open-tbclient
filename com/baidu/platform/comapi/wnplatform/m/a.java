package com.baidu.platform.comapi.wnplatform.m;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.p.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes3.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: b  reason: collision with root package name */
    private static String f4657b;
    private File c;
    private BufferedReader d;
    private int n;

    /* renamed from: a  reason: collision with root package name */
    private static final String f4656a = a.class.getSimpleName();
    private static final Long j = -1L;
    private boolean e = false;
    private int f = 0;
    private C0305a g = null;
    private com.baidu.platform.comapi.wnplatform.c.b h = null;
    private Object i = new Object();
    private boolean k = true;
    private Long l = 0L;
    private Long m = 600L;
    private Handler o = new b(this);

    static /* synthetic */ int f(a aVar) {
        int i = aVar.f;
        aVar.f = i + 1;
        return i;
    }

    public a() {
        f4657b = c.a() + "/WNavi/track/track.txt";
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0305a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f4658a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f4659b;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WLocData c = this.f4658a.c();
            while (this.f4659b && c != null) {
                try {
                    if (this.f4658a.k) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(a.f4656a, "[文件时间戳]读取轨迹记录点成功，延时" + this.f4658a.m + "ms执行");
                        sleep(800L);
                    } else {
                        com.baidu.platform.comapi.wnplatform.d.a.a(a.f4656a, "[用户设定]读取轨迹记录点成功，延时" + this.f4658a.n + "ms执行");
                        sleep(800L);
                    }
                } catch (InterruptedException e) {
                    com.baidu.platform.comapi.wnplatform.d.a.a(a.f4656a, "TrackThread sleep InterruptedException IN");
                }
                Message obtainMessage = this.f4658a.o.obtainMessage(1);
                obtainMessage.obj = c;
                this.f4658a.o.sendMessage(obtainMessage);
                c = this.f4658a.c();
                if (c == null) {
                    com.baidu.platform.comapi.wnplatform.d.a.a(a.f4656a, "轨迹点为空，轨迹导航停止");
                    this.f4658a.d = null;
                    a.f(this.f4658a);
                    c = this.f4658a.c();
                }
            }
        }

        public void a() {
            this.f4659b = false;
            interrupt();
        }
    }

    public void a() {
        if (this.e) {
            if (this.g != null && this.g.isAlive()) {
                com.baidu.platform.comapi.wnplatform.d.a.a(f4656a, "用户中断轨迹复现");
                this.g.a();
                this.l = 0L;
                this.g = null;
            }
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized WLocData c() {
        WLocData wLocData;
        File[] listFiles;
        try {
            if (this.d == null && this.c != null && this.c.exists() && (listFiles = this.c.listFiles()) != null && listFiles.length > 0) {
                if (this.f < listFiles.length) {
                    File file = listFiles[this.f];
                    if (file.isFile()) {
                        String name = file.getName();
                        com.baidu.platform.comapi.wnplatform.d.a.a(f4656a, "GPS Data fileName = " + name);
                        if (!TextUtils.isEmpty(name) && name.endsWith(DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION)) {
                            this.d = new BufferedReader(new FileReader(file));
                        }
                    }
                } else {
                    this.f = 0;
                }
            }
            String readLine = this.d.readLine();
            com.baidu.platform.comapi.wnplatform.d.a.a(f4656a, "line = " + readLine);
            wLocData = a(readLine, true);
        } catch (Exception e) {
            wLocData = null;
        }
        return wLocData;
    }

    private WLocData a(String str, boolean z) {
        WLocData wLocData = new WLocData();
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split == null && split.length <= 0) {
                return null;
            }
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 2) {
                if (split.length == 7) {
                    d = Double.parseDouble(split[1]);
                    d2 = Double.parseDouble(split[2]);
                    f = Float.parseFloat(split[3]);
                    f2 = Float.parseFloat(split[4]);
                    f3 = Float.parseFloat(split[5]);
                    this.m = j;
                } else if (split.length == 8) {
                    Integer.parseInt(split[0]);
                    d = Double.parseDouble(split[1]);
                    d2 = Double.parseDouble(split[2]);
                    f = Float.parseFloat(split[3]);
                    f2 = Float.parseFloat(split[4]);
                    f3 = Float.parseFloat(split[5]);
                    this.m = Long.valueOf(Long.parseLong(split[7]));
                } else if (split.length == 9) {
                    Integer.parseInt(split[0]);
                    d = Double.parseDouble(split[1]);
                    d2 = Double.parseDouble(split[2]);
                    f = Float.parseFloat(split[3]);
                    f2 = Float.parseFloat(split[4]);
                    f3 = Float.parseFloat(split[5]);
                    if (z) {
                        long parseLong = Long.parseLong(split[8]);
                        this.m = Long.valueOf(Math.abs(parseLong - this.l.longValue()));
                        this.l = Long.valueOf(parseLong);
                        com.baidu.platform.comapi.wnplatform.d.a.a(f4656a, "[文件时间戳] stampTime：" + parseLong + "mRecordInternalTime:" + this.m);
                    }
                }
            } else if (2 == parseInt || parseInt == 0) {
                if (split.length == 2) {
                    this.m = j;
                } else if (split.length == 3) {
                    this.m = Long.valueOf(Long.parseLong(split[2]));
                }
            }
            wLocData.accuracy = f3;
            GeoPoint a2 = com.baidu.platform.comapi.wnplatform.p.b.a(d, d2);
            wLocData.longitude = a2.getLongitudeE6() / 100000.0d;
            wLocData.latitude = a2.getLatitudeE6() / 100000.0d;
            wLocData.speed = f;
            wLocData.direction = f2;
            com.baidu.platform.comapi.wnplatform.d.a.a(f4656a, wLocData.toString());
            return wLocData;
        }
        return null;
    }

    public void a(com.baidu.platform.comapi.wnplatform.c.b bVar) {
        this.h = bVar;
    }

    private void d() {
        synchronized (this.i) {
            this.c = null;
            this.d = null;
            this.f = 0;
        }
    }
}
