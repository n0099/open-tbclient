package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class e {
    private static Toast zy;
    private boolean adW;
    private static Handler mHandler = new Handler();
    private static Runnable adV = new f();

    public static e uu() {
        return new e();
    }

    private e() {
    }

    public void b(String str, int i, int i2) {
        if (!this.adW && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(adV);
                if (zy != null) {
                    zy.setText(trim);
                } else {
                    zy = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    zy.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(adV, i);
                zy.show();
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
        this.adW = true;
        cancel();
    }

    public void onResume() {
        this.adW = false;
    }

    public static void cancel() {
        if (zy != null) {
            mHandler.removeCallbacks(adV);
            zy.cancel();
            zy = null;
        }
    }
}
