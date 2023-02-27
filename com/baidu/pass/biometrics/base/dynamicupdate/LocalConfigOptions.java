package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.common.SecurityUtil;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LocalConfigOptions {
    public static final int DEFAULT_ILLUM_GRAY = -1;
    public static final int DEFAULT_ILLUM_VALUE = 8;
    public static final String d = "pass_face_sdk";
    public static final String e = "illum_gray";
    public static LocalConfigOptions f;
    public String a;
    public SharedPreferences b;
    public Context c;

    public LocalConfigOptions(Context context) {
        this.c = context.getApplicationContext();
        this.b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.b.getString(str, "");
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (f == null) {
            f = new LocalConfigOptions(context);
        }
        return f;
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.c)));
        }
    }

    public void setIllumValueGray(int i) {
        put(e, i);
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.a)) {
            try {
                this.a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.a;
    }

    private void a(String str, String str2) {
        this.b.edit().putString(str, str2).apply();
    }

    public int getInt(String str, int i) {
        return this.b.getInt(str, i);
    }

    public void put(String str, int i) {
        this.b.edit().putInt(str, i).apply();
    }

    public SdkConfigOptions getBioOptions() {
        String a = a(d);
        if (!TextUtils.isEmpty(a)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a, a(this.c));
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    return SdkConfigOptions.fromLocalJson(new JSONObject(decryptAccountInfo));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        }
        return new SdkConfigOptions();
    }

    public int getIllumVlaueGray() {
        return getInt(e, -1);
    }
}
