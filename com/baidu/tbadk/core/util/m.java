package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static Toast nt;
    private static Handler mHandler = new Handler();
    private static String mText = null;
    private static Runnable HH = new n();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(HH);
            if (nt != null) {
                if (!str.equals(mText)) {
                    mText = str;
                    nt.setText(str);
                }
            } else {
                mText = str;
                nt = Toast.makeText(TbadkCoreApplication.m255getInst(), str, 0);
                nt.setGravity(17, 0, com.baidu.adp.lib.util.l.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(HH, i);
            nt.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
