package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static Toast AE;
    private boolean afU;
    private static Handler mHandler = new Handler();
    private static Runnable afT = new Runnable() { // from class: com.baidu.tbadk.core.util.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.AE != null) {
                e.AE.cancel();
            }
        }
    };

    public static e uG() {
        return new e();
    }

    private e() {
    }

    public void b(String str, int i, int i2) {
        if (!this.afU && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(afT);
                if (AE != null && AE.getView() != null) {
                    try {
                        AE.setText(trim);
                    } catch (RuntimeException e) {
                        BdLog.e(e);
                        AE = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                        AE.setGravity(17, 0, i2);
                    }
                } else {
                    AE = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    AE.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(afT, i);
                AE.show();
            }
        }
    }

    public void showToast(int i) {
        showToast(i, 2000);
    }

    public void showToast(String str, int i) {
        b(str, i, com.baidu.adp.lib.util.k.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void m(int i, int i2, int i3) {
        b(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.afU = true;
        cancel();
    }

    public void onResume() {
        this.afU = false;
    }

    public static void cancel() {
        if (AE != null) {
            mHandler.removeCallbacks(afT);
            AE.cancel();
            AE = null;
        }
    }
}
