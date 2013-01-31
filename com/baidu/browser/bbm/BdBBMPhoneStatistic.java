package com.baidu.browser.bbm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.baidu.browser.core.net.BdNetStat;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import java.io.ByteArrayOutputStream;
import java.util.List;
/* loaded from: classes.dex */
public final class BdBBMPhoneStatistic {
    private static final short SHORT_TPYE_BS_ID = 2;
    private static final short SHORT_TPYE_FLOW_RATE = 7;
    private static final short SHORT_TPYE_IMEI = 0;
    private static final short SHORT_TPYE_IMSI = 1;
    private static final short SHORT_TPYE_MODEL = 5;
    private static final short SHORT_TPYE_NET = 8;
    private static final short SHORT_TPYE_OS = 6;
    private static final short SHORT_TPYE_PHONE = 9;
    private static final short SHORT_TPYE_SCREEN_H = 4;
    private static final short SHORT_TPYE_SCREEN_W = 3;
    private static final short SHORT_TPYE_SOFT_ID = 4;
    private static final short SHORT_TPYE_SOFT_NAME = 0;
    private static final short SHORT_TPYE_SOFT_PAGKAGE = 3;
    private static final short SHORT_TPYE_SOFT_TIMES = 2;
    private static final short SHORT_TPYE_SOFT_VERSION = 1;
    private Context mContext;

    public BdBBMPhoneStatistic(Context context) {
        this.mContext = context;
    }

    public byte[] getPhoneInfo() {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        String deviceId = telephonyManager.getDeviceId();
        if (deviceId != null) {
            writeShortTypeInfo((short) 0, deviceId, byteArrayOutputStream);
        }
        String subscriberId = telephonyManager.getSubscriberId();
        if (subscriberId != null && subscriberId.length() > 0) {
            writeShortTypeInfo((short) 1, subscriberId, byteArrayOutputStream);
            if (subscriberId.length() > 5) {
                str = String.valueOf(String.valueOf(String.valueOf(subscriberId.substring(0, 3)) + ";") + subscriberId.substring(3, 5)) + ";";
            } else {
                str = "000;00;";
            }
            if (telephonyManager.getCellLocation() != null) {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof GsmCellLocation) {
                    BdLog.d("GsmCellLocation");
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    str = String.valueOf(String.valueOf(String.valueOf(str) + String.valueOf(gsmCellLocation.getLac())) + ";") + gsmCellLocation.getCid();
                } else if (cellLocation instanceof CdmaCellLocation) {
                    BdLog.d("CdmaCellLocation");
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    str = String.valueOf(String.valueOf(String.valueOf(str) + String.valueOf(cdmaCellLocation.getNetworkId())) + ";") + cdmaCellLocation.getBaseStationId();
                }
                writeShortTypeInfo((short) 2, str, byteArrayOutputStream);
            }
        }
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int min2 = Math.min(displayMetrics.heightPixels, displayMetrics.heightPixels);
        writeShortTypeInfo((short) 3, String.valueOf(new StringBuilder(String.valueOf(min)).toString()), byteArrayOutputStream);
        writeShortTypeInfo((short) 4, new StringBuilder(String.valueOf(min2)).toString(), byteArrayOutputStream);
        writeShortTypeInfo(SHORT_TPYE_MODEL, Build.MODEL, byteArrayOutputStream);
        writeShortTypeInfo(SHORT_TPYE_OS, "Android|" + Build.VERSION.RELEASE, byteArrayOutputStream);
        writeShortTypeInfo(SHORT_TPYE_FLOW_RATE, String.valueOf(0), byteArrayOutputStream);
        writeShortTypeInfo(SHORT_TPYE_NET, String.valueOf(BdNetStat.getInstance().getNetmode()) + "-" + BdNetStat.getInstance().getNetmodeExtra(), byteArrayOutputStream);
        writeShortTypeInfo(SHORT_TPYE_PHONE, "", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getSoftsInfo() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<PackageInfo> installedPackages = this.mContext.getPackageManager().getInstalledPackages(0);
        int size = installedPackages.size();
        for (int i = 0; i < size; i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if (packageInfo.versionName != null && !packageInfo.applicationInfo.publicSourceDir.startsWith("/sys")) {
                writeShortTypeInfo((short) 0, packageInfo.applicationInfo.loadLabel(this.mContext.getPackageManager()).toString(), byteArrayOutputStream);
                writeShortTypeInfo((short) 1, packageInfo.versionName, byteArrayOutputStream);
                writeShortTypeInfo((short) 2, "", byteArrayOutputStream);
                writeShortTypeInfo((short) 3, packageInfo.packageName, byteArrayOutputStream);
                BdLog.i("zd " + packageInfo.packageName);
                writeShortTypeInfo((short) 4, "", byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private final byte[] intToBytes(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    private void writeShortTypeInfo(short s, String str, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            byteArrayOutputStream.write(shortToBytes(s));
            byte[] bytes = str.getBytes(BdUtil.UTF8);
            byteArrayOutputStream.write(intToBytes(bytes.length));
            byteArrayOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final byte[] shortToBytes(short s) {
        return new byte[]{(byte) s, (byte) (s >> SHORT_TPYE_NET)};
    }
}
