package com.baidu.mobads.container.remote.location;

import android.content.Context;
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
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes2.dex */
public class LocationDexLoader {
    public static final String TAG = "loc tiny String";
    public static final long WIFI_SCAN_SPAN_MIN = 10000;
    public static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    public static Class<?> mCdmaClass;
    public static Method mMethodCid;
    public static Method mMethodLac;
    public static Method mMethodSid;
    public BDCellInfo mCellInfo = new BDCellInfo();
    public String mExtraInfo;
    public TelephonyManager mTeleman;

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
                int i = this.mMcc;
                if (i != 460) {
                    stringBuffer.append(i);
                }
                stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.mMnc), Integer.valueOf(this.mLac), Integer.valueOf(this.mCid)));
                return stringBuffer.toString();
            }
            return null;
        }
    }

    public LocationDexLoader(Context context, String str) {
        this.mTeleman = null;
        this.mExtraInfo = null;
        if (context != null) {
            this.mExtraInfo = "&" + str + "&null";
            try {
                this.mTeleman = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
            }
        }
    }

    public static String data2Base64(byte[] bArr) {
        boolean z;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < bArr.length) {
                i5 |= bArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = 64;
            cArr[i2 + 3] = alphabet[z2 ? 63 - (i5 & 63) : 64];
            int i8 = i5 >> 6;
            int i9 = i2 + 2;
            char[] cArr2 = alphabet;
            if (z) {
                i7 = 63 - (i8 & 63);
            }
            cArr[i9] = cArr2[i7];
            int i10 = i8 >> 6;
            char[] cArr3 = alphabet;
            cArr[i2 + 1] = cArr3[63 - (i10 & 63)];
            cArr[i2 + 0] = cArr3[63 - ((i10 >> 6) & 63)];
            i += 3;
            i2 += 4;
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
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        bArr[i2] = nextInt;
        bArr[i2 + 1] = nextInt2;
        return data2Base64(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00be A[Catch: Exception -> 0x00ef, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ef, blocks: (B:18:0x00ba, B:20:0x00be), top: B:25:0x00ba }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            bDCellInfo.mMnc = getValidValue(cellIdentity2.getSystemId());
            bDCellInfo.mLac = getValidValue(cellIdentity2.getNetworkId());
            bDCellInfo.mCid = getValidValue(cellIdentity2.getBasestationId());
            bDCellInfo.mNetworkType = 'w';
        } else {
            if (cellInfo instanceof CellInfoLte) {
                CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                bDCellInfo.mMcc = getValidValue(cellIdentity3.getMcc());
                bDCellInfo.mMnc = getValidValue(cellIdentity3.getMnc());
                bDCellInfo.mLac = getValidValue(cellIdentity3.getTac());
                bDCellInfo.mCid = getValidValue(cellIdentity3.getCi());
                bDCellInfo.mNetworkType = 'g';
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
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(e2.getMessage());
                }
            }
            return bDCellInfo;
        }
        z = true;
        if (intValue >= 18) {
            if (cellInfo instanceof CellInfoWcdma) {
            }
        }
        return bDCellInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocStringData(int i) {
        String str;
        BDCellInfo registeredBDCellInfo;
        try {
            registeredBDCellInfo = getRegisteredBDCellInfo();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
            str = null;
        }
        if (registeredBDCellInfo != null && registeredBDCellInfo.isValid()) {
            RemoteXAdLogger.getInstance().d("new cell api is valid = " + registeredBDCellInfo.toCellString());
            this.mCellInfo = registeredBDCellInfo;
            str = this.mCellInfo.toCellString();
            if (str == null) {
                RemoteXAdLogger.getInstance().d("cell info = null");
                str = "Z";
            }
            if (str.equals("Z")) {
                return encode(str + "t" + System.currentTimeMillis() + this.mExtraInfo);
            }
            return null;
        }
        setCellInfo(this.mTeleman.getCellLocation());
        str = this.mCellInfo.toCellString();
        if (str == null) {
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
                if (cellInfo.isRegistered() && (bDCellInfo = getBDCellInfo(cellInfo)) != null) {
                    if (bDCellInfo.isValid()) {
                        return bDCellInfo;
                    }
                    return null;
                }
            }
            return bDCellInfo;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th.getMessage());
            return null;
        }
    }

    private int getValidValue(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    private void setCellInfo(CellLocation cellLocation) {
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
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.mCellInfo.mMnc;
                    }
                    bDCellInfo.mMnc = intValue2;
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
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
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    mCdmaClass = cls;
                    mMethodCid = cls.getMethod("getBaseStationId", new Class[0]);
                    mMethodLac = mCdmaClass.getMethod("getNetworkId", new Class[0]);
                    mMethodSid = mCdmaClass.getMethod("getSystemId", new Class[0]);
                } catch (Exception unused) {
                    mCdmaClass = null;
                    return;
                }
            }
            Class<?> cls2 = mCdmaClass;
            if (cls2 != null && cls2.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) mMethodSid.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.mCellInfo.mMnc;
                    }
                    bDCellInfo.mMnc = intValue3;
                    bDCellInfo.mCid = ((Integer) mMethodCid.invoke(cellLocation, new Object[0])).intValue();
                    bDCellInfo.mLac = ((Integer) mMethodLac.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception unused2) {
                    return;
                }
            }
        }
        if (bDCellInfo.isValid()) {
            this.mCellInfo = bDCellInfo;
        }
    }

    public String getLocString() {
        if (PermissionUtils.hasPermission("permission_location")) {
            try {
                return getLocStringData(10);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
                return null;
            }
        }
        return "";
    }
}
