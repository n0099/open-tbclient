package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast zc;
    private static Handler mHandler = new Handler();
    private static String aem = null;
    private static Runnable aek = new h();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aek);
            if (zc != null) {
                if (!str.equals(aem)) {
                    aem = str;
                    zc.setText(str);
                }
            } else {
                aem = str;
                zc = Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0);
                zc.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aek, i);
            zc.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
