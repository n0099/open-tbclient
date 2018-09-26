package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast FI;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.FI != null) {
                e.FI.cancel();
            }
        }
    };
    private boolean aqU;

    public static e zk() {
        return new e();
    }

    private e() {
    }

    public void k(String str, int i, int i2) {
        if (!this.aqU && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (FI != null && FI.getView() != null) {
                    try {
                        FI.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        FI = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        FI.setGravity(17, 0, i2);
                    }
                } else {
                    FI = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    FI.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                FI.show();
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
        k(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void l(int i, int i2, int i3) {
        k(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.aqU = true;
        cancel();
    }

    public void onResume() {
        this.aqU = false;
    }

    public static void cancel() {
        if (FI != null) {
            mHandler.removeCallbacks(r);
            FI.cancel();
            FI = null;
        }
    }
}
