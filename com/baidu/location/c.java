package com.baidu.location;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.tieba.util.NetWorkCore;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: do  reason: not valid java name */
    private Handler f96do;

    /* renamed from: if  reason: not valid java name */
    private Context f98if;

    /* renamed from: byte  reason: not valid java name */
    private static String f90byte = null;

    /* renamed from: goto  reason: not valid java name */
    private static Method f94goto = null;

    /* renamed from: case  reason: not valid java name */
    private static Method f91case = null;

    /* renamed from: for  reason: not valid java name */
    private static Method f93for = null;
    private static Class c = null;

    /* renamed from: long  reason: not valid java name */
    private static long f95long = 3000;
    private static int b = 3;

    /* renamed from: char  reason: not valid java name */
    private static boolean f92char = false;

    /* renamed from: else  reason: not valid java name */
    private final String f97else = f.g;

    /* renamed from: try  reason: not valid java name */
    private TelephonyManager f101try = null;
    private a a = null;

    /* renamed from: new  reason: not valid java name */
    private List f100new = null;

    /* renamed from: int  reason: not valid java name */
    private b f99int = null;

    /* renamed from: void  reason: not valid java name */
    private boolean f102void = false;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: byte  reason: not valid java name */
        public long f103byte;

        /* renamed from: do  reason: not valid java name */
        public int f104do;

        /* renamed from: for  reason: not valid java name */
        public int f105for;

        /* renamed from: if  reason: not valid java name */
        public int f106if;

        /* renamed from: int  reason: not valid java name */
        public int f107int;

        /* renamed from: new  reason: not valid java name */
        public char f108new;

        /* renamed from: try  reason: not valid java name */
        public int f109try;

        public a() {
            this.f105for = -1;
            this.f109try = -1;
            this.f104do = -1;
            this.f106if = -1;
            this.f103byte = 0L;
            this.f107int = -1;
            this.f108new = (char) 0;
            this.f103byte = System.currentTimeMillis();
        }

        public a(int i, int i2, int i3, int i4, char c) {
            this.f105for = -1;
            this.f109try = -1;
            this.f104do = -1;
            this.f106if = -1;
            this.f103byte = 0L;
            this.f107int = -1;
            this.f108new = (char) 0;
            this.f105for = i;
            this.f109try = i2;
            this.f104do = i3;
            this.f106if = i4;
            this.f108new = c;
            this.f103byte = System.currentTimeMillis() / 1000;
        }

        public String a() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(String.format("cell=%d|%d|%d|%d:%d", Integer.valueOf(this.f104do), Integer.valueOf(this.f106if), Integer.valueOf(this.f105for), Integer.valueOf(this.f109try), Integer.valueOf(this.f107int)));
            return stringBuffer.toString();
        }

        public boolean a(a aVar) {
            return this.f105for == aVar.f105for && this.f109try == aVar.f109try && this.f106if == aVar.f106if;
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m91do() {
            return this.f105for > -1 && this.f109try > 0;
        }

        /* renamed from: for  reason: not valid java name */
        public String m92for() {
            String str;
            String str2;
            try {
                List<NeighboringCellInfo> neighboringCellInfo = c.this.f101try.getNeighboringCellInfo();
                if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                    str = null;
                } else {
                    String str3 = "&nc=";
                    int i = 0;
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (i != 0) {
                            if (i >= 6) {
                                break;
                            }
                            str2 = neighboringCellInfo2.getLac() != this.f105for ? str3 + ";" + neighboringCellInfo2.getLac() + NetWorkCore.NET_TYPE_NET + neighboringCellInfo2.getCid() + NetWorkCore.NET_TYPE_NET + neighboringCellInfo2.getRssi() : str3 + ";|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                        } else {
                            str2 = neighboringCellInfo2.getLac() != this.f105for ? str3 + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                        }
                        i++;
                        str3 = str2;
                    }
                    str = str3;
                }
            } catch (Exception e) {
                str = null;
            }
            j.a(f.g, "Neighbour:" + str);
            return str;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m93if() {
            return System.currentTimeMillis() - this.f103byte < c.f95long;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer((int) AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
            stringBuffer.append("&nw=");
            stringBuffer.append(c.this.a.f108new);
            stringBuffer.append(String.format("&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f104do), Integer.valueOf(this.f106if), Integer.valueOf(this.f105for), Integer.valueOf(this.f109try), Integer.valueOf(this.f107int)));
            stringBuffer.append("&cl_t=");
            stringBuffer.append(this.f103byte);
            if (c.this.f100new != null && c.this.f100new.size() > 0) {
                int size = c.this.f100new.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    a aVar = (a) c.this.f100new.get(i);
                    if (i != size - 1) {
                        stringBuffer.append(String.format("%d|%d|%d|%d|%d;", Integer.valueOf(aVar.f104do), Integer.valueOf(aVar.f106if), Integer.valueOf(aVar.f105for), Integer.valueOf(aVar.f109try), Long.valueOf(aVar.f103byte / 1000)));
                    } else {
                        stringBuffer.append(String.format("%d|%d|%d|%d|%d;", Integer.valueOf(aVar.f104do), Integer.valueOf(aVar.f106if), Integer.valueOf(aVar.f105for), Integer.valueOf(aVar.f109try), Long.valueOf((System.currentTimeMillis() - aVar.f103byte) / 1000)));
                    }
                }
            }
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes.dex */
    private class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            c.this.a(cellLocation);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (c.this.a != null) {
                if (c.this.a.f108new == 'g') {
                    c.this.a.f107int = signalStrength.getGsmSignalStrength();
                } else if (c.this.a.f108new == 'c') {
                    c.this.a.f107int = signalStrength.getCdmaDbm();
                }
                j.a("cell strength", "===== cell singal strength changed : " + c.this.a.f107int);
                if (c.this.f96do != null) {
                    c.this.f96do.obtainMessage(31).sendToTarget();
                }
            }
        }
    }

    public c(Context context, Handler handler) {
        this.f98if = null;
        this.f96do = null;
        this.f98if = context;
        this.f96do = handler;
    }

    public static String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer((int) AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT);
        stringBuffer.append("&sdk=");
        stringBuffer.append(2.6f);
        if (!j.f181do && !j.c && z) {
            stringBuffer.append("&addr=all");
        }
        if (z) {
            if (j.c) {
                stringBuffer.append("&coor=wgs84");
            } else {
                stringBuffer.append("&coor=gcj02");
            }
        }
        stringBuffer.append("&im=");
        stringBuffer.append(f90byte);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        if (z) {
            stringBuffer.append("&sv=");
            String str = Build.VERSION.RELEASE;
            if (str != null && str.length() > 5) {
                str = str.substring(0, 5);
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CellLocation cellLocation) {
        if (cellLocation == null || this.f101try == null) {
            return;
        }
        if (!f92char) {
            f90byte = this.f101try.getDeviceId();
            f92char = m84if();
        }
        j.a(f.g, "set cell info..");
        a aVar = new a();
        aVar.f103byte = System.currentTimeMillis();
        String networkOperator = this.f101try.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.a.f104do;
                    }
                    aVar.f104do = intValue;
                    int intValue2 = Integer.valueOf(networkOperator.substring(3)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.a.f106if;
                    }
                    aVar.f106if = intValue2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                j.a(f.g, e.getMessage());
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f105for = ((GsmCellLocation) cellLocation).getLac();
            aVar.f109try = ((GsmCellLocation) cellLocation).getCid();
            aVar.f108new = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f108new = 'c';
            if (Integer.parseInt(Build.VERSION.SDK) < 5) {
                return;
            }
            if (c == null) {
                try {
                    c = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f94goto = c.getMethod("getBaseStationId", new Class[0]);
                    f91case = c.getMethod("getNetworkId", new Class[0]);
                    f93for = c.getMethod("getSystemId", new Class[0]);
                } catch (Exception e2) {
                    c = null;
                    e2.printStackTrace();
                    return;
                }
            }
            if (c != null && c.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) f93for.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.a.f106if;
                    }
                    aVar.f106if = intValue3;
                    aVar.f109try = ((Integer) f94goto.invoke(cellLocation, new Object[0])).intValue();
                    aVar.f105for = ((Integer) f91case.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
        if (aVar.m91do()) {
            if (this.a == null || !this.a.a(aVar)) {
                this.a = aVar;
                this.f96do.obtainMessage(31).sendToTarget();
                if (!aVar.m91do()) {
                    if (this.f100new != null) {
                        this.f100new.clear();
                        return;
                    }
                    return;
                }
                if (this.f100new == null) {
                    this.f100new = new LinkedList();
                }
                int size = this.f100new.size();
                a aVar2 = size == 0 ? null : (a) this.f100new.get(size - 1);
                if (aVar2 != null && aVar2.f109try == this.a.f109try && aVar2.f105for == this.a.f105for) {
                    return;
                }
                if (aVar2 != null) {
                    aVar2.f103byte = this.a.f103byte - aVar2.f103byte;
                }
                this.f100new.add(this.a);
                if (this.f100new.size() > b) {
                    this.f100new.remove(0);
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m84if() {
        if (f90byte == null || f90byte.length() < 10) {
            return false;
        }
        try {
            char[] charArray = f90byte.toCharArray();
            for (int i = 0; i < 10; i++) {
                if (charArray[i] > '9' || charArray[i] < '0') {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public a a() {
        if ((this.a == null || !this.a.m93if()) && this.f101try != null) {
            a(this.f101try.getCellLocation());
        }
        return this.a;
    }

    /* renamed from: byte  reason: not valid java name */
    public void m86byte() {
        if (this.f102void) {
            if (this.f99int != null && this.f101try != null) {
                this.f101try.listen(this.f99int, 0);
            }
            this.f99int = null;
            this.f101try = null;
            this.f100new.clear();
            this.f100new = null;
            j.a(f.g, "cell manager stop ...");
            this.f102void = false;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m87do() {
        if (this.f102void) {
            return;
        }
        this.f101try = (TelephonyManager) this.f98if.getSystemService("phone");
        this.f100new = new LinkedList();
        this.f99int = new b();
        if (this.f101try == null || this.f99int == null) {
            return;
        }
        try {
            this.f101try.listen(this.f99int, 272);
        } catch (Exception e) {
        }
        f90byte = this.f101try.getDeviceId();
        f92char = m84if();
        j.m188if(f.g, "i:" + f90byte);
        j.a(f.g, "cell manager start...");
        this.f102void = true;
    }

    /* renamed from: for  reason: not valid java name */
    public String m88for() {
        if (this.f101try == null) {
            this.f101try = (TelephonyManager) this.f98if.getSystemService("phone");
        }
        a(this.f101try.getCellLocation());
        return this.a.toString();
    }

    /* renamed from: int  reason: not valid java name */
    public String m89int() {
        return f90byte;
    }

    /* renamed from: new  reason: not valid java name */
    public int m90new() {
        return this.f101try.getNetworkType();
    }
}
