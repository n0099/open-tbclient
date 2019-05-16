package com.baidu.location.a;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<C0042a> f;
    private static a e = null;
    public static long c = 0;
    private boolean g = false;
    public boolean a = false;
    boolean b = false;
    private BDLocation h = null;
    private BDLocation i = null;
    int d = 0;
    private BDLocation j = null;
    private boolean k = false;
    private boolean l = false;
    private b m = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0042a {
        public String a;
        public Messenger b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;
        final /* synthetic */ a e;

        public C0042a(a aVar, Message message) {
            boolean z = false;
            this.e = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.g.b.a().a(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.g.g.m = com.baidu.location.g.g.m || this.c.enableSimulateGps;
            if (!com.baidu.location.g.g.g.equals("all")) {
                com.baidu.location.g.g.g = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.g.g.i = com.baidu.location.g.g.i || this.c.isNeedNewVersionRgc;
            com.baidu.location.g.g.h = com.baidu.location.g.g.h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.g.g.j = com.baidu.location.g.g.j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.g.g.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i < com.baidu.location.g.g.af) {
                com.baidu.location.g.g.af = i;
            }
            int i2 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i2 >= com.baidu.location.g.g.W) {
                com.baidu.location.g.g.W = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i3 >= com.baidu.location.g.g.Y) {
                com.baidu.location.g.g.Y = i3;
            }
            int i4 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i4 >= com.baidu.location.g.g.X) {
                com.baidu.location.g.g.X = i4;
            }
            if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
                l.a().a(this.c.mIsNeedDeviceDirect);
                l.a().b();
            }
            aVar.b = (aVar.b || this.c.isNeedAltitude) ? true : z;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
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
                e.printStackTrace();
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
            if (this.c.location_change_notify) {
                if (com.baidu.location.g.g.b) {
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
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.c.coorType != null && !this.c.coorType.equals(CoordinateType.GCJ02)) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.GCJ02)) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.c.coorType);
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.WGS84) && !this.c.coorType.equals("bd09ll")) {
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

    /* loaded from: classes3.dex */
    private class b implements Runnable {
        final /* synthetic */ a a;
        private int b;
        private boolean c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.b++;
            this.a.l = false;
        }
    }

    private a() {
        this.f = null;
        this.f = new ArrayList<>();
    }

    private C0042a a(Messenger messenger) {
        if (this.f == null) {
            return null;
        }
        Iterator<C0042a> it = this.f.iterator();
        while (it.hasNext()) {
            C0042a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    public static a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    private void a(C0042a c0042a) {
        if (c0042a == null) {
            return;
        }
        if (a(c0042a.b) != null) {
            c0042a.a(14);
            return;
        }
        this.f.add(c0042a);
        c0042a.a(13);
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.g.b.d);
        intent.putExtra("tag", WXLoginActivity.KEY_BASE_RESP_STATE);
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0042a> it = this.f.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0042a next = it.next();
            if (next.c.openGps) {
                z2 = true;
            }
            z = next.c.location_change_notify ? true : z;
        }
        com.baidu.location.g.g.a = z;
        if (this.g != z2) {
            this.g = z2;
            com.baidu.location.e.d.a().a(this.g);
        }
    }

    public void a(Bundle bundle, int i) {
        Iterator<C0042a> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                C0042a next = it.next();
                next.a(i, bundle);
                if (next.d > 4) {
                    it.remove();
                }
            } catch (Exception e2) {
                return;
            }
        }
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        c = System.currentTimeMillis();
        this.a = true;
        com.baidu.location.e.f.a().b();
        a(new C0042a(this, message));
        e();
        if (this.k) {
            b(IntentConfig.START);
            this.d = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        if (com.baidu.location.g.g.a(com.baidu.location.f.getServiceContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            b(bDLocation);
            return;
        }
        BDLocation bDLocation2 = new BDLocation();
        bDLocation2.setLocType(62);
        b(bDLocation2);
    }

    public void a(String str) {
        c(new BDLocation(str));
    }

    public void b() {
        this.f.clear();
        this.h = null;
        e();
    }

    public void b(Message message) {
        C0042a a = a(message.replyTo);
        if (a != null) {
            this.f.remove(a);
        }
        l.a().c();
        e();
        if (this.k) {
            b(IntentConfig.STOP);
            this.d = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        if (bDLocation == null || bDLocation.getLocType() != 161 || i.a().b()) {
            if (!bDLocation.hasAltitude() && this.b && (bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
                double d = com.baidu.location.b.a.a().a(bDLocation.getLongitude(), bDLocation.getLatitude())[0];
                com.baidu.location.b.a.a();
                if (d < 10000.0d - 1.0d) {
                    bDLocation.setAltitude(d);
                }
            }
            if (bDLocation.getLocType() == 61) {
                bDLocation.setGpsAccuracyStatus(com.baidu.location.b.a.a().a(bDLocation));
            }
            Iterator<C0042a> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    C0042a next = it.next();
                    next.a(bDLocation);
                    if (next.d > 4) {
                        it.remove();
                    }
                } catch (Exception e2) {
                }
            }
        } else {
            if (this.i == null) {
                this.i = new BDLocation();
                this.i.setLocType(505);
            }
            Iterator<C0042a> it2 = this.f.iterator();
            while (it2.hasNext()) {
                try {
                    C0042a next2 = it2.next();
                    next2.a(this.i);
                    if (next2.d > 4) {
                        it2.remove();
                    }
                } catch (Exception e3) {
                }
            }
        }
        boolean z = j.g;
        if (z) {
            j.g = false;
        }
        if (com.baidu.location.g.g.W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                if (this.h == null) {
                    this.h = new BDLocation(bDLocation);
                    return;
                }
                float[] fArr = new float[1];
                Location.distanceBetween(this.h.getLatitude(), this.h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] > com.baidu.location.g.g.Y || z) {
                    this.h = null;
                    this.h = new BDLocation(bDLocation);
                }
            }
        }
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f.isEmpty()) {
            return "&prod=" + com.baidu.location.g.b.e + ":" + com.baidu.location.g.b.d;
        }
        C0042a c0042a = this.f.get(0);
        if (c0042a.c.prodName != null) {
            stringBuffer.append(c0042a.c.prodName);
        }
        if (c0042a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0042a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void c(BDLocation bDLocation) {
        Address a = j.c().a(bDLocation);
        String f = j.c().f();
        List<Poi> g = j.c().g();
        if (a != null) {
            bDLocation.setAddr(a);
        }
        if (f != null) {
            bDLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        a(bDLocation);
        j.c().c(bDLocation);
    }

    public boolean c(Message message) {
        boolean z = false;
        C0042a a = a(message.replyTo);
        if (a != null) {
            int i = a.c.scanSpan;
            a.c.scanSpan = message.getData().getInt("scanSpan", a.c.scanSpan);
            if (a.c.scanSpan < 1000) {
                l.a().c();
                this.a = false;
            } else {
                this.a = true;
            }
            if (a.c.scanSpan > 999 && i < 1000) {
                if (a.c.mIsNeedDeviceDirect || a.c.isNeedAltitude) {
                    l.a().a(a.c.mIsNeedDeviceDirect);
                    l.a().b();
                }
                if (this.b || a.c.isNeedAltitude) {
                    z = true;
                }
                this.b = z;
                z = true;
            }
            a.c.openGps = message.getData().getBoolean("openGPS", a.c.openGps);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption = a.c;
            if (string == null || string.equals("")) {
                string = a.c.coorType;
            }
            locationClientOption.coorType = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption2 = a.c;
            if (string2 == null || string2.equals("")) {
                string2 = a.c.addrType;
            }
            locationClientOption2.addrType = string2;
            if (!com.baidu.location.g.g.g.equals(a.c.addrType)) {
                j.c().j();
            }
            a.c.timeOut = message.getData().getInt("timeOut", a.c.timeOut);
            a.c.location_change_notify = message.getData().getBoolean("location_change_notify", a.c.location_change_notify);
            a.c.priority = message.getData().getInt("priority", a.c.priority);
            int i2 = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i2 < com.baidu.location.g.g.af) {
                com.baidu.location.g.g.af = i2;
            }
            e();
        }
        return z;
    }

    public int d(Message message) {
        C0042a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.c == null) {
            return 1;
        }
        return a.c.priority;
    }

    public void d() {
        Iterator<C0042a> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
