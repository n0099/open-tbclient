package com.baidu.location.a;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<C0242a> f;
    private static a e = null;
    public static long c = 0;
    private boolean g = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2528a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f2529b = false;
    private BDLocation h = null;
    private BDLocation i = null;
    int d = 0;
    private BDLocation j = null;
    private boolean k = false;
    private boolean l = false;
    private b m = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0242a {

        /* renamed from: a  reason: collision with root package name */
        public String f2530a;

        /* renamed from: b  reason: collision with root package name */
        public Messenger f2531b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;
        final /* synthetic */ a e;

        public C0242a(a aVar, Message message) {
            boolean z = false;
            this.e = aVar;
            this.f2530a = null;
            this.f2531b = null;
            this.f2531b = message.replyTo;
            this.f2530a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.d.b.a().a(this.c.prodName, this.f2530a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.d.j.m = com.baidu.location.d.j.m || this.c.enableSimulateGps;
            if (!com.baidu.location.d.j.g.equals("all")) {
                com.baidu.location.d.j.g = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.d.j.i = com.baidu.location.d.j.i || this.c.isNeedNewVersionRgc;
            com.baidu.location.d.j.h = com.baidu.location.d.j.h || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.d.j.j = com.baidu.location.d.j.j || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.d.j.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i < com.baidu.location.d.j.af) {
                com.baidu.location.d.j.af = i;
            }
            int i2 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i2 >= com.baidu.location.d.j.W) {
                com.baidu.location.d.j.W = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i3 >= com.baidu.location.d.j.Y) {
                com.baidu.location.d.j.Y = i3;
            }
            int i4 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i4 >= com.baidu.location.d.j.X) {
                com.baidu.location.d.j.X = i4;
            }
            if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
                o.a().a(this.c.mIsNeedDeviceDirect);
                o.a().b();
            }
            aVar.f2529b = (aVar.f2529b || this.c.isNeedAltitude) ? true : z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f2531b != null) {
                    this.f2531b.send(obtain);
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
                if (this.f2531b != null) {
                    this.f2531b.send(obtain);
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
                if (this.f2531b != null) {
                    this.f2531b.send(obtain);
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
                if (com.baidu.location.d.j.f2645b) {
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
            if (this.c.coorType != null && !this.c.coorType.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
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

    /* loaded from: classes6.dex */
    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f2532a;

        /* renamed from: b  reason: collision with root package name */
        private int f2533b;
        private boolean c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.f2533b++;
            this.f2532a.l = false;
        }
    }

    private a() {
        this.f = null;
        this.f = new ArrayList<>();
    }

    private C0242a a(Messenger messenger) {
        if (this.f == null) {
            return null;
        }
        Iterator<C0242a> it = this.f.iterator();
        while (it.hasNext()) {
            C0242a next = it.next();
            if (next.f2531b.equals(messenger)) {
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

    private void a(C0242a c0242a) {
        if (c0242a == null) {
            return;
        }
        if (a(c0242a.f2531b) != null) {
            c0242a.a(14);
            return;
        }
        this.f.add(c0242a);
        c0242a.a(13);
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.d.b.d);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0242a> it = this.f.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0242a next = it.next();
            if (next.c.openGps) {
                z2 = true;
            }
            z = next.c.location_change_notify ? true : z;
        }
        com.baidu.location.d.j.f2644a = z;
        if (this.g != z2) {
            this.g = z2;
            com.baidu.location.b.e.a().a(this.g);
        }
    }

    public void a(Bundle bundle, int i) {
        Iterator<C0242a> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                C0242a next = it.next();
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
        this.f2528a = true;
        com.baidu.location.b.i.a().b();
        a(new C0242a(this, message));
        e();
        if (this.k) {
            b("start");
            this.d = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
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
        C0242a a2 = a(message.replyTo);
        if (a2 != null) {
            this.f.remove(a2);
        }
        o.a().c();
        e();
        if (this.k) {
            b("stop");
            this.d = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        if (bDLocation == null || bDLocation.getLocType() != 161 || j.a().b()) {
            Iterator<C0242a> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    C0242a next = it.next();
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
            Iterator<C0242a> it2 = this.f.iterator();
            while (it2.hasNext()) {
                try {
                    C0242a next2 = it2.next();
                    next2.a(this.i);
                    if (next2.d > 4) {
                        it2.remove();
                    }
                } catch (Exception e3) {
                }
            }
        }
        boolean z = l.g;
        if (z) {
            l.g = false;
        }
        if (com.baidu.location.d.j.W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                if (this.h == null) {
                    this.h = new BDLocation(bDLocation);
                    return;
                }
                float[] fArr = new float[1];
                Location.distanceBetween(this.h.getLatitude(), this.h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] > com.baidu.location.d.j.Y || z) {
                    this.h = null;
                    this.h = new BDLocation(bDLocation);
                }
            }
        }
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f.isEmpty()) {
            return "&prod=" + com.baidu.location.d.b.e + ":" + com.baidu.location.d.b.d;
        }
        C0242a c0242a = this.f.get(0);
        if (c0242a.c.prodName != null) {
            stringBuffer.append(c0242a.c.prodName);
        }
        if (c0242a.f2530a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0242a.f2530a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void c(BDLocation bDLocation) {
        Address a2 = l.c().a(bDLocation);
        String f = l.c().f();
        List<Poi> g = l.c().g();
        if (a2 != null) {
            bDLocation.setAddr(a2);
        }
        if (f != null) {
            bDLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        a(bDLocation);
        l.c().c(bDLocation);
    }

    public boolean c(Message message) {
        boolean z = false;
        C0242a a2 = a(message.replyTo);
        if (a2 != null) {
            int i = a2.c.scanSpan;
            a2.c.scanSpan = message.getData().getInt("scanSpan", a2.c.scanSpan);
            if (a2.c.scanSpan < 1000) {
                o.a().c();
                this.f2528a = false;
            } else {
                this.f2528a = true;
            }
            if (a2.c.scanSpan > 999 && i < 1000) {
                if (a2.c.mIsNeedDeviceDirect || a2.c.isNeedAltitude) {
                    o.a().a(a2.c.mIsNeedDeviceDirect);
                    o.a().b();
                }
                if (this.f2529b || a2.c.isNeedAltitude) {
                    z = true;
                }
                this.f2529b = z;
                z = true;
            }
            a2.c.openGps = message.getData().getBoolean("openGPS", a2.c.openGps);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption = a2.c;
            if (string == null || string.equals("")) {
                string = a2.c.coorType;
            }
            locationClientOption.coorType = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption2 = a2.c;
            if (string2 == null || string2.equals("")) {
                string2 = a2.c.addrType;
            }
            locationClientOption2.addrType = string2;
            if (!com.baidu.location.d.j.g.equals(a2.c.addrType)) {
                l.c().i();
            }
            a2.c.timeOut = message.getData().getInt("timeOut", a2.c.timeOut);
            a2.c.location_change_notify = message.getData().getBoolean("location_change_notify", a2.c.location_change_notify);
            a2.c.priority = message.getData().getInt("priority", a2.c.priority);
            int i2 = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i2 < com.baidu.location.d.j.af) {
                com.baidu.location.d.j.af = i2;
            }
            e();
        }
        return z;
    }

    public int d(Message message) {
        C0242a a2;
        if (message == null || message.replyTo == null || (a2 = a(message.replyTo)) == null || a2.c == null) {
            return 1;
        }
        return a2.c.priority;
    }

    public void d() {
        Iterator<C0242a> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public int e(Message message) {
        C0242a a2;
        if (message == null || message.replyTo == null || (a2 = a(message.replyTo)) == null || a2.c == null) {
            return 1000;
        }
        return a2.c.scanSpan;
    }
}
