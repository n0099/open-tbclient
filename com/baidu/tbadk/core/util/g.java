package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast yE;
    private boolean TT;
    private static Handler mHandler = new Handler();
    private static Runnable TS = new h();

    public static g sq() {
        return new g();
    }

    private g() {
    }

    public void c(String str, int i, int i2) {
        if (!this.TT && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(TS);
                if (yE != null) {
                    yE.setText(trim);
                } else {
                    yE = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yE.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(TS, i);
                yE.show();
            }
        }
    }

    public void showToast(String str, int i) {
        c(str, i, com.baidu.adp.lib.util.n.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void p(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.TT = true;
        cancel();
    }

    public void onResume() {
        this.TT = false;
    }

    public static void cancel() {
        if (yE != null) {
            mHandler.removeCallbacks(TS);
            yE.cancel();
            yE = null;
        }
    }
}
