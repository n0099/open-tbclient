package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class i {
    private static Toast yJ;
    private static Handler mHandler = new Handler();
    private static String ZR = null;
    private static Runnable ZP = new j();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(ZP);
            if (yJ != null) {
                if (!str.equals(ZR)) {
                    ZR = str;
                    yJ.setText(str);
                }
            } else {
                ZR = str;
                yJ = Toast.makeText(TbadkCoreApplication.m411getInst(), str, 0);
                yJ.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(ZP, i);
            yJ.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
