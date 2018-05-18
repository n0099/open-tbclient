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
    private static a Nn = null;
    private ArrayList<C0048a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation No = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a {
        final /* synthetic */ a Nq;
        public String a;
        public Messenger b;
        public LocationClientOption Np = new LocationClientOption();
        public int d = 0;

        public C0048a(a aVar, Message message) {
            boolean z = true;
            this.Nq = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.Np.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nS().a(this.Np.prodName, this.a);
            this.Np.coorType = message.getData().getString("coorType");
            this.Np.addrType = message.getData().getString("addrType");
            this.Np.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.Np.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.Np.addrType;
            }
            this.Np.openGps = message.getData().getBoolean("openGPS");
            this.Np.scanSpan = message.getData().getInt("scanSpan");
            this.Np.timeOut = message.getData().getInt("timeOut");
            this.Np.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.Np.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.Np.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.Np.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.QG = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.Np.scanSpan >= 1000) {
                com.baidu.location.c.h.no().b();
            }
            if (this.Np.mIsNeedDeviceDirect || this.Np.isNeedAltitude) {
                f.mV().a(this.Np.mIsNeedDeviceDirect);
                f.mV().b(this.Np.isNeedAltitude);
                f.mV().b();
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
            if (this.Np.location_change_notify) {
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
            if (f.mV().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.mV().mW());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.Np.coorType != null && !this.Np.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Np.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.Np.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.Np.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0048a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0048a> it = this.c.iterator();
        while (it.hasNext()) {
            C0048a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0048a c0048a) {
        if (c0048a == null) {
            return;
        }
        if (a(c0048a.b) != null) {
            c0048a.a(14);
            return;
        }
        this.c.add(c0048a);
        c0048a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0048a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0048a next = it.next();
            if (next.Np.openGps) {
                z2 = true;
            }
            z = next.Np.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.nL().a(this.d);
        }
    }

    public static a mS() {
        if (Nn == null) {
            Nn = new a();
        }
        return Nn;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0048a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.No != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.No.getLatitude(), this.No.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.No = null;
                this.No = new BDLocation(bDLocation);
            } else {
                this.No = new BDLocation(bDLocation);
            }
        }
        Iterator<C0048a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0048a next = it.next();
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
        Address b = e.mU().b(bDLocation);
        String e = e.mU().e();
        List<Poi> f = e.mU().f();
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
        this.No = null;
        e();
    }

    public void b(Message message) {
        C0048a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.no().c();
        f.mV().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0048a c0048a = this.c.get(0);
        if (c0048a.Np.prodName != null) {
            stringBuffer.append(c0048a.Np.prodName);
        }
        if (c0048a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0048a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0048a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean f(Message message) {
        boolean z = true;
        C0048a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.Np.scanSpan;
        a.Np.scanSpan = message.getData().getInt("scanSpan", a.Np.scanSpan);
        if (a.Np.scanSpan < 1000) {
            com.baidu.location.c.h.no().e();
            f.mV().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.no().d();
            this.a = true;
        }
        if (a.Np.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.Np.mIsNeedDeviceDirect || a.Np.isNeedAltitude) {
            f.mV().a(a.Np.mIsNeedDeviceDirect);
            f.mV().b(a.Np.isNeedAltitude);
            f.mV().b();
        }
        a.Np.openGps = message.getData().getBoolean("openGPS", a.Np.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.Np;
        if (string == null || string.equals("")) {
            string = a.Np.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.Np;
        if (string2 == null || string2.equals("")) {
            string2 = a.Np.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.Np.addrType)) {
            e.mU().i();
        }
        a.Np.timeOut = message.getData().getInt("timeOut", a.Np.timeOut);
        a.Np.location_change_notify = message.getData().getBoolean("location_change_notify", a.Np.location_change_notify);
        a.Np.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, a.Np.priority);
        e();
        return z;
    }

    public int g(Message message) {
        C0048a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Np == null) {
            return 1;
        }
        return a.Np.priority;
    }

    public int h(Message message) {
        C0048a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Np == null) {
            return 1000;
        }
        return a.Np.scanSpan;
    }
}
