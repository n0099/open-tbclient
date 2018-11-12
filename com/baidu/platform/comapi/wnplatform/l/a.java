package com.baidu.platform.comapi.wnplatform.l;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.wnplatform.o.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {
    private static String b;
    private File c;
    private BufferedReader d;
    private int n;
    private static final String a = a.class.getSimpleName();
    private static final Long j = -1L;
    private boolean e = false;
    private int f = 0;
    private C0108a g = null;
    private com.baidu.platform.comapi.wnplatform.b.b h = null;
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
        b = c.a() + "/WNavi/track/track.txt";
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        com.baidu.platform.comapi.walknavi.b.a().y().c(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0108a extends Thread {
        final /* synthetic */ a a;
        private volatile boolean b;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.platform.comapi.wnplatform.d.a.a c = this.a.c();
            while (this.b && c != null) {
                try {
                    if (this.a.k) {
                        com.baidu.platform.comapi.wnplatform.c.a.a(a.a, "[文件时间戳]读取轨迹记录点成功，延时" + this.a.m + "ms执行");
                        sleep(800L);
                    } else {
                        com.baidu.platform.comapi.wnplatform.c.a.a(a.a, "[用户设定]读取轨迹记录点成功，延时" + this.a.n + "ms执行");
                        sleep(800L);
                    }
                } catch (InterruptedException e) {
                    com.baidu.platform.comapi.wnplatform.c.a.a(a.a, "TrackThread sleep InterruptedException IN");
                }
                Message obtainMessage = this.a.o.obtainMessage(1);
                obtainMessage.obj = c;
                this.a.o.sendMessage(obtainMessage);
                c = this.a.c();
                if (c == null) {
                    com.baidu.platform.comapi.wnplatform.c.a.a(a.a, "轨迹点为空，轨迹导航停止");
                    this.a.d = null;
                    a.f(this.a);
                    c = this.a.c();
                }
            }
        }

        public void a() {
            this.b = false;
            interrupt();
        }
    }

    public void a() {
        if (this.e) {
            if (this.g != null && this.g.isAlive()) {
                com.baidu.platform.comapi.wnplatform.c.a.a(a, "用户中断轨迹复现");
                this.g.a();
                this.l = 0L;
                this.g = null;
            }
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.baidu.platform.comapi.wnplatform.d.a.a c() {
        com.baidu.platform.comapi.wnplatform.d.a.a aVar;
        File[] listFiles;
        try {
            if (this.d == null && this.c != null && this.c.exists() && (listFiles = this.c.listFiles()) != null && listFiles.length > 0) {
                if (this.f < listFiles.length) {
                    File file = listFiles[this.f];
                    if (file.isFile()) {
                        String name = file.getName();
                        com.baidu.platform.comapi.wnplatform.c.a.a(a, "GPS Data fileName = " + name);
                        if (!TextUtils.isEmpty(name) && name.endsWith(".txt")) {
                            this.d = new BufferedReader(new FileReader(file));
                        }
                    }
                } else {
                    this.f = 0;
                }
            }
            String readLine = this.d.readLine();
            com.baidu.platform.comapi.wnplatform.c.a.a(a, "line = " + readLine);
            aVar = a(readLine, true);
        } catch (Exception e) {
            aVar = null;
        }
        return aVar;
    }

    private com.baidu.platform.comapi.wnplatform.d.a.a a(String str, boolean z) {
        com.baidu.platform.comapi.wnplatform.d.a.a aVar = new com.baidu.platform.comapi.wnplatform.d.a.a();
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
                        com.baidu.platform.comapi.wnplatform.c.a.a(a, "[文件时间戳] stampTime：" + parseLong + "mRecordInternalTime:" + this.m);
                    }
                }
            } else if (2 == parseInt || parseInt == 0) {
                if (split.length == 2) {
                    this.m = j;
                } else if (split.length == 3) {
                    this.m = Long.valueOf(Long.parseLong(split[2]));
                }
            }
            aVar.e = f3;
            GeoPoint a2 = com.baidu.platform.comapi.wnplatform.o.b.a(d, d2);
            aVar.b = a2.getLongitudeE6() / 100000.0d;
            aVar.a = a2.getLatitudeE6() / 100000.0d;
            aVar.c = f;
            aVar.d = f2;
            com.baidu.platform.comapi.wnplatform.c.a.a(a, aVar.toString());
            return aVar;
        }
        return null;
    }

    public void a(com.baidu.platform.comapi.wnplatform.b.b bVar) {
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
