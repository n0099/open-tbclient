package com.baidu.android.util.sp;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes12.dex */
public final class SharedPreferencesUtil {
    public static final String CARD_REMIND_GUIDANCE_SHARED_PREFERENCE = "card_remind_guidance_preference";
    public static final String DISCOVERY_HOME_SHARED_PREFERENCE = "discovery_home_share_preference";
    public static final String STRONG_CARD_SHARED_PREFRENCE = "strong_shared_prefrence";
    public static final String WEAK_CARD_SHARED_PREFRENCE = "weak_shared_prefrence";
    private static HashMap<String, SharedPreferencesUtil> mPrefrencesUtil = new HashMap<>();
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;

    private SharedPreferencesUtil(Context context, String str, int i) {
        this.mSharedPreferences = context.getSharedPreferences(str, i);
        this.mEditor = this.mSharedPreferences.edit();
    }

    public static SharedPreferencesUtil getInstance(Context context, String str) {
        return getInstance(context, str, 0);
    }

    public static SharedPreferencesUtil getInstance(Context context, String str, int i) {
        SharedPreferencesUtil sharedPreferencesUtil = mPrefrencesUtil.get(str);
        if (sharedPreferencesUtil == null) {
            synchronized (SharedPreferencesUtil.class) {
                sharedPreferencesUtil = mPrefrencesUtil.get(str);
                if (sharedPreferencesUtil == null) {
                    sharedPreferencesUtil = new SharedPreferencesUtil(context, str, i);
                    mPrefrencesUtil.put(str, sharedPreferencesUtil);
                }
            }
        }
        return sharedPreferencesUtil;
    }

    public void setIntPreference(String str, int i) {
        this.mEditor.putInt(str, i);
        this.mEditor.commit();
    }

    public void setLongPreference(String str, long j) {
        this.mEditor.putLong(str, j);
        this.mEditor.commit();
    }

    public void setStringPreference(String str, String str2) {
        this.mEditor.putString(str, str2);
        this.mEditor.commit();
    }

    public void setStringWithoutCommit(String str, String str2) {
        this.mEditor.putString(str, str2);
    }

    public void commitPreference() {
        this.mEditor.commit();
    }

    public void setBooleanPreference(String str, boolean z) {
        this.mEditor.putBoolean(str, z);
        this.mEditor.commit();
    }

    public void removeStringPreference(String str) {
        this.mEditor.remove(str);
        this.mEditor.commit();
    }

    public Map<String, ?> getAll() {
        return this.mSharedPreferences.getAll();
    }

    public void setFloatPreference(String str, float f) {
        this.mEditor.putFloat(str, f);
        this.mEditor.commit();
    }

    public int getIntPreference(String str, int i) {
        return this.mSharedPreferences.getInt(str, i);
    }

    public long getLongPreference(String str, long j) {
        return this.mSharedPreferences.getLong(str, j);
    }

    public boolean getBooleanPreference(String str, boolean z) {
        return this.mSharedPreferences.getBoolean(str, z);
    }

    public String getStringPreference(String str, String str2) {
        return this.mSharedPreferences.getString(str, str2);
    }

    public float getFloatPreference(String str, float f) {
        return this.mSharedPreferences.getFloat(str, f);
    }
}
