package com.baidu.adp.lib.e;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    public static boolean a(Context context, Intent intent) {
        try {
            context.startService(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, Intent intent) {
        try {
            context.stopService(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean c(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }
}
