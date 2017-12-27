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
    private static a azE = null;
    private ArrayList<C0037a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation azF = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a {
        public String a;
        final /* synthetic */ a azH;
        public Messenger b;
        public LocationClientOption azG = new LocationClientOption();
        public int d = 0;

        public C0037a(a aVar, Message message) {
            boolean z = true;
            this.azH = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.azG.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.uA().a(this.azG.prodName, this.a);
            this.azG.coorType = message.getData().getString("coorType");
            this.azG.addrType = message.getData().getString("addrType");
            this.azG.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.azG.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.azG.addrType;
            }
            this.azG.openGps = message.getData().getBoolean("openGPS");
            this.azG.scanSpan = message.getData().getInt("scanSpan");
            this.azG.timeOut = message.getData().getInt("timeOut");
            this.azG.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.azG.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.azG.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.azG.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.aDn = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.azG.scanSpan >= 1000) {
                com.baidu.location.c.h.tW().b();
            }
            if (this.azG.mIsNeedDeviceDirect || this.azG.isNeedAltitude) {
                f.tB().a(this.azG.mIsNeedDeviceDirect);
                f.tB().b(this.azG.isNeedAltitude);
                f.tB().b();
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
            if (this.azG.location_change_notify) {
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
            if (f.tB().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.tB().tE());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.azG.coorType != null && !this.azG.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.azG.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.azG.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.azG.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private void a(C0037a c0037a) {
        if (c0037a == null) {
            return;
        }
        if (f(c0037a.b) != null) {
            c0037a.a(14);
            return;
        }
        this.c.add(c0037a);
        c0037a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private C0037a f(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0037a> it = this.c.iterator();
        while (it.hasNext()) {
            C0037a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void f() {
        Iterator<C0037a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0037a next = it.next();
            if (next.azG.openGps) {
                z2 = true;
            }
            z = next.azG.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.ut().a(this.d);
        }
    }

    public static a ty() {
        if (azE == null) {
            azE = new a();
        }
        return azE;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0037a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.azF != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.azF.getLatitude(), this.azF.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.azF = null;
                this.azF = new BDLocation(bDLocation);
            } else {
                this.azF = new BDLocation(bDLocation);
            }
        }
        Iterator<C0037a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0037a next = it.next();
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
        Address b = e.tA().b(bDLocation);
        String e = e.tA().e();
        List<Poi> f = e.tA().f();
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
        this.azF = null;
        e();
    }

    public void b(Message message) {
        C0037a f = f(message.replyTo);
        if (f != null) {
            this.c.remove(f);
        }
        com.baidu.location.c.h.tW().c();
        f.tB().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0037a c0037a = this.c.get(0);
        if (c0037a.azG.prodName != null) {
            stringBuffer.append(c0037a.azG.prodName);
        }
        if (c0037a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0037a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0037a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0037a f = f(message.replyTo);
        if (f == null) {
            return false;
        }
        int i = f.azG.scanSpan;
        f.azG.scanSpan = message.getData().getInt("scanSpan", f.azG.scanSpan);
        if (f.azG.scanSpan < 1000) {
            com.baidu.location.c.h.tW().e();
            f.tB().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.tW().d();
            this.a = true;
        }
        if (f.azG.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (f.azG.mIsNeedDeviceDirect || f.azG.isNeedAltitude) {
            f.tB().a(f.azG.mIsNeedDeviceDirect);
            f.tB().b(f.azG.isNeedAltitude);
            f.tB().b();
        }
        f.azG.openGps = message.getData().getBoolean("openGPS", f.azG.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = f.azG;
        if (string == null || string.equals("")) {
            string = f.azG.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = f.azG;
        if (string2 == null || string2.equals("")) {
            string2 = f.azG.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(f.azG.addrType)) {
            e.tA().i();
        }
        f.azG.timeOut = message.getData().getInt("timeOut", f.azG.timeOut);
        f.azG.location_change_notify = message.getData().getBoolean("location_change_notify", f.azG.location_change_notify);
        f.azG.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, f.azG.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0037a f;
        if (message == null || message.replyTo == null || (f = f(message.replyTo)) == null || f.azG == null) {
            return 1;
        }
        return f.azG.priority;
    }

    public int f(Message message) {
        C0037a f;
        if (message == null || message.replyTo == null || (f = f(message.replyTo)) == null || f.azG == null) {
            return 1000;
        }
        return f.azG.scanSpan;
    }
}
