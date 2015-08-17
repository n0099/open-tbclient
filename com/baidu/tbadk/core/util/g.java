package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g {
    private static Toast yE;
    private boolean YV;
    private static Handler mHandler = new Handler();
    private static Runnable YU = new h();

    public static g tx() {
        return new g();
    }

    private g() {
    }

    public void c(String str, int i, int i2) {
        if (!this.YV && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(YU);
                if (yE != null) {
                    yE.setText(trim);
                } else {
                    yE = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    yE.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(YU, i);
                yE.show();
            }
        }
    }

    public void showToast(int i) {
        showToast(i, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public void showToast(String str, int i) {
        c(str, i, com.baidu.adp.lib.util.k.dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void n(int i, int i2, int i3) {
        c(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.YV = true;
        cancel();
    }

    public void onResume() {
        this.YV = false;
    }

    public static void cancel() {
        if (yE != null) {
            mHandler.removeCallbacks(YU);
            yE.cancel();
            yE = null;
        }
    }
}
