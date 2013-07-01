package com.baidu.location;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t {
    private static String f = null;
    private static String g = null;
    private static Method k = null;
    private static Method l = null;
    private static Method m = null;
    private static Class n = null;
    private static long o = 3000;
    private static int p = 3;
    private static boolean q = false;
    private Context b;
    private Handler h;

    /* renamed from: a  reason: collision with root package name */
    private final String f484a = "baidu_location_service";
    private TelephonyManager c = null;
    private u d = new u(this);
    private List e = null;
    private v i = null;
    private boolean j = false;

    public t(Context context, Handler handler) {
        this.b = null;
        this.h = null;
        this.b = context;
        this.h = handler;
    }

    public static String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(3.1f);
        if (!ap.f464a && !ap.b && z && ap.i.equals("all")) {
            stringBuffer.append("&addr=all");
        }
        if (z) {
            if (ap.b) {
                stringBuffer.append("&coor=wgs84");
            } else {
                stringBuffer.append("&coor=gcj02");
            }
        }
        if (g == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(f);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(g);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        if (ap.f464a) {
            stringBuffer.append("13");
        } else if (ap.b) {
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
        if (cellLocation == null || this.c == null) {
            return;
        }
        if (!q) {
            f = this.c.getDeviceId();
            q = f();
        }
        ap.a("baidu_location_service", "set cell info..");
        u uVar = new u(this);
        uVar.e = System.currentTimeMillis();
        String networkOperator = this.c.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.d.c;
                    }
                    uVar.c = intValue;
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
                    intValue2 = this.d.d;
                }
                uVar.d = intValue2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            uVar.f485a = ((GsmCellLocation) cellLocation).getLac();
            uVar.b = ((GsmCellLocation) cellLocation).getCid();
            uVar.g = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            uVar.g = 'c';
            if (Integer.parseInt(Build.VERSION.SDK) < 5) {
                return;
            }
            if (n == null) {
                try {
                    n = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    k = n.getMethod("getBaseStationId", new Class[0]);
                    l = n.getMethod("getNetworkId", new Class[0]);
                    m = n.getMethod("getSystemId", new Class[0]);
                } catch (Exception e2) {
                    n = null;
                    e2.printStackTrace();
                    return;
                }
            }
            if (n != null && n.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) m.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.d.d;
                    }
                    uVar.d = intValue3;
                    uVar.b = ((Integer) k.invoke(cellLocation, new Object[0])).intValue();
                    uVar.f485a = ((Integer) l.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
        if (uVar.b()) {
            if (this.d == null || !this.d.a(uVar)) {
                this.d = uVar;
                this.h.obtainMessage(31).sendToTarget();
                if (!uVar.b()) {
                    if (this.e != null) {
                        this.e.clear();
                        return;
                    }
                    return;
                }
                if (this.e == null) {
                    this.e = new LinkedList();
                }
                int size = this.e.size();
                u uVar2 = size == 0 ? null : (u) this.e.get(size - 1);
                if (uVar2 != null && uVar2.b == this.d.b && uVar2.f485a == this.d.f485a) {
                    return;
                }
                if (uVar2 != null) {
                    uVar2.e = this.d.e - uVar2.e;
                }
                this.e.add(this.d);
                if (this.e.size() > p) {
                    this.e.remove(0);
                }
            }
        }
    }

    private boolean f() {
        if (f == null || f.length() < 10) {
            return false;
        }
        try {
            char[] charArray = f.toCharArray();
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

    public void a() {
        if (this.j) {
            return;
        }
        this.c = (TelephonyManager) this.b.getSystemService("phone");
        this.e = new LinkedList();
        this.i = new v(this);
        if (this.c == null || this.i == null) {
            return;
        }
        try {
            this.c.listen(this.i, 272);
            f = this.c.getDeviceId();
            ap.h = f + "|" + Build.MODEL;
        } catch (Exception e) {
        }
        try {
            g = aq.a(this.b);
            ap.a("baidu_location_service", "CUID:" + g);
        } catch (Exception e2) {
            g = null;
        }
        try {
            if (g != null) {
                ap.h = "v3.1|" + g + "|" + Build.MODEL;
            }
            ap.a("baidu_location_service", "CUID:" + ap.h);
        } catch (Exception e3) {
        }
        q = f();
        ap.b("baidu_location_service", "i:" + f);
        ap.a("baidu_location_service", "cell manager start...");
        this.j = true;
    }

    public void b() {
        if (this.j) {
            if (this.i != null && this.c != null) {
                this.c.listen(this.i, 0);
            }
            this.i = null;
            this.c = null;
            this.e.clear();
            this.e = null;
            ap.a("baidu_location_service", "cell manager stop ...");
            this.j = false;
        }
    }

    public int c() {
        return this.c.getNetworkType();
    }

    public u d() {
        if ((this.d == null || !this.d.a() || !this.d.b()) && this.c != null) {
            try {
                a(this.c.getCellLocation());
            } catch (Exception e) {
            }
        }
        return this.d;
    }
}
