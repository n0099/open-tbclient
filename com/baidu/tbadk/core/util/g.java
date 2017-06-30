package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast zd;
    private static Handler mHandler = new Handler();
    private static String aef = null;
    private static Runnable aed = new h();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aed);
            if (zd != null) {
                if (!str.equals(aef)) {
                    aef = str;
                    zd.setText(str);
                }
            } else {
                aef = str;
                zd = Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0);
                zd.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aed, i);
            zd.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
