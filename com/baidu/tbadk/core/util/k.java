package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class k {
    private static Toast nq;
    private boolean Hz;
    private static Handler mHandler = new Handler();
    private static Runnable Hy = new l();

    public static k oo() {
        return new k();
    }

    private k() {
    }

    public void c(String str, int i, int i2) {
        if (!this.Hz && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(Hy);
                if (nq != null) {
                    nq.setText(trim);
                } else {
                    nq = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    nq.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(Hy, i);
                nq.show();
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
        this.Hz = true;
        cancel();
    }

    public void onResume() {
        this.Hz = false;
    }

    public static void cancel() {
        if (nq != null) {
            mHandler.removeCallbacks(Hy);
            nq.cancel();
            nq = null;
        }
    }
}
