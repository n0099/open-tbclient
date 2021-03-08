package com.baidu.searchbox.logsystem.logsys;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
/* loaded from: classes4.dex */
public class CrashUtil {
    private static String CRASH_TAG = AperfRuntime.Runtime.getProcessUUID().replaceAll("#", "") + "#" + System.currentTimeMillis();
    private static final String SEPERATOR = "#";

    /* loaded from: classes4.dex */
    public static final class CrashpadConstant {
        public static final String FULL_BDMP_PERFIX = "fullbdmp-";
        public static final String JSON_EXTRA = "json-extra_info";
        public static final String MIND_BDMP_PREFIX = "minibdmp-";
        public static final String TXT_EXTRA = "txt-json_supplement";
    }

    public static void init() {
    }

    public static final String getCrashTAG() {
        return CRASH_TAG;
    }

    /* loaded from: classes4.dex */
    public static final class CrashTAG {
        public String mCrashProcessUUID;
        public long mTimeStamp;

        private CrashTAG(@NonNull String str, long j) {
            this.mCrashProcessUUID = str;
            this.mTimeStamp = j;
        }

        public static CrashTAG getCrashTAG(@NonNull String str) {
            String[] split;
            long j;
            if (str == null || TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 2 || TextUtils.isEmpty(split[0])) {
                return null;
            }
            try {
                j = Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                j = 0;
            }
            if (j > 0) {
                return new CrashTAG(split[0], j);
            }
            return null;
        }

        public static String getCrashTAG(@NonNull CrashTAG crashTAG) {
            if (crashTAG == null || TextUtils.isEmpty(crashTAG.mCrashProcessUUID) || crashTAG.mTimeStamp < 0) {
                return null;
            }
            return crashTAG.mCrashProcessUUID.replaceAll("#", "") + "#" + crashTAG.mTimeStamp;
        }
    }
}
