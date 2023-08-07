package com.baidu.searchbox.util;

import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import java.util.Date;
/* loaded from: classes4.dex */
public class TBCrashHelper {
    public static final int MAX_CRASH_UPLOAD_PER_DAY = 100;
    public static final String SP_KEY_CRASH_UPLOAD_COUNT = "SP_MAX_CRASH_UPLOAD_COUNT";
    public static final String SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP = "SP_LAST_CRASH_UPLOAD_TIMESTAMP";

    public static boolean checkIsUploadOverMax() {
        int i;
        long j;
        long currentTimeMillis;
        try {
            i = SharedPrefHelper.getInstance().getInt(SP_KEY_CRASH_UPLOAD_COUNT, 0);
            j = SharedPrefHelper.getInstance().getLong(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, 0L);
            currentTimeMillis = System.currentTimeMillis();
            SharedPrefHelper.getInstance().syncPutLong(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, currentTimeMillis);
        } catch (Exception unused) {
        }
        if (TimeHelper.isSameDay(new Date(j), new Date(currentTimeMillis))) {
            int i2 = i + 1;
            SharedPrefHelper.getInstance().syncPutInt(SP_KEY_CRASH_UPLOAD_COUNT, i2);
            if (i2 <= 100) {
                return false;
            }
            return true;
        }
        SharedPrefHelper.getInstance().syncPutInt(SP_KEY_CRASH_UPLOAD_COUNT, 1);
        return false;
    }
}
