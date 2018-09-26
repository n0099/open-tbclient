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
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.LogFactory;
/* loaded from: classes2.dex */
public class a {
    private static a Yj = null;
    public static long c = 0;
    private ArrayList<C0070a> f;
    private boolean g = false;
    public boolean a = false;
    boolean b = false;
    private BDLocation Yk = null;
    private BDLocation Yl = null;
    int d = 0;
    private BDLocation Ym = null;
    private boolean k = false;
    private boolean l = false;
    private b Yn = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0070a {
        final /* synthetic */ a Yj;
        public String a;
        public Messenger b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;

        public C0070a(a aVar, Message message) {
            boolean z = true;
            this.Yj = aVar;
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.d.b.rS().a(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.d.g.l = com.baidu.location.d.g.l || this.c.enableSimulateGps;
            if (!com.baidu.location.d.g.g.equals("all")) {
                com.baidu.location.d.g.g = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            com.baidu.location.d.g.h = com.baidu.location.d.g.h || message.getData().getBoolean("isneedaptag", false);
            if (!com.baidu.location.d.g.i && !message.getData().getBoolean("isneedaptagd", false)) {
                z = false;
            }
            com.baidu.location.d.g.i = z;
            com.baidu.location.d.g.aaN = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i < com.baidu.location.d.g.aaQ) {
                com.baidu.location.d.g.aaQ = i;
            }
            int i2 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i2 >= com.baidu.location.d.g.W) {
                com.baidu.location.d.g.W = i2;
            }
            int i3 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i3 >= com.baidu.location.d.g.Y) {
                com.baidu.location.d.g.Y = i3;
            }
            int i4 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i4 >= com.baidu.location.d.g.X) {
                com.baidu.location.d.g.X = i4;
            }
            if (this.c.scanSpan >= 1000) {
            }
            if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
                l.rA().a(this.c.mIsNeedDeviceDirect);
                l.rA().b();
            }
            aVar.b |= this.c.isNeedAltitude;
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
                if (com.baidu.location.d.g.b) {
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
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.c.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
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

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        final /* synthetic */ a Yo;
        private int b;
        private boolean c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.b++;
            this.Yo.l = false;
        }
    }

    private a() {
        this.f = null;
        this.f = new ArrayList<>();
    }

    private C0070a a(Messenger messenger) {
        if (this.f == null) {
            return null;
        }
        Iterator<C0070a> it = this.f.iterator();
        while (it.hasNext()) {
            C0070a next = it.next();
            if (next.b.equals(messenger)) {
                return next;
            }
        }
        return null;
    }

    private void a(C0070a c0070a) {
        if (c0070a == null) {
            return;
        }
        if (a(c0070a.b) != null) {
            c0070a.a(14);
            return;
        }
        this.f.add(c0070a);
        c0070a.a(13);
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.d.b.d);
        intent.putExtra("tag", WXLoginActivity.KEY_BASE_RESP_STATE);
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator<C0070a> it = this.f.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0070a next = it.next();
            if (next.c.openGps) {
                z2 = true;
            }
            z = next.c.location_change_notify ? true : z;
        }
        com.baidu.location.d.g.a = z;
        if (this.g != z2) {
            this.g = z2;
            com.baidu.location.b.d.rL().a(this.g);
        }
    }

    public static a rp() {
        if (Yj == null) {
            Yj = new a();
        }
        return Yj;
    }

    public void a(Bundle bundle, int i) {
        Iterator<C0070a> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                C0070a next = it.next();
                next.a(i, bundle);
                if (next.d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
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
        com.baidu.location.b.f.rN().b();
        a(new C0070a(this, message));
        e();
        if (this.k) {
            b(IntentConfig.START);
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
        this.Yk = null;
        e();
    }

    public void b(Message message) {
        C0070a a = a(message.replyTo);
        if (a != null) {
            this.f.remove(a);
        }
        l.rA().c();
        e();
        if (this.k) {
            b(IntentConfig.STOP);
            this.d = 0;
        }
    }

    public void b(BDLocation bDLocation) {
        if (bDLocation == null || bDLocation.getLocType() != 161 || h.rv().b()) {
            Iterator<C0070a> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    C0070a next = it.next();
                    next.a(bDLocation);
                    if (next.d > 4) {
                        it.remove();
                    }
                } catch (Exception e) {
                }
            }
        } else {
            if (this.Yl == null) {
                this.Yl = new BDLocation();
                this.Yl.setLocType(505);
            }
            Iterator<C0070a> it2 = this.f.iterator();
            while (it2.hasNext()) {
                try {
                    C0070a next2 = it2.next();
                    next2.a(this.Yl);
                    if (next2.d > 4) {
                        it2.remove();
                    }
                } catch (Exception e2) {
                }
            }
        }
        boolean z = j.h;
        if (z) {
            j.h = false;
        }
        if (com.baidu.location.d.g.W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                if (this.Yk == null) {
                    this.Yk = new BDLocation(bDLocation);
                    return;
                }
                float[] fArr = new float[1];
                Location.distanceBetween(this.Yk.getLatitude(), this.Yk.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] > com.baidu.location.d.g.Y || z) {
                    this.Yk = null;
                    this.Yk = new BDLocation(bDLocation);
                }
            }
        }
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f.isEmpty()) {
            return "&prod=" + com.baidu.location.d.b.e + ":" + com.baidu.location.d.b.d;
        }
        C0070a c0070a = this.f.get(0);
        if (c0070a.c.prodName != null) {
            stringBuffer.append(c0070a.c.prodName);
        }
        if (c0070a.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0070a.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void c(BDLocation bDLocation) {
        Address e = j.rx().e(bDLocation);
        String f = j.rx().f();
        List<Poi> g = j.rx().g();
        if (e != null) {
            bDLocation.setAddr(e);
        }
        if (f != null) {
            bDLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        a(bDLocation);
        j.rx().c(bDLocation);
    }

    public void d() {
        Iterator<C0070a> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean f(Message message) {
        boolean z = true;
        C0070a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.c.scanSpan;
        a.c.scanSpan = message.getData().getInt("scanSpan", a.c.scanSpan);
        if (a.c.scanSpan < 1000) {
            l.rA().c();
            this.a = false;
        } else {
            this.a = true;
        }
        if (a.c.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else {
            if (a.c.mIsNeedDeviceDirect || a.c.isNeedAltitude) {
                l.rA().a(a.c.mIsNeedDeviceDirect);
                l.rA().b();
            }
            this.b |= a.c.isNeedAltitude;
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
        if (!com.baidu.location.d.g.g.equals(a.c.addrType)) {
            j.rx().i();
        }
        a.c.timeOut = message.getData().getInt("timeOut", a.c.timeOut);
        a.c.location_change_notify = message.getData().getBoolean("location_change_notify", a.c.location_change_notify);
        a.c.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, a.c.priority);
        int i2 = message.getData().getInt("wifitimeout", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (i2 < com.baidu.location.d.g.aaQ) {
            com.baidu.location.d.g.aaQ = i2;
        }
        e();
        return z;
    }

    public int g(Message message) {
        C0070a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.c == null) {
            return 1;
        }
        return a.c.priority;
    }

    public int h(Message message) {
        C0070a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.c == null) {
            return 1000;
        }
        return a.c.scanSpan;
    }
}
