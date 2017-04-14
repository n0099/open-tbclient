package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.appsearchlib.Info;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes.dex */
public class d {
    private static final String a = "2.0";
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Class<?> h = null;
    private static char[] n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private Context b;
    private TelephonyManager c;
    private WifiManager i;
    private String m;
    private a d = new a();
    private b j = null;
    private String k = null;
    private int l = 0;

    public d(Context context) {
        String str;
        this.b = null;
        this.c = null;
        this.i = null;
        this.m = null;
        this.b = context.getApplicationContext();
        String packageName = this.b.getPackageName();
        try {
            this.c = (TelephonyManager) this.b.getSystemService("phone");
            str = this.c.getDeviceId();
        } catch (Exception e2) {
            L.e(e2);
            str = null;
        }
        this.m = "&" + packageName + "&" + str;
        this.i = (WifiManager) this.b.getSystemService("wifi");
    }

    public String a() {
        try {
            return b(10);
        } catch (Exception e2) {
            L.e(e2);
            return null;
        }
    }

    public String a(int i) {
        try {
            return b(i);
        } catch (Exception e2) {
            L.e(e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(int i) {
        String str;
        String str2;
        if (i < 3) {
            i = 3;
        }
        try {
            a b2 = b();
            if (b2 == null || !b2.b()) {
                if (this.c != null && this.c.getClass().getMethod("getCellLocation", new Class[0]) != null) {
                    a(this.c.getCellLocation());
                }
            } else {
                L.e("new cell api is valid = " + b2.a(), new Object[0]);
                this.d = b2;
            }
            str = this.d.a();
        } catch (Exception e2) {
            L.e(e2);
            str = null;
        }
        if (str == null) {
            L.e("cell info = null", new Object[0]);
            str = "Z";
        }
        try {
            if (this.j == null || this.j.c()) {
                this.j = new b(this.i.getScanResults());
            }
            str2 = this.j.a(i);
        } catch (Exception e3) {
            e = e3;
            str2 = null;
        }
        try {
            L.e("wifi info = " + str2, new Object[0]);
        } catch (Exception e4) {
            e = e4;
            L.e(e);
            if (str2 != null) {
            }
            if (str.equals("Z")) {
            }
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str.equals("Z")) {
            return a(str + Info.kBaiduTimeKey + System.currentTimeMillis() + this.m);
        }
        return null;
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.c != null) {
            a aVar = new a();
            String networkOperator = this.c.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.d.c;
                        }
                        aVar.c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] charArray = substring.toCharArray();
                        while (i < charArray.length && Character.isDigit(charArray[i])) {
                            i++;
                        }
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.d.d;
                    }
                    aVar.d = intValue2;
                } catch (Exception e2) {
                    L.e(e2);
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                aVar.a = ((GsmCellLocation) cellLocation).getLac();
                aVar.b = ((GsmCellLocation) cellLocation).getCid();
                aVar.e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                aVar.e = 'w';
                if (h == null) {
                    try {
                        h = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        e = h.getMethod("getBaseStationId", new Class[0]);
                        f = h.getMethod("getNetworkId", new Class[0]);
                        g = h.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e3) {
                        h = null;
                        return;
                    }
                }
                if (h != null && h.isInstance(cellLocation)) {
                    try {
                        int intValue3 = ((Integer) g.invoke(cellLocation, new Object[0])).intValue();
                        if (intValue3 < 0) {
                            intValue3 = this.d.d;
                        }
                        aVar.d = intValue3;
                        aVar.b = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                        aVar.a = ((Integer) f.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e4) {
                        return;
                    }
                }
            }
            if (aVar.b()) {
                this.d = aVar;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.b() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        com.baidu.sapi2.utils.L.e(" !res.isValid()", new java.lang.Object[0]);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        com.baidu.sapi2.utils.L.e(" res.isValid()", new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a b() {
        a aVar = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                try {
                    List<CellInfo> allCellInfo = this.c.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        Iterator<CellInfo> it = allCellInfo.iterator();
                        a aVar2 = null;
                        while (true) {
                            try {
                                if (!it.hasNext()) {
                                    aVar = aVar2;
                                    break;
                                }
                                CellInfo next = it.next();
                                if (next.isRegistered()) {
                                    a a2 = a(next);
                                    if (a2 != null) {
                                        try {
                                            break;
                                        } catch (Exception e2) {
                                            aVar = a2;
                                            e = e2;
                                            L.e(e);
                                            return aVar;
                                        }
                                    }
                                    aVar2 = a2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                aVar = aVar2;
                            }
                        }
                    } else {
                        L.e("getAllCellInfo =null", new Object[0]);
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (NoSuchMethodError e5) {
                L.e(e5);
            }
        }
        return aVar;
    }

    private a a(CellInfo cellInfo) {
        boolean z;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        a aVar = new a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            L.e("CellInfoGsm", new Object[0]);
            aVar.c = c(cellIdentity.getMcc());
            aVar.d = c(cellIdentity.getMnc());
            aVar.a = c(cellIdentity.getLac());
            aVar.b = c(cellIdentity.getCid());
            aVar.e = 'g';
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            L.e("CellInfoCdma", new Object[0]);
            aVar.d = c(cellIdentity2.getSystemId());
            aVar.a = c(cellIdentity2.getNetworkId());
            aVar.b = c(cellIdentity2.getBasestationId());
            aVar.e = 'w';
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            L.e("CellInfoLte", new Object[0]);
            aVar.c = c(cellIdentity3.getMcc());
            aVar.d = c(cellIdentity3.getMnc());
            aVar.a = c(cellIdentity3.getTac());
            aVar.b = c(cellIdentity3.getCi());
            aVar.e = 'g';
            z = true;
        } else {
            z = false;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    L.e("CellInfoWcdma", new Object[0]);
                    aVar.c = c(cellIdentity4.getMcc());
                    aVar.d = c(cellIdentity4.getMnc());
                    aVar.a = c(cellIdentity4.getLac());
                    aVar.b = c(cellIdentity4.getCid());
                    aVar.e = 'g';
                }
            } catch (Exception e2) {
                L.e(e2);
            }
        }
        L.e("mcc = " + aVar.c, new Object[0]);
        L.e("mnc = " + aVar.d, new Object[0]);
        L.e("lac = " + aVar.a, new Object[0]);
        L.e("cid = " + aVar.b, new Object[0]);
        return aVar;
    }

    private int c(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;

        private a() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return this.a > -1 && this.b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.e);
            stringBuffer.append("h");
            if (this.c != 460) {
                stringBuffer.append(this.c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)));
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class b {
        public List<ScanResult> a;
        private long c;

        public b(List<ScanResult> list) {
            this.a = null;
            this.c = 0L;
            this.a = list;
            this.c = System.currentTimeMillis();
            b();
        }

        public int a() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        public String a(int i) {
            boolean z;
            boolean z2;
            int i2;
            boolean z3;
            if (a() < 1) {
                return null;
            }
            boolean c = d.this.c();
            if (c) {
                i--;
                z = false;
            } else {
                z = true;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.a.size();
            int i3 = 0;
            int i4 = 0;
            boolean z4 = true;
            boolean z5 = z;
            while (true) {
                if (i3 >= size) {
                    z2 = z4;
                    break;
                }
                if (this.a.get(i3).level == 0) {
                    i2 = i4;
                    z2 = z4;
                    z3 = z5;
                } else {
                    String str = this.a.get(i3).BSSID;
                    int i5 = this.a.get(i3).level;
                    String replace = str.replace(":", "");
                    if (d.this.k != null && replace.equals(d.this.k)) {
                        d.this.l = StrictMath.abs(i5);
                        i2 = i4;
                        z2 = z4;
                        z3 = true;
                    } else {
                        if (i4 < i) {
                            stringBuffer.append("h");
                            stringBuffer.append(replace);
                            stringBuffer.append("m");
                            stringBuffer.append(StrictMath.abs(i5));
                            i2 = i4 + 1;
                            z2 = false;
                        } else {
                            i2 = i4;
                            z2 = z4;
                        }
                        if (i2 > i && z5) {
                            break;
                        }
                        z3 = z5;
                    }
                }
                i3++;
                z5 = z3;
                z4 = z2;
                i4 = i2;
            }
            String str2 = c ? "h" + d.this.k + "km" + d.this.l : null;
            if (!z2) {
                return str2 + stringBuffer.toString();
            }
            return str2;
        }

        private void b() {
            boolean z;
            if (a() >= 1) {
                boolean z2 = true;
                for (int size = this.a.size() - 1; size >= 1 && z2; size--) {
                    int i = 0;
                    z2 = false;
                    while (i < size) {
                        if (this.a.get(i).level < this.a.get(i + 1).level) {
                            this.a.set(i + 1, this.a.get(i));
                            this.a.set(i, this.a.get(i + 1));
                            z = true;
                        } else {
                            z = z2;
                        }
                        i++;
                        z2 = z;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        this.k = null;
        this.l = 0;
        WifiInfo connectionInfo = this.i.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(":", "") : null;
            if (replace.length() == 12) {
                this.k = new String(replace);
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private static String a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(MotionEventCompat.ACTION_MASK);
        byte nextInt2 = (byte) new Random().nextInt(MotionEventCompat.ACTION_MASK);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        int i3 = i2 + 1;
        bArr[i2] = nextInt;
        int i4 = i3 + 1;
        bArr[i3] = nextInt2;
        return a(bArr);
    }

    private static String a(byte[] bArr) {
        boolean z;
        boolean z2;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                z = true;
            } else {
                z = false;
            }
            int i4 = i3 << 8;
            if (i2 + 2 < bArr.length) {
                i4 |= bArr[i2 + 2] & 255;
                z2 = true;
            } else {
                z2 = false;
            }
            cArr[i + 3] = n[z2 ? 63 - (i4 & 63) : 64];
            int i5 = i4 >> 6;
            cArr[i + 2] = n[z ? 63 - (i5 & 63) : 64];
            int i6 = i5 >> 6;
            cArr[i + 1] = n[63 - (i6 & 63)];
            cArr[i + 0] = n[63 - ((i6 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }
}
