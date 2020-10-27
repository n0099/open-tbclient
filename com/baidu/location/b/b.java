package com.baidu.location.b;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.location.CoordinateType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private ArrayList<a> g;
    private static b f = null;
    public static long c = 0;
    public static int d = -1;
    private boolean h = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1871a = false;
    boolean b = false;
    private BDLocation i = null;
    private BDLocation j = null;
    int e = 0;
    private BDLocation k = null;
    private boolean l = false;
    private boolean m = false;
    private RunnableC0233b n = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f1872a;
        public Messenger b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;
        final /* synthetic */ b e;

        public a(b bVar, Message message) {
            boolean z = false;
            this.e = bVar;
            this.f1872a = null;
            this.b = null;
            this.b = message.replyTo;
            this.f1872a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.c.prodName, this.f1872a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.l.m = com.baidu.location.e.l.m || this.c.enableSimulateGps;
            if (!com.baidu.location.e.l.g.equals("all")) {
                com.baidu.location.e.l.g = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.l.i = com.baidu.location.e.l.i || this.c.isNeedNewVersionRgc;
            com.baidu.location.e.l.h = com.baidu.location.e.l.h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.l.j = com.baidu.location.e.l.j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.l.S = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wfnum", com.baidu.location.e.l.az);
            float f = message.getData().getFloat("wfsm", com.baidu.location.e.l.aA);
            int i2 = message.getData().getInt("gnmcon", com.baidu.location.e.l.aC);
            double d = message.getData().getDouble("gnmcrm", com.baidu.location.e.l.aB);
            int i3 = message.getData().getInt("iupl", 1);
            com.baidu.location.e.l.aF = message.getData().getInt(Config.EXCEPTION_CRASH_TYPE, 10);
            com.baidu.location.e.l.aG = message.getData().getInt("suci", 3);
            com.baidu.location.e.l.aI = message.getData().getDoubleArray("cgs");
            com.baidu.location.e.l.aJ = message.getData().getInt("ums", 1);
            com.baidu.location.e.l.aH = message.getData().getInt("smn", 40);
            if (i3 <= 0) {
                com.baidu.location.e.l.aE = 0;
            } else if (com.baidu.location.e.l.aE == -1) {
                com.baidu.location.e.l.aE = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                com.baidu.location.e.l.aK = 0;
            }
            if (message.getData().getInt("lpcs", com.baidu.location.e.l.aL) == 0) {
                com.baidu.location.e.l.aL = 0;
            }
            if (i2 == 1) {
                com.baidu.location.e.l.aC = 1;
            }
            if (d > com.baidu.location.e.l.aB) {
                com.baidu.location.e.l.aB = d;
            }
            com.baidu.location.e.l.ay = com.baidu.location.e.l.ay || message.getData().getBoolean("ischeckper", false);
            if (i > com.baidu.location.e.l.az) {
                com.baidu.location.e.l.az = i;
            }
            if (f > com.baidu.location.e.l.aA) {
                com.baidu.location.e.l.aA = f;
            }
            int i4 = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i4 < com.baidu.location.e.l.ag) {
                com.baidu.location.e.l.ag = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i5 >= com.baidu.location.e.l.X) {
                com.baidu.location.e.l.X = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i6 >= com.baidu.location.e.l.Z) {
                com.baidu.location.e.l.Z = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i7 >= com.baidu.location.e.l.Y) {
                com.baidu.location.e.l.Y = i7;
            }
            if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
                r.a().a(this.c.mIsNeedDeviceDirect);
                r.a().b();
            }
            bVar.b = (bVar.b || this.c.isNeedAltitude) ? true : z;
        }

        private double a(boolean z, BDLocation bDLocation, BDLocation bDLocation2) {
            double a2;
            double[] dArr;
            if (z) {
                if (!TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                    if (TextUtils.equals(CoordinateType.WGS84, bDLocation.getCoorType())) {
                        dArr = new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                    } else {
                        double[] coorEncrypt = TextUtils.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09, bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02) : TextUtils.equals("bd09ll", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02) : new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                        dArr = Jni.coorEncrypt(coorEncrypt[0], coorEncrypt[1], "gcj2wgs");
                    }
                    bDLocation.setLatitude(dArr[1]);
                    bDLocation.setLongitude(dArr[0]);
                    bDLocation.setTime(com.baidu.location.e.l.a());
                    bDLocation.setCoorType(CoordinateType.WGS84);
                    a2 = com.baidu.location.e.l.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                    bDLocation2.setDisToRealLocation(a2);
                } else if (TextUtils.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09, bDLocation2.getCoorType())) {
                    double[] coorEncrypt2 = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double[] coorEncrypt3 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    a2 = com.baidu.location.e.l.a(coorEncrypt2[1], coorEncrypt2[0], coorEncrypt3[1], coorEncrypt3[0]);
                    bDLocation2.setDisToRealLocation(a2);
                } else {
                    a2 = com.baidu.location.e.l.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                    bDLocation2.setDisToRealLocation(a2);
                }
            } else if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                a2 = com.baidu.location.e.l.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                bDLocation2.setDisToRealLocation(a2);
            } else {
                double[] coorEncrypt4 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                bDLocation.setLatitude(coorEncrypt4[1]);
                bDLocation.setLongitude(coorEncrypt4[0]);
                bDLocation.setTime(com.baidu.location.e.l.a());
                bDLocation.setCoorType(CoordinateType.WGS84);
                a2 = com.baidu.location.e.l.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                bDLocation2.setDisToRealLocation(a2);
            }
            if (bDLocation != null) {
                bDLocation2.setReallLocation(bDLocation);
            }
            return a2;
        }

        private int a(double d) {
            if (d < 0.0d || d > 10.0d) {
                if (d <= 10.0d || d > 100.0d) {
                    return (d <= 100.0d || d > 200.0d) ? 3 : 2;
                }
                return 1;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        private BDLocation b() {
            BDLocation h = com.baidu.location.c.f.a().h();
            if (h != null) {
                double[] coorEncrypt = Jni.coorEncrypt(h.getLongitude(), h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                double[] coorEncrypt2 = Jni.coorEncrypt(coorEncrypt[0], coorEncrypt[1], this.c.coorType);
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLongitude(coorEncrypt2[0]);
                bDLocation.setLatitude(coorEncrypt2[1]);
                bDLocation.setTime(com.baidu.location.e.l.a());
                bDLocation.setLocType(61);
                bDLocation.setCoorType(this.c.coorType);
                return bDLocation;
            }
            return null;
        }

        private BDLocation c() {
            BDLocation h = com.baidu.location.c.f.a().h();
            if (h != null) {
                double[] coorEncrypt = Jni.coorEncrypt(h.getLongitude(), h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLongitude(coorEncrypt[0]);
                bDLocation.setLatitude(coorEncrypt[1]);
                bDLocation.setTime(com.baidu.location.e.l.a());
                bDLocation.setLocType(61);
                bDLocation.setCoorType("gcj02");
                return bDLocation;
            }
            return null;
        }

        public int a(int i, boolean z, BDLocation bDLocation) {
            if (i == 100) {
                if (z) {
                    BDLocation b = b();
                    if (b != null) {
                        a(true, b, bDLocation);
                    }
                } else {
                    BDLocation c = c();
                    if (c != null) {
                        a(false, c, bDLocation);
                    }
                }
                return 3;
            } else if (i == 200 || i == 300) {
                return 1;
            } else {
                if (i != 400) {
                    return i != 500 ? 0 : 1;
                }
                if (z) {
                    BDLocation b2 = b();
                    if (b2 != null) {
                        return a(a(true, b2, bDLocation));
                    }
                } else {
                    BDLocation c2 = c();
                    if (c2 != null) {
                        return a(a(false, c2, bDLocation));
                    }
                }
                return -1;
            }
        }

        public void a() {
            if (this.c.location_change_notify) {
                if (com.baidu.location.e.l.b) {
                    a(54);
                } else {
                    a(55);
                }
            }
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.c.coorType != null && !this.c.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.c.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84) && !this.c.coorType.equals("bd09ll")) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        bDLocation2.setCoorType("wgs84mc");
                    }
                }
                if (!com.baidu.location.e.l.m && bDLocation2.getMockGpsStrategy() > 0) {
                    bDLocation2.setMockGpsProbability(a(bDLocation2.getMockGpsStrategy(), true, bDLocation2));
                }
            } else if (!com.baidu.location.e.l.m && bDLocation2.getMockGpsStrategy() > 0) {
                bDLocation2.setMockGpsProbability(a(bDLocation2.getMockGpsStrategy(), false, bDLocation2));
            }
            a(i, "locStr", bDLocation2);
        }
    }

    /* renamed from: com.baidu.location.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class RunnableC0233b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f1873a;
        private int b;
        private boolean c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.b++;
            this.f1873a.m = false;
        }
    }

    private b() {
        this.g = null;
        this.g = new ArrayList<>();
    }

    private a a(Messenger messenger) {
        if (this.g == null) {
            return null;
        }
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    public static b a() {
        if (f == null) {
            f = new b();
        }
        return f;
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (a(aVar.b) != null) {
            aVar.a(14);
            return;
        }
        this.g.add(aVar);
        aVar.a(13);
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.e.b.e);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<a> it = this.g.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            a next = it.next();
            if (next.c.openGps) {
                z2 = true;
            }
            z = next.c.location_change_notify ? true : z;
        }
        com.baidu.location.e.l.f1955a = z;
        if (this.h != z2) {
            this.h = z2;
            com.baidu.location.c.f.a().a(this.h);
        }
    }

    public void a(Bundle bundle, int i) {
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            try {
                a next = it.next();
                next.a(i, bundle);
                if (next.d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        c = System.currentTimeMillis();
        this.f1871a = true;
        com.baidu.location.c.i.a().b();
        a(new a(this, message));
        e();
        if (this.l) {
            b("start");
            this.e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    public void a(String str) {
        c(new BDLocation(str));
    }

    public void a(boolean z) {
        this.f1871a = z;
        if (z) {
            d = 1;
        } else {
            d = 0;
        }
    }

    public void b() {
        this.g.clear();
        this.i = null;
        e();
    }

    public void b(Message message) {
        a a2 = a(message.replyTo);
        if (a2 != null) {
            this.g.remove(a2);
        }
        r.a().c();
        e();
        if (this.l) {
            b("stop");
            this.e = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().b()) {
            Iterator<a> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    a next = it.next();
                    next.a(bDLocation);
                    if (next.d > 4) {
                        it.remove();
                    }
                } catch (Exception e) {
                }
            }
        } else {
            if (this.j == null) {
                this.j = new BDLocation();
                this.j.setLocType(505);
            }
            Iterator<a> it2 = this.g.iterator();
            while (it2.hasNext()) {
                try {
                    a next2 = it2.next();
                    next2.a(this.j);
                    if (next2.d > 4) {
                        it2.remove();
                    }
                } catch (Exception e2) {
                }
            }
        }
        boolean z = o.h;
        if (z) {
            o.h = false;
        }
        if (com.baidu.location.e.l.X >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                if (this.i == null) {
                    this.i = new BDLocation(bDLocation);
                    return;
                }
                float[] fArr = new float[1];
                Location.distanceBetween(this.i.getLatitude(), this.i.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] > com.baidu.location.e.l.Z || z) {
                    this.i = null;
                    this.i = new BDLocation(bDLocation);
                }
            }
        }
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.g.isEmpty()) {
            return "&prod=" + com.baidu.location.e.b.f + ":" + com.baidu.location.e.b.e;
        }
        a aVar = this.g.get(0);
        if (aVar.c.prodName != null) {
            stringBuffer.append(aVar.c.prodName);
        }
        if (aVar.f1872a != null) {
            stringBuffer.append(":");
            stringBuffer.append(aVar.f1872a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void c(BDLocation bDLocation) {
        Address a2 = o.c().a(bDLocation);
        String f2 = o.c().f();
        List<Poi> g = o.c().g();
        PoiRegion h = o.c().h();
        if (a2 != null) {
            bDLocation.setAddr(a2);
        }
        if (f2 != null) {
            bDLocation.setLocationDescribe(f2);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        if (h != null) {
            bDLocation.setPoiRegion(h);
        }
        a(bDLocation);
        o.c().c(bDLocation);
    }

    public boolean c(Message message) {
        boolean z = false;
        a a2 = a(message.replyTo);
        if (a2 != null) {
            int i = a2.c.scanSpan;
            a2.c.scanSpan = message.getData().getInt("scanSpan", a2.c.scanSpan);
            if (a2.c.scanSpan < 1000) {
                r.a().c();
                this.f1871a = false;
            } else {
                this.f1871a = true;
            }
            if (a2.c.scanSpan > 999 && i < 1000) {
                if (a2.c.mIsNeedDeviceDirect || a2.c.isNeedAltitude) {
                    r.a().a(a2.c.mIsNeedDeviceDirect);
                    r.a().b();
                }
                if (this.b || a2.c.isNeedAltitude) {
                    z = true;
                }
                this.b = z;
                z = true;
            }
            a2.c.openGps = message.getData().getBoolean("openGPS", a2.c.openGps);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption = a2.c;
            if (string == null || string.equals("")) {
                string = a2.c.coorType;
            }
            locationClientOption.coorType = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption2 = a2.c;
            if (string2 == null || string2.equals("")) {
                string2 = a2.c.addrType;
            }
            locationClientOption2.addrType = string2;
            if (!com.baidu.location.e.l.g.equals(a2.c.addrType)) {
                o.c().j();
            }
            a2.c.timeOut = message.getData().getInt("timeOut", a2.c.timeOut);
            a2.c.location_change_notify = message.getData().getBoolean("location_change_notify", a2.c.location_change_notify);
            a2.c.priority = message.getData().getInt("priority", a2.c.priority);
            int i2 = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i2 < com.baidu.location.e.l.ag) {
                com.baidu.location.e.l.ag = i2;
            }
            e();
        }
        return z;
    }

    public int d(Message message) {
        a a2;
        if (message == null || message.replyTo == null || (a2 = a(message.replyTo)) == null || a2.c == null) {
            return 1;
        }
        return a2.c.priority;
    }

    public void d() {
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public int e(Message message) {
        a a2;
        if (message == null || message.replyTo == null || (a2 = a(message.replyTo)) == null || a2.c == null) {
            return 1000;
        }
        return a2.c.scanSpan;
    }
}
