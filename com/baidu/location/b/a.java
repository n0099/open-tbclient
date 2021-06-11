package com.baidu.location.b;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static long f6475c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f6476d = -1;

    /* renamed from: f  reason: collision with root package name */
    public static a f6477f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<C0091a> f6481g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6482h = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6478a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6479b = false;

    /* renamed from: i  reason: collision with root package name */
    public BDLocation f6483i = null;
    public BDLocation j = null;

    /* renamed from: e  reason: collision with root package name */
    public int f6480e = 0;
    public BDLocation k = null;
    public boolean l = false;
    public boolean m = false;
    public b n = null;

    /* renamed from: com.baidu.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0091a {

        /* renamed from: a  reason: collision with root package name */
        public String f6484a;

        /* renamed from: b  reason: collision with root package name */
        public Messenger f6485b;

        /* renamed from: c  reason: collision with root package name */
        public LocationClientOption f6486c = new LocationClientOption();

        /* renamed from: d  reason: collision with root package name */
        public int f6487d = 0;

        public C0091a(Message message) {
            this.f6484a = null;
            this.f6485b = null;
            boolean z = false;
            this.f6485b = message.replyTo;
            this.f6484a = message.getData().getString("packName");
            this.f6486c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.f6486c.prodName, this.f6484a);
            this.f6486c.coorType = message.getData().getString("coorType");
            this.f6486c.addrType = message.getData().getString("addrType");
            this.f6486c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.k.m = com.baidu.location.e.k.m || this.f6486c.enableSimulateGps;
            if (!com.baidu.location.e.k.f6768g.equals("all")) {
                com.baidu.location.e.k.f6768g = this.f6486c.addrType;
            }
            this.f6486c.openGps = message.getData().getBoolean("openGPS");
            this.f6486c.scanSpan = message.getData().getInt("scanSpan");
            this.f6486c.timeOut = message.getData().getInt("timeOut");
            this.f6486c.priority = message.getData().getInt("priority");
            this.f6486c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.f6486c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.f6486c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.f6486c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.k.f6770i = com.baidu.location.e.k.f6770i || this.f6486c.isNeedNewVersionRgc;
            com.baidu.location.e.k.f6769h = com.baidu.location.e.k.f6769h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.k.j = com.baidu.location.e.k.j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.k.S = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i2 < com.baidu.location.e.k.ag) {
                com.baidu.location.e.k.ag = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i3 >= com.baidu.location.e.k.X) {
                com.baidu.location.e.k.X = i3;
            }
            int i4 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i4 >= com.baidu.location.e.k.Z) {
                com.baidu.location.e.k.Z = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i5 >= com.baidu.location.e.k.Y) {
                com.baidu.location.e.k.Y = i5;
            }
            LocationClientOption locationClientOption = this.f6486c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                n.a().a(this.f6486c.mIsNeedDeviceDirect);
                n.a().b();
            }
            a.this.f6479b = (a.this.f6479b || this.f6486c.isNeedAltitude) ? true : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2) {
            Message obtain = Message.obtain((Handler) null, i2);
            try {
                if (this.f6485b != null) {
                    this.f6485b.send(obtain);
                }
                this.f6487d = 0;
            } catch (Exception e2) {
                if (e2 instanceof DeadObjectException) {
                    this.f6487d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.setData(bundle);
            try {
                if (this.f6485b != null) {
                    this.f6485b.send(obtain);
                }
                this.f6487d = 0;
            } catch (Exception e2) {
                if (e2 instanceof DeadObjectException) {
                    this.f6487d++;
                }
                e2.printStackTrace();
            }
        }

        private void a(int i2, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.setData(bundle);
            try {
                if (this.f6485b != null) {
                    this.f6485b.send(obtain);
                }
                this.f6487d = 0;
            } catch (Exception e2) {
                if (e2 instanceof DeadObjectException) {
                    this.f6487d++;
                }
            }
        }

        public void a() {
            if (this.f6486c.location_change_notify) {
                a(com.baidu.location.e.k.f6763b ? 54 : 55);
            }
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i2) {
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i2 == 21) {
                a(27, "locStr", bDLocation2);
            }
            String str2 = this.f6486c.coorType;
            if (str2 != null && !str2.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f6486c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.f6486c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84)) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, this.f6486c.coorType);
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        str = this.f6486c.coorType.equals("bd09ll") ? "wgs84mc" : "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
            }
            a(i2, "locStr", bDLocation2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6489a;

        /* renamed from: b  reason: collision with root package name */
        public int f6490b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6491c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6491c) {
                return;
            }
            this.f6490b++;
            this.f6489a.m = false;
        }
    }

    public a() {
        this.f6481g = null;
        this.f6481g = new ArrayList<>();
    }

    private C0091a a(Messenger messenger) {
        ArrayList<C0091a> arrayList = this.f6481g;
        if (arrayList == null) {
            return null;
        }
        Iterator<C0091a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0091a next = it.next();
            if (next.f6485b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    public static a a() {
        if (f6477f == null) {
            f6477f = new a();
        }
        return f6477f;
    }

    private void a(C0091a c0091a) {
        int i2;
        if (c0091a == null) {
            return;
        }
        if (a(c0091a.f6485b) != null) {
            i2 = 14;
        } else {
            this.f6481g.add(c0091a);
            i2 = 13;
        }
        c0091a.a(i2);
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.e.b.f6719e);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0091a> it = this.f6481g.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0091a next = it.next();
            if (next.f6486c.openGps) {
                z2 = true;
            }
            if (next.f6486c.location_change_notify) {
                z = true;
            }
        }
        com.baidu.location.e.k.f6762a = z;
        if (this.f6482h != z2) {
            this.f6482h = z2;
            com.baidu.location.c.e.a().a(this.f6482h);
        }
    }

    public void a(Bundle bundle, int i2) {
        Iterator<C0091a> it = this.f6481g.iterator();
        while (it.hasNext()) {
            try {
                C0091a next = it.next();
                next.a(i2, bundle);
                if (next.f6487d > 4) {
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
        f6475c = System.currentTimeMillis();
        this.f6478a = true;
        com.baidu.location.c.i.a().b();
        a(new C0091a(message));
        e();
        if (this.l) {
            b(IntentConfig.START);
            this.f6480e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    public void a(String str) {
        c(new BDLocation(str));
    }

    public void a(boolean z) {
        this.f6478a = z;
        f6476d = z ? 1 : 0;
    }

    public void b() {
        this.f6481g.clear();
        this.f6483i = null;
        e();
    }

    public void b(Message message) {
        C0091a a2 = a(message.replyTo);
        if (a2 != null) {
            this.f6481g.remove(a2);
        }
        n.a().c();
        e();
        if (this.l) {
            b(IntentConfig.STOP);
            this.f6480e = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        try {
            if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().b()) {
                Iterator<C0091a> it = this.f6481g.iterator();
                while (it.hasNext()) {
                    C0091a next = it.next();
                    next.a(bDLocation);
                    if (next.f6487d > 4) {
                        it.remove();
                    }
                }
            } else {
                if (this.j == null) {
                    BDLocation bDLocation3 = new BDLocation();
                    this.j = bDLocation3;
                    bDLocation3.setLocType(505);
                }
                Iterator<C0091a> it2 = this.f6481g.iterator();
                while (it2.hasNext()) {
                    C0091a next2 = it2.next();
                    next2.a(this.j);
                    if (next2.f6487d > 4) {
                        it2.remove();
                    }
                }
            }
        } catch (Exception unused) {
        }
        boolean z = l.f6586g;
        if (z) {
            l.f6586g = false;
        }
        if (com.baidu.location.e.k.X >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                BDLocation bDLocation4 = this.f6483i;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.getLatitude(), this.f6483i.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] <= com.baidu.location.e.k.Z && !z) {
                        return;
                    }
                    this.f6483i = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.f6483i = bDLocation2;
            }
        }
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f6481g.isEmpty()) {
            return "&prod=" + com.baidu.location.e.b.f6720f + ":" + com.baidu.location.e.b.f6719e;
        }
        C0091a c0091a = this.f6481g.get(0);
        String str = c0091a.f6486c.prodName;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (c0091a.f6484a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0091a.f6484a);
            stringBuffer.append("|");
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
        C0091a a2 = a(message.replyTo);
        boolean z = false;
        if (a2 == null) {
            return false;
        }
        LocationClientOption locationClientOption = a2.f6486c;
        int i2 = locationClientOption.scanSpan;
        locationClientOption.scanSpan = message.getData().getInt("scanSpan", a2.f6486c.scanSpan);
        if (a2.f6486c.scanSpan < 1000) {
            n.a().c();
            this.f6478a = false;
        } else {
            this.f6478a = true;
        }
        LocationClientOption locationClientOption2 = a2.f6486c;
        if (locationClientOption2.scanSpan > 999 && i2 < 1000) {
            if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                n.a().a(a2.f6486c.mIsNeedDeviceDirect);
                n.a().b();
            }
            this.f6479b = (this.f6479b || a2.f6486c.isNeedAltitude) ? true : true;
            z = true;
        }
        a2.f6486c.openGps = message.getData().getBoolean("openGPS", a2.f6486c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption3 = a2.f6486c;
        if (string == null || string.equals("")) {
            string = a2.f6486c.coorType;
        }
        locationClientOption3.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption4 = a2.f6486c;
        if (string2 == null || string2.equals("")) {
            string2 = a2.f6486c.addrType;
        }
        locationClientOption4.addrType = string2;
        if (!com.baidu.location.e.k.f6768g.equals(a2.f6486c.addrType)) {
            l.c().i();
        }
        a2.f6486c.timeOut = message.getData().getInt("timeOut", a2.f6486c.timeOut);
        a2.f6486c.location_change_notify = message.getData().getBoolean("location_change_notify", a2.f6486c.location_change_notify);
        a2.f6486c.priority = message.getData().getInt("priority", a2.f6486c.priority);
        int i3 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i3 < com.baidu.location.e.k.ag) {
            com.baidu.location.e.k.ag = i3;
        }
        e();
        return z;
    }

    public int d(Message message) {
        Messenger messenger;
        C0091a a2;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || (locationClientOption = a2.f6486c) == null) {
            return 1;
        }
        return locationClientOption.priority;
    }

    public void d() {
        Iterator<C0091a> it = this.f6481g.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public int e(Message message) {
        Messenger messenger;
        C0091a a2;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || (locationClientOption = a2.f6486c) == null) {
            return 1000;
        }
        return locationClientOption.scanSpan;
    }
}
