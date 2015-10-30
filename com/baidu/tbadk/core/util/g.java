package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast yD;
    private boolean Za;
    private static Handler mHandler = new Handler();
    private static Runnable YZ = new h();

    public static g tx() {
        return new g();
    }

    private g() {
    }

    public void c(String str, int i, int i2) {
        if (!this.Za && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(YZ);
                if (yD != null) {
                    yD.setText(trim);
                } else {
                    yD = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yD.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(YZ, i);
                yD.show();
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
        this.Za = true;
        cancel();
    }

    public void onResume() {
        this.Za = false;
    }

    public static void cancel() {
        if (yD != null) {
            mHandler.removeCallbacks(YZ);
            yD.cancel();
            yD = null;
        }
    }
}
