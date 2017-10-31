package com.baidu.sofire.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes.dex */
public final class b {
    public static void a(Context context, boolean z) {
        long currentTimeMillis;
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
        intent.setClass(context, MyService.class);
        intent.setPackage(context.getPackageName());
        intent.addCategory("com.baidu.category.SOFIRE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("from_plugin_package", context.getPackageName());
        intent.putExtra("target_class", U.class.getCanonicalName());
        intent.putExtra("target_method", "handleWork");
        intent.putExtra("from", 6);
        PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728);
        if (z) {
            currentTimeMillis = eVar.a.getLong("npuct", 0L);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = System.currentTimeMillis() + 86400000;
                eVar.Qh.putLong("npuct", currentTimeMillis);
                eVar.Qh.commit();
            }
        } else {
            currentTimeMillis = ((System.currentTimeMillis() + 86400000) - 600000) + ((long) (1200000.0d * Math.random()));
            eVar.Qh.putLong("npuct", currentTimeMillis);
            eVar.Qh.commit();
        }
        String str = "b=" + z + ", n=" + currentTimeMillis + ", t=86400000, c=" + System.currentTimeMillis();
        com.baidu.sofire.b.a();
        try {
            alarmManager.cancel(service);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.b();
        }
        try {
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable th2) {
            th2.getMessage();
            com.baidu.sofire.b.b();
        }
    }

    public static void b(Context context, int i, boolean z) {
        long j = 600000;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
        intent.setClass(context, MyService.class);
        intent.setPackage(context.getPackageName());
        intent.addCategory("com.baidu.category.SOFIRE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("from_plugin_package", context.getPackageName());
        intent.putExtra("target_class", U.class.getCanonicalName());
        intent.putExtra("target_method", "handleWork");
        intent.putExtra("from", 2);
        PendingIntent service = PendingIntent.getService(context, 1001, intent, 134217728);
        switch (i) {
            case 0:
                j = 30000;
                break;
            case 1:
                j = 180000;
                break;
            case 2:
                j = ReportUserInfoModel.TIME_INTERVAL;
                break;
        }
        long currentTimeMillis = j + System.currentTimeMillis();
        String str = "n=" + currentTimeMillis + ", c=" + System.currentTimeMillis();
        com.baidu.sofire.b.a();
        try {
            alarmManager.cancel(service);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.b();
        }
        if (!z) {
            try {
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th2) {
                th2.getMessage();
                com.baidu.sofire.b.b();
            }
        }
    }

    public static void a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
        intent.setClass(context, MyService.class);
        intent.setPackage(context.getPackageName());
        intent.addCategory("com.baidu.category.SOFIRE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("from_plugin_package", context.getPackageName());
        intent.putExtra("target_class", U.class.getCanonicalName());
        intent.putExtra("target_method", "handleUploadPidChange");
        PendingIntent service = PendingIntent.getService(context, 1002, intent, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + 86400000;
        try {
            alarmManager.cancel(service);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.b();
        }
        try {
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable th2) {
            th2.getMessage();
            com.baidu.sofire.b.b();
        }
    }
}
