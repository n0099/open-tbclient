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
    public static final String f9035d = "pass_face_sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9036e = "illum_gray";

    /* renamed from: f  reason: collision with root package name */
    public static LocalConfigOptions f9037f;

    /* renamed from: a  reason: collision with root package name */
    public String f9038a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f9039b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9040c;

    public LocalConfigOptions(Context context) {
        this.f9040c = context.getApplicationContext();
        this.f9039b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.f9039b.getString(str, "");
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (f9037f == null) {
            f9037f = new LocalConfigOptions(context);
        }
        return f9037f;
    }

    public SdkConfigOptions getBioOptions() {
        String a2 = a(f9035d);
        if (!TextUtils.isEmpty(a2)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.f9040c));
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
        return getInt(f9036e, -1);
    }

    public int getInt(String str, int i2) {
        return this.f9039b.getInt(str, i2);
    }

    public void put(String str, int i2) {
        this.f9039b.edit().putInt(str, i2).apply();
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(f9035d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.f9040c)));
        }
    }

    public void setIllumValueGray(int i2) {
        put(f9036e, i2);
    }

    private void a(String str, String str2) {
        this.f9039b.edit().putString(str, str2).apply();
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.f9038a)) {
            try {
                this.f9038a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.f9038a;
    }
}
