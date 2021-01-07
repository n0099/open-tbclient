package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.common.SecurityUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LocalConfigOptions {
    public static final int DEFAULT_ILLUM_GRAY = -1;
    public static final int DEFAULT_ZIP_GRAY_THRESHOLD = 100;

    /* renamed from: a  reason: collision with root package name */
    private static final String f3984a = ".BD_SAPI_CACHE";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3985b = "pass_face_sdk";
    private static final String c = "illum_gray";
    private static LocalConfigOptions d;
    private String e;
    private SharedPreferences f;
    private Context g;

    private LocalConfigOptions(Context context) {
        this.g = context.getApplicationContext();
        this.f = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.f.getString(str, "");
    }

    public static String getExternalZipPath(String str) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + f3984a + "/" + f3985b + "/" + SdkConfigOptions.HOST_VERSION + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + ".zip";
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (d == null) {
            d = new LocalConfigOptions(context);
        }
        return d;
    }

    public static String getInternalRootPath(Context context) {
        return context.getDir(f3985b, 0).getAbsolutePath();
    }

    public static String getInternalZipPath(Context context, String str) {
        return new File(getInternalRootPath(context) + File.separator + f3985b + File.separator + SdkConfigOptions.HOST_VERSION + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + ".zip").getAbsolutePath();
    }

    public static String getLoadSoPath(Context context) {
        return new File(getInternalRootPath(context) + File.separator).getAbsolutePath();
    }

    public SdkConfigOptions getBioOptions() {
        String a2 = a(f3985b);
        if (!TextUtils.isEmpty(a2)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.g));
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    return SdkConfigOptions.fromLocalJson(new JSONObject(decryptAccountInfo));
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
        }
        return new SdkConfigOptions();
    }

    public int getIllumVlaueGray() {
        return getInt(c, -1);
    }

    public int getInt(String str, int i) {
        return this.f.getInt(str, i);
    }

    public void put(String str, int i) {
        if (Build.VERSION.SDK_INT > 8) {
            this.f.edit().putInt(str, i).apply();
        } else {
            this.f.edit().putInt(str, i).commit();
        }
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            a(f3985b, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.g)));
        }
    }

    public void setIllumValueGray(int i) {
        put(c, i);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.f.edit().putString(str, str2).apply();
        } else {
            this.f.edit().putString(str, str2).commit();
        }
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.e)) {
            try {
                this.e = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        }
        return this.e;
    }
}
