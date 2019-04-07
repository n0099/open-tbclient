package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiEnv;
/* loaded from: classes.dex */
final class b {
    private static String a = null;

    b() {
    }

    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SapiDataEncryptor.byteToHex(new AES("AES", "AES/CBC/PKCS5Padding").encrypt(str, SapiEnv.SHARE_IV, a(context)));
        } catch (Exception e) {
            Log.e(e);
            return null;
        }
    }

    public static String b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(new AES("AES", "AES/CBC/PKCS5Padding").decrypt(SapiDataEncryptor.hexToByte(str), SapiEnv.SHARE_IV, a(context))).trim();
        } catch (Exception e) {
            Log.e(e);
            return null;
        }
    }

    private static String a(Context context) {
        String str;
        String format;
        String str2 = null;
        if (a != null) {
            return a;
        }
        String deviceId = Build.VERSION.SDK_INT < 23 ? ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId() : null;
        String str3 = Build.MODEL;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            str = statFs.getBlockSize() + "";
            str2 = statFs.getBlockCount() + "";
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(deviceId)) {
            format = String.format("%1$s-%2$s-%3$s-%4$s", str3, deviceId, str, str2);
        } else {
            format = String.format("%1$s-%2$s-%3$s", str3, str, str2);
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
        ShareAccountAccessor.getAccessor().setPtoken(sapiAccount2, a(context, ShareAccountAccessor.getAccessor().getPtoken(sapiAccount)));
        ShareAccountAccessor.getAccessor().setStoken(sapiAccount2, a(context, ShareAccountAccessor.getAccessor().getStoken(sapiAccount)));
        ShareAccountAccessor.getAccessor().setExtra(sapiAccount2, a(context, ShareAccountAccessor.getAccessor().getExtra(sapiAccount)));
        sapiAccount2.email = a(context, sapiAccount.email);
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
        ShareAccountAccessor.getAccessor().setPtoken(sapiAccount2, b(context, ShareAccountAccessor.getAccessor().getPtoken(sapiAccount)));
        ShareAccountAccessor.getAccessor().setStoken(sapiAccount2, b(context, ShareAccountAccessor.getAccessor().getStoken(sapiAccount)));
        ShareAccountAccessor.getAccessor().setExtra(sapiAccount2, b(context, ShareAccountAccessor.getAccessor().getExtra(sapiAccount)));
        sapiAccount2.email = b(context, sapiAccount.email);
        sapiAccount2.phone = b(context, sapiAccount.phone);
        return sapiAccount2;
    }
}
