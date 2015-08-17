package com.baidu.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a0, n {
    private static final int f1 = 10000;
    private static final int f4 = 5;
    private static StringBuilder fH = null;
    private static final double fI = 1.0E-5d;
    private static final int fK = 3000;
    private static String fM = null;
    private static final int fU = 1;
    private static final int fZ = 3;
    private static final int gd = 290000;
    private long f2;
    private Location fE;
    private HashMap fJ;
    private Location fN;
    private long fP;
    private Location fQ;
    private Context fR;
    private Location fY;
    private GpsStatus fx;
    private int fz;
    private Location ga;
    private long ge;
    private int gf;
    private long gh;
    private static z f5 = null;
    private static int fT = 0;
    private static String fW = null;
    private static String gg = "Temp_in.dat";
    private static File f6 = new File(I, gg);
    private static final byte[] fy = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private final long fV = 1000;
    private LocationManager fC = null;
    private b f3 = null;
    private c f8 = null;
    private a fF = null;
    private long fO = 0;
    private long fL = 0;
    private boolean fD = false;
    private boolean f0 = false;
    private String f9 = null;
    private boolean f7 = false;
    private long fS = 0;
    private long gc = 0;
    private Handler fA = null;
    private final int gb = 1;
    private final int fB = 2;
    private final int fX = 3;
    private final int fG = 4;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GpsStatus.Listener, GpsStatus.NmeaListener {
        private long a;

        /* renamed from: byte  reason: not valid java name */
        private boolean f117byte;

        /* renamed from: case  reason: not valid java name */
        private List f118case;

        /* renamed from: char  reason: not valid java name */
        private final int f119char;

        /* renamed from: do  reason: not valid java name */
        private String f120do;

        /* renamed from: for  reason: not valid java name */
        private String f121for;

        /* renamed from: if  reason: not valid java name */
        long f122if;

        /* renamed from: new  reason: not valid java name */
        private String f124new;

        /* renamed from: try  reason: not valid java name */
        private boolean f125try;

        private a() {
            this.f122if = 0L;
            this.a = 0L;
            this.f119char = 400;
            this.f125try = true;
            this.f117byte = false;
            this.f118case = new ArrayList();
            this.f121for = null;
            this.f124new = null;
            this.f120do = null;
        }

        public void a(String str) {
            if (System.currentTimeMillis() - this.a > 400 && this.f117byte && this.f118case.size() > 0) {
                try {
                    aw awVar = new aw(this.f118case, this.f121for, this.f124new, this.f120do);
                    if (awVar.c9()) {
                        com.baidu.location.c.aq = z.this.m383if(awVar, z.this.fz);
                        if (com.baidu.location.c.aq > 0) {
                            String unused = z.fW = String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", Double.valueOf(awVar.c7()), Double.valueOf(awVar.da()), Integer.valueOf(com.baidu.location.c.aq));
                        }
                    } else {
                        com.baidu.location.c.aq = 0;
                    }
                } catch (Exception e) {
                    com.baidu.location.c.aq = 0;
                }
                this.f118case.clear();
                this.f120do = null;
                this.f124new = null;
                this.f121for = null;
                this.f117byte = false;
            }
            if (str.startsWith("$GPGGA")) {
                this.f117byte = true;
                this.f121for = str.trim();
            } else if (str.startsWith("$GPGSV")) {
                this.f118case.add(str.trim());
            } else if (str.startsWith("$GPGSA")) {
                this.f120do = str.trim();
            }
            this.a = System.currentTimeMillis();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            Location lastKnownLocation;
            int i2 = 0;
            try {
                if (z.this.fC == null) {
                    return;
                }
                switch (i) {
                    case 2:
                        z.this.m403int((Location) null);
                        z.this.m406new(false);
                        int unused = z.fT = 0;
                        return;
                    case 3:
                    default:
                        return;
                    case 4:
                        if (z.this.f0 || System.currentTimeMillis() - this.f122if >= 10000) {
                            if (z.this.fx == null) {
                                z.this.fx = z.this.fC.getGpsStatus(null);
                            } else {
                                z.this.fC.getGpsStatus(z.this.fx);
                            }
                            StringBuilder unused2 = z.fH = new StringBuilder();
                            z.this.gf = 0;
                            z.this.fz = 0;
                            z.this.fJ = new HashMap();
                            int i3 = 0;
                            int i4 = 0;
                            for (GpsSatellite gpsSatellite : z.this.fx.getSatellites()) {
                                i3++;
                                if (gpsSatellite.usedInFix()) {
                                    i4++;
                                    if (gpsSatellite.getSnr() > 0.0f) {
                                        i2++;
                                    }
                                    if (gpsSatellite.getSnr() >= com.baidu.location.c.Z) {
                                        z.m402int(z.this);
                                    }
                                    z.fH.append(z.this.m391if(gpsSatellite, z.this.fJ));
                                }
                            }
                            int unused3 = z.fT = i2;
                            z.this.m387if(z.this.fJ);
                            if (z.this.f0 || System.currentTimeMillis() - z.this.gc < TbConfig.USE_TIME_INTERVAL) {
                                return;
                            }
                            if ((i4 > 3 || i3 > 15) && (lastKnownLocation = z.this.fC.getLastKnownLocation("gps")) != null) {
                                this.f122if = System.currentTimeMillis();
                                long currentTimeMillis = (System.currentTimeMillis() + g.h().br) - lastKnownLocation.getTime();
                                if (currentTimeMillis >= 3500 || currentTimeMillis <= -200 || !q.m333if(lastKnownLocation, false)) {
                                    return;
                                }
                                z.this.fA.sendMessage(z.this.fA.obtainMessage(3, lastKnownLocation));
                                return;
                            }
                            return;
                        }
                        return;
                }
            } catch (Exception e) {
            }
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (z.this.f0) {
                if (!aa.gn) {
                    com.baidu.location.c.aq = 0;
                } else if (str == null || str.equals("") || str.length() < 9 || str.length() > 150 || !z.this.aZ()) {
                } else {
                    z.this.fA.sendMessage(z.this.fA.obtainMessage(2, str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements LocationListener {
        private b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            z.this.fS = System.currentTimeMillis();
            z.this.m406new(true);
            z.this.m403int(location);
            z.this.fD = false;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            z.this.m403int((Location) null);
            z.this.m406new(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    z.this.m403int((Location) null);
                    z.this.m406new(false);
                    return;
                case 1:
                    z.this.fL = System.currentTimeMillis();
                    z.this.fD = true;
                    z.this.m406new(false);
                    return;
                case 2:
                    z.this.fD = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements LocationListener {

        /* renamed from: if  reason: not valid java name */
        private long f126if;

        private c() {
            this.f126if = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (z.this.f0 || location == null || location.getProvider() != "gps") {
                return;
            }
            z.this.gc = System.currentTimeMillis();
            if (System.currentTimeMillis() - this.f126if < 10000 || !q.m333if(location, false)) {
                return;
            }
            this.f126if = System.currentTimeMillis();
            z.this.fA.sendMessage(z.this.fA.obtainMessage(4, location));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private z() {
    }

    private static String a5() {
        if (fH != null) {
            if (!TextUtils.isEmpty(fH.toString())) {
                fH.insert(0, "&snlf=");
            }
            if (!TextUtils.isEmpty(fM)) {
                fH.append("&pogr=").append(fM);
            }
            return fH.toString();
        }
        return null;
    }

    private boolean aY() {
        return false;
    }

    public static z bc() {
        if (f5 == null) {
            f5 = new z();
        }
        return f5;
    }

    /* renamed from: byte  reason: not valid java name */
    public static String m368byte(Location location) {
        String m369case = m369case(location);
        return m369case != null ? m369case + "&g_tp=0" : m369case;
    }

    /* renamed from: case  reason: not valid java name */
    public static String m369case(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(fT), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    /* renamed from: do  reason: not valid java name */
    private double[] m378do(double d, double d2) {
        return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m381for(Location location) {
        if (location != null) {
            int i = fT;
            if (i == 0) {
                try {
                    i = location.getExtras().getInt("satellites");
                } catch (Exception e) {
                }
            }
            if (i == 0) {
                return;
            }
            this.ga = location;
            if (this.ga == null) {
                this.f9 = null;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                this.ga.setTime(currentTimeMillis);
                float speed = (float) (this.ga.getSpeed() * 3.6d);
                if (!this.ga.hasSpeed()) {
                    speed = -1.0f;
                }
                int i2 = fT;
                if (i2 == 0) {
                    try {
                        i2 = this.ga.getExtras().getInt("satellites");
                        fT = i2;
                    } catch (Exception e2) {
                    }
                }
                this.f9 = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.ga.getLongitude()), Double.valueOf(this.ga.getLatitude()), Float.valueOf(speed), Float.valueOf(this.ga.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                m394if(this.ga.getLongitude(), this.ga.getLatitude(), speed);
            }
            try {
                y.aR().m366do(this.ga);
            } catch (Exception e3) {
            }
            if (aZ()) {
                k.q().m297byte(aX());
                if (fT <= 2 || !q.m333if(this.ga, true)) {
                    return;
                }
                au.cc().cj();
                q.m318do(u.au().at(), au.cc().b7(), this.ga, k.q().p());
            }
        }
    }

    /* renamed from: for  reason: not valid java name */
    private double[] m382for(double d, double d2) {
        double d3 = 0.0d;
        if (d2 != 0.0d) {
            d3 = Math.toDegrees(Math.atan(d / d2));
        } else if (d > 0.0d) {
            d3 = 90.0d;
        } else if (d < 0.0d) {
            d3 = 270.0d;
        }
        return new double[]{Math.sqrt((d * d) + (d2 * d2)), d3};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m383if(aw awVar, int i) {
        if (fT >= com.baidu.location.c.aP) {
            return 1;
        }
        if (fT <= com.baidu.location.c.ax) {
            return 4;
        }
        double c7 = awVar.c7();
        if (c7 > com.baidu.location.c.bg) {
            if (c7 >= com.baidu.location.c.am) {
                return 4;
            }
            double da = awVar.da();
            if (da > com.baidu.location.c.aJ) {
                if (da >= com.baidu.location.c.aY) {
                    return 4;
                }
                if (i < com.baidu.location.c.ab) {
                    if (i <= com.baidu.location.c.a1) {
                        return 4;
                    }
                    if (this.fJ != null) {
                        return m387if(this.fJ);
                    }
                    return 3;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m387if(HashMap hashMap) {
        double[] m400if;
        if (this.gf > 4) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            Iterator it = hashMap.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                List list = (List) ((Map.Entry) it.next()).getValue();
                if (list == null || (m400if = m400if(list)) == null) {
                    i = i2;
                } else {
                    arrayList.add(m400if);
                    i = i2 + 1;
                    arrayList2.add(Integer.valueOf(i2));
                }
            }
            if (!arrayList.isEmpty()) {
                double[] dArr = new double[2];
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    double[] dArr2 = (double[]) arrayList.get(i3);
                    int intValue = ((Integer) arrayList2.get(i3)).intValue();
                    dArr2[0] = dArr2[0] * intValue;
                    dArr2[1] = dArr2[1] * intValue;
                    dArr[0] = dArr[0] + dArr2[0];
                    dArr[1] = dArr[1] + dArr2[1];
                }
                dArr[0] = dArr[0] / size;
                dArr[1] = dArr[1] / size;
                double[] m382for = m382for(dArr[0], dArr[1]);
                fM = String.format(Locale.CHINA, "%d,%d,%d,%d", Long.valueOf(Math.round(dArr[0] * 100.0d)), Long.valueOf(Math.round(dArr[1] * 100.0d)), Long.valueOf(Math.round(m382for[0] * 100.0d)), Long.valueOf(Math.round(m382for[1] * 100.0d)));
                if (m382for[0] <= com.baidu.location.c.a7) {
                    return 1;
                }
                if (m382for[0] >= com.baidu.location.c.ai) {
                    return 4;
                }
            }
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public String m391if(GpsSatellite gpsSatellite, HashMap hashMap) {
        int floor = (int) Math.floor(gpsSatellite.getAzimuth() / 6.0f);
        float elevation = gpsSatellite.getElevation();
        int floor2 = (int) Math.floor(elevation / 1.5d);
        float snr = gpsSatellite.getSnr();
        int round = Math.round(snr / 5.0f);
        int prn = gpsSatellite.getPrn();
        if (prn >= 65) {
            prn -= 32;
        }
        if (snr >= 10.0f && elevation >= 1.0f) {
            List list = (List) hashMap.get(Integer.valueOf(round));
            if (list == null) {
                list = new ArrayList();
            }
            list.add(gpsSatellite);
            hashMap.put(Integer.valueOf(round), list);
            this.gf++;
        }
        if (floor >= 64) {
            floor = 63;
        }
        return String.format(Locale.CHINA, "%c%c%c%d", Byte.valueOf(fy[(prn >= 65 ? 64 : prn) - 1]), Byte.valueOf(fy[floor]), Byte.valueOf(fy[floor2 < 64 ? floor2 : 63]), Integer.valueOf(round));
    }

    /* renamed from: if  reason: not valid java name */
    private void m394if(double d, double d2, float f) {
        int i = 0;
        if (aa.gj) {
            if (d >= 73.146973d && d <= 135.252686d && d2 <= 54.258807d && d2 >= 14.604847d && f <= 18.0f) {
                int i2 = (int) ((d - com.baidu.location.c.Y) * 1000.0d);
                int i3 = (int) ((com.baidu.location.c.au - d2) * 1000.0d);
                if (i2 <= 0 || i2 >= 50 || i3 <= 0 || i3 >= 50) {
                    com.baidu.location.c.aO = d;
                    com.baidu.location.c.a3 = d2;
                    aa.bf().o(String.format(Locale.CHINA, "&ll=%.5f|%.5f", Double.valueOf(d), Double.valueOf(d2)) + "&im=" + a2.cC().cA());
                } else {
                    int i4 = i2 + (i3 * 50);
                    int i5 = i4 >> 2;
                    int i6 = i4 & 3;
                    if (com.baidu.location.c.bb) {
                        i = (com.baidu.location.c.ar[i5] >> (i6 * 2)) & 3;
                    }
                }
            }
            if (com.baidu.location.c.aN != i) {
                com.baidu.location.c.aN = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m398if(String str, Location location) {
        q.m318do(u.au().at(), au.cc().b7(), location, str + k.q().p());
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m399if(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z && com.baidu.location.c.aN == 3 && speed < 5.0f) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > com.baidu.location.c.aG ? distanceTo > com.baidu.location.c.aW : speed > com.baidu.location.c.aH ? distanceTo > com.baidu.location.c.bd : distanceTo > 5.0f;
    }

    /* renamed from: if  reason: not valid java name */
    private double[] m400if(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GpsSatellite gpsSatellite = (GpsSatellite) it.next();
            if (gpsSatellite != null) {
                double[] m378do = m378do(90.0f - gpsSatellite.getElevation(), gpsSatellite.getAzimuth());
                dArr[0] = dArr[0] + m378do[0];
                dArr[1] = dArr[1] + m378do[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / size;
        dArr[1] = dArr[1] / size;
        return dArr;
    }

    /* renamed from: int  reason: not valid java name */
    static /* synthetic */ int m402int(z zVar) {
        int i = zVar.fz;
        zVar.fz = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m403int(Location location) {
        this.fA.sendMessage(this.fA.obtainMessage(1, location));
    }

    /* renamed from: new  reason: not valid java name */
    public static String m404new(Location location) {
        String m369case = m369case(location);
        if (m369case != null) {
            m369case = m369case + fW;
        }
        String a5 = a5();
        return !TextUtils.isEmpty(a5) ? m369case + a5 : m369case;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m406new(boolean z) {
        this.f7 = z;
        if (!z || !aZ()) {
        }
    }

    /* renamed from: try  reason: not valid java name */
    private void m408try(Location location) {
        long currentTimeMillis = System.currentTimeMillis();
        this.fY = location;
        this.ge = currentTimeMillis;
        if (this.f2 == 0 || currentTimeMillis - this.f2 >= 290000 || this.fQ == null) {
            if (this.fE == null) {
                this.fE = location;
                this.fN = this.fE;
                this.f2 = currentTimeMillis;
                this.gh = this.f2;
                this.fQ = null;
            } else if (currentTimeMillis - this.f2 >= 10000) {
                this.fQ = location;
                String m323if = q.m323if(u.au().at(), au.cc().b7(), location, k.q().p(), String.format("&dt=%.6f|%.6f|%s|%s|%s", Double.valueOf(this.fQ.getLongitude() - this.fE.getLongitude()), Double.valueOf(this.fQ.getLatitude() - this.fE.getLatitude()), Float.valueOf(this.fQ.getSpeed()), Float.valueOf(this.fQ.getBearing()), Long.valueOf(currentTimeMillis - this.f2)));
                if (!TextUtils.isEmpty(m323if)) {
                    q.y().m336long(Jni.j(m323if));
                }
                this.fE = null;
            }
        }
    }

    public Location a0() {
        return this.ga;
    }

    public boolean a1() {
        return (this.ga == null || this.ga.getLatitude() == 0.0d || this.ga.getLongitude() == 0.0d) ? false : true;
    }

    public synchronized void a2() {
        if (ad.gO) {
            this.fR = f.getServiceContext();
            try {
                this.fC = (LocationManager) this.fR.getSystemService("location");
                this.fF = new a();
                this.fC.addGpsStatusListener(this.fF);
                this.f8 = new c();
                this.fC.requestLocationUpdates("passive", 1000L, 0.0f, this.f8);
            } catch (Exception e) {
            }
            this.fA = new Handler() { // from class: com.baidu.location.z.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (ad.gO) {
                        switch (message.what) {
                            case 1:
                                z.this.m381for((Location) message.obj);
                                return;
                            case 2:
                                if (z.this.fF != null) {
                                    z.this.fF.a((String) message.obj);
                                    return;
                                }
                                return;
                            case 3:
                                z.this.m398if("&og=1", (Location) message.obj);
                                return;
                            case 4:
                                z.this.m398if("&og=2", (Location) message.obj);
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
        }
    }

    public String a3() {
        return this.f9;
    }

    public synchronized void a4() {
        bb();
        if (this.fC != null) {
            try {
                if (this.fF != null) {
                    this.fC.removeGpsStatusListener(this.fF);
                }
                this.fC.removeUpdates(this.f8);
            } catch (Exception e) {
            }
            this.fF = null;
            this.fC = null;
        }
    }

    public String a6() {
        if (!aZ() || this.ga == null) {
            return null;
        }
        return m369case(this.ga);
    }

    public void a8() {
        try {
            if (this.fY == null && this.fN == null) {
                return;
            }
            String m323if = q.m323if(u.au().at(), au.cc().b7(), this.fY, k.q().p(), String.format(Locale.CHINA, "&dt=%.6f|%.6f|%s|%s|%s", Double.valueOf(this.fY.getLongitude() - this.fN.getLongitude()), Double.valueOf(this.fY.getLatitude() - this.fN.getLatitude()), Float.valueOf(this.fY.getSpeed()), Float.valueOf(this.fY.getBearing()), Long.valueOf(this.ge - this.gh)));
            if (TextUtils.isEmpty(m323if)) {
                return;
            }
            q.y().m336long(Jni.j(m323if));
        } catch (Exception e) {
        }
    }

    public boolean a9() {
        if (this.fC != null) {
            return this.fC.isProviderEnabled("gps");
        }
        return false;
    }

    public String aX() {
        if (this.ga != null) {
            String str = "{\"result\":{\"time\":\"" + com.baidu.location.c.m278try() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.ga.hasAccuracy() ? this.ga.getAccuracy() : 10.0f);
            float speed = (float) (this.ga.getSpeed() * 3.6d);
            if (!this.ga.hasSpeed()) {
                speed = -1.0f;
            }
            double[] m20if = Jni.m20if(this.ga.getLongitude(), this.ga.getLatitude(), "gps2gcj");
            if (m20if[0] <= 0.0d && m20if[1] <= 0.0d) {
                m20if[0] = this.ga.getLongitude();
                m20if[1] = this.ga.getLatitude();
            }
            String format = String.format(Locale.CHINA, str, Double.valueOf(m20if[0]), Double.valueOf(m20if[1]), Integer.valueOf(accuracy), Float.valueOf(this.ga.getBearing()), Float.valueOf(speed), Integer.valueOf(fT));
            return this.ga.hasAltitude() ? format + String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.ga.getAltitude())) : format + "}}";
        }
        return null;
    }

    public boolean aZ() {
        if (a1() && System.currentTimeMillis() - this.fS <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.fD || currentTimeMillis - this.fL >= 3000) {
                return this.f7;
            }
            return true;
        }
        return false;
    }

    public void ba() {
        if (this.f0) {
            return;
        }
        try {
            this.f3 = new b();
            this.fC.requestLocationUpdates("gps", 1000L, 0.0f, this.f3);
            this.fC.addNmeaListener(this.fF);
            this.f0 = true;
        } catch (Exception e) {
        }
    }

    public void bb() {
        if (this.f0) {
            if (this.fC != null) {
                try {
                    if (this.f3 != null) {
                        this.fC.removeUpdates(this.f3);
                    }
                    if (this.fF != null) {
                        this.fC.removeNmeaListener(this.fF);
                    }
                } catch (Exception e) {
                }
            }
            com.baidu.location.c.aq = 0;
            com.baidu.location.c.aN = 0;
            this.f3 = null;
            this.f0 = false;
            m406new(false);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public void m409int(boolean z) {
        if (z) {
            ba();
        } else {
            bb();
        }
    }
}
