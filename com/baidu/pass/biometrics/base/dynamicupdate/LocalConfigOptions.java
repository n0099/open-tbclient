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
/* loaded from: classes6.dex */
public class LocalConfigOptions {
    public static final int DEFAULT_ILLUM_GRAY = -1;
    public static final int DEFAULT_ZIP_GRAY_THRESHOLD = 100;
    private static final String EXTERNAL_CACHE_DIR = ".BD_SAPI_CACHE";
    private static final String KEY_ILLUM_GRAY = "illum_gray";
    private static final String LIVENESS_RECOG_NAME = "pass_face_sdk";
    private static LocalConfigOptions instance;
    private Context context;
    private String encryptKey;
    private SharedPreferences storage;

    public static LocalConfigOptions getInstance(Context context) {
        if (instance == null) {
            instance = new LocalConfigOptions(context);
        }
        return instance;
    }

    private LocalConfigOptions(Context context) {
        this.context = context.getApplicationContext();
        this.storage = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    public static String getInternalRootPath(Context context) {
        return context.getDir(LIVENESS_RECOG_NAME, 0).getAbsolutePath();
    }

    public static String getLoadSoPath(Context context) {
        return new File(getInternalRootPath(context) + File.separator).getAbsolutePath();
    }

    public static String getInternalZipPath(Context context, String str) {
        return new File(getInternalRootPath(context) + File.separator + LIVENESS_RECOG_NAME + File.separator + SdkConfigOptions.HOST_VERSION + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + ".zip").getAbsolutePath();
    }

    public static String getExternalZipPath(String str) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + EXTERNAL_CACHE_DIR + "/" + LIVENESS_RECOG_NAME + "/" + SdkConfigOptions.HOST_VERSION + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + ".zip";
    }

    public int getInt(String str, int i) {
        return this.storage.getInt(str, i);
    }

    private String getString(String str) {
        return this.storage.getString(str, "");
    }

    private void setString(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.storage.edit().putString(str, str2).apply();
        } else {
            this.storage.edit().putString(str, str2).commit();
        }
    }

    public void put(String str, int i) {
        if (Build.VERSION.SDK_INT > 8) {
            this.storage.edit().putInt(str, i).apply();
        } else {
            this.storage.edit().putInt(str, i).commit();
        }
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            setString(LIVENESS_RECOG_NAME, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), getAccountEncryptKey(this.context)));
        }
    }

    public SdkConfigOptions getBioOptions() {
        String string = getString(LIVENESS_RECOG_NAME);
        if (!TextUtils.isEmpty(string)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(string, getAccountEncryptKey(this.context));
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

    private String getAccountEncryptKey(Context context) {
        if (TextUtils.isEmpty(this.encryptKey)) {
            try {
                this.encryptKey = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        }
        return this.encryptKey;
    }

    public void setIllumValueGray(int i) {
        put(KEY_ILLUM_GRAY, i);
    }

    public int getIllumVlaueGray() {
        return getInt(KEY_ILLUM_GRAY, -1);
    }
}
