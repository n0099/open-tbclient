package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;
/* loaded from: classes3.dex */
public class SafeService {
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;
    public static final int SOFIRE_MODULE_ID = 1;
    public static final String Tag = "SafeService";

    /* loaded from: classes3.dex */
    public static class SingletonContainer {
        public static SafeService mSingleInstance = new SafeService();
    }

    public SafeService() {
    }

    public static SafeService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public String getDeviceAuthToken(Context context, String str, String str2, int i) {
        return FH.gt(context, str, str2, i, null);
    }

    public boolean init(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(Tag, "init()", th.toString());
            return false;
        }
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        String gzfi = FH.gzfi(context, str, i);
        if (TextUtils.isEmpty(gzfi)) {
            return "NoZidYet";
        }
        return gzfi;
    }
}
