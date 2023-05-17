package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import android.util.Log;
import java.util.UUID;
/* loaded from: classes3.dex */
public class ActivitySecurityToken {
    public static final boolean DEBUG = SecurityConfig.DEBUG;
    public static final String TAG = "ActivitySecurityToken";
    public static volatile ActivitySecurityToken sInstance;
    public String mToken;

    public ActivitySecurityToken() {
        this.mToken = "";
        this.mToken = UUID.randomUUID().toString();
        if (DEBUG) {
            Log.d(TAG, "ActivitySecurityToken: " + this.mToken);
        }
    }

    public static ActivitySecurityToken getInstance() {
        if (sInstance == null) {
            synchronized (SecurityPersistConfig.class) {
                if (sInstance == null) {
                    sInstance = new ActivitySecurityToken();
                }
            }
        }
        return sInstance;
    }

    public String acquire() {
        return this.mToken;
    }

    public boolean isValid(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.mToken)) {
            return true;
        }
        return false;
    }
}
