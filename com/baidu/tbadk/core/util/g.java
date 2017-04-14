package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast yZ;
    private static Handler mHandler = new Handler();
    private static String ael = null;
    private static Runnable aej = new h();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aej);
            if (yZ != null) {
                if (!str.equals(ael)) {
                    ael = str;
                    yZ.setText(str);
                }
            } else {
                ael = str;
                yZ = Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0);
                yZ.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aej, i);
            yZ.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
