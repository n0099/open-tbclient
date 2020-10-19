package com.baidu.down.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class URLRegUtils {
    private static final boolean DEBUG = false;
    private static final String DEFAULT_HOST_REG = "^http[s]?:\\/\\/(.*(gdown|appdown|app.dcdn)\\.baidu\\.com|.*baijincdn.cn)(:\\d+)?(\\/.*|)$";
    public static final String TAG = URLRegUtils.class.getSimpleName();
    private static String mRetryHostReg = null;
    private static String mDomainNameToIpReg = null;

    private URLRegUtils() {
    }

    public static void setURLReg(String str, String str2) {
        mRetryHostReg = str;
        mDomainNameToIpReg = str2;
    }

    public static boolean matchRetryHostReg(String str) {
        if (TextUtils.isEmpty(mRetryHostReg)) {
            mRetryHostReg = DEFAULT_HOST_REG;
        }
        return Pattern.matches(mRetryHostReg, str);
    }

    public static boolean matchDomainNameToIpReg(String str) {
        if (TextUtils.isEmpty(mDomainNameToIpReg)) {
            mDomainNameToIpReg = DEFAULT_HOST_REG;
        }
        return Pattern.matches(mDomainNameToIpReg, str);
    }
}
