package com.baidu.android.common.util;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class DeviceId {
    private static final String AES_KEY = "30212102dicudiab";
    private static final boolean DEBUG = false;
    private static final String EXT_FILE = "baidu/.cuid";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String TAG = "DeviceId";

    /* loaded from: classes.dex */
    final class IMEIInfo {
        private static final String KEY_IMEI = "bd_setting_i";
        public final boolean CAN_READ_AND_WRITE_SYSTEM_SETTINGS;
        public final String IMEI;

        private IMEIInfo(String str, boolean z) {
            this.IMEI = str;
            this.CAN_READ_AND_WRITE_SYSTEM_SETTINGS = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0015 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static String getIMEI(Context context, String str) {
            String str2;
            TelephonyManager telephonyManager;
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Exception e) {
                Log.e(DeviceId.TAG, "Read IMEI failed", e);
            }
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
                return !TextUtils.isEmpty(str2) ? str : str2;
            }
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static IMEIInfo getIMEIInfo(Context context) {
            String str;
            Exception e;
            boolean z;
            String str2 = "";
            try {
                str2 = Settings.System.getString(context.getContentResolver(), KEY_IMEI);
                str = TextUtils.isEmpty(str2) ? getIMEI(context, "") : str2;
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            try {
                Settings.System.putString(context.getContentResolver(), KEY_IMEI, str);
                z = false;
            } catch (Exception e3) {
                e = e3;
                Log.e(DeviceId.TAG, "Settings.System.getString or putString failed", e);
                if (TextUtils.isEmpty(str)) {
                    str = getIMEI(context, "");
                    z = true;
                } else {
                    z = true;
                }
                return new IMEIInfo(str, z ? false : true);
            }
            return new IMEIInfo(str, z ? false : true);
        }
    }

    private DeviceId() {
    }

    private static void checkPermission(Context context, String str) {
        if (!(context.checkCallingOrSelfPermission(str) == 0 ? true : DEBUG)) {
            throw new SecurityException("Permission Denial: requires permission " + str);
        }
    }

    public static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String getDeviceID(Context context) {
        checkPermission(context, "android.permission.WRITE_SETTINGS");
        checkPermission(context, "android.permission.READ_PHONE_STATE");
        checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        IMEIInfo iMEIInfo = IMEIInfo.getIMEIInfo(context);
        String str = iMEIInfo.IMEI;
        boolean z = !iMEIInfo.CAN_READ_AND_WRITE_SYSTEM_SETTINGS ? true : DEBUG;
        String androidId = getAndroidId(context);
        if (z) {
            return Util.toMd5(("com.baidu" + androidId).getBytes(), true);
        }
        String str2 = null;
        String string = Settings.System.getString(context.getContentResolver(), KEY_DEVICE_ID);
        if (TextUtils.isEmpty(string)) {
            str2 = Util.toMd5(("com.baidu" + str + androidId).getBytes(), true);
            string = Settings.System.getString(context.getContentResolver(), str2);
            if (!TextUtils.isEmpty(string)) {
                Settings.System.putString(context.getContentResolver(), KEY_DEVICE_ID, string);
                setExternalDeviceId(str, string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = getExternalDeviceId(str);
            if (!TextUtils.isEmpty(string)) {
                Settings.System.putString(context.getContentResolver(), str2, string);
                Settings.System.putString(context.getContentResolver(), KEY_DEVICE_ID, string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            String md5 = Util.toMd5((str + androidId + UUID.randomUUID().toString()).getBytes(), true);
            Settings.System.putString(context.getContentResolver(), str2, md5);
            Settings.System.putString(context.getContentResolver(), KEY_DEVICE_ID, md5);
            setExternalDeviceId(str, md5);
            return md5;
        }
        return string;
    }

    private static String getExternalDeviceId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), EXT_FILE)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            bufferedReader.close();
            Object[] split = new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(sb.toString().getBytes()))).split("=");
            return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException e2) {
            return "";
        } catch (Exception e3) {
            return "";
        }
    }

    public static String getIMEI(Context context) {
        return IMEIInfo.getIMEIInfo(context).IMEI;
    }

    private static void setExternalDeviceId(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), EXT_FILE);
        try {
            new File(file.getParent()).mkdirs();
            FileWriter fileWriter = new FileWriter(file, (boolean) DEBUG);
            fileWriter.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }
}
