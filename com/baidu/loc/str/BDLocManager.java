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
import com.baidu.webkit.internal.ETAG;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes4.dex */
public class BDLocManager implements Debug {
    private static final String TAG = "loc tiny String";
    private static final long WIFI_SCAN_SPAN_MIN = 10000;
    private CellStateListener mCellListener;
    private Context mContext;
    private String mExtraInfo;
    private TelephonyManager mTeleman;
    private WifiManager mWifiman;
    private static Object lock = new Object();
    private static BDLocManager instance = null;
    private static Class<?> mCdmaClass = null;
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private BDCellInfo mCellInfo = new BDCellInfo();
    private WifiList mWifiList = null;
    private long mScanTime = 0;
    private String connectWifi = null;
    private int connecetWifiLevel = 0;
    private long time = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
        public boolean isValid() {
            return this.mLac > -1 && this.mCid > 0;
        }

        public String toCellString() {
            if (isValid()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append(this.mNetworkType);
                stringBuffer.append("h");
                if (this.mMcc != 460) {
                    stringBuffer.append(this.mMcc);
                }
                stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.mMnc), Integer.valueOf(this.mLac), Integer.valueOf(this.mCid)));
                return stringBuffer.toString();
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class CellStateListener extends PhoneStateListener {
        public CellStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                BDLocManager.this.setCellInfo(cellLocation);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public class WifiList {
        public List<ScanResult> wifiList;
        private long wifiTime;

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

        private void sort() {
            boolean z;
            if (size() < 1) {
                return;
            }
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

        public int size() {
            if (this.wifiList == null) {
                return 0;
            }
            return this.wifiList.size();
        }

        public String toString(int i) {
            boolean z;
            int i2;
            if (size() < 1) {
                return null;
            }
            boolean hasConnectWifi = BDLocManager.this.hasConnectWifi();
            if (hasConnectWifi) {
                i--;
                z = false;
            } else {
                z = true;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.wifiList.size();
            int i3 = 0;
            int i4 = 0;
            boolean z2 = true;
            boolean z3 = z;
            while (i3 < size) {
                if (this.wifiList.get(i3).level == 0) {
                    i2 = i4;
                } else {
                    String str = this.wifiList.get(i3).BSSID;
                    int i5 = this.wifiList.get(i3).level;
                    String replace = str.replace(":", "");
                    if (BDLocManager.this.connectWifi == null || !replace.equals(BDLocManager.this.connectWifi)) {
                        if (i4 < i) {
                            stringBuffer.append("h");
                            stringBuffer.append(replace);
                            stringBuffer.append("m");
                            stringBuffer.append(StrictMath.abs(i5));
                            i2 = i4 + 1;
                            z2 = false;
                        } else {
                            i2 = i4;
                        }
                        if (i2 > i && z3) {
                            break;
                        }
                    } else {
                        BDLocManager.this.connecetWifiLevel = StrictMath.abs(i5);
                        i2 = i4;
                        z3 = true;
                    }
                }
                i3++;
                i4 = i2;
            }
            String str2 = hasConnectWifi ? "h" + BDLocManager.this.connectWifi + "km" + BDLocManager.this.connecetWifiLevel : null;
            return !z2 ? str2 + stringBuffer.toString() : str2;
        }
    }

    BDLocManager(Context context) {
        this.mContext = null;
        this.mTeleman = null;
        this.mCellListener = null;
        this.mWifiman = null;
        this.mExtraInfo = null;
        this.mContext = context.getApplicationContext();
        String packageName = this.mContext.getPackageName();
        try {
            this.mTeleman = (TelephonyManager) this.mContext.getSystemService("phone");
            this.mCellListener = new CellStateListener();
            this.mTeleman.listen(this.mCellListener, 16);
        } catch (Exception e) {
        }
        this.mExtraInfo = ETAG.ITEM_SEPARATOR + packageName + ETAG.ITEM_SEPARATOR + ((String) null);
        this.mWifiman = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
    }

    private static String data2Base64(byte[] bArr) {
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
            cArr[i + 3] = alphabet[z2 ? 63 - (i4 & 63) : 64];
            int i5 = i4 >> 6;
            cArr[i + 2] = alphabet[z ? 63 - (i5 & 63) : 64];
            int i6 = i5 >> 6;
            cArr[i + 1] = alphabet[63 - (i6 & 63)];
            cArr[i + 0] = alphabet[63 - ((i6 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }

    private static String encode(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
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
        return data2Base64(bArr);
    }

    private BDCellInfo getBDCellInfo(CellInfo cellInfo) {
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        BDCellInfo bDCellInfo = new BDCellInfo();
        boolean z = false;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            bDCellInfo.mMcc = getValidValue(cellIdentity.getMcc());
            bDCellInfo.mMnc = getValidValue(cellIdentity.getMnc());
            bDCellInfo.mLac = getValidValue(cellIdentity.getLac());
            bDCellInfo.mCid = getValidValue(cellIdentity.getCid());
            bDCellInfo.mNetworkType = 'g';
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            bDCellInfo.mMnc = getValidValue(cellIdentity2.getSystemId());
            bDCellInfo.mLac = getValidValue(cellIdentity2.getNetworkId());
            bDCellInfo.mCid = getValidValue(cellIdentity2.getBasestationId());
            bDCellInfo.mNetworkType = 'w';
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            bDCellInfo.mMcc = getValidValue(cellIdentity3.getMcc());
            bDCellInfo.mMnc = getValidValue(cellIdentity3.getMnc());
            bDCellInfo.mLac = getValidValue(cellIdentity3.getTac());
            bDCellInfo.mCid = getValidValue(cellIdentity3.getCi());
            bDCellInfo.mNetworkType = 'g';
            z = true;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    bDCellInfo.mMcc = getValidValue(cellIdentity4.getMcc());
                    bDCellInfo.mMnc = getValidValue(cellIdentity4.getMnc());
                    bDCellInfo.mLac = getValidValue(cellIdentity4.getLac());
                    bDCellInfo.mCid = getValidValue(cellIdentity4.getCid());
                    bDCellInfo.mNetworkType = 'g';
                }
            } catch (Exception e) {
            }
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

    private String getLocStringData(int i) {
        String str;
        String str2;
        this.time = System.currentTimeMillis();
        if (i < 3) {
            i = 3;
        }
        try {
            str = this.mCellInfo != null ? this.mCellInfo.toCellString() : null;
        } catch (Exception e) {
            str = null;
        }
        if (str == null) {
            str = "Z";
        }
        try {
            if (this.mWifiList == null || this.mWifiList.needToFresh()) {
                this.mWifiList = new WifiList(this.mWifiman.getScanResults());
            }
            str2 = this.mWifiList.toString(i);
        } catch (Exception e2) {
            str2 = null;
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str.equals("Z")) {
            return null;
        }
        return encode(str + "t" + System.currentTimeMillis() + this.mExtraInfo) + "|qloc2";
    }

    private BDCellInfo getRegisteredBDCellInfo() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            try {
                List<CellInfo> allCellInfo = this.mTeleman.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                BDCellInfo bDCellInfo = null;
                for (CellInfo cellInfo : allCellInfo) {
                    try {
                        if (cellInfo.isRegistered()) {
                            BDCellInfo bDCellInfo2 = getBDCellInfo(cellInfo);
                            if (bDCellInfo2 != null) {
                                try {
                                    if (!bDCellInfo2.isValid()) {
                                        bDCellInfo2 = null;
                                    }
                                    return bDCellInfo2;
                                } catch (Exception e) {
                                    return bDCellInfo2;
                                }
                            }
                            bDCellInfo = bDCellInfo2;
                        }
                    } catch (Exception e2) {
                        return bDCellInfo;
                    }
                }
                return bDCellInfo;
            } catch (NoSuchMethodError e3) {
                return null;
            }
        } catch (Exception e4) {
            return null;
        }
    }

    private int getValidValue(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
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
            if (replace == null || replace.length() != 12) {
                return false;
            }
            this.connectWifi = new String(replace);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCellInfo(CellLocation cellLocation) {
        int i = 0;
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
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.mCellInfo.mMnc;
                    }
                    bDCellInfo.mMnc = intValue2;
                }
            } catch (Exception e) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            bDCellInfo.mLac = ((GsmCellLocation) cellLocation).getLac();
            bDCellInfo.mCid = ((GsmCellLocation) cellLocation).getCid();
            bDCellInfo.mNetworkType = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            bDCellInfo.mNetworkType = 'w';
            if (mCdmaClass == null) {
                try {
                    mCdmaClass = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception e2) {
                    mCdmaClass = null;
                    return;
                }
            }
            if (mCdmaClass != null && mCdmaClass.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    bDCellInfo.mMnc = systemId;
                    bDCellInfo.mCid = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    bDCellInfo.mLac = ((CdmaCellLocation) cellLocation).getNetworkId();
                } catch (Exception e3) {
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
        } catch (Exception e) {
            return null;
        }
    }

    public String getLocString(int i) {
        try {
            return getLocStringData(i);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean startWifiScan() {
        boolean z = false;
        if (this.mWifiman == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mScanTime;
        if (currentTimeMillis > WIFI_SCAN_SPAN_MIN || currentTimeMillis < 0) {
            if (this.mWifiman.isWifiEnabled()) {
                this.mWifiman.startScan();
                this.mScanTime = System.currentTimeMillis();
                return true;
            } else if (Build.VERSION.SDK_INT <= 17) {
                this.mScanTime = 0L;
                return false;
            } else {
                try {
                    if (this.mWifiman.isScanAlwaysAvailable()) {
                        this.mWifiman.startScan();
                        this.mScanTime = System.currentTimeMillis();
                        z = true;
                    } else {
                        this.mScanTime = 0L;
                    }
                    return z;
                } catch (Exception e) {
                    this.mScanTime = 0L;
                    return z;
                } catch (NoSuchMethodError e2) {
                    this.mScanTime = 0L;
                    return z;
                }
            }
        }
        return false;
    }
}
