package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Do;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Do != null) {
                e.Do.cancel();
            }
        }
    };
    private boolean aon;

    public static e ye() {
        return new e();
    }

    private e() {
    }

    public void i(String str, int i, int i2) {
        if (!this.aon && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Do != null && Do.getView() != null) {
                    try {
                        Do.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Do = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        Do.setGravity(17, 0, i2);
                    }
                } else {
                    Do = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    Do.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Do.show();
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
        this.aon = true;
        cancel();
    }

    public void onResume() {
        this.aon = false;
    }

    public static void cancel() {
        if (Do != null) {
            mHandler.removeCallbacks(r);
            Do.cancel();
            Do = null;
        }
    }
}
