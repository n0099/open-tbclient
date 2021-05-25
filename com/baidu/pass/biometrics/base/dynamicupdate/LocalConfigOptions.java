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

    /* renamed from: d  reason: collision with root package name */
    public static final String f8935d = "pass_face_sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f8936e = "illum_gray";

    /* renamed from: f  reason: collision with root package name */
    public static LocalConfigOptions f8937f;

    /* renamed from: a  reason: collision with root package name */
    public String f8938a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f8939b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8940c;

    public LocalConfigOptions(Context context) {
        this.f8940c = context.getApplicationContext();
        this.f8939b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.f8939b.getString(str, "");
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (f8937f == null) {
            f8937f = new LocalConfigOptions(context);
        }
        return f8937f;
    }

    public SdkConfigOptions getBioOptions() {
        String a2 = a(f8935d);
        if (!TextUtils.isEmpty(a2)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.f8940c));
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
        return getInt(f8936e, -1);
    }

    public int getInt(String str, int i2) {
        return this.f8939b.getInt(str, i2);
    }

    public void put(String str, int i2) {
        this.f8939b.edit().putInt(str, i2).apply();
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(f8935d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.f8940c)));
        }
    }

    public void setIllumValueGray(int i2) {
        put(f8936e, i2);
    }

    private void a(String str, String str2) {
        this.f8939b.edit().putString(str, str2).apply();
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.f8938a)) {
            try {
                this.f8938a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.f8938a;
    }
}
