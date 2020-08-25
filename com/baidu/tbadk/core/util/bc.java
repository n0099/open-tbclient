package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class bc {
    private static final HashMap<String, String> mActivityNames = new HashMap<>();
    private static String mCurrentActivityAllName;
    private static String mCurrentActivityName;

    public static void setCurrentActivity(String str) {
        mCurrentActivityAllName = str;
        if (TextUtils.isEmpty(str)) {
            mCurrentActivityName = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (mActivityNames != null) {
            str2 = mActivityNames.get(str);
        }
        if (str2 == null) {
            str2 = getShortName(str);
            if (mActivityNames != null) {
                mActivityNames.put(str, str2);
            }
        }
        if (str2 != null) {
            mCurrentActivityName = str2 + System.currentTimeMillis();
        }
    }

    private static String getShortName(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String getCurrentActivity() {
        return mCurrentActivityName;
    }

    public static String getCurrentActivityAllName() {
        return mCurrentActivityAllName;
    }
}
