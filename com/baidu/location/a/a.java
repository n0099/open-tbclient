package com.baidu.location.a;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static long f6448c;

    /* renamed from: e  reason: collision with root package name */
    public static a f6449e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<C0090a> f6453f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6454g = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6450a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6451b = false;

    /* renamed from: h  reason: collision with root package name */
    public BDLocation f6455h = null;
    public BDLocation i = null;

    /* renamed from: d  reason: collision with root package name */
    public int f6452d = 0;
    public BDLocation j = null;
    public boolean k = false;
    public boolean l = false;
    public b m = null;

    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0090a {

        /* renamed from: a  reason: collision with root package name */
        public String f6456a;

        /* renamed from: b  reason: collision with root package name */
        public Messenger f6457b;

        /* renamed from: c  reason: collision with root package name */
        public LocationClientOption f6458c = new LocationClientOption();

        /* renamed from: d  reason: collision with root package name */
        public int f6459d = 0;

        public C0090a(Message message) {
            this.f6456a = null;
            this.f6457b = null;
            boolean z = false;
            this.f6457b = message.replyTo;
            this.f6456a = message.getData().getString("packName");
            this.f6458c.prodName = message.getData().getString("prodName");
            com.baidu.location.d.b.a().a(this.f6458c.prodName, this.f6456a);
            this.f6458c.coorType = message.getData().getString("coorType");
            this.f6458c.addrType = message.getData().getString("addrType");
            this.f6458c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.d.j.m = com.baidu.location.d.j.m || this.f6458c.enableSimulateGps;
            if (!com.baidu.location.d.j.f6720g.equals("all")) {
                com.baidu.location.d.j.f6720g = this.f6458c.addrType;
            }
            this.f6458c.openGps = message.getData().getBoolean("openGPS");
            this.f6458c.scanSpan = message.getData().getInt("scanSpan");
            this.f6458c.timeOut = message.getData().getInt("timeOut");
            this.f6458c.priority = message.getData().getInt("priority");
            this.f6458c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.f6458c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.f6458c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.f6458c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.d.j.i = com.baidu.location.d.j.i || this.f6458c.isNeedNewVersionRgc;
            com.baidu.location.d.j.f6721h = com.baidu.location.d.j.f6721h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.d.j.j = com.baidu.location.d.j.j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.d.j.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i < com.baidu.location.d.j.af) {
                com.baidu.location.d.j.af = i;
            }
            int i2 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i2 >= com.baidu.location.d.j.W) {
                com.baidu.location.d.j.W = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i3 >= com.baidu.location.d.j.Y) {
                com.baidu.location.d.j.Y = i3;
            }
            int i4 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i4 >= com.baidu.location.d.j.X) {
                com.baidu.location.d.j.X = i4;
            }
            LocationClientOption locationClientOption = this.f6458c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                o.a().a(this.f6458c.mIsNeedDeviceDirect);
                o.a().b();
            }
            a.this.f6451b = (a.this.f6451b || this.f6458c.isNeedAltitude) ? true : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f6457b != null) {
                    this.f6457b.send(obtain);
                }
                this.f6459d = 0;
            } catch (Exception e2) {
                if (e2 instanceof DeadObjectException) {
                    this.f6459d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f6457b != null) {
                    this.f6457b.send(obtain);
                }
                this.f6459d = 0;
            } catch (Exception e2) {
                if (e2 instanceof DeadObjectException) {
                    this.f6459d++;
                }
                e2.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f6457b != null) {
                    this.f6457b.send(obtain);
                }
                this.f6459d = 0;
            } catch (Exception e2) {
                if (e2 instanceof DeadObjectException) {
                    this.f6459d++;
                }
            }
        }

        public void a() {
            if (this.f6458c.location_change_notify) {
                a(com.baidu.location.d.j.f6715b ? 54 : 55);
            }
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            String str2 = this.f6458c.coorType;
            if (str2 != null && !str2.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f6458c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.f6458c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84) && !this.f6458c.coorType.equals("bd09ll")) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
            }
            a(i, "locStr", bDLocation2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6461a;

        /* renamed from: b  reason: collision with root package name */
        public int f6462b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6463c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6463c) {
                return;
            }
            this.f6462b++;
            this.f6461a.l = false;
        }
    }

    public a() {
        this.f6453f = null;
        this.f6453f = new ArrayList<>();
    }

    private C0090a a(Messenger messenger) {
        ArrayList<C0090a> arrayList = this.f6453f;
        if (arrayList == null) {
            return null;
        }
        Iterator<C0090a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0090a next = it.next();
            if (next.f6457b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    public static a a() {
        if (f6449e == null) {
            f6449e = new a();
        }
        return f6449e;
    }

    private void a(C0090a c0090a) {
        int i;
        if (c0090a == null) {
            return;
        }
        if (a(c0090a.f6457b) != null) {
            i = 14;
        } else {
            this.f6453f.add(c0090a);
            i = 13;
        }
        c0090a.a(i);
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.d.b.f6676d);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0090a> it = this.f6453f.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0090a next = it.next();
            if (next.f6458c.openGps) {
                z2 = true;
            }
            if (next.f6458c.location_change_notify) {
                z = true;
            }
        }
        com.baidu.location.d.j.f6714a = z;
        if (this.f6454g != z2) {
            this.f6454g = z2;
            com.baidu.location.b.e.a().a(this.f6454g);
        }
    }

    public void a(Bundle bundle, int i) {
        Iterator<C0090a> it = this.f6453f.iterator();
        while (it.hasNext()) {
            try {
                C0090a next = it.next();
                next.a(i, bundle);
                if (next.f6459d > 4) {
                    it.remove();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        f6448c = System.currentTimeMillis();
        this.f6450a = true;
        com.baidu.location.b.i.a().b();
        a(new C0090a(message));
        e();
        if (this.k) {
            b(IntentConfig.START);
            this.f6452d = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    public void a(String str) {
        c(new BDLocation(str));
    }

    public void b() {
        this.f6453f.clear();
        this.f6455h = null;
        e();
    }

    public void b(Message message) {
        C0090a a2 = a(message.replyTo);
        if (a2 != null) {
            this.f6453f.remove(a2);
        }
        o.a().c();
        e();
        if (this.k) {
            b(IntentConfig.STOP);
            this.f6452d = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        try {
            if (bDLocation == null || bDLocation.getLocType() != 161 || j.a().b()) {
                Iterator<C0090a> it = this.f6453f.iterator();
                while (it.hasNext()) {
                    C0090a next = it.next();
                    next.a(bDLocation);
                    if (next.f6459d > 4) {
                        it.remove();
                    }
                }
            } else {
                if (this.i == null) {
                    BDLocation bDLocation3 = new BDLocation();
                    this.i = bDLocation3;
                    bDLocation3.setLocType(505);
                }
                Iterator<C0090a> it2 = this.f6453f.iterator();
                while (it2.hasNext()) {
                    C0090a next2 = it2.next();
                    next2.a(this.i);
                    if (next2.f6459d > 4) {
                        it2.remove();
                    }
                }
            }
        } catch (Exception unused) {
        }
        boolean z = l.f6549g;
        if (z) {
            l.f6549g = false;
        }
        if (com.baidu.location.d.j.W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                BDLocation bDLocation4 = this.f6455h;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.getLatitude(), this.f6455h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] <= com.baidu.location.d.j.Y && !z) {
                        return;
                    }
                    this.f6455h = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.f6455h = bDLocation2;
            }
        }
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f6453f.isEmpty()) {
            return "&prod=" + com.baidu.location.d.b.f6677e + ":" + com.baidu.location.d.b.f6676d;
        }
        C0090a c0090a = this.f6453f.get(0);
        String str = c0090a.f6458c.prodName;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (c0090a.f6456a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0090a.f6456a);
            stringBuffer.append(FieldBuilder.SE);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void c(BDLocation bDLocation) {
        Address a2 = l.c().a(bDLocation);
        String f2 = l.c().f();
        List<Poi> g2 = l.c().g();
        if (a2 != null) {
            bDLocation.setAddr(a2);
        }
        if (f2 != null) {
            bDLocation.setLocationDescribe(f2);
        }
        if (g2 != null) {
            bDLocation.setPoiList(g2);
        }
        a(bDLocation);
        l.c().c(bDLocation);
    }

    public boolean c(Message message) {
        C0090a a2 = a(message.replyTo);
        boolean z = false;
        if (a2 == null) {
            return false;
        }
        LocationClientOption locationClientOption = a2.f6458c;
        int i = locationClientOption.scanSpan;
        locationClientOption.scanSpan = message.getData().getInt("scanSpan", a2.f6458c.scanSpan);
        if (a2.f6458c.scanSpan < 1000) {
            o.a().c();
            this.f6450a = false;
        } else {
            this.f6450a = true;
        }
        LocationClientOption locationClientOption2 = a2.f6458c;
        if (locationClientOption2.scanSpan > 999 && i < 1000) {
            if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                o.a().a(a2.f6458c.mIsNeedDeviceDirect);
                o.a().b();
            }
            this.f6451b = (this.f6451b || a2.f6458c.isNeedAltitude) ? true : true;
            z = true;
        }
        a2.f6458c.openGps = message.getData().getBoolean("openGPS", a2.f6458c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption3 = a2.f6458c;
        if (string == null || string.equals("")) {
            string = a2.f6458c.coorType;
        }
        locationClientOption3.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption4 = a2.f6458c;
        if (string2 == null || string2.equals("")) {
            string2 = a2.f6458c.addrType;
        }
        locationClientOption4.addrType = string2;
        if (!com.baidu.location.d.j.f6720g.equals(a2.f6458c.addrType)) {
            l.c().i();
        }
        a2.f6458c.timeOut = message.getData().getInt("timeOut", a2.f6458c.timeOut);
        a2.f6458c.location_change_notify = message.getData().getBoolean("location_change_notify", a2.f6458c.location_change_notify);
        a2.f6458c.priority = message.getData().getInt("priority", a2.f6458c.priority);
        int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i2 < com.baidu.location.d.j.af) {
            com.baidu.location.d.j.af = i2;
        }
        e();
        return z;
    }

    public int d(Message message) {
        Messenger messenger;
        C0090a a2;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || (locationClientOption = a2.f6458c) == null) {
            return 1;
        }
        return locationClientOption.priority;
    }

    public void d() {
        Iterator<C0090a> it = this.f6453f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public int e(Message message) {
        Messenger messenger;
        C0090a a2;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || (locationClientOption = a2.f6458c) == null) {
            return 1000;
        }
        return locationClientOption.scanSpan;
    }
}
