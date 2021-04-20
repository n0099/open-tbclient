package com.baidu.mobads.container.util;

import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.util.network.NetworkRequestFilterManager;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes2.dex */
public class SDKLogSecurityManager {
    public static final int[] TYPE_LIST_UNDEFINED = new int[0];
    public static final int[] TYPE_LIST_SECRET = {527, 528, 529, 9, 11};
    public static final int[] TYPE_LIST_DANGER = new int[0];

    /* loaded from: classes2.dex */
    public enum LogTypeLevel {
        UNDEFINED(SessionMonitorEngine.PUBLIC_DATA_UNDIFNED, -1),
        NORMAL("normal", 0),
        SECRET("secret", 1),
        DANGER("danger", 2);
        
        public int mLevel;
        public String mName;

        LogTypeLevel(String str, int i) {
            this.mName = str;
            this.mLevel = i;
        }

        public int getLevel() {
            return this.mLevel;
        }

        public String getName() {
            return this.mName;
        }
    }

    public static String encryptValue(String str) {
        try {
            return Base64.encode(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getLogTypeLevel(int i) {
        if (isListContainsType(TYPE_LIST_UNDEFINED, i)) {
            return LogTypeLevel.UNDEFINED.getLevel();
        }
        if (isListContainsType(TYPE_LIST_SECRET, i)) {
            return LogTypeLevel.SECRET.getLevel();
        }
        if (isListContainsType(TYPE_LIST_DANGER, i)) {
            return LogTypeLevel.DANGER.getLevel();
        }
        return LogTypeLevel.NORMAL.getLevel();
    }

    public static boolean isEnvSecurity() {
        NetworkRequestFilterManager networkRequestFilterManager = NetworkRequestFilterManager.getInstance(XAdRemoteCommonUtils.getApplicationContext());
        return networkRequestFilterManager.isAdbDebugConnected() || networkRequestFilterManager.isProxyRunning() || networkRequestFilterManager.isRooted();
    }

    public static boolean isListContainsType(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isLogTypeEnable(int i, boolean z) {
        if (XAdSDKRemoteConfig.DEBUG_MODE) {
            return true;
        }
        int logTypeLevel = getLogTypeLevel(i);
        if (logTypeLevel == LogTypeLevel.UNDEFINED.getLevel()) {
            return false;
        }
        if (logTypeLevel == LogTypeLevel.NORMAL.getLevel()) {
            return true;
        }
        return logTypeLevel == LogTypeLevel.SECRET.getLevel() ? !isEnvSecurity() : z;
    }
}
