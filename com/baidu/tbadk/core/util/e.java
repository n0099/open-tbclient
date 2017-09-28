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
            if (e.yB != null) {
                e.yB.cancel();
            }
        }
    };
    private static Toast yB;
    private boolean aeC;

    public static e uf() {
        return new e();
    }

    private e() {
    }

    public void c(String str, int i, int i2) {
        if (!this.aeC && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (yB != null && yB.getView() != null) {
                    try {
                        yB.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        yB = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        yB.setGravity(17, 0, i2);
                    }
                } else {
                    yB = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yB.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                yB.show();
            }
        }
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

    public void m(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.aeC = true;
        cancel();
    }

    public void onResume() {
        this.aeC = false;
    }

    public static void cancel() {
        if (yB != null) {
            mHandler.removeCallbacks(r);
            yB.cancel();
            yB = null;
        }
    }
}
