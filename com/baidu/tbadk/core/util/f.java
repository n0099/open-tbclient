package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class f {
    private static Toast sl;
    private boolean ZZ;
    private static Handler mHandler = new Handler();
    private static Runnable ZY = new g();

    public static f us() {
        return new f();
    }

    private f() {
    }

    public void b(String str, int i, int i2) {
        if (!this.ZZ && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                mHandler.removeCallbacks(ZY);
                if (sl != null) {
                    sl.setText(trim);
                } else {
                    sl = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                    sl.setGravity(17, 0, i2);
                }
                mHandler.postDelayed(ZY, i);
                sl.show();
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

    public void n(int i, int i2, int i3) {
        b(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void onPause() {
        this.ZZ = true;
        cancel();
    }

    public void onResume() {
        this.ZZ = false;
    }

    public static void cancel() {
        if (sl != null) {
            mHandler.removeCallbacks(ZY);
            sl.cancel();
            sl = null;
        }
    }
}
