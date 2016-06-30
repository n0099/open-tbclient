package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static Toast pv;
    private static Handler mHandler = new Handler();
    private static String VS = null;
    private static Runnable VQ = new i();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(VQ);
            if (pv != null) {
                if (!str.equals(VS)) {
                    VS = str;
                    pv.setText(str);
                }
            } else {
                VS = str;
                pv = Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0);
                pv.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(VQ, i);
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
