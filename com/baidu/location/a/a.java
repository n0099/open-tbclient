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
    private static a MF = null;
    private ArrayList<C0014a> c;
    private boolean d = false;
    public boolean a = false;
    private BDLocation MG = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0014a {
        final /* synthetic */ a MI;
        public String a;
        public Messenger b;
        public LocationClientOption MH = new LocationClientOption();
        public int d = 0;

        public C0014a(a aVar, Message message) {
            boolean z = true;
            this.MI = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.MH.prodName = message.getData().getString("prodName");
            com.baidu.location.h.c.nP().a(this.MH.prodName, this.a);
            this.MH.coorType = message.getData().getString("coorType");
            this.MH.addrType = message.getData().getString("addrType");
            this.MH.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.h.i.k = com.baidu.location.h.i.k || this.MH.enableSimulateGps;
            if (!com.baidu.location.h.i.f.equals("all")) {
                com.baidu.location.h.i.f = this.MH.addrType;
            }
            this.MH.openGps = message.getData().getBoolean("openGPS");
            this.MH.scanSpan = message.getData().getInt("scanSpan");
            this.MH.timeOut = message.getData().getInt("timeOut");
            this.MH.priority = message.getData().getInt("priority");
            this.MH.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.MH.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.MH.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.h.i.g = com.baidu.location.h.i.g || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.h.i.h && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.h.i.h = z;
            com.baidu.location.h.i.Qp = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
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
            if (this.MH.scanSpan >= 1000) {
                com.baidu.location.c.h.nk().b();
            }
            if (this.MH.mIsNeedDeviceDirect || this.MH.isNeedAltitude) {
                f.mS().a(this.MH.mIsNeedDeviceDirect);
                f.mS().b(this.MH.isNeedAltitude);
                f.mS().b();
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
            if (this.MH.location_change_notify) {
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
            if (f.mS().g() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(f.mS().mT());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.MH.coorType != null && !this.MH.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.MH.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.MH.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.MH.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    private C0014a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator<C0014a> it = this.c.iterator();
        while (it.hasNext()) {
            C0014a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0014a c0014a) {
        if (c0014a == null) {
            return;
        }
        if (a(c0014a.b) != null) {
            c0014a.a(14);
            return;
        }
        this.c.add(c0014a);
        c0014a.a(13);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0014a> it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0014a next = it.next();
            if (next.MH.openGps) {
                z2 = true;
            }
            z = next.MH.location_change_notify ? true : z;
        }
        com.baidu.location.h.i.a = z;
        if (this.d != z2) {
            this.d = z2;
            com.baidu.location.f.f.nI().a(this.d);
        }
    }

    public static a mP() {
        if (MF == null) {
            MF = new a();
        }
        return MF;
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        this.a = true;
        a(new C0014a(this, message));
        e();
    }

    public void a(BDLocation bDLocation) {
        boolean z = e.h;
        if (z) {
            e.h = false;
        }
        if (com.baidu.location.h.i.T >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.MG != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.MG.getLatitude(), this.MG.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] <= com.baidu.location.h.i.V && !z) {
                    return;
                }
                this.MG = null;
                this.MG = new BDLocation(bDLocation);
            } else {
                this.MG = new BDLocation(bDLocation);
            }
        }
        Iterator<C0014a> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                C0014a next = it.next();
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
        Address b = e.mR().b(bDLocation);
        String e = e.mR().e();
        List<Poi> f = e.mR().f();
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
        this.MG = null;
        e();
    }

    public void b(Message message) {
        C0014a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        com.baidu.location.c.h.nk().c();
        f.mS().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c;
        }
        C0014a c0014a = this.c.get(0);
        if (c0014a.MH.prodName != null) {
            stringBuffer.append(c0014a.MH.prodName);
        }
        if (c0014a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0014a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void d() {
        Iterator<C0014a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean d(Message message) {
        boolean z = true;
        C0014a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.MH.scanSpan;
        a.MH.scanSpan = message.getData().getInt("scanSpan", a.MH.scanSpan);
        if (a.MH.scanSpan < 1000) {
            com.baidu.location.c.h.nk().e();
            f.mS().c();
            this.a = false;
        } else {
            com.baidu.location.c.h.nk().d();
            this.a = true;
        }
        if (a.MH.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (a.MH.mIsNeedDeviceDirect || a.MH.isNeedAltitude) {
            f.mS().a(a.MH.mIsNeedDeviceDirect);
            f.mS().b(a.MH.isNeedAltitude);
            f.mS().b();
        }
        a.MH.openGps = message.getData().getBoolean("openGPS", a.MH.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.MH;
        if (string == null || string.equals("")) {
            string = a.MH.coorType;
        }
        locationClientOption.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.MH;
        if (string2 == null || string2.equals("")) {
            string2 = a.MH.addrType;
        }
        locationClientOption2.addrType = string2;
        if (!com.baidu.location.h.i.f.equals(a.MH.addrType)) {
            e.mR().i();
        }
        a.MH.timeOut = message.getData().getInt("timeOut", a.MH.timeOut);
        a.MH.location_change_notify = message.getData().getBoolean("location_change_notify", a.MH.location_change_notify);
        a.MH.priority = message.getData().getInt("priority", a.MH.priority);
        e();
        return z;
    }

    public int e(Message message) {
        C0014a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.MH == null) {
            return 1;
        }
        return a.MH.priority;
    }

    public int f(Message message) {
        C0014a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.MH == null) {
            return 1000;
        }
        return a.MH.scanSpan;
    }
}
