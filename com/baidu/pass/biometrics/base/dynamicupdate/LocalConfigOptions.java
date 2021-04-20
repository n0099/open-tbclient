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
    public static final String f9080d = "pass_face_sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9081e = "illum_gray";

    /* renamed from: f  reason: collision with root package name */
    public static LocalConfigOptions f9082f;

    /* renamed from: a  reason: collision with root package name */
    public String f9083a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f9084b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9085c;

    public LocalConfigOptions(Context context) {
        this.f9085c = context.getApplicationContext();
        this.f9084b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        return this.f9084b.getString(str, "");
    }

    public static LocalConfigOptions getInstance(Context context) {
        if (f9082f == null) {
            f9082f = new LocalConfigOptions(context);
        }
        return f9082f;
    }

    public SdkConfigOptions getBioOptions() {
        String a2 = a(f9080d);
        if (!TextUtils.isEmpty(a2)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.f9085c));
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
        return getInt(f9081e, -1);
    }

    public int getInt(String str, int i) {
        return this.f9084b.getInt(str, i);
    }

    public void put(String str, int i) {
        this.f9084b.edit().putInt(str, i).apply();
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(f9080d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.f9085c)));
        }
    }

    public void setIllumValueGray(int i) {
        put(f9081e, i);
    }

    private void a(String str, String str2) {
        this.f9084b.edit().putString(str, str2).apply();
    }

    private String a(Context context) {
        if (TextUtils.isEmpty(this.f9083a)) {
            try {
                this.f9083a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.f9083a;
    }
}
