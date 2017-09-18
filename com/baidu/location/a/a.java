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
    private static a KN = null;
    private ArrayList<C0023a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation KO = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0023a {
        final /* synthetic */ a KQ;
        public String a;
        public Messenger b;
        public LocationClientOption KP = new LocationClientOption();
        public int d = 0;

        public C0023a(a aVar, Message message) {
            boolean z = true;
            this.KQ = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.KP.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nf().a(this.KP.prodName, this.a);
            this.KP.coorType = message.getData().getString("coorType");
            this.KP.addrType = message.getData().getString("addrType");
            this.KP.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.KP.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.KP.addrType;
            }
            this.KP.openGps = message.getData().getBoolean("openGPS");
            this.KP.scanSpan = message.getData().getInt("scanSpan");
            this.KP.timeOut = message.getData().getInt("timeOut");
            this.KP.priority = message.getData().getInt("priority");
            this.KP.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.KP.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.KP.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.OD = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i >= com.baidu.location.h.i.T) {
                com.baidu.location.h.i.T = i;
            }
            int i2 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i2 >= com.baidu.location.h.i.OG) {
                com.baidu.location.h.i.OG = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i3 >= com.baidu.location.h.i.U) {
                com.baidu.location.h.i.U = i3;
            }
            if (this.KP.scanSpan >= 1000) {
                com.baidu.location.c.h.mA().b();
            }
            if (this.KP.mIsNeedDeviceDirect || this.KP.isNeedAltitude) {
                f.mf().a(this.KP.mIsNeedDeviceDirect);
                f.mf().b(this.KP.isNeedAltitude);
                f.mf().b();
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
            if (this.KP.location_change_notify) {
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
            if (f.mf().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.mf().mi());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.KP.coorType != null && !this.KP.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.KP.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.KP.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.KP.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0023a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0023a> it = this.c.iterator();
        while (it.hasNext()) {
            C0023a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0023a c0023a) {
        if (c0023a == null) {
            return;
        }
        if (a(c0023a.b) != null) {
            c0023a.a(14);
            return;
        }
        this.c.add(c0023a);
        c0023a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0023a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0023a next = it.next();
            if (next.KP.openGps) {
                z2 = true;
            }
            z = next.KP.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.mY().a(this.d);
        }
    }

    public static a mc() {
        if (KN == null) {
            KN = new a();
        }
        return KN;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0023a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.KO != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.KO.getLatitude(), this.KO.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.OG && !z) {
                    return;
                }
                this.KO = null;
                this.KO = new BDLocation(bDLocation);
            } else {
                this.KO = new BDLocation(bDLocation);
            }
        }
        Iterator<C0023a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0023a next = it.next();
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
        Address b = e.me().b(bDLocation);
        String e = e.me().e();
        List<Poi> f = e.me().f();
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
        this.KO = null;
        e();
    }

    public void b(Message message) {
        C0023a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.mA().c();
        f.mf().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0023a c0023a = this.c.get(0);
        if (c0023a.KP.prodName != null) {
            stringBuffer.append(c0023a.KP.prodName);
        }
        if (c0023a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0023a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0023a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0023a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.KP.scanSpan;
        a.KP.scanSpan = message.getData().getInt("scanSpan", a.KP.scanSpan);
        if (a.KP.scanSpan < 1000) {
            com.baidu.location.c.h.mA().e();
            f.mf().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.mA().d();
            this.a = true;
        }
        if (a.KP.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.KP.mIsNeedDeviceDirect || a.KP.isNeedAltitude) {
            f.mf().a(a.KP.mIsNeedDeviceDirect);
            f.mf().b(a.KP.isNeedAltitude);
            f.mf().b();
        }
        a.KP.openGps = message.getData().getBoolean("openGPS", a.KP.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.KP;
        if (string == null || string.equals("")) {
            string = a.KP.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.KP;
        if (string2 == null || string2.equals("")) {
            string2 = a.KP.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.KP.addrType)) {
            e.me().i();
        }
        a.KP.timeOut = message.getData().getInt("timeOut", a.KP.timeOut);
        a.KP.location_change_notify = message.getData().getBoolean("location_change_notify", a.KP.location_change_notify);
        a.KP.priority = message.getData().getInt("priority", a.KP.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0023a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.KP == null) {
            return 1;
        }
        return a.KP.priority;
    }

    public int f(Message message) {
        C0023a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.KP == null) {
            return 1000;
        }
        return a.KP.scanSpan;
    }
}
