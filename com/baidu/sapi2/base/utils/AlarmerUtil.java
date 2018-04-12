package com.baidu.sapi2.base.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.base.debug.Log;
import java.util.Calendar;
/* loaded from: classes.dex */
public class AlarmerUtil {
    private static final String Tag = "AlarmerUtil";

    public static PendingIntent addAlarm(Context context, String str, int i, int i2) {
        Log.d(Tag, "addAlarm()", str, Integer.valueOf(i), Integer.valueOf(i2));
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(str), 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(i, i2);
        try {
            ((AlarmManager) context.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), broadcast);
        } catch (Throwable th) {
            Log.e(th);
        }
        return broadcast;
    }
}
