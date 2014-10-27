package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class k {
    private static Toast nr;
    private boolean Dl;
    private static Handler mHandler = new Handler();
    private static Runnable Dk = new l();

    public static k lt() {
        return new k();
    }

    private k() {
    }

    public void b(String str, int i, int i2) {
        if (!this.Dl && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(Dk);
                if (nr != null) {
                    nr.setText(trim);
                } else {
                    nr = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    nr.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(Dk, i);
                nr.show();
            }
        }
    }

    public void showToast(String str, int i) {
        b(str, i, com.baidu.adp.lib.util.m.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void k(int i, int i2, int i3) {
        b(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.Dl = true;
        cancel();
    }

    public void onResume() {
        this.Dl = false;
    }

    public static void cancel() {
        if (nr != null) {
            mHandler.removeCallbacks(Dk);
            nr.cancel();
            nr = null;
        }
    }
}
