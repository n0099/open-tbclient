package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.baidu.ar.util.SystemInfoUtil;
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
    private static a Vx = null;
    private ArrayList<C0064a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation Vy = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a {
        final /* synthetic */ a VA;
        public String a;
        public Messenger b;
        public LocationClientOption Vz = new LocationClientOption();
        public int d = 0;

        public C0064a(a aVar, Message message) {
            boolean z = true;
            this.VA = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.Vz.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.rf().a(this.Vz.prodName, this.a);
            this.Vz.coorType = message.getData().getString("coorType");
            this.Vz.addrType = message.getData().getString("addrType");
            this.Vz.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.Vz.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.Vz.addrType;
            }
            this.Vz.openGps = message.getData().getBoolean("openGPS");
            this.Vz.scanSpan = message.getData().getInt("scanSpan");
            this.Vz.timeOut = message.getData().getInt("timeOut");
            this.Vz.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.Vz.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.Vz.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.Vz.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.YF = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.Vz.scanSpan >= 1000) {
                com.baidu.location.c.h.qB().b();
            }
            if (this.Vz.mIsNeedDeviceDirect || this.Vz.isNeedAltitude) {
                f.qj().a(this.Vz.mIsNeedDeviceDirect);
                f.qj().b(this.Vz.isNeedAltitude);
                f.qj().b();
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
            if (this.Vz.location_change_notify) {
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
            if (f.qj().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.qj().qk());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.Vz.coorType != null && !this.Vz.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Vz.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.Vz.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.Vz.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0064a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0064a> it = this.c.iterator();
        while (it.hasNext()) {
            C0064a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0064a c0064a) {
        if (c0064a == null) {
            return;
        }
        if (a(c0064a.b) != null) {
            c0064a.a(14);
            return;
        }
        this.c.add(c0064a);
        c0064a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0064a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0064a next = it.next();
            if (next.Vz.openGps) {
                z2 = true;
            }
            z = next.Vz.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.qY().a(this.d);
        }
    }

    public static a qg() {
        if (Vx == null) {
            Vx = new a();
        }
        return Vx;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0064a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.Vy != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.Vy.getLatitude(), this.Vy.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.Vy = null;
                this.Vy = new BDLocation(bDLocation);
            } else {
                this.Vy = new BDLocation(bDLocation);
            }
        }
        Iterator<C0064a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0064a next = it.next();
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
        Address b = e.qi().b(bDLocation);
        String e = e.qi().e();
        List<Poi> f = e.qi().f();
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
        this.Vy = null;
        e();
    }

    public void b(Message message) {
        C0064a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.qB().c();
        f.qj().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + SystemInfoUtil.COLON + com.baidu.location.h.c.c;
        }
        C0064a c0064a = this.c.get(0);
        if (c0064a.Vz.prodName != null) {
            stringBuffer.append(c0064a.Vz.prodName);
        }
        if (c0064a.a != null) {
            stringBuffer.append(SystemInfoUtil.COLON);
            stringBuffer.append(c0064a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0064a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean f(Message message) {
        boolean z = true;
        C0064a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.Vz.scanSpan;
        a.Vz.scanSpan = message.getData().getInt("scanSpan", a.Vz.scanSpan);
        if (a.Vz.scanSpan < 1000) {
            com.baidu.location.c.h.qB().e();
            f.qj().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.qB().d();
            this.a = true;
        }
        if (a.Vz.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.Vz.mIsNeedDeviceDirect || a.Vz.isNeedAltitude) {
            f.qj().a(a.Vz.mIsNeedDeviceDirect);
            f.qj().b(a.Vz.isNeedAltitude);
            f.qj().b();
        }
        a.Vz.openGps = message.getData().getBoolean("openGPS", a.Vz.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.Vz;
        if (string == null || string.equals("")) {
            string = a.Vz.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.Vz;
        if (string2 == null || string2.equals("")) {
            string2 = a.Vz.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.Vz.addrType)) {
            e.qi().i();
        }
        a.Vz.timeOut = message.getData().getInt("timeOut", a.Vz.timeOut);
        a.Vz.location_change_notify = message.getData().getBoolean("location_change_notify", a.Vz.location_change_notify);
        a.Vz.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, a.Vz.priority);
        e();
        return z;
    }

    public int g(Message message) {
        C0064a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Vz == null) {
            return 1;
        }
        return a.Vz.priority;
    }

    public int h(Message message) {
        C0064a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Vz == null) {
            return 1000;
        }
        return a.Vz.scanSpan;
    }
}
