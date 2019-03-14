package com.baidu.loctp.str;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes3.dex */
public class BDLocManager {
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Class<?> h = null;
    private static char[] r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private Context b;
    private TelephonyManager c;
    private WifiManager i;
    private Object k;
    private Method l;
    private String q;
    private final long a = 5000;
    private a d = new a();
    private WifiList j = null;
    private boolean m = true;
    private long n = 0;
    private String o = null;
    private int p = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class WifiList {
        public List<ScanResult> _WifiList;
        private long b;

        public WifiList(List<ScanResult> list) {
            this._WifiList = null;
            this.b = 0L;
            this._WifiList = list;
            this.b = System.currentTimeMillis();
            a();
        }

        private void a() {
            boolean z;
            if (size() < 1) {
                return;
            }
            boolean z2 = true;
            for (int size = this._WifiList.size() - 1; size >= 1 && z2; size--) {
                int i = 0;
                z2 = false;
                while (i < size) {
                    if (this._WifiList.get(i).level < this._WifiList.get(i + 1).level) {
                        this._WifiList.set(i + 1, this._WifiList.get(i));
                        this._WifiList.set(i, this._WifiList.get(i + 1));
                        z = true;
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }

        public int size() {
            if (this._WifiList == null) {
                return 0;
            }
            return this._WifiList.size();
        }

        public String toString(int i) {
            boolean z;
            boolean z2;
            int i2;
            boolean z3;
            if (size() < 1) {
                return null;
            }
            boolean a = BDLocManager.this.a();
            if (a) {
                i--;
                z = false;
            } else {
                z = true;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this._WifiList.size();
            int i3 = 0;
            int i4 = 0;
            boolean z4 = true;
            boolean z5 = z;
            while (true) {
                if (i3 >= size) {
                    z2 = z4;
                    break;
                }
                if (this._WifiList.get(i3).level == 0) {
                    i2 = i4;
                    z2 = z4;
                    z3 = z5;
                } else {
                    String str = this._WifiList.get(i3).BSSID;
                    int i5 = this._WifiList.get(i3).level;
                    String replace = str.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                    if (BDLocManager.this.o == null || !replace.equals(BDLocManager.this.o)) {
                        if (i4 < i) {
                            stringBuffer.append("h");
                            stringBuffer.append(replace);
                            stringBuffer.append(Config.MODEL);
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
                    } else {
                        BDLocManager.this.p = StrictMath.abs(i5);
                        i2 = i4;
                        z2 = z4;
                        z3 = true;
                    }
                }
                i3++;
                z5 = z3;
                z4 = z2;
                i4 = i2;
            }
            String str2 = a ? "h" + BDLocManager.this.o + "km" + BDLocManager.this.p : null;
            return !z2 ? str2 + stringBuffer.toString() : str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
        public boolean a() {
            return this.a > -1 && this.b > 0;
        }

        public String toString() {
            if (a()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append(this.e);
                stringBuffer.append("h");
                if (this.c != 460) {
                    stringBuffer.append(this.c);
                }
                stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)));
                return stringBuffer.toString();
            }
            return null;
        }
    }

    public BDLocManager(Context context) {
        String str;
        this.b = null;
        this.c = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.b = context.getApplicationContext();
        String packageName = this.b.getPackageName();
        try {
            this.c = (TelephonyManager) this.b.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            str = this.c.getDeviceId();
        } catch (Exception e2) {
            str = null;
        }
        this.q = "&" + packageName + "&" + str;
        this.i = (WifiManager) this.b.getSystemService("wifi");
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField == null) {
                return;
            }
            declaredField.setAccessible(true);
            this.k = declaredField.get(this.i);
            this.l = this.k.getClass().getDeclaredMethod("startScan", Boolean.TYPE);
            if (this.l != null) {
                this.l.setAccessible(true);
            }
        } catch (Exception e3) {
        }
    }

    private String a(int i) {
        String str;
        String str2;
        if (i < 3) {
            i = 3;
        }
        try {
            a(this.c.getCellLocation());
            str = this.d.toString();
        } catch (Exception e2) {
            str = null;
        }
        if (str == null) {
            str = "Z";
        }
        try {
            if (this.j == null || this.j.b()) {
                this.j = new WifiList(this.i.getScanResults());
            }
            str2 = this.j.toString(i);
        } catch (Exception e3) {
            str2 = null;
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str.equals("Z")) {
            return null;
        }
        return a(str + "t" + System.currentTimeMillis() + this.q);
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
            cArr[i + 3] = r[z2 ? 63 - (i4 & 63) : 64];
            int i5 = i4 >> 6;
            cArr[i + 2] = r[z ? 63 - (i5 & 63) : 64];
            int i6 = i5 >> 6;
            cArr[i + 1] = r[63 - (i6 & 63)];
            cArr[i + 0] = r[63 - ((i6 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation == null || this.c == null) {
            return;
        }
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
        if (aVar.a()) {
            this.d = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        this.o = null;
        this.p = 0;
        WifiInfo connectionInfo = this.i.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "") : null;
            if (replace.length() == 12) {
                this.o = new String(replace);
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public String getLocString() {
        try {
            return a(3);
        } catch (Exception e2) {
            return null;
        }
    }

    public String getLocString(int i) {
        try {
            return a(i);
        } catch (Exception e2) {
            return null;
        }
    }

    public boolean startWifiScan() {
        if (this.i == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.n;
        if (currentTimeMillis > 5000 || currentTimeMillis < 0) {
            if (!this.i.isWifiEnabled()) {
                this.n = 0L;
                return false;
            }
            if (this.l == null || this.k == null) {
                this.i.startScan();
            } else {
                try {
                    this.l.invoke(this.k, Boolean.valueOf(this.m));
                } catch (Exception e2) {
                    this.i.startScan();
                }
            }
            this.n = System.currentTimeMillis();
            return true;
        }
        return false;
    }
}
