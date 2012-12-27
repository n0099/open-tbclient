package com.baidu.location;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.j;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: do  reason: not valid java name */
    private Handler f99do;

    /* renamed from: if  reason: not valid java name */
    private Context f101if;

    /* renamed from: byte  reason: not valid java name */
    private static String f92byte = null;

    /* renamed from: goto  reason: not valid java name */
    private static String f96goto = null;

    /* renamed from: long  reason: not valid java name */
    private static Method f97long = null;

    /* renamed from: case  reason: not valid java name */
    private static Method f93case = null;

    /* renamed from: for  reason: not valid java name */
    private static Method f95for = null;
    private static Class d = null;

    /* renamed from: void  reason: not valid java name */
    private static long f98void = 3000;
    private static int c = 3;

    /* renamed from: char  reason: not valid java name */
    private static boolean f94char = false;

    /* renamed from: else  reason: not valid java name */
    private final String f100else = f.v;

    /* renamed from: try  reason: not valid java name */
    private TelephonyManager f104try = null;
    private a a = new a();

    /* renamed from: new  reason: not valid java name */
    private List f103new = null;

    /* renamed from: int  reason: not valid java name */
    private b f102int = null;
    private boolean b = false;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: byte  reason: not valid java name */
        public long f105byte;

        /* renamed from: do  reason: not valid java name */
        public int f106do;

        /* renamed from: for  reason: not valid java name */
        public int f107for;

        /* renamed from: if  reason: not valid java name */
        public int f108if;

        /* renamed from: int  reason: not valid java name */
        public int f109int;

        /* renamed from: new  reason: not valid java name */
        public char f110new;

        /* renamed from: try  reason: not valid java name */
        public int f111try;

        public a() {
            this.f107for = -1;
            this.f111try = -1;
            this.f106do = -1;
            this.f108if = -1;
            this.f105byte = 0L;
            this.f109int = -1;
            this.f110new = (char) 0;
            this.f105byte = System.currentTimeMillis();
        }

        public a(int i, int i2, int i3, int i4, char c) {
            this.f107for = -1;
            this.f111try = -1;
            this.f106do = -1;
            this.f108if = -1;
            this.f105byte = 0L;
            this.f109int = -1;
            this.f110new = (char) 0;
            this.f107for = i;
            this.f111try = i2;
            this.f106do = i3;
            this.f108if = i4;
            this.f110new = c;
            this.f105byte = System.currentTimeMillis() / 1000;
        }

        public String a() {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.f111try + 23);
            stringBuffer.append("H");
            stringBuffer.append(this.f107for + 45);
            stringBuffer.append("K");
            stringBuffer.append(this.f108if + 54);
            stringBuffer.append("Q");
            stringBuffer.append(this.f106do + 203);
            return stringBuffer.toString();
        }

        public boolean a(a aVar) {
            return this.f107for == aVar.f107for && this.f111try == aVar.f111try && this.f108if == aVar.f108if;
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m111do() {
            return System.currentTimeMillis() - this.f105byte < c.f98void;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m112for() {
            return this.f107for > -1 && this.f111try > 0;
        }

        /* renamed from: if  reason: not valid java name */
        public String m113if() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(String.format("cell=%d|%d|%d|%d:%d", Integer.valueOf(this.f106do), Integer.valueOf(this.f108if), Integer.valueOf(this.f107for), Integer.valueOf(this.f111try), Integer.valueOf(this.f109int)));
            return stringBuffer.toString();
        }

        /* renamed from: int  reason: not valid java name */
        public String m114int() {
            String str;
            String str2;
            try {
                List<NeighboringCellInfo> neighboringCellInfo = c.this.f104try.getNeighboringCellInfo();
                if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                    str = null;
                } else {
                    String str3 = "&nc=";
                    int i = 0;
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (i != 0) {
                            if (i >= 8) {
                                break;
                            }
                            str2 = neighboringCellInfo2.getLac() != this.f107for ? str3 + ";" + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + ";|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                        } else {
                            str2 = neighboringCellInfo2.getLac() != this.f107for ? str3 + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                        }
                        i++;
                        str3 = str2;
                    }
                    str = str3;
                }
            } catch (Exception e) {
                str = null;
            }
            j.a(f.v, "Neighbour:" + str);
            return str;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(c.this.a.f110new);
            stringBuffer.append(String.format("&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f106do), Integer.valueOf(this.f108if), Integer.valueOf(this.f107for), Integer.valueOf(this.f111try), Integer.valueOf(this.f109int)));
            stringBuffer.append("&cl_t=");
            stringBuffer.append(this.f105byte);
            if (c.this.f103new != null && c.this.f103new.size() > 0) {
                int size = c.this.f103new.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    a aVar = (a) c.this.f103new.get(i);
                    if (aVar.f106do != this.f106do) {
                        stringBuffer.append(aVar.f106do);
                    }
                    stringBuffer.append("|");
                    if (aVar.f108if != this.f108if) {
                        stringBuffer.append(aVar.f108if);
                    }
                    stringBuffer.append("|");
                    if (aVar.f107for != this.f107for) {
                        stringBuffer.append(aVar.f107for);
                    }
                    stringBuffer.append("|");
                    if (aVar.f111try != this.f111try) {
                        stringBuffer.append(aVar.f111try);
                    }
                    stringBuffer.append("|");
                    if (i != size - 1) {
                        stringBuffer.append(aVar.f105byte / 1000);
                    } else {
                        stringBuffer.append((System.currentTimeMillis() - aVar.f105byte) / 1000);
                    }
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes.dex */
    class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                c.this.a(c.this.f104try.getCellLocation());
            } catch (Exception e) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (c.this.a != null) {
                if (c.this.a.f110new == 'g') {
                    c.this.a.f109int = signalStrength.getGsmSignalStrength();
                } else if (c.this.a.f110new == 'c') {
                    c.this.a.f109int = signalStrength.getCdmaDbm();
                }
                j.a("cell strength", "===== cell singal strength changed : " + c.this.a.f109int);
                if (c.this.f99do != null) {
                    c.this.f99do.obtainMessage(31).sendToTarget();
                }
            }
        }
    }

    public c(Context context, Handler handler) {
        this.f101if = null;
        this.f99do = null;
        this.f101if = context;
        this.f99do = handler;
    }

    public static String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(3.1f);
        if (!j.f205try && !j.v && z && j.j.equals("all")) {
            stringBuffer.append("&addr=all");
        }
        if (z) {
            if (j.v) {
                stringBuffer.append("&coor=wgs84");
            } else {
                stringBuffer.append("&coor=gcj02");
            }
        }
        if (f96goto == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(f92byte);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(f96goto);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        if (j.f205try) {
            stringBuffer.append("13");
        } else if (j.v) {
            stringBuffer.append("11");
        } else {
            stringBuffer.append("12");
        }
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
        int i;
        if (cellLocation == null || this.f104try == null) {
            return;
        }
        if (!f94char) {
            f92byte = this.f104try.getDeviceId();
            f94char = m104if();
        }
        j.a(f.v, "set cell info..");
        a aVar = new a();
        aVar.f105byte = System.currentTimeMillis();
        String networkOperator = this.f104try.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.a.f106do;
                    }
                    aVar.f106do = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                } else {
                    i = 0;
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.a.f108if;
                }
                aVar.f108if = intValue2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f107for = ((GsmCellLocation) cellLocation).getLac();
            aVar.f111try = ((GsmCellLocation) cellLocation).getCid();
            aVar.f110new = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f110new = 'c';
            if (Integer.parseInt(Build.VERSION.SDK) < 5) {
                return;
            }
            if (d == null) {
                try {
                    d = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f97long = d.getMethod("getBaseStationId", new Class[0]);
                    f93case = d.getMethod("getNetworkId", new Class[0]);
                    f95for = d.getMethod("getSystemId", new Class[0]);
                } catch (Exception e2) {
                    d = null;
                    e2.printStackTrace();
                    return;
                }
            }
            if (d != null && d.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) f95for.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.a.f108if;
                    }
                    aVar.f108if = intValue3;
                    aVar.f111try = ((Integer) f97long.invoke(cellLocation, new Object[0])).intValue();
                    aVar.f107for = ((Integer) f93case.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
        if (aVar.m112for()) {
            if (this.a == null || !this.a.a(aVar)) {
                this.a = aVar;
                this.f99do.obtainMessage(31).sendToTarget();
                if (!aVar.m112for()) {
                    if (this.f103new != null) {
                        this.f103new.clear();
                        return;
                    }
                    return;
                }
                if (this.f103new == null) {
                    this.f103new = new LinkedList();
                }
                int size = this.f103new.size();
                a aVar2 = size == 0 ? null : (a) this.f103new.get(size - 1);
                if (aVar2 != null && aVar2.f111try == this.a.f111try && aVar2.f107for == this.a.f107for) {
                    return;
                }
                if (aVar2 != null) {
                    aVar2.f105byte = this.a.f105byte - aVar2.f105byte;
                }
                this.f103new.add(this.a);
                if (this.f103new.size() > c) {
                    this.f103new.remove(0);
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m104if() {
        if (f92byte == null || f92byte.length() < 10) {
            return false;
        }
        try {
            char[] charArray = f92byte.toCharArray();
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
        if ((this.a == null || !this.a.m111do() || !this.a.m112for()) && this.f104try != null) {
            try {
                a(this.f104try.getCellLocation());
            } catch (Exception e) {
            }
        }
        return this.a;
    }

    /* renamed from: byte  reason: not valid java name */
    public void m106byte() {
        if (this.b) {
            if (this.f102int != null && this.f104try != null) {
                this.f104try.listen(this.f102int, 0);
            }
            this.f102int = null;
            this.f104try = null;
            this.f103new.clear();
            this.f103new = null;
            j.a(f.v, "cell manager stop ...");
            this.b = false;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m107do() {
        if (this.b) {
            return;
        }
        this.f104try = (TelephonyManager) this.f101if.getSystemService("phone");
        this.f103new = new LinkedList();
        this.f102int = new b();
        if (this.f104try == null || this.f102int == null) {
            return;
        }
        try {
            this.f104try.listen(this.f102int, 272);
            f92byte = this.f104try.getDeviceId();
            j.f = f92byte + "|" + Build.MODEL;
        } catch (Exception e) {
        }
        try {
            f96goto = j.a.m241if(this.f101if);
            j.a(f.v, "CUID:" + f96goto);
        } catch (Exception e2) {
            f96goto = null;
        }
        try {
            if (f96goto != null) {
                j.f = "v3.1|" + f96goto + "|" + Build.MODEL;
            }
            j.a(f.v, "CUID:" + j.f);
        } catch (Exception e3) {
        }
        f94char = m104if();
        j.m239if(f.v, "i:" + f92byte);
        j.a(f.v, "cell manager start...");
        this.b = true;
    }

    /* renamed from: for  reason: not valid java name */
    public String m108for() {
        if (this.f104try == null) {
            this.f104try = (TelephonyManager) this.f101if.getSystemService("phone");
        }
        try {
            a(this.f104try.getCellLocation());
        } catch (Exception e) {
        }
        return this.a.toString();
    }

    /* renamed from: int  reason: not valid java name */
    public String m109int() {
        return f92byte;
    }

    /* renamed from: new  reason: not valid java name */
    public int m110new() {
        return this.f104try.getNetworkType();
    }
}
