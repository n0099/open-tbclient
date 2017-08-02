package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast zd;
    private static Handler mHandler = new Handler();
    private static String aeB = null;
    private static Runnable aez = new Runnable() { // from class: com.baidu.tbadk.core.util.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.zd.cancel();
        }
    };

    public static void showToast(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(aez);
            if (zd != null) {
                if (!str.equals(aeB)) {
                    aeB = str;
                    zd.setText(str);
                }
            } else {
                aeB = str;
                zd = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
                zd.setGravity(17, 0, com.baidu.adp.lib.util.k.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(aez, i);
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
