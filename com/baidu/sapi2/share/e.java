package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiDataEncryptor;
/* loaded from: classes.dex */
public final class e {
    private static String a = null;

    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SapiDataEncryptor.a(new com.baidu.sapi2.utils.f(com.baidu.sapi2.utils.d.v, com.baidu.sapi2.utils.d.u).a(str, com.baidu.sapi2.utils.d.w, a(context)));
        } catch (Exception e) {
            L.e(e);
            return null;
        }
    }

    public static String b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(new com.baidu.sapi2.utils.f(com.baidu.sapi2.utils.d.v, com.baidu.sapi2.utils.d.u).a(SapiDataEncryptor.d(str), com.baidu.sapi2.utils.d.w, a(context))).trim();
        } catch (Exception e) {
            L.e(e);
            return null;
        }
    }

    private static String a(Context context) {
        String format;
        if (a != null) {
            return a;
        }
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        String str = Build.MODEL;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        String str2 = statFs.getBlockSize() + "";
        String str3 = statFs.getBlockCount() + "";
        if (!TextUtils.isEmpty(deviceId)) {
            format = String.format("%1$s-%2$s-%3$s-%4$s", str, deviceId, str2, str3);
        } else {
            format = String.format("%1$s-%2$s-%3$s", str, str2, str3);
        }
        String substring = format.substring(0, 16);
        if (TextUtils.isEmpty(substring)) {
            substring = "----------------";
        }
        if (substring.length() < 16) {
            substring = (substring + "----------------").substring(0, 16);
        }
        a = substring;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiAccount a(Context context, SapiAccount sapiAccount) {
        if (context == null || sapiAccount == null) {
            return null;
        }
        SapiAccount sapiAccount2 = new SapiAccount();
        sapiAccount2.displayname = a(context, sapiAccount.displayname);
        sapiAccount2.uid = a(context, sapiAccount.uid);
        sapiAccount2.username = a(context, sapiAccount.username);
        sapiAccount2.app = a(context, sapiAccount.app);
        sapiAccount2.bduss = a(context, sapiAccount.bduss);
        sapiAccount2.ptoken = a(context, sapiAccount.ptoken);
        sapiAccount2.stoken = a(context, sapiAccount.stoken);
        sapiAccount2.email = a(context, sapiAccount.email);
        sapiAccount2.extra = a(context, sapiAccount.extra);
        sapiAccount2.phone = a(context, sapiAccount.phone);
        return sapiAccount2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiAccount b(Context context, SapiAccount sapiAccount) {
        if (context == null || sapiAccount == null) {
            return null;
        }
        SapiAccount sapiAccount2 = new SapiAccount();
        sapiAccount2.displayname = b(context, sapiAccount.displayname);
        sapiAccount2.uid = b(context, sapiAccount.uid);
        sapiAccount2.username = b(context, sapiAccount.username);
        sapiAccount2.app = b(context, sapiAccount.app);
        sapiAccount2.bduss = b(context, sapiAccount.bduss);
        sapiAccount2.ptoken = b(context, sapiAccount.ptoken);
        sapiAccount2.stoken = b(context, sapiAccount.stoken);
        sapiAccount2.email = b(context, sapiAccount.email);
        sapiAccount2.extra = b(context, sapiAccount.extra);
        sapiAccount2.phone = b(context, sapiAccount.phone);
        return sapiAccount2;
    }
}
