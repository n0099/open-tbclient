package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast mToast;
    private boolean dontShowToast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.mToast != null) {
                e.mToast.cancel();
            }
        }
    };

    public static e bnP() {
        return new e();
    }

    private e() {
    }

    public void showToast(String str, int i, int i2) {
        if (!this.dontShowToast && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (mToast != null && mToast.getView() != null) {
                    try {
                        mToast.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        mToast = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        mToast.setText(trim);
                        mToast.setGravity(17, 0, i2);
                    }
                } else {
                    mToast = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    mToast.setText(trim);
                    mToast.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                mToast.show();
            }
        }
    }

    public void showToast(int i) {
        showToast(i, 2000);
    }

    public void showToast(String str, int i) {
        showToast(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void showToast(int i, int i2, int i3) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.dontShowToast = true;
        cancel();
    }

    public void onResume() {
        this.dontShowToast = false;
    }

    public static void cancel() {
        if (mToast != null) {
            mHandler.removeCallbacks(r);
            mToast.cancel();
            mToast = null;
        }
    }
}
