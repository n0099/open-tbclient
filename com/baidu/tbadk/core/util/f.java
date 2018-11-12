package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast Gv;
    private static Handler mHandler = new Handler();
    private static String mText = null;
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.Gv.cancel();
        }
    };

    public static void e(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(r);
            if (Gv != null) {
                if (!str.equals(mText)) {
                    mText = str;
                    Gv.setText(str);
                }
            } else {
                mText = str;
                Gv = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
                Gv.setGravity(17, 0, com.baidu.adp.lib.util.l.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(r, i);
            Gv.show();
        }
    }

    public static void showToast(Context context, String str) {
        e(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
