package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast sd;
    private static Handler mHandler = new Handler();
    private static String YI = null;
    private static Runnable YG = new h();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(YG);
            if (sd != null) {
                if (!str.equals(YI)) {
                    YI = str;
                    sd.setText(str);
                }
            } else {
                YI = str;
                sd = Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0);
                sd.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(YG, i);
            sd.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
