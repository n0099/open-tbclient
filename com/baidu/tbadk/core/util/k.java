package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class k {
    private static Toast nt;
    private boolean HF;
    private static Handler mHandler = new Handler();
    private static Runnable HE = new l();

    public static k ok() {
        return new k();
    }

    private k() {
    }

    public void c(String str, int i, int i2) {
        if (!this.HF && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(HE);
                if (nt != null) {
                    nt.setText(trim);
                } else {
                    nt = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    nt.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(HE, i);
                nt.show();
            }
        }
    }

    public void showToast(String str, int i) {
        c(str, i, com.baidu.adp.lib.util.l.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void p(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.HF = true;
        cancel();
    }

    public void onResume() {
        this.HF = false;
    }

    public static void cancel() {
        if (nt != null) {
            mHandler.removeCallbacks(HE);
            nt.cancel();
            nt = null;
        }
    }
}
