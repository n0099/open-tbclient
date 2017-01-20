package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class e {
    private static Toast sd;
    private boolean YH;
    private static Handler mHandler = new Handler();
    private static Runnable YG = new f();

    public static e tW() {
        return new e();
    }

    private e() {
    }

    public void b(String str, int i, int i2) {
        if (!this.YH && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(YG);
                if (sd != null) {
                    sd.setText(trim);
                } else {
                    sd = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    sd.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(YG, i);
                sd.show();
            }
        }
    }

    public void showToast(int i) {
        showToast(i, 2000);
    }

    public void showToast(String str, int i) {
        b(str, i, com.baidu.adp.lib.util.k.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void m(int i, int i2, int i3) {
        b(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.YH = true;
        cancel();
    }

    public void onResume() {
        this.YH = false;
    }

    public static void cancel() {
        if (sd != null) {
            mHandler.removeCallbacks(YG);
            sd.cancel();
            sd = null;
        }
    }
}
