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
    private static a HZ = null;
    private ArrayList<C0017a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation Ia = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0017a {
        final /* synthetic */ a Ic;
        public String a;
        public Messenger b;
        public LocationClientOption Ib = new LocationClientOption();
        public int d = 0;

        public C0017a(a aVar, Message message) {
            boolean z = true;
            this.Ic = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.Ib.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nm().a(this.Ib.prodName, this.a);
            this.Ib.coorType = message.getData().getString("coorType");
            this.Ib.addrType = message.getData().getString("addrType");
            this.Ib.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.Ib.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.Ib.addrType;
            }
            this.Ib.openGps = message.getData().getBoolean("openGPS");
            this.Ib.scanSpan = message.getData().getInt("scanSpan");
            this.Ib.timeOut = message.getData().getInt("timeOut");
            this.Ib.priority = message.getData().getInt("priority");
            this.Ib.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.Ib.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.Ib.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.LN = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.Ib.scanSpan >= 1000) {
                com.baidu.location.c.h.mI().b();
            }
            if (this.Ib.mIsNeedDeviceDirect || this.Ib.isNeedAltitude) {
                f.mq().a(this.Ib.mIsNeedDeviceDirect);
                f.mq().b(this.Ib.isNeedAltitude);
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
            if (this.Ib.location_change_notify) {
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
            if (this.Ib.coorType != null && !this.Ib.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Ib.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.Ib.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.Ib.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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
            if (next.Ib.openGps) {
                z2 = true;
            }
            z = next.Ib.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.nf().a(this.d);
        }
    }

    public static a mn() {
        if (HZ == null) {
            HZ = new a();
        }
        return HZ;
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
            if (this.Ia != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.Ia.getLatitude(), this.Ia.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.Ia = null;
                this.Ia = new BDLocation(bDLocation);
            } else {
                this.Ia = new BDLocation(bDLocation);
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
        this.Ia = null;
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
        if (c0017a.Ib.prodName != null) {
            stringBuffer.append(c0017a.Ib.prodName);
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
        int i = a.Ib.scanSpan;
        a.Ib.scanSpan = message.getData().getInt("scanSpan", a.Ib.scanSpan);
        if (a.Ib.scanSpan < 1000) {
            com.baidu.location.c.h.mI().e();
            f.mq().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.mI().d();
            this.a = true;
        }
        if (a.Ib.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.Ib.mIsNeedDeviceDirect || a.Ib.isNeedAltitude) {
            f.mq().a(a.Ib.mIsNeedDeviceDirect);
            f.mq().b(a.Ib.isNeedAltitude);
            f.mq().b();
        }
        a.Ib.openGps = message.getData().getBoolean("openGPS", a.Ib.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.Ib;
        if (string == null || string.equals("")) {
            string = a.Ib.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.Ib;
        if (string2 == null || string2.equals("")) {
            string2 = a.Ib.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.Ib.addrType)) {
            e.mp().i();
        }
        a.Ib.timeOut = message.getData().getInt("timeOut", a.Ib.timeOut);
        a.Ib.location_change_notify = message.getData().getBoolean("location_change_notify", a.Ib.location_change_notify);
        a.Ib.priority = message.getData().getInt("priority", a.Ib.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0017a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Ib == null) {
            return 1;
        }
        return a.Ib.priority;
    }

    public int f(Message message) {
        C0017a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Ib == null) {
            return 1000;
        }
        return a.Ib.scanSpan;
    }
}
