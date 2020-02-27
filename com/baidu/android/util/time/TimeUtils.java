package com.baidu.android.util.time;

import android.content.Context;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
@Deprecated
/* loaded from: classes13.dex */
public class TimeUtils {
    private static final String MD = "MM-dd";
    private static long MSEC_OF_ONE_DAY = 86400000;
    private static long MSEC_OF_ONE_HOUR = BdKVCache.MILLS_1Hour;
    private static long MSEC_OF_ONE_MINUTE = 60000;
    private static long MSEC_OF_ONE_SEC = 1000;
    private static final String Y4MD = "yyyy-MM-dd";
    private static final String Y4MD_HM = "yyyy-MM-dd HH:mm";

    public static String getFormatTeletextTime(Context context, long j) {
        return getFormatTeletextTime(context, j, true);
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        String format;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - j;
            if (j2 < 0) {
                j = currentTimeMillis;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            boolean z2 = calendar.get(1) == Calendar.getInstance().get(1);
            long j3 = (j2 % MSEC_OF_ONE_DAY) / MSEC_OF_ONE_HOUR;
            long j4 = ((j2 % MSEC_OF_ONE_DAY) % MSEC_OF_ONE_HOUR) / MSEC_OF_ONE_MINUTE;
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.add(5, -1);
            calendar3.set(11, 0);
            calendar3.set(12, 0);
            calendar3.set(13, 0);
            calendar3.set(14, 0);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.add(5, -2);
            calendar4.set(11, 0);
            calendar4.set(12, 0);
            calendar4.set(13, 0);
            calendar4.set(14, 0);
            Calendar calendar5 = Calendar.getInstance();
            calendar5.add(2, -1);
            calendar5.set(11, 0);
            calendar5.set(12, 0);
            calendar5.set(13, 0);
            calendar5.set(14, 0);
            if (calendar.after(calendar2)) {
                if (j3 > 0) {
                    format = String.format(context.getString(R.string.time_liveshow_teletext_time_hour_before), Long.valueOf(j3));
                } else if (j4 > 0) {
                    format = String.format(context.getString(R.string.time_liveshow_teletext_time_min_before), Long.valueOf(j4));
                } else {
                    format = context.getString(R.string.time_liveshow_teletext_time_sec_before);
                }
            } else if (calendar.after(calendar5)) {
                format = String.format(context.getString(R.string.time_liveshow_teletext_time_day_before), Integer.valueOf((int) (((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / MSEC_OF_ONE_DAY) + 1)));
            } else if (z2) {
                format = new SimpleDateFormat(MD, Locale.getDefault()).format(calendar.getTime());
            } else {
                Date time = calendar.getTime();
                String str = "yyyy-MM-dd";
                if (z) {
                    str = Y4MD_HM;
                }
                format = new SimpleDateFormat(str, Locale.getDefault()).format(time);
            }
            return format;
        } catch (Exception e) {
            return String.valueOf(j);
        }
    }
}
