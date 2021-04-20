package com.baidu.mobads.container;

import android.content.Context;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.DeviceUtils;
/* loaded from: classes2.dex */
public class XAdSDKRemoteExp {

    /* loaded from: classes2.dex */
    public static class LiteInc {
        public static int mCountMax = 2;
        public static int mIntervalTime = 3600000;
        public static long mLastTimeMillis = 0;
        public static String mPkgName = "com.baidu.searchbox.lite";

        public static boolean count() {
            if (mCountMax <= 0) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - mLastTimeMillis < mIntervalTime) {
                return false;
            }
            mLastTimeMillis = currentTimeMillis;
            int i = mCountMax;
            mCountMax = i - 1;
            return i > 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class PlayGame {
        public static boolean mInit = false;
    }

    /* loaded from: classes2.dex */
    public static class SearchBoxAct {
        public static int mIntervalTime = 43200000;

        public static boolean count(long j) {
            return System.currentTimeMillis() - j >= ((long) mIntervalTime);
        }
    }

    /* loaded from: classes2.dex */
    public static class SecDexExp {
        public static String[] appsidList = {"c5cd4938", "cc11ff4a", "c37351b3", "c57c567d", "f4ebd40b", "ee9301d8", "d73bab66", "edb0202e", "c346a49a", "cdd9e6c3", "a8dd3411", "eaaaf235", "eedce234", "be6cafba", "fdb23908", "ecfe3dd9", "f3b8127c", "cb8f3131", "e7a4e60d", "af908ec9", "e866cfb0"};

        public static boolean isAddZdTd(Context context) {
            String appId = DeviceUtils.getInstance().getAppId(context);
            String[] strArr = appsidList;
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str.equals(appId)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class StateMachineExp {
        public static boolean isUnderStateMachine(XAdContainerContext xAdContainerContext) {
            if (xAdContainerContext != null) {
                try {
                    String adProd = xAdContainerContext.getAdProd();
                    if (!"feed".equals(adProd)) {
                        if (!"rsplash".equals(adProd)) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class ThirdMonitorExp {
        public static String[] appsidList = {"df7e6e9f", "e866cfb0", "b4305876"};

        public static boolean isSendThirdMonitorLog(Context context) {
            return false;
        }
    }
}
