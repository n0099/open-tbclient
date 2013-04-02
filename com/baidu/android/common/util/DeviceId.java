package com.baidu.android.common.util;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.account.AccountProxy;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.browser.core.util.BdUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
/* loaded from: classes.dex */
public final class DeviceId {
    private static final String AES_KEY = "30212102dicudiab";
    private static final boolean DEBUG = false;
    private static final String EXT_FILE = "baidu/.cuid";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_IMEI = "bd_setting_i";
    private static final String TAG = "DeviceId";

    private DeviceId() {
    }

    private static void checkPermission(Context context, String str) {
        if (!(context.checkCallingOrSelfPermission(str) == 0)) {
            throw new SecurityException("Permission Denial: requires permission " + str);
        }
    }

    public static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDeviceID(Context context) {
        Exception e;
        String str;
        checkPermission(context, "android.permission.WRITE_SETTINGS");
        checkPermission(context, "android.permission.READ_PHONE_STATE");
        checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean z = false;
        String str2 = "";
        try {
            str2 = Settings.System.getString(context.getContentResolver(), KEY_IMEI);
            str = str2 == null ? getIMEI(context) : str2;
        } catch (Exception e2) {
            e = e2;
            str = str2;
        }
        try {
            Settings.System.putString(context.getContentResolver(), KEY_IMEI, str);
        } catch (Exception e3) {
            e = e3;
            Log.e(TAG, "Settings.System.getString or putString failed", e);
            z = true;
            String androidId = getAndroidId(context);
            if (z) {
            }
        }
        String androidId2 = getAndroidId(context);
        if (z) {
            String str3 = null;
            String string = Settings.System.getString(context.getContentResolver(), KEY_DEVICE_ID);
            if (TextUtils.isEmpty(string)) {
                str3 = Util.toMd5((AccountProxy.BAIDUACCOUNT_TYPE + str + androidId2).getBytes(), true);
                string = Settings.System.getString(context.getContentResolver(), str3);
                if (!TextUtils.isEmpty(string)) {
                    Settings.System.putString(context.getContentResolver(), KEY_DEVICE_ID, string);
                    setExternalDeviceId(str, string);
                }
            }
            if (TextUtils.isEmpty(string)) {
                string = getExternalDeviceId(str);
                if (!TextUtils.isEmpty(string)) {
                    Settings.System.putString(context.getContentResolver(), str3, string);
                    Settings.System.putString(context.getContentResolver(), KEY_DEVICE_ID, string);
                }
            }
            if (TextUtils.isEmpty(string)) {
                String md5 = Util.toMd5((str + androidId2 + UUID.randomUUID().toString()).getBytes(), true);
                Settings.System.putString(context.getContentResolver(), str3, md5);
                Settings.System.putString(context.getContentResolver(), KEY_DEVICE_ID, md5);
                setExternalDeviceId(str, md5);
                return md5;
            }
            return string;
        }
        return Util.toMd5((AccountProxy.BAIDUACCOUNT_TYPE + androidId2).getBytes(), true);
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
                sb.append("\r\n");
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
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        return "";
    }

    private static void setExternalDeviceId(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), EXT_FILE);
        try {
            new File(file.getParent()).mkdirs();
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, (str + "=" + str2).getBytes()), BdUtil.UTF8));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }
}
