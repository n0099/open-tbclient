package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Gv;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Gv != null) {
                e.Gv.cancel();
            }
        }
    };
    private boolean awy;

    public static e Bz() {
        return new e();
    }

    private e() {
    }

    public void k(String str, int i, int i2) {
        if (!this.awy && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Gv != null && Gv.getView() != null) {
                    try {
                        Gv.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Gv = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        Gv.setGravity(17, 0, i2);
                    }
                } else {
                    Gv = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    Gv.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Gv.show();
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
        this.awy = true;
        cancel();
    }

    public void onResume() {
        this.awy = false;
    }

    public static void cancel() {
        if (Gv != null) {
            mHandler.removeCallbacks(r);
            Gv.cancel();
            Gv = null;
        }
    }
}
