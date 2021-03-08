package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.k;
import java.util.HashMap;
/* loaded from: classes3.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f3423a;

    c() {
    }

    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(new AES(com.baidu.sapi2.utils.e.q, com.baidu.sapi2.utils.e.p).decrypt(SapiDataEncryptor.hexToByte(str), com.baidu.sapi2.utils.e.r, a(context))).trim();
        } catch (Exception e) {
            Log.e(e);
            HashMap hashMap = new HashMap();
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put("device_ver", Build.VERSION.RELEASE);
            hashMap.put("error_msg", android.util.Log.getStackTraceString(e));
            k.a("aes_decrypt_error", hashMap);
            return null;
        }
    }

    public static String b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SapiDataEncryptor.byteToHex(new AES(com.baidu.sapi2.utils.e.q, com.baidu.sapi2.utils.e.p).encrypt(str, com.baidu.sapi2.utils.e.r, a(context)));
        } catch (Exception e) {
            Log.e(e);
            HashMap hashMap = new HashMap();
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put("device_ver", Build.VERSION.RELEASE);
            hashMap.put("error_msg", android.util.Log.getStackTraceString(e));
            k.a("aes_encrypt_error", hashMap);
            return null;
        }
    }

    private static String a(Context context) {
        String str;
        String str2;
        String str3 = f3423a;
        if (str3 == null) {
            String deviceId = Build.VERSION.SDK_INT < 23 ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : null;
            String str4 = Build.MODEL;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                str2 = statFs.getBlockSize() + "";
                str = statFs.getBlockCount() + "";
            } else {
                str = null;
                str2 = null;
            }
            String substring = (!TextUtils.isEmpty(deviceId) ? String.format("%1$s-%2$s-%3$s-%4$s", str4, deviceId, str2, str) : String.format("%1$s-%2$s-%3$s", str4, str2, str)).substring(0, 16);
            if (TextUtils.isEmpty(substring)) {
                substring = "----------------";
            }
            if (substring.length() < 16) {
                substring = (substring + "----------------").substring(0, 16);
            }
            f3423a = substring;
            return f3423a;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiAccount b(Context context, SapiAccount sapiAccount) {
        if (context != null && sapiAccount != null) {
            SapiAccount sapiAccount2 = new SapiAccount();
            sapiAccount2.displayname = b(context, sapiAccount.displayname);
            sapiAccount2.uid = b(context, sapiAccount.uid);
            sapiAccount2.username = b(context, sapiAccount.username);
            sapiAccount2.app = b(context, sapiAccount.app);
            sapiAccount2.bduss = b(context, sapiAccount.bduss);
            a.a().c(sapiAccount2, b(context, a.a().b(sapiAccount)));
            a.a().d(sapiAccount2, b(context, a.a().c(sapiAccount)));
            a.a().b(sapiAccount2, b(context, a.a().a(sapiAccount)));
            sapiAccount2.email = b(context, sapiAccount.email);
            sapiAccount2.phone = b(context, sapiAccount.phone);
            return sapiAccount2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiAccount a(Context context, SapiAccount sapiAccount) {
        if (context != null && sapiAccount != null) {
            SapiAccount sapiAccount2 = new SapiAccount();
            sapiAccount2.displayname = a(context, sapiAccount.displayname);
            sapiAccount2.uid = a(context, sapiAccount.uid);
            sapiAccount2.username = a(context, sapiAccount.username);
            sapiAccount2.app = a(context, sapiAccount.app);
            sapiAccount2.bduss = a(context, sapiAccount.bduss);
            a.a().c(sapiAccount2, a(context, a.a().b(sapiAccount)));
            a.a().d(sapiAccount2, a(context, a.a().c(sapiAccount)));
            a.a().b(sapiAccount2, a(context, a.a().a(sapiAccount)));
            sapiAccount2.email = a(context, sapiAccount.email);
            sapiAccount2.phone = a(context, sapiAccount.phone);
            return sapiAccount2;
        }
        return null;
    }
}
