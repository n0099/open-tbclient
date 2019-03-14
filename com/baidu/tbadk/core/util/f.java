package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast Gu;
    private static Handler mHandler = new Handler();
    private static String alJ = null;
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.Gu.cancel();
        }
    };

    public static void e(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(r);
            if (Gu != null) {
                if (!str.equals(alJ)) {
                    alJ = str;
                    Gu.setText(str);
                }
            } else {
                alJ = str;
                Gu = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
                Gu.setGravity(17, 0, com.baidu.adp.lib.util.l.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(r, i);
            Gu.show();
        }
    }

    public static void showToast(Context context, String str) {
        e(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
