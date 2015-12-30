package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast yL;
    private boolean aau;
    private static Handler mHandler = new Handler();
    private static Runnable aat = new h();

    public static g tP() {
        return new g();
    }

    private g() {
    }

    public void c(String str, int i, int i2) {
        if (!this.aau && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(aat);
                if (yL != null) {
                    yL.setText(trim);
                } else {
                    yL = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yL.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(aat, i);
                yL.show();
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

    public void o(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.aau = true;
        cancel();
    }

    public void onResume() {
        this.aau = false;
    }

    public static void cancel() {
        if (yL != null) {
            mHandler.removeCallbacks(aat);
            yL.cancel();
            yL = null;
        }
    }
}
