package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class i {
    private static Toast yD;
    private static Handler mHandler = new Handler();
    private static String YZ = null;
    private static Runnable YX = new j();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(YX);
            if (yD != null) {
                if (!str.equals(YZ)) {
                    YZ = str;
                    yD.setText(str);
                }
            } else {
                YZ = str;
                yD = Toast.makeText(TbadkCoreApplication.m411getInst(), str, 0);
                yD.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(YX, i);
            yD.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
