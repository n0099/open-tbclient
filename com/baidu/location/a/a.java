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
    private static a Nr = null;
    private ArrayList<C0048a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation Ns = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a {
        final /* synthetic */ a Nu;
        public String a;
        public Messenger b;
        public LocationClientOption Nt = new LocationClientOption();
        public int d = 0;

        public C0048a(a aVar, Message message) {
            boolean z = true;
            this.Nu = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.Nt.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nT().a(this.Nt.prodName, this.a);
            this.Nt.coorType = message.getData().getString("coorType");
            this.Nt.addrType = message.getData().getString("addrType");
            this.Nt.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.Nt.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.Nt.addrType;
            }
            this.Nt.openGps = message.getData().getBoolean("openGPS");
            this.Nt.scanSpan = message.getData().getInt("scanSpan");
            this.Nt.timeOut = message.getData().getInt("timeOut");
            this.Nt.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.Nt.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.Nt.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.Nt.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.QK = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.Nt.scanSpan >= 1000) {
                com.baidu.location.c.h.np().b();
            }
            if (this.Nt.mIsNeedDeviceDirect || this.Nt.isNeedAltitude) {
                f.mW().a(this.Nt.mIsNeedDeviceDirect);
                f.mW().b(this.Nt.isNeedAltitude);
                f.mW().b();
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
            if (this.Nt.location_change_notify) {
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
            if (f.mW().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.mW().mX());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.Nt.coorType != null && !this.Nt.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Nt.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.Nt.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.Nt.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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
            if (next.Nt.openGps) {
                z2 = true;
            }
            z = next.Nt.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.nM().a(this.d);
        }
    }

    public static a mT() {
        if (Nr == null) {
            Nr = new a();
        }
        return Nr;
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
            if (this.Ns != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.Ns.getLatitude(), this.Ns.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.Ns = null;
                this.Ns = new BDLocation(bDLocation);
            } else {
                this.Ns = new BDLocation(bDLocation);
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
        Address b = e.mV().b(bDLocation);
        String e = e.mV().e();
        List<Poi> f = e.mV().f();
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
        this.Ns = null;
        e();
    }

    public void b(Message message) {
        C0048a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.np().c();
        f.mW().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0048a c0048a = this.c.get(0);
        if (c0048a.Nt.prodName != null) {
            stringBuffer.append(c0048a.Nt.prodName);
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
        int i = a.Nt.scanSpan;
        a.Nt.scanSpan = message.getData().getInt("scanSpan", a.Nt.scanSpan);
        if (a.Nt.scanSpan < 1000) {
            com.baidu.location.c.h.np().e();
            f.mW().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.np().d();
            this.a = true;
        }
        if (a.Nt.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.Nt.mIsNeedDeviceDirect || a.Nt.isNeedAltitude) {
            f.mW().a(a.Nt.mIsNeedDeviceDirect);
            f.mW().b(a.Nt.isNeedAltitude);
            f.mW().b();
        }
        a.Nt.openGps = message.getData().getBoolean("openGPS", a.Nt.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.Nt;
        if (string == null || string.equals("")) {
            string = a.Nt.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.Nt;
        if (string2 == null || string2.equals("")) {
            string2 = a.Nt.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.Nt.addrType)) {
            e.mV().i();
        }
        a.Nt.timeOut = message.getData().getInt("timeOut", a.Nt.timeOut);
        a.Nt.location_change_notify = message.getData().getBoolean("location_change_notify", a.Nt.location_change_notify);
        a.Nt.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, a.Nt.priority);
        e();
        return z;
    }

    public int g(Message message) {
        C0048a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Nt == null) {
            return 1;
        }
        return a.Nt.priority;
    }

    public int h(Message message) {
        C0048a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.Nt == null) {
            return 1000;
        }
        return a.Nt.scanSpan;
    }
}
