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
/* loaded from: classes2.dex */
public class a {
    private static a Vz = null;
    private ArrayList<C0065a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation VA = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0065a {
        final /* synthetic */ a VC;
        public String a;
        public Messenger b;
        public LocationClientOption VB = new LocationClientOption();
        public int d = 0;

        public C0065a(a aVar, Message message) {
            boolean z = true;
            this.VC = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.VB.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.rf().a(this.VB.prodName, this.a);
            this.VB.coorType = message.getData().getString("coorType");
            this.VB.addrType = message.getData().getString("addrType");
            this.VB.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.VB.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.VB.addrType;
            }
            this.VB.openGps = message.getData().getBoolean("openGPS");
            this.VB.scanSpan = message.getData().getInt("scanSpan");
            this.VB.timeOut = message.getData().getInt("timeOut");
            this.VB.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.VB.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.VB.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.VB.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.YI = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.VB.scanSpan >= 1000) {
                com.baidu.location.c.h.qB().b();
            }
            if (this.VB.mIsNeedDeviceDirect || this.VB.isNeedAltitude) {
                f.qj().a(this.VB.mIsNeedDeviceDirect);
                f.qj().b(this.VB.isNeedAltitude);
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
            if (this.VB.location_change_notify) {
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
            if (this.VB.coorType != null && !this.VB.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.VB.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.VB.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.VB.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0065a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0065a> it = this.c.iterator();
        while (it.hasNext()) {
            C0065a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0065a c0065a) {
        if (c0065a == null) {
            return;
        }
        if (a(c0065a.b) != null) {
            c0065a.a(14);
            return;
        }
        this.c.add(c0065a);
        c0065a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0065a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0065a next = it.next();
            if (next.VB.openGps) {
                z2 = true;
            }
            z = next.VB.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.qY().a(this.d);
        }
    }

    public static a qg() {
        if (Vz == null) {
            Vz = new a();
        }
        return Vz;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0065a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.VA != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.VA.getLatitude(), this.VA.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.VA = null;
                this.VA = new BDLocation(bDLocation);
            } else {
                this.VA = new BDLocation(bDLocation);
            }
        }
        Iterator<C0065a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0065a next = it.next();
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
        this.VA = null;
        e();
    }

    public void b(Message message) {
        C0065a a = a(message.replyTo);
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
        C0065a c0065a = this.c.get(0);
        if (c0065a.VB.prodName != null) {
            stringBuffer.append(c0065a.VB.prodName);
        }
        if (c0065a.a != null) {
            stringBuffer.append(SystemInfoUtil.COLON);
            stringBuffer.append(c0065a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0065a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean f(Message message) {
        boolean z = true;
        C0065a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.VB.scanSpan;
        a.VB.scanSpan = message.getData().getInt("scanSpan", a.VB.scanSpan);
        if (a.VB.scanSpan < 1000) {
            com.baidu.location.c.h.qB().e();
            f.qj().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.qB().d();
            this.a = true;
        }
        if (a.VB.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.VB.mIsNeedDeviceDirect || a.VB.isNeedAltitude) {
            f.qj().a(a.VB.mIsNeedDeviceDirect);
            f.qj().b(a.VB.isNeedAltitude);
            f.qj().b();
        }
        a.VB.openGps = message.getData().getBoolean("openGPS", a.VB.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.VB;
        if (string == null || string.equals("")) {
            string = a.VB.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.VB;
        if (string2 == null || string2.equals("")) {
            string2 = a.VB.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.VB.addrType)) {
            e.qi().i();
        }
        a.VB.timeOut = message.getData().getInt("timeOut", a.VB.timeOut);
        a.VB.location_change_notify = message.getData().getBoolean("location_change_notify", a.VB.location_change_notify);
        a.VB.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, a.VB.priority);
        e();
        return z;
    }

    public int g(Message message) {
        C0065a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.VB == null) {
            return 1;
        }
        return a.VB.priority;
    }

    public int h(Message message) {
        C0065a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.VB == null) {
            return 1000;
        }
        return a.VB.scanSpan;
    }
}
