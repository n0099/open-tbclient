package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast amL;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.amL != null) {
                e.amL.cancel();
            }
        }
    };
    private boolean aTp;

    public static e BF() {
        return new e();
    }

    private e() {
    }

    public void h(String str, int i, int i2) {
        if (!this.aTp && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (amL != null && amL.getView() != null) {
                    try {
                        amL.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        amL = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        amL.setGravity(17, 0, i2);
                    }
                } else {
                    amL = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    amL.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                amL.show();
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
        h(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void u(int i, int i2, int i3) {
        h(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.aTp = true;
        cancel();
    }

    public void onResume() {
        this.aTp = false;
    }

    public static void cancel() {
        if (amL != null) {
            mHandler.removeCallbacks(r);
            amL.cancel();
            amL = null;
        }
    }
}
