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
    private static a LM = null;
    private ArrayList<C0021a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation LN = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0021a {
        final /* synthetic */ a LP;
        public String a;
        public Messenger b;
        public LocationClientOption LO = new LocationClientOption();
        public int d = 0;

        public C0021a(a aVar, Message message) {
            boolean z = true;
            this.LP = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.LO.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nl().a(this.LO.prodName, this.a);
            this.LO.coorType = message.getData().getString("coorType");
            this.LO.addrType = message.getData().getString("addrType");
            this.LO.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.LO.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.LO.addrType;
            }
            this.LO.openGps = message.getData().getBoolean("openGPS");
            this.LO.scanSpan = message.getData().getInt("scanSpan");
            this.LO.timeOut = message.getData().getInt("timeOut");
            this.LO.priority = message.getData().getInt("priority");
            this.LO.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.LO.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.LO.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.Pq = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.LO.scanSpan >= 1000) {
                com.baidu.location.c.h.mI().b();
            }
            if (this.LO.mIsNeedDeviceDirect || this.LO.isNeedAltitude) {
                f.mq().a(this.LO.mIsNeedDeviceDirect);
                f.mq().b(this.LO.isNeedAltitude);
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
            if (this.LO.location_change_notify) {
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
            if (this.LO.coorType != null && !this.LO.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.LO.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.LO.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.LO.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0021a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0021a> it = this.c.iterator();
        while (it.hasNext()) {
            C0021a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0021a c0021a) {
        if (c0021a == null) {
            return;
        }
        if (a(c0021a.b) != null) {
            c0021a.a(14);
            return;
        }
        this.c.add(c0021a);
        c0021a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0021a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0021a next = it.next();
            if (next.LO.openGps) {
                z2 = true;
            }
            z = next.LO.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.ne().a(this.d);
        }
    }

    public static a mn() {
        if (LM == null) {
            LM = new a();
        }
        return LM;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0021a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.LN != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.LN.getLatitude(), this.LN.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.LN = null;
                this.LN = new BDLocation(bDLocation);
            } else {
                this.LN = new BDLocation(bDLocation);
            }
        }
        Iterator<C0021a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0021a next = it.next();
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
        this.LN = null;
        e();
    }

    public void b(Message message) {
        C0021a a = a(message.replyTo);
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
        C0021a c0021a = this.c.get(0);
        if (c0021a.LO.prodName != null) {
            stringBuffer.append(c0021a.LO.prodName);
        }
        if (c0021a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0021a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0021a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0021a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.LO.scanSpan;
        a.LO.scanSpan = message.getData().getInt("scanSpan", a.LO.scanSpan);
        if (a.LO.scanSpan < 1000) {
            com.baidu.location.c.h.mI().e();
            f.mq().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.mI().d();
            this.a = true;
        }
        if (a.LO.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.LO.mIsNeedDeviceDirect || a.LO.isNeedAltitude) {
            f.mq().a(a.LO.mIsNeedDeviceDirect);
            f.mq().b(a.LO.isNeedAltitude);
            f.mq().b();
        }
        a.LO.openGps = message.getData().getBoolean("openGPS", a.LO.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.LO;
        if (string == null || string.equals("")) {
            string = a.LO.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.LO;
        if (string2 == null || string2.equals("")) {
            string2 = a.LO.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.LO.addrType)) {
            e.mp().i();
        }
        a.LO.timeOut = message.getData().getInt("timeOut", a.LO.timeOut);
        a.LO.location_change_notify = message.getData().getBoolean("location_change_notify", a.LO.location_change_notify);
        a.LO.priority = message.getData().getInt("priority", a.LO.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0021a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.LO == null) {
            return 1;
        }
        return a.LO.priority;
    }

    public int f(Message message) {
        C0021a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.LO == null) {
            return 1000;
        }
        return a.LO.scanSpan;
    }
}
