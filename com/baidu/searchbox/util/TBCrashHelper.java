package com.baidu.searchbox.util;

import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.da5;
import java.util.Date;
/* loaded from: classes4.dex */
public class TBCrashHelper {
    public static final int MAX_CRASH_UPLOAD_PER_DAY = 100;
    public static final String SP_KEY_CRASH_UPLOAD_COUNT = "SP_MAX_CRASH_UPLOAD_COUNT";
    public static final String SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP = "SP_LAST_CRASH_UPLOAD_TIMESTAMP";

    public static boolean checkIsUploadOverMax() {
        int q;
        long r;
        long currentTimeMillis;
        try {
            q = da5.p().q(SP_KEY_CRASH_UPLOAD_COUNT, 0);
            r = da5.p().r(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, 0L);
            currentTimeMillis = System.currentTimeMillis();
            da5.p().Z(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, currentTimeMillis);
        } catch (Exception unused) {
        }
        if (TimeHelper.isSameDay(new Date(r), new Date(currentTimeMillis))) {
            int i = q + 1;
            da5.p().X(SP_KEY_CRASH_UPLOAD_COUNT, i);
            if (i <= 100) {
                return false;
            }
            return true;
        }
        da5.p().X(SP_KEY_CRASH_UPLOAD_COUNT, 1);
        return false;
    }
}
