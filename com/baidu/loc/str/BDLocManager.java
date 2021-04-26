package com.baidu.loc.str;

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
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes2.dex */
public class BDLocManager implements Debug {
    public static final String TAG = "loc tiny String";
    public static final long WIFI_SCAN_SPAN_MIN = 10000;
    public static BDLocManager instance;
    public static Class<?> mCdmaClass;
    public CellStateListener mCellListener;
    public Context mContext;
    public String mExtraInfo;
    public TelephonyManager mTeleman;
    public WifiManager mWifiman;
    public static Object lock = new Object();
    public static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    public BDCellInfo mCellInfo = new BDCellInfo();
    public WifiList mWifiList = null;
    public long mScanTime = 0;
    public String connectWifi = null;
    public int connecetWifiLevel = 0;
    public long time = System.currentTimeMillis();

    /* loaded from: classes2.dex */
    public class BDCellInfo {
        public int mCid;
        public int mLac;
        public int mMcc;
        public int mMnc;
        public char mNetworkType;

        public BDCellInfo() {
            this.mLac = -1;
            this.mCid = -1;
            this.mMcc = -1;
            this.mMnc = -1;
            this.mNetworkType = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mLac > -1 && this.mCid > 0;
        }

        public String toCellString() {
            if (isValid()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append(this.mNetworkType);
                stringBuffer.append("h");
                int i2 = this.mMcc;
                if (i2 != 460) {
                    stringBuffer.append(i2);
                }
                stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.mMnc), Integer.valueOf(this.mLac), Integer.valueOf(this.mCid)));
                return stringBuffer.toString();
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class CellStateListener extends PhoneStateListener {
        public CellStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                BDLocManager.this.setCellInfo(cellLocation);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class WifiList {
        public List<ScanResult> wifiList;
        public long wifiTime;

        public WifiList(List<ScanResult> list) {
            this.wifiList = null;
            this.wifiTime = 0L;
            this.wifiList = list;
            this.wifiTime = System.currentTimeMillis();
            sort();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean needToFresh() {
            long currentTimeMillis = System.currentTimeMillis() - this.wifiTime;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        private void sort() {
            /*
                r7 = this;
                int r0 = r7.size()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.wifiList
                int r0 = r0.size()
                int r0 = r0 - r1
                r2 = 1
            L10:
                if (r0 < r1) goto L4d
                if (r2 == 0) goto L4d
                r2 = 0
                r3 = 0
            L16:
                if (r2 >= r0) goto L49
                java.util.List<android.net.wifi.ScanResult> r4 = r7.wifiList
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r5 = r7.wifiList
                int r6 = r2 + 1
                java.lang.Object r5 = r5.get(r6)
                android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
                int r5 = r5.level
                if (r4 >= r5) goto L47
                java.util.List<android.net.wifi.ScanResult> r3 = r7.wifiList
                java.lang.Object r3 = r3.get(r6)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.wifiList
                java.lang.Object r5 = r4.get(r2)
                r4.set(r6, r5)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.wifiList
                r4.set(r2, r3)
                r3 = 1
            L47:
                r2 = r6
                goto L16
            L49:
                int r0 = r0 + (-1)
                r2 = r3
                goto L10
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.loc.str.BDLocManager.WifiList.sort():void");
        }

        public int size() {
            List<ScanResult> list = this.wifiList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString(int i2) {
            int i3;
            boolean z;
            if (size() < 1) {
                return null;
            }
            boolean hasConnectWifi = BDLocManager.this.hasConnectWifi();
            if (hasConnectWifi) {
                i3 = i2 - 1;
                z = false;
            } else {
                i3 = i2;
                z = true;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.wifiList.size();
            int i4 = 0;
            boolean z2 = true;
            for (int i5 = 0; i5 < size; i5++) {
                if (this.wifiList.get(i5).level != 0) {
                    String str = this.wifiList.get(i5).BSSID;
                    int i6 = this.wifiList.get(i5).level;
                    String replace = str.replace(":", "");
                    if (BDLocManager.this.connectWifi == null || !replace.equals(BDLocManager.this.connectWifi)) {
                        if (i4 < i3) {
                            stringBuffer.append("h");
                            stringBuffer.append(replace);
                            stringBuffer.append("m");
                            stringBuffer.append(StrictMath.abs(i6));
                            i4++;
                            z2 = false;
                        }
                        if (i4 > i3 && z) {
                            break;
                        }
                    } else {
                        BDLocManager.this.connecetWifiLevel = StrictMath.abs(i6);
                        z = true;
                    }
                }
            }
            String str2 = hasConnectWifi ? "h" + BDLocManager.this.connectWifi + "km" + BDLocManager.this.connecetWifiLevel : null;
            if (z2) {
                return str2;
            }
            return str2 + stringBuffer.toString();
        }
    }

    public BDLocManager(Context context) {
        this.mContext = null;
        this.mTeleman = null;
        this.mCellListener = null;
        this.mWifiman = null;
        this.mExtraInfo = null;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        String packageName = applicationContext.getPackageName();
        try {
            this.mTeleman = (TelephonyManager) this.mContext.getSystemService("phone");
            CellStateListener cellStateListener = new CellStateListener();
            this.mCellListener = cellStateListener;
            this.mTeleman.listen(cellStateListener, 16);
        } catch (Exception unused) {
        }
        this.mExtraInfo = "&" + packageName + "&" + ((String) null);
        this.mWifiman = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
    }

    public static String data2Base64(byte[] bArr) {
        boolean z;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = (bArr[i2] & 255) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < bArr.length) {
                i4 |= bArr[i5] & 255;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < bArr.length) {
                i6 |= bArr[i7] & 255;
            } else {
                z2 = false;
            }
            int i8 = 64;
            cArr[i3 + 3] = alphabet[z2 ? 63 - (i6 & 63) : 64];
            int i9 = i6 >> 6;
            int i10 = i3 + 2;
            char[] cArr2 = alphabet;
            if (z) {
                i8 = 63 - (i9 & 63);
            }
            cArr[i10] = cArr2[i8];
            int i11 = i9 >> 6;
            char[] cArr3 = alphabet;
            cArr[i3 + 1] = cArr3[63 - (i11 & 63)];
            cArr[i3 + 0] = cArr3[63 - ((i11 >> 6) & 63)];
            i2 += 3;
            i3 += 4;
        }
        return new String(cArr);
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            bArr[i3] = (byte) (bytes[i2] ^ nextInt);
            i2++;
            i3++;
        }
        bArr[i3] = nextInt;
        bArr[i3 + 1] = nextInt2;
        return data2Base64(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6 A[Catch: Exception -> 0x00e6, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e6, blocks: (B:19:0x00b2, B:21:0x00b6), top: B:24:0x00b2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BDCellInfo getBDCellInfo(CellInfo cellInfo) {
        int ci;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        BDCellInfo bDCellInfo = new BDCellInfo();
        boolean z = false;
        if (!(cellInfo instanceof CellInfoGsm)) {
            if (!(cellInfo instanceof CellInfoCdma)) {
                if (cellInfo instanceof CellInfoLte) {
                    CellIdentityLte cellIdentity = ((CellInfoLte) cellInfo).getCellIdentity();
                    bDCellInfo.mMcc = getValidValue(cellIdentity.getMcc());
                    bDCellInfo.mMnc = getValidValue(cellIdentity.getMnc());
                    bDCellInfo.mLac = getValidValue(cellIdentity.getTac());
                    ci = cellIdentity.getCi();
                }
                if (intValue >= 18) {
                    if (cellInfo instanceof CellInfoWcdma) {
                    }
                }
                return bDCellInfo;
            }
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            bDCellInfo.mMnc = getValidValue(cellIdentity2.getSystemId());
            bDCellInfo.mLac = getValidValue(cellIdentity2.getNetworkId());
            bDCellInfo.mCid = getValidValue(cellIdentity2.getBasestationId());
            bDCellInfo.mNetworkType = 'w';
            z = true;
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        bDCellInfo.mMcc = getValidValue(cellIdentity3.getMcc());
                        bDCellInfo.mMnc = getValidValue(cellIdentity3.getMnc());
                        bDCellInfo.mLac = getValidValue(cellIdentity3.getLac());
                        bDCellInfo.mCid = getValidValue(cellIdentity3.getCid());
                        bDCellInfo.mNetworkType = 'g';
                    }
                } catch (Exception unused) {
                }
            }
            return bDCellInfo;
        }
        CellIdentityGsm cellIdentity4 = ((CellInfoGsm) cellInfo).getCellIdentity();
        bDCellInfo.mMcc = getValidValue(cellIdentity4.getMcc());
        bDCellInfo.mMnc = getValidValue(cellIdentity4.getMnc());
        bDCellInfo.mLac = getValidValue(cellIdentity4.getLac());
        ci = cellIdentity4.getCid();
        bDCellInfo.mCid = getValidValue(ci);
        bDCellInfo.mNetworkType = 'g';
        z = true;
        if (intValue >= 18) {
        }
        return bDCellInfo;
    }

    public static BDLocManager getInstance(Context context) {
        BDLocManager bDLocManager;
        synchronized (lock) {
            if (instance == null) {
                instance = new BDLocManager(context);
            }
            bDLocManager = instance;
        }
        return bDLocManager;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(1:3)|4|(2:5|6)|(10:8|9|(1:11)|12|13|(1:27)|17|(1:19)|20|(1:22)(2:24|25))|30|9|(0)|12|13|(1:15)|27|17|(0)|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocStringData(int i2) {
        String str;
        String str2;
        this.time = System.currentTimeMillis();
        if (i2 < 3) {
            i2 = 3;
        }
        if (this.mCellInfo != null) {
            str = this.mCellInfo.toCellString();
            if (str == null) {
                str = "Z";
            }
            if (this.mWifiList != null || this.mWifiList.needToFresh()) {
                this.mWifiList = new WifiList(this.mWifiman.getScanResults());
            }
            str2 = this.mWifiList.toString(i2);
            if (str2 != null) {
                str = str + str2;
            }
            if (str.equals("Z")) {
                return encode(str + "t" + System.currentTimeMillis() + this.mExtraInfo) + "|qloc2";
            }
            return null;
        }
        str = null;
        if (str == null) {
        }
        if (this.mWifiList != null) {
        }
        this.mWifiList = new WifiList(this.mWifiman.getScanResults());
        str2 = this.mWifiList.toString(i2);
        if (str2 != null) {
        }
        if (str.equals("Z")) {
        }
    }

    private BDCellInfo getRegisteredBDCellInfo() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.mTeleman.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            BDCellInfo bDCellInfo = null;
            for (CellInfo cellInfo : allCellInfo) {
                try {
                    if (cellInfo.isRegistered() && (bDCellInfo = getBDCellInfo(cellInfo)) != null) {
                        if (bDCellInfo.isValid()) {
                            return bDCellInfo;
                        }
                        return null;
                    }
                } catch (Exception unused) {
                }
            }
            return bDCellInfo;
        } catch (Exception | NoSuchMethodError unused2) {
            return null;
        }
    }

    private int getValidValue(int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasConnectWifi() {
        this.connectWifi = null;
        this.connecetWifiLevel = 0;
        WifiInfo connectionInfo = this.mWifiman.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(":", "") : null;
            if (replace != null && replace.length() == 12) {
                this.connectWifi = new String(replace);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCellInfo(CellLocation cellLocation) {
        if (cellLocation == null || this.mTeleman == null) {
            return;
        }
        BDCellInfo bDCellInfo = new BDCellInfo();
        String networkOperator = this.mTeleman.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.mCellInfo.mMcc;
                    }
                    bDCellInfo.mMcc = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.mCellInfo.mMnc;
                    }
                    bDCellInfo.mMnc = intValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            bDCellInfo.mLac = gsmCellLocation.getLac();
            bDCellInfo.mCid = gsmCellLocation.getCid();
            bDCellInfo.mNetworkType = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            bDCellInfo.mNetworkType = 'w';
            if (mCdmaClass == null) {
                try {
                    mCdmaClass = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    mCdmaClass = null;
                    return;
                }
            }
            Class<?> cls = mCdmaClass;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    bDCellInfo.mMnc = systemId;
                    bDCellInfo.mCid = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    bDCellInfo.mLac = ((CdmaCellLocation) cellLocation).getNetworkId();
                } catch (Exception unused3) {
                    return;
                }
            }
        }
        if (bDCellInfo.isValid()) {
            this.mCellInfo = bDCellInfo;
        }
    }

    public String getLocString() {
        try {
            return getLocStringData(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getLocString(int i2) {
        try {
            return getLocStringData(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean startWifiScan() {
        if (this.mWifiman == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mScanTime;
        if (currentTimeMillis > 10000 || currentTimeMillis < 0) {
            if (this.mWifiman.isWifiEnabled()) {
                this.mWifiman.startScan();
                this.mScanTime = System.currentTimeMillis();
                return true;
            } else if (Build.VERSION.SDK_INT <= 17) {
                this.mScanTime = 0L;
                return false;
            } else {
                try {
                    if (!this.mWifiman.isScanAlwaysAvailable()) {
                        this.mScanTime = 0L;
                        return false;
                    }
                    this.mWifiman.startScan();
                    this.mScanTime = System.currentTimeMillis();
                    return true;
                } catch (Exception unused) {
                    this.mScanTime = 0L;
                    return false;
                } catch (NoSuchMethodError unused2) {
                    this.mScanTime = 0L;
                    return false;
                }
            }
        }
        return false;
    }
}
