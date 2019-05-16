package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast Eg;
    private static Handler mHandler = new Handler();
    private static String ama = null;
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.Eg.cancel();
        }
    };

    public static void d(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(r);
            if (Eg != null) {
                if (!str.equals(ama)) {
                    ama = str;
                    Eg.setText(str);
                }
            } else {
                ama = str;
                Eg = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
                Eg.setGravity(17, 0, com.baidu.adp.lib.util.l.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(r, i);
            Eg.show();
        }
    }

    public static void showToast(Context context, String str) {
        d(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
