package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Eg;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Eg != null) {
                e.Eg.cancel();
            }
        }
    };
    private boolean bQj;

    public static e agU() {
        return new e();
    }

    private e() {
    }

    public void l(String str, int i, int i2) {
        if (!this.bQj && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Eg != null && Eg.getView() != null) {
                    try {
                        Eg.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Eg = Toast.makeText(BdBaseApplication.getInst().getApp(), (CharSequence) null, 0);
                        Eg.setText(trim);
                        Eg.setGravity(17, 0, i2);
                    }
                } else {
                    Eg = Toast.makeText(BdBaseApplication.getInst().getApp(), (CharSequence) null, 0);
                    Eg.setText(trim);
                    Eg.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Eg.show();
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
        l(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void n(int i, int i2, int i3) {
        l(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.bQj = true;
        cancel();
    }

    public void onResume() {
        this.bQj = false;
    }

    public static void cancel() {
        if (Eg != null) {
            mHandler.removeCallbacks(r);
            Eg.cancel();
            Eg = null;
        }
    }
}
