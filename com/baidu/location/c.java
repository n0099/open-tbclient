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
import com.baidu.zeus.bouncycastle.DERTags;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: do  reason: not valid java name */
    private Handler f135do;

    /* renamed from: if  reason: not valid java name */
    private Context f137if;

    /* renamed from: byte  reason: not valid java name */
    private static String f128byte = null;

    /* renamed from: goto  reason: not valid java name */
    private static String f132goto = null;

    /* renamed from: long  reason: not valid java name */
    private static Method f133long = null;

    /* renamed from: case  reason: not valid java name */
    private static Method f129case = null;

    /* renamed from: for  reason: not valid java name */
    private static Method f131for = null;
    private static Class d = null;

    /* renamed from: void  reason: not valid java name */
    private static long f134void = 3000;
    private static int c = 3;

    /* renamed from: char  reason: not valid java name */
    private static boolean f130char = false;

    /* renamed from: else  reason: not valid java name */
    private final String f136else = f.v;

    /* renamed from: try  reason: not valid java name */
    private TelephonyManager f140try = null;
    private a a = new a();

    /* renamed from: new  reason: not valid java name */
    private List f139new = null;

    /* renamed from: int  reason: not valid java name */
    private b f138int = null;
    private boolean b = false;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: byte  reason: not valid java name */
        public long f141byte;

        /* renamed from: do  reason: not valid java name */
        public int f142do;

        /* renamed from: for  reason: not valid java name */
        public int f143for;

        /* renamed from: if  reason: not valid java name */
        public int f144if;

        /* renamed from: int  reason: not valid java name */
        public int f145int;

        /* renamed from: new  reason: not valid java name */
        public char f146new;

        /* renamed from: try  reason: not valid java name */
        public int f147try;

        public a() {
            this.f143for = -1;
            this.f147try = -1;
            this.f142do = -1;
            this.f144if = -1;
            this.f141byte = 0L;
            this.f145int = -1;
            this.f146new = (char) 0;
            this.f141byte = System.currentTimeMillis();
        }

        public a(int i, int i2, int i3, int i4, char c) {
            this.f143for = -1;
            this.f147try = -1;
            this.f142do = -1;
            this.f144if = -1;
            this.f141byte = 0L;
            this.f145int = -1;
            this.f146new = (char) 0;
            this.f143for = i;
            this.f147try = i2;
            this.f142do = i3;
            this.f144if = i4;
            this.f146new = c;
            this.f141byte = System.currentTimeMillis() / 1000;
        }

        public String a() {
            StringBuffer stringBuffer = new StringBuffer((int) DERTags.TAGGED);
            stringBuffer.append(this.f147try + 23);
            stringBuffer.append("H");
            stringBuffer.append(this.f143for + 45);
            stringBuffer.append("K");
            stringBuffer.append(this.f144if + 54);
            stringBuffer.append("Q");
            stringBuffer.append(this.f142do + 203);
            return stringBuffer.toString();
        }

        public boolean a(a aVar) {
            return this.f143for == aVar.f143for && this.f147try == aVar.f147try && this.f144if == aVar.f144if;
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m128do() {
            return System.currentTimeMillis() - this.f141byte < c.f134void;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m129for() {
            return this.f143for > -1 && this.f147try > 0;
        }

        /* renamed from: if  reason: not valid java name */
        public String m130if() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(String.format("cell=%d|%d|%d|%d:%d", Integer.valueOf(this.f142do), Integer.valueOf(this.f144if), Integer.valueOf(this.f143for), Integer.valueOf(this.f147try), Integer.valueOf(this.f145int)));
            return stringBuffer.toString();
        }

        /* renamed from: int  reason: not valid java name */
        public String m131int() {
            String str;
            String str2;
            try {
                List<NeighboringCellInfo> neighboringCellInfo = c.this.f140try.getNeighboringCellInfo();
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
                            str2 = neighboringCellInfo2.getLac() != this.f143for ? str3 + ";" + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + ";|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
                        } else {
                            str2 = neighboringCellInfo2.getLac() != this.f143for ? str3 + neighboringCellInfo2.getLac() + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() : str3 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi();
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
            StringBuffer stringBuffer = new StringBuffer((int) DERTags.TAGGED);
            stringBuffer.append("&nw=");
            stringBuffer.append(c.this.a.f146new);
            stringBuffer.append(String.format("&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f142do), Integer.valueOf(this.f144if), Integer.valueOf(this.f143for), Integer.valueOf(this.f147try), Integer.valueOf(this.f145int)));
            stringBuffer.append("&cl_t=");
            stringBuffer.append(this.f141byte);
            if (c.this.f139new != null && c.this.f139new.size() > 0) {
                int size = c.this.f139new.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    a aVar = (a) c.this.f139new.get(i);
                    if (aVar.f142do != this.f142do) {
                        stringBuffer.append(aVar.f142do);
                    }
                    stringBuffer.append("|");
                    if (aVar.f144if != this.f144if) {
                        stringBuffer.append(aVar.f144if);
                    }
                    stringBuffer.append("|");
                    if (aVar.f143for != this.f143for) {
                        stringBuffer.append(aVar.f143for);
                    }
                    stringBuffer.append("|");
                    if (aVar.f147try != this.f147try) {
                        stringBuffer.append(aVar.f147try);
                    }
                    stringBuffer.append("|");
                    if (i != size - 1) {
                        stringBuffer.append(aVar.f141byte / 1000);
                    } else {
                        stringBuffer.append((System.currentTimeMillis() - aVar.f141byte) / 1000);
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
                c.this.a(c.this.f140try.getCellLocation());
            } catch (Exception e) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (c.this.a != null) {
                if (c.this.a.f146new == 'g') {
                    c.this.a.f145int = signalStrength.getGsmSignalStrength();
                } else if (c.this.a.f146new == 'c') {
                    c.this.a.f145int = signalStrength.getCdmaDbm();
                }
                j.a("cell strength", "===== cell singal strength changed : " + c.this.a.f145int);
                if (c.this.f135do != null) {
                    c.this.f135do.obtainMessage(31).sendToTarget();
                }
            }
        }
    }

    public c(Context context, Handler handler) {
        this.f137if = null;
        this.f135do = null;
        this.f137if = context;
        this.f135do = handler;
    }

    public static String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(3.1f);
        if (!j.f241try && !j.v && z && j.j.equals("all")) {
            stringBuffer.append("&addr=all");
        }
        if (z) {
            if (j.v) {
                stringBuffer.append("&coor=wgs84");
            } else {
                stringBuffer.append("&coor=gcj02");
            }
        }
        if (f132goto == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(f128byte);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(f132goto);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        if (j.f241try) {
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
        if (cellLocation == null || this.f140try == null) {
            return;
        }
        if (!f130char) {
            f128byte = this.f140try.getDeviceId();
            f130char = m121if();
        }
        j.a(f.v, "set cell info..");
        a aVar = new a();
        aVar.f141byte = System.currentTimeMillis();
        String networkOperator = this.f140try.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.a.f142do;
                    }
                    aVar.f142do = intValue;
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
                    intValue2 = this.a.f144if;
                }
                aVar.f144if = intValue2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f143for = ((GsmCellLocation) cellLocation).getLac();
            aVar.f147try = ((GsmCellLocation) cellLocation).getCid();
            aVar.f146new = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f146new = 'c';
            if (Integer.parseInt(Build.VERSION.SDK) < 5) {
                return;
            }
            if (d == null) {
                try {
                    d = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f133long = d.getMethod("getBaseStationId", new Class[0]);
                    f129case = d.getMethod("getNetworkId", new Class[0]);
                    f131for = d.getMethod("getSystemId", new Class[0]);
                } catch (Exception e2) {
                    d = null;
                    e2.printStackTrace();
                    return;
                }
            }
            if (d != null && d.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) f131for.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.a.f144if;
                    }
                    aVar.f144if = intValue3;
                    aVar.f147try = ((Integer) f133long.invoke(cellLocation, new Object[0])).intValue();
                    aVar.f143for = ((Integer) f129case.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
        if (aVar.m129for()) {
            if (this.a == null || !this.a.a(aVar)) {
                this.a = aVar;
                this.f135do.obtainMessage(31).sendToTarget();
                if (!aVar.m129for()) {
                    if (this.f139new != null) {
                        this.f139new.clear();
                        return;
                    }
                    return;
                }
                if (this.f139new == null) {
                    this.f139new = new LinkedList();
                }
                int size = this.f139new.size();
                a aVar2 = size == 0 ? null : (a) this.f139new.get(size - 1);
                if (aVar2 != null && aVar2.f147try == this.a.f147try && aVar2.f143for == this.a.f143for) {
                    return;
                }
                if (aVar2 != null) {
                    aVar2.f141byte = this.a.f141byte - aVar2.f141byte;
                }
                this.f139new.add(this.a);
                if (this.f139new.size() > c) {
                    this.f139new.remove(0);
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m121if() {
        if (f128byte == null || f128byte.length() < 10) {
            return false;
        }
        try {
            char[] charArray = f128byte.toCharArray();
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
        if ((this.a == null || !this.a.m128do() || !this.a.m129for()) && this.f140try != null) {
            try {
                a(this.f140try.getCellLocation());
            } catch (Exception e) {
            }
        }
        return this.a;
    }

    /* renamed from: byte  reason: not valid java name */
    public void m123byte() {
        if (this.b) {
            if (this.f138int != null && this.f140try != null) {
                this.f140try.listen(this.f138int, 0);
            }
            this.f138int = null;
            this.f140try = null;
            this.f139new.clear();
            this.f139new = null;
            j.a(f.v, "cell manager stop ...");
            this.b = false;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m124do() {
        if (this.b) {
            return;
        }
        this.f140try = (TelephonyManager) this.f137if.getSystemService("phone");
        this.f139new = new LinkedList();
        this.f138int = new b();
        if (this.f140try == null || this.f138int == null) {
            return;
        }
        try {
            this.f140try.listen(this.f138int, 272);
            f128byte = this.f140try.getDeviceId();
            j.f = f128byte + "|" + Build.MODEL;
        } catch (Exception e) {
        }
        try {
            f132goto = j.a.m258if(this.f137if);
            j.a(f.v, "CUID:" + f132goto);
        } catch (Exception e2) {
            f132goto = null;
        }
        try {
            if (f132goto != null) {
                j.f = "v3.1|" + f132goto + "|" + Build.MODEL;
            }
            j.a(f.v, "CUID:" + j.f);
        } catch (Exception e3) {
        }
        f130char = m121if();
        j.m256if(f.v, "i:" + f128byte);
        j.a(f.v, "cell manager start...");
        this.b = true;
    }

    /* renamed from: for  reason: not valid java name */
    public String m125for() {
        if (this.f140try == null) {
            this.f140try = (TelephonyManager) this.f137if.getSystemService("phone");
        }
        try {
            a(this.f140try.getCellLocation());
        } catch (Exception e) {
        }
        return this.a.toString();
    }

    /* renamed from: int  reason: not valid java name */
    public String m126int() {
        return f128byte;
    }

    /* renamed from: new  reason: not valid java name */
    public int m127new() {
        return this.f140try.getNetworkType();
    }
}
