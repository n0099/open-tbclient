package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Dq;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Dq != null) {
                e.Dq.cancel();
            }
        }
    };
    private boolean aom;

    public static e xZ() {
        return new e();
    }

    private e() {
    }

    public void i(String str, int i, int i2) {
        if (!this.aom && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Dq != null && Dq.getView() != null) {
                    try {
                        Dq.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Dq = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        Dq.setGravity(17, 0, i2);
                    }
                } else {
                    Dq = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    Dq.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Dq.show();
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
        this.aom = true;
        cancel();
    }

    public void onResume() {
        this.aom = false;
    }

    public static void cancel() {
        if (Dq != null) {
            mHandler.removeCallbacks(r);
            Dq.cancel();
            Dq = null;
        }
    }
}
