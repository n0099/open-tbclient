package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast pv;
    private boolean VB;
    private static Handler mHandler = new Handler();
    private static Runnable VA = new g();

    public static f sX() {
        return new f();
    }

    private f() {
    }

    public void b(String str, int i, int i2) {
        if (!this.VB && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(VA);
                if (pv != null) {
                    pv.setText(trim);
                } else {
                    pv = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    pv.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(VA, i);
                pv.show();
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
        this.VB = true;
        cancel();
    }

    public void onResume() {
        this.VB = false;
    }

    public static void cancel() {
        if (pv != null) {
            mHandler.removeCallbacks(VA);
            pv.cancel();
            pv = null;
        }
    }
}
