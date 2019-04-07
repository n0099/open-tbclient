package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast Gu;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.Gu != null) {
                e.Gu.cancel();
            }
        }
    };
    private boolean bIy;

    public static e abX() {
        return new e();
    }

    private e() {
    }

    public void l(String str, int i, int i2) {
        if (!this.bIy && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(r);
                if (Gu != null && Gu.getView() != null) {
                    try {
                        Gu.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        Gu = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        Gu.setGravity(17, 0, i2);
                    }
                } else {
                    Gu = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    Gu.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(r, i);
                Gu.show();
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
        this.bIy = true;
        cancel();
    }

    public void onResume() {
        this.bIy = false;
    }

    public static void cancel() {
        if (Gu != null) {
            mHandler.removeCallbacks(r);
            Gu.cancel();
            Gu = null;
        }
    }
}
