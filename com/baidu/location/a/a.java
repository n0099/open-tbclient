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
import org.apache.commons.logging.LogFactory;
/* loaded from: classes.dex */
public class a {
    private static a aBk = null;
    private ArrayList<C0059a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation aBl = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059a {
        public String a;
        final /* synthetic */ a aBn;
        public Messenger b;
        public LocationClientOption aBm = new LocationClientOption();
        public int d = 0;

        public C0059a(a aVar, Message message) {
            boolean z = true;
            this.aBn = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.aBm.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.vn().a(this.aBm.prodName, this.a);
            this.aBm.coorType = message.getData().getString("coorType");
            this.aBm.addrType = message.getData().getString("addrType");
            this.aBm.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.aBm.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.aBm.addrType;
            }
            this.aBm.openGps = message.getData().getBoolean("openGPS");
            this.aBm.scanSpan = message.getData().getInt("scanSpan");
            this.aBm.timeOut = message.getData().getInt("timeOut");
            this.aBm.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.aBm.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.aBm.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.aBm.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.aEM = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.aBm.scanSpan >= 1000) {
                com.baidu.location.c.h.uJ().b();
            }
            if (this.aBm.mIsNeedDeviceDirect || this.aBm.isNeedAltitude) {
                f.uq().a(this.aBm.mIsNeedDeviceDirect);
                f.uq().b(this.aBm.isNeedAltitude);
                f.uq().b();
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
            if (this.aBm.location_change_notify) {
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
            if (f.uq().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.uq().ur());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.aBm.coorType != null && !this.aBm.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.aBm.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.aBm.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.aBm.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private void a(C0059a c0059a) {
        if (c0059a == null) {
            return;
        }
        if (f(c0059a.b) != null) {
            c0059a.a(14);
            return;
        }
        this.c.add(c0059a);
        c0059a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private C0059a f(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0059a> it = this.c.iterator();
        while (it.hasNext()) {
            C0059a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void f() {
        Iterator<C0059a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0059a next = it.next();
            if (next.aBm.openGps) {
                z2 = true;
            }
            z = next.aBm.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.vg().a(this.d);
        }
    }

    public static a un() {
        if (aBk == null) {
            aBk = new a();
        }
        return aBk;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0059a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.aBl != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.aBl.getLatitude(), this.aBl.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.aBl = null;
                this.aBl = new BDLocation(bDLocation);
            } else {
                this.aBl = new BDLocation(bDLocation);
            }
        }
        Iterator<C0059a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0059a next = it.next();
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
        Address b = e.up().b(bDLocation);
        String e = e.up().e();
        List<Poi> f = e.up().f();
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
        this.aBl = null;
        e();
    }

    public void b(Message message) {
        C0059a f = f(message.replyTo);
        if (f != null) {
            this.c.remove(f);
        }
        com.baidu.location.c.h.uJ().c();
        f.uq().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0059a c0059a = this.c.get(0);
        if (c0059a.aBm.prodName != null) {
            stringBuffer.append(c0059a.aBm.prodName);
        }
        if (c0059a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0059a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0059a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean f(Message message) {
        boolean z = true;
        C0059a f = f(message.replyTo);
        if (f == null) {
            return false;
        }
        int i = f.aBm.scanSpan;
        f.aBm.scanSpan = message.getData().getInt("scanSpan", f.aBm.scanSpan);
        if (f.aBm.scanSpan < 1000) {
            com.baidu.location.c.h.uJ().e();
            f.uq().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.uJ().d();
            this.a = true;
        }
        if (f.aBm.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (f.aBm.mIsNeedDeviceDirect || f.aBm.isNeedAltitude) {
            f.uq().a(f.aBm.mIsNeedDeviceDirect);
            f.uq().b(f.aBm.isNeedAltitude);
            f.uq().b();
        }
        f.aBm.openGps = message.getData().getBoolean("openGPS", f.aBm.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = f.aBm;
        if (string == null || string.equals("")) {
            string = f.aBm.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = f.aBm;
        if (string2 == null || string2.equals("")) {
            string2 = f.aBm.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(f.aBm.addrType)) {
            e.up().i();
        }
        f.aBm.timeOut = message.getData().getInt("timeOut", f.aBm.timeOut);
        f.aBm.location_change_notify = message.getData().getBoolean("location_change_notify", f.aBm.location_change_notify);
        f.aBm.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, f.aBm.priority);
        e();
        return z;
    }

    public int g(Message message) {
        C0059a f;
        if (message == null || message.replyTo == null || (f = f(message.replyTo)) == null || f.aBm == null) {
            return 1;
        }
        return f.aBm.priority;
    }

    public int h(Message message) {
        C0059a f;
        if (message == null || message.replyTo == null || (f = f(message.replyTo)) == null || f.aBm == null) {
            return 1000;
        }
        return f.aBm.scanSpan;
    }
}
