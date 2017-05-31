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
    private static a LN = null;
    private ArrayList<C0019a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation LO = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0019a {
        final /* synthetic */ a LQ;
        public String a;
        public Messenger b;
        public LocationClientOption LP = new LocationClientOption();
        public int d = 0;

        public C0019a(a aVar, Message message) {
            boolean z = true;
            this.LQ = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.LP.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.np().a(this.LP.prodName, this.a);
            this.LP.coorType = message.getData().getString("coorType");
            this.LP.addrType = message.getData().getString("addrType");
            this.LP.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.LP.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.LP.addrType;
            }
            this.LP.openGps = message.getData().getBoolean("openGPS");
            this.LP.scanSpan = message.getData().getInt("scanSpan");
            this.LP.timeOut = message.getData().getInt("timeOut");
            this.LP.priority = message.getData().getInt("priority");
            this.LP.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.LP.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.LP.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.Pw = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.LP.scanSpan >= 1000) {
                com.baidu.location.c.h.mK().b();
            }
            if (this.LP.mIsNeedDeviceDirect || this.LP.isNeedAltitude) {
                f.ms().a(this.LP.mIsNeedDeviceDirect);
                f.ms().b(this.LP.isNeedAltitude);
                f.ms().b();
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
            if (this.LP.location_change_notify) {
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
            if (f.ms().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.ms().mt());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.LP.coorType != null && !this.LP.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.LP.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.LP.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.LP.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0019a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0019a> it = this.c.iterator();
        while (it.hasNext()) {
            C0019a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0019a c0019a) {
        if (c0019a == null) {
            return;
        }
        if (a(c0019a.b) != null) {
            c0019a.a(14);
            return;
        }
        this.c.add(c0019a);
        c0019a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0019a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0019a next = it.next();
            if (next.LP.openGps) {
                z2 = true;
            }
            z = next.LP.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.ni().a(this.d);
        }
    }

    public static a mp() {
        if (LN == null) {
            LN = new a();
        }
        return LN;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0019a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.LO != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.LO.getLatitude(), this.LO.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.LO = null;
                this.LO = new BDLocation(bDLocation);
            } else {
                this.LO = new BDLocation(bDLocation);
            }
        }
        Iterator<C0019a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0019a next = it.next();
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
        Address b = e.mr().b(bDLocation);
        String e = e.mr().e();
        List<Poi> f = e.mr().f();
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
        this.LO = null;
        e();
    }

    public void b(Message message) {
        C0019a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.mK().c();
        f.ms().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0019a c0019a = this.c.get(0);
        if (c0019a.LP.prodName != null) {
            stringBuffer.append(c0019a.LP.prodName);
        }
        if (c0019a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0019a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0019a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0019a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.LP.scanSpan;
        a.LP.scanSpan = message.getData().getInt("scanSpan", a.LP.scanSpan);
        if (a.LP.scanSpan < 1000) {
            com.baidu.location.c.h.mK().e();
            f.ms().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.mK().d();
            this.a = true;
        }
        if (a.LP.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.LP.mIsNeedDeviceDirect || a.LP.isNeedAltitude) {
            f.ms().a(a.LP.mIsNeedDeviceDirect);
            f.ms().b(a.LP.isNeedAltitude);
            f.ms().b();
        }
        a.LP.openGps = message.getData().getBoolean("openGPS", a.LP.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.LP;
        if (string == null || string.equals("")) {
            string = a.LP.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.LP;
        if (string2 == null || string2.equals("")) {
            string2 = a.LP.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.LP.addrType)) {
            e.mr().i();
        }
        a.LP.timeOut = message.getData().getInt("timeOut", a.LP.timeOut);
        a.LP.location_change_notify = message.getData().getBoolean("location_change_notify", a.LP.location_change_notify);
        a.LP.priority = message.getData().getInt("priority", a.LP.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0019a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.LP == null) {
            return 1;
        }
        return a.LP.priority;
    }

    public int f(Message message) {
        C0019a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.LP == null) {
            return 1000;
        }
        return a.LP.scanSpan;
    }
}
