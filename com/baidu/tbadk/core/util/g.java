package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class g {
    private static Toast yQ;
    private boolean Tk;
    private static Handler mHandler = new Handler();
    private static Runnable Tj = new h();

    public static g rH() {
        return new g();
    }

    private g() {
    }

    public void c(String str, int i, int i2) {
        if (!this.Tk && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(Tj);
                if (yQ != null) {
                    yQ.setText(trim);
                } else {
                    yQ = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yQ.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(Tj, i);
                yQ.show();
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
        this.Tk = true;
        cancel();
    }

    public void onResume() {
        this.Tk = false;
    }

    public static void cancel() {
        if (yQ != null) {
            mHandler.removeCallbacks(Tj);
            yQ.cancel();
            yQ = null;
        }
    }
}
