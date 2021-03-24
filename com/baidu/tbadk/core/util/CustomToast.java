package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class CustomToast {
    public static final int TOAST_DURATION = 2000;
    public static Toast mToast;
    public boolean dontShowToast;
    public static Handler mHandler = new Handler();
    public static Runnable r = new Runnable() { // from class: com.baidu.tbadk.core.util.CustomToast.1
        @Override // java.lang.Runnable
        public void run() {
            if (CustomToast.mToast != null) {
                CustomToast.mToast.cancel();
            }
        }
    };

    public static void cancel() {
        if (mToast != null) {
            mHandler.removeCallbacks(r);
            mToast.cancel();
            mToast = null;
        }
    }

    public static CustomToast newInstance() {
        return new CustomToast();
    }

    public void onPause() {
        this.dontShowToast = true;
        cancel();
    }

    public void onResume() {
        this.dontShowToast = false;
    }

    public void showToast(String str, int i, int i2) {
        if (this.dontShowToast || str == null) {
            return;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return;
        }
        mHandler.removeCallbacks(r);
        Toast toast = mToast;
        if (toast != null && toast.getView() != null) {
            try {
                mToast.setText(trim);
            } catch (RuntimeException e2) {
                BdLog.e(e2);
                Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                mToast = makeText;
                makeText.setText(trim);
                mToast.setGravity(17, 0, i2);
            }
        } else {
            Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
            mToast = makeText2;
            makeText2.setText(trim);
            mToast.setGravity(17, 0, i2);
        }
        mHandler.postDelayed(r, i);
        mToast.show();
    }

    public void showToast(String str) {
        showToast(str, 2000);
    }

    public void showToast(int i) {
        showToast(i, 2000);
    }

    public void showToast(String str, int i) {
        showToast(str, i, l.e(BdBaseApplication.getInst().getApp(), 100.0f));
    }

    public void showToast(int i, int i2) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
    }

    public void showToast(int i, int i2, int i3) {
        showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
    }
}
