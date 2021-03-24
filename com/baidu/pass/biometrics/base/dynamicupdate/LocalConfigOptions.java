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
    public static final String f9521d = "pass_face_sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9522e = "illum_gray";

    /* renamed from: f  reason: collision with root package name */
    public static LocalConfigOptions f9523f;

    /* renamed from: a  reason: collision with root package name */
    public String f9524a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f9525b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9526c;

    public LocalConfigOptions(Context context) {
        this.f9526c = context.getApplicationContext();
        this.f9525b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.f9525b.getString(str, "");
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (f9523f == null) {
            f9523f = new LocalConfigOptions(context);
        }
        return f9523f;
    }

    public SdkConfigOptions getBioOptions() {
        String a2 = a(f9521d);
        if (!TextUtils.isEmpty(a2)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.f9526c));
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
        return getInt(f9522e, -1);
    }

    public int getInt(String str, int i) {
        return this.f9525b.getInt(str, i);
    }

    public void put(String str, int i) {
        this.f9525b.edit().putInt(str, i).apply();
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(f9521d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.f9526c)));
        }
    }

    public void setIllumValueGray(int i) {
        put(f9522e, i);
    }

    private void a(String str, String str2) {
        this.f9525b.edit().putString(str, str2).apply();
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.f9524a)) {
            try {
                this.f9524a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.f9524a;
    }
}
