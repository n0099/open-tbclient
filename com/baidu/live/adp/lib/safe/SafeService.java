package com.baidu.live.adp.lib.safe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes11.dex */
public class SafeService {
    public static boolean startActivity(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean startActivityForResult(Activity activity, Intent intent, int i) {
        try {
            activity.startActivityForResult(intent, i);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean startService(Context context, Intent intent) {
        try {
            context.startService(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        try {
            context.bindService(intent, serviceConnection, i);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean unbindService(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean stopService(Context context, Intent intent) {
        try {
            context.stopService(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean sendBroadcast(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }
}
