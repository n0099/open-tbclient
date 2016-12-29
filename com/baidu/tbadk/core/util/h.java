package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static Toast sl;
    private static Handler mHandler = new Handler();
    private static String Zu = null;
    private static Runnable Zs = new i();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(Zs);
            if (sl != null) {
                if (!str.equals(Zu)) {
                    Zu = str;
                    sl.setText(str);
                }
            } else {
                Zu = str;
                sl = Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0);
                sl.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(Zs, i);
            sl.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
