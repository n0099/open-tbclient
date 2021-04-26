package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class CustomToast2 {
    public static Toast mToast;
    public static Handler mHandler = new Handler();
    public static String mText = null;
    public static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.CustomToast2.1
        @Override // java.lang.Runnable
        public void run() {
            CustomToast2.mToast.cancel();
        }
    };

    public static void showToast(Context context, String str, int i2) {
        if (str == null || str.length() <= 0) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            if (!str.equals(mText)) {
                mText = str;
                mToast.setText(str);
            }
        } else {
            mText = str;
            mToast = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
            mToast.setGravity(17, 0, l.e(context, 100.0f));
        }
        mHandler.postDelayed(r, i2);
        mToast.show();
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i2) {
        showToast(context, context.getResources().getString(i2));
    }

    public static void showToast(Context context, int i2, int i3) {
        showToast(context, context.getResources().getString(i2), i3);
    }
}
