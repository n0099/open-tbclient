package com.baidu.mobads.h;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
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
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.webkit.internal.ETAG;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes8.dex */
public class a {
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static Class<?> g = null;
    private static char[] n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private Context a;
    private TelephonyManager b;
    private WifiManager h;
    private String m;
    private C0122a c = new C0122a();
    private b i = null;
    private long j = 0;
    private String k = null;
    private int l = 0;

    public a(Context context) {
        String str;
        this.a = null;
        this.b = null;
        this.h = null;
        this.m = null;
        this.a = context.getApplicationContext();
        String packageName = this.a.getPackageName();
        try {
            this.b = (TelephonyManager) this.a.getSystemService("phone");
            str = (String) XAdSDKFoundationFacade.getInstance().getCommonUtils().a(this.b, XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("uvNYwANvpyP-iyfb"), new Object[0]);
        } catch (Exception e2) {
            str = null;
        }
        this.m = ETAG.ITEM_SEPARATOR + packageName + ETAG.ITEM_SEPARATOR + str;
        this.h = (WifiManager) this.a.getSystemService("wifi");
    }

    public String a() {
        try {
            return a(10);
        } catch (Exception e2) {
            return null;
        }
    }

    private String a(int i) {
        String str;
        String str2;
        if (i < 3) {
            i = 3;
        }
        try {
            C0122a b2 = b();
            if (b2 == null || !b2.b()) {
                a(this.b.getCellLocation());
            } else {
                this.c = b2;
            }
            str = this.c.a();
        } catch (Exception e2) {
            str = null;
        }
        if (str == null) {
            str = "Z";
        }
        try {
            if (this.i == null || this.i.c()) {
                this.i = new b(this.h.getScanResults());
            }
            str2 = this.i.a(i);
        } catch (Exception e3) {
            str2 = null;
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str.equals("Z")) {
            return null;
        }
        return a(str + "t" + System.currentTimeMillis() + this.m);
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.b != null) {
            C0122a c0122a = new C0122a();
            String networkOperator = this.b.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.c.c;
                        }
                        c0122a.c = intValue;
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
                        intValue2 = this.c.d;
                    }
                    c0122a.d = intValue2;
                } catch (Exception e2) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                c0122a.a = ((GsmCellLocation) cellLocation).getLac();
                c0122a.b = ((GsmCellLocation) cellLocation).getCid();
                c0122a.e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                c0122a.e = 'w';
                if (g == null) {
                    try {
                        g = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        d = g.getMethod("getBaseStationId", new Class[0]);
                        e = g.getMethod("getNetworkId", new Class[0]);
                        f = g.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e3) {
                        g = null;
                        return;
                    }
                }
                if (g != null && g.isInstance(cellLocation)) {
                    try {
                        int intValue3 = ((Integer) f.invoke(cellLocation, new Object[0])).intValue();
                        if (intValue3 < 0) {
                            intValue3 = this.c.d;
                        }
                        c0122a.d = intValue3;
                        c0122a.b = ((Integer) d.invoke(cellLocation, new Object[0])).intValue();
                        c0122a.a = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e4) {
                        return;
                    }
                }
            }
            if (c0122a.b()) {
                this.c = c0122a;
            }
        }
    }

    private C0122a b() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            try {
                List<CellInfo> allCellInfo = this.b.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                C0122a c0122a = null;
                for (CellInfo cellInfo : allCellInfo) {
                    try {
                        if (cellInfo.isRegistered()) {
                            C0122a a = a(cellInfo);
                            if (a != null) {
                                try {
                                    if (!a.b()) {
                                        a = null;
                                    }
                                    return a;
                                } catch (Exception e2) {
                                    return a;
                                }
                            }
                            c0122a = a;
                        }
                    } catch (Exception e3) {
                        return c0122a;
                    }
                }
                return c0122a;
            } catch (NoSuchMethodError e4) {
                return null;
            }
        } catch (Exception e5) {
            return null;
        }
    }

    private C0122a a(CellInfo cellInfo) {
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        C0122a c0122a = new C0122a();
        boolean z = false;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c0122a.c = b(cellIdentity.getMcc());
            c0122a.d = b(cellIdentity.getMnc());
            c0122a.a = b(cellIdentity.getLac());
            c0122a.b = b(cellIdentity.getCid());
            c0122a.e = 'g';
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c0122a.d = b(cellIdentity2.getSystemId());
            c0122a.a = b(cellIdentity2.getNetworkId());
            c0122a.b = b(cellIdentity2.getBasestationId());
            c0122a.e = 'w';
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            c0122a.c = b(cellIdentity3.getMcc());
            c0122a.d = b(cellIdentity3.getMnc());
            c0122a.a = b(cellIdentity3.getTac());
            c0122a.b = b(cellIdentity3.getCi());
            c0122a.e = 'g';
            z = true;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c0122a.c = b(cellIdentity4.getMcc());
                    c0122a.d = b(cellIdentity4.getMnc());
                    c0122a.a = b(cellIdentity4.getLac());
                    c0122a.b = b(cellIdentity4.getCid());
                    c0122a.e = 'g';
                }
            } catch (Exception e2) {
            }
        }
        return c0122a;
    }

    private int b(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0122a {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;

        private C0122a() {
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
    /* loaded from: classes8.dex */
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
            boolean c = a.this.c();
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
                    if (a.this.k != null && replace.equals(a.this.k)) {
                        a.this.l = StrictMath.abs(i5);
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
            String str2 = c ? "h" + a.this.k + "km" + a.this.l : null;
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
        WifiInfo connectionInfo = this.h.getConnectionInfo();
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
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
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
