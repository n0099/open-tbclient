package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static Toast zk;
    private static Handler mHandler = new Handler();
    private static String aad = null;
    private static Runnable aab = new i();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aab);
            if (zk != null) {
                if (!str.equals(aad)) {
                    aad = str;
                    zk.setText(str);
                }
            } else {
                aad = str;
                zk = Toast.makeText(TbadkCoreApplication.m411getInst(), str, 0);
                zk.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aab, i);
            zk.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
