package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.yC != null) {
                e.yC.cancel();
            }
        }
    };
    private static Toast yC;
    private boolean afh;

    public static e ui() {
        return new e();
    }

    private e() {
    }

    public void c(String str, int i, int i2) {
        if (!this.afh && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (yC != null && yC.getView() != null) {
                    try {
                        yC.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        yC = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        yC.setGravity(17, 0, i2);
                    }
                } else {
                    yC = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yC.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                yC.show();
            }
        }
    }

    public void showToast(String str) {
        showToast(str, 2000);
    }

    public void showToast(int i) {
        showToast(i, 2000);
    }

    public void showToast(String str, int i) {
        c(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void l(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.afh = true;
        cancel();
    }

    public void onResume() {
        this.afh = false;
    }

    public static void cancel() {
        if (yC != null) {
            mHandler.removeCallbacks(r);
            yC.cancel();
            yC = null;
        }
    }
}
