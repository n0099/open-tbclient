package com.baidu.down.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class URLRegUtils {
    public static final boolean DEBUG = false;
    public static final String DEFAULT_HOST_REG = "^http[s]?:\\/\\/(.*(gdown|appdown|app.dcdn)\\.baidu\\.com|.*baijincdn.cn)(:\\d+)?(\\/.*|)$";
    public static final String TAG = "URLRegUtils";
    public static String mDomainNameToIpReg;
    public static String mRetryHostReg;

    public static boolean matchDomainNameToIpReg(String str) {
        if (TextUtils.isEmpty(mDomainNameToIpReg)) {
            mDomainNameToIpReg = DEFAULT_HOST_REG;
        }
        return Pattern.matches(mDomainNameToIpReg, str);
    }

    public static boolean matchRetryHostReg(String str) {
        if (TextUtils.isEmpty(mRetryHostReg)) {
            mRetryHostReg = DEFAULT_HOST_REG;
        }
        return Pattern.matches(mRetryHostReg, str);
    }

    public static void setURLReg(String str, String str2) {
        mRetryHostReg = str;
        mDomainNameToIpReg = str2;
    }
}
