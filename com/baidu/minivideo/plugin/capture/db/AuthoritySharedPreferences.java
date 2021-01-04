package com.baidu.minivideo.plugin.capture.db;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.Application;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AuthoritySharedPreferences {
    private static final String FIRSTSHOT_CONFIG = "firstshot_config";
    private static final String KEY_AUTHORITY_AUDIO_RATIONALE = "key_authority_audio_rationale";
    private static final String KEY_AUTHORITY_AUDIO_RESULT = "key_authority_album";
    private static final String KEY_AUTHORITY_CAMERA_RATIONALE = "key_authority_camera_rationale";
    private static final String KEY_AUTHORITY_CONFIG_TIMESTAMP = "authority_config_timestamp";
    private static final String KEY_AUTHORITY_STORAGE_RATIONALE = "key_authority_storage_rationale";
    public static final String KEY_CONFIG_FIRSTSHOT = "firstShot";
    public static final String KEY_CONFIG_FIRSTSHOT_GUIDE = "guide";
    public static final String KEY_CONFIG_FIRSTSHOT_IMAGE = "image";
    public static final String KEY_CONFIG_PRIVILEGE = "privilege";
    public static final String KEY_CONFIG_PRIVILEGE_APPLY = "apply";
    public static final String KEY_CONFIG_PRIVILEGE_DONE = "done";
    public static final String KEY_CONFIG_PRIVILEGE_OPENCAMERA = "openCamera";
    public static final String KEY_CONFIG_PRIVILEGE_OPENMICROPHONE = "openMicrophone";
    public static final String KEY_CONFIG_PRIVILEGE_OPENSHOT = "openShot";
    private static final String PRIVILEGE_CONFIG = "privilege_config";
    private static final String TAG = "AuthoritySharedPreferencesTAG";
    private static final String PREF = "authority_config";
    private static SharedPreferences sPref = Application.get().getSharedPreferences(PREF, 0);

    public static void setPrivilegeConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            sPref.edit().putString(PRIVILEGE_CONFIG, str).apply();
        }
    }

    public static String getPrivilegeConfig() {
        return sPref.getString(PRIVILEGE_CONFIG, "");
    }

    public static void setFirstShotConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            sPref.edit().putString(FIRSTSHOT_CONFIG, str).apply();
        }
    }

    public static String getFirstShotConfig() {
        return sPref.getString(FIRSTSHOT_CONFIG, "");
    }

    public static void setAuthorityConfigTimestamp(long j) {
        sPref.edit().putLong(KEY_AUTHORITY_CONFIG_TIMESTAMP, j).apply();
    }

    public static long getAuthorityConfigTimestamp() {
        return sPref.getLong(KEY_AUTHORITY_CONFIG_TIMESTAMP, 0L);
    }

    public static String getFirstShotImage() {
        JSONObject jSONObject;
        String firstShotConfig = getFirstShotConfig();
        if (TextUtils.isEmpty(firstShotConfig)) {
            return "";
        }
        try {
            JSONObject jSONObject2 = new JSONObject(firstShotConfig);
            if (!jSONObject2.has("guide") || (jSONObject = jSONObject2.getJSONObject("guide")) == null) {
                return "";
            }
            return jSONObject.optString("image");
        } catch (JSONException e) {
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static void setAuthorityCameraResult(boolean z) {
        sPref.edit().putBoolean(KEY_AUTHORITY_CAMERA_RATIONALE, z).apply();
    }

    public static boolean getAuthorityCameraResult() {
        return sPref.getBoolean(KEY_AUTHORITY_CAMERA_RATIONALE, true);
    }

    public static void setAuthorityAudioResult(boolean z) {
        sPref.edit().putBoolean(KEY_AUTHORITY_AUDIO_RATIONALE, z).apply();
    }

    public static boolean getAuthorityStorageResult() {
        return sPref.getBoolean(KEY_AUTHORITY_STORAGE_RATIONALE, true);
    }

    public static void setAuthorityStorageResult(boolean z) {
        sPref.edit().putBoolean(KEY_AUTHORITY_STORAGE_RATIONALE, z).apply();
    }

    public static boolean getAuthorityAudioResult() {
        return sPref.getBoolean(KEY_AUTHORITY_AUDIO_RATIONALE, true);
    }

    public static void setAuthorityAlbumResult(boolean z) {
        sPref.edit().putBoolean(KEY_AUTHORITY_AUDIO_RESULT, z).apply();
    }

    public static boolean getAuthorityAlbumResult() {
        return sPref.getBoolean(KEY_AUTHORITY_AUDIO_RESULT, true);
    }
}
