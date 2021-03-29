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
    public static final String f9522d = "pass_face_sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9523e = "illum_gray";

    /* renamed from: f  reason: collision with root package name */
    public static LocalConfigOptions f9524f;

    /* renamed from: a  reason: collision with root package name */
    public String f9525a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f9526b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9527c;

    public LocalConfigOptions(Context context) {
        this.f9527c = context.getApplicationContext();
        this.f9526b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.f9526b.getString(str, "");
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (f9524f == null) {
            f9524f = new LocalConfigOptions(context);
        }
        return f9524f;
    }

    public SdkConfigOptions getBioOptions() {
        String a2 = a(f9522d);
        if (!TextUtils.isEmpty(a2)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.f9527c));
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
        return getInt(f9523e, -1);
    }

    public int getInt(String str, int i) {
        return this.f9526b.getInt(str, i);
    }

    public void put(String str, int i) {
        this.f9526b.edit().putInt(str, i).apply();
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(f9522d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.f9527c)));
        }
    }

    public void setIllumValueGray(int i) {
        put(f9523e, i);
    }

    private void a(String str, String str2) {
        this.f9526b.edit().putString(str, str2).apply();
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.f9525a)) {
            try {
                this.f9525a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.f9525a;
    }
}
