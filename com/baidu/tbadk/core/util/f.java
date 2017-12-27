package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast amL;
    private static Handler mHandler = new Handler();
    private static String aTq = null;
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.amL.cancel();
        }
    };

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(r);
            if (amL != null) {
                if (!str.equals(aTq)) {
                    aTq = str;
                    amL.setText(str);
                }
            } else {
                aTq = str;
                amL = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
                amL.setGravity(17, 0, com.baidu.adp.lib.util.l.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(r, i);
            amL.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
