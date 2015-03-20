package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import java.util.Calendar;
/* loaded from: classes.dex */
class i {
    i() {
    }

    public static void a(Context context, PendingIntent pendingIntent) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(pendingIntent);
    }

    public static void a(Context context, PendingIntent pendingIntent, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(pendingIntent);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(14, i);
        alarmManager.set(0, calendar.getTimeInMillis(), pendingIntent);
    }
}
