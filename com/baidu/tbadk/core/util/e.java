package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Gr;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Gr != null) {
                e.Gr.cancel();
            }
        }
    };
    private boolean avL;

    public static e Bs() {
        return new e();
    }

    private e() {
    }

    public void k(String str, int i, int i2) {
        if (!this.avL && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Gr != null && Gr.getView() != null) {
                    try {
                        Gr.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Gr = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        Gr.setGravity(17, 0, i2);
                    }
                } else {
                    Gr = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    Gr.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Gr.show();
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
        this.avL = true;
        cancel();
    }

    public void onResume() {
        this.avL = false;
    }

    public static void cancel() {
        if (Gr != null) {
            mHandler.removeCallbacks(r);
            Gr.cancel();
            Gr = null;
        }
    }
}
