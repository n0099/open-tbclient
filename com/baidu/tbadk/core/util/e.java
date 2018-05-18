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
            if (e.xj != null) {
                e.xj.cancel();
            }
        }
    };
    private static Toast xj;
    private boolean agg;

    public static e uA() {
        return new e();
    }

    private e() {
    }

    public void i(String str, int i, int i2) {
        if (!this.agg && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (xj != null && xj.getView() != null) {
                    try {
                        xj.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        xj = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        xj.setGravity(17, 0, i2);
                    }
                } else {
                    xj = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    xj.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                xj.show();
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
        i(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void j(int i, int i2, int i3) {
        i(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.agg = true;
        cancel();
    }

    public void onResume() {
        this.agg = false;
    }

    public static void cancel() {
        if (xj != null) {
            mHandler.removeCallbacks(r);
            xj.cancel();
            xj = null;
        }
    }
}
