package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
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
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes.dex */
public class SapiBDLocManager {
    private static final String a = "2.0";
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Class<?> h = null;
    private static char[] n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private static String o;
    private Context b;
    private TelephonyManager c;
    private WifiManager i;
    private String m;
    private BDCellInfo d = new BDCellInfo();
    private WifiList j = null;
    private String k = null;
    private int l = 0;

    public SapiBDLocManager(Context context) {
        String str;
        this.b = null;
        this.c = null;
        this.i = null;
        this.m = null;
        this.b = context.getApplicationContext();
        String packageName = this.b.getPackageName();
        try {
            this.c = (TelephonyManager) this.b.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            str = this.c.getDeviceId();
        } catch (Exception e2) {
            str = null;
        }
        this.m = "&" + packageName + "&" + str;
        this.i = (WifiManager) this.b.getSystemService("wifi");
    }

    public String getLocString() {
        try {
            return a(10);
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    public String getLocString(final int i) {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.utils.SapiBDLocManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String unused = SapiBDLocManager.o = SapiBDLocManager.this.a(i);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
        }));
        return o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i) {
        String str;
        String str2;
        if (i < 3) {
            i = 3;
        }
        try {
            BDCellInfo a2 = a();
            if (a2 == null || !a2.a()) {
                if (this.c != null && this.c.getClass().getMethod("getCellLocation", new Class[0]) != null) {
                    a(this.c.getCellLocation());
                }
            } else {
                Log.i("new cell api is valid = " + a2.toCellString(), new Object[0]);
                this.d = a2;
            }
            str = this.d.toCellString();
        } catch (Exception e2) {
            Log.i(e2);
            str = null;
        }
        if (str == null) {
            Log.e("cell info = null", new Object[0]);
            str = "Z";
        }
        try {
            if (this.j == null || this.j.b()) {
                this.j = new WifiList(this.i.getScanResults());
            }
            str2 = this.j.toString(i);
        } catch (Exception e3) {
            e = e3;
            str2 = null;
        }
        try {
            Log.e("wifi info = " + str2, new Object[0]);
        } catch (Exception e4) {
            e = e4;
            Log.e(e);
            if (str2 != null) {
            }
            if (str.equals("Z")) {
            }
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str.equals("Z")) {
            return b(str + Info.kBaiduTimeKey + System.currentTimeMillis() + this.m);
        }
        return null;
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.c != null) {
            BDCellInfo bDCellInfo = new BDCellInfo();
            String networkOperator = this.c.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.d.mMcc;
                        }
                        bDCellInfo.mMcc = intValue;
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
                        intValue2 = this.d.mMnc;
                    }
                    bDCellInfo.mMnc = intValue2;
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                bDCellInfo.mLac = ((GsmCellLocation) cellLocation).getLac();
                bDCellInfo.mCid = ((GsmCellLocation) cellLocation).getCid();
                bDCellInfo.mNetworkType = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                bDCellInfo.mNetworkType = 'w';
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
                            intValue3 = this.d.mMnc;
                        }
                        bDCellInfo.mMnc = intValue3;
                        bDCellInfo.mCid = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                        bDCellInfo.mLac = ((Integer) f.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e4) {
                        return;
                    }
                }
            }
            if (bDCellInfo.a()) {
                this.d = bDCellInfo;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r0.a() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        com.baidu.sapi2.base.debug.Log.e(" !res.isValid()", new java.lang.Object[0]);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        com.baidu.sapi2.base.debug.Log.e(" res.isValid()", new java.lang.Object[0]);
     */
    @TargetApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BDCellInfo a() {
        BDCellInfo bDCellInfo = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                try {
                    List<CellInfo> allCellInfo = this.c.getAllCellInfo();
                    if (allCellInfo != null && allCellInfo.size() > 0) {
                        Iterator<CellInfo> it = allCellInfo.iterator();
                        BDCellInfo bDCellInfo2 = null;
                        while (true) {
                            try {
                                if (!it.hasNext()) {
                                    bDCellInfo = bDCellInfo2;
                                    break;
                                }
                                CellInfo next = it.next();
                                if (next.isRegistered()) {
                                    BDCellInfo a2 = a(next);
                                    if (a2 != null) {
                                        try {
                                            break;
                                        } catch (Exception e2) {
                                            bDCellInfo = a2;
                                            e = e2;
                                            Log.i(e);
                                            return bDCellInfo;
                                        }
                                    }
                                    bDCellInfo2 = a2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bDCellInfo = bDCellInfo2;
                            }
                        }
                    } else {
                        Log.e("getAllCellInfo =null", new Object[0]);
                    }
                } catch (NoSuchMethodError e4) {
                    Log.i(e4);
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return bDCellInfo;
    }

    @TargetApi(18)
    private BDCellInfo a(CellInfo cellInfo) {
        boolean z;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        BDCellInfo bDCellInfo = new BDCellInfo();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            Log.e("CellInfoGsm", new Object[0]);
            bDCellInfo.mMcc = b(cellIdentity.getMcc());
            bDCellInfo.mMnc = b(cellIdentity.getMnc());
            bDCellInfo.mLac = b(cellIdentity.getLac());
            bDCellInfo.mCid = b(cellIdentity.getCid());
            bDCellInfo.mNetworkType = 'g';
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            Log.e("CellInfoCdma", new Object[0]);
            bDCellInfo.mMnc = b(cellIdentity2.getSystemId());
            bDCellInfo.mLac = b(cellIdentity2.getNetworkId());
            bDCellInfo.mCid = b(cellIdentity2.getBasestationId());
            bDCellInfo.mNetworkType = 'w';
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            Log.e("CellInfoLte", new Object[0]);
            bDCellInfo.mMcc = b(cellIdentity3.getMcc());
            bDCellInfo.mMnc = b(cellIdentity3.getMnc());
            bDCellInfo.mLac = b(cellIdentity3.getTac());
            bDCellInfo.mCid = b(cellIdentity3.getCi());
            bDCellInfo.mNetworkType = 'g';
            z = true;
        } else {
            z = false;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    Log.e("CellInfoWcdma", new Object[0]);
                    bDCellInfo.mMcc = b(cellIdentity4.getMcc());
                    bDCellInfo.mMnc = b(cellIdentity4.getMnc());
                    bDCellInfo.mLac = b(cellIdentity4.getLac());
                    bDCellInfo.mCid = b(cellIdentity4.getCid());
                    bDCellInfo.mNetworkType = 'g';
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
        Log.e("mcc = " + bDCellInfo.mMcc, new Object[0]);
        Log.e("mnc = " + bDCellInfo.mMnc, new Object[0]);
        Log.e("lac = " + bDCellInfo.mLac, new Object[0]);
        Log.e("cid = " + bDCellInfo.mCid, new Object[0]);
        return bDCellInfo;
    }

    private int b(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class BDCellInfo {
        public int mCid;
        public int mLac;
        public int mMcc;
        public int mMnc;
        public char mNetworkType;

        private BDCellInfo() {
            this.mLac = -1;
            this.mCid = -1;
            this.mMcc = -1;
            this.mMnc = -1;
            this.mNetworkType = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            return this.mLac > -1 && this.mCid > 0;
        }

        public String toCellString() {
            if (!a()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.mNetworkType);
            stringBuffer.append("h");
            if (this.mMcc != 460) {
                stringBuffer.append(this.mMcc);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.mMnc), Integer.valueOf(this.mLac), Integer.valueOf(this.mCid)));
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class WifiList {
        private long b;
        public List<ScanResult> wifiList;

        public WifiList(List<ScanResult> list) {
            this.wifiList = null;
            this.b = 0L;
            this.wifiList = list;
            this.b = System.currentTimeMillis();
            a();
        }

        public int size() {
            if (this.wifiList == null) {
                return 0;
            }
            return this.wifiList.size();
        }

        public String toString(int i) {
            boolean z;
            boolean z2;
            int i2;
            boolean z3;
            if (size() < 1) {
                return null;
            }
            boolean b = SapiBDLocManager.this.b();
            if (b) {
                i--;
                z = false;
            } else {
                z = true;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.wifiList.size();
            int i3 = 0;
            int i4 = 0;
            boolean z4 = true;
            boolean z5 = z;
            while (true) {
                if (i3 >= size) {
                    z2 = z4;
                    break;
                }
                if (this.wifiList.get(i3).level == 0) {
                    i2 = i4;
                    z2 = z4;
                    z3 = z5;
                } else {
                    String str = this.wifiList.get(i3).BSSID;
                    int i5 = this.wifiList.get(i3).level;
                    String replace = str.replace(SystemInfoUtil.COLON, "");
                    if (SapiBDLocManager.this.k != null && replace.equals(SapiBDLocManager.this.k)) {
                        SapiBDLocManager.this.l = StrictMath.abs(i5);
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
            String str2 = b ? "h" + SapiBDLocManager.this.k + "km" + SapiBDLocManager.this.l : null;
            if (!z2) {
                return str2 + stringBuffer.toString();
            }
            return str2;
        }

        private void a() {
            boolean z;
            if (size() >= 1) {
                boolean z2 = true;
                for (int size = this.wifiList.size() - 1; size >= 1 && z2; size--) {
                    int i = 0;
                    z2 = false;
                    while (i < size) {
                        if (this.wifiList.get(i).level < this.wifiList.get(i + 1).level) {
                            this.wifiList.set(i + 1, this.wifiList.get(i));
                            this.wifiList.set(i, this.wifiList.get(i + 1));
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
        public boolean b() {
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        this.k = null;
        this.l = 0;
        WifiInfo connectionInfo = this.i.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(SystemInfoUtil.COLON, "") : null;
            if (replace.length() == 12) {
                this.k = new String(replace);
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private static String b(String str) {
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
