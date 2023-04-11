package com.baidu.searchbox.util;

import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.p45;
import java.util.Date;
/* loaded from: classes2.dex */
public class TBCrashHelper {
    public static final int MAX_CRASH_UPLOAD_PER_DAY = 100;
    public static final String SP_KEY_CRASH_UPLOAD_COUNT = "SP_MAX_CRASH_UPLOAD_COUNT";
    public static final String SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP = "SP_LAST_CRASH_UPLOAD_TIMESTAMP";

    public static boolean checkIsUploadOverMax() {
        int n;
        long o;
        long currentTimeMillis;
        try {
            n = p45.m().n(SP_KEY_CRASH_UPLOAD_COUNT, 0);
            o = p45.m().o(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, 0L);
            currentTimeMillis = System.currentTimeMillis();
            p45.m().N(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, currentTimeMillis);
        } catch (Exception unused) {
        }
        if (TimeHelper.isSameDay(new Date(o), new Date(currentTimeMillis))) {
            int i = n + 1;
            p45.m().M(SP_KEY_CRASH_UPLOAD_COUNT, i);
            if (i <= 100) {
                return false;
            }
            return true;
        }
        p45.m().M(SP_KEY_CRASH_UPLOAD_COUNT, 1);
        return false;
    }
}
