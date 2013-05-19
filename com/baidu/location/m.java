package com.baidu.location;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.zeus.Headers;
import com.baidu.zeus.NotificationProxy;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private Context b;
    private Location d;
    private GpsStatus f;
    private Handler l;
    private s y;
    private static int h = 0;
    private static String x = null;
    private static String z = "Temp_in.dat";
    private static File A = new File(f.a, z);
    private static StringBuffer B = null;
    private static boolean C = true;
    private static int D = 0;
    private static int E = 0;
    private static long F = 0;
    private static long G = 0;
    private static long H = 0;
    private static int I = 0;
    private static int J = 0;
    private static int K = 0;
    private final long a = 1000;
    private LocationManager c = null;
    private p e = null;
    private o g = null;
    private long i = 0;
    private long j = 0;
    private boolean k = false;
    private boolean m = false;
    private String n = null;
    private boolean o = false;
    private long p = 0;
    private final int q = BdWebErrorView.ERROR_CODE_400;
    private boolean r = true;
    private boolean s = false;
    private List t = new ArrayList();
    private String u = null;
    private String v = null;
    private String w = null;

    public m(Context context, Handler handler) {
        this.l = null;
        this.y = null;
        this.b = context;
        this.l = handler;
        try {
            if (ap.h != null) {
                this.y = new s(ap.h);
            } else {
                this.y = new s("NULL");
            }
        } catch (Exception e) {
            this.y = null;
        }
    }

    public static String a(Location location) {
        if (location == null) {
            return null;
        }
        return String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&g_tp=0", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(h), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    private void a(double d, double d2, float f) {
        int i = 0;
        ap.a("baidu_location_service", "check...gps ...");
        if (d >= 73.146973d && d <= 135.252686d && d2 <= 54.258807d && d2 >= 14.604847d && f <= 18.0f) {
            ap.a("baidu_location_service", "check...gps2 ...");
            int i2 = (int) ((d - ap.o) * 1000.0d);
            int i3 = (int) ((ap.p - d2) * 1000.0d);
            ap.a("baidu_location_service", "check...gps ..." + i2 + i3);
            if (i2 <= 0 || i2 >= 50 || i3 <= 0 || i3 >= 50) {
                ap.m = d;
                ap.n = d2;
                ah.a(String.format("&ll=%.5f|%.5f", Double.valueOf(d), Double.valueOf(d2)) + "&im=" + ap.h, true);
            } else {
                ap.a("baidu_location_service", "check...gps ..." + i2 + i3);
                int i4 = i2 + (i3 * 50);
                int i5 = i4 >> 2;
                int i6 = i4 & 3;
                if (ap.s) {
                    i = (ap.r[i5] >> (i6 * 2)) & 3;
                    ap.a("baidu_location_service", "check gps scacity..." + i);
                }
            }
        }
        if (ap.q != i) {
            ap.q = i;
            try {
                if (ap.q == 3) {
                    this.c.removeUpdates(this.e);
                    this.c.requestLocationUpdates("gps", 1000L, 1.0f, this.e);
                } else {
                    this.c.removeUpdates(this.e);
                    this.c.requestLocationUpdates("gps", 1000L, 5.0f, this.e);
                }
            } catch (Exception e) {
            }
        }
    }

    public static boolean a(Location location, Location location2, boolean z2) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z2 && ap.q == 3 && speed < 5.0f) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > ap.G ? distanceTo > ap.I : speed > ap.F ? distanceTo > ap.H : distanceTo > 5.0f;
    }

    public void b(Location location) {
        ap.a("baidu_location_service", "set new gpsLocation ...");
        this.d = location;
        if (this.d == null) {
            this.n = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.d.setTime(currentTimeMillis);
            float speed = (float) (this.d.getSpeed() * 3.6d);
            this.n = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.d.getLongitude()), Double.valueOf(this.d.getLatitude()), Float.valueOf(speed), Float.valueOf(this.d.getBearing()), Integer.valueOf(h), Long.valueOf(currentTimeMillis));
            a(this.d.getLongitude(), this.d.getLatitude(), speed);
        }
        if (this.y != null) {
            try {
                this.y.a(this.d);
            } catch (Exception e) {
            }
        }
        this.l.obtainMessage(51).sendToTarget();
    }

    public void b(boolean z2) {
        this.o = z2;
        if ((!z2 || f()) && ap.d != z2) {
            ap.d = z2;
            if (ap.c) {
                this.l.obtainMessage(53).sendToTarget();
            }
        }
    }

    public static boolean b(int i, int i2, int i3) {
        if (i < 0 || i > ap.V) {
            return false;
        }
        if (i2 < 0 || i2 > i + 1) {
            return false;
        }
        return i3 >= 1 && i3 <= i + 1 && i3 <= ap.V;
    }

    public static String g() {
        return x;
    }

    public static String h() {
        ap.a("baidu_location_service", "GPS readline...");
        if (A != null && A.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(A, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!b(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    x();
                    return null;
                }
                ap.a("baidu_location_service", "GPS readline1...");
                if (readInt2 == 0 || readInt2 == readInt3) {
                    return null;
                }
                ap.a("baidu_location_service", "GPS readline2...");
                long j = 0 + ((readInt2 - 1) * NotificationProxy.MAX_URL_LENGTH) + 12;
                randomAccessFile.seek(j);
                int readInt4 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt4];
                randomAccessFile.seek(j + 4);
                for (int i = 0; i < readInt4; i++) {
                    bArr[i] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                int i2 = readInt < ap.V ? readInt2 + 1 : readInt2 == ap.V ? 1 : readInt2 + 1;
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.close();
                return str;
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    public static /* synthetic */ int o() {
        int i = D + 1;
        D = i;
        return i;
    }

    public static boolean x() {
        if (A.exists()) {
            A.delete();
        }
        if (!A.getParentFile().exists()) {
            A.getParentFile().mkdirs();
        }
        try {
            A.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(A, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            y();
            return A.exists();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void y() {
        C = true;
        B = null;
        D = 0;
        E = 0;
        F = 0L;
        G = 0L;
        H = 0L;
        I = 0;
        J = 0;
        K = 0;
    }

    public void a() {
        if (this.m) {
            return;
        }
        try {
            this.c = (LocationManager) this.b.getSystemService(Headers.LOCATION);
            this.e = new p(this);
            this.g = new o(this);
            this.c.requestLocationUpdates("gps", 1000L, 5.0f, this.e);
            this.c.addGpsStatusListener(this.g);
            this.c.addNmeaListener(this.g);
            this.m = true;
        } catch (Exception e) {
        }
    }

    public void b() {
        if (this.m) {
            if (this.c != null) {
                try {
                    if (this.e != null) {
                        this.c.removeUpdates(this.e);
                    }
                    if (this.g != null) {
                        this.c.removeGpsStatusListener(this.g);
                        this.c.removeNmeaListener(this.g);
                    }
                    if (this.y != null) {
                        this.y.a();
                    }
                } catch (Exception e) {
                }
            }
            this.e = null;
            this.g = null;
            this.c = null;
            this.m = false;
            b(false);
        }
    }

    public String c() {
        if (this.d == null) {
            ap.a("baidu_location_service", "gps man getGpsJson but gpslocation is null");
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + ap.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"}}";
        int accuracy = (int) (this.d.hasAccuracy() ? this.d.getAccuracy() : 10.0f);
        float speed = (float) (this.d.getSpeed() * 3.6d);
        double[] a = Jni.a(this.d.getLongitude(), this.d.getLatitude(), "gps2gcj");
        if (a[0] <= 0.0d && a[1] <= 0.0d) {
            a[0] = this.d.getLongitude();
            a[1] = this.d.getLatitude();
        }
        String format = String.format(str, Double.valueOf(a[0]), Double.valueOf(a[1]), Integer.valueOf(accuracy), Float.valueOf(this.d.getBearing()), Float.valueOf(speed), Integer.valueOf(h));
        ap.a("baidu_location_service", "wgs84: " + this.d.getLongitude() + HanziToPinyin.Token.SEPARATOR + this.d.getLatitude() + " gcj02: " + a[0] + HanziToPinyin.Token.SEPARATOR + a[1]);
        return format;
    }

    public Location d() {
        return this.d;
    }

    public boolean e() {
        return (this.d == null || this.d.getLatitude() == 0.0d || this.d.getLongitude() == 0.0d) ? false : true;
    }

    public boolean f() {
        if (e()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.k || currentTimeMillis - this.j <= 3000) {
                return h >= 3 || currentTimeMillis - this.i < 3000;
            }
            return false;
        }
        return false;
    }
}
