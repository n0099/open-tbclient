package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static Toast pv;
    private static Handler mHandler = new Handler();
    private static String VC = null;
    private static Runnable VA = new i();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(VA);
            if (pv != null) {
                if (!str.equals(VC)) {
                    VC = str;
                    pv.setText(str);
                }
            } else {
                VC = str;
                pv = Toast.makeText(TbadkCoreApplication.m11getInst(), str, 0);
                pv.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(VA, i);
            pv.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
