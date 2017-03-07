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
    private static a Mr = null;
    private ArrayList<C0015a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation Ms = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0015a {
        final /* synthetic */ a Mu;
        public String a;
        public Messenger b;
        public LocationClientOption Mt = new LocationClientOption();
        public int d = 0;

        public C0015a(a aVar, Message message) {
            boolean z = true;
            this.Mu = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.Mt.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nv().a(this.Mt.prodName, this.a);
            this.Mt.coorType = message.getData().getString("coorType");
            this.Mt.addrType = message.getData().getString("addrType");
            this.Mt.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.Mt.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.Mt.addrType;
            }
            this.Mt.openGps = message.getData().getBoolean("openGPS");
            this.Mt.scanSpan = message.getData().getInt("scanSpan");
            this.Mt.timeOut = message.getData().getInt("timeOut");
            this.Mt.priority = message.getData().getInt("priority");
            this.Mt.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.Mt.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.Mt.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.Qe = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.Mt.scanSpan >= 1000) {
                com.baidu.location.c.h.mR().b();
            }
            if (this.Mt.mIsNeedDeviceDirect || this.Mt.isNeedAltitude) {
                f.mz().a(this.Mt.mIsNeedDeviceDirect);
                f.mz().b(this.Mt.isNeedAltitude);
                f.mz().b();
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
            if (this.Mt.location_change_notify) {
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
            if (f.mz().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.mz().mA());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.Mt.coorType != null && !this.Mt.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Mt.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.Mt.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.Mt.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0015a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0015a> it = this.c.iterator();
        while (it.hasNext()) {
            C0015a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0015a c0015a) {
        if (c0015a == null) {
            return;
        }
        if (a(c0015a.b) != null) {
            c0015a.a(14);
            return;
        }
        this.c.add(c0015a);
        c0015a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0015a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0015a next = it.next();
            if (next.Mt.openGps) {
                z2 = true;
            }
            z = next.Mt.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.no().a(this.d);
        }
    }

    public static a mw() {
        if (Mr == null) {
            Mr = new a();
        }
        return Mr;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0015a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.Ms != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.Ms.getLatitude(), this.Ms.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.Ms = null;
                this.Ms = new BDLocation(bDLocation);
            } else {
                this.Ms = new BDLocation(bDLocation);
            }
        }
        Iterator<C0015a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0015a next = it.next();
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
        Address b = e.my().b(bDLocation);
        String e = e.my().e();
        List<Poi> f = e.my().f();
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
        this.Ms = null;
        e();
    }

    public void b(Message message) {
        C0015a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.mR().c();
        f.mz().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0015a c0015a = this.c.get(0);
        if (c0015a.Mt.prodName != null) {
            stringBuffer.append(c0015a.Mt.prodName);
        }
        if (c0015a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0015a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0015a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0015a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.Mt.scanSpan;
        a.Mt.scanSpan = message.getData().getInt("scanSpan", a.Mt.scanSpan);
        if (a.Mt.scanSpan < 1000) {
            com.baidu.location.c.h.mR().e();
            f.mz().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.mR().d();
            this.a = true;
        }
        if (a.Mt.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.Mt.mIsNeedDeviceDirect || a.Mt.isNeedAltitude) {
            f.mz().a(a.Mt.mIsNeedDeviceDirect);
            f.mz().b(a.Mt.isNeedAltitude);
            f.mz().b();
        }
        a.Mt.openGps = message.getData().getBoolean("openGPS", a.Mt.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.Mt;
        if (string == null || string.equals("")) {
            string = a.Mt.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.Mt;
        if (string2 == null || string2.equals("")) {
            string2 = a.Mt.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.Mt.addrType)) {
            e.my().i();
        }
        a.Mt.timeOut = message.getData().getInt("timeOut", a.Mt.timeOut);
        a.Mt.location_change_notify = message.getData().getBoolean("location_change_notify", a.Mt.location_change_notify);
        a.Mt.priority = message.getData().getInt("priority", a.Mt.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0015a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Mt == null) {
            return 1;
        }
        return a.Mt.priority;
    }

    public int f(Message message) {
        C0015a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Mt == null) {
            return 1000;
        }
        return a.Mt.scanSpan;
    }
}
