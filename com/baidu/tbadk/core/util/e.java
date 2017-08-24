package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast AG;
    private boolean afW;
    private static Handler mHandler = new Handler();
    private static Runnable afV = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.AG != null) {
                e.AG.cancel();
            }
        }
    };

    public static e uH() {
        return new e();
    }

    private e() {
    }

    public void c(String str, int i, int i2) {
        if (!this.afW && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(afV);
                if (AG != null && AG.getView() != null) {
                    try {
                        AG.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        AG = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        AG.setGravity(17, 0, i2);
                    }
                } else {
                    AG = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    AG.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(afV, i);
                AG.show();
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
        this.afW = true;
        cancel();
    }

    public void onResume() {
        this.afW = false;
    }

    public static void cancel() {
        if (AG != null) {
            mHandler.removeCallbacks(afV);
            AG.cancel();
            AG = null;
        }
    }
}
