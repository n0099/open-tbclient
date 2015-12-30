package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class i {
    private static Toast yL;
    private static Handler mHandler = new Handler();
    private static String aav = null;
    private static Runnable aat = new j();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aat);
            if (yL != null) {
                if (!str.equals(aav)) {
                    aav = str;
                    yL.setText(str);
                }
            } else {
                aav = str;
                yL = Toast.makeText(TbadkCoreApplication.m411getInst(), str, 0);
                yL.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aat, i);
            yL.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
