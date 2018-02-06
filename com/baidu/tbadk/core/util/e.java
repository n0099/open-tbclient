package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast amN;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.amN != null) {
                e.amN.cancel();
            }
        }
    };
    private boolean aUW;

    public static e BR() {
        return new e();
    }

    private e() {
    }

    public void h(String str, int i, int i2) {
        if (!this.aUW && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (amN != null && amN.getView() != null) {
                    try {
                        amN.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        amN = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        amN.setGravity(17, 0, i2);
                    }
                } else {
                    amN = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    amN.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                amN.show();
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
        this.aUW = true;
        cancel();
    }

    public void onResume() {
        this.aUW = false;
    }

    public static void cancel() {
        if (amN != null) {
            mHandler.removeCallbacks(r);
            amN.cancel();
            amN = null;
        }
    }
}
