package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static Toast pX;
    private static Handler mHandler = new Handler();
    private static String WB = null;
    private static Runnable Wz = new i();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(Wz);
            if (pX != null) {
                if (!str.equals(WB)) {
                    WB = str;
                    pX.setText(str);
                }
            } else {
                WB = str;
                pX = Toast.makeText(TbadkCoreApplication.m10getInst(), str, 0);
                pX.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(Wz, i);
            pX.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
