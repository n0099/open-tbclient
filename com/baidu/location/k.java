package com.baidu.location;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.baidu.location.LocationClientOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a0, n {
    private static k bx = null;
    private ArrayList bw;
    private boolean by = false;
    private boolean bv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: for  reason: not valid java name */
        public Messenger f97for;

        /* renamed from: int  reason: not valid java name */
        public String f99int;

        /* renamed from: do  reason: not valid java name */
        public LocationClientOption f96do = new LocationClientOption();

        /* renamed from: if  reason: not valid java name */
        public int f98if = 0;

        public a(Message message) {
            this.f99int = null;
            this.f97for = null;
            this.f97for = message.replyTo;
            this.f99int = message.getData().getString("packName");
            this.f96do.f22if = message.getData().getString("prodName");
            a2.cC().m80try(this.f96do.f22if, this.f99int);
            this.f96do.f18do = message.getData().getString("coorType");
            this.f96do.f19else = message.getData().getString("addrType");
            c.aF = this.f96do.f19else;
            this.f96do.f20for = message.getData().getBoolean("openGPS");
            this.f96do.f23int = message.getData().getInt("scanSpan");
            this.f96do.d = message.getData().getInt("timeOut");
            this.f96do.h = message.getData().getInt("priority");
            this.f96do.f21goto = message.getData().getBoolean("location_change_notify");
            this.f96do.g = message.getData().getBoolean("needDirect");
            if (this.f96do.g) {
                ah.bG().m152try(this.f96do.g);
                ah.bG().bH();
            }
            if (this.f96do.f23int > 1000) {
                h.m291for().m293int();
            }
            if (this.f96do.getLocationMode() == LocationClientOption.LocationMode.Hight_Accuracy) {
                if (!au.cc().cf()) {
                    Log.w(a0.i, "use hight accuracy mode does not use open wifi");
                }
                if (z.bc().a9()) {
                    return;
                }
                Log.w(a0.i, "use hight accuracy mode does not use open gps");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f97for != null) {
                    this.f97for.send(obtain);
                }
                this.f98if = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f98if++;
                }
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f97for != null) {
                    this.f97for.send(obtain);
                }
                this.f98if = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f98if++;
                }
            }
        }

        public void a() {
            a(23);
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.internalSet(0, a2.cC().jj);
            if (bDLocation2 == null) {
                return;
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (this.f96do.f18do != null && !this.f96do.f18do.equals(BDGeofence.COORD_TYPE_GCJ)) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    double[] m20if = Jni.m20if(longitude, latitude, this.f96do.f18do);
                    bDLocation2.setLongitude(m20if[0]);
                    bDLocation2.setLatitude(m20if[1]);
                }
            }
            a(i, "locStr", bDLocation2);
        }

        /* renamed from: if  reason: not valid java name */
        public void m306if() {
            if (this.f96do.f21goto) {
                if (c.a5) {
                    a(54);
                } else {
                    a(55);
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m307if(BDLocation bDLocation) {
            if (!this.f96do.f21goto || ag.bz().bA()) {
                return;
            }
            a(bDLocation);
            an.a().a((String) null);
            an.a().m184if(an.a().f52new);
        }
    }

    private k() {
        this.bw = null;
        this.bw = new ArrayList();
    }

    /* renamed from: if  reason: not valid java name */
    private a m295if(Messenger messenger) {
        if (this.bw == null) {
            return null;
        }
        Iterator it = this.bw.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.f97for.equals(messenger)) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    private void m296if(a aVar) {
        if (aVar == null) {
            return;
        }
        if (m295if(aVar.f97for) != null) {
            aVar.a(14);
            return;
        }
        this.bw.add(aVar);
        aVar.a(13);
    }

    private void k() {
        m();
        n();
    }

    private void m() {
        Iterator it = this.bw.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.f96do.f20for) {
                z2 = true;
            }
            z = aVar.f96do.f21goto ? true : z;
        }
        c.aL = z;
        if (this.by != z2) {
            this.by = z2;
            z.bc().m409int(this.by);
        }
    }

    public static k q() {
        if (bx == null) {
            bx = new k();
        }
        return bx;
    }

    /* renamed from: byte  reason: not valid java name */
    public void m297byte(String str) {
        BDLocation bDLocation = new BDLocation(str);
        an.a().f52new = str;
        Iterator it = this.bw.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m307if(bDLocation);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m298do(Message message) {
        a m295if = m295if(message.replyTo);
        if (m295if != null) {
            this.bw.remove(m295if);
        }
        ah.bG().bF();
        h.m291for().m292do();
        k();
    }

    /* renamed from: do  reason: not valid java name */
    public void m299do(BDLocation bDLocation) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.bw.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(bDLocation);
            if (aVar.f98if > 4) {
                arrayList.add(aVar);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.bw.remove((a) it2.next());
        }
    }

    /* renamed from: for  reason: not valid java name */
    public int m300for(Message message) {
        a m295if;
        if (message == null || message.replyTo == null || (m295if = m295if(message.replyTo)) == null || m295if.f96do == null) {
            return 1;
        }
        return m295if.f96do.h;
    }

    /* renamed from: if  reason: not valid java name */
    public String m301if(Message message) {
        a m295if;
        if (message == null || message.replyTo == null || (m295if = m295if(message.replyTo)) == null) {
            return null;
        }
        m295if.f96do.f24long = message.getData().getInt("num", m295if.f96do.f24long);
        m295if.f96do.c = message.getData().getFloat("distance", m295if.f96do.c);
        m295if.f96do.e = message.getData().getBoolean("extraInfo", m295if.f96do.e);
        m295if.f96do.f25new = true;
        String format = String.format(Locale.CHINA, "&poi=%.1f|%d", Float.valueOf(m295if.f96do.c), Integer.valueOf(m295if.f96do.f24long));
        return m295if.f96do.e ? format + "|1" : format;
    }

    /* renamed from: if  reason: not valid java name */
    public void m302if(BDLocation bDLocation, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.bw.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(bDLocation, i);
            if (aVar.f98if > 4) {
                arrayList.add(aVar);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.bw.remove((a) it2.next());
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m303if(BDLocation bDLocation, Message message) {
        a m295if;
        if (bDLocation == null || message == null || (m295if = m295if(message.replyTo)) == null) {
            return;
        }
        m295if.a(bDLocation);
        if (m295if.f98if > 4) {
            this.bw.remove(m295if);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public boolean m304int(Message message) {
        boolean z = false;
        a m295if = m295if(message.replyTo);
        if (m295if != null) {
            int i = m295if.f96do.f23int;
            m295if.f96do.f23int = message.getData().getInt("scanSpan", m295if.f96do.f23int);
            if (m295if.f96do.f23int < 1000) {
                h.m291for().a();
                ah.bG().bF();
                z.bc().a8();
            } else {
                h.m291for().mo251if();
            }
            if (m295if.f96do.f23int > 999 && i < 1000) {
                z = true;
                if (m295if.f96do.g) {
                    ah.bG().m152try(m295if.f96do.g);
                    ah.bG().bH();
                }
            }
            m295if.f96do.f20for = message.getData().getBoolean("openGPS", m295if.f96do.f20for);
            String string = message.getData().getString("coorType");
            LocationClientOption locationClientOption = m295if.f96do;
            if (string == null || string.equals("")) {
                string = m295if.f96do.f18do;
            }
            locationClientOption.f18do = string;
            String string2 = message.getData().getString("addrType");
            LocationClientOption locationClientOption2 = m295if.f96do;
            if (string2 == null || string2.equals("")) {
                string2 = m295if.f96do.f19else;
            }
            locationClientOption2.f19else = string2;
            if (!c.aF.equals(m295if.f96do.f19else)) {
                ak.aF().aG();
            }
            c.aF = m295if.f96do.f19else;
            m295if.f96do.d = message.getData().getInt("timeOut", m295if.f96do.d);
            m295if.f96do.f21goto = message.getData().getBoolean("location_change_notify", m295if.f96do.f21goto);
            m295if.f96do.h = message.getData().getInt("priority", m295if.f96do.h);
            k();
        }
        return z;
    }

    public void j() {
        Iterator it = this.bw.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public boolean l() {
        return this.by;
    }

    public void n() {
        Iterator it = this.bw.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m306if();
        }
    }

    /* renamed from: new  reason: not valid java name */
    public void m305new(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        m296if(new a(message));
        k();
    }

    public void o() {
        this.bw.clear();
        k();
    }

    public String p() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.bw.isEmpty()) {
            return "&prod=" + a2.jg + ":" + a2.jc;
        }
        a aVar = (a) this.bw.get(0);
        if (aVar.f96do.f22if != null) {
            stringBuffer.append(aVar.f96do.f22if);
        }
        if (aVar.f99int != null) {
            stringBuffer.append(":");
            stringBuffer.append(aVar.f99int);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }
}
