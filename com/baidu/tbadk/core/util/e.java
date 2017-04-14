package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class e {
    private static Toast yZ;
    private boolean aek;
    private static Handler mHandler = new Handler();
    private static Runnable aej = new f();

    public static e uR() {
        return new e();
    }

    private e() {
    }

    public void b(String str, int i, int i2) {
        if (!this.aek && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(aej);
                if (yZ != null) {
                    yZ.setText(trim);
                } else {
                    yZ = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yZ.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(aej, i);
                yZ.show();
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
        this.aek = true;
        cancel();
    }

    public void onResume() {
        this.aek = false;
    }

    public static void cancel() {
        if (yZ != null) {
            mHandler.removeCallbacks(aej);
            yZ.cancel();
            yZ = null;
        }
    }
}
