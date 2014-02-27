package com.baidu.loc.strWebApp;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
public class BDLocManager {
    private Context mContext;
    private TelephonyManager mTeleman;
    private WifiManager mWifiman;
    private Method proxyStartScan;
    private Object serviceProxy;
    private static Method mMethodCid = null;
    private static Method mMethodLac = null;
    private static Method mMethodSid = null;
    private static Class<?> mCdmaClass = null;
    private final long WIFI_SCAN_SPAN_MIN = 5000;
    private CellInfo mCellInfo = new CellInfo();
    private WifiList mWifiList = null;
    private boolean activeScan = true;
    private long mScanTime = 0;
    private String connectWifi = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CellInfo {
        public int mCid;
        public int mLac;
        public int mMcc;
        public int mMnc;
        public char mNetworkType;

        private CellInfo() {
            this.mLac = -1;
            this.mCid = -1;
            this.mMcc = -1;
            this.mMnc = -1;
            this.mNetworkType = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mLac >= 0 && this.mCid > 0;
        }

        public String toString() {
            if (isValid()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append(this.mNetworkType);
                stringBuffer.append("h");
                if (this.mMcc != 460) {
                    stringBuffer.append(this.mMcc);
                }
                stringBuffer.append(String.format("h%xh%xh%x", Integer.valueOf(this.mMnc), Integer.valueOf(this.mLac), Integer.valueOf(this.mCid)));
                return stringBuffer.toString();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class WifiList {
        public List<ScanResult> _WifiList;
        private long _WifiTime;

        public WifiList(List<ScanResult> list) {
            this._WifiList = null;
            this._WifiTime = 0L;
            this._WifiList = list;
            this._WifiTime = System.currentTimeMillis();
            sort();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean NeedToFresh() {
            long currentTimeMillis = System.currentTimeMillis() - this._WifiTime;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }

        private void sort() {
            boolean z;
            if (size() <= 0) {
                return;
            }
            boolean z2 = true;
            for (int size = this._WifiList.size() - 1; size > 0 && z2; size--) {
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

        public int size() {
            if (this._WifiList == null) {
                return 0;
            }
            return this._WifiList.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0093 A[EDGE_INSN: B:30:0x0093->B:25:0x0093 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x005e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString(int i) {
            int i2;
            int i3 = 1;
            if (size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this._WifiList.size();
            int i4 = 0;
            boolean z = true;
            while (i4 < size) {
                if (this._WifiList.get(i4).level != 0) {
                    if (z) {
                        String replace = this._WifiList.get(i4).BSSID.replace(":", "");
                        if (BDLocManager.this.connectWifi == null || !replace.equals(BDLocManager.this.connectWifi)) {
                            stringBuffer.append("h");
                            stringBuffer.append(replace);
                            z = false;
                            i2 = i3 + 1;
                            if (i2 <= i) {
                                break;
                            }
                            i4++;
                            z = z;
                            i3 = i2;
                        }
                    } else {
                        String replace2 = this._WifiList.get(i4).BSSID.replace(":", "");
                        if (BDLocManager.this.connectWifi == null || !replace2.equals(BDLocManager.this.connectWifi)) {
                            stringBuffer.append("h");
                            stringBuffer.append(replace2);
                            i2 = i3 + 1;
                            if (i2 <= i) {
                            }
                        }
                    }
                }
                i2 = i3;
                i4++;
                z = z;
                i3 = i2;
            }
            if (z) {
                return null;
            }
            return stringBuffer.toString();
        }
    }

    public BDLocManager(Context context) {
        this.mContext = null;
        this.mTeleman = null;
        this.mWifiman = null;
        this.serviceProxy = null;
        this.proxyStartScan = null;
        this.mContext = context;
        this.mTeleman = (TelephonyManager) this.mContext.getSystemService("phone");
        this.mWifiman = (WifiManager) this.mContext.getSystemService("wifi");
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField == null) {
                return;
            }
            declaredField.setAccessible(true);
            this.serviceProxy = declaredField.get(this.mWifiman);
            this.proxyStartScan = this.serviceProxy.getClass().getDeclaredMethod("startScan", Boolean.TYPE);
            if (this.proxyStartScan != null) {
                this.proxyStartScan.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x0013: CAST (r1v5 char A[REMOVE]) = (char) (wrap: int : 0x0011: ARITH  (r1v4 int A[REMOVE]) = (wrap: int : 0x000f: ARITH  (r1v3 int A[REMOVE]) = (wrap: int : ?: ARITH  null = (r3v0 char) - ('/' char)) * (2 int)) + (97 int)))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x0042: CAST (r1v1 char A[REMOVE]) = (char) (wrap: int : ?: ARITH  null = (r3v0 char) - (' ' char)))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : ?: CAST (int) (r3v0 char))] */
    private String encryptChar(char c) {
        return (c >= ':' || c <= '/') ? (c >= '[' || c <= '@') ? (c >= '{' || c <= '`') ? new StringBuilder().append(c).toString() : new StringBuilder().append((char) (c - ' ')).toString() : new StringBuilder().append((int) c).toString() : new StringBuilder().append((char) (((c - '/') * 2) + 97)).toString();
    }

    private String getApinfo() {
        try {
            return getLocStringData(4);
        } catch (Exception e) {
            return null;
        }
    }

    private String getConnectWifiMac() {
        this.connectWifi = null;
        WifiInfo connectionInfo = this.mWifiman.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(":", "") : null;
            if (replace.length() == 12) {
                this.connectWifi = new String(replace);
                return "h" + replace + "k";
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private String getImei() {
        try {
            return this.mTeleman.getDeviceId();
        } catch (Exception e) {
            return " ";
        }
    }

    private String getLocStringData(int i) {
        setCellInfo(this.mTeleman.getCellLocation());
        String cellInfo = this.mCellInfo.toString();
        if (cellInfo == null) {
            cellInfo = "Z";
        }
        if (i <= 0) {
            i = 1;
        }
        String connectWifiMac = getConnectWifiMac();
        if (connectWifiMac != null) {
            cellInfo = cellInfo + connectWifiMac;
            i--;
        }
        if (this.mWifiList == null || this.mWifiList.NeedToFresh()) {
            this.mWifiList = new WifiList(this.mWifiman.getScanResults());
        }
        String wifiList = this.mWifiList.toString(i);
        if (wifiList != null) {
            cellInfo = cellInfo + wifiList;
        }
        if (cellInfo.equals("Z")) {
            return null;
        }
        return cellInfo;
    }

    private void setCellInfo(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation == null || this.mTeleman == null) {
            return;
        }
        CellInfo cellInfo = new CellInfo();
        String networkOperator = this.mTeleman.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.mCellInfo.mMcc;
                    }
                    cellInfo.mMcc = intValue;
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
                    intValue2 = this.mCellInfo.mMnc;
                }
                cellInfo.mMnc = intValue2;
            } catch (Exception e) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            cellInfo.mLac = ((GsmCellLocation) cellLocation).getLac();
            cellInfo.mCid = ((GsmCellLocation) cellLocation).getCid();
            cellInfo.mNetworkType = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            cellInfo.mNetworkType = 'w';
            if (mCdmaClass == null) {
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    mCdmaClass = cls;
                    mMethodCid = cls.getMethod("getBaseStationId", new Class[0]);
                    mMethodLac = mCdmaClass.getMethod("getNetworkId", new Class[0]);
                    mMethodSid = mCdmaClass.getMethod("getSystemId", new Class[0]);
                } catch (Exception e2) {
                    mCdmaClass = null;
                    return;
                }
            }
            if (mCdmaClass != null && mCdmaClass.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) mMethodSid.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.mCellInfo.mMnc;
                    }
                    cellInfo.mMnc = intValue3;
                    cellInfo.mCid = ((Integer) mMethodCid.invoke(cellLocation, new Object[0])).intValue();
                    cellInfo.mLac = ((Integer) mMethodLac.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e3) {
                    return;
                }
            }
        }
        if (cellInfo.isValid()) {
            this.mCellInfo = cellInfo;
        }
    }

    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        int i = 0;
        while (i < str.length()) {
            str2 = i < 50 ? str2 + encryptChar(str.charAt(i)) : str2 + str.charAt(i);
            i++;
        }
        return str2;
    }

    public String getLocString() {
        try {
            String apinfo = getApinfo();
            if (apinfo == null) {
                return null;
            }
            return encrypt(getImei() + "&" + apinfo);
        } catch (Exception e) {
            return null;
        }
    }
}
