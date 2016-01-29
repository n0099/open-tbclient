package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static Toast yT;
    private static Handler mHandler = new Handler();
    private static String aaR = null;
    private static Runnable aaP = new i();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aaP);
            if (yT != null) {
                if (!str.equals(aaR)) {
                    aaR = str;
                    yT.setText(str);
                }
            } else {
                aaR = str;
                yT = Toast.makeText(TbadkCoreApplication.m411getInst(), str, 0);
                yT.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aaP, i);
            yT.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
