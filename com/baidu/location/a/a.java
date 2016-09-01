package com.baidu.location.a;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a Ia = null;
    private ArrayList<C0017a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation Ib = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0017a {
        final /* synthetic */ a Id;
        public String a;
        public Messenger b;
        public LocationClientOption Ic = new LocationClientOption();
        public int d = 0;

        public C0017a(a aVar, Message message) {
            boolean z = true;
            this.Id = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.Ic.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nm().a(this.Ic.prodName, this.a);
            this.Ic.coorType = message.getData().getString("coorType");
            this.Ic.addrType = message.getData().getString("addrType");
            this.Ic.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.Ic.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.Ic.addrType;
            }
            this.Ic.openGps = message.getData().getBoolean("openGPS");
            this.Ic.scanSpan = message.getData().getInt("scanSpan");
            this.Ic.timeOut = message.getData().getInt("timeOut");
            this.Ic.priority = message.getData().getInt("priority");
            this.Ic.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.Ic.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.Ic.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.LO = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i >= com.baidu.location.h.i.T) {
                com.baidu.location.h.i.T = i;
            }
            int i2 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i2 >= com.baidu.location.h.i.V) {
                com.baidu.location.h.i.V = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i3 >= com.baidu.location.h.i.U) {
                com.baidu.location.h.i.U = i3;
            }
            if (this.Ic.scanSpan >= 1000) {
                com.baidu.location.c.h.mI().b();
            }
            if (this.Ic.mIsNeedDeviceDirect || this.Ic.isNeedAltitude) {
                f.mq().a(this.Ic.mIsNeedDeviceDirect);
                f.mq().b(this.Ic.isNeedAltitude);
                f.mq().b();
            }
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

        public void a() {
            if (this.Ic.location_change_notify) {
                if (com.baidu.location.h.i.b) {
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
            if (f.mq().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.mq().mr());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.Ic.coorType != null && !this.Ic.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Ic.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.Ic.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.Ic.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        bDLocation2.setCoorType("wgs84mc");
                    }
                }
            }
            a(i, "locStr", bDLocation2);
        }
    }

    private a() {
        this.c = null;
        this.c = new ArrayList<>();
    }

    private C0017a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0017a> it = this.c.iterator();
        while (it.hasNext()) {
            C0017a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0017a c0017a) {
        if (c0017a == null) {
            return;
        }
        if (a(c0017a.b) != null) {
            c0017a.a(14);
            return;
        }
        this.c.add(c0017a);
        c0017a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0017a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0017a next = it.next();
            if (next.Ic.openGps) {
                z2 = true;
            }
            z = next.Ic.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.nf().a(this.d);
        }
    }

    public static a mn() {
        if (Ia == null) {
            Ia = new a();
        }
        return Ia;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0017a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.Ib != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.Ib.getLatitude(), this.Ib.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.Ib = null;
                this.Ib = new BDLocation(bDLocation);
            } else {
                this.Ib = new BDLocation(bDLocation);
            }
        }
        Iterator<C0017a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0017a next = it.next();
                next.a(bDLocation);
                if (next.d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public void a(String str) {
        BDLocation bDLocation = new BDLocation(str);
        Address b = e.mp().b(bDLocation);
        String e = e.mp().e();
        List<Poi> f = e.mp().f();
        if (b != null) {
            bDLocation.setAddr(b);
        }
        if (e != null) {
            bDLocation.setLocationDescribe(e);
        }
        if (f != null) {
            bDLocation.setPoiList(f);
        }
        a(bDLocation);
    }

    public void b() {
        this.c.clear();
        this.Ib = null;
        e();
    }

    public void b(Message message) {
        C0017a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.mI().c();
        f.mq().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0017a c0017a = this.c.get(0);
        if (c0017a.Ic.prodName != null) {
            stringBuffer.append(c0017a.Ic.prodName);
        }
        if (c0017a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0017a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0017a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0017a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.Ic.scanSpan;
        a.Ic.scanSpan = message.getData().getInt("scanSpan", a.Ic.scanSpan);
        if (a.Ic.scanSpan < 1000) {
            com.baidu.location.c.h.mI().e();
            f.mq().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.mI().d();
            this.a = true;
        }
        if (a.Ic.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.Ic.mIsNeedDeviceDirect || a.Ic.isNeedAltitude) {
            f.mq().a(a.Ic.mIsNeedDeviceDirect);
            f.mq().b(a.Ic.isNeedAltitude);
            f.mq().b();
        }
        a.Ic.openGps = message.getData().getBoolean("openGPS", a.Ic.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.Ic;
        if (string == null || string.equals("")) {
            string = a.Ic.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.Ic;
        if (string2 == null || string2.equals("")) {
            string2 = a.Ic.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.Ic.addrType)) {
            e.mp().i();
        }
        a.Ic.timeOut = message.getData().getInt("timeOut", a.Ic.timeOut);
        a.Ic.location_change_notify = message.getData().getBoolean("location_change_notify", a.Ic.location_change_notify);
        a.Ic.priority = message.getData().getInt("priority", a.Ic.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0017a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Ic == null) {
            return 1;
        }
        return a.Ic.priority;
    }

    public int f(Message message) {
        C0017a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Ic == null) {
            return 1000;
        }
        return a.Ic.scanSpan;
    }
}
