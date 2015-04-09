package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class i {
    private static Toast yQ;
    private static Handler mHandler = new Handler();
    private static String mText = null;
    private static Runnable Tj = new j();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(Tj);
            if (yQ != null) {
                if (!str.equals(mText)) {
                    mText = str;
                    yQ.setText(str);
                }
            } else {
                mText = str;
                yQ = Toast.makeText(TbadkCoreApplication.m411getInst(), str, 0);
                yQ.setGravity(17, 0, com.baidu.adp.lib.util.n.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(Tj, i);
            yQ.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
