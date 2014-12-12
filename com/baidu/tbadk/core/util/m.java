package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static Toast nq;
    private static Handler mHandler = new Handler();
    private static String mText = null;
    private static Runnable Hy = new n();

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(Hy);
            if (nq != null) {
                if (!str.equals(mText)) {
                    mText = str;
                    nq.setText(str);
                }
            } else {
                mText = str;
                nq = Toast.makeText(TbadkCoreApplication.m255getInst(), str, 0);
                nq.setGravity(17, 0, com.baidu.adp.lib.util.l.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(Hy, i);
            nq.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
