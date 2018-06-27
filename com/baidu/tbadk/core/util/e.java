package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Ds;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Ds != null) {
                e.Ds.cancel();
            }
        }
    };
    private boolean aoL;

    public static e ym() {
        return new e();
    }

    private e() {
    }

    public void i(String str, int i, int i2) {
        if (!this.aoL && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Ds != null && Ds.getView() != null) {
                    try {
                        Ds.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Ds = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        Ds.setGravity(17, 0, i2);
                    }
                } else {
                    Ds = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    Ds.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Ds.show();
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
        this.aoL = true;
        cancel();
    }

    public void onResume() {
        this.aoL = false;
    }

    public static void cancel() {
        if (Ds != null) {
            mHandler.removeCallbacks(r);
            Ds.cancel();
            Ds = null;
        }
    }
}
