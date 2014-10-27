package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class m {
    private static Toast nr;
    private static Handler mHandler = new Handler();
    private static String Dm = null;
    private static Runnable Dk = new n();

    public static void a(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            mHandler.removeCallbacks(Dk);
            if (nr != null) {
                if (!str.equals(Dm)) {
                    Dm = str;
                    nr.setText(str);
                }
            } else {
                Dm = str;
                nr = Toast.makeText(context, str, 0);
                nr.setGravity(17, 0, com.baidu.adp.lib.util.m.dip2px(context, 100.0f));
            }
            mHandler.postDelayed(Dk, i);
            nr.show();
        }
    }

    public static void showToast(Context context, String str) {
        a(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }
}
