package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class e {
    private static Toast zc;
    private boolean ael;
    private static Handler mHandler = new Handler();
    private static Runnable aek = new f();

    public static e uR() {
        return new e();
    }

    private e() {
    }

    public void b(String str, int i, int i2) {
        if (!this.ael && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(aek);
                if (zc != null) {
                    zc.setText(trim);
                } else {
                    zc = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    zc.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(aek, i);
                zc.show();
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
        this.ael = true;
        cancel();
    }

    public void onResume() {
        this.ael = false;
    }

    public static void cancel() {
        if (zc != null) {
            mHandler.removeCallbacks(aek);
            zc.cancel();
            zc = null;
        }
    }
}
