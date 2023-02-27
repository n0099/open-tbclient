package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.sapi2.ServiceManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.kuaishou.weapon.p0.h;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SapiDeviceUtils {
    public static String mImei;

    public static String getBrandName() {
        String str;
        try {
            if (TextUtils.isEmpty(Build.BRAND)) {
                str = "";
            } else {
                str = Build.BRAND;
            }
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean checkHosts(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        if (context == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream("/system/etc/hosts");
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("passport.baidu.com")) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        Log.e(Log.TAG, e.toString());
                    }
                    return true;
                }
            }
            try {
                fileInputStream.close();
            } catch (Exception e2) {
                Log.e(Log.TAG, e2.toString());
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            try {
                Log.e(Log.TAG, th.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        Log.e(Log.TAG, e3.toString());
                    }
                }
                return false;
            } catch (Throwable th4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                        Log.e(Log.TAG, e4.toString());
                    }
                }
                throw th4;
            }
        }
    }

    public static String getIMEI(Context context) {
        try {
            if (isForbidDangerousPermissionApp(context) || Build.VERSION.SDK_INT >= 29 || !ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                return "";
            }
            if (!TextUtils.isEmpty(mImei)) {
                return mImei;
            }
            if (!PassPermissions.checkRequestPermission(h.c, context)) {
                return "";
            }
            String deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
            mImei = deviceId;
            if (deviceId == null) {
                mImei = "";
            }
            return mImei;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isForbidDangerousPermissionApp(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        String packageName = context.getPackageName();
        for (String str : arrayList) {
            if (packageName.matches(str)) {
                return true;
            }
        }
        return false;
    }
}
