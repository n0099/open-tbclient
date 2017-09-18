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
            if (e.yz != null) {
                e.yz.cancel();
            }
        }
    };
    private static Toast yz;
    private boolean aff;

    public static e uC() {
        return new e();
    }

    private e() {
    }

    public void c(String str, int i, int i2) {
        if (!this.aff && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (yz != null && yz.getView() != null) {
                    try {
                        yz.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        yz = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        yz.setGravity(17, 0, i2);
                    }
                } else {
                    yz = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yz.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                yz.show();
            }
        }
    }

    public void showToast(int i) {
        showToast(i, 2000);
    }

    public void showToast(String str, int i) {
        c(str, i, com.baidu.adp.lib.util.k.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void m(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.aff = true;
        cancel();
    }

    public void onResume() {
        this.aff = false;
    }

    public static void cancel() {
        if (yz != null) {
            mHandler.removeCallbacks(r);
            yz.cancel();
            yz = null;
        }
    }
}
