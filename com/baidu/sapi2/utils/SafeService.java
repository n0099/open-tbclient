package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;
/* loaded from: classes.dex */
public class SafeService {
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;
    public static final int SOFIRE_MODULE_ID = 1;
    private static final String a = "SafeService";

    /* loaded from: classes.dex */
    private static class SingletonContainer {
        public static SafeService mSingleInstance = new SafeService();

        private SingletonContainer() {
        }
    }

    public static SafeService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public boolean init(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(a, "init()", th.toString());
            return false;
        }
    }

    private SafeService() {
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        String gzfi = FH.gzfi(context, str, i);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }

    public String getDeviceAuthToken(Context context, String str, String str2, int i) {
        return FH.gt(context, str, str2, i, null);
    }
}
