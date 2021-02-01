package com.baidu.live.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class CustomToast2 {
    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static String mText = null;
    private static Runnable r = new Runnable() { // from class: com.baidu.live.tbadk.core.util.CustomToast2.1
        @Override // java.lang.Runnable
        public void run() {
            CustomToast2.mToast.cancel();
        }
    };

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(r);
            if (mToast != null) {
                if (!str.equals(mText)) {
                    mText = str;
                    mToast.setText(str);
                }
            } else {
                mText = str;
                mToast = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
                mToast.setGravity(17, 0, BdUtilHelper.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(r, i);
            mToast.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }

    public static void showToast(Context context, int i, int i2) {
        showToast(context, context.getResources().getString(i), i2);
    }
}
