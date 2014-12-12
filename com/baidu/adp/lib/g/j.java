package com.baidu.adp.lib.g;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    public static boolean e(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean f(Context context, Intent intent) {
        try {
            context.startService(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        try {
            context.bindService(intent, serviceConnection, i);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean g(Context context, Intent intent) {
        try {
            context.stopService(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean h(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }
}
